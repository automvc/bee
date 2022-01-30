/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.interccept;

/**
 * @author Kingstar
 * @since  1.11
 */
public interface InterceptorChain extends Interceptor {

	public void addInterceptor(Interceptor interceptor);

}
