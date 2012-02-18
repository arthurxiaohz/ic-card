package org.hi.base.sysapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hi.SpringContextHolder;
import org.hi.base.sysapp.model.AppSetting;
import org.hi.base.sysapp.service.AppSettingManager;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;


public class AppSettingHelper {
	/**通过给定的组名与键返回值
	 * @param groupName
	 * @param appKey
	 * @return
	 */
	public static String getValue(String groupName, String appKey){
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		if(appSettingMgr.getSecurityAppSettingToChach() != null){
			List<AppSetting> cache = appSettingMgr.getSecurityAppSettingToChach();
			for (AppSetting appSetting : cache) {
				if(appSetting.getAppGroup().equals(groupName) && appSetting.getAppName().equals(appKey))
					return appSetting.getAppValue();
			}
		}
		Filter filter = FilterFactory.getSimpleFilter("appGroup", groupName, Filter.OPERATOR_EQ)
			.addCondition("appName", appKey, Filter.OPERATOR_EQ);
		List result = appSettingMgr.getObjects(filter);
		
		if(result.size() == 0)
			return null;
		
		AppSetting bean = (AppSetting)result.get(0);
		return bean.getAppValue();
	}
	
	/**
	 * 通过组名返回一组值
	 * @param groupName
	 * @return
	 */
	public static Set<String> getValues(String groupName){
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		
		if(appSettingMgr.getSecurityAppSettingToChach() != null){
			List<AppSetting> cache = appSettingMgr.getSecurityAppSettingToChach();
			Set<String> values = new LinkedHashSet<String>();
 			for (AppSetting appSetting : cache) {
				if(appSetting.getAppGroup().equals(groupName))
					values.add(appSetting.getAppValue());
			}
 			return values;
		}
		
		Filter filter = FilterFactory.getSimpleFilter("appGroup", groupName, Filter.OPERATOR_EQ);
		List settings = appSettingMgr.getObjects(filter);
		
		Set<String> result = new HashSet<String>();
		if(settings.size() == 0)
			return result;
		
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			AppSetting appSetting = (AppSetting) iter.next();
			result.add(appSetting.getAppValue());
			
		}
		return result;
	}
	
	public static List<AppSetting> getGroup(String groupName){
		AppSettingManager appSettingMgr = (AppSettingManager)SpringContextHolder.getBean(AppSetting.class);
		if(appSettingMgr.getSecurityAppSettingToChach() != null){
			List<AppSetting> cache = appSettingMgr.getSecurityAppSettingToChach();
			List<AppSetting> values = new ArrayList<AppSetting>();
 			for (AppSetting appSetting : cache) {
				if(appSetting.getAppGroup().equals(groupName))
					values.add(appSetting);
			}
 			return values;
		}
		
		Filter filter = FilterFactory.getSimpleFilter("appGroup", groupName, Filter.OPERATOR_EQ);
		return (List<AppSetting>)appSettingMgr.getObjects(filter);
	}
	
	public static String getValue(List<AppSetting> group, String appKey){
		for (AppSetting appSetting : group) {
			if(appSetting.getAppName().equals(appKey))
				return appSetting.getAppValue();
		}
		return null;
	}
}
