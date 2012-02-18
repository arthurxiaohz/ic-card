package org.hi.base.menu.strutsmenu;

import java.util.HashMap;

import org.hi.common.util.StringUtils;
/**
 * 菜单的定义类
 * @author 张昊
 * Created on 2005-03-25
 */
public class WebDynamicMenuDefine {

	/**
	 * bean的全限类名
	 */
	private String beanName;
	/**
	 * 子菜单的名称的数组，并且不能大于两个子菜
	 */
	private String[] submenuName;
	
	/**
	 * 子菜单的指针
	 */
	private int submpoint=0;

	/**
	 * 对应字段，其中key为主表的字段，value是从表的字段
	 */
	private HashMap keymap;
	/**
	 * 菜单的名称
	 */
	private String MenuName;

	/**
	 * 节点的显示内容与显示字段相关联
	 */
	private String Title;
	/**
	 * 作为显示的字段名
	 */
	private String TitleField;

	/**
	 * 是否需要显示
	 */
	private boolean needShow=true;

	/**
	 * 当前表作为父菜单的字段名
	 */
	private String parent;
	/**
	 * 当前表作为子菜单的字段名
	 */
	private String child;
	/**
	 * 如果是终级父菜单，它要收集数据的始值
	 */
	private String childvalue;
	
	/**
	 * 排序字段，只允许一个字段
	 */
	private String sort;
	
	/**
	 * 节点的动作
	 * 有两种方式，一种是从URL中动态生成，另一种是从数据表字段中取得
	 * 1、commonEditAction.action?bo=HiUser&amp;recodeNum=[#himenuitemid]
	 * 2、字段名
	 */
	private String action;
	
	/**
	 * 资源绑定键值
	 * 对于配置文件中message-resources元素中的parameter属性值
	 * 如：properties.ApplicationResources
	 */
	private String bundle;
	
	/**
	 * html中目标frame的值
	 */
	private String target;
	
	/**
	 * 是否在树的节后加一个复选框
	 */
	private boolean checkbox = false;
	
	private HashMap iconmap;
	
	/**
	 * POJO中判断是否为叶节点的方法名，该方法必须是无参的
	 */
	private String leafMethod;
	
	/**
	 * 判断这个树是否经过权限过滤
	 */
	private boolean security = false;
	
	/**
	 * 在配置文件中声明的javascript方法
	 */
	private String javascript="";
	
	/**
	 * 树所描述的数据库是否加入缓存
	 * 注意加入缓冲区的数据将不会因数据的更新而更新
	 */
	private boolean cache = false;
	
	
	/**
	 * 在配置文件中加入过滤器处理器
	 */
	private String filter;
	
	public String getParent(){
		return this.parent;
	}
	
	public void setParent(String parent){
		this.parent = parent;
	}
	
	public String getChild(){
		return this.child;
	}
	
	public void setChild(String child){
		this.child = child;
	}
	
	public String getChildvalue(){
		return this.childvalue;
	}
	
	public void setChildValue(String childvalue){
		this.childvalue = childvalue;
	}
	

	public String getMenuName() {
		return MenuName;
	}

	public String getBeanName() {
		return beanName;
	}

	public String getTitle() {
		return Title;
	}


	public void setMenuName(String string) {
		MenuName = string;
	}


	public void setBeanName(String beanname) {
		beanName = beanname;
	}


	public void setTitle(String string) {
		Title = string;
	}


	public String getSubmenuName() {
		if(submpoint>=submenuName.length || submpoint<0)
			return null;
		
		return submenuName[submpoint];
	}

	public void setSubmenuName(String string) {
		submenuName = StringUtils.strToStrArray(string);
	}
	
	public void nextSubmenuName(){
		submpoint++;
	}

	public void previousSubmenuName(){
		submpoint--;
	}
	public HashMap getKeymap() {
		return keymap;
	}


	public String getTitleField() {
		return TitleField;
	}


	public void setKeymap(HashMap map) {
		keymap = map;
	}


	public void setTitleField(String string) {
		TitleField = string;
	}


	public boolean isNeedShow() {
		return needShow;
	}


	public void setNeedShow(boolean b) {
		needShow = b;
	}

	public String getSort() {
		return this.sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public String getAction(){
		return this.action;
	}
	
	public void setAction(String action){
		this.action = action;
	}
	
	public String getBundle(){
		return this.bundle;
	}
	
	public void setBundle(String bundle){
		this.bundle = bundle;
	}
	
	public String getTarget(){
		return this.target;
	}
	
	public void setTarget(String target){
		this.target = target;
	}
	
	public boolean getCheckbox() {
		return this.checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	
	public HashMap getIconmap(){
		return this.iconmap;
	}
	
	public void setIconmap(HashMap iconmap){
		this.iconmap = iconmap;
	}

	public String getLeafMethod() {
		return leafMethod;
	}

	public void setLeafMethod(String leafMethod) {
		this.leafMethod = leafMethod;
	}

	public boolean isSecurity() {
		return security;
	}

	public void setSecurity(boolean security) {
		this.security = security;
	}

	public String getJavascript() {
		return javascript;
	}

	public void setJavascript(String javascript) {
		this.javascript = javascript;
	}

	public boolean isCache() {
		return cache;
	}

	public void setCache(boolean cache) {
		this.cache = cache;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

}
