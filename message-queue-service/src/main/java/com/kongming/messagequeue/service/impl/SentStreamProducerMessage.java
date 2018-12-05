package com.kongming.messagequeue.service.impl;

import com.kongming.messagequeue.domain.RequestParams;
import com.kongming.messagequeue.service.SentProducerMessage;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service("sentStreamProducerMessage")
public class SentStreamProducerMessage implements SentProducerMessage {
    @Override
    public int sentMessage(RequestParams requestParams) {
        JedisPool pool = new JedisPool();
        try (Jedis jedis = pool.getResource()) { // 用完自动 close
            jedis.get("key");
        }
        return 0;
    }
}
