package org.hi.base.menu.strutsmenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hi.base.menu.model.Menu;
import org.hi.base.menu.model.MenuLink;
import org.hi.base.organization.model.UserType;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.StringUtils;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.dao.impl.SorterFactory;
import org.hi.framework.model.BaseObject;
import org.hi.framework.security.context.UserContextHelper;
/**
 * @author 张昊
 * Created on 2005-04-07
 */
public class SysMenuTreeManager extends AbstractMenuTreeManager{
	
//	如果菜单项中没有任何子项（包括菜单项与菜单链接）
	protected void refactorMenu(HiMenuComponent menu){
		for (Iterator iter = menu.getComponents().iterator(); iter.hasNext();) {
			HiMenuComponent component = (HiMenuComponent) iter.next();
			
			refactorMenu(component);

			Object obj = component.getTargetObject();
			if(obj instanceof MenuLink)
				continue;
			
			if(component.getComponents() == null || component.getComponents().size() == 0){
				menu.removeMenuComponent(component);
				iter.remove();
			}
		}
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
	public HiMenuComponent subMenuAdd(
		HiMenuComponent menu,
		final Map menuMap,
		String menuName,
		HttpServletRequest request,String parent,Map map)
		throws  Exception {
		try {
			//得到菜单定义
			WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
			Collection list = new ArrayList();
			//如果需要进行权限过滤
			if(menudefine.isSecurity())
				list = getSubMenuListBySecurity(request,parent,menudefine, map);
			else
				list = getSubMenuList(request,parent,menudefine, map);
			int namei = 0;
			
//			if(null==list || list.size()<=0 )
//				menu.addMenuComponent(menu);
			
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BaseObject bean = (BaseObject) iter.next();
                //建立当前节点
				HiMenuComponent submenu = new HiMenuComponent(menudefine);
				
				//设置菜单属性
				
				setAttrbute(menu, submenu, bean, menudefine, request, namei++, false);
				
					//如果不需要显示，则使用父节点作为当前节点
				if (!menudefine.isNeedShow())
					submenu = menu;
				//如果有子菜单，则递归调用。	
				if (menudefine.getSubmenuName() != null ) {

					submenu =
						subMenuAdd(
							submenu,
//							getSubMenuInfo(menudefine, element),
							menuMap,
							menudefine.getSubmenuName(),
							request,BeanUtil.getPropertyValue(bean,menudefine.getParent()).toString(),map);
				}
				//将当前节点放到树中。(如果不需要显示就不用放)
				if (menudefine.isNeedShow())
					menu.addMenuComponent(submenu);
			}
		
		//如果该菜单有多于一个以上的子菜单，注意在菜单定义时不能大于两个子菜单
			menudefine.nextSubmenuName();
			if (menudefine.getSubmenuName() != null ) {
					subMenuAdd(
						menu,
						menuMap,
						menudefine.getSubmenuName(),
						request,parent, map);
		}
			menudefine.previousSubmenuName();
		
			return menu;
		}catch (Exception e) {

			throw e;
		}
	}

	

	/**
	 * 通过给定条件和权限条件收集数据集合
	 * @param contain action上下文的一个实例
	 * @param parent 子节点与父节点联合的数值
	 * @param menudefine 当前一级的菜单定义与xml文件相对应
	 * @return 返回当前节点的下一级数据的集合
	 * @throws Exception 当创建bean或数据库连接错误时
	 * @author xinfeng
	 */
	private Collection getSubMenuListBySecurity(HttpServletRequest request,String parent,WebDynamicMenuDefine menudefine, Map<String, String> map)throws Exception{
		if(menudefine == null || UserContextHelper.getUser() == null) return new ArrayList();
		Filter filter = null;
		Sorter sorter = null;
		
//		设置筛选条件
		if(parent == null || parent.trim().equals("")|| parent.trim().equals("0")){
			filter = FilterFactory.getSimpleFilter(menudefine.getChild(), menudefine.getChildvalue(), Filter.OPERATOR_EQ);
			filter.addCondition(menudefine.getChild(), null, Filter.OPERATOR_EQ, Filter.RELATION_OR);
		}
		else
			filter = FilterFactory.getSimpleFilter(menudefine.getChild(), new Integer(parent), Filter.OPERATOR_EQ);
		
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
			sorter.addSort("id");	//加第二个排序字段，因为序列生成时数值都是相同的
		}
//		循环判断有无权限	
		Class clazz = Class.forName(menudefine.getBeanName());
		if(clazz.equals(MenuLink.class) && HiConfigHolder.getPublished())
			filter.addCondition("menuLinkType", new Integer(1), Filter.OPERATOR_NOT_EQ, Filter.RELATION_AND);
		Collection noSecurityList = bMgr.getObjects(clazz, filter, sorter);
		
//		如果是超级管理员就忽略权限，显示全部菜单内容
		if(UserContextHelper.getUser().getUserMgrType()!=null && UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR){
			
			if(processor != null && (processor instanceof MenuCollectionProcessor)){
				MenuCollectionProcessor process = (MenuCollectionProcessor)processor;
				return process.getCollection(noSecurityList, map);
			}
			return noSecurityList;
		}
		
		Collection securityList = new ArrayList();
		for (Object object : noSecurityList) {
			if (object instanceof Menu) {
				Menu menu = (Menu) object;
				filter = FilterFactory.getSimpleFilter("menu.id", menu.getId(), Filter.OPERATOR_EQ);
				Collection chiledList = bMgr.getObjects(MenuLink.class,filter);
				Filter menuFilter = FilterFactory.getSimpleFilter("parentMenu.id",menu.getId(), Filter.OPERATOR_EQ);
				chiledList.addAll(bMgr.getObjects(Menu.class,menuFilter));

				if(hasSecuritys(chiledList)){
					securityList.add(object);
				}
			}
			if (object instanceof MenuLink){
				if(hasSecuritys(object))
					securityList.add(object);
			}
			
		}
		
		if(processor != null && (processor instanceof MenuCollectionProcessor)){
			MenuCollectionProcessor process = (MenuCollectionProcessor)processor;
			return process.getCollection(securityList, map);
		}
		
		return  securityList;
	}
	
	/**
	 * 判断权限，如果列表中有一个有权限就返回真
	 * @param objectList 列表
	 * @return 返回真假
	 * @author xinfeng
	 */
	private boolean hasSecuritys(Collection objectList){
		if(UserContextHelper.getUser().getUserMgrType()!=null && UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR)
			return true;
		for (Object object : objectList) {
			if(hasSecuritys(object))
				return true;
			
		}
		
		
		return false;
	}
	
	/**
	 * 判断权限，如果object是MenuLink并且此用户对些连接有权限就返回真.
	 * @param object 
	 * @return 返回真假
	 * @author xinfeng
	 */
	private boolean hasSecuritys(Object object){
		if(UserContextHelper.getUser().getUserMgrType()!=null && UserContextHelper.getUser().getUserMgrType() == UserType.USERTYPE_ADMINISTRATOR)
			return true;
		if(object instanceof Menu)
			return true;
		if(object instanceof MenuLink){
			MenuLink menuLink = (MenuLink)object;
			Set links = UserContextHelper.getUserContext().getUserMenuUrls();
			String url = menuLink.getLinkUrl();
			if(StringUtils.isIncludes(url, "?"))
				url = url.substring(0, url.indexOf("?"));
			if(links.contains(url))
				return true;
		}
		return false;
	}
}
