package com.kongming.messagequeue.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kongming.messagequeue.service.ConsumerServicer;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.Set;

public class StreamConsumerService<T> implements ConsumerServicer {


    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    private Jedis jedis = new Jedis();
    private String queueKey;

    // fastjson 序列化对象中存在 generic 类型时，需要使用 TypeReference
    private Type TaskType = new TypeReference<TaskItem<T>>() {
    }.getType();

    @Override
    public void consumeQueueMessage() {
        Thread consumer = new Thread() {
            public void run() {
                loop();
            }
        };
        consumer.start();
        try {
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    private void loop() {
        while (!Thread.interrupted()) {
            // 只取一条
            Set<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500); // 歇会继续
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String s = values.iterator().next();
            if (jedis.zrem(queueKey, s) > 0) { // 抢到了
                TaskItem<T> task = JSON.parseObject(s, TaskType); // fastjson 反序列化
                this.handleMsg(task.msg);
            }
        }
    }

    private void handleMsg(T msg) {
        System.out.println(msg);
    }
}
