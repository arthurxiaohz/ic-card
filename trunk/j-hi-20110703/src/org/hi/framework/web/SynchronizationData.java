package org.hi.framework.web;

/**
 * 该接口为标识接口,没有任何声明方法.
 * <p>目的：使表现层的数据与持久层的数据进行数据同步
 * <p>注意：如果想对***Action类中的成员属性做数据同步,那么这个action类必须实现
 * 该接口;成员属性可以是一个POJO或一个集合,但无论是POJO还是集合中的元素其类必须继承
 * <code>BaseObject</code>类,即集合元素或POJO类必须是<code>BaseObject</code>
 * 的子孙类
 * <p>原理：在执行action中的方法之前均要通过一个前置拦截器,拦截器只会拦截那些实现该接口
 * 的action类,然后对这个action对象的成员属性逐一与数据库(持久层)做数据同步.规则为如果主
 * 键为空就创建一个POJO,否则从数据库中load出该记录并将action中当前属性的域值逐一赋值到
 * load中来的对象中
 * 
 * @see org.hi.framework.model.BaseObject
 * @see org.hi.framework.web.webwork.LoadObjectInterceptor
 * @author 张昊
 * @since 2007-09-19
 */
public interface SynchronizationData {}
