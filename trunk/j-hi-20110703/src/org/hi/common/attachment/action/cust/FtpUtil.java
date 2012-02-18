package org.hi.common.attachment.action.cust;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.web.ServletContext;

import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

public class FtpUtil{
	FtpClient ftpClient = null;
	
	/**
	 * ��hiFrameworkConfig.properties�����ļ��п�����ipϵͳ
	 */
	private String ftpip= HiConfigHolder.getProperty("hi.upload.ftp.ip");
	/**
	 * ����ftp���û���
	 */
	private String ftpUser=HiConfigHolder.getProperty("hi.upload.ftp.userName");
	/**
	 * ����ftp������
	 */
	private String ftpPassword=HiConfigHolder.getProperty("hi.upload.ftp.password");
	/**
	 * ����root
	 */
	private String ftpRoot=HiConfigHolder.getProperty("hi.upload.ftp.root");
	
	public void connectServer() throws IOException
	{
		this.connectServer(ftpip,ftpUser,ftpPassword,ftpRoot);
	}
	
	/**
	 * ԭ����baseAction��Ϊ��ͳһ�������ŵ�������
	 * @param file ��Ҫ������ļ�
	 * @param fileName �ļ���
	 * @param moduleName �����·��
	 * @return
	 * @throws IOException
	 */
	public String saveFile(File file, String fileName,String moduleName, String contextPath) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String prefix;
		if(contextPath == null)
			prefix = ServletContext.getServletContext().getRealPath("/");
		else
			prefix = contextPath;
		
		String contextFilePath = HiConfigHolder.getRootUpload() + "/"  
		+ moduleName + "/" + formatter.format(new Date())
		+ "/";
		String filePath = prefix + "/" +  contextFilePath;
		String formatedFileName = formatFileName(filePath,fileName);
		
		File dest = new File(filePath + formatedFileName );
		 
		FileUtils.copyFile(file, dest);
		 
		return contextFilePath + formatedFileName;
	}
	
	/**
	 * @param filePath Ҫ�ϴ����������б�����ļ���ַ
	 * @param fileName �����ļ��ϴ���·������
	 * @return
	 */
	private  String formatFileName(String filePath,String fileName)
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
		int i=1;
		File file  = new File (filePath + fileName );
		while (file .exists() )
		{
			formatedFielName = preName+ "(" + i +")"  + extName;
			i ++;
			file  = new File (filePath + formatedFielName );
			
		}
		
		return formatedFielName;
			
	}
	
	
	/**
	 * ԭ����baseAction��Ϊ��ͳһ�������ŵ�������
	 * @param inputStream �ֽ���
	 * @param fileName �ļ���
	 * @param moduleName �����·��
	 * @return
	 * @throws IOException
	 */
	public String saveInputStream(InputStream inputStream, String fileName,String moduleName, String contextPath) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String prefix;
		if(contextPath == null)
			prefix = ServletContext.getServletContext().getRealPath("/");
		else
			prefix = contextPath;


		String contextFilePath = HiConfigHolder.getRootUpload() + "/" 
		+ moduleName + "/" + formatter.format(new Date())
		+ "/";
		String filePath = prefix + "/" +  contextFilePath;
		String formatedFileName = formatFileName(filePath,fileName);
		
	 
		File dest = new File(filePath + formatedFileName );
		
		File forder = new File (filePath);
		if (!forder.exists())
			forder.mkdirs();
				
		 
		
		FileOutputStream fileoutputstream = new FileOutputStream( dest );
		byte[] ba = (byte[])null;
	    int length =  inputStream.available();		 
	 
        ba = new byte[length];
        inputStream.read(ba);
        
        
	    fileoutputstream.write(ba);
	    fileoutputstream.close();
	    
		return contextFilePath +formatedFileName ;
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
		
		    try {
		    	
		         //����ftp������    
		         this.connectServer(ftpip, ftpUser, ftpPassword, ftpRoot);    
		         /**  �ϴ��ļ��� moduleName �ļ����� ���û�оʹ����ļ���*/    
		         fileName =  this.uploadIS(inputStream,moduleName,fileName);    
		        
		    } catch (IOException e) {    
		       throw e;
		    }finally    
		    {    
		    	this.closeServer();    
		    }    
		 
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
		 String newFileName=filename;
	     TelnetOutputStream os = null;    
	     try {                 
	         isDirExist(  path);
	         newFileName = formatFTPFileName(path,filename);
	         os = ftpClient.put(newFileName);    
	         byte[] bytes = new byte[1024];    
	         int c;    
	         while ((c = is.read(bytes)) != -1) {    
	              os.write(bytes, 0, c);    
	         }    
	     } finally {    
	         if (is != null) {    
	             is.close();    
	         }    
	         if (os != null) {    
	            os.close();    
	         }    
	     }
	     return newFileName;
	 }   
	 
	
	
	
	/**
	 * @param file Ҫ������ļ�
	 * @param fileName �ļ���
	 * @param moduleName ������ָ����Ŀ¼��
	 * @return
	 * @throws IOException
	 */
	public String saveFile(File file, String fileName,String moduleName) throws IOException {
		return saveFile( file,  fileName, moduleName, null);
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
		    try {
		    	
		         //����ftp������    
		         this.connectServer(ftpip, ftpUser, ftpPassword, ftpRoot);    
		         /**  �ϴ��ļ��� moduleName �ļ����� ���û�оʹ����ļ���*/    
		         fileName = this.upload(file,moduleName,fileName);    
		        
		    } catch (IOException e) {    
		       throw e;
		    }finally    
		    {    
		    	this.closeServer();    
		    }    
		 
		return moduleName+"/"+fileName;
	}
	
	/**
	 * ���ļ�����
	 * @param path like abc/abc.exe
	 * @return
	 * @throws IOException
	 */
	public File ftpDownload(String path ) throws IOException
	{
		File file= new File(  "tempfile/"+new Date().getTime() +"" );
		 FtpUtil ftp = new FtpUtil();    
		    try {
		    	
		         //����ftp������    
		         ftp.connectServer(ftpip, ftpUser, ftpPassword, ftpRoot);    
		         /** �����ļ���file������ */    
		         ftp.download( path, file);    
		        
		    } catch (IOException e) {    
		       throw e;
		    }finally    
		    {    
		       ftp.closeServer();    
		    }   
		    
		    return file;
	}
	
	
	
	
 /**   
    * connectServer   
    * ����ftp������   
    * @throws java.io.IOException   
    * @param path �ļ��У��մ����Ŀ¼   
    * @param password ����   
    * @param user   ��½�û�   
    * @param server ��������ַ   
    */    
  public void connectServer(String server, String user, String password,  String path)    
  throws IOException     
  {    
     // server��FTP��������IP��ַ��user:��¼FTP���������û���    
     // password����¼FTP���������û����Ŀ��path��FTP�������ϵ�·��    
     ftpClient = new FtpClient();    
     ftpClient.openServer(server);    
     ftpClient.login(user, password);    
     //path��ftp��������Ŀ¼����Ŀ¼    
     if (path.length() != 0)  ftpClient.cd(path);    
     //��2�����ϴ�������    
     ftpClient.binary();         
 } 
  
  /** �ж�FtpĿ¼�Ƿ����,����������򴴽�Ŀ¼ */
  private void isDirExist( String dir)
  {
   try
   {
    ftpClient.cd(dir);  //�벻��ʲô�ð취���ж�Ŀ¼�Ƿ���ڣ�ֻ�����쳣��(�Ƚϱ�).
   } catch (IOException e1)
   {
	    ftpClient.sendServer("MKD " + dir + "\r\n");
	    try
	    {
	     ftpClient.readServerResponse();
	     ftpClient.cd(dir);
	    } catch (IOException e)
	    {
	     e.printStackTrace();
	    }
   }
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
     String newFileName=fileName;
     TelnetOutputStream os = null;    
     FileInputStream is = null;    
     try {                 
         if (!file_in.exists()) return "";    
         if (file_in.length()==0) return "";    
         isDirExist(  path);
         newFileName = formatFTPFileName(path,fileName);
         os = ftpClient.put(newFileName);    
         is = new FileInputStream(file_in);    
         byte[] bytes = new byte[1024];    
         int c;    
         while ((c = is.read(bytes)) != -1) {    
              os.write(bytes, 0, c);    
         }    
     } finally {    
         if (is != null) {    
             is.close();    
         }    
         if (os != null) {    
            os.close();    
         }    
     }    
    return newFileName;    
 }

 /**
 * @param path  Ҫ�ϴ����������б�����ļ���ַ
 * @param fileName  �����ļ��ϴ���·������
 * @return
 */
private String formatFTPFileName(String path,String fileName)
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
	 List fileList = this.getFileList(path);
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
    String newname = "";    
    
    return upload(file,"",newname);    
 }    
     
 /**   
    *  download   
    *  ��ftp�����ļ�������   
    * @throws java.lang.Exception   
    * @return    
    * @param outfile ����ļ� 
    * @param filename �������ϵ��ļ�������·��  
    */    
 public OutputStream download(String filename,File outfile)     
 throws IOException    
 {      
    long result = 0;    
    TelnetInputStream is = null;  
    ByteArrayOutputStream byteos= null;
  //  FileOutputStream os = null;    
    try     
    {    
       is = ftpClient.get(filename);      
       byteos  =  new ByteArrayOutputStream(); 
      // os = new FileOutputStream(outfile);   
       byte[] bytes = new byte[1024];    
       int c;    
       while ((c = is.read(bytes)) != -1) {    
    	   byteos.write(bytes, 0, c);    
           result = result + c;    
       }    
    } catch (IOException e)     
    {    
       e.printStackTrace();    
    }    
    finally {    
         if (is != null) {    
             is.close();    
         }    
         
     }    
     return byteos;    
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
       DataInputStream dis = new  DataInputStream(ftpClient.nameList(path));    
       String filename = "";    
       while((filename=dis.readLine())!=null)      
       {      
         list.add(filename);            
       }      
       
    } catch (Exception e)     
    {    
       e.printStackTrace();    
    }    
    return list;    
 }    
     
 /**   
    * closeServer   
    * �Ͽ���ftp������������   
    * @throws java.io.IOException   
    */    
 public void closeServer()    
 throws IOException     
 {       
   try     
   {    
      if (ftpClient != null)     
      {    
        ftpClient.closeServer();         
      }    
   } catch (IOException e) {    
      e.printStackTrace();    
   }    
 }    
 
 public static void main (String[] args )
 {
	// System.out.println(formatFileName("c:\\temp\\","eclipseproduct"));
 }
      
    
}  
