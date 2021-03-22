package org.ouyushan.entity;

/**
 * @Description: 消息实体
 * @Author: ouyushan
 * @Email: ouyushan@hotmail.com
 * @Date: 2021/2/26 11:19
 */
public class Message {

    private String message;

    private String code;

    public Message(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
