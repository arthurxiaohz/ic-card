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
 * @author ���
 * Created on 2005-04-07
 */
public class WebDynamicTreeManager extends AbstractMenuTreeManager {
	
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
		HttpServletRequest request,
		String parent,
		Map map)
		throws  Exception {
		try {
			//�õ��˵�����
			WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
			if(menudefine == null)
				throw new BusinessException(menuName + "�˵�δ����");
			Collection list = getSubMenuList(request,parent,menudefine, map);
			int namei = 0;
			
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
						request,parent,map);
		}
			menudefine.previousSubmenuName();
		
			return menu;
		}catch (Exception e) {

			throw e;
		}
	}

	
	/**
	 * ͨ�����������ƶ�̬������
	 * @param name �˵�����
	 * @param keys HttpServletRequest����Ĳ�������
	 * @param menuType forward�ļ�ֵ
	 * @param contain action�����ĵ�һ��ʵ��
	 * @return ���ص�ǰ���µ����нڵ����
	 * @throws Exception �������ռ������XML�ļ���װ��Bean����ʱ
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
	 * �齨��̬���ص�����ÿ��ֻ����һ��
	 * @param menu ��ǰ����Ϊ������HiMenuComponentʵ��
	 * @param menuMap himenu-config.xmlת��ΪWebDynamicMenuDefine����ļ��ϣ���ֵΪ�˵���ֵΪWebDynamicMenuDefine����
	 * @param menuName ��ǰ��Ĳ˵�����
	 * @param contain action�����ĵ�һ��ʵ��
	 * @param parent ��Ϊ�ӽڵ���Ҹ��ڵ��Ӧ��ֵ
	 * @return ���ص�ǰ�㼰���Ӳ��HiMenuComponentʵ��
	 * @throws Exception �������ռ���װ��Bean����ʱ
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
			//�õ��˵�����
			WebDynamicMenuDefine menudefine = (WebDynamicMenuDefine) menuMap.get(menuName);
			Collection list = this.getSubMenuList(request,parent,menudefine, map);
			int namei = 0;
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BaseObject bean = (BaseObject) iter.next();
				//������ǰ�ڵ�
				HiMenuComponent submenu = new HiMenuComponent(menudefine);
				//���ýڵ����������
				setAttrbute(menu, submenu, bean, menudefine, request, namei++, true);

				//�������Ҫ��ʾ����ʹ�ø��ڵ���Ϊ��ǰ�ڵ�
				if (!menudefine.isNeedShow())
					submenu = menu;
				//������Ӳ˵�,������Ƿ������ݾ����Ӷ�̬�˵�	
				if (menudefine.getSubmenuName() != null) {

					subMenuUrlAdd(
						submenu,
						getSubMenuInfo(menudefine, bean),
						menuMap,
						menudefine.getSubmenuName(),request,parent,list);
				}
				//����ǰ�ڵ�ŵ����С�(�������Ҫ�Ͷ�ȡ�Ӳ˵�)
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
	 * ����Ӳ˵������ݣ�����붯̬�����Ϊ��ȡ��һ���������׼��
	 * @param submenu �Ӳ˵��ڵ�HiMenuComponentʵ��
	 * @param map ���ӹ�ϵ��Map��Ӧ�����ļ��е�keymap����
	 * @param menuMap himenu-config.xmlת��ΪWebDynamicMenuDefine����ļ��ϣ���ֵΪ�˵���ֵΪWebDynamicMenuDefine����
	 * @param menuName �˵�����
	 * @param contain action�����ĵ�һ��ʵ��
	 * @param parent ��Ϊ�ӽڵ���Ҹ��ڵ��Ӧ��ֵ
	 * @param list ��ǰ���µ������ӽڵ�ļ���
	 */
	private void subMenuUrlAdd(
		HiMenuComponent submenu,
		HashMap map,
		Map menuMap,
		String menuName,
		HttpServletRequest request,String parent,Collection list){
		//�õ��˵�����
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
	 * �����˵��Ĺؼ��ֶε�ֵ��Ϊ�������Ӳ˵�
	 * @param menudefine ��ǰ�ڵ�Ĳ˵�����
	 * @param bean ��ǰ��װ�ص��˵��ڵ��е�bean
	 * @return �����븸�˵���ص���Ϣ�������˵���Ӧ���ݿ����ֶ����뵱ǰֵ
	 * @throws Exception ��ͨ�����˵��ֶεõ�bean����ֵʱ
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
