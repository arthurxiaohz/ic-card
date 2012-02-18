package org.hi.common.util;

import java.io.*;
import java.util.*;

/**
 * �ļ���������
 * @author ���
 * @since 2004-11-30
 */
public class FileUtil {

	/**
	 * �����ļ�
	 * @param in Դ�ļ������������ļ�ʵ��
	 * @param out Ŀ���ļ������ļ�����ֻ���ļ�·�����ļ���
	 * @throws IOException 
	 * @throws IOException ����������������������Դ�ļ���·�������
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
	 * ���ļ�ת��Ϊ�ַ���
	 * @param in Դ�ļ������������ļ�ʵ��
	 * @throws IOException ����������������������Դ�ļ���·�������
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
	 * ���ļ�ת��Ϊ�ַ���
	 * @param in Դ�ļ����ļ����������ļ�������·��
	 * @throws IOException ����������������������Դ�ļ���·�������
	 */
	public static String fileToStr(String in) throws IOException {
		return fileToStr(new File(in));
	}

	/**
	 * ���ļ����ݴ�ŵ�������
	 * @param fileName �ļ���
	 * @return ����һ������
	 * @throws IOException ������ļ�����ʱ
	 * ���ļ���ÿһ����Ϊ���ϵ�������
	 */
	public static List fileToList(String fileName) throws IOException {
		File file = new File(fileName);
		return fileToList(file);
	}

	/**
	 * ���ļ����ݴ�ŵ�������
	 * @param file �ļ�����
	 * @return ����һ������
	 * @throws IOException ������ļ�����ʱ
	 * ���ļ���ÿһ����Ϊ���ϵ�������
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