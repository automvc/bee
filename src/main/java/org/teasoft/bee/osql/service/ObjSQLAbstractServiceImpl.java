/*
 * Copyright 2013-2018 the original author.All rights reserved.
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

package org.teasoft.bee.osql.service;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Suid;

/**
 * 默认抽象通用面向对象SQL服务实现类.Default common abstract object SQLService implement class.
 * @author Kingstar
 * @since  1.0
 */
public abstract class ObjSQLAbstractServiceImpl implements ObjSQLService {

	public abstract Suid getSuid();
	
	@Override
	public <T> int insert(T entity){
		//Add the business logic if need.
		return getSuid().insert(entity);
	}

	@Override
	public <T> List<T> select(T entity) {
		//Add the business logic if need.
		return getSuid().select(entity);
	}

	@Override
	public <T> int delete(T entity){
		//Add the business logic if need.
		return getSuid().delete(entity);
	}

	@Override
	public <T> int update(T entity){
		//Add the business logic if need.
		return getSuid().update(entity);
	}
	
	@Override
	public <T> List<T> select(T entity, Condition condition) {
		//Add the business logic if need.
		return getSuid().select(entity, condition);
	}

	@Override
	public <T> int delete(T entity, Condition condition) {
		//Add the business logic if need.
		return getSuid().delete(entity, condition);
	}

	@Override
	public Suid setDynamicParameter(String para, String value) {
		//Add the business logic if need.
		return getSuid().setDynamicParameter(para, value);
	}
	
}
