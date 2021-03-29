package org.yann.thread.forkjoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2WithDisruptor {

    public static void main(String[] args) {
        System.out.println(17 & 15);
        System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        Logger logger = LoggerFactory.getLogger(Log4j2WithDisruptor.class);
        logger.debug("hello={}", "Disruptor");
    }

}
