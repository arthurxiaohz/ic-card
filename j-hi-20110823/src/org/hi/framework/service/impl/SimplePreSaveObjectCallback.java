package org.hi.framework.service.impl;

import java.util.Date;

import org.hi.common.util.BeanUtil;
import org.hi.framework.service.PreSaveObjectCallback;

public class SimplePreSaveObjectCallback implements PreSaveObjectCallback {

	public void savePreObjectProcess(Object obj) {
		
	}
	
//	在updateDate最后一次修改日期为例,只要POJO中有这个属性就会在保存之前
//	将该属性的值设为当前日期
//	public void savePreObjectProcess(Object obj) {
//		
//		if(BeanUtil.hasPropertyName(obj, "updateDate")){
//			BeanUtil.setPropertyValue(obj, "updateDate", new Date());  //将当前系统日期的值赋到POJO中的updateDate属性中
//		}
//	}
	
	

}
