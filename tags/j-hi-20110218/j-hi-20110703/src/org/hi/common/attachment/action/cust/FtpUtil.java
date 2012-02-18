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
	 * 在hiFrameworkConfig.properties配置文件中可设置ip系统
	 */
	private String ftpip= HiConfigHolder.getProperty("hi.upload.ftp.ip");
	/**
	 * 配置ftp的用户名
	 */
	private String ftpUser=HiConfigHolder.getProperty("hi.upload.ftp.userName");
	/**
	 * 配置ftp的密码
	 */
	private String ftpPassword=HiConfigHolder.getProperty("hi.upload.ftp.password");
	/**
	 * 配置root
	 */
	private String ftpRoot=HiConfigHolder.getProperty("hi.upload.ftp.root");
	
	public void connectServer() throws IOException
	{
		this.connectServer(ftpip,ftpUser,ftpPassword,ftpRoot);
	}
	
	/**
	 * 原来在baseAction中为了统一管理附件放到了这里
	 * @param file 需要保存的文件
	 * @param fileName 文件名
	 * @param moduleName 保存的路径
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
	 * @param filePath 要上传到服务器中保存的文件地址
	 * @param fileName 本地文件上传的路径名称
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
	 * 原来在baseAction中为了统一管理附件放到了这里
	 * @param inputStream 字节流
	 * @param fileName 文件名
	 * @param moduleName 保存的路径
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
		
		    try {
		    	
		         //连接ftp服务器    
		         this.connectServer(ftpip, ftpUser, ftpPassword, ftpRoot);    
		         /**  上传文件到 moduleName 文件夹下 如果没有就创建文件夹*/    
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
	 * @param file 要保存的文件
	 * @param fileName 文件名
	 * @param moduleName 保存在指定的目录中
	 * @return
	 * @throws IOException
	 */
	public String saveFile(File file, String fileName,String moduleName) throws IOException {
		return saveFile( file,  fileName, moduleName, null);
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
		    try {
		    	
		         //连接ftp服务器    
		         this.connectServer(ftpip, ftpUser, ftpPassword, ftpRoot);    
		         /**  上传文件到 moduleName 文件夹下 如果没有就创建文件夹*/    
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
	 * 将文件下载
	 * @param path like abc/abc.exe
	 * @return
	 * @throws IOException
	 */
	public File ftpDownload(String path ) throws IOException
	{
		File file= new File(  "tempfile/"+new Date().getTime() +"" );
		 FtpUtil ftp = new FtpUtil();    
		    try {
		    	
		         //连接ftp服务器    
		         ftp.connectServer(ftpip, ftpUser, ftpPassword, ftpRoot);    
		         /** 下载文件到file对象中 */    
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
    * 连接ftp服务器   
    * @throws java.io.IOException   
    * @param path 文件夹，空代表根目录   
    * @param password 密码   
    * @param user   登陆用户   
    * @param server 服务器地址   
    */    
  public void connectServer(String server, String user, String password,  String path)    
  throws IOException     
  {    
     // server：FTP服务器的IP地址；user:登录FTP服务器的用户名    
     // password：登录FTP服务器的用户名的口令；path：FTP服务器上的路径    
     ftpClient = new FtpClient();    
     ftpClient.openServer(server);    
     ftpClient.login(user, password);    
     //path是ftp服务下主目录的子目录    
     if (path.length() != 0)  ftpClient.cd(path);    
     //用2进制上传、下载    
     ftpClient.binary();         
 } 
  
  /** 判断Ftp目录是否存在,如果不存在则创建目录 */
  private void isDirExist( String dir)
  {
   try
   {
    ftpClient.cd(dir);  //想不到什么好办法来判断目录是否存在，只能用异常了(比较笨).
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
 * @param path  要上传到服务器中保存的文件地址
 * @param fileName  本地文件上传的路径名称
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
    *  从ftp下载文件到本地   
    * @throws java.lang.Exception   
    * @return    
    * @param outfile 输出文件 
    * @param filename 服务器上的文件名包括路径  
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
  * 取得某个目录下的所有文件列表   
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
    * 断开与ftp服务器的链接   
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
