package org.hi.base.schedule.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.framework.service.Manager;

public interface TriggerDefManager extends Manager{
	/**
	 * 
	 * 新增/修改保存触发器
	 */
    public void saveTriggerDef(TriggerDef triggerDef);
    /**
     * 删除触发器
     * @param id
     */
    public void removeTriggerDefById(Integer id);
   /**
    * 查询触发器
    * @param id
    * @return
    */
    public TriggerDef getTriggerDefById(Integer id);
    /**
     * 触发器列表
     * @param pageInfo
     * @return
     */
    public List<TriggerDef> getTriggerDefList(PageInfo pageInfo);
    
    public void saveSecurityTriggerDef(TriggerDef triggerDef);
    public void removeSecurityTriggerDefById(Integer id);
    public TriggerDef getSecurityTriggerDefById(Integer id);
    public List<TriggerDef> getSecurityTriggerDefList(PageInfo pageInfo);
}
