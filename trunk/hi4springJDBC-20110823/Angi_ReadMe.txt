反编译于平台hi4springJDBC-20110823版本

修改bug
1、用户（非sa）在角色查询（权限为用户级）中看到了不是他创建的角色 
RoleListAction中没有调用getSecurityRoleList()，而是调用的getRoleList()，见拦截器ResourceBindleMethodSecurityInterceptor 
这个问题在j-hi-20110703和j-hi-20110823中都未解决 

2、角色编辑中用户（非sa）不可以编辑自己创建的角色 
RoleAction.viewRole()中判断有误 
这个问题在j-hi-20110703中未得到解决，但是j-hi-20110823中已解决

3、dao中乐观锁实现时，如果数据过期，追加抛出BusinessException，而不是仅打印日志
org.hi.framework.dao.ibatis.BaseDAOIbatis
org.hi.framework.dao.ibatis3.BaseDAOIbatis

4、角色定义页面，选择部门时，应该控制为其可见的部门
org.hi.framework.security.action.struts.RoleAction.getOrgs()

5、权限范围的传递没有延续性，比如用户a仅具有某个查询的部门级范围，但是他却可以分配给用户b某个查询的所有范围
org.hi.framework.web.taglib.SelectTag
hi.tld
org.hi.framework.security.action.struts.RoleAction.getRoleAuthority(List<Authority>)

