package org.hi.framework.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hi.framework.dao.Sorter;

/**
 * 
 * @author 张昊
 * @since 2006-11-15
 *
 */
class SimpleSorter implements Sorter {

	private StringBuffer strBuf = new StringBuffer();
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 排序集合，其作用是Sorter与相应的ORM中做数据转换
	 */
	private Map<String, String> sorts = new LinkedHashMap<String, String>();
	
	/**
	 * 用于排序个数的计算器
	 */
	private int n = 0 ;
	

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Sorter#addSort(java.lang.String)
	 */
	public Sorter addSort(String name){
		if(name == null || name.trim().equals("")){
			log.fatal("addSort method of name is null");
			return this;	//如果name为空或空串则当前方法操作无效
		}
			
		return addSort(name,ORDER_ASC);
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Sorter#addSort(java.lang.String, java.lang.String)
	 */
	public Sorter addSort(String name,String direction){
		
		if(name == null || name.trim().equals("")){
			log.fatal("addSort method of name is null");
			return this;	//如果name为空或空串则当前方法操作无效
		}
		
		if(direction == null)
			direction = ORDER_ASC;
		
		if(n>0) strBuf.append(" ,");
		n++;
		sorts.put(name, direction);
		strBuf.append(name).append(" ").append(direction);
		return this;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return strBuf.toString();
	}

	/* (non-Javadoc)
	 * @see org.hi.framework.dao.Sorter#getSorts()
	 */
	public Map<String, String> getSorts() {
		return sorts;
	}
}
