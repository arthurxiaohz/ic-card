package org.hi.base.sysapp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hi.SpringContextHolder;
import org.hi.framework.HiConfigHolder;
import org.hi.framework.dao.Filter;
import org.hi.framework.dao.impl.FilterFactory;
import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.YesNo;
import org.hi.base.sysapp.model.Helper;
import org.hi.base.sysapp.model.HelperRef;
import org.hi.framework.service.impl.ManagerImpl;
import org.hi.base.sysapp.service.HelperManager;
import org.hi.common.util.BeanUtil;
import org.hi.common.util.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;

public class HelperManagerImpl extends ManagerImpl implements HelperManager,InitializingBean{
    List<Helper> helpers = Collections.synchronizedList(new ArrayList<Helper>());
	
    protected void preSaveObject(Object obj) {
        super.preSaveObject(obj);

    }

    protected void postSaveObject(Object obj) {
//    	发布模式，在更新数据后同步缓存
		if(HiConfigHolder.getPublished() && HiConfigHolder.getHelper().equals("true")){
			Helper helper = new Helper();
			BeanUtil.setBean2Bean(obj, helper);
			
			for (Helper _helper : helpers) {
				synchronized(_helper){
					if(_helper.getId().equals(helper.getId())){
						_helper = helper;
						super.postSaveObject(obj);
						return;
					}
				}
			}
			
			helpers.add(helper);
		}
    	super.postSaveObject(obj);

    }

    protected void preRemoveObject(Object obj) {
        super.preRemoveObject(obj);
        
    }

    protected void postRemoveObject(Object obj) {
//    	发布模式，在删除数据后同步缓存
		if(HiConfigHolder.getPublished() && HiConfigHolder.getHelper().equals("true")){
			Helper helper = (Helper)obj;
			for (Helper _helper : helpers) {
				synchronized (_helper) {
					if(_helper.getId().equals(helper.getId())){
						helpers.remove(_helper);
						break;
					}
				}
			}
		}
    	
        super.postRemoveObject(obj);
        
    }
    
    public void saveHelper(Helper helper){
    	saveObject(helper);
    
    }

    public void removeHelperById(Integer id){
    	removeObjectById(id);
    	
    }

    public Helper getHelperById(Integer id){
   		return (Helper) getObjectById(id);
    }

    public List<Helper> getHelperList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

    public void saveSecurityHelper(Helper helper){
    	saveObject(helper);
    
    }

    public void removeSecurityHelperById(Integer id){
    	removeObjectById(id);
    	
    }

    public Helper getSecurityHelperById(Integer id){
   		return (Helper) getObjectById(id);
    }

    public List<Helper> getSecurityHelperList(PageInfo pageInfo){
    	return super.getList(pageInfo);
    }

	public void afterPropertiesSet() throws Exception {
		if(!HiConfigHolder.getPublished())
			return;
		if(!HiConfigHolder.getHelper().equals("true"))
			return;
		
		 List<Helper> _helpers = this.getObjects();
		 for (Helper _helper : _helpers) {
			 Helper helper = new Helper();
			 BeanUtil.setBean2Bean(_helper, helper);
			 helpers.add(helper);
		 }
		 
		 for (Helper helper : helpers) {
			 List<HelperRef> helperRefs = helper.getHelperRefs();
			 if(helperRefs == null) continue;
			 for (HelperRef helperRef : helperRefs) {
				 Helper refHelper = (Helper)CollectionUtils.getElementByPropertyValue(helpers, "id", helperRef.getRefHelper().getId());
				 helperRef.setRefHelper(refHelper);
				 helperRef.setHelper(helper);
			}
		}
	}
	
	public Helper getRefHelper(String url){
		if(url == null || url.equals(""))
			return null;
		
		String uri = url;
		if(url.indexOf("?")>0){
			uri = url.substring(0, url.indexOf("?"));
		}
		
		if(HiConfigHolder.getPublished()){
			for (Helper helper : helpers) {
				if(helper.getIsWithPara() == YesNo.YESNO_YES && helper.getUrlAction().equals(url)){
						return helper;
				}
				
				if(helper.getIsWithPara() == YesNo.YESNO_NO && helper.getUrlAction().contains(uri))
					return helper;
			}
		}
		else{
			Filter filter = FilterFactory.getSimpleFilter("urlAction", uri)
				.addCondition("activeHelp",YesNo.YESNO_YES);
			List<Helper> helpers = this.getObjects(filter);
			for (Helper helper : helpers) {
				if(helper.getIsWithPara() == YesNo.YESNO_YES){
					if(helper.getUrlAction().equals(url))
						return helper;
				}
				
				if(helper.getIsWithPara() == YesNo.YESNO_NO)
					return helper;
			}
		}
		
		return null;
	}
	
	
	public Helper getLinkHelper(Helper helper){
		if(HiConfigHolder.getPublished()){
			for (Helper _helper : helpers){
				if(helper.getId().equals(helper.getId()))
					return _helper;
			}
		}
		else{
			return this.getHelperById(helper.getId());
			
		}
		
		return null;
	}
}
