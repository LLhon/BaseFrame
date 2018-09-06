package com.marvhong.baseframe.core.http.exception;

/**
 * @author LLhon
 * @Project BaseFrame
 * @Package com.marvhong.baseframe.core.http.exception
 * @Date 2018/9/6 12:20
 * @description
 */
public class ServerException extends Exception {

    private int code;

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
