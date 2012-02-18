package org.hi.common.attachment.action.cust;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.httpclient.URIException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.hi.framework.HiConfigHolder;

public class FTPClientManager {

	
	/**
	 * ��hiFrameworkConfig.properties�����ļ��п�����ip
	 */
	private final static String ftpip= HiConfigHolder.getProperty("hi.upload.ftp.ip");
	
	private  static int port=21;
	
	/**
	 * ����ftp���û���
	 */
	private final static String ftpUser=HiConfigHolder.getProperty("hi.upload.ftp.userName");
	/**
	 * ����ftp������
	 */
	private final static String ftpPassword=HiConfigHolder.getProperty("hi.upload.ftp.password");
	/**
	 * ����root
	 */
	private final static String ftpRoot=HiConfigHolder.getProperty("hi.upload.ftp.root");
	
	private  static int clientSize=1;
	
	/**
	 * �������ص�ftpclient
	 */
	private static List<FTPClient> ftpDownloads = new ArrayList<FTPClient>();
	
	/**
	 * �����ϴ���ftpclient
	 */
	private static List<FTPClient> ftpUploads = new ArrayList<FTPClient>();
	
	/**
	 * 0��ʾ���� 1 ��ʾ������
	 */
	private static HashMap<FTPClient, Integer> ftpStatus = new HashMap<FTPClient, Integer >();
	
	
	 static{
		 try{
		 clientSize   = new Integer ( HiConfigHolder.getProperty("hi.upload.ftp.clientSize"));
		 }catch(Exception e ){}
		 try{
			 port = new Integer(HiConfigHolder.getProperty("hi.upload.ftp.port"));
		 }catch(Exception e ){}
		 
	 
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
	  private static void connectServer(FTPClient ftp )
	  throws IOException     
	  {   
		  try{
			  int reply; 
		     ftp.connect(ftpip,port);    
		     reply = ftp.getReplyCode();
		
		     if (!FTPReply.isPositiveCompletion(reply))
		     {
		         ftp.disconnect();
		         System.err.println("FTP server refused connection.");
		         System.exit(1);
		     }
		     
		     if (!ftp.login(ftpUser, ftpPassword))
	         {
		    	 ftp.logout();
		    	 throw new IOException("ftp login error");
	         }
		     
		     ftp.setFileType(FTP.BINARY_FILE_TYPE);
		     
		     if ( ftpRoot != null && !ftpRoot.trim().equals(""))
		    	 ftp.changeWorkingDirectory(ftpRoot);
		     
		     
		 
		  }catch (IOException e)
	      {
	          if (ftp.isConnected())
	          {
	              try
	              {
	                  ftp.disconnect();
	              }
	              catch (IOException f)
	              {
	                  
	              }
	          }
	          System.err.println("Could not connect to server.");
	        throw e;
	      }
	 } 
	 
	  
	  
	
	
	public synchronized static FTPClient getFTPDownloadClient() throws IOException {
		 
		FTPClient  ftp = getAvalableDownloadClient();
	 //��ʱftp���ܹ��ڶϿ��������Ҫ��������һ��
		if ( ! ftp.isAvailable() ){
			try{
				disconnect(ftp);
			}catch(Exception e ){}
			
			connectServer(ftp);
			
		}else{
			ftp.changeToParentDirectory();
			
			if ( ftpRoot != null && !ftpRoot.trim().equals(""))
			ftp.changeWorkingDirectory(ftpRoot);
		}
		return ftp;
	}
	
	
	
	
	private static FTPClient getAvalableDownloadClient() {
		for(FTPClient client :ftpDownloads){
			if( isFree(client) )
			{
				setBusy(client);
				return client;
			}
				
		}
		// û�п���client�ʹ���һ���� Ȼ��Ž����ӳ�
		FTPClient tranClient =  getTranFtpClient();
		if ( ftpDownloads.size() < clientSize ){
			ftpDownloads.add(tranClient);
			setBusy(tranClient);
		}
		return tranClient;
			
	}
	
	
	private static FTPClient getAvalableUploadClient() {
		for(FTPClient client :ftpUploads){
			if( isFree(client) )
			{
				setBusy(client);
				return client;
			}
				
		}
		// û�п���client�ʹ���һ���� Ȼ��Ž����ӳ�
		FTPClient tranClient =  getTranFtpClient();
		if ( ftpUploads.size() < clientSize ){
			setBusy(tranClient);
			ftpUploads.add(tranClient);
		}
		return tranClient;
			
	}
	
	

	
	private static FTPClient getTranFtpClient() {
		FTPClient  ftp =  new FTPClient();
	 
		try {
			connectServer(ftp);
		} catch (IOException e) {
			 LogFactory.getLog("/").error("connect to ftp error : " + ftp );
		}
	 
		return ftp;
		 
	}





	private static void setFree(FTPClient client)
	{
		ftpStatus.put( client, 0);
	}
	
	
	private static void setBusy(FTPClient client)
	{
		ftpStatus.put( client, 1);
	}
	
	
	/**
	 * �ж������Ƿ����
	 * @param client
	 * @return
	 */
	private static boolean isFree(FTPClient client){
	  return 	ftpStatus.get(client) != null && ftpStatus.get(client).equals( new Integer(0) );
	}

	/**
	 * �ж������Ƿ����
	 * @param client
	 * @return
	 */
	private static boolean isBusy(FTPClient client){
		  return 	ftpStatus.get(client) != null && ftpStatus.get(client).equals( new Integer(1) );
	}
	
	/**
	 * �ж���������Ƿ�����ʱ���ӣ������ӳ���ʱ��ʹ����ʱ����
	 * @param client
	 * @return
	 */
	private static boolean isTranClient(FTPClient client){
		  return 	ftpDownloads.indexOf(client) < 0  && ftpUploads.indexOf(client) < 0  ;
		  
	}


	public synchronized static FTPClient getFTPUploadClient() throws IOException {
		 
		 FTPClient  ftp = getAvalableUploadClient();
		 //��ʱftp���ܹ��ڶϿ��������Ҫ��������һ��
			if ( ! ftp.isAvailable() ){
				try{
					disconnect(ftp);
				}catch(Exception e ){}
				
				connectServer(ftp);
				
			}else{
				ftp.changeToParentDirectory();
				
				if ( ftpRoot != null && !ftpRoot.trim().equals(""))
				ftp.changeWorkingDirectory(ftpRoot);
			}
			return ftp;
			
		 
	}
	
	
	
    
	 /**   
	    * closeServer   
	    * �Ͽ���ftp������������   
	    * @throws java.io.IOException   
	    */    
	 private  static void disconnect( FTPClient ftp )    throws IOException     
	 {       
		 try{
		     ftp.noop(); // check that control connection is working OK
		
		     ftp.logout();
		 }
		 catch (Exception e)
		 {
		     throw new IOException("ftp server has a Exception :" + e );
		      
		 }
		 finally
		 {
		     if (ftp.isConnected())
		     {
		         try
		         {
		             ftp.disconnect();
		         }
		         catch (IOException f)
		         {
		        	  throw new IOException("ftp server has a Exception :" + f );
		         }
		     }
		 }
	 }
	 
	 public static void closeFtpClient(FTPClient ftpClient) throws IOException{
		 if( isTranClient(ftpClient) ){
			 disconnect(ftpClient);
		 }else
		 {
			 setFree(ftpClient);
		 }
		 
		 
	 }
	 
	 public static void main (String[] args ) throws URIException
	 {
		
	 
		 
	 }





	public static void resetClient(FTPClient ftp) throws IOException {
		try{
			disconnect(ftp);
		}catch(Exception e ){}
		
		connectServer(ftp);
		
	}
	
}
