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
