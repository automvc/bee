/*
 * Copyright 2013-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teasoft.bee.logging;

/**
 * Log interface.
 * @author Kingstar
 * @since  1.4
 */
public interface Log {
	
    public boolean isTraceEnabled();

    /**
     * Log a message at the TRACE level.
     *
     * @param msg the message string to be logged
     */
    public void trace(String msg);
    
    public boolean isDebugEnabled();

    /**
     * Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     */
    public void debug(String msg);
    public void debug(String msg, Throwable t);
    
    public boolean isInfoEnabled();

    /**
     * Log a  at the INFO level.
     *
     * @param msg the message string to be logged
     */
    public void info(String msg);
    
    public boolean isWarnEnabled();

    /**
     * Log a message at the  level.
     *
     * @param msg the message string to be logged
     */
    public void warn(String msg);
    public void warn(String msg, Throwable t); 
    
    public boolean isErrorEnabled();

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    public void error(String msg);
    
    public void error(String msg, Throwable t);
    
}
