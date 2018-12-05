package com.kongming.messagequeue.service;

import com.kongming.messagequeue.domain.RequestParams;

public interface SentProducerMessage {
    int sentMessage(RequestParams requestParams);
}
