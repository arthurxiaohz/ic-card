package org.hi.base.enumeration.service;

import java.util.List;

import org.hi.framework.paging.PageInfo;
import org.hi.base.enumeration.model.Enumeration;
import org.hi.base.enumeration.model.EnumerationValue;
import org.hi.framework.service.Manager;

public interface EnumerationValueManager extends Manager{
    /**
     * 保存枚举值
     * @param enumerationValue 枚举值对象
     */
    public void saveEnumerationValue(EnumerationValue enumerationValue);

    /**
     * 根据主键删除枚举值对象
     * @param id 主键
     */
    public void removeEnumerationValueById(Integer id);
    /**
     * 根据主键查询枚举值对象
     * @param id 主键
     * @return 
     */
    public EnumerationValue getEnumerationValueById(Integer id);
    /**
     * 返回枚举值列表
     * @param pageInfo
     * @return
     */
    public List<EnumerationValue> getEnumerationValueList(PageInfo pageInfo);

    public void saveSecurityEnumerationValue(EnumerationValue enumerationValue);
    public void removeSecurityEnumerationValueById(Integer id);
    public EnumerationValue getSecurityEnumerationValueById(Integer id);
    public List<EnumerationValue> getSecurityEnumerationValueList(PageInfo pageInfo);
}
