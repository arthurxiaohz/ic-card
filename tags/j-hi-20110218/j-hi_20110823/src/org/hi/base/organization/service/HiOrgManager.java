package org.hi.base.organization.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.service.Manager;

public interface HiOrgManager extends Manager{
    /**
     * 保存部门
     * @param hiOrg
     */
    public void saveHiOrg(HiOrg hiOrg);
    /**
     * 根据主键删除部门
     * @param id
     */
    public void removeHiOrgById(Integer id);
    /**
     * 根据主键查询部门
     * @param id
     * @return
     */
    public HiOrg getHiOrgById(Integer id);
    /**
     * 部门列表
     * @param pageInfo
     * @return
     */
    public List<HiOrg> getHiOrgList(PageInfo pageInfo);
    
    public void saveSecurityHiOrg(HiOrg hiOrg);
    public void removeSecurityHiOrgById(Integer id);
    public HiOrg getSecurityHiOrgById(Integer id);
    public List<HiOrg> getSecurityHiOrgList(PageInfo pageInfo);
}
