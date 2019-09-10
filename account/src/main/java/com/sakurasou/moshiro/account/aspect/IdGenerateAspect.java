package com.sakurasou.moshiro.account.aspect;

import com.baomidou.mybatisplus.annotation.TableName;
import com.sakurasou.moshiro.account.remote.CommonRemote;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Calendar;

@Aspect
@Component
@Slf4j
public class IdGenerateAspect {
    private final CommonRemote commonRemote;

    public IdGenerateAspect(CommonRemote commonRemote) {
        this.commonRemote = commonRemote;
    }

    @Pointcut("execution(* com.baomidou.mybatisplus.core.mapper.BaseMapper+.insert(..))")
    public void generateAspect() {

    }

    @Around("generateAspect()")
    public Object generateId(ProceedingJoinPoint jp) {
        Object[] ob = jp.getArgs();
        Object entity = ob[0];
        TableName[] tb = entity.getClass().getAnnotationsByType(TableName.class);
        if (tb.length != 0) {
            String tableName = tb[0].value();
            String sequenceId = commonRemote.findSequenceIdByTableName(tableName).replaceAll("\"", "");
            Calendar calendar = Calendar.getInstance();
            String year = String.valueOf(calendar.getWeekYear());
            Integer sequence = Integer.parseInt(sequenceId.substring(4)) + 1;
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(4);
            nf.setGroupingUsed(false);
            String generateId = year + nf.format(sequence);
            try {
                Method method = entity.getClass().getMethod("setId", String.class);
                method.invoke(entity, generateId);
                Object result = jp.proceed();
                commonRemote.updateSequenceIdByTableName(tableName, generateId);
                return result;
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getClass().getName());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            log.info("sequenceId in aspect = {}", generateId);
        } else {
            log.info("please annotate @TableName");
        }
        return null;
    }
}
