package org.hi.base.enumeration.service;

import java.util.List;

import org.hi.base.enumeration.model.Enumeration;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public interface EnumerationManager extends Manager{
    /**
     * 保存枚举值
     * @param enumeration 枚举实体类
     */
    public void saveEnumeration(Enumeration enumeration);
    /**
     * 根据ID删除此枚举值
     * @param id 主键
     */
    public void removeEnumerationById(Integer id);
    /**
     * 根据ID查枚举值
     * @param id 主键
     * @return 枚举值对象
     */
    public Enumeration getEnumerationById(Integer id);
    /**
     * 取得枚举列表展示的数据
     * @param pageInfo  页面pojo
     * @return list
     */
    public List<Enumeration> getEnumerationList(PageInfo pageInfo);
    
    /**
     * 查询枚举值的集合
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
