package com.kongming.messagequeue.web.controller;

import com.kongming.messagequeue.domain.RequestParams;

import com.kongming.messagequeue.domain.util.Constant;
import com.kongming.messagequeue.domain.vo.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kongming.messagequeue.service.ProducerService;

import javax.annotation.Resource;


@RestController
@RequestMapping("queue")
public class ProducerController {

    @Resource
    private ProducerService kafkaProducerService;

    @Resource
    private ProducerService streamProducerService;

    @Resource
    private ProducerService activeMqProducerService;

    @RequestMapping("producer")
    public ApiResult Producer(@RequestParam(value = "topic") String topic,
                              @RequestParam(value = "batch") String batch,
                              @RequestParam(value = "level") String level,
                              @RequestParam(value = "lose") boolean lose,
                              @RequestParam(value = "content") String content) {

        try {
            if (content == null) {
                return ApiResult.failResult(-1, "content not be null");
            }

            RequestParams requestParams = new RequestParams();
            if (!Constant.TOPIC.contains(topic)) {
                topic = Constant.DEFAULT_TOPIC;
            }
            if (Integer.valueOf(level) < 0) {
                level = "0";
            }
            requestParams.setTopic(topic);
            requestParams.setBatch(batch);
            requestParams.setLose(lose);
            requestParams.setContent(content);

            int resultCode = -1;

            if (level.equals(Constant.STREAMLEVEL)) {
                resultCode = streamProducerService.setMessageToQueue(requestParams);
            }

            if (level.equals(Constant.KAFKALEVEL)) {
                resultCode = kafkaProducerService.setMessageToQueue(requestParams);
            }

            if (level.equals(Constant.ACTIVEMQLEVEL)) {
                resultCode = activeMqProducerService.setMessageToQueue(requestParams);
            }
            return ApiResult.successResult(resultCode);
        } catch (Exception e) {
            return ApiResult.failResult(-1, "error");
        }
    }
}
