package org.hi.base.menu.strutsmenu;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hi.SpringContextHolder;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.model.BaseObject;
import org.hi.framework.service.Manager;
import org.hi.framework.service.impl.ManagerImpl;

public abstract class AbstractMenuTreeManager {
	protected static final  String MENAU_CONFIG = "/WEB-INF/config/himenu-config.xml";
	protected String menuConfig = MENAU_CONFIG;
	protected String menuType;
	protected ManagerImpl bMgr = (ManagerImpl)SpringContextHolder.getBean(Manager.class);
	protected static Map menuMap; 
	   
	/**
	 * menu���ݿ�Ļ�����
	 */
	private static Map<String, HiMenuComponent>  cacheMap = Collections.synchronizedMap(new HashMap<String, HiMenuComponent>());
	
	/**
	 * ͨ����������himenu-config.xml�ļ��еĲ˵����ƣ�
	 * @param name �˵�����
	 * @param keys request.parameter��һ������
	 * @param contain action�����ĵ�һ��ʵ��
	 * @return ������װ���MenuComponent�˵���ʵ����ͨ��struts-menu���ö�����Ͳ���tag����ҳ����
	 * @throws Exception �������ռ������XML�ļ�����ʱ
	 */
	public HiMenuComponent getMenu(String name, Map keys ,HttpServletRequest request) throws Exception {
		
		//��ȡ�˵��������ļ�
		if(HiConfigHolder.getMenuConfig() != null)
			menuConfig = HiConfigHolder.getMenuConfig();
		
		//ÿ���Ƿ�����װ�ز˵������ļ�
		boolean reload = HiConfigHolder.getMenuReload();
		if(reload ||  menuMap == null)
			menuMap = (Map) (new XmlUtil().read(getInputStream(request)));
		
		HiMenuComponent menu = null ;
		WebDynamicMenuDefine rootMenudefine = null;
		if (menuMap.get(name) != null) {
			rootMenudefine = (WebDynamicMenuDefine) menuMap.get(name);
			request.setAttribute("javascript", rootMenudefine.getJavascript());
			
			if(rootMenudefine.isCache() && cacheMap.get(rootMenudefine.getMenuName()) != null)
				return (HiMenuComponent)cacheMap.get(rootMenudefine.getMenuName());
			
			menu = new HiMenuComponent(rootMenudefine);
			menu.setTitle(rootMenudefine.getTitle());
			menu.setName(rootMenudefine.getMenuName());
			menu = subMenuAdd(menu, menuMap, name, request,rootMenudefine.getChildvalue(), keys);
		}
		
//		ȥ������û���ӽڵ��֦�ڵ�
		refactorMenu(menu);
		
		if(rootMenudefine.isCache())
			cacheMap.put(rootMenudefine.getMenuName(), menu);
		
		return menu;
	}
	
	/**
	 * ����װ�õ����ͽṹ�����ع�
	 * @param menu
	 */
	protected void refactorMenu(HiMenuComponent menu){
	}
	
	/**
	 * ͨ���ݹ麯��������֯����
	 * @param menu ��MenuComponentʵ��
	 * @param menuMap himenu-config.xmlת��ΪWebDynamicMenuDefine����ļ��ϣ���ֵΪ�˵���ֵΪWebDynamicMenuDefine����
	 * @param menuName ��ǰ�˵��Ĳ˵���
	 * @param contain  action�����ĵ�һ��ʵ��
	 * @param parent ��Ϊ�ӽڵ���Ҹ��ڵ��Ӧ��ֵ
	 * @return  ������������
	 * @throws Exception �������ռ�ʱ
	 */
	public abstract HiMenuComponent subMenuAdd(
		HiMenuComponent menu,
		final Map menuMap,
		String menuName,
		HttpServletRequest request,String parent,Map map)
		throws  Exception ;
	
	/**
	 * ͨ�����������ռ����ݼ���
	 * @param contain action�����ĵ�һ��ʵ��
	 * @param parent �ӽڵ��븸�ڵ����ϵ���ֵ
	 * @param menudefine ��ǰһ���Ĳ˵�������xml�ļ����Ӧ
	 * @return ���ص�ǰ�ڵ����һ�����ݵļ���
	 * @throws Exception ������bean�����ݿ����Ӵ���ʱ
	 */
	protected Collection getSubMenuList(HttpServletRequest request,String parent,WebDynamicMenuDefine menudefine, Map<String, String> map)throws Exception{
		if(menudefine == null) return new ArrayList();
		Filter filter = null;
		Sorter sorter = null;
		
		Class clazz = Class.forName(menudefine.getBeanName());
		Object bean = BeanUtil.CreateObject(clazz.getName());
		String propertyName = menudefine.getChild();
		
//		����ɸѡ����
		if(parent == null || parent.trim().equals("") || parent.trim().equals("0")){
			
			if(propertyName != null && !propertyName.equals("")){
				parent = menudefine.getChildvalue();
				Class propertyClass = BeanUtil.getProperyClass(bean, propertyName);
				if( BaseObject.class.isAssignableFrom(propertyClass)){
					propertyClass = Integer.class;
				}
				Object p_value = propertyClass.getConstructor(new Class[]{String.class}).newInstance(parent);
				filter = FilterFactory.getSimpleFilter(menudefine.getChild(), p_value, Filter.OPERATOR_EQ);
				filter.addCondition(menudefine.getChild(), null, Filter.OPERATOR_EQ, Filter.RELATION_OR);
			}
			else
				filter = FilterFactory.getSimpleFilter(null, null);
			
		}
		else{
			Class propertyClass = BeanUtil.getProperyClass(bean, propertyName);
			if( BaseObject.class.isAssignableFrom(propertyClass)){
				propertyClass = Integer.class;
			}
			Object p_value = propertyClass.getConstructor(new Class[]{String.class}).newInstance(parent);
			
			filter = FilterFactory.getSimpleFilter(menudefine.getChild(), p_value, Filter.OPERATOR_EQ);
			
		}
		
		//�ص�������������
		Object processor = null;
		if(menudefine.getFilter() != null && !menudefine.getFilter().equals("")){
			String filterName = menudefine.getFilter();
			processor = BeanUtil.CreateObject(filterName.trim());
			if(processor instanceof MenuFilterProcessor){
				MenuFilterProcessor process = (MenuFilterProcessor)processor;
				filter.addFilter(process.getFilter(map));
			}
		}
		
//		��������
		if(menudefine.getSort() != null && !menudefine.getSort().trim().equals("") ){
			sorter = SorterFactory.getSimpleSort(menudefine.getSort().trim());
		}
			
		Collection coll = bMgr.getObjects(clazz, filter, sorter);
		
		if(processor != null && (processor instanceof MenuCollectionProcessor)){
			MenuCollectionProcessor process = (MenuCollectionProcessor)processor;
			return process.getCollection(coll, map);
		}
		return coll;
	}
	
	
	/**
	 * ���õ�ǰ�ڵ����������
	 * @param menu ���˵�
	 * @param submenu �Ӳ˵�
	 * @param bean ��ǰ�ڵ��bean
	 * @param menudefine ��ǰ�ڵ�������Ϣ��bean
	 * @param contain action�����ĵ�һ��ʵ��
	 * @param namei ��ǰ�ڵ�Ĳ˵����ݲ˵�����Ψһ��
	 * @param isLoad �Ƿ��Ƕ�̬����
	 * @throws Exception ����beanȡ��Ӧ���Ե�ֵʱ
	 */
	protected void setAttrbute(HiMenuComponent menu, HiMenuComponent submenu,
			BaseObject bean, WebDynamicMenuDefine menudefine,
			HttpServletRequest request, int namei, boolean isLoad) throws Exception {

//		���ò˵�Դ����
		submenu.setTargetObject(bean);
		
//		���ò˵��ڲ����ƣ���ȷ�����������ýڵ��Ψһ��
		submenu.setName(menu.getName() + String.valueOf(namei));
		
//		���ýڵ����ʾ����,��������ļ�����bundle��ȡ����Դ�ļ���ָ����ֵ����֧�ֶ�����
		String bundle = menudefine.getBundle();
		if(bundle !=null && !bundle.trim().equals("") ){
			bundle = Resource.message(bundle,request.getLocale(),BeanUtil.getPropertyValueToStr(bean, menudefine.getTitleField()));
			if(StringUtils.isInclude(bundle,request.getLocale().toString()) &&  StringUtils.isInclude(bundle,"?")) //�����Դ�ļ���û��������
			    bundle = (String)BeanUtil.getPropertyValue(bean,menudefine.getTitleField());
			submenu.setTitle(bundle);
		}
		else{
			bundle = (String)BeanUtil.getPropertyValue(bean,menudefine.getTitleField());
			submenu.setTitle(bundle);
		}
		
//		���ýڵ�Ķ�����������URL���ж�̬������[#XX]����ʶ���ʶ��������Ϊ��̬����
		String action = menudefine.getAction();
		String setAction;
		if(action != null){
			if (StringUtils.isInclude(action, "{js}")) {
				setAction = processAction(bean, action);
				if (setAction != null)
					submenu.setJsFunctionName("javascript:"
							+ actionStr(bean, setAction, request));
			} else {
				setAction = processAction(bean, action);
				if (setAction != null)
					submenu.setAction(actionStr(bean, setAction, request));
			}
		}
//		���ö���Ӱ���Ŀ¼
		if(menudefine.getTarget() != null)
			submenu.setTarget(menudefine.getTarget());
		
//		���ø�ѡ��
		if(menudefine.getCheckbox())
		submenu.setCheckbox(String.valueOf(bean.getPrimarykey()));
		
//		���ýڵ��Ҳ��ͼ�꼰�䶯��
		// ���ýڵ��Ҳ��ͼ�꼰�䶯��
		if (menudefine.getIconmap() != null) {
			HashMap iconmap = menudefine.getIconmap();
			String iconStrArr = "[";
			for (Iterator i = iconmap.keySet().iterator(); i.hasNext();) {
				String iconpath = (String) i.next();
				setAction = (String) iconmap.get(iconpath);
				if (StringUtils.isInclude(setAction, "{js}"))
					setAction = "javascript:" + setAction;

				setAction = processAction(bean, setAction);

				if (!iconStrArr.equals("[")) {
					iconStrArr += ",";
				}
				iconStrArr += "[\\\"" + iconpath + "\\\",\\\""
						+ actionStr(bean, setAction, request) + "\\\"]";

			}
			iconStrArr += "]";
			if (isLoad)
				iconStrArr = iconStrArr.replaceAll("&", "&amp;");
			submenu.setIconarr(iconStrArr);
		}
		
		// ����Ҷ�ڵ�
		submenu.setLeaf(isLeaf(menudefine, bean));
		
	}
	
	/**
	 * �Ƿ�ΪҶ�ڵ�
	 * @return
	 */
	protected boolean isLeaf(WebDynamicMenuDefine menudefine, BaseObject bean) throws Exception{
		boolean leaf = false;
		if(menudefine.getLeafMethod() != null){
			String methodName = menudefine.getLeafMethod();
			Method leafMethod = bean.getClass().getMethod(methodName, new Class[]{});
			Object val = leafMethod.invoke(bean, new Object[]{});
			leaf = new Boolean(val.toString()).booleanValue();
		}
		
		return leaf;
	}
	
//	��ôaction��ͷ����,jsΪjavascript�ű�;urlΪ*.action;propertyΪ���ݿ����ֶε�ֵ
	protected String processAction(BaseObject bean, String action){
		if(action == null)
			return null;
		
		String actionLower = action.toLowerCase();
		
//			��javascript�Ĵ���
		if(StringUtils.isInclude(actionLower, "{js}")){
			return StringUtils.delString(action, "{js}");
		}
		
//			��url�Ĵ���
		if(StringUtils.isInclude(actionLower, "{url}")){
			return StringUtils.delString(action, "{url}");
		}
		
//			�Դ洢�����ݿ����ֶ�ֵ�Ĵ���
		if(StringUtils.isInclude(actionLower, "{property}")){
			String setAction = StringUtils.delString(action, "{property}");
			setAction = BeanUtil.getPropertyValueToStr(bean,setAction);
			return processAction(bean, setAction);
			}
		
		return action;
	}
	
	/**
	 * ����action���ַ�������Ƕ�̬��������̬��[#XX]�滻Ϊָ����ֵ�������ºϳ��ַ���
	 * @param bean �ڵ��beanʵ��
	 * @param action ���滻��action�ַ���
	 * @return ����һ����[#...]�м䲿���滻Ϊֵ���´�
	 * @throws Exception  ����beanȡ��Ӧ���Ե�ֵʱ
	 */
	protected String actionStr(BaseObject bean, String action, HttpServletRequest request)throws Exception{
		
		if(!StringUtils.isInclude(action,"[#"))
			return action;
		
		String result = action;
		List<String> properties = StringUtils.subStringList(action,"[#","]");
		for (String property : properties) {
			Object val = null;
			
			if(BeanUtil.hasPropertyName(bean, property))
				val = BeanUtil.getPropertyValue(bean,property);
			else
				val = request.getParameter(property);
			
			if(val == null) val = "";
			result = StringUtils.replace(result, "[#" + property + "]", val.toString());
		}
		
		return result.replaceAll("&", "&amp;");
		
	}
	
	protected InputStream getInputStream(HttpServletRequest request){
		return request.getSession().getServletContext().getResourceAsStream(menuConfig);
	}
}
