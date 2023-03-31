/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.mongodb;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.Condition;

/**
 * Do SUID operate for Mongodb GridFs File.
 * @author Kingstar
 * @since  2.1
 */
public interface SuidFile {
	
	//GridFS
	public String uploadFile(String filename, InputStream fileStream);
	public String uploadFile(String filename, InputStream fileStream,Map<String, Object> metadataMap);
	
	public List<GridFsFile> selectFiles(GridFsFile gridFsFile, Condition condition);

	public byte[] getFileByName(String fileName);
	public byte[] getFileById(String fileId);
	
//	public OutputStream getOutputStreamByName(String fileName);
//	public OutputStream getOutputStreamById(String fileId);

	public void renameFile(String fileId, String newName);
	public void deleteFile(String fileId);

}
