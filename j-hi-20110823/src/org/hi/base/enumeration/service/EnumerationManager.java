package org.hi.base.enumeration.service;

import java.util.List;

import org.hi.base.enumeration.model.Enumeration;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public interface EnumerationManager extends Manager{
    /**
     * ����ö��ֵ
     * @param enumeration ö��ʵ����
     */
    public void saveEnumeration(Enumeration enumeration);
    /**
     * ����IDɾ����ö��ֵ
     * @param id ����
     */
    public void removeEnumerationById(Integer id);
    /**
     * ����ID��ö��ֵ
     * @param id ����
     * @return ö��ֵ����
     */
    public Enumeration getEnumerationById(Integer id);
    /**
     * ȡ��ö���б�չʾ������
     * @param pageInfo  ҳ��pojo
     * @return list
     */
    public List<Enumeration> getEnumerationList(PageInfo pageInfo);
    
    /**
     * ��ѯö��ֵ�ļ���
     * @return list
     */
    public List<Enumeration> getEnumerations();  
    /**
     * 
     */
    public void reloadEnumeration();
    
    /**
     * 
     * @param enumeration
     */
    public void saveSecurityEnumeration(Enumeration enumeration);
    /**
     * 
     * @param id
     */
    public void removeSecurityEnumerationById(Integer id);
    /**
     * 
     * @param id
     * @return
     */
    public Enumeration getSecurityEnumerationById(Integer id);
    /**
     * 
     * @param pageInfo
     * @return
     */
    public List<Enumeration> getSecurityEnumerationList(PageInfo pageInfo);
}
