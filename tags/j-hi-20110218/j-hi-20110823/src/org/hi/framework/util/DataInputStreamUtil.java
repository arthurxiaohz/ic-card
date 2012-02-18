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
	 * ͨ��������Դ,��Դ��ȡһ����Ϣ,�����Ϣ�ķ�Χ����ʼ�����ֹ���޶���
	 * <p>�����Դ��û���ҵ�ָ������ʼ�Ὣ���ؿ��ַ���,���û���ָ����Ľ�ֹ����
	 * ������һֱ��ȡ��Դ�����.
	 * <p>һ����˵Դ����Ӧ����һ��properties�ļ�,���ڱ������ṩ����<code>#</code>������Ϊע�ͷ�
	 * �Ĺ���
	 * @param resource ��Դ��������Spring�ṩ��<code>Resource</code>,����������֧���κθ�ʽ��
	 * ���ļ���ʽ,������Բμ�<code>Resource</code>�ӿڵ�������
	 * @param start ���ڽ�ȡԴ����ʼ��ʶ��
	 * @param end ���ڽ�ȡԴ�Ľ�ֹ��ʶ��
	 * @return ����Դ�д���ʼ��ʶ������ֹ��ʶ��֮���ȫ������,�����������ֱ�ʶ������,��һ���ַ�������
	 * @throws IOException ���Դ����Ӧ������������ʱ
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
