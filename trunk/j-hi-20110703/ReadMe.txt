官方下载原版j-hi-20110703

从hi4springJDBC-20110823平台中提取xml配置文件并添加

修改bug
1、角色查询（用户级）中用户（非sa）看到了不是他创建的角色 
RoleListAction中没有调用getSecurityRoleList()，而是调用的getRoleList()，见拦截器ResourceBindleMethodSecurityInterceptor 
这个问题在j-hi-20110703和j-hi-20110823中都未解决 
2、角色编辑中用户（非sa）不可以编辑自己创建的角色 
RoleAction.viewRole()中判断有误 
这个问题在j-hi-20110703中未得到解决，但是j-hi-20110823中已解决 
3、dao中乐观锁实现时，如果数据过期，抛出BusinessException，而不是仅打印日志