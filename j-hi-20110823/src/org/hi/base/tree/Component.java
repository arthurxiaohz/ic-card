package org.hi.base.tree;

/**
 * �ϳɣ�Composite��ģʽ�ļ�ʵ�ֽӿ�.�ڱ�ϵͳ�е����������ĳҵ�����Ҫ����һ������
 * �ṹ����Ҫʵ�ָýӿ�,��ָ����ҵ������еĸ�-�ӹ�ϵ,ͨ�����ָ��ӹ�ϵ,<code>TreeManager</code>
 * ���Զ���������κ����ڵ��֦-Ҷ��ϵ.�粿�ž���һ�����͵����ͽṹ��ϵ
 * @author ���
 * @since 2007-1-26
 * @see org.hi.base.tree.TreeManager
 *
 */
public interface Component {
	
    /**
     * �����ͽṹ�иýڵ�Ľڵ�����.
     * ע��:���������ͽṹ�нڵ������������Ψһ��,����Ϊ�˱�֤Ψһ����ҵ������
     * ���ʹ�õ�ǰҵ������+ID����ʽ.����HiOrg�Ը÷�����ʵ��Ϊ:
     * <p> return this.orgName + ":" + this.id;
     * @return ���ظýڵ�����
     */
    String getComponentName();
    
    /**
     * ���ͽṹ�иýڵ��Ŀ�����.
     * һ����˵��Ӧ��ǰҵ�����.����HiOrg�Ը÷�����ʵ��Ϊ:
     * <p> return this;
     * @return ���ظýڵ���Ŀ�����
     */
    Component getTarget();
    
    /**
     * ���ͽṹ�иýڵ�ĸ�Ŀ�����.
     * һ����˵��Ӧ��ǰ��ҵ�����.����HiOrg�Ը÷�����ʵ��Ϊ:
     * <p> return this.parentOrg;
     * @return ���ظýڵ㸸Ŀ�����
     */
    Component getTargetParent();
    
}
