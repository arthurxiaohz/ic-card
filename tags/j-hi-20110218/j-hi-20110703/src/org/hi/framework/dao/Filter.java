package org.hi.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.hi.framework.dao.impl.FilterBean;
import org.hi.framework.service.Manager;

/**
 * ���ӿ��ǹ淶�������Ĳ�ѯ�����������ǶԵ���Ĺ��˲���
 * <p>���������Ĳ�����ɣ��ֶ�����ֵ�����������ϵ��������ͨ��<code>addCondition</code>����
 * �����ۼӲ�ѯ�������÷����ķ���ֵ�Ļ��ǵ�ǰ��<code>Filter</code>��ʵ�������Կ�����<code>StringBuffer</code>
 * һ���Ĳ�����
 * <p>ע��:Ŀǰ�Ĺ�������֧��between������������ͨ����������<code>addCondition</code>������ʵ��
 * �ù��ܡ�ͬʱ��֧���������������Ӳ�ѯ����ͨ����Ӧ��ORM�ھ����DAO����ʵ�ָù��ܡ�
 * <p>���Ϊ�˹淶������û������<code>addCondition</code>����������Ĺ��أ���Ҳ������ζ�Ŷ�
 * �ڸ÷����еĲ���valһ��Ҫ��Ӧ��Ӧ��POJO�����Ե�����
 * 
 * @author ���
 * @since 2006-11-15
 *
 */
public interface Filter extends Serializable {

    /**
     * ��Ӧ���ݿ��е�like������
     */
    public static final String OPERATOR_LIKE = "LIKE";
    
    /**
     * ��Ӧ���ݿ��е�=������ 
     * URL: %3D
     */
    public static final String OPERATOR_EQ = "=";
    
    /**
     *  ��Ӧ���ݿ��е�<>��!=������
     *  URL: %3C%3E
     */
    public static final String OPERATOR_NOT_EQ = "<>";
    
    /**
     *  ��Ӧ���ݿ��е�>������
     *  URL: %3E
     */
    public static final String OPERATOR_GREATER_THAN = ">";
    
    /**
     *  ��Ӧ���ݿ��е�<������
     *  URL: %3C
     */
    public static final String OPERATOR_LESS_THEN = "<";
    
    /**
     *  ��Ӧ���ݿ��е�>=������
     *  URL: %3E%3D
     */
    public static final String OPERATOR_GREATER_EQ = ">=";
    
    /**
     *  ��Ӧ���ݿ��е�<=������
     *  URL: %3C%3D
     */
    public static final String OPERATOR_LESS_EQ = "<=";
    
    /**
     *  ��Ӧ���ݿ��е�in������,ע�⣺��IN��������ͨ��FilterFactory.getInFilter()����һ��InFilter����
     */
    public static final String OPERATOR_IN = "IN";
    
    /**
     *  ��Ӧ���ݿ��е�and��ϵ��
     */
    public static final String RELATION_AND = "AND";
    
    /**
     * ��Ӧ���ݿ��е�or��ϵ��
     */
    public static final String RELATION_OR = "OR";
    
    /**
     * ��Ӧ���ݿ��е�not��ϵ��
     */
    public static final String RELATION_NOT = "NOT";
    
    
    /**
     * ���ɸѡ����
     * @param name ���ݿ��ֶ��� 
     * @param val �ֶζ�Ӧ��ֵ
     * ע�⣺Ĭ�ϵĲ�����������ַ���ΪLIKE����Ϊ=<br>Ĭ�ϵĹ�ϵ��ΪAND
     * @return ���ص�ǰ������
     */
    public Filter addCondition(String name, Object val);
    
    /**
     * ���ɸѡ����
     * @param name ���ݿ��ֶ��� 
     * @param val �ֶζ�Ӧ��ֵ
     * @param op ������
     * ����ͨ��Filter.OPERATOR_LIKE�Ȼ�ȡ�������ĳ���
     * ע�⣺Ĭ�ϵĹ�ϵ��ΪAND
     * @return ���ص�ǰ������
     */
    public Filter addCondition(String name, Object val, String op);
   
    /**
     * ���ɸѡ����
     * @param name ���ݿ��ֶ��� 
     * @param val �ֶζ�Ӧ��ֵ
     * @param op ������
     * @param relation ��ϵ��
     * ����ͨ��Filter.OPERATOR_LIKE�Ȼ�ȡ�������ĳ���
     * Filter.RELATION_AND�Ȼ�ȡ��ϵ���ĳ���
     * @return ���ص�ǰ������
     */
    public Filter addCondition(String name, Object val, String op ,String relation);
    
    /**
     * �õ�SQL�����Where�Ӿ䲿�ֵ��ַ���
     * @return ���ع����ַ���
     * ע��÷��ص��ַ���������"where"�ַ���
     */
    public String toString();
    
    /**
     * ��õ�ǰ���������������ļ��ϣ��ڼ�����ÿ��Ԫ�ض�һ��<code>ConditionBean</code>
     * <p>����������<code>Filter</code>����Ӧ��ORM��������ת��
     * @return ���ص�ǰ��������������
     * @see org.hi.framework.dao.impl.FilterBean
     */
    public List<FilterBean> getConditions();
    
    /**
     * ����һ����������ӵ���ǰ�Ĺ������У�������������Ĺ�ϵ��ȱʡΪAND���ϵ
     * @param otherfilter ��һ��������
     * @return ���ص�ǰ������
     */
    public Filter addFilter(Filter otherfilter);
    
    /**
     * ����һ����������ӵ���ǰ�Ĺ�������
     * @param otherfilter ��һ��������
     * @param relation ������������Ĺ�ϵ��
     * @return ���ص�ǰ������
     */
    public Filter addFilter(Filter otherFilter, String relation);
    
    /**
     * ɾ����ǰ�������µ��ӹ�����
     * @param subFilter �ӹ�����
     */
    public void removeFilter(Filter subFilter);
    
    public List<List<FilterBean>> getFilterGroup();
    
    public String getAliasName();
    public void setAliasName(String aliasName);
    
    /**
     * ������Filter��Ӧ��SQL���
     * @return ����SQL�����ַ���
     */
    public String getSQL(Manager manger);
}
