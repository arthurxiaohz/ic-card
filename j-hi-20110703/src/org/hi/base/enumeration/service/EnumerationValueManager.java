package org.hi.base.enumeration.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.framework.service.Manager;

public interface EnumerationValueManager extends Manager{
    /**
     * ����ö��ֵ
     * @param enumerationValue ö��ֵ����
     */
    public void saveEnumerationValue(EnumerationValue enumerationValue);

    /**
     * ��������ɾ��ö��ֵ����
     * @param id ����
     */
    public void removeEnumerationValueById(Integer id);
    /**
     * ����������ѯö��ֵ����
     * @param id ����
     * @return 
     */
    public EnumerationValue getEnumerationValueById(Integer id);
    /**
     * ����ö��ֵ�б�
     * @param pageInfo
     * @return
     */
    public List<EnumerationValue> getEnumerationValueList(PageInfo pageInfo);

    public void saveSecurityEnumerationValue(EnumerationValue enumerationValue);
    public void removeSecurityEnumerationValueById(Integer id);
    public EnumerationValue getSecurityEnumerationValueById(Integer id);
    public List<EnumerationValue> getSecurityEnumerationValueList(PageInfo pageInfo);
}
