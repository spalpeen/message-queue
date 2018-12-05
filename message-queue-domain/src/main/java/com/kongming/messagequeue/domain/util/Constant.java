package com.kongming.messagequeue.domain.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constant {
    /**
     * level 等级1为Redis Stream
     */
    public static final int STREAMLEVEL = 1;

    /**
     * level 等级2为kafka
     */
    public static final int KAFKALEVEL = 2;

    /**
     * level 等级3为RbMQ
     */
    public static final int ACTIVEMQLEVEL = 3;

    /**
     * topic config
     */
    public static final List<String> TOPIC = new ArrayList<String>(
            Arrays.asList("test", "queue")
    );

    /**
     * default topic
     */
    public static final String DEFAULT_TOPIC = "default_topic";
}
