package com.sakurasou.moshiro.account.dto;

import lombok.Getter;

@Getter
public class ResponseBody {
    private final int code;
    private final boolean status;
    private final String message;
    private final Object data;

    private ResponseBody(int code, boolean status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResponseBody success(String message, Object data) {
        return new ResponseBody(200, true, message, data);
    }

    public static ResponseBody error(String message, Object data) {
        return new ResponseBody(404, false, message, data);
    }
}
