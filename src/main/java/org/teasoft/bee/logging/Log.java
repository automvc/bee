/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.logging;

/**
 * 日志接口.Log interface.
 * @author Kingstar
 * @since  1.4
 */
public interface Log {
	
    public boolean isTraceEnabled();

    /**
     * 记录一个跟踪级别的消息.Log a message at the TRACE level.
     *
     * @param msg the message string to be logged
     */
    public void trace(String msg);
    
    public boolean isDebugEnabled();

    /**
     * 记录一个调试级别的消息.Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     */
    public void debug(String msg);
    
    public boolean isInfoEnabled();

    /**
     * 记录一个信息级别的消息.Log a  at the INFO level.
     *
     * @param msg the message string to be logged
     */
    public void info(String msg);
    
    public boolean isWarnEnabled();

    /**
     * 记录一个警告级别的消息.Log a message at the  level.
     *
     * @param msg the message string to be logged
     */
    public void warn(String msg);
    
    public boolean isErrorEnabled();

    /**
     * 记录一个错误级别的消息.Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    public void error(String msg);
    
    public void error(String msg, Throwable t);
    
    public boolean isOff();
    
    public Log getLogger();
	public Log getLogger(String name);
	public Log getLogger(Class<?> clazz);
}
