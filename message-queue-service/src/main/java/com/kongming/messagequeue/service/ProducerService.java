package com.kongming.messagequeue.service;

import com.kongming.messagequeue.domain.RequestParams;

public interface ProducerService {
    int setMessageToQueue(RequestParams requestParams);
}
