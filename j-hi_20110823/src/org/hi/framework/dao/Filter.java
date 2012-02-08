package org.hi.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.hi.framework.dao.impl.FilterBean;
import org.hi.framework.service.Manager;

/**
 * 本接口是规范面向对象的查询过滤条件，是对单表的过滤操作
 * <p>过滤器由四部分组成：字段名、值、操作符与关系符，可以通过<code>addCondition</code>方法
 * 不断累加查询条件，该方法的返回值的还是当前的<code>Filter</code>的实例，所以可以象<code>StringBuffer</code>
 * 一样的操作。
 * <p>注意:目前的过滤器不支持between操作，但可以通过调用两次<code>addCondition</code>方法来实现
 * 该功能。同时不支持左、右外连接与子查询，可通过相应的ORM在具体的DAO类中实现该功能。
 * <p>最后，为了规范编码我没有做参<code>addCondition</code>方法做多余的过载，这也就是意味着对
 * 于该方法中的参数val一定要对应相应的POJO中属性的类型
 * 
 * @author 张昊
 * @since 2006-11-15
 *
 */
public interface Filter extends Serializable {

    /**
     * 对应数据库中的like操作符
     */
    public static final String OPERATOR_LIKE = "LIKE";
    
    /**
     * 对应数据库中的=操作符 
     * URL: %3D
     */
    public static final String OPERATOR_EQ = "=";
    
    /**
     *  对应数据库中的<>或!=操作符
     *  URL: %3C%3E
     */
    public static final String OPERATOR_NOT_EQ = "<>";
    
    /**
     *  对应数据库中的>操作符
     *  URL: %3E
     */
    public static final String OPERATOR_GREATER_THAN = ">";
    
    /**
     *  对应数据库中的<操作符
     *  URL: %3C
     */
    public static final String OPERATOR_LESS_THEN = "<";
    
    /**
     *  对应数据库中的>=操作符
     *  URL: %3E%3D
     */
    public static final String OPERATOR_GREATER_EQ = ">=";
    
    /**
     *  对应数据库中的<=操作符
     *  URL: %3C%3D
     */
    public static final String OPERATOR_LESS_EQ = "<=";
    
    /**
     *  对应数据库中的in操作符,注意：做IN操作必须通过FilterFactory.getInFilter()创建一个InFilter对象
     */
    public static final String OPERATOR_IN = "IN";
    
    /**
     *  对应数据库中的and关系符
     */
    public static final String RELATION_AND = "AND";
    
    /**
     * 对应数据库中的or关系符
     */
    public static final String RELATION_OR = "OR";
    
    /**
     * 对应数据库中的not关系符
     */
    public static final String RELATION_NOT = "NOT";
    
    
    /**
     * 添加筛选条件
     * @param name 数据库字段名 
     * @param val 字段对应的值
     * 注意：默认的操作符如果是字符串为LIKE否则为=<br>默认的关系符为AND
     * @return 返回当前过滤器
     */
    public Filter addCondition(String name, Object val);
    
    /**
     * 添加筛选条件
     * @param name 数据库字段名 
     * @param val 字段对应的值
     * @param op 操作符
     * 可以通过Filter.OPERATOR_LIKE等获取操作符的常量
     * 注意：默认的关系符为AND
     * @return 返回当前过滤器
     */
    public Filter addCondition(String name, Object val, String op);
   
    /**
     * 添加筛选条件
     * @param name 数据库字段名 
     * @param val 字段对应的值
     * @param op 操作符
     * @param relation 关系符
     * 可以通过Filter.OPERATOR_LIKE等获取操作符的常量
     * Filter.RELATION_AND等获取关系符的常量
     * @return 返回当前过滤器
     */
    public Filter addCondition(String name, Object val, String op ,String relation);
    
    /**
     * 得到SQL语句中Where子句部分的字符串
     * @return 返回过滤字符串
     * 注意该返回的字符串不包含"where"字符串
     */
    public String toString();
    
    /**
     * 获得当前过滤器所有条件的集合，在集合中每个元素都一个<code>ConditionBean</code>
     * <p>其作用是在<code>Filter</code>与相应的ORM中做数据转换
     * @return 返回当前过滤器条件集合
     * @see org.hi.framework.dao.impl.FilterBean
     */
    public List<FilterBean> getConditions();
    
    /**
     * 将另一个过滤器添加到当前的过滤器中，两个过滤器间的关系符缺省为AND与关系
     * @param otherfilter 另一个过滤器
     * @return 返回当前过滤器
     */
    public Filter addFilter(Filter otherfilter);
    
    /**
     * 将另一个过滤器添加到当前的过滤器中
     * @param otherfilter 另一个过滤器
     * @param relation 两个过滤器间的关系符
     * @return 返回当前过滤器
     */
    public Filter addFilter(Filter otherFilter, String relation);
    
    /**
     * 删除当前过滤器下的子过滤器
     * @param subFilter 子过滤器
     */
    public void removeFilter(Filter subFilter);
    
    public List<List<FilterBean>> getFilterGroup();
    
    public String getAliasName();
    public void setAliasName(String aliasName);
    
    /**
     * 获得与该Filter相应的SQL语句
     * @return 返回SQL语句的字符串
     */
    public String getSQL(Manager manger);
}
