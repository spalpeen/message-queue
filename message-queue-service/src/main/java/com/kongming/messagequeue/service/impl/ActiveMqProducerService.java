package com.kongming.messagequeue.service.impl;

import com.kongming.messagequeue.domain.RequestParams;
import com.kongming.messagequeue.service.ProducerService;
import org.springframework.stereotype.Service;

@Service("activeMqProducerService")
public class ActiveMqProducerService implements ProducerService {
    @Override
    public int setMessageToQueue(RequestParams requestParams) {
        return 0;
    }
}
