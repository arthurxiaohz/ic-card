package org.hi.common.attachment.action.cust;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.hi.framework.web.BusinessException;
import org.hi.i18n.util.I18NUtil;





public class FtpDownloadClient{


	 FTPClient ftp;
	
	
	 public FtpDownloadClient() {
		 try{
		 ftp = FTPClientManager.getFTPDownloadClient();
		 }catch(Exception e){
			 throw new BusinessException(I18NUtil.getString("connect to ftp errro :") + e);
		 }
	 }
	
	/**
	 * 将文件下载
	 * @param file path in ftp ,for example  abc/abc.text
	 * @return
	 * @throws IOException
	 */
	public InputStream download(String path ) throws IOException
	{
		 ByteArrayInputStream inputFile  = null;
		 try{
			  ByteArrayOutputStream out = new ByteArrayOutputStream();
			  ftp.retrieveFile(path, out);
			  byte[] ba  =  out.toByteArray();
			  out.close();
			   
			  inputFile = new ByteArrayInputStream(ba);
			  
		 }catch(IOException e ){// 发生异常就再尝试一次 不能递归 否则死循环
			  FTPClientManager.resetClient(ftp);
			 
			  ByteArrayOutputStream out = new ByteArrayOutputStream();
			  ftp.retrieveFile(path, out);
			  byte[] ba  =  out.toByteArray();
			  out.close();
			   
			  inputFile = new ByteArrayInputStream(ba);
			  
			return inputFile;
		 }finally{
			 FTPClientManager.closeFtpClient(ftp);
		 }
		 
		return inputFile;
		        
	}
	
	/**
	 * 将文件下载
	 * @param path file path in ftp ,for example  abc/abc.text
	 * @param file 输出的文件
	 * @return
	 * @throws IOException
	 */
	public void download(String path,  File file  ) throws IOException
	{
		try{
			  FileOutputStream out = new FileOutputStream(file);
			  ftp.retrieveFile(path, out);
			  
			  out.close();
			 
		}catch(IOException e ){// 发生异常就再尝试一次 不能递归 否则死循环
			  FTPClientManager.resetClient(ftp);
			 
			  FileOutputStream out = new FileOutputStream(file);
			  ftp.retrieveFile(path, out);
			  out.close();
			  
		 }finally{
			 FTPClientManager.closeFtpClient(ftp);
		 }
	}
	
	 
	 
 
    
}  
