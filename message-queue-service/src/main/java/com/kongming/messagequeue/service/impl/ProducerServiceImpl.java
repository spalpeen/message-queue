package com.kongming.messagequeue.service.impl;

import com.alibaba.fastjson.JSON;

import com.kongming.messagequeue.domain.RequestParams;
import com.kongming.messagequeue.domain.util.Constant;
import com.kongming.messagequeue.service.SentProducerMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import com.kongming.messagequeue.service.ProducerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProducerServiceImpl implements ProducerService {


    @Resource
    private SentProducerMessage sentKafkaProducerMessage;

    @Resource
    private SentProducerMessage sentStreamProducerMessage;

    @Resource
    private SentProducerMessage sentActiveMqProducerMessage;

    @Override
    public int setMessageToQueue(RequestParams requestParams) {
        int level = Integer.valueOf(requestParams.getLevel());
        int sendCode = -1;

        if (level == Constant.STREAMLEVEL) {
            sendCode = sentStreamProducerMessage.sentMessage(requestParams);
        }

        if (level == Constant.KAFKALEVEL) {
            sendCode = sentKafkaProducerMessage.sentMessage(requestParams);
        }

        if (level == Constant.ACTIVEMQLEVEL) {
            sendCode = sentActiveMqProducerMessage.sentMessage(requestParams);
        }

        return sendCode;
    }

}
