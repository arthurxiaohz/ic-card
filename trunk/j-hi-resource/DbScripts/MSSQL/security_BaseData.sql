--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 2000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(2000, 0, 'security', '��ȫ����', '��ȫ����', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 2000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2000, 0, '/authorityList.action', 'Ȩ��', 'Ȩ��', 2000, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2100, 0, '/roleList.action', '��ɫ', '��ɫ', 2100, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2200, 0, '/securityGroupList.action', '�û���', '�û���', 2200, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2300, 0, '/userAuthorityList.action', '�û�Ȩ��', '�û�Ȩ��', 2300, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2400, 0, '/userRoleList.action', '�û���ɫ', '�û���ɫ', 2400, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2500, 0, '/userGroupList.action', '�û�����', '�û�����', 2500, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2600, 0, '/roleAuthorityList.action', '��ɫȨ��', '��ɫȨ��', 2600, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2700, 0, '/groupRoleList.action', '�����ɫ', '�����ɫ', 2700, 9999, 2000, 0, 0);

--
delete from MenuLink where ID = 2800;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2800, 0, '/privilegeResourceList.action', 'Ȩ����Դ', 'Ȩ����Դ', 2800, 9999, 2000, 0, 0);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2000, 0, 'AUTHORITY_LIST', 'security.AuthorityList', '', 'Ȩ�޲�ѯ', 1, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2001, 0, 'AUTHORITY_VIEW', 'security.AuthorityView', '', 'Ȩ�޲鿴', 2, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2002, 0, 'AUTHORITY_SAVE', 'security.AuthoritySave', '', 'Ȩ�ޱ���', 3, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2003, 0, 'AUTHORITY_DEL', 'security.AuthorityDel', '', 'Ȩ��ɾ��', 4, 2000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2004, 0, 'AUTHORITY_LOOKUP', 'security.AuthorityLookup', '', 'Ȩ�޴���', 1, 2000);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2100, 0, 'ROLE_LIST', 'security.RoleList', '', '��ɫ��ѯ', 1, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2101, 0, 'ROLE_VIEW', 'security.RoleView', '', '��ɫ�鿴', 2, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2102, 0, 'ROLE_SAVE', 'security.RoleSave', '', '��ɫ����', 3, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2103, 0, 'ROLE_DEL', 'security.RoleDel', '', '��ɫɾ��', 4, 2100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2104, 0, 'ROLE_LOOKUP', 'security.RoleLookup', '', '��ɫ����', 1, 2100);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2200, 0, 'SECURITYGROUP_LIST', 'security.SecurityGroupList', '', '�û����ѯ', 1, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2201, 0, 'SECURITYGROUP_VIEW', 'security.SecurityGroupView', '', '�û���鿴', 2, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2202, 0, 'SECURITYGROUP_SAVE', 'security.SecurityGroupSave', '', '�û��鱣��', 3, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2203, 0, 'SECURITYGROUP_DEL', 'security.SecurityGroupDel', '', '�û���ɾ��', 4, 2200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2204, 0, 'SECURITYGROUP_LOOKUP', 'security.SecurityGroupLookup', '', '�û������', 1, 2200);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2300, 0, 'USERAUTHORITY_LIST', 'security.UserAuthorityList', '', '�û�Ȩ�޲�ѯ', 1, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2301, 0, 'USERAUTHORITY_VIEW', 'security.UserAuthorityView', '', '�û�Ȩ�޲鿴', 2, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2302, 0, 'USERAUTHORITY_SAVE', 'security.UserAuthoritySave', '', '�û�Ȩ�ޱ���', 3, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2303, 0, 'USERAUTHORITY_DEL', 'security.UserAuthorityDel', '', '�û�Ȩ��ɾ��', 4, 2300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2304, 0, 'USERAUTHORITY_LOOKUP', 'security.UserAuthorityLookup', '', '�û�Ȩ�޴���', 1, 2300);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2400, 0, 'USERROLE_LIST', 'security.UserRoleList', '', '�û���ɫ��ѯ', 1, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2401, 0, 'USERROLE_VIEW', 'security.UserRoleView', '', '�û���ɫ�鿴', 2, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2402, 0, 'USERROLE_SAVE', 'security.UserRoleSave', '', '�û���ɫ����', 3, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2403, 0, 'USERROLE_DEL', 'security.UserRoleDel', '', '�û���ɫɾ��', 4, 2400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2404, 0, 'USERROLE_LOOKUP', 'security.UserRoleLookup', '', '�û���ɫ����', 1, 2400);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2500, 0, 'USERGROUP_LIST', 'security.UserGroupList', '', '�û������ѯ', 1, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2501, 0, 'USERGROUP_VIEW', 'security.UserGroupView', '', '�û�����鿴', 2, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2502, 0, 'USERGROUP_SAVE', 'security.UserGroupSave', '', '�û����鱣��', 3, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2503, 0, 'USERGROUP_DEL', 'security.UserGroupDel', '', '�û�����ɾ��', 4, 2500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2504, 0, 'USERGROUP_LOOKUP', 'security.UserGroupLookup', '', '�û��������', 1, 2500);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2600, 0, 'ROLEAUTHORITY_LIST', 'security.RoleAuthorityList', '', '��ɫȨ�޲�ѯ', 1, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2601, 0, 'ROLEAUTHORITY_VIEW', 'security.RoleAuthorityView', '', '��ɫȨ�޲鿴', 2, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2602, 0, 'ROLEAUTHORITY_SAVE', 'security.RoleAuthoritySave', '', '��ɫȨ�ޱ���', 3, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2603, 0, 'ROLEAUTHORITY_DEL', 'security.RoleAuthorityDel', '', '��ɫȨ��ɾ��', 4, 2600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2604, 0, 'ROLEAUTHORITY_LOOKUP', 'security.RoleAuthorityLookup', '', '��ɫȨ�޴���', 1, 2600);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2700, 0, 'GROUPROLE_LIST', 'security.GroupRoleList', '', '�����ɫ��ѯ', 1, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2701, 0, 'GROUPROLE_VIEW', 'security.GroupRoleView', '', '�����ɫ�鿴', 2, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2702, 0, 'GROUPROLE_SAVE', 'security.GroupRoleSave', '', '�����ɫ����', 3, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2703, 0, 'GROUPROLE_DEL', 'security.GroupRoleDel', '', '�����ɫɾ��', 4, 2700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2704, 0, 'GROUPROLE_LOOKUP', 'security.GroupRoleLookup', '', '�����ɫ����', 1, 2700);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2800, 0, 'PRIVILEGERESOURCE_LIST', 'security.PrivilegeResourceList', '', 'Ȩ����Դ��ѯ', 1, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2801, 0, 'PRIVILEGERESOURCE_VIEW', 'security.PrivilegeResourceView', '', 'Ȩ����Դ�鿴', 2, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2802, 0, 'PRIVILEGERESOURCE_SAVE', 'security.PrivilegeResourceSave', '', 'Ȩ����Դ����', 3, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2803, 0, 'PRIVILEGERESOURCE_DEL', 'security.PrivilegeResourceDel', '', 'Ȩ����Դɾ��', 4, 2800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2804, 0, 'PRIVILEGERESOURCE_LOOKUP', 'security.PrivilegeResourceLookup', '', 'Ȩ����Դ����', 1, 2800);

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
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(2900, 0, 'securityScope', 'Ȩ�޷�Χ', 'Ȩ�޷�Χ', 0, 0);
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
--
delete from EnumerationValue where ID = 2900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2900, 0, 'User_Level', '�û���', '�û���', 2900, 0);
--
delete from EnumerationValue where ID = 2901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2901, 0, 'CurrentOrg_Level', '��ǰ���ż�', '��ǰ���ż�', 2900, 0);
--
delete from EnumerationValue where ID = 2902;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2902, 0, 'Org_Level', '���ż�', '���ż�', 2900, 0);
--
delete from EnumerationValue where ID = 2903;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2903, 0, 'OrgAndSuborg_Level', '���ż��Ӳ��ż�', '���ż��Ӳ��ż�', 2900, 0);
--
delete from EnumerationValue where ID = 2904;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(2904, 0, 'System_Level', 'ϵͳ��', 'ϵͳ��', 2900, 0);
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 2000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2000, 0, 'Ȩ��', 1, 0);
--
delete from HI_Language where ID = 2001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2001, 0, 'Ȩ������', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2002, 0, '������Դ', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2003, 0, '����', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2004, 0, '�˵���', 'Authority', 1, 0);
--
delete from HI_Language where ID = 2100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2100, 0, '��ɫ', 1, 0);
--
delete from HI_Language where ID = 2101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2101, 0, '��ɫ����', 'Role', 1, 0);
--
delete from HI_Language where ID = 2102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2102, 0, '��ʾ��Ϣ', 'Role', 1, 0);
--
delete from HI_Language where ID = 2103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2103, 0, '����', 'Role', 1, 0);
--
delete from HI_Language where ID = 2104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2104, 0, '������', 'Role', 1, 0);
--
delete from HI_Language where ID = 2200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2200, 0, '�û���', 1, 0);
--
delete from HI_Language where ID = 2201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2201, 0, '�û�����', 'SecurityGroup', 1, 0);
--
delete from HI_Language where ID = 2202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2202, 0, '��ʾ��Ϣ', 'SecurityGroup', 1, 0);
--
delete from HI_Language where ID = 2203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2203, 0, '����', 'SecurityGroup', 1, 0);
--
delete from HI_Language where ID = 2300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2300, 0, '�û�Ȩ��', 1, 0);
--
delete from HI_Language where ID = 2301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2301, 0, '�û�', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2302, 0, 'Ȩ��', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2303, 0, '����', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2304, 0, '��Χ', 'UserAuthority', 1, 0);
--
delete from HI_Language where ID = 2400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2400, 0, '�û���ɫ', 1, 0);
--
delete from HI_Language where ID = 2401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2401, 0, '�û�', 'UserRole', 1, 0);
--
delete from HI_Language where ID = 2402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2402, 0, '��ɫ����', 'UserRole', 1, 0);
--
delete from HI_Language where ID = 2500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2500, 0, '�û�����', 1, 0);
--
delete from HI_Language where ID = 2501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2501, 0, '�û�', 'UserGroup', 1, 0);
--
delete from HI_Language where ID = 2502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2502, 0, '��ɫ����', 'UserGroup', 1, 0);
--
delete from HI_Language where ID = 2600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2600, 0, '��ɫȨ��', 1, 0);
--
delete from HI_Language where ID = 2601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2601, 0, '��ɫ����', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2602, 0, '�û�', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2603, 0, '����', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2604, 0, '��Χ', 'RoleAuthority', 1, 0);
--
delete from HI_Language where ID = 2700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2700, 0, '�����ɫ', 1, 0);
--
delete from HI_Language where ID = 2701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2701, 0, '�û���', 'GroupRole', 1, 0);
--
delete from HI_Language where ID = 2702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2702, 0, '��ɫ����', 'GroupRole', 1, 0);
--
delete from HI_Language where ID = 2800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2800, 0, 'Ȩ����Դ', 1, 0);
--
delete from HI_Language where ID = 2801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2801, 0, 'Ȩ������', 'PrivilegeResource', 1, 0);
--
delete from HI_Language where ID = 2802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2802, 0, 'ҵ���', 'PrivilegeResource', 1, 0);
--
delete from HI_Language where ID = 2900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(2900, 0, 'Ȩ�޷�Χ', 1, 0);
--
delete from HI_Language where ID = 2901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2901, 0, '�û���', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2902, 0, '��ǰ���ż�', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2903;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2903, 0, '���ż�', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2904;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2904, 0, '���ż��Ӳ��ż�', 'securityScope', 1, 0);
--
delete from HI_Language where ID = 2905;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(2905, 0, 'ϵͳ��', 'securityScope', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--