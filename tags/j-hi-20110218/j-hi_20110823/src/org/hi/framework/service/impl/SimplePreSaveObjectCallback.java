package org.hi.framework.service.impl;

import java.util.Date;

import org.hi.common.util.BeanUtil;
import org.hi.framework.service.PreSaveObjectCallback;

public class SimplePreSaveObjectCallback implements PreSaveObjectCallback {

	public void savePreObjectProcess(Object obj) {
		
	}
	
//	��updateDate���һ���޸�����Ϊ��,ֻҪPOJO����������Ծͻ��ڱ���֮ǰ
//	�������Ե�ֵ��Ϊ��ǰ����
//	public void savePreObjectProcess(Object obj) {
//		
//		if(BeanUtil.hasPropertyName(obj, "updateDate")){
//			BeanUtil.setPropertyValue(obj, "updateDate", new Date());  //����ǰϵͳ���ڵ�ֵ����POJO�е�updateDate������
//		}
//	}
	
	

}
