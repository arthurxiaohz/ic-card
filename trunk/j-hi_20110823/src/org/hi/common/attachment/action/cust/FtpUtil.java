package org.hi.common.attachment.action.cust;






public class FtpUtil{

	/*
	 * ���ڴ�ftp�����ļ�
	 */
	public static FtpDownloadClient getFtpDownloadClient()
	{
		return new FtpDownloadClient();
	}
	
	
	/**
	 * ������ftp�ϴ��ļ�
	 * @return
	 */
	public static FtpUploadClient getFtpUploadClient()
	{
		return new  FtpUploadClient();
	}
	
	/**
	 * ���������ϵͳ���ϴ��ļ�
	 * @return
	 */
	public static OSFileClient getOSFileClient()
	{
		return new OSFileClient();
	}
	
 
    
}  
