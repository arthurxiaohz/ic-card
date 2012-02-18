package org.hi.base.menu.strutsmenu;

/**
 * @author ���
 * Created on 2005-4-14
 */

import net.sf.navigator.menu.MenuComponent;


/**
 * ��չMenuComponent
 * ��ʵ�ָ�ѡ���ͼ����Ĺ���
 */
public class HiMenuComponent extends MenuComponent {

	private static final long serialVersionUID = -7663899286675884527L;

	/**
	 * ��ѡ���ж�Ӧ��ֵ
	 */
	protected String checkbox;
	
	/**
	 * ͼ���ά������ַ���
	 * �磺[['images/openfoldericon.png','commonEditAction.hi?bo=HiUser&amp;recodeNum=6'],['images/foldericon.png','commonEditAction.hi?bo=DataObject&amp;recodeNum=6']]
	 */
	protected String iconarr;
	
	/**
	 * ��Ҷ�ڵ���
	 */
	protected boolean leaf;
	
	/**
	 * �ڽڵ���ԴĿ�����
	 */
	protected Object targetObject;
	/**
	 * ִ�и���Ĺ�������
	 */
	
	protected WebDynamicMenuDefine define;
	
	protected String jsFunctionName;
	
	public HiMenuComponent(WebDynamicMenuDefine define){
		super();
		this.define =define;
	}
	
	public String getCheckbox(){
		return this.checkbox;
	}
	
	public void setCheckbox(String checkbox){
		this.checkbox = checkbox;
	}
	
	public String getIconarr(){
		return this.iconarr;
	}
	
	public void setIconarr(String iconarr){
		this.iconarr = iconarr;
	}

	public boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	
	public void removeMenuComponent(MenuComponent menuComponent){
        if (!menuComponents.contains(menuComponent)) {
            menuComponents.remove(menuComponent);
            menuComponent = null;
        }
	}

	public Object getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getJsFunctionName() {
		return jsFunctionName;
	}

	public void setJsFunctionName(String jsFunctionName) {
		this.jsFunctionName = jsFunctionName;
	}

	public WebDynamicMenuDefine getDefine() {
		return define;
	}

}

