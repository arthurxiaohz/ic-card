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
	 * 将文件保存到ftp并返回文件在ftp的地址
	 * @param inputStream 要保存的文件的字节流
	 * @param fileName 文件名
	 * @param moduleName 保存在哪个目录中
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
	    * 上传文件   
	    * @throws java.lang.Exception   
	    * @return -1 文件不存在   
	    *          -2 文件内容为空    
	    *          >0 成功上传，返回文件的大小   
	    * @param newname 上传后的新文件名   
	    * @param filename 上传的文件   
	    * @param path 文件存放路径
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
	 * 将文件保存到ftp并返回文件在ftp的地址
	 * @param file 要保存的文件
	 * @param fileName 文件名
	 * @param moduleName 保存在哪个目录中
	 * @return
	 * @throws IOException
	 */
	
	public String saveFileToFTP(File file, String fileName,String moduleName) throws IOException {
		if(moduleName == null || moduleName.equals(""))
			moduleName = "common"; 
		    fileName = this.upload(file,moduleName,fileName);    
		return moduleName+"/"+fileName;
	}
	

	 
	
	
	
 
  
  
  /** 判断Ftp目录是否存在,如果不存在则创建目录  
 * @throws IOException */
  private void changeToDir( String dir) throws IOException
  {
	  String serDir = this.getFtpServerDir(dir); //这样做防止大小写问题
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
    * 上传文件   
    * @throws java.lang.Exception   
    * @return -1 文件不存在   
    *          -2 文件内容为空    
    *          >0 成功上传，返回文件的大小   
    * @param newname 上传后的新文件名   
    * @param filename 上传的文件   
    * @param path 文件存放路径
    */    
 public String upload(File file_in ,String path,String fileName) throws IOException     
 {  
	 FileInputStream is = new FileInputStream(file_in);
	 return uploadIS( is , path, fileName);
 }

 /**
 * @param path  要上传到服务器中保存的文件地址
 * @param fileName  本地文件上传的路径名称
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
  * 取得某个目录下的所有文件列表   
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
