package org.hi.base.organization.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.organization.model.HiOrg;
import org.hi.base.organization.model.HiUser;
import org.hi.framework.service.Manager;

public interface HiOrgManager extends Manager{
    /**
     * ���沿��
     * @param hiOrg
     */
    public void saveHiOrg(HiOrg hiOrg);
    /**
     * ��������ɾ������
     * @param id
     */
    public void removeHiOrgById(Integer id);
    /**
     * ����������ѯ����
     * @param id
     * @return
     */
    public HiOrg getHiOrgById(Integer id);
    /**
     * �����б�
     * @param pageInfo
     * @return
     */
    public List<HiOrg> getHiOrgList(PageInfo pageInfo);
    
    public void saveSecurityHiOrg(HiOrg hiOrg);
    public void removeSecurityHiOrgById(Integer id);
    public HiOrg getSecurityHiOrgById(Integer id);
    public List<HiOrg> getSecurityHiOrgList(PageInfo pageInfo);
}
