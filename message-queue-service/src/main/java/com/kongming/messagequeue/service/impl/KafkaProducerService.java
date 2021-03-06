package com.kongming.messagequeue.service.impl;

import com.alibaba.fastjson.JSON;
import com.kongming.messagequeue.domain.RequestParams;
import com.kongming.messagequeue.service.ProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("kafkaProducerService")
public class KafkaProducerService implements ProducerService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public int setMessageToQueue(RequestParams requestParams) {
        Map<String, String> sendMap = new HashMap<>();
        sendMap.put(String.valueOf(UUID.randomUUID()), requestParams.getContent());
        kafkaTemplate.send(requestParams.getTopic(), JSON.toJSONString(sendMap));
        return 0;
    }
}
