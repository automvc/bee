/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
 * @author Kingstar
 * @since  1.11
 */
public interface Serializer {

	public byte[] serialize(Object obj);

	public Object unserialize(byte[] bytes);

}
