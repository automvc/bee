/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.mongodb;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.api.Condition;

/**
 * Do SUID operate for Mongodb GridFs File.
 * @author Kingstar
 * @since  2.1
 */
public interface SuidFile {
	
	//GridFS
	/**
	 * 
	 * @param filename file name for storing file.
	 * @param fileStream inputStream corresponding to the file.
	 * @return string of file id generated by Mongodb.
	 */
	public String uploadFile(String filename, InputStream fileStream);
	
	/**
	 * 
	 * @param filename file name for storing file.
	 * @param fileStream inputStream corresponding to the file.
	 * @param metadataMap  map of metadata.
	 * @return string of file id generated by Mongodb.
	 */
	public String uploadFile(String filename, InputStream fileStream,Map<String, Object> metadataMap);
	
	/**
	 * 
	 * @param gridFsFile parameter of gridFsFile
	 * @param condition  instance of Condition for add query criteria.
	 * @return list of GridFsFile
	 */
	public List<GridFsFile> selectFiles(GridFsFile gridFsFile, Condition condition);

	/**
	 * get byte data of the file.
	 * @param fileName file name for specify file.
	 * @return byte data of the file
	 */
	public byte[] getFileByName(String fileName);
	
	/**
	 * get byte data of the file.
	 * @param fileId  file id for specify file.
	 * @return byte data of the file
	 */
	public byte[] getFileById(String fileId);
	
//	public OutputStream getOutputStreamByName(String fileName);
//	public OutputStream getOutputStreamById(String fileId);

	/**
	 * rename the file
	 * @param fileId  file id for specify file.
	 * @param newName new name.
	 */
	public void renameFile(String fileId, String newName);
	
	/**
	 * delete file
	 * @param fileId file id for specify file.
	 */
	public void deleteFile(String fileId);

}
