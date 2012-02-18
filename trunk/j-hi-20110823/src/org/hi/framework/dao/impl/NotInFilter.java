package org.hi.framework.dao.impl;

import java.util.Collection;
import java.util.Iterator;

import org.hi.framework.dao.Filter;
import org.hi.framework.dao.NotFilter;

public class NotInFilter extends InFilter implements NotFilter {
	NotInFilter() {}
	/**
	 * ���ɸѡ����
     * @param name ���ݿ��ֶ��� 
     * @param val �ֶζ�Ӧ��ֵ�����ͱ�����<code>Collection</code>������
     * @param op ������
     * @param relation ��ϵ��
     * ע�⣺�ڱ�����ֻ����op(������)������Ϊ��ֵ,ϵͳ�������дΪIN���ض�������,������null
     * <p><code>Filter.OPERATOR_IN</code>
     * @return ���ص�ǰ������
	 */
	public InFilter addCondition(String name, Object val, String op,
			String relation) {
		super.addCondition(name, val, op, relation);
		FilterBean condition = conditions.get(conditions.size() -1);
		condition.setNot(true);
		
		return this;
	}
}
