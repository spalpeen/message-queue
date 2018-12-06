package com.kongming.messagequeue.domain;

public class RequestParams {

    /**
     * 主题
     */
    private String topic;

    /**
     * 批次
     */
    private String batch;

    /**
     * 是否允许丢失
     */
    private boolean lose;

    /**
     * 内容
     */
    private String content;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
