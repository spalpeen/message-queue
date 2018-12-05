package com.kongming.messagequeue.domain.vo;

import java.io.Serializable;

public class ResultSupport implements Serializable {

    /**
     * logId
     */
    private String logId;
    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
