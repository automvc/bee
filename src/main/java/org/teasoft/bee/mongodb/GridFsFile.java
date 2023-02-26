/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
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
