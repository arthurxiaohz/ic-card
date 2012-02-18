package org.hi.framework.paging;

import java.io.Serializable;

/**
 * �ýӿ��ǹ淶ҳ���װ��Ϣ,�����ܼ�¼������ҳ����ÿҳ��¼��(pageSize)���Ƿ�����ҳ��βҳ������޼�¼����
 * ��ҳ��Ҫ��ʾ��ҳ��������middlePageNum���ȡ�����ƽ̨�ṩ��ȫ�ֵ����ã��μ�hiFrameworkConfig.properties�ļ�
 * @author ���
 * @since 2006-11-15
 *
 */
public interface Page extends Serializable {

	/**
	 * ����ҳ���ܼ�¼��
	 * @param totalRecords �ܼ�¼��
	 */
	public void setTotalRecords(int totalRecords);
	
	/**
	 * ���ҳ���ܼ�¼��
	 * @return ҳ���ܼ�¼��
	 */
	public int getTotalRecords();
	/**
	 * ������ҳ��
	 * @param totalPage ��ҳ��
	 */
	public void setTotalPage(int totalPage);
	
	/**
	 * ��ȡ��ҳ�� 
	 * @return ��ҳ��
	 */
	public int getTotalPage();
	
	/**
	 * ��ҳ�ļ�¼��
	 * @return ��ҳ�ļ�¼��
	 */
	public void setPageSize(int pageSize);
	
	/**
	 * ��ҳ�ļ�¼��
	 * @return ��ҳ�ļ�¼��
	 */
	public int getPageSize();
	
	
	/**
	 * �����Ƿ�����ҳ
	 * @param isFristPage �Ƿ�Ϊ��ҳ
	 */
	public void setIsFristPage(boolean isFristPage);
	
	/**
	 * �Ƿ�Ϊ��ҳ
	 * @return �Ƿ�Ϊ��ҳ 
	 */
	public boolean getIsFristPage();
	
	/**
	 * �����Ƿ�Ϊ���һҳ
	 * @param isLastPage ��Ϊ���һҳ
	 */
	public void setIsLastPage(boolean isLastPage);
	
	/**
	 * �Ƿ������һҳ
	 * @return
	 */
	public boolean getIsLastPage();
	
	/**
	 * ���õ�ǰҳ�ǵڼ�ҳ
	 * @param currentPage ��ǰҳ��ҳ��
	 */
	public void setCurrentPage(int currentPage);
	
	/**
	 * �õ���ǰҳ��ҳ��
	 * @return ��ǰҳ��ҳ��
	 */
	public int getCurrentPage();
	
	/**
	 * ��ǰҳ�ĵ�һ����¼�����ܼ�¼���ǵڼ���
	 * @param startRowPosition ��ǰҳ��Ϊ�ڼ�����¼
	 */
	public void setStartRowPosition(int startRowPosition);
	
	/**
	 * �õ���ǰҳ��ĵ�һ����¼�����ܼ�¼����λ��
	 * @return �ܼ�¼����λ��
	 */
	public int getStartRowPosition();
	
	/**
	 * ���õ�ǰҳ�����һ����¼���ܼ�¼���е�λ��
	 * @param endRowPosition ���ܼ�¼���е�λ��
	 */
	public void setEndRowPosition(int endRowPosition);
	
	/**
	 * ���ص�ǰҳ�����һ����¼���ܼ�¼���е�λ��
	 * @return ���ܼ�¼���е�λ��
	 */
	public int getEndRowPosition();
	
	/**
	 * �õ�����޼�¼��
	 * @return ����޼�¼��
	 */ 
	public int getMaxRecords();
	
	/**
	 * ��������޼�¼��
	 * @param maxRecords ����޼�¼��
	 */
	public void setMaxRecords(int maxRecords);
	
	/**
	 * �ڷ�ҳʱ�м��ҳ����,�����ֵ��Ϊ5,��ôҳ����ֻ��ʾ10��ҳ����,�÷���ֵ����
	 * ȫ�������ļ���hiFrameworkConfig.properties����,������Ϊhi.pageinfo.currnetmiddlepag
	 * @return currnetmiddlepag
	 */
	public int getMiddlePageNum();

}
