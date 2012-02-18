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
	 * menu数据库的缓冲区
	 */
	private static Map<String, HiMenuComponent>  cacheMap = Collections.synchronizedMap(new HashMap<String, HiMenuComponent>());
	
	/**
	 * 通过给定的在himenu-config.xml文件中的菜单名称，
	 * @param name 菜单名称
	 * @param keys request.parameter的一个集合
	 * @param contain action上下文的一个实例
	 * @return 返回组装后的MenuComponent菜单类实例，通过struts-menu将该对象解释并对tag画到页面中
	 * @throws Exception 在数据收集或读出XML文件出错时
	 */
	public HiMenuComponent getMenu(String name, Map keys ,HttpServletRequest request) throws Exception {
		
		//获取菜单的配置文件
		if(HiConfigHolder.getMenuConfig() != null)
			menuConfig = HiConfigHolder.getMenuConfig();
		
		//每次是否重新装载菜单配置文件
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
		
//		去除所有没有子节点的枝节点
		refactorMenu(menu);
		
		if(rootMenudefine.isCache())
			cacheMap.put(rootMenudefine.getMenuName(), menu);
		
		return menu;
	}
	
	/**
	 * 对组装好的树型结构进行重构
	 * @param menu
	 */
	protected void refactorMenu(HiMenuComponent menu){
	}
	
	/**
	 * 通过递归函数，以组织成树
	 * @param menu 父MenuComponent实例
	 * @param menuMap himenu-config.xml转换为WebDynamicMenuDefine对象的集合，键值为菜单名值为WebDynamicMenuDefine对象
	 * @param menuName 当前菜单的菜单名
	 * @param contain  action上下文的一个实例
	 * @param parent 作为子节点查找父节点对应的值
	 * @return  返回子树对象
	 * @throws Exception 在数据收集时
	 */
	public abstract HiMenuComponent subMenuAdd(
		HiMenuComponent menu,
		final Map menuMap,
		String menuName,
		HttpServletRequest request,String parent,Map map)
		throws  Exception ;
	
	/**
	 * 通过给定条件收集数据集合
	 * @param contain action上下文的一个实例
	 * @param parent 子节点与父节点联合的数值
	 * @param menudefine 当前一级的菜单定义与xml文件相对应
	 * @return 返回当前节点的下一级数据的集合
	 * @throws Exception 当创建bean或数据库连接错误时
	 */
	protected Collection getSubMenuList(HttpServletRequest request,String parent,WebDynamicMenuDefine menudefine, Map<String, String> map)throws Exception{
		if(menudefine == null) return new ArrayList();
		Filter filter = null;
		Sorter sorter = null;
		
		Class clazz = Class.forName(menudefine.getBeanName());
		Object bean = BeanUtil.CreateObject(clazz.getName());
		String propertyName = menudefine.getChild();
		
//		设置筛选条件
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
		
		//回调过滤器处理器
		Object processor = null;
		if(menudefine.getFilter() != null && !menudefine.getFilter().equals("")){
			String filterName = menudefine.getFilter();
			processor = BeanUtil.CreateObject(filterName.trim());
			if(processor instanceof MenuFilterProcessor){
				MenuFilterProcessor process = (MenuFilterProcessor)processor;
				filter.addFilter(process.getFilter(map));
			}
		}
		
//		设置排序
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
	 * 设置当前节点的所有属性
	 * @param menu 父菜单
	 * @param submenu 子菜单
	 * @param bean 当前节点的bean
	 * @param menudefine 当前节点配置信息的bean
	 * @param contain action上下文的一个实例
	 * @param namei 当前节点的菜单内容菜单名，唯一键
	 * @param isLoad 是否是动态加载
	 * @throws Exception 当从bean取相应属性的值时
	 */
	protected void setAttrbute(HiMenuComponent menu, HiMenuComponent submenu,
			BaseObject bean, WebDynamicMenuDefine menudefine,
			HttpServletRequest request, int namei, boolean isLoad) throws Exception {

//		设置菜单源对象
		submenu.setTargetObject(bean);
		
//		设置菜单内部名称，以确定在整棵树该节点的唯一性
		submenu.setName(menu.getName() + String.valueOf(namei));
		
//		设置节点的显示标题,如果配置文件中有bundle就取找资源文件中指定的值，以支持多语言
		String bundle = menudefine.getBundle();
		if(bundle !=null && !bundle.trim().equals("") ){
			bundle = Resource.message(bundle,request.getLocale(),BeanUtil.getPropertyValueToStr(bean, menudefine.getTitleField()));
			if(StringUtils.isInclude(bundle,request.getLocale().toString()) &&  StringUtils.isInclude(bundle,"?")) //如果资源文件中没有做翻译
			    bundle = (String)BeanUtil.getPropertyValue(bean,menudefine.getTitleField());
			submenu.setTitle(bundle);
		}
		else{
			bundle = (String)BeanUtil.getPropertyValue(bean,menudefine.getTitleField());
			submenu.setTitle(bundle);
		}
		
//		设置节点的动作，动作的URL中有动态数据用[#XX]作用识别标识，否则视为静态动作
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
//		设置动作影响的目录
		if(menudefine.getTarget() != null)
			submenu.setTarget(menudefine.getTarget());
		
//		设置复选框
		if(menudefine.getCheckbox())
		submenu.setCheckbox(String.valueOf(bean.getPrimarykey()));
		
//		设置节点右侧的图标及其动作
		// 设置节点右侧的图标及其动作
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
		
		// 设置叶节点
		submenu.setLeaf(isLeaf(menudefine, bean));
		
	}
	
	/**
	 * 是否为叶节点
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
	
//	怎么action的头规则,js为javascript脚本;url为*.action;property为数据库中字段的值
	protected String processAction(BaseObject bean, String action){
		if(action == null)
			return null;
		
		String actionLower = action.toLowerCase();
		
//			对javascript的处理
		if(StringUtils.isInclude(actionLower, "{js}")){
			return StringUtils.delString(action, "{js}");
		}
		
//			对url的处理
		if(StringUtils.isInclude(actionLower, "{url}")){
			return StringUtils.delString(action, "{url}");
		}
		
//			对存储于数据库中字段值的处理
		if(StringUtils.isInclude(actionLower, "{property}")){
			String setAction = StringUtils.delString(action, "{property}");
			setAction = BeanUtil.getPropertyValueToStr(bean,setAction);
			return processAction(bean, setAction);
			}
		
		return action;
	}
	
	/**
	 * 处理action的字符，如果是动态动作将动态将[#XX]替换为指定的值，并重新合成字符串
	 * @param bean 节点的bean实例
	 * @param action 待替换的action字符串
	 * @return 返回一个将[#...]中间部分替换为值的新串
	 * @throws Exception  当从bean取相应属性的值时
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
