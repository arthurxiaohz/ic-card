package org.hi.common.util;

import java.io.*;
import java.util.*;

/**
 * 文件处理工具类
 * @author 张昊
 * @since 2004-11-30
 */
public class FileUtil {

	/**
	 * 拷贝文件
	 * @param in 源文件，包括整个文件实体
	 * @param out 目的文件，该文件对象只有文件路径与文件名
	 * @throws IOException 
	 * @throws IOException 如果发生输入输出错误，如无源文件、路径错误等
	 */
	public static void copyFile(File in, File out) throws IOException {
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		byte[] buf = new byte[1024];
		int i = 0;
		while ((i = fis.read(buf)) != -1) {
			fos.write(buf, 0, i);
		}
		fis.close();
		fos.close();
	}

	/**
	 * 将文件转换为字符串
	 * @param in 源文件，包括整个文件实体
	 * @throws IOException 如果发生输入输出错误，如无源文件、路径错误等
	 */
	public static String fileToStr(File in) throws IOException {
		FileInputStream fis = new FileInputStream(in);
		String outStr = "";
		byte[] buf = new byte[(int)in.length()];
		int i = 0;
		while ((i = fis.read(buf)) != -1) {
			outStr += new String(buf, "utf-8");
		}
		fis.close();
		return outStr;
	}

	/**
	 * 将文件转换为字符串
	 * @param in 源文件的文件名，包括文件的完整路径
	 * @throws IOException 如果发生输入输出错误，如无源文件、路径错误等
	 */
	public static String fileToStr(String in) throws IOException {
		return fileToStr(new File(in));
	}

	/**
	 * 将文件内容存放到集合中
	 * @param fileName 文件名
	 * @return 返回一个集合
	 * @throws IOException 如果读文件出错时
	 * 将文件的每一行做为集合的数据项
	 */
	public static List fileToList(String fileName) throws IOException {
		File file = new File(fileName);
		return fileToList(file);
	}

	/**
	 * 将文件内容存放到集合中
	 * @param file 文件对象
	 * @return 返回一个集合
	 * @throws IOException 如果读文件出错时
	 * 将文件的每一行做为集合的数据项
	 */
	public static List fileToList(File file) throws IOException {
		List list = new ArrayList();
		String read;
        FileReader fileread=new FileReader(file);
        BufferedReader bufread=new BufferedReader(fileread);
        int counter = 0;
        while((read=bufread.readLine())!=null)
        {
          if(read.equals("")) continue;
          	list.add(read);
        }
        return list;

	}
	
	public static Properties getProperties(String propertiesFile){
		 Properties props = new Properties();
		InputStream is = null;
	    try {
	    	is = new FileInputStream(propertiesFile);
	    	getProperties(is);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
       return props;
	}
	
	public static Properties getProperties(InputStream in){
		 Properties props = new Properties();
	    try {
	    	props.load(in);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
      return props;
	}	
	
	public static void createDir(String dir){
		File outputDirFile = new File(dir);
		if(!outputDirFile.exists())
			outputDirFile.mkdirs();
	}
	
	public static boolean exists(String filePath){
		File filePathFile = new File(filePath);
		return filePathFile.exists();
	}
/*	
	public static String replaceFile(String inFile, String resource, String target) throws IOException{
		String fileStr = fileToStr(inFile);
		String result = fileStr.replaceAll("("+resource+")", target);
		return result;
	}
	
	public static String replaceAndAddFile(String inFile, String resource, String target, String addContext) throws IOException{
		String fileStr = replaceFile(inFile, resource, target);
		return fileStr + addContext;
	}
	
	public static void StringToFile(String str, File out) throws IOException{
		FileOutputStream fos = new FileOutputStream(out);
		fos.write(str.getBytes("utf-8"));
		fos.close();
	}
	*/
}