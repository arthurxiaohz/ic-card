package org.hi.framework.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hi.framework.HiConfigHolder;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

public class XmlBeanDefinitionReader extends
		org.springframework.beans.factory.xml.XmlBeanDefinitionReader {

	public XmlBeanDefinitionReader(BeanDefinitionRegistry beanFactory) {
		super(beanFactory);
	}
	public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
		ByteArrayResource _resource = null;
		BufferedReader dis = null;
		try{
			
			 dis = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = dis.readLine()) != null) {
				if(!line.contains("${")){
					sb.append(line).append("\n");
					continue;
				}
//				将spring配置文件中${...}区间内容替换为指定的内容
				List<String> dividList = org.hi.common.util.StringUtils.dividToList(line, "${", "}");
				for (String divid : dividList) 
					sb.append(HiConfigHolder.getProperty(divid) == null ? 
							divid :	HiConfigHolder.getProperty(divid));
			}
			_resource = new ByteArrayResource(sb.toString().getBytes("UTF-8"));
		}
		
		catch (IOException ex) {
			throw new BeanDefinitionStoreException(
					"IOException parsing XML document from " + resource, ex);
		}
		finally{
			if(dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					throw new BeanDefinitionStoreException(
							"IOException parsing XML document from " + resource, e);
				}
		}
		
		return loadBeanDefinitions(new EncodedResource(_resource));
	}
}
