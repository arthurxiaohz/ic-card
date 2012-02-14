--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 1000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(1000, 0, 'organization', '部门管理', '部门管理', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 1000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(1000, 0, '/hiOrgList.action', '部门', '部门', 1000, 9999, 1000, 0, 0);

--
delete from MenuLink where ID = 1100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(1100, 0, '/hiUserList.action', '人员', '人员', 1100, 9999, 1000, 0, 0);

--
SET IDENTITY_INSERT MenuLink OFF
--
SET IDENTITY_INSERT HI_Authority ON
--
delete from HI_Authority where ID = 1000;
--
delete from HI_Authority where ID = 1001;
--
delete from HI_Authority where ID = 1002;
--
delete from HI_Authority where ID = 1003;
--
delete from HI_Authority where ID = 1004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1000, 0, 'HIORG_LIST', 'organization.HiOrgList', '', '部门查询', 1, 1000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1001, 0, 'HIORG_VIEW', 'organization.HiOrgView', '', '部门查看', 2, 1000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1002, 0, 'HIORG_SAVE', 'organization.HiOrgSave', '', '部门保存', 3, 1000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1003, 0, 'HIORG_DEL', 'organization.HiOrgDel', '', '部门删除', 4, 1000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1004, 0, 'HIORG_LOOKUP', 'organization.HiOrgLookup', '', '部门带回', 1, 1000);

--
delete from HI_Authority where ID = 1100;
--
delete from HI_Authority where ID = 1101;
--
delete from HI_Authority where ID = 1102;
--
delete from HI_Authority where ID = 1103;
--
delete from HI_Authority where ID = 1104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1100, 0, 'HIUSER_LIST', 'organization.HiUserList', '', '人员查询', 1, 1100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1101, 0, 'HIUSER_VIEW', 'organization.HiUserView', '', '人员查看', 2, 1100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1102, 0, 'HIUSER_SAVE', 'organization.HiUserSave', '', '人员保存', 3, 1100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1103, 0, 'HIUSER_DEL', 'organization.HiUserDel', '', '人员删除', 4, 1100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(1104, 0, 'HIUSER_LOOKUP', 'organization.HiUserLookup', '', '人员带回', 1, 1100);

--
SET IDENTITY_INSERT HI_Authority OFF
--
SET IDENTITY_INSERT HI_PrivilegeResource ON
--
delete from HI_PrivilegeResource where ID = 1000;
--
delete from HI_PrivilegeResource where ID = 1001;
--
delete from HI_PrivilegeResource where ID = 1002;
--
delete from HI_PrivilegeResource where ID = 1003;
--
delete from HI_PrivilegeResource where ID = 1004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(1000, 0, 'HIORG_LIST', '/hiOrgList.action', 'org.hi.base.organization.service.HiOrgManager.getSecurityHiOrgList', 'HIORG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(1001, 0, 'HIORG_VIEW', '/hiOrgView.action', 'org.hi.base.organization.service.HiOrgManager.getSecurityHiOrgById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(1002, 0, 'HIORG_SAVE', '/hiOrgSave.action', 'org.hi.base.organization.service.HiOrgManager.saveSecurityHiOrg');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(1003, 0, 'HIORG_DEL', '/hiOrgRemove.action', 'org.hi.base.organization.service.HiOrgManager.removeSecurityHiOrgById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(1004, 0, 'HIORG_LOOKUP', '/hiOrgLookup.action');
--
delete from HI_PrivilegeResource where ID = 1100;
--
delete from HI_PrivilegeResource where ID = 1101;
--
delete from HI_PrivilegeResource where ID = 1102;
--
delete from HI_PrivilegeResource where ID = 1103;
--
delete from HI_PrivilegeResource where ID = 1104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(1100, 0, 'HIUSER_LIST', '/hiUserList.action', 'org.hi.base.organization.service.HiUserManager.getSecurityHiUserList', 'HIUSER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(1101, 0, 'HIUSER_VIEW', '/hiUserView.action', 'org.hi.base.organization.service.HiUserManager.getSecurityHiUserById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(1102, 0, 'HIUSER_SAVE', '/hiUserSave.action', 'org.hi.base.organization.service.HiUserManager.saveSecurityHiUser');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(1103, 0, 'HIUSER_DEL', '/hiUserRemove.action', 'org.hi.base.organization.service.HiUserManager.removeSecurityHiUserById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(1104, 0, 'HIUSER_LOOKUP', '/hiUserLookup.action');
--
SET IDENTITY_INSERT HI_PrivilegeResource OFF
--
SET IDENTITY_INSERT Enumeration ON
--
delete from Enumeration where ID = 1200;
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1200, 0, 'gender', '性别', '性别', 0, 0);
--
delete from Enumeration where ID = 1300;
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1300, 0, 'job', '职位', '职位', 0, 0);
--
delete from Enumeration where ID = 1400;
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1400, 0, 'userType', '用户类型', '用户类型', 0, 0);
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
--
delete from EnumerationValue where ID = 1200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1200, 0, 'Male', '男', '男', 1200, 0);
--
delete from EnumerationValue where ID = 1201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1201, 0, 'Woman', '女', '女', 1200, 0);
--
delete from EnumerationValue where ID = 1300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1300, 0, 'Accountant', '会计', '会计', 1300, 0);
--
delete from EnumerationValue where ID = 1301;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1301, 0, 'Cashier', '出纳', '出纳', 1300, 0);
--
delete from EnumerationValue where ID = 1302;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1302, 0, 'ProjectManager', '项目经理', '项目经理', 1300, 0);
--
delete from EnumerationValue where ID = 1400;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1400, 0, 'Administrator', '超级管理员', '超级管理员', 1400, 0);
--
delete from EnumerationValue where ID = 1401;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1401, 0, 'Manager', '管理员', '管理员', 1400, 0);
--
delete from EnumerationValue where ID = 1402;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(1402, 0, 'Menual', '一般用户', '一般用户', 1400, 0);
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 1000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(1000, 0, '部门', 1, 0);
--
delete from HI_Language where ID = 1001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1001, 0, '部门名称', 'HiOrg', 1, 0);
--
delete from HI_Language where ID = 1002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1002, 0, '部门编号', 'HiOrg', 1, 0);
--
delete from HI_Language where ID = 1003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1003, 0, '部门经理', 'HiOrg', 1, 0);
--
delete from HI_Language where ID = 1004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1004, 0, '上级部门', 'HiOrg', 1, 0);
--
delete from HI_Language where ID = 1005;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1005, 0, '创建人', 'HiOrg', 1, 0);
--
delete from HI_Language where ID = 1100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(1100, 0, '人员', 1, 0);
--
delete from HI_Language where ID = 1101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1101, 0, '帐号', 'HiUser', 1, 0);
--
delete from HI_Language where ID = 1102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1102, 0, '姓名', 'HiUser', 1, 0);
--
delete from HI_Language where ID = 1103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1103, 0, '部门', 'HiUser', 1, 0);
--
delete from HI_Language where ID = 1104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1104, 0, '性别', 'HiUser', 1, 0);
--
delete from HI_Language where ID = 1200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(1200, 0, '性别', 1, 0);
--
delete from HI_Language where ID = 1201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1201, 0, '男', 'gender', 1, 0);
--
delete from HI_Language where ID = 1202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1202, 0, '女', 'gender', 1, 0);
--
delete from HI_Language where ID = 1300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(1300, 0, '职位', 1, 0);
--
delete from HI_Language where ID = 1301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1301, 0, '会计', 'job', 1, 0);
--
delete from HI_Language where ID = 1302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1302, 0, '出纳', 'job', 1, 0);
--
delete from HI_Language where ID = 1303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1303, 0, '项目经理', 'job', 1, 0);
--
delete from HI_Language where ID = 1400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(1400, 0, '用户类型', 1, 0);
--
delete from HI_Language where ID = 1401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1401, 0, '超级管理员', 'userType', 1, 0);
--
delete from HI_Language where ID = 1402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1402, 0, '管理员', 'userType', 1, 0);
--
delete from HI_Language where ID = 1403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(1403, 0, '一般用户', 'userType', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--