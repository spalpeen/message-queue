package com.kongming.messagequeue.service.impl;

import com.kongming.messagequeue.domain.RequestParams;
import com.kongming.messagequeue.service.SentProducerMessage;
import org.springframework.stereotype.Service;

@Service("sentActiveMqProducerMessage")
public class SentActiveMqProducerMessage implements SentProducerMessage {
    @Override
    public int sentMessage(RequestParams requestParams) {
        return 0;
    }
}
