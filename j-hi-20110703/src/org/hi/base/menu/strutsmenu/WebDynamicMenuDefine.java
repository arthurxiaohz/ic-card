package org.hi.base.menu.strutsmenu;

import java.util.HashMap;

import org.hi.common.util.StringUtils;
/**
 * �˵��Ķ�����
 * @author ���
 * Created on 2005-03-25
 */
public class WebDynamicMenuDefine {

	/**
	 * bean��ȫ������
	 */
	private String beanName;
	/**
	 * �Ӳ˵������Ƶ����飬���Ҳ��ܴ��������Ӳ�
	 */
	private String[] submenuName;
	
	/**
	 * �Ӳ˵���ָ��
	 */
	private int submpoint=0;

	/**
	 * ��Ӧ�ֶΣ�����keyΪ������ֶΣ�value�Ǵӱ���ֶ�
	 */
	private HashMap keymap;
	/**
	 * �˵�������
	 */
	private String MenuName;

	/**
	 * �ڵ����ʾ��������ʾ�ֶ������
	 */
	private String Title;
	/**
	 * ��Ϊ��ʾ���ֶ���
	 */
	private String TitleField;

	/**
	 * �Ƿ���Ҫ��ʾ
	 */
	private boolean needShow=true;

	/**
	 * ��ǰ����Ϊ���˵����ֶ���
	 */
	private String parent;
	/**
	 * ��ǰ����Ϊ�Ӳ˵����ֶ���
	 */
	private String child;
	/**
	 * ������ռ����˵�����Ҫ�ռ����ݵ�ʼֵ
	 */
	private String childvalue;
	
	/**
	 * �����ֶΣ�ֻ����һ���ֶ�
	 */
	private String sort;
	
	/**
	 * �ڵ�Ķ���
	 * �����ַ�ʽ��һ���Ǵ�URL�ж�̬���ɣ���һ���Ǵ����ݱ��ֶ���ȡ��
	 * 1��commonEditAction.action?bo=HiUser&amp;recodeNum=[#himenuitemid]
	 * 2���ֶ���
	 */
	private String action;
	
	/**
	 * ��Դ�󶨼�ֵ
	 * ���������ļ���message-resourcesԪ���е�parameter����ֵ
	 * �磺properties.ApplicationResources
	 */
	private String bundle;
	
	/**
	 * html��Ŀ��frame��ֵ
	 */
	private String target;
	
	/**
	 * �Ƿ������Ľں��һ����ѡ��
	 */
	private boolean checkbox = false;
	
	private HashMap iconmap;
	
	/**
	 * POJO���ж��Ƿ�ΪҶ�ڵ�ķ��������÷����������޲ε�
	 */
	private String leafMethod;
	
	/**
	 * �ж�������Ƿ񾭹�Ȩ�޹���
	 */
	private boolean security = false;
	
	/**
	 * �������ļ���������javascript����
	 */
	private String javascript="";
	
	/**
	 * �������������ݿ��Ƿ���뻺��
	 * ע����뻺���������ݽ����������ݵĸ��¶�����
	 */
	private boolean cache = false;
	
	
	/**
	 * �������ļ��м��������������
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
