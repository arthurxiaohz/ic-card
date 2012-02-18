package org.hi.base.tree;

/**
 * 合成（Composite）模式的简单实现接口.在本系统中的作用是如果某业务组件要求是一棵树型
 * 结构则需要实现该接口,来指定该业务组件中的父-子关系,通过这种父子关系,<code>TreeManager</code>
 * 会自动整理出在任何树节点的枝-叶关系.如部门就是一个典型的树型结构关系
 * @author 张昊
 * @since 2007-1-26
 * @see org.hi.base.tree.TreeManager
 *
 */
public interface Component {
	
    /**
     * 在树型结构中该节点的节点名称.
     * 注意:在整个树型结构中节点的名称需求是唯一的,建意为了保证唯一性与业务语义
     * 最好使用当前业务名称+ID的形式.例如HiOrg对该方法的实现为:
     * <p> return this.orgName + ":" + this.id;
     * @return 返回该节点名称
     */
    String getComponentName();
    
    /**
     * 树型结构中该节点的目标对象.
     * 一般来说对应当前业务对象.例如HiOrg对该方法的实现为:
     * <p> return this;
     * @return 返回该节点下目标对象
     */
    Component getTarget();
    
    /**
     * 树型结构中该节点的父目标对象.
     * 一般来说对应当前父业务对象.例如HiOrg对该方法的实现为:
     * <p> return this.parentOrg;
     * @return 返回该节点父目标对象
     */
    Component getTargetParent();
    
}
