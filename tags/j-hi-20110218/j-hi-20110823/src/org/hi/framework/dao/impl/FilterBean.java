package org.hi.framework.dao.impl;

import java.io.Serializable;

import org.hi.base.organization.model.HiUser;

/**
 * ����ֻ��һ���򵥵�POJO����Ϊ�洢��������������Ŀ���Ƕ��ڲ�ͬ��ORM��Ϊһ���м����ݲ���ʹ�����
 * �ڲ�ͬ��ORM��ת�����ݡ�
 * <p>ע�⣺<code>Sorter</code>û���ṩ���Ƶ�����,��Ϊ�������������ṩ���������Ĺ���
 * @author ���
 * @since 2006-11-16
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.Sorter
 *
 */
public class FilterBean implements Serializable{
		
		/**
		 * ���ݿ����ֶ���
		 */
		private String fieldName;

		/**
		 * ֵ
		 */
		private Object value;

		/**
		 * ������
		 */
		private String operater;

		/**
		 * ��ϵ��
		 */
		private String relations;
		
		private boolean not;
		
		/**
		 * like�Ŀ�����,����%��λ��
		 * @see org.hi.framework.dao.impl.LikeFilter
		 */
		private int likeControler;
		
		/**
		 * ����ֶ���
		 * @return �ֶ���
		 */
		public String getFieldName() {
			return fieldName;
		}

		/**
		 * �����ֶ���
		 * @param fieldName �ֶ���
		 */
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		/**
		 * ��ò�����
		 * @return ������
		 */
		public String getOperater() {
			return operater;
		}

		/**
		 * ���ò�����
		 * @param operater ������
		 */
		public void setOperater(String operater) {
			this.operater = operater;
		}

		/**
		 * ��ù�ϵ��
		 * @return ��ϵ��
		 */
		public String getRelations() {
			return relations;
		}

		/**
		 * ���ù�ϵ��
		 * @param relations ��ϵ��
		 */
		public void setRelations(String relations) {
			this.relations = relations;
		}

		/**
		 * ���ֵ
		 * @return ֵ
		 */
		public Object getValue() {
			return value;
		}

		/**
		 * ����ֵ
		 * @param value ֵ
		 */
		public void setValue(Object value) {
			this.value = value;
		}

		public boolean isNot() {
			return not;
		}

		public void setNot(boolean not) {
			this.not = not;
		}

		public int getLikeControler() {
			return likeControler;
		}

		public void setLikeControler(int likeControler) {
			this.likeControler = likeControler;
		}
		
		@Override
		public boolean equals(Object other) {
	         if ( (this == other ) ) return true;
			 if ( (other == null ) ) return false;
			 if ( !(other instanceof FilterBean) ) return false;
			 FilterBean castOther = ( FilterBean ) other; 
			 if(this.value != castOther.value) return false;
			 if(this.fieldName != castOther.fieldName) return false;
			 
			 return this.not == castOther.not && this.likeControler == castOther.likeControler  && 
			 			this.operater == castOther.operater && this.relations == castOther.relations && 
			 			(this.fieldName == castOther.fieldName || this.fieldName.equals(castOther.fieldName)) && 
			 			(this.value == castOther.value || this.value.equals(castOther.value));
		}
	}
