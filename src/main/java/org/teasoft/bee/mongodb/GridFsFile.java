/*
 * Copyright 2016-2023 the original author.All rights reserved.
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

package org.teasoft.bee.mongodb;

import java.util.Date;
import java.util.Map;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GridFsFile {

	private final String id;
	private final String filename;
	private final long length;
	private final int chunkSize;
	private final Date uploadDate;
	
    // Optional values
    private final Map<String,Object> metadata;

	public GridFsFile(String id, String filename, long length, int chunkSize, Date uploadDate,final Map<String,Object> metadata) {
		super();
		this.id = id;
		this.filename = filename;
		this.length = length;
		this.chunkSize = chunkSize;
		this.uploadDate = uploadDate;
		this.metadata = metadata != null && metadata.isEmpty() ? null : metadata;
	}

	public String getId() {
		return id;
	}

	public String getFilename() {
		return filename;
	}

	public long getLength() {
		return length;
	}

	public int getChunkSize() {
		return chunkSize;
	}

	public Date getUploadDate() {
		return uploadDate;
	}
	
	  @Override
	    public String toString() {
	        return "GridFSFile{"
	                + "id=" + id
	                + ", filename='" + filename + '\''
	                + ", length=" + length
	                + ", chunkSize=" + chunkSize
	                + ", uploadDate=" + uploadDate
	                + ", metadata=" + metadata
	                + '}';
	    }

}
