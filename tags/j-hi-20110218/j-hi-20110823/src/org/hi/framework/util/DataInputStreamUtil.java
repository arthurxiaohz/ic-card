package org.hi.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;

public abstract class DataInputStreamUtil {
	private static Log log = LogFactory.getLog( DataInputStreamUtil.class );
	

	/**
	 * 通过给定的源,从源截取一段信息,这段信息的范围由启始符与结止符限定。
	 * <p>如果在源中没有找到指定的启始会将返回空字符串,如果没发现给定的结止符则
	 * 本方法一直截取到源的最后.
	 * <p>一般来说源所对应的是一个properties文件,所在本方法提供了用<code>#</code>井号作为注释符
	 * 的功能
	 * @param resource 该源的类型是Spring提供的<code>Resource</code>,它几乎可以支持任何格式的
	 * 的文件形式,具体可以参见<code>Resource</code>接口的子孙类
	 * @param start 用于截取源的启始标识符
	 * @param end 用于截取源的结止标识符
	 * @return 返回源中从启始标识符到结止标识符之间的全部内容,但不包含两种标识符本身,的一个字符串缓冲
	 * @throws IOException 如果源所对应的流出现问题时
	 * @see org.springframework.core.io.Resource
	 */
	public static StringBuffer getInputStreameSegment(Resource resource,  String start, String end) throws IOException {
		
		BufferedReader dis = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		boolean isStart = false;
		boolean findEndTag = false;
		try{
			while ((line = dis.readLine()) != null) {
				
				if(line.trim().equals(start))
					isStart = true;
				if (line.trim().startsWith("#") || !isStart || line.trim().equals(""))
					continue;
				if (line.trim().equals(end)){
					findEndTag = true;
					break;
				}
				if(!line.trim().equals(start))
					sb.append(line);
					sb.append("\n");
			}
			
			if(!isStart){
				log.debug("not find start tag: " + start + " in URL:" + resource.getURL());
			}
			if(!findEndTag){
				log.debug("not find end tag:  " + end + "  in URL:" + resource.getURL());
			}
		}
		finally{
			dis.close();
		}
		return sb;
	}
}
