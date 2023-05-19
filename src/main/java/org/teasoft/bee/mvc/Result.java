/*
 * Copyright 2020-2023 the original author.All rights reserved.
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

package org.teasoft.bee.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Result struct for transferring the data from back end to front end.
 * @author Kingstar
 * @since  2.1
 */
public class Result {
    
	private int total;
	private List<?> rows;
	private String code;
	private String msg;
	private String errorCode;
	private String errorMsg;

	public Result() {
		rows = new ArrayList<>(1);
	}

	public Result(String errorMsg) {
		this.errorMsg = errorMsg;
		rows = new ArrayList<>(1); // prevent front end null exception; 预防前端页面null异常
	}

	/**
	 * all match records,not a page, is include all pages.
	 * The number of records on the current page can be obtained from rows.length/rows.size(). 
	 * @return the number of all match records.
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * all match records,not a page, is include all pages.
	 * @param total  all match records,
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * get the records in one page. 
	 * @return  the records in one page. 
	 */
	public List<?> getRows() {
		return rows;
	}

	/**
	 * set the rows(records) in one page.
	 * @param rows the records in one page.
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	/**
	 * get code
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * set code
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * get message
	 * @return message
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * set message
	 * @param msg message text
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * get error type code.
	 * @return error type code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * set code of error type.
	 * @param errorCode error type code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * get error type message
	 * @return error type message
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * set error type message
	 * @param errorMsg error type message
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
