package org.hi.common.attachment.action.cust;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.web.ServletContext;



/**
 * 用于将文件保存到操作系统或者从操作系统下载
 * @author xiao2
 *
 */

public class OSFileClient{

	
	
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
	 * @param file 要保存的文件
	 * @param fileName 文件名
	 * @param moduleName 保存在指定的目录中
	 * @return
	 * @throws IOException
	 */
	public String saveFile(File file, String fileName,String moduleName) throws IOException {
		return saveFile( file,  fileName, moduleName, null);
	}
	 
 
    
}  
