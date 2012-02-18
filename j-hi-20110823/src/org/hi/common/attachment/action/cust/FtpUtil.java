package org.hi.common.attachment.action.cust;






public class FtpUtil{

	/*
	 * 用于从ftp下载文件
	 */
	public static FtpDownloadClient getFtpDownloadClient()
	{
		return new FtpDownloadClient();
	}
	
	
	/**
	 * 用于向ftp上传文件
	 * @return
	 */
	public static FtpUploadClient getFtpUploadClient()
	{
		return new  FtpUploadClient();
	}
	
	/**
	 * 用于向操作系统中上传文件
	 * @return
	 */
	public static OSFileClient getOSFileClient()
	{
		return new OSFileClient();
	}
	
 
    
}  
