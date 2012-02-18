package org.hi.framework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hi.SpringContextHolder;
import org.hi.base.sysapp.message.MessageProviderManager;
import org.hi.common.util.BeanUtil;
import org.hi.framework.context.HiFrameworkConfig;
import org.hi.framework.security.constant.SecurityOrgShowMode;
import org.hi.framework.web.WebContextName;

/**
 * �������ڼ���Hiƽ̨����ʱ������Ϣ�ĳ����ߣ���һ�����������ڷ���ĵõ������ļ���ÿһ�����Ե�ֵ
 * @author ���
 * @since 2007-5-20
 *
 */
public class HiConfigHolder {
	private static final int PAGE_SIZE = 10;
	public static final int PAGE_MAXRECORDS=0;
	private static WebContextName webContextName = null; 
	private static MessageProviderManager providerFactory = null;
	
	private static Properties properties;
	public static Properties getProperties(){
		if(properties != null)
			return properties;
		HiFrameworkConfig config = null;
		try{
			config = (HiFrameworkConfig)SpringContextHolder.getBean("hiConfig");
		}
		catch(Throwable e){}
		if(config != null){
			properties = config.getConfig();
			return properties;
		}
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("hiFrameworkConfig.properties");
		Properties _properties = new Properties();
		try {
			_properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(in != null)
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		properties = _properties;
		return properties;
		
	}
	
	public static String getProperty(String key){
		return getProperties().getProperty(key);
	}
	/**
	 * ���ȡֵʧ�ܣ������¼���
	 * @return
	 */
	public static boolean getFrameworkConfigReload(){
		
		String reload = getProperties().getProperty("hi.config.reload");
		if(reload == null)
			return false;
		
		return Boolean.parseBoolean(reload);
	}
	
	private static void ObjectNull(){
		if(getFrameworkConfigReload())
			properties = null;
	}
	
	/**
	 * ȱʡ�б�ҳ��һҳ�ļ�¼����
	 * @return ����ȱʡ�б�ҳ��һҳ�ļ�¼����
	 */
	public static int getPageSize(){
		String pageSize = getProperties().getProperty("hi.pageinfo.pagesize");
		if(pageSize == null)
			return PAGE_SIZE;
		ObjectNull();
		return Integer.parseInt(pageSize);
	}
	
	/**
	 * ȱʡ�б�ҳ����޼�¼����ֵ,0Ϊ��������
	 * @return �б�ҳ����޼�¼��
	 */
	public static int getMaxRecords(){
		String maxRecords = getProperties().getProperty("hi.pageinfo.maxrecords");
		if(maxRecords == null)
			return PAGE_MAXRECORDS;
		ObjectNull();
		return Integer.parseInt(maxRecords);
	}
	
	/**
	 * �˵������ļ����ڵ�λ��
	 * @return ���ز˵������ļ����ڵ�λ��
	 */
	public static String getMenuConfig(){
		String menuConfig = getProperties().getProperty("hi.menu.menuconfig");
		ObjectNull();
		return menuConfig;
	}
	
	/**
	 * �����ڻ�����ҳ���Ƿ�ÿ�ζ����¼��ز˵������ļ�
	 * @return ��ÿ�ζ����¼��ز˵������ļ����ڻ�����ҳ��ʱ
	 */
	public static boolean getMenuReload(){
		String reload = getProperties().getProperty("hi.menu.reload");
		if(reload == null)
			return true;
		ObjectNull();
		return Boolean.parseBoolean(reload);
	}
	
	/**
	 * ������������Ȩʱ���ڲ��ŵ���ʾ��ʽ
	 * <p>lookupΪ���Ҵ�����ʽ��ʾ,dropdownΪ�����б���ʽ��ʾ.
	 * �������hi.security.page.org.show.mode���ã�ȱʡ��lookup��ʽ��ʾ����
	 * @return ������ʾ��ʽ���ַ���
	 */
	public static String getSecurityOrgShowMode(){
		String mode = getProperties().getProperty("hi.security.page.org.show.mode");
		ObjectNull();
		if(mode == null || mode.trim().equals(""))
			return SecurityOrgShowMode.SECURITY_ORG_SHOW_LOOKUP;
		if(!mode.equals(SecurityOrgShowMode.SECURITY_ORG_SHOW_LOOKUP) && !mode.equals(SecurityOrgShowMode.SECURITY_ORG_SHOW_DROPDOWN))
			return SecurityOrgShowMode.SECURITY_ORG_SHOW_LOOKUP;
		return mode;
	}
	
	/**
	 * ���ر��ֲ��ܵĺ�׺,��action/do...
	 * @return
	 */
	public static String getViewFrameworkSuffix(){
		String actionSuffix = getProperties().getProperty("hi.view.framework.action.suffix");
		ObjectNull();
		if(actionSuffix == null || actionSuffix.trim().equals(""))
			return "action";
		return actionSuffix;
	}
	
	public static String getSecurityFilterCalss(){
		String className = getProperties().getProperty("hi.pageinfo.securityfilterclass");
		ObjectNull();
		if(className == null || className.trim().equals(""))
			return "org.hi.framework.dao.impl.SecurityFilterImpl";
		return className;
		
	}
	
	public static String getTagBuilderClass(String builderKey){
		String className = getProperties().getProperty(builderKey);
		ObjectNull();
		return className;
	}
	
	public static int getCurrnetMiddlePage(){
		String currnetMiddlePage = getProperties().getProperty("hi.pageinfo.currnetmiddlepag");
		ObjectNull();
		if(currnetMiddlePage == null || currnetMiddlePage.trim().equals(""))
			return Integer.parseInt("5");
		return Integer.parseInt(currnetMiddlePage);
	}
	
	/**
	 * �Ƿ񷢲����
	 * @return
	 */
	public static boolean getPublished(){
		String published = getProperties().getProperty("hi.depolyment.published");
		ObjectNull();
		if(published == null || published.trim().equals(""))
			return false;
		return Boolean.parseBoolean(published);
	}
	
	public static String getRootUpload(){
		String upload = getProperties().getProperty("hi.depolyment.rootupload");
		ObjectNull();
		if(upload == null || upload.trim().equals(""))
			return "upload";
		return upload;
	}
	
	public static String getJarFile(){
		String jarFile = getProperties().getProperty("hi.jarfiles");
		ObjectNull();
		if(jarFile == null || jarFile.trim().equals(""))
			return null;
		return jarFile;
	}
	
	public static String getWebContextName(){
		if(webContextName != null)
			return webContextName.getContextName();
		
		String webContextClassName = getProperties().getProperty("hi.view.framework.web.contextName");
		ObjectNull();
		if(webContextClassName == null || webContextClassName.trim().equals(""))
			webContextClassName =  "org.hi.framework.web.ContextName.ContextNameDefault";
		
		webContextName = (WebContextName)BeanUtil.CreateObject(webContextClassName);
		
		return webContextName.getContextName();
	}
	
	public static String getMaxLimit() {
		String maxCode = getProperties().getProperty("hi.pageinfo.maxlimitrecode");
		ObjectNull();
		if(maxCode == null || maxCode.trim().equals(""))
			return "100000";
		return maxCode;
	}
	
	public static MessageProviderManager getMessageProviderFactory() {
		if(providerFactory != null)
			return providerFactory;
		
		String providerFactoryClassName = getProperties().getProperty("hi.message.providerfactory");
		ObjectNull();
		if(providerFactoryClassName == null || providerFactoryClassName.trim().equals(""))
			providerFactoryClassName =  "org.hi.base.sysapp.message.MessageProviderFactory";
		providerFactory = (MessageProviderManager) BeanUtil.CreateObject(providerFactoryClassName);
		return providerFactory;
	}
	
	
	public static boolean getVerifyCode(){
		String verifycode = getProperties().getProperty("hi.security.page.verifycode");
		ObjectNull();
		if(verifycode == null || verifycode.trim().equals(""))
			return false;
		return Boolean.parseBoolean(verifycode);
	}
	
	public static boolean getUrlEncrypt(){
		String urlEncrypt = getProperties().getProperty("hi.security.page.urlencrypt");
		ObjectNull();
		if(urlEncrypt == null || urlEncrypt.trim().equals(""))
			return true;
		return Boolean.parseBoolean(urlEncrypt);
	}
	
	public static String getMVCActionName(){
		String actionName = getProperties().getProperty("hi.mvc.action.name");
		ObjectNull();
		if(actionName == null || actionName.trim().equals(""))
			return "hi.action";
		return actionName;
	}
	
	public static String getI18NLanguage(){
		ObjectNull();
		return getProperties().getProperty("hi.i18n.defaultLanguage");
	}
	
	public static String getViewMode(){
		String modeName = getProperties().getProperty("hi.view.framework.mode");
		ObjectNull();
		if(modeName == null || modeName.trim().equals(""))
			return "classic";
		return modeName;
		
	}
}
