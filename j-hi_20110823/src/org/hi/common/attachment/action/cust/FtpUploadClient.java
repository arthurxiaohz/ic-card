package org.hi.common.attachment.action.cust;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.hi.framework.web.BusinessException;
import org.hi.i18n.util.I18NUtil;





public class FtpUploadClient{


	 FTPClient ftp;
	
	
	 public FtpUploadClient() {
		 try{
		 ftp = FTPClientManager.getFTPUploadClient();
		 }catch(Exception e){
			 throw new BusinessException(I18NUtil.getString("connect to ftp errro :") + e);
		 }
	 }
	
	
	/**
	 * ���ļ����浽ftp�������ļ���ftp�ĵ�ַ
	 * @param inputStream Ҫ������ļ����ֽ���
	 * @param fileName �ļ���
	 * @param moduleName �������ĸ�Ŀ¼��
	 * @return
	 * @throws IOException
	 */
	
	public String saveInputStreamToFTP(InputStream inputStream, String fileName,String moduleName) throws IOException {
		if(moduleName == null || moduleName.equals(""))
			moduleName = "common";
		    fileName =  this.uploadIS(inputStream,moduleName,fileName);    
		   
		return moduleName+"/"+fileName;
	}
	
	 /**   
	    * upload   
	    * �ϴ��ļ�   
	    * @throws java.lang.Exception   
	    * @return -1 �ļ�������   
	    *          -2 �ļ�����Ϊ��    
	    *          >0 �ɹ��ϴ��������ļ��Ĵ�С   
	    * @param newname �ϴ�������ļ���   
	    * @param filename �ϴ����ļ�   
	    * @param path �ļ����·��
	    */    
	 public String uploadIS(InputStream is ,String path,String filename) throws IOException     
	 {  
		 String newFileName = filename;
		 try{
			  changeToDir(  path);
			  newFileName =  URIUtil.encodeQuery(newFileName);
			  newFileName = formatFTPFileName(newFileName);
			  ftp.storeUniqueFile(newFileName, is);
			  is.close();
		  
		 }catch(IOException e ){
			 FTPClientManager.resetClient(ftp);
			 
			 changeToDir(  path);
			 newFileName =  URIUtil.encodeQuery(newFileName);
			 newFileName = formatFTPFileName(newFileName);
			 ftp.storeUniqueFile(newFileName, is);
			 is.close();
		 }finally{
			 FTPClientManager.closeFtpClient(ftp);
		 }
		 
		 
		 
	     return newFileName;
	 }   
	 
	
	
	
	/**
	 * ���ļ����浽ftp�������ļ���ftp�ĵ�ַ
	 * @param file Ҫ������ļ�
	 * @param fileName �ļ���
	 * @param moduleName �������ĸ�Ŀ¼��
	 * @return
	 * @throws IOException
	 */
	
	public String saveFileToFTP(File file, String fileName,String moduleName) throws IOException {
		if(moduleName == null || moduleName.equals(""))
			moduleName = "common"; 
		    fileName = this.upload(file,moduleName,fileName);    
		return moduleName+"/"+fileName;
	}
	

	 
	
	
	
 
  
  
  /** �ж�FtpĿ¼�Ƿ����,����������򴴽�Ŀ¼  
 * @throws IOException */
  private void changeToDir( String dir) throws IOException
  {
	  String serDir = this.getFtpServerDir(dir); //��������ֹ��Сд����
	 if ( serDir .equals("") )
	 {
		 ftp.makeDirectory(dir);
		 ftp.changeWorkingDirectory(dir);
	 }else {
		 ftp.changeWorkingDirectory(serDir);
	 }
  }
  
  public String getFtpServerDir(String dir) throws IOException
  {
	    FTPFile[]  dirs  = ftp.mlistDir();
	   if ( dirs == null || dir .length() == 0 )
	   {
		   return "";
	   }
	   for (FTPFile ftpDir : dirs ){
		   if (ftpDir.getName().equalsIgnoreCase(dir))
			   return ftpDir.getName();
	   }
	   return "";
  }
    
     
 /**   
    * upload   
    * �ϴ��ļ�   
    * @throws java.lang.Exception   
    * @return -1 �ļ�������   
    *          -2 �ļ�����Ϊ��    
    *          >0 �ɹ��ϴ��������ļ��Ĵ�С   
    * @param newname �ϴ�������ļ���   
    * @param filename �ϴ����ļ�   
    * @param path �ļ����·��
    */    
 public String upload(File file_in ,String path,String fileName) throws IOException     
 {  
	 FileInputStream is = new FileInputStream(file_in);
	 return uploadIS( is , path, fileName);
 }

 /**
 * @param path  Ҫ�ϴ����������б�����ļ���ַ
 * @param fileName  �����ļ��ϴ���·������
 * @return
 */
private String formatFTPFileName(String fileName)
 {
	 String preName = "";
	 String extName = "";
	 String formatedFielName  = fileName;
	 
	 	if (fileName.indexOf(".") < 0 )
		     preName = fileName;
		else
		{
			 preName = fileName.substring(0,fileName.lastIndexOf("."));
			 extName = fileName.substring(fileName.lastIndexOf("."));
		}
	 List fileList = this.getFileList("");
	 int i=1;
	 
	 while (fileList != null && fileList.contains(formatedFielName))
	 {
		 formatedFielName = preName+ "(" + i +")"  + extName;
		 i ++;
	 }
	 
	 return formatedFielName;
 }
 
 /**   
    * upload   
    * @throws java.lang.Exception   
    * @return    
    * @param filename   
    */    
 public String upload(File file)    
 throws Exception     
 {    
    String newname = file.getName();    
    
    return upload(file,"attachment",newname);    
 }    
     

 /**   
  * ȡ��ĳ��Ŀ¼�µ������ļ��б�   
  *   
  */    
 public List getFileList(String path)    
 {    
    List list = new ArrayList();    
    try     
    {    
    FTPFile[] files = ftp.listFiles();
       String filename = "";    
       for(FTPFile ftpFile : files )     
       {      
         list.add(ftpFile.getName());            
       }      
       
    } catch (Exception e)     
    {    
       e.printStackTrace();    
    }    
    return list;    
 }    

 
    
}  
