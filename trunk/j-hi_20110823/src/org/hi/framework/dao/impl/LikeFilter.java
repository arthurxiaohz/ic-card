package org.hi.framework.dao.impl;

import org.hi.framework.dao.Filter;

public class LikeFilter extends SimpleFilter {
	/**
	 * ֵ�������������%
	 */
	public static int LIKE_CONTROLER_ALL = 0;
	/**
	 * ֵ������%
	 */
	public static int LIKE_CONTROLER_LEFT = 1;
	/**
	 * ֵ���Ҳ��%
	 */
	public static int LIKE_CONTROLER_RIGHT = 2;
	LikeFilter() {}
	
	public Filter addCondition(String name, String val, String op,
			String relation, int controler) {
		
		if(name == null || name.trim().equals("")){
			log.fatal("addCondition method of name  is null");
			return this;	//���nameΪ�ջ�մ���ǰ����������Ч
		}
		if(val == null || !(val instanceof String)){
			log.fatal("NotLikeFilter addCondition method of value  is null or not String");
			return this;	//���valΪ�ջ����Ͳ�ΪString����
		}
		
		FilterBean condition = new FilterBean();
		
		if (relation == null)
			relation = RELATION_AND;
 		
		condition.setRelations(relation);  //���ӹ�ϵ��
		
		if (op == null) 
				op = OPERATOR_LIKE;

		condition.setOperater(op);		//���Ӳ�����
		condition.setValue(val);		//����ֵ
		condition.setLikeControler(controler); //����like�Ŀ���,�� %��λ��
		
		condition.setFieldName(name);		//���ò�ѯ�ֶεĵ��ֶ���
		conditions.add(condition);
		return this;
	}
}
