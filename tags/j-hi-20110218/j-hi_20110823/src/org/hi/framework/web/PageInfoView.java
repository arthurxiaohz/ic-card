package org.hi.framework.web;

import org.hi.framework.paging.impl.PageImpl;

/**
 * 
 * @author ���
 * @since 2007-3-3
 *
 */
public class PageInfoView extends PageImpl {
	private static final long serialVersionUID = 7389809057021954833L;
	
	/**
	 * ����ʾҳ����sortBy(sorterName)�����Ѳ�����ֵ��action�е�pageInfo.sorterName��������е�����
	 */
	private String sorterName;
	/**
	 * ͨ��sortBy�����������ֵ����action�е�pageInfo.sorterDirection��������е�����
	 */
	private String sorterDirection;
	
	public String getSorterDirection() {
		return sorterDirection;
	}
	public void setSorterDirection(String sorterDirection) {
		this.sorterDirection = sorterDirection;
	}
	public String getSorterName() {
		return sorterName;
	}
	public void setSorterName(String sorterName) {
		this.sorterName = sorterName;
	}
}

