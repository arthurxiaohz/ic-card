package org.hi.framework.dao.impl;

import java.io.Serializable;

import org.hi.base.organization.model.HiUser;

/**
 * 该类只是一个简单的POJO，作为存储过滤器的容器其目的是对于不同的ORM做为一个中间数据层以使本框架
 * 在不同的ORM中转换数据。
 * <p>注意：<code>Sorter</code>没有提供类似的容器,因为排序器本身已提供这样容器的功能
 * @author 张昊
 * @since 2006-11-16
 * @see org.hi.framework.dao.Filter
 * @see org.hi.framework.dao.Sorter
 *
 */
public class FilterBean implements Serializable{
		
		/**
		 * 数据库表的字段名
		 */
		private String fieldName;

		/**
		 * 值
		 */
		private Object value;

		/**
		 * 操作符
		 */
		private String operater;

		/**
		 * 关系符
		 */
		private String relations;
		
		private boolean not;
		
		/**
		 * like的控制器,即加%的位置
		 * @see org.hi.framework.dao.impl.LikeFilter
		 */
		private int likeControler;
		
		/**
		 * 获得字段名
		 * @return 字段名
		 */
		public String getFieldName() {
			return fieldName;
		}

		/**
		 * 设置字段名
		 * @param fieldName 字段名
		 */
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		/**
		 * 获得操作符
		 * @return 操作符
		 */
		public String getOperater() {
			return operater;
		}

		/**
		 * 设置操作符
		 * @param operater 操作符
		 */
		public void setOperater(String operater) {
			this.operater = operater;
		}

		/**
		 * 获得关系符
		 * @return 关系符
		 */
		public String getRelations() {
			return relations;
		}

		/**
		 * 设置关系符
		 * @param relations 关系符
		 */
		public void setRelations(String relations) {
			this.relations = relations;
		}

		/**
		 * 获得值
		 * @return 值
		 */
		public Object getValue() {
			return value;
		}

		/**
		 * 设置值
		 * @param value 值
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
