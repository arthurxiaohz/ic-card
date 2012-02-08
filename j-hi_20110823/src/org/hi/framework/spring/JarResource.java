package org.hi.framework.spring;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.common.tools.Matcher;
import org.hi.common.tools.StringMatcher;
import org.springframework.core.io.AbstractResource;
import org.springframework.util.ResourceUtils;


/**
 * ����ʵ��Spring��<code>Resource</code>�ӿ�,��ȡjar�ļ��е�����ļ���Դ.
 * <p>ע��:������ⲻ�ṩ��������,����ͨ��<code>getInstance()</code>������ȡ<code>JarResource</code>��ʵ��,
 * ����������ܼ�һ��jar�ļ��п��ܻ��ж����Դ�ļ�,���Ը÷����᷵��һ��<code>JarResource</code>����.
 * <p>ע��:��jar�ļ��л�ȡָ������Դ�ļ��������ı����ļ�(��Դ),����xml/properties/txt/java��,������ͨ�����±��пɱ༭���ļ�
 * @author ���
 * @since 2009-11-16
 * @see org.springframework.core.io.Resource
 * @see java.util.jar.JarFile
 * @see java.util.jar.JarFile
 *
 */
public class JarResource extends AbstractResource {
	private static Log log = LogFactory.getLog( JarResource.class );
	/**
	 * jar�ļ���<code>File</code>
	 */
	private File file = null;
	/**
	 * ���ļ�(��Դ)����������
	 */
	private String context = null;
	/**
	 * ���ļ���jar�е����·��
	 */
	private String path = null;
	
	private File jarFile = null;
	
	/**
	 * JarResource˽�й�����,�����⿪��
	 * @param jarFile jar�ļ�
	 * @param context ��Դ�ļ�����������
	 * @param path ��Դ�ļ���jar���е����·��
	 */
	private  JarResource(File jarFile, String context, String path){
		this.context = context;
		this.path = path;
		this.jarFile = jarFile;
	}
	
	/**
	 * ͨ������jar/zip�ļ��Ի�ȡ��jar/zip�е�ȫ���ļ���Դ
	 * <p>ע��:jar/zip�ļ��е������ļ���Դ�������ı����ļ�
	 * @param jar jar����zip�ļ�
	 * @return ����jar����zip�ļ��е�ȫ���ļ���Դ
	 * 
	 */
	public static synchronized JarResource[] getInstance(File jar){
		return getInstance(jar, "*");
	}
	
	/**
	 * ͨ������jar/zip�ļ���ģ���ʽ�Ի�ȡ��jar/zip�еķ���ģ���������ļ���Դ
	 * <p>���� getInstance(simpleJar, "*.xml");��simpleJar�ļ���ֻ��ȡ��׺�ļ�Ϊ.xml����Դ�ļ�
	 * @param jar jar jar����zip�ļ�
	 * @param extension ����ģ��
	 * @return ����jar����zip�ļ��еķ���ģ���������ļ���Դ
	 * @see org.hi.common.tools.StringMatcher
	 */
	public static synchronized JarResource[] getInstance(File jar, String extension){
		List<JarResource> resources = new ArrayList<JarResource>();
		JarFile jarFile = null;
		try {

			try {
				jarFile = new JarFile( jar );
			}
			catch (IOException ioe) {
				throw new RuntimeException(
					"Could not read mapping documents from jar: " + jar.getName()
					);
			}
			Matcher matcher = new StringMatcher();
			Enumeration jarEntries = jarFile.entries();
			while ( jarEntries.hasMoreElements() ) {

				ZipEntry ze = (ZipEntry) jarEntries.nextElement();

				if ( matcher.match(extension, ze.getName()) ) { //ƥ����Դ�ļ���
					log.info( "Found mapping document in jar: " + ze.getName() );
					BufferedReader dis = null;
					
					//����Դ�ļ����ļ���Ϊ�ַ���
					try {
						 dis = new BufferedReader(new InputStreamReader(jarFile.getInputStream( ze )));
							StringBuffer sb = new StringBuffer();
							String line;
							while ((line = dis.readLine()) != null) {
								sb.append(line).append("\n");
								continue;
							}
							resources.add(new JarResource(jar, sb.toString(), ze.getName()));
					}
					catch (Exception e) {
						throw new RuntimeException(
								"Could not read mapping documents from jar: " + jar.getName()
							);
					}
				}
			}

		}
		finally {

			try {
				if ( jarFile != null ) {
					jarFile.close();
				}
			}
			catch (IOException ioe) {
				log.error("could not close jar", ioe);
			}
		}
		return resources.toArray(new JarResource[resources.size()]);
	}
	
	public String toString(){
		return "jar:"+this.file.getName() + "  resource file:[" + this.path + "]";
	}
	                   
	/* (non-Javadoc)
	 * @see org.springframework.core.io.Resource#getDescription()
	 */
	@Override
	public String getDescription() {
		return file.getName() + " jar resource file [" + this.path + "]";
	}
	/**
	 * ������Դ�ļ����ļ���
	 */
	public String getFilename(){
		if(!path.contains("/"))
			return path;
		return path.substring(path.lastIndexOf("/") + 1);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.core.io.Resource#getFile()
	 */
	public File getFile() {
		return this.file;
	}
	
	/**
	 * ���ظ���Դ�ļ���jar����zip�ļ��е����·��
	 */
	public String getPath(){
		return this.path;
	}
	
	/** 
	 * ���ظ���Դ��Jar�ļ��е�URL
	 */
	public URL getURL() throws IOException {
		return new URL(ResourceUtils.URL_PROTOCOL_JAR + ":" +jarFile.toURL()+"!/" + this.getPath());
	}
	
	/**
	 * ���ظ���Դ�ļ��ĵ�������,��������Ϊ<code>ByteArrayInputStream</code>
	 * @see org.springframework.core.io.InputStreamSource#getInputStream()
	 */
	public InputStream getInputStream() throws IOException, IllegalStateException {
		return new ByteArrayInputStream(this.context.getBytes("UTF-8"));
	}
	
	
}
