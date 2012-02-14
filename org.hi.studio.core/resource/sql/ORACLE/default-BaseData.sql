CREATE SEQUENCE HIBERNATE_SEQUENCE MINVALUE 1 MAXVALUE 999999999999999999999999 INCREMENT BY 1 NOCYCLE
/---增加个人设置菜单链接
delete from MenuLink where ID = 2701;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2701, 0, '/securityUserList.action', '用户管理', '用户管理', 2999, 9999, 2000, 0, 0);
/---
delete from MenuLink where ID = 1200;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(1200, 0, '/personalSettingView.action', '个人设置', '个人设置', 1200, 9999, 1000, 0, 0);
/---
delete from MenuLink where ID = 2200;
/---
delete from MenuLink where ID = 2400;
/---
delete from MenuLink where ID = 2500;
/---
delete from MenuLink where ID = 2600;
/---
delete from MenuLink where ID = 2700;
/---
delete from MenuLink where ID = 12100;
/---
delete from MenuLink where ID = 12200;

/---任务管理
delete from HiMenu where ID = 4000;
/--
delete from MenuLink where ID = 4000;
/---
delete from MenuLink where ID = 4100;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(4100, 0, '/triggerDefList.action', '触发器', '触发器', 4100, 9999, 5000, 1, 0);
/---权限
delete from MenuLink where ID = 2000;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2000, 0, '/authorityList.action', '权限', '权限', 2000, 9999, 2000,1, 0);
/---权限资源
delete from MenuLink where ID = 2800;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2800, 0, '/privilegeResourceList.action', '权限资源', '权限资源', 2800, 9999, 2000, 1, 0);
/---消息
delete from MenuLink where ID = 5100;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(5100, 0, '/messageList.action', '消息', '消息', 5100, 9999, 5000,1, 0);
/---消息参数
delete from MenuLink where ID = 5200;

/---增加sa超级管理员用户
delete from Hi_User where ID=1;
/---
insert  into Hi_User(id,version,userName,password,country,timeZone,accountEnabled,accountLocked,expiredDate,credentialsExpired,fullName,org,gender,address,phone,mobile,zip,SSN,mail,userMgrType,description,creator,deleted) values (1,52,'sa','c12e01f2a13ff5587e1e9e4aedb8242d',NULL,NULL,NULL,NULL,NULL,NULL,'administrator',1,NULL,'ss12','12','','',NULL,'',1400,NULL,NULL,0);

/---将性别、用户类型、权限范围、是否枚举设为系统级
delete from Enumeration where ID = 1200;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1200, 0, 'gender', '性别', '性别', 1, 0);
/---
delete from Enumeration where ID = 1400;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1400, 0, 'userType', '用户类型', '用户类型', 1, 0);
/---
delete from Enumeration where ID = 2900;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(2900, 0, 'securityScope', '权限范围', '权限范围', 1, 0);
/---
delete from Enumeration where ID = 3200;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(3200, 0, 'yesNo', '是否', '是否', 1, 0);

/---增加系统管理权限
delete from HI_Authority where ID = 2999;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2999, 0, 'SYSTEM_USER_MANAGE', '用户管理', '', '用户管理', 0, 2701);
/---权限
delete from HI_Authority where ID = 2000;
/---
delete from HI_Authority where ID = 2001;
/---
delete from HI_Authority where ID = 2002;
/---
delete from HI_Authority where ID = 2003;
/---
delete from HI_Authority where ID = 2004;
/---用户角色
delete from HI_Authority where ID = 2400;
/---
delete from HI_Authority where ID = 2401;
/---
delete from HI_Authority where ID = 2402;
/---
delete from HI_Authority where ID = 2403;
/---
delete from HI_Authority where ID = 2404;
/---用户组
delete from HI_Authority where ID = 2200;
/---
delete from HI_Authority where ID = 2201;
/---
delete from HI_Authority where ID = 2202;
/---
delete from HI_Authority where ID = 2203;
/---
delete from HI_Authority where ID = 2204;
/---用户与组
delete from HI_Authority where ID = 2500;
/---
delete from HI_Authority where ID = 2501;
/---
delete from HI_Authority where ID = 2502;
/---
delete from HI_Authority where ID = 2503;
/---
delete from HI_Authority where ID = 2504;
/---角色权限
delete from HI_Authority where ID = 2600;
/---
delete from HI_Authority where ID = 2601;
/---
delete from HI_Authority where ID = 2602;
/---
delete from HI_Authority where ID = 2603;
/---
delete from HI_Authority where ID = 2604;
/---组与角色
delete from HI_Authority where ID = 2700;
/---
delete from HI_Authority where ID = 2701;
/---
delete from HI_Authority where ID = 2702;
/---
delete from HI_Authority where ID = 2703;
/---
delete from HI_Authority where ID = 2704;
/---权限资源
delete from HI_Authority where ID = 2900;
/---
delete from HI_Authority where ID = 2901;
/---
delete from HI_Authority where ID = 2902;
/---
delete from HI_Authority where ID = 2903;
/---
delete from HI_Authority where ID = 2904;
/---日志的带回与保存
delete from HI_Authority where ID = 5402;
/---
delete from HI_Authority where ID = 5404;

/---权限
delete from HI_PrivilegeResource where ID = 2000;
/---
delete from HI_PrivilegeResource where ID = 2001;
/---
delete from HI_PrivilegeResource where ID = 2002;
/---
delete from HI_PrivilegeResource where ID = 2003;
/---
delete from HI_PrivilegeResource where ID = 2004;
/---用户组
delete from HI_PrivilegeResource where ID = 2200;
/---
delete from HI_PrivilegeResource where ID = 2201;
/---
delete from HI_PrivilegeResource where ID = 2202;
/---
delete from HI_PrivilegeResource where ID = 2203;
/---
delete from HI_PrivilegeResource where ID = 2204;
/---用户角色
delete from HI_PrivilegeResource where ID = 2400;
/---
delete from HI_PrivilegeResource where ID = 2401;
/---
delete from HI_PrivilegeResource where ID = 2402;
/---
delete from HI_PrivilegeResource where ID = 2403;
/---
delete from HI_PrivilegeResource where ID = 2404;
/---用户与组
delete from HI_PrivilegeResource where ID = 2500;
/---
delete from HI_PrivilegeResource where ID = 2501;
/---
delete from HI_PrivilegeResource where ID = 2502;
/---
delete from HI_PrivilegeResource where ID = 2503;
/---
delete from HI_PrivilegeResource where ID = 2504;
/---角色权限
delete from HI_PrivilegeResource where ID = 2600;
/---
delete from HI_PrivilegeResource where ID = 2601;
/---
delete from HI_PrivilegeResource where ID = 2602;
/---
delete from HI_PrivilegeResource where ID = 2603;
/---
delete from HI_PrivilegeResource where ID = 2604;
/---组与角色
delete from HI_PrivilegeResource where ID = 2700;
/---
delete from HI_PrivilegeResource where ID = 2701;
/---
delete from HI_PrivilegeResource where ID = 2702;
/---
delete from HI_PrivilegeResource where ID = 2703;
/---
delete from HI_PrivilegeResource where ID = 2704;
/---权限资源
delete from HI_PrivilegeResource where ID = 2900;
/---
delete from HI_PrivilegeResource where ID = 2901;
/---
delete from HI_PrivilegeResource where ID = 2902;
/---
delete from HI_PrivilegeResource where ID = 2903;
/---
delete from HI_PrivilegeResource where ID = 2904;
/---日志的带回与保存
delete from HI_PrivilegeResource where ID = 5402;
/---
delete from HI_PrivilegeResource where ID = 5404;

/---系统用应用配置
delete from Hi_AppSetting;
/---
insert into Hi_AppSetting(id,version, appGroup, appName, appValue,description, creator) values(1, 0, 'HOSTING', 'WEB_HOSTING', 'http://localhost:8080', '应用服务器地址', 0);


/---附件内容全部删除
delete from HiMenu where ID = 6000;
/---
delete from MenuLink where ID = 6000;
/---
delete from HI_Authority where ID = 6000;
/---
delete from HI_Authority where ID = 6001;
/---
delete from HI_Authority where ID = 6002;
/---
delete from HI_Authority where ID = 6003;
/---
delete from HI_Authority where ID = 6004;
/---
delete from HI_PrivilegeResource where ID = 6000;
/---
delete from HI_PrivilegeResource where ID = 6001;
/---
delete from HI_PrivilegeResource where ID = 6002;
/---
delete from HI_PrivilegeResource where ID = 6003;
/---
delete from HI_PrivilegeResource where ID = 6004;

/---初始化多语言数据
delete from HI_Language where id =3;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(3, 5, '查询条件', null, '', 1, 1);
/---
delete from HI_Language where id =4;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(4, 0, '新建', null, '', 1, 1);
/---
delete from HI_Language where id =5;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(5, 0, '查询', null, '', 1, 1);
/---
delete from HI_Language where id =6;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(6, 0, '重置', null, '', 1, 1);
/---
delete from HI_Language where id =8;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(8, 6, '列表', null, '', 1, 1);
/---
delete from HI_Language where id =9;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(9, 0, '操作', null, '', 1, 1);
/---
delete from HI_Language where id =10;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(10, 0, '查找带回', null, '', 1, 1);
/---
delete from HI_Language where id =11;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(11, 0, '删除', null, '', 1, 1);
/---
delete from HI_Language where id =12;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(12, 0, '查看', null, '', 1, 1);
/---
delete from HI_Language where id =13;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(13, 0, '编辑', null, '', 1, 1);
/---
delete from HI_Language where id =14;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(14, 3, '取消全选', null, '', 1, 1);
/---
delete from HI_Language where id =15;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(15, 0, '全选', null, '', 1, 1);
/---
delete from HI_Language where id =16;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(16, 0, '批量删除', null, '', 1, 1);
/---
delete from HI_Language where id =17;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(17, 2, '编辑页面', null, '', 1, 1);
/---
delete from HI_Language where id =18;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(18, 0, '保存', null, '', 1, 1);
/---
delete from HI_Language where id =19;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(19, 0, '关闭', null, '', 1, 1);
/---
delete from HI_Language where id =20;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(20, 1, '查看页面', null, '', 1, 1);
/---
delete from HI_Language where id =22;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(22, 0, '总条数', null, '', 1, 1);
/---
delete from HI_Language where id =23;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(23, 0, '总页数', null, '', 1, 1);
/---
delete from HI_Language where id =24;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(24, 0, '尾页', null, '', 1, 1);
/---
delete from HI_Language where id =25;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(25, 0, '下一页', null, '', 1, 1);
/---
delete from HI_Language where id =26;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(26, 0, '上一页', null, '', 1, 1);
/---
delete from HI_Language where id =27;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(27, 0, '首页', null, '', 1, 1);
/---
delete from HI_Language where id =28;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(28, 0, '到', null, '', 1, 1);
/---
delete from HI_Language where id =29;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(29, 0, '页', null, '', 1, 1);
/---
delete from HI_Language where id =30;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(30, 0, '跳转', null, '', 1, 1);
/---
delete from HI_Language where id =31;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(31, 0, '全部', null, '', 1, 1);
/---
delete from HI_Language where id =32;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(32, 0, '操作符', null, '', 1, 1);
/---
delete from HI_Language where id =33;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(33, 0, '小于', null, '', 1, 1);
/---
delete from HI_Language where id =34;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(34, 0, '大于', null, '', 1, 1);
/---
delete from HI_Language where id =35;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(35, 0, '等于', null, '', 1, 1);
/---
delete from HI_Language where id =36;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(36, 0, '小于等于', null, '', 1, 1);
/---
delete from HI_Language where id =37;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(37, 0, '大于等于', null, '', 1, 1);
/---
delete from HI_Language where id =38;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(38, 1, '请选择需要上传的附件', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =39;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(39, 1, '上传', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =40;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(40, 3, '请先选择需要上传的文件!', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =41;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(41, 0, '权限管理', null, '', 1, 1);
/---
delete from HI_Language where id =42;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(42, 0, '错误详细信息', null, '', 1, 1);
/---
delete from HI_Language where id =43;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(43, 0, '您没有操作此功能的权限', null, '', 1, 1);
/---
delete from HI_Language where id =44;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(44, 0, '返回', null, '', 1, 1);
/---
delete from HI_Language where id =45;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(45, 0, '未找到Action', null, 'ExcelReportDesign', 1, 1);
/---
delete from HI_Language where id =46;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(46, 0, '上传文件过大', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =47;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(47, 0, 'Action加载失败', null, '', 1, 1);
/---
delete from HI_Language where id =48;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(48, 0, '您是一般用户,不能分派角色', null, 'Role', 1, 1);
/---
delete from HI_Language where id =49;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(49, 1, '您的用户类型是管理员,必须是您自己创建的角色才可以为该角色分派用户', null, 'Role', 1, 1);
/---
delete from HI_Language where id =50;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(50, 0, '超级管理员无需授权', null, 'Role', 1, 1);
/---
delete from HI_Language where id =51;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(51, 0, '您是一般用户,不能删除建角色', null, 'Role', 1, 1);
/---
delete from HI_Language where id =52;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(52, 0, '您的用户类型为管理员,只能删除您自己所创建的角色', null, 'Role', 1, 1);
/---
delete from HI_Language where id =53;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(53, 0, '角色名重复', null, 'Role', 1, 1);
/---
delete from HI_Language where id =54;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(54, 0, '系统无法识别您的用户类型', null, '', 1, 1);
/---
delete from HI_Language where id =55;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(55, 0, '您是一般用户,不能修改与创建角色', null, 'Role', 1, 1);
/---
delete from HI_Language where id =56;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(56, 1, '您的用户是管理员,所以只能编辑您自己创建的角色!', null, 'Role', 1, 1);
/---
delete from HI_Language where id =57;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(57, 0, '该页面中的数据已经被改写，请重新刷新页面后重新编辑该记录', null, '', 1, 1);
/---
delete from HI_Language where id =58;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(58, 0, 'Action对象赋值时出错', null, '', 1, 1);
/---
delete from HI_Language where id =59;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(59, 0, '发送邮件失败', null, '', 1, 1);
/---
delete from HI_Language where id =61;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(61, 0, '请选择要授权的用户', null, 'Role', 1, 1);
/---
delete from HI_Language where id =62;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(62, 0, 'HI平台', null, '', 1, 1);
/---
delete from HI_Language where id =63;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(63, 0, '用户名', null, '', 1, 1);
/---
delete from HI_Language where id =64;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(64, 0, '密码', null, '', 1, 1);
/---
delete from HI_Language where id =65;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(65, 0, '验证码', null, '', 1, 1);
/---
delete from HI_Language where id =66;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(66, 0, '你没有登陆成功', null, '', 1, 1);
/---
delete from HI_Language where id =67;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(67, 0, '可能的原因', null, '', 1, 1);
/---
delete from HI_Language where id =68;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(68, 0, '欢迎', null, '', 1, 1);
/---
delete from HI_Language where id =69;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(69, 0, '登陆', null, '', 1, 1);
/---
delete from HI_Language where id =70;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(70, 0, '退出', null, '', 1, 1);
/---

delete from HI_LanguageCode where id =1;
/---
insert into HI_LanguageCode(id, version, languageCode, description, creator) values(1, 2, 'zh_CN', '中国汉语', 1);
/---
delete from HI_LanguageCode where id =2;
/---
insert into HI_LanguageCode(id, version, languageCode, description, creator) values(2, 0, 'en_US', '美国英语', 1);
/---

delete from HI_languageStr where id =2;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(2, 8, 3, 'zh_CN', '查询条件', 1);
/---
delete from HI_languageStr where id =3;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(3, 0, 4, 'zh_CN', '新建', 1);
/---
delete from HI_languageStr where id =4;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(4, 0, 5, 'zh_CN', '查询', 1);
/---
delete from HI_languageStr where id =5;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(5, 0, 6, 'zh_CN', '重置', 1);
/---
delete from HI_languageStr where id =7;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(7, 1, 8, 'zh_CN', '{1}列表', 1);
/---
delete from HI_languageStr where id =8;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(8, 1, 9, 'zh_CN', '操作', 1);
/---
delete from HI_languageStr where id =9;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(9, 0, 10, 'zh_CN', '查找带回', 1);
/---
delete from HI_languageStr where id =10;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(10, 0, 11, 'zh_CN', '删除{1}', 1);
/---
delete from HI_languageStr where id =11;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(11, 0, 12, 'zh_CN', '查看{1}', 1);
/---
delete from HI_languageStr where id =12;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(12, 0, 13, 'zh_CN', '编辑{1}', 1);
/---
delete from HI_languageStr where id =13;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(13, 0, 14, 'zh_CN', '取消全选', 1);
/---
delete from HI_languageStr where id =14;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(14, 0, 15, 'zh_CN', '全选', 1);
/---
delete from HI_languageStr where id =15;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(15, 0, 16, 'zh_CN', '批量删除', 1);
/---
delete from HI_languageStr where id =16;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(16, 1, 17, 'zh_CN', '{1}编辑页面', 1);
/---
delete from HI_languageStr where id =17;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(17, 0, 18, 'zh_CN', '保存', 1);
/---
delete from HI_languageStr where id =18;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(18, 0, 19, 'zh_CN', '关闭', 1);
/---
delete from HI_languageStr where id =19;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(19, 1, 20, 'zh_CN', '{1}查看页面', 1);
/---
delete from HI_languageStr where id =27;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(27, 0, 22, 'zh_CN', '共{1}条', 1);
/---
delete from HI_languageStr where id =29;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(29, 0, 23, 'zh_CN', '共{1}页', 1);
/---
delete from HI_languageStr where id =31;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(31, 0, 24, 'zh_CN', '尾页', 1);
/---
delete from HI_languageStr where id =33;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(33, 0, 25, 'zh_CN', '下一页', 1);
/---
delete from HI_languageStr where id =35;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(35, 0, 26, 'zh_CN', '上一页', 1);
/---
delete from HI_languageStr where id =37;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(37, 0, 27, 'zh_CN', '首页', 1);
/---
delete from HI_languageStr where id =39;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(39, 0, 28, 'zh_CN', '到', 1);
/---
delete from HI_languageStr where id =41;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(41, 0, 29, 'zh_CN', '页', 1);
/---
delete from HI_languageStr where id =43;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(43, 0, 30, 'zh_CN', '跳转', 1);
/---
delete from HI_languageStr where id =45;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(45, 0, 31, 'zh_CN', '全部', 1);
/---
delete from HI_languageStr where id =47;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(47, 0, 32, 'zh_CN', '操作符', 1);
/---
delete from HI_languageStr where id =49;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(49, 0, 33, 'zh_CN', '小于', 1);
/---
delete from HI_languageStr where id =51;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(51, 0, 34, 'zh_CN', '大于', 1);
/---
delete from HI_languageStr where id =53;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(53, 0, 35, 'zh_CN', '等于', 1);
/---
delete from HI_languageStr where id =55;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(55, 0, 36, 'zh_CN', '小于等于', 1);
/---
delete from HI_languageStr where id =57;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(57, 0, 37, 'zh_CN', '大于等于', 1);
/---
delete from HI_languageStr where id =59;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(59, 0, 38, 'zh_CN', '请选择需要上传的附件', 1);
/---
delete from HI_languageStr where id =60;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(60, 0, 39, 'zh_CN', '上传', 1);
/---
delete from HI_languageStr where id =61;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(61, 0, 40, 'zh_CN', '请先选择需要上传的文件！', 1);
/---
delete from HI_languageStr where id =62;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(62, 0, 41, 'zh_CN', '权限管理', 1);
/---
delete from HI_languageStr where id =63;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(63, 0, 42, 'zh_CN', '错误详细信息', 1);
/---
delete from HI_languageStr where id =64;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(64, 0, 43, 'zh_CN', '您没有操作此功能的权限', 1);
/---
delete from HI_languageStr where id =65;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(65, 0, 44, 'zh_CN', '返回', 1);
/---
delete from HI_languageStr where id =66;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(66, 0, 45, 'zh_CN', '在系统中没有与action:{1}  对应的报表设计,如果存在请确认是否处于激活状态', 1);
/---
delete from HI_languageStr where id =67;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(67, 0, 46, 'zh_CN', '上传文件过大！最大能上传{1}MB 的附件.', 1);
/---
delete from HI_languageStr where id =68;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(68, 0, 47, 'zh_CN', '{1}加载失败!', 1);
/---
delete from HI_languageStr where id =69;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(69, 0, 48, 'zh_CN', '您是一般用户,不能分派角色', 1);
/---
delete from HI_languageStr where id =70;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(70, 0, 49, 'zh_CN', '您的用户类型是管理员,必须是您自己创建的角色才可以为该角色分派用户', 1);
/---
delete from HI_languageStr where id =71;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(71, 0, 50, 'zh_CN', '您选择的用户：{1}是超级管理员,不需要为超级管理员授权', 1);
/---
delete from HI_languageStr where id =72;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(72, 0, 51, 'zh_CN', '您是一般用户,不能删除建角色', 1);
/---
delete from HI_languageStr where id =73;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(73, 0, 52, 'zh_CN', '您的用户类型为管理员,只能删除您自己所创建的角色', 1);
/---
delete from HI_languageStr where id =74;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(74, 0, 53, 'zh_CN', '角色名：{1}已经存在，不能有重复的角色名！', 1);
/---
delete from HI_languageStr where id =75;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(75, 1, 54, 'zh_CN', '系统无法识别您的用户类型!', 1);
/---
delete from HI_languageStr where id =76;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(76, 0, 55, 'zh_CN', '您是一般用户,不能修改与创建角色!', 1);
/---
delete from HI_languageStr where id =77;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(77, 0, 56, 'zh_CN', '您的用户是管理员,所以只能编辑您自己创建的角色!', 1);
/---
delete from HI_languageStr where id =78;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(78, 0, 57, 'zh_CN', '该页面中的数据已经被改写，请重新刷新页面后重新编辑该记录!', 1);
/---
delete from HI_languageStr where id =79;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(79, 0, 58, 'zh_CN', '在给action对象赋值时出错：{1}属性！', 1);
/---
delete from HI_languageStr where id =80;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(80, 0, 59, 'zh_CN', '发送邮件失败', 1);
/---
delete from HI_languageStr where id =82;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(82, 0, 61, 'zh_CN', '请选择要授权的用户', 1);
/---
delete from HI_languageStr where id =83;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(83, 0, 62, 'zh_CN', 'HI平台', 1);
/---
delete from HI_languageStr where id =84;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(84, 0, 63, 'zh_CN', '用户名', 1);
/---
delete from HI_languageStr where id =85;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(85, 0, 64, 'zh_CN', '密　码', 1);
/---
delete from HI_languageStr where id =86;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(86, 0, 65, 'zh_CN', '验证码', 1);
/---
delete from HI_languageStr where id =87;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(87, 0, 66, 'zh_CN', '你没有登陆成功，请再试一次。', 1);
/---
delete from HI_languageStr where id =88;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(88, 0, 67, 'zh_CN', '可能的原因: 您输入的用户名或密码错误！', 1);
/---
delete from HI_languageStr where id =89;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(89, 0, 68, 'zh_CN', '欢迎', 1);
/---
delete from HI_languageStr where id =90;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(90, 0, 69, 'zh_CN', '登陆', 1);
/---
delete from HI_languageStr where id =91;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(91, 0, 70, 'zh_CN', '退出', 1);


