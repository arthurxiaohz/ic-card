package org.hi.base.menu.strutsmenu;

/**
 * @author 张昊
 * Created on 2005-4-14
 */

import net.sf.navigator.menu.MenuComponent;


/**
 * 扩展MenuComponent
 * 以实现复选框和图标组的功能
 */
public class HiMenuComponent extends MenuComponent {

	private static final long serialVersionUID = -7663899286675884527L;

	/**
	 * 复选框中对应的值
	 */
	protected String checkbox;
	
	/**
	 * 图标二维数组的字符串
	 * 如：[['images/openfoldericon.png','commonEditAction.hi?bo=HiUser&amp;recodeNum=6'],['images/foldericon.png','commonEditAction.hi?bo=DataObject&amp;recodeNum=6']]
	 */
	protected String iconarr;
	
	/**
	 * 是叶节点吗
	 */
	protected boolean leaf;
	
	/**
	 * 在节点上源目标对象
	 */
	protected Object targetObject;
	/**
	 * 执行父类的构建函数
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

