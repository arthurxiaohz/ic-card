package org.hi.base.schedule.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.report.excel.model.ExcelCell;
import org.hi.base.schedule.model.TriggerDef;
import org.hi.framework.service.Manager;

public interface TriggerDefManager extends Manager{
	/**
	 * 
	 * ����/�޸ı��津����
	 */
    public void saveTriggerDef(TriggerDef triggerDef);
    /**
     * ɾ��������
     * @param id
     */
    public void removeTriggerDefById(Integer id);
   /**
    * ��ѯ������
    * @param id
    * @return
    */
    public TriggerDef getTriggerDefById(Integer id);
    /**
     * �������б�
     * @param pageInfo
     * @return
     */
    public List<TriggerDef> getTriggerDefList(PageInfo pageInfo);
    
    public void saveSecurityTriggerDef(TriggerDef triggerDef);
    public void removeSecurityTriggerDefById(Integer id);
    public TriggerDef getSecurityTriggerDefById(Integer id);
    public List<TriggerDef> getSecurityTriggerDefList(PageInfo pageInfo);
}
