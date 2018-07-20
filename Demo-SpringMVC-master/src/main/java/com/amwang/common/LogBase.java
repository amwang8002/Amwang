package com.amwang.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志基类
 * @author wangyao.m
 *
 */
public class LogBase {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @return the logger
     */
    protected Logger getLogger() {
        return logger;
    }
}
