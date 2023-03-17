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

import org.teasoft.bee.osql.annotation.Column;

/**
 * @author Kingstar
 * @since  2.1
 */
public class GridFsFile {

	private  String id;
	private  String filename;
	private  Long length;
	@Column("chunkSize")
	private  Integer chunkSize;
	@Column("uploadDate")
	private  Date uploadDate;
	
    // Optional values
    private Map<String,Object> metadata;
    
    public GridFsFile(){}

	public GridFsFile(String id, String filename, long length, int chunkSize, Date uploadDate,final Map<String,Object> metadata) {
		super();
		this.id = id;
		this.filename = filename;
		this.length = length;
		this.chunkSize = chunkSize;
		this.uploadDate = uploadDate;
		this.metadata = metadata != null && metadata.isEmpty() ? null : metadata;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}

	 //不支持。  一般使用这个类查询，就是为了拿文件id
//	public void setId(String id) {
//		this.id = id;
//	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getId() {
		return id;
	}

	public String getFilename() {
		return filename;
	}

	public Long getLength() {
		return length;
	}

	public Integer getChunkSize() {
		return chunkSize;
	}

	public Date getUploadDate() {
		return uploadDate;
	}
	
	  @Override
	    public String toString() {
	          String str=   "GridFSFile{"
	                + "id=" + id;
	               if(filename==null)
	            	   str += ", filename=" + filename ;
	               else 
	            	   str += ", filename='" + filename + '\'';
	                
	               str  += ", length=" + length
	                + ", chunkSize=" + chunkSize
	                + ", uploadDate=" + uploadDate
	                + ", metadata=" + metadata
	                + '}';
	               
	               return str;
	    }

}
