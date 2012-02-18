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
 * 该类实现Spring的<code>Resource</code>接口,获取jar文件中的相关文件资源.
 * <p>注意:该类对外不提供构建函数,必须通过<code>getInstance()</code>方法获取<code>JarResource</code>的实例,
 * 这理解起来很简单一个jar文件中可能会有多个资源文件,所以该方法会返回一个<code>JarResource</code>数组.
 * <p>注意:在jar文件中获取指定的资源文件必须是文本型文件(资源),例如xml/properties/txt/java等,即可以通过记事本中可编辑的文件
 * @author 张昊
 * @since 2009-11-16
 * @see org.springframework.core.io.Resource
 * @see java.util.jar.JarFile
 * @see java.util.jar.JarFile
 *
 */
public class JarResource extends AbstractResource {
	private static Log log = LogFactory.getLog( JarResource.class );
	/**
	 * jar文件的<code>File</code>
	 */
	private File file = null;
	/**
	 * 该文件(资源)的内容正文
	 */
	private String context = null;
	/**
	 * 该文件在jar中的相对路径
	 */
	private String path = null;
	
	private File jarFile = null;
	
	/**
	 * JarResource私有构建器,不对外开放
	 * @param jarFile jar文件
	 * @param context 资源文件的内容正文
	 * @param path 资源文件在jar包中的相对路径
	 */
	private  JarResource(File jarFile, String context, String path){
		this.context = context;
		this.path = path;
		this.jarFile = jarFile;
	}
	
	/**
	 * 通过给定jar/zip文件以获取该jar/zip中的全部文件资源
	 * <p>注意:jar/zip文件中的所有文件资源必须是文本型文件
	 * @param jar jar包或zip文件
	 * @return 返回jar包或zip文件中的全部文件资源
	 * 
	 */
	public static synchronized JarResource[] getInstance(File jar){
		return getInstance(jar, "*");
	}
	
	/**
	 * 通过给定jar/zip文件及模板格式以获取该jar/zip中的符合模板条件的文件资源
	 * <p>例如 getInstance(simpleJar, "*.xml");从simpleJar文件中只获取后缀文件为.xml的资源文件
	 * @param jar jar jar包或zip文件
	 * @param extension 条件模板
	 * @return 返回jar包或zip文件中的符合模板条件的文件资源
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

				if ( matcher.match(extension, ze.getName()) ) { //匹配资源文件名
					log.info( "Found mapping document in jar: " + ze.getName() );
					BufferedReader dis = null;
					
					//将资源文件正文件变为字符串
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
	 * 返回资源文件的文件名
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
	 * 返回该资源文件在jar包或zip文件中的相对路径
	 */
	public String getPath(){
		return this.path;
	}
	
	/** 
	 * 返回该资源在Jar文件中的URL
	 */
	public URL getURL() throws IOException {
		return new URL(ResourceUtils.URL_PROTOCOL_JAR + ":" +jarFile.toURL()+"!/" + this.getPath());
	}
	
	/**
	 * 返回该资源文件的的输入流,该输入流为<code>ByteArrayInputStream</code>
	 * @see org.springframework.core.io.InputStreamSource#getInputStream()
	 */
	public InputStream getInputStream() throws IOException, IllegalStateException {
		return new ByteArrayInputStream(this.context.getBytes("UTF-8"));
	}
	
	
}
