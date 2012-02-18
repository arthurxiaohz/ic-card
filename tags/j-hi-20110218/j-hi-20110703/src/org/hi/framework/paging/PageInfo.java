package org.hi.framework.paging;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.Sorter;

/**
 * �ýӿ��Ƕ�����ҳ����Ϣ�����ϣ�����ҳ����Ϣ��Ϣ�Ľ�һ����װ�����а���Page,Fltert��Sorter
 * <p>ע�⣺Ŀ����໹��֧�ַ��顢�ۺϵ�SQL��׼����
 * @author���
 * @since 2006-12-16
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.Sorter
 * @ses org.hi.framework.paging.Page
 */
public interface PageInfo extends java.io.Serializable{
	
	/**
	 * ��ȡ��ǰҳ����Ϣ�Ĺ�������ʵ������һ�������,ͨ��<code>getConditions()</code>����<p>
	 * ���Եõ���ҳ����Ϣ���й������ľ�������,�÷������ص���<code>FilterBean</code>���͵�һ��
	 * <code>List</code>����
	 * @see org.hi.framework.dao.Filter.getConditions()
	 * @see import org.hi.framework.dao.impl.FilterBean
	 * @return ���ص�ǰҳ����Ϣ�Ĺ�����
	 */
	public Filter getFilter();
	
	/**
	 * Ϊ��ǰҳ����Ϣ���ù�����
	 * @param filter ������
	 */
	public void setFilter(Filter filter) ;
	
	/**
	 * ��õ�ǰҳ���б�ľ�����Ϣ
	 * @return �����б�ҳ����к���ҳ��
	 */
	public Page getPage() ;
	
	/**
	 * �����б���Ϣ
	 * @param page
	 */
	public void setPage(Page page);
	
	/**
	 * ����������
	 * @return
	 */
	public Sorter getSorter() ;
	
	/**
	 * ����������
	 * @param sorter
	 */
	public void setSorter(Sorter sorter) ;
}
