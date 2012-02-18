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
 * @author ���
 * Created on 2005-04-07
 */
public class SysMenuTreeManager extends AbstractMenuTreeManager{
	
//	����˵�����û���κ���������˵�����˵����ӣ�
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
	 * ͨ���ݹ麯��������֯����
	 * @param menu ��MenuComponentʵ��
	 * @param menuMap himenu-config.xmlת��ΪWebDynamicMenuDefine����ļ��ϣ���ֵΪ�˵���ֵΪWebDynamicMenuDefine����
	 * @param menuName ��ǰ�˵��Ĳ˵���
	 * @param contain  action�����ĵ�һ��ʵ��
	 * @param parent ��Ϊ�ӽڵ���Ҹ��ڵ��Ӧ��ֵ
	 * @return  ������������
	 * @throws Exception �������ռ�ʱ
	 */
	public HiMenuComponent subMenuAdd(
		HiMenuComponent menu,
		final Map menuMap,
		String menuName,
		HttpServletRequest request,String parent,Map map)
		throws  Exception {
		try {
			//�õ��˵�����
			WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
			Collection list = new ArrayList();
			//�����Ҫ����Ȩ�޹���
			if(menudefine.isSecurity())
				list = getSubMenuListBySecurity(request,parent,menudefine, map);
			else
				list = getSubMenuList(request,parent,menudefine, map);
			int namei = 0;
			
//			if(null==list || list.size()<=0 )
//				menu.addMenuComponent(menu);
			
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BaseObject bean = (BaseObject) iter.next();
                //������ǰ�ڵ�
				HiMenuComponent submenu = new HiMenuComponent(menudefine);
				
				//���ò˵�����
				
				setAttrbute(menu, submenu, bean, menudefine, request, namei++, false);
				
					//�������Ҫ��ʾ����ʹ�ø��ڵ���Ϊ��ǰ�ڵ�
				if (!menudefine.isNeedShow())
					submenu = menu;
				//������Ӳ˵�����ݹ���á�	
				if (menudefine.getSubmenuName() != null ) {

					submenu =
						subMenuAdd(
							submenu,
//							getSubMenuInfo(menudefine, element),
							menuMap,
							menudefine.getSubmenuName(),
							request,BeanUtil.getPropertyValue(bean,menudefine.getParent()).toString(),map);
				}
				//����ǰ�ڵ�ŵ����С�(�������Ҫ��ʾ�Ͳ��÷�)
				if (menudefine.isNeedShow())
					menu.addMenuComponent(submenu);
			}
		
		//����ò˵��ж���һ�����ϵ��Ӳ˵���ע���ڲ˵�����ʱ���ܴ��������Ӳ˵�
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
	 * ͨ������������Ȩ�������ռ����ݼ���
	 * @param contain action�����ĵ�һ��ʵ��
	 * @param parent �ӽڵ��븸�ڵ����ϵ���ֵ
	 * @param menudefine ��ǰһ���Ĳ˵�������xml�ļ����Ӧ
	 * @return ���ص�ǰ�ڵ����һ�����ݵļ���
	 * @throws Exception ������bean�����ݿ����Ӵ���ʱ
	 * @author xinfeng
	 */
	private Collection getSubMenuListBySecurity(HttpServletRequest request,String parent,WebDynamicMenuDefine menudefine, Map<String, String> map)throws Exception{
		if(menudefine == null || UserContextHelper.getUser() == null) return new ArrayList();
		Filter filter = null;
		Sorter sorter = null;
		
//		����ɸѡ����
		if(parent == null || parent.trim().equals("")|| parent.trim().equals("0")){
			filter = FilterFactory.getSimpleFilter(menudefine.getChild(), menudefine.getChildvalue(), Filter.OPERATOR_EQ);
			filter.addCondition(menudefine.getChild(), null, Filter.OPERATOR_EQ, Filter.RELATION_OR);
		}
		else
			filter = FilterFactory.getSimpleFilter(menudefine.getChild(), new Integer(parent), Filter.OPERATOR_EQ);
		
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
			sorter.addSort("id");	//�ӵڶ��������ֶΣ���Ϊ��������ʱ��ֵ������ͬ��
		}
//		ѭ���ж�����Ȩ��	
		Class clazz = Class.forName(menudefine.getBeanName());
		if(clazz.equals(MenuLink.class) && HiConfigHolder.getPublished())
			filter.addCondition("menuLinkType", new Integer(1), Filter.OPERATOR_NOT_EQ, Filter.RELATION_AND);
		Collection noSecurityList = bMgr.getObjects(clazz, filter, sorter);
		
//		����ǳ�������Ա�ͺ���Ȩ�ޣ���ʾȫ���˵�����
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
	 * �ж�Ȩ�ޣ�����б�����һ����Ȩ�޾ͷ�����
	 * @param objectList �б�
	 * @return �������
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
	 * �ж�Ȩ�ޣ����object��MenuLink���Ҵ��û���Щ������Ȩ�޾ͷ�����.
	 * @param object 
	 * @return �������
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
