package com.kongming.messagequeue.service.impl;

import com.alibaba.fastjson.JSON;
import com.kongming.messagequeue.domain.RequestParams;
import com.kongming.messagequeue.service.ProducerService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("streamProducerService")
public class StreamProducerService implements ProducerService {

    @Override
    public int setMessageToQueue(RequestParams requestParams) {
        JedisPool pool = new JedisPool();
        Map<String, String> sendMap = new HashMap<>();
        sendMap.put(String.valueOf(UUID.randomUUID()), requestParams.getContent());
        try (Jedis jedis = pool.getResource()) { // 用完自动 close
            jedis.rpushx(requestParams.getTopic(), JSON.toJSONString(sendMap));
        }
        return 0;
    }

}
