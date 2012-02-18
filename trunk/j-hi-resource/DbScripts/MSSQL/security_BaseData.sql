--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 2000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(2000, 0, 'security', '安全管理', '安全管理', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 2000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2000, 0, '/authorityList.action', '权限', '权限', 2000, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2100, 0, '/roleList.action', '角色', '角色', 2100, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2200, 0, '/securityGroupList.action', '用户组', '用户组', 2200, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2300, 0, '/userAuthorityList.action', '用户权限', '用户权限', 2300, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2400, 0, '/userRoleList.action', '用户角色', '用户角色', 2400, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2500, 0, '/userGroupList.action', '用户与组', '用户与组', 2500, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2600, 0, '/roleAuthorityList.action', '角色权限', '角色权限', 2600, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2700, 0, '/groupRoleList.action', '组与角色', '组与角色', 2700, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2800;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2800, 0, '/privilegeResourceList.action', '权限资源', '权限资源', 2800, 9999, 2000, 0, 0);

--
SET IDENTITY_INSERT MenuLink OFF
--
SET IDENTITY_INSERT HI_Authority ON
--
delete from HI_Authority where ID = 2000;
--
delete from HI_Authority where ID = 2001;
--
delete from HI_Authority where ID = 2002;
--
delete from HI_Authority where ID = 2003;
--
delete from HI_Authority where ID = 2004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2000, 0, 'AUTHORITY_LIST', 'security.AuthorityList', '', '权限查询', 1, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2001, 0, 'AUTHORITY_VIEW', 'security.AuthorityView', '', '权限查看', 2, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2002, 0, 'AUTHORITY_SAVE', 'security.AuthoritySave', '', '权限保存', 3, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2003, 0, 'AUTHORITY_DEL', 'security.AuthorityDel', '', '权限删除', 4, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2004, 0, 'AUTHORITY_LOOKUP', 'security.AuthorityLookup', '', '权限带回', 1, 2000);

--
delete from HI_Authority where ID = 2100;
--
delete from HI_Authority where ID = 2101;
--
delete from HI_Authority where ID = 2102;
--
delete from HI_Authority where ID = 2103;
--
delete from HI_Authority where ID = 2104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2100, 0, 'ROLE_LIST', 'security.RoleList', '', '角色查询', 1, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2101, 0, 'ROLE_VIEW', 'security.RoleView', '', '角色查看', 2, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2102, 0, 'ROLE_SAVE', 'security.RoleSave', '', '角色保存', 3, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2103, 0, 'ROLE_DEL', 'security.RoleDel', '', '角色删除', 4, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2104, 0, 'ROLE_LOOKUP', 'security.RoleLookup', '', '角色带回', 1, 2100);

--
delete from HI_Authority where ID = 2200;
--
delete from HI_Authority where ID = 2201;
--
delete from HI_Authority where ID = 2202;
--
delete from HI_Authority where ID = 2203;
--
delete from HI_Authority where ID = 2204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2200, 0, 'SECURITYGROUP_LIST', 'security.SecurityGroupList', '', '用户组查询', 1, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2201, 0, 'SECURITYGROUP_VIEW', 'security.SecurityGroupView', '', '用户组查看', 2, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2202, 0, 'SECURITYGROUP_SAVE', 'security.SecurityGroupSave', '', '用户组保存', 3, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2203, 0, 'SECURITYGROUP_DEL', 'security.SecurityGroupDel', '', '用户组删除', 4, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2204, 0, 'SECURITYGROUP_LOOKUP', 'security.SecurityGroupLookup', '', '用户组带回', 1, 2200);

--
delete from HI_Authority where ID = 2300;
--
delete from HI_Authority where ID = 2301;
--
delete from HI_Authority where ID = 2302;
--
delete from HI_Authority where ID = 2303;
--
delete from HI_Authority where ID = 2304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2300, 0, 'USERAUTHORITY_LIST', 'security.UserAuthorityList', '', '用户权限查询', 1, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2301, 0, 'USERAUTHORITY_VIEW', 'security.UserAuthorityView', '', '用户权限查看', 2, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2302, 0, 'USERAUTHORITY_SAVE', 'security.UserAuthoritySave', '', '用户权限保存', 3, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2303, 0, 'USERAUTHORITY_DEL', 'security.UserAuthorityDel', '', '用户权限删除', 4, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2304, 0, 'USERAUTHORITY_LOOKUP', 'security.UserAuthorityLookup', '', '用户权限带回', 1, 2300);

--
delete from HI_Authority where ID = 2400;
--
delete from HI_Authority where ID = 2401;
--
delete from HI_Authority where ID = 2402;
--
delete from HI_Authority where ID = 2403;
--
delete from HI_Authority where ID = 2404;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2400, 0, 'USERROLE_LIST', 'security.UserRoleList', '', '用户角色查询', 1, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2401, 0, 'USERROLE_VIEW', 'security.UserRoleView', '', '用户角色查看', 2, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2402, 0, 'USERROLE_SAVE', 'security.UserRoleSave', '', '用户角色保存', 3, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2403, 0, 'USERROLE_DEL', 'security.UserRoleDel', '', '用户角色删除', 4, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2404, 0, 'USERROLE_LOOKUP', 'security.UserRoleLookup', '', '用户角色带回', 1, 2400);

--
delete from HI_Authority where ID = 2500;
--
delete from HI_Authority where ID = 2501;
--
delete from HI_Authority where ID = 2502;
--
delete from HI_Authority where ID = 2503;
--
delete from HI_Authority where ID = 2504;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2500, 0, 'USERGROUP_LIST', 'security.UserGroupList', '', '用户与组查询', 1, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2501, 0, 'USERGROUP_VIEW', 'security.UserGroupView', '', '用户与组查看', 2, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2502, 0, 'USERGROUP_SAVE', 'security.UserGroupSave', '', '用户与组保存', 3, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2503, 0, 'USERGROUP_DEL', 'security.UserGroupDel', '', '用户与组删除', 4, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2504, 0, 'USERGROUP_LOOKUP', 'security.UserGroupLookup', '', '用户与组带回', 1, 2500);

--
delete from HI_Authority where ID = 2600;
--
delete from HI_Authority where ID = 2601;
--
delete from HI_Authority where ID = 2602;
--
delete from HI_Authority where ID = 2603;
--
delete from HI_Authority where ID = 2604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2600, 0, 'ROLEAUTHORITY_LIST', 'security.RoleAuthorityList', '', '角色权限查询', 1, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2601, 0, 'ROLEAUTHORITY_VIEW', 'security.RoleAuthorityView', '', '角色权限查看', 2, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2602, 0, 'ROLEAUTHORITY_SAVE', 'security.RoleAuthoritySave', '', '角色权限保存', 3, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2603, 0, 'ROLEAUTHORITY_DEL', 'security.RoleAuthorityDel', '', '角色权限删除', 4, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2604, 0, 'ROLEAUTHORITY_LOOKUP', 'security.RoleAuthorityLookup', '', '角色权限带回', 1, 2600);

--
delete from HI_Authority where ID = 2700;
--
delete from HI_Authority where ID = 2701;
--
delete from HI_Authority where ID = 2702;
--
delete from HI_Authority where ID = 2703;
--
delete from HI_Authority where ID = 2704;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2700, 0, 'GROUPROLE_LIST', 'security.GroupRoleList', '', '组与角色查询', 1, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2701, 0, 'GROUPROLE_VIEW', 'security.GroupRoleView', '', '组与角色查看', 2, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2702, 0, 'GROUPROLE_SAVE', 'security.GroupRoleSave', '', '组与角色保存', 3, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2703, 0, 'GROUPROLE_DEL', 'security.GroupRoleDel', '', '组与角色删除', 4, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2704, 0, 'GROUPROLE_LOOKUP', 'security.GroupRoleLookup', '', '组与角色带回', 1, 2700);

--
delete from HI_Authority where ID = 2800;
--
delete from HI_Authority where ID = 2801;
--
delete from HI_Authority where ID = 2802;
--
delete from HI_Authority where ID = 2803;
--
delete from HI_Authority where ID = 2804;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2800, 0, 'PRIVILEGERESOURCE_LIST', 'security.PrivilegeResourceList', '', '权限资源查询', 1, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2801, 0, 'PRIVILEGERESOURCE_VIEW', 'security.PrivilegeResourceView', '', '权限资源查看', 2, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2802, 0, 'PRIVILEGERESOURCE_SAVE', 'security.PrivilegeResourceSave', '', '权限资源保存', 3, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2803, 0, 'PRIVILEGERESOURCE_DEL', 'security.PrivilegeResourceDel', '', '权限资源删除', 4, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2804, 0, 'PRIVILEGERESOURCE_LOOKUP', 'security.PrivilegeResourceLookup', '', '权限资源带回', 1, 2800);

--
SET IDENTITY_INSERT HI_Authority OFF
--
SET IDENTITY_INSERT HI_PrivilegeResource ON
--
delete from HI_PrivilegeResource where ID = 2000;
--
delete from HI_PrivilegeResource where ID = 2001;
--
delete from HI_PrivilegeResource where ID = 2002;
--
delete from HI_PrivilegeResource where ID = 2003;
--
delete from HI_PrivilegeResource where ID = 2004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2000, 0, 'AUTHORITY_LIST', '/authorityList.action', 'org.hi.framework.security.service.AuthorityManager.getSecurityAuthorityList', 'AUTHORITY_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2001, 0, 'AUTHORITY_VIEW', '/authorityView.action', 'org.hi.framework.security.service.AuthorityManager.getSecurityAuthorityById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2002, 0, 'AUTHORITY_SAVE', '/authoritySave.action', 'org.hi.framework.security.service.AuthorityManager.saveSecurityAuthority');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2003, 0, 'AUTHORITY_DEL', '/authorityRemove.action', 'org.hi.framework.security.service.AuthorityManager.removeSecurityAuthorityById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2004, 0, 'AUTHORITY_LOOKUP', '/authorityLookup.action');
--
delete from HI_PrivilegeResource where ID = 2100;
--
delete from HI_PrivilegeResource where ID = 2101;
--
delete from HI_PrivilegeResource where ID = 2102;
--
delete from HI_PrivilegeResource where ID = 2103;
--
delete from HI_PrivilegeResource where ID = 2104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2100, 0, 'ROLE_LIST', '/roleList.action', 'org.hi.framework.security.service.RoleManager.getSecurityRoleList', 'ROLE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2101, 0, 'ROLE_VIEW', '/roleView.action', 'org.hi.framework.security.service.RoleManager.getSecurityRoleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2102, 0, 'ROLE_SAVE', '/roleSave.action', 'org.hi.framework.security.service.RoleManager.saveSecurityRole');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2103, 0, 'ROLE_DEL', '/roleRemove.action', 'org.hi.framework.security.service.RoleManager.removeSecurityRoleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2104, 0, 'ROLE_LOOKUP', '/roleLookup.action');
--
delete from HI_PrivilegeResource where ID = 2200;
--
delete from HI_PrivilegeResource where ID = 2201;
--
delete from HI_PrivilegeResource where ID = 2202;
--
delete from HI_PrivilegeResource where ID = 2203;
--
delete from HI_PrivilegeResource where ID = 2204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2200, 0, 'SECURITYGROUP_LIST', '/securityGroupList.action', 'org.hi.framework.security.service.SecurityGroupManager.getSecuritySecurityGroupList', 'SECURITYGROUP_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2201, 0, 'SECURITYGROUP_VIEW', '/securityGroupView.action', 'org.hi.framework.security.service.SecurityGroupManager.getSecuritySecurityGroupById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2202, 0, 'SECURITYGROUP_SAVE', '/securityGroupSave.action', 'org.hi.framework.security.service.SecurityGroupManager.saveSecuritySecurityGroup');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2203, 0, 'SECURITYGROUP_DEL', '/securityGroupRemove.action', 'org.hi.framework.security.service.SecurityGroupManager.removeSecuritySecurityGroupById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2204, 0, 'SECURITYGROUP_LOOKUP', '/securityGroupLookup.action');
--
delete from HI_PrivilegeResource where ID = 2300;
--
delete from HI_PrivilegeResource where ID = 2301;
--
delete from HI_PrivilegeResource where ID = 2302;
--
delete from HI_PrivilegeResource where ID = 2303;
--
delete from HI_PrivilegeResource where ID = 2304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2300, 0, 'USERAUTHORITY_LIST', '/userAuthorityList.action', 'org.hi.framework.security.service.UserAuthorityManager.getSecurityUserAuthorityList', 'USERAUTHORITY_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2301, 0, 'USERAUTHORITY_VIEW', '/userAuthorityView.action', 'org.hi.framework.security.service.UserAuthorityManager.getSecurityUserAuthorityById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2302, 0, 'USERAUTHORITY_SAVE', '/userAuthoritySave.action', 'org.hi.framework.security.service.UserAuthorityManager.saveSecurityUserAuthority');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2303, 0, 'USERAUTHORITY_DEL', '/userAuthorityRemove.action', 'org.hi.framework.security.service.UserAuthorityManager.removeSecurityUserAuthorityById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2304, 0, 'USERAUTHORITY_LOOKUP', '/userAuthorityLookup.action');
--
delete from HI_PrivilegeResource where ID = 2400;
--
delete from HI_PrivilegeResource where ID = 2401;
--
delete from HI_PrivilegeResource where ID = 2402;
--
delete from HI_PrivilegeResource where ID = 2403;
--
delete from HI_PrivilegeResource where ID = 2404;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2400, 0, 'USERROLE_LIST', '/userRoleList.action', 'org.hi.framework.security.service.UserRoleManager.getSecurityUserRoleList', 'USERROLE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2401, 0, 'USERROLE_VIEW', '/userRoleView.action', 'org.hi.framework.security.service.UserRoleManager.getSecurityUserRoleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2402, 0, 'USERROLE_SAVE', '/userRoleSave.action', 'org.hi.framework.security.service.UserRoleManager.saveSecurityUserRole');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2403, 0, 'USERROLE_DEL', '/userRoleRemove.action', 'org.hi.framework.security.service.UserRoleManager.removeSecurityUserRoleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2404, 0, 'USERROLE_LOOKUP', '/userRoleLookup.action');
--
delete from HI_PrivilegeResource where ID = 2500;
--
delete from HI_PrivilegeResource where ID = 2501;
--
delete from HI_PrivilegeResource where ID = 2502;
--
delete from HI_PrivilegeResource where ID = 2503;
--
delete from HI_PrivilegeResource where ID = 2504;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2500, 0, 'USERGROUP_LIST', '/userGroupList.action', 'org.hi.framework.security.service.UserGroupManager.getSecurityUserGroupList', 'USERGROUP_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2501, 0, 'USERGROUP_VIEW', '/userGroupView.action', 'org.hi.framework.security.service.UserGroupManager.getSecurityUserGroupById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2502, 0, 'USERGROUP_SAVE', '/userGroupSave.action', 'org.hi.framework.security.service.UserGroupManager.saveSecurityUserGroup');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2503, 0, 'USERGROUP_DEL', '/userGroupRemove.action', 'org.hi.framework.security.service.UserGroupManager.removeSecurityUserGroupById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2504, 0, 'USERGROUP_LOOKUP', '/userGroupLookup.action');
--
delete from HI_PrivilegeResource where ID = 2600;
--
delete from HI_PrivilegeResource where ID = 2601;
--
delete from HI_PrivilegeResource where ID = 2602;
--
delete from HI_PrivilegeResource where ID = 2603;
--
delete from HI_PrivilegeResource where ID = 2604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2600, 0, 'ROLEAUTHORITY_LIST', '/roleAuthorityList.action', 'org.hi.framework.security.service.RoleAuthorityManager.getSecurityRoleAuthorityList', 'ROLEAUTHORITY_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2601, 0, 'ROLEAUTHORITY_VIEW', '/roleAuthorityView.action', 'org.hi.framework.security.service.RoleAuthorityManager.getSecurityRoleAuthorityById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2602, 0, 'ROLEAUTHORITY_SAVE', '/roleAuthoritySave.action', 'org.hi.framework.security.service.RoleAuthorityManager.saveSecurityRoleAuthority');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2603, 0, 'ROLEAUTHORITY_DEL', '/roleAuthorityRemove.action', 'org.hi.framework.security.service.RoleAuthorityManager.removeSecurityRoleAuthorityById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2604, 0, 'ROLEAUTHORITY_LOOKUP', '/roleAuthorityLookup.action');
--
delete from HI_PrivilegeResource where ID = 2700;
--
delete from HI_PrivilegeResource where ID = 2701;
--
delete from HI_PrivilegeResource where ID = 2702;
--
delete from HI_PrivilegeResource where ID = 2703;
--
delete from HI_PrivilegeResource where ID = 2704;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2700, 0, 'GROUPROLE_LIST', '/groupRoleList.action', 'org.hi.framework.security.service.GroupRoleManager.getSecurityGroupRoleList', 'GROUPROLE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2701, 0, 'GROUPROLE_VIEW', '/groupRoleView.action', 'org.hi.framework.security.service.GroupRoleManager.getSecurityGroupRoleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2702, 0, 'GROUPROLE_SAVE', '/groupRoleSave.action', 'org.hi.framework.security.service.GroupRoleManager.saveSecurityGroupRole');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2703, 0, 'GROUPROLE_DEL', '/groupRoleRemove.action', 'org.hi.framework.security.service.GroupRoleManager.removeSecurityGroupRoleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2704, 0, 'GROUPROLE_LOOKUP', '/groupRoleLookup.action');
--
delete from HI_PrivilegeResource where ID = 2800;
--
delete from HI_PrivilegeResource where ID = 2801;
--
delete from HI_PrivilegeResource where ID = 2802;
--
delete from HI_PrivilegeResource where ID = 2803;
--
delete from HI_PrivilegeResource where ID = 2804;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(2800, 0, 'PRIVILEGERESOURCE_LIST', '/privilegeResourceList.action', 'org.hi.framework.security.service.PrivilegeResourceManager.getSecurityPrivilegeResourceList', 'PRIVILEGERESOURCE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2801, 0, 'PRIVILEGERESOURCE_VIEW', '/privilegeResourceView.action', 'org.hi.framework.security.service.PrivilegeResourceManager.getSecurityPrivilegeResourceById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2802, 0, 'PRIVILEGERESOURCE_SAVE', '/privilegeResourceSave.action', 'org.hi.framework.security.service.PrivilegeResourceManager.saveSecurityPrivilegeResource');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(2803, 0, 'PRIVILEGERESOURCE_DEL', '/privilegeResourceRemove.action', 'org.hi.framework.security.service.PrivilegeResourceManager.removeSecurityPrivilegeResourceById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(2804, 0, 'PRIVILEGERESOURCE_LOOKUP', '/privilegeResourceLookup.action');
--
SET IDENTITY_INSERT HI_PrivilegeResource OFF
--
SET IDENTITY_INSERT Enumeration ON
--
delete from Enumeration where ID = 2900;
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(2900, 0, 'securityScope', '权限范围', '权限范围', 0, 0);
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
--
delete from EnumerationValue where ID = 2900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2900, 0, 'User_Level', '用户级', '用户级', 2900, 0);
--
delete from EnumerationValue where ID = 2901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2901, 0, 'CurrentOrg_Level', '当前部门级', '当前部门级', 2900, 0);
--
delete from EnumerationValue where ID = 2902;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2902, 0, 'Org_Level', '部门级', '部门级', 2900, 0);
--
delete from EnumerationValue where ID = 2903;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2903, 0, 'OrgAndSuborg_Level', '部门及子部门级', '部门及子部门级', 2900, 0);
--
delete from EnumerationValue where ID = 2904;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2904, 0, 'System_Level', '系统级', '系统级', 2900, 0);
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 2000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2000, 0, '权限', 1, 0);
--
delete from HI_Language where ID = 2001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2001, 0, '权限名称', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2002, 0, '属性资源', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2003, 0, '描述', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2004, 0, '菜单项', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2100, 0, '角色', 1, 0);
--
delete from HI_Language where ID = 2101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2101, 0, '角色名称', 'Role', 1, 0);
--
delete from HI_Language where ID = 2102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2102, 0, '显示信息', 'Role', 1, 0);
--
delete from HI_Language where ID = 2103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2103, 0, '描述', 'Role', 1, 0);
--
delete from HI_Language where ID = 2104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2104, 0, '创建人', 'Role', 1, 0);
--
delete from HI_Language where ID = 2200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2200, 0, '用户组', 1, 0);
--
delete from HI_Language where ID = 2201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2201, 0, '用户组名', 'SecurityGroup', 1, 0);
--
delete from HI_Language where ID = 2202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2202, 0, '显示信息', 'SecurityGroup', 1, 0);
--
delete from HI_Language where ID = 2203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2203, 0, '描述', 'SecurityGroup', 1, 0);
--
delete from HI_Language where ID = 2300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2300, 0, '用户权限', 1, 0);
--
delete from HI_Language where ID = 2301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2301, 0, '用户', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2302, 0, '权限', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2303, 0, '部门', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2304, 0, '范围', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2400, 0, '用户角色', 1, 0);
--
delete from HI_Language where ID = 2401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2401, 0, '用户', 'UserRole', 1, 0);
--
delete from HI_Language where ID = 2402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2402, 0, '角色名称', 'UserRole', 1, 0);
--
delete from HI_Language where ID = 2500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2500, 0, '用户与组', 1, 0);
--
delete from HI_Language where ID = 2501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2501, 0, '用户', 'UserGroup', 1, 0);
--
delete from HI_Language where ID = 2502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2502, 0, '角色名称', 'UserGroup', 1, 0);
--
delete from HI_Language where ID = 2600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2600, 0, '角色权限', 1, 0);
--
delete from HI_Language where ID = 2601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2601, 0, '角色名称', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2602, 0, '用户', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2603, 0, '部门', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2604, 0, '范围', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2700, 0, '组与角色', 1, 0);
--
delete from HI_Language where ID = 2701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2701, 0, '用户组', 'GroupRole', 1, 0);
--
delete from HI_Language where ID = 2702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2702, 0, '角色名称', 'GroupRole', 1, 0);
--
delete from HI_Language where ID = 2800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2800, 0, '权限资源', 1, 0);
--
delete from HI_Language where ID = 2801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2801, 0, '权限名称', 'PrivilegeResource', 1, 0);
--
delete from HI_Language where ID = 2802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2802, 0, '业务层', 'PrivilegeResource', 1, 0);
--
delete from HI_Language where ID = 2900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2900, 0, '权限范围', 1, 0);
--
delete from HI_Language where ID = 2901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2901, 0, '用户级', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2902, 0, '当前部门级', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2903;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2903, 0, '部门级', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2904;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2904, 0, '部门及子部门级', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2905;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2905, 0, '系统级', 'securityScope', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--