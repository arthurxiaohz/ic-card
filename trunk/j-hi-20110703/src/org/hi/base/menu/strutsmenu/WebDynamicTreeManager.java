package org.hi.base.menu.strutsmenu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hi.common.util.BeanUtil;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.model.BaseObject;
import org.hi.framework.web.BusinessException;
/**
 * @author 张昊
 * Created on 2005-04-07
 */
public class WebDynamicTreeManager extends AbstractMenuTreeManager {
	
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
		HttpServletRequest request,
		String parent,
		Map map)
		throws  Exception {
		try {
			//得到菜单定义
			WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
			if(menudefine == null)
				throw new BusinessException(menuName + "菜单未定义");
			Collection list = getSubMenuList(request,parent,menudefine, map);
			int namei = 0;
			
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
						request,parent,map);
		}
			menudefine.previousSubmenuName();
		
			return menu;
		}catch (Exception e) {

			throw e;
		}
	}

	
	/**
	 * 通过给定的名称动态加载树
	 * @param name 菜单名称
	 * @param keys HttpServletRequest对象的参数集合
	 * @param menuType forward的键值
	 * @param contain action上下文的一个实例
	 * @return 返回当前层下的所有节点的树
	 * @throws Exception 在数据收集或读出XML文件或装载Bean出错时
	 */
		public HiMenuComponent getLoadMenu(String name, Map keys, String menuType,HttpServletRequest request)
						throws Exception {
			this.menuType = menuType;
			String parent = null;
			Map menuMap = (Map) (new XmlUtil().read(getInputStream(request)));
			WebDynamicMenuDefine rootMenudefine = (WebDynamicMenuDefine) menuMap.get(name);
			HiMenuComponent menu = new HiMenuComponent(rootMenudefine);
		
			if (menuMap.get(name) != null) {
				menu.setTitle(rootMenudefine.getTitle());
				menu.setName(rootMenudefine.getMenuName());
				
				for (Iterator iter = rootMenudefine.getKeymap().keySet().iterator(); iter.hasNext();){
					String key = (String) iter.next();
					Object obj = keys.get(rootMenudefine.getKeymap().get(key));
					if(obj != null)
						parent = obj.toString();
				}
				menu = submenuLoadAdd(menu, menuMap, name, request, parent, keys);
			}
			request.setAttribute("javascript", rootMenudefine.getJavascript());
			return menu;
	}


	/**
	 * 组建动态加载的树。每次只加载一层
	 * @param menu 当前层作为树根的HiMenuComponent实例
	 * @param menuMap himenu-config.xml转换为WebDynamicMenuDefine对象的集合，键值为菜单名值为WebDynamicMenuDefine对象
	 * @param menuName 当前层的菜单名称
	 * @param contain action上下文的一个实例
	 * @param parent 作为子节点查找父节点对应的值
	 * @return 返回当前层及其子层的HiMenuComponent实例
	 * @throws Exception 在数据收集或装载Bean出错时
	 */
	private HiMenuComponent submenuLoadAdd(
		HiMenuComponent menu,
		final Map menuMap,
		String menuName,
		HttpServletRequest request,
		String parent,
		Map map)
		throws  Exception {
		try {
			//得到菜单定义
			WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
			Collection list = this.getSubMenuList(request,parent,menudefine, map);
			int namei = 0;
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BaseObject bean = (BaseObject) iter.next();
				//建立当前节点
				HiMenuComponent submenu = new HiMenuComponent(menudefine);
				//设置节点的所有属性
				setAttrbute(menu, submenu, bean, menudefine, request, namei++, true);

				//如果不需要显示，则使用父节点作为当前节点
				if (!menudefine.isNeedShow())
					submenu = menu;
				//如果有子菜单,则根据是否有数据决定加动态菜单	
				if (menudefine.getSubmenuName() != null) {

					subMenuUrlAdd(
						submenu,
						getSubMenuInfo(menudefine, bean),
						menuMap,
						menudefine.getSubmenuName(),request,parent,list);
				}
				//将当前节点放到树中。(如果不需要就读取子菜单)
				if (menudefine.isNeedShow())
					menu.addMenuComponent(submenu);
				else {
					menu =
						submenuLoadAdd(
							submenu,
//							getSubMenuInfo(menudefine, bean),
							menuMap,
							menudefine.getSubmenuName(),request,parent, map);
				}
			}
			
				menudefine.nextSubmenuName();
				if (menudefine.getSubmenuName() != null ) {
					submenuLoadAdd(
							menu,
//							getSubMenuInfo(menudefine, bean),
							menuMap,
							menudefine.getSubmenuName(),request,parent, map);
			}
				menudefine.previousSubmenuName();
				
			
			return menu;
		} catch (Exception e) {

			throw e;
		}
	}

	/**
	 * 如果子菜单有数据，则加入动态加载项，为提取下一层的数据做准备
	 * @param submenu 子菜单节点HiMenuComponent实例
	 * @param map 主从关系的Map对应配置文件中的keymap属性
	 * @param menuMap himenu-config.xml转换为WebDynamicMenuDefine对象的集合，键值为菜单名值为WebDynamicMenuDefine对象
	 * @param menuName 菜单名称
	 * @param contain action上下文的一个实例
	 * @param parent 作为子节点查找父节点对应的值
	 * @param list 当前层下的所有子节点的集合
	 */
	private void subMenuUrlAdd(
		HiMenuComponent submenu,
		HashMap map,
		Map menuMap,
		String menuName,
		HttpServletRequest request,String parent,Collection list){
		//得到菜单定义
		WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
		if (list.size() > 0) {
			String location = "";
			String adjust = "&";
			if ("subMenu".equals(menuType))
				adjust = "&amp;";
			location += adjust + "menuName=" + menudefine.getMenuName();
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ) {
				String lkey = (String) iterator.next();
				location += adjust + lkey + "=" + map.get(lkey);
			}
			String actionSuffix = HiConfigHolder.getViewFrameworkSuffix();
			submenu.setForward(request.getContextPath() + "/loadTree."+ actionSuffix +"?type=subMenu" + location);
		}
	}

	
	/**
	 * 将父菜单的关键字段的值作为参数给子菜单
	 * @param menudefine 当前节点的菜单定义
	 * @param bean 当前做装载到菜单节点中的bean
	 * @return 返回与父菜单相关的信息，即父菜单对应数据库表的字段名与当前值
	 * @throws Exception 当通过父菜单字段得到bean属性值时
	 */
	private HashMap getSubMenuInfo(WebDynamicMenuDefine menudefine, BaseObject bean) throws Exception{
		HashMap map = new HashMap();
		for (Iterator iter = menudefine.getKeymap().keySet().iterator(); iter.hasNext();){
			String key = (String) iter.next();
			map.put(menudefine.getKeymap().get(key), BeanUtil.getPropertyValue(bean,key).toString());
		}
		return map;
	}
	

}
