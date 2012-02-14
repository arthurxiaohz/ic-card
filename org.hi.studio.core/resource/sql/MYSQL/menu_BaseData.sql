
delete from HiMenu where ID = 10000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(10000, 0, 'menu', '�˵�����', '�˵�����', 0, 9999, 0);
--



delete from MenuLink where ID = 10000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(10000, 0, '/menuList.action', '�˵���', '�˵���', 10000, 9999, 10000, 0, 0);
--
delete from MenuLink where ID = 10100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(10100, 0, '/menuLinkList.action', '�˵�����', '�˵�����', 10100, 9999, 10000, 0, 0);
--



delete from HI_Authority where ID = 10000;
--
delete from HI_Authority where ID = 10001;
--
delete from HI_Authority where ID = 10002;
--
delete from HI_Authority where ID = 10003;
--
delete from HI_Authority where ID = 10004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10000, 0, 'MENU_LIST', 'menu.MenuList', '', '�˵����ѯ', 1, 10000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10001, 0, 'MENU_VIEW', 'menu.MenuView', '', '�˵���鿴', 2, 10000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10002, 0, 'MENU_SAVE', 'menu.MenuSave', '', '�˵����', 3, 10000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10003, 0, 'MENU_DEL', 'menu.MenuDel', '', '�˵���ɾ��', 4, 10000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10004, 0, 'MENU_LOOKUP', 'menu.MenuLookup', '', '�˵������', 1, 10000);
--
delete from HI_Authority where ID = 10100;
--
delete from HI_Authority where ID = 10101;
--
delete from HI_Authority where ID = 10102;
--
delete from HI_Authority where ID = 10103;
--
delete from HI_Authority where ID = 10104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10100, 0, 'MENULINK_LIST', 'menu.MenuLinkList', '', '�˵����Ӳ�ѯ', 1, 10100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10101, 0, 'MENULINK_VIEW', 'menu.MenuLinkView', '', '�˵����Ӳ鿴', 2, 10100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10102, 0, 'MENULINK_SAVE', 'menu.MenuLinkSave', '', '�˵����ӱ���', 3, 10100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10103, 0, 'MENULINK_DEL', 'menu.MenuLinkDel', '', '�˵�����ɾ��', 4, 10100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(10104, 0, 'MENULINK_LOOKUP', 'menu.MenuLinkLookup', '', '�˵����Ӵ���', 1, 10100);
--

delete from HI_PrivilegeResource where ID = 10000;
--
delete from HI_PrivilegeResource where ID = 10001;
--
delete from HI_PrivilegeResource where ID = 10002;
--
delete from HI_PrivilegeResource where ID = 10003;
--
delete from HI_PrivilegeResource where ID = 10004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(10000, 0, 'MENU_LIST', '/menuList.action', 'org.hi.base.menu.service.MenuManager.getSecurityMenuList', 'MENU_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(10001, 0, 'MENU_VIEW', '/menuView.action', 'org.hi.base.menu.service.MenuManager.getSecurityMenuById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(10002, 0, 'MENU_SAVE', '/menuSave.action', 'org.hi.base.menu.service.MenuManager.saveSecurityMenu');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(10003, 0, 'MENU_DEL', '/menuRemove.action', 'org.hi.base.menu.service.MenuManager.removeSecurityMenuById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(10004, 0, 'MENU_LOOKUP', '/menuLookup.action');
--
delete from HI_PrivilegeResource where ID = 10100;
--
delete from HI_PrivilegeResource where ID = 10101;
--
delete from HI_PrivilegeResource where ID = 10102;
--
delete from HI_PrivilegeResource where ID = 10103;
--
delete from HI_PrivilegeResource where ID = 10104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(10100, 0, 'MENULINK_LIST', '/menuLinkList.action', 'org.hi.base.menu.service.MenuLinkManager.getSecurityMenuLinkList', 'MENULINK_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(10101, 0, 'MENULINK_VIEW', '/menuLinkView.action', 'org.hi.base.menu.service.MenuLinkManager.getSecurityMenuLinkById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(10102, 0, 'MENULINK_SAVE', '/menuLinkSave.action', 'org.hi.base.menu.service.MenuLinkManager.saveSecurityMenuLink');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(10103, 0, 'MENULINK_DEL', '/menuLinkRemove.action', 'org.hi.base.menu.service.MenuLinkManager.removeSecurityMenuLinkById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(10104, 0, 'MENULINK_LOOKUP', '/menuLinkLookup.action');
--







--
delete from HI_Language where ID = 10000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(10000, 0, '�˵���', 1, 0);
--
delete from HI_Language where ID = 10001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10001, 0, '�˵�����', 'Menu', 1, 0);
--
delete from HI_Language where ID = 10002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10002, 0, '����', 'Menu', 1, 0);
--
delete from HI_Language where ID = 10003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10003, 0, '���˵���', 'Menu', 1, 0);
--
delete from HI_Language where ID = 10004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10004, 0, '����', 'Menu', 1, 0);
--
delete from HI_Language where ID = 10100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(10100, 0, '�˵�����', 1, 0);
--
delete from HI_Language where ID = 10101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10101, 0, '�˵�URL', 'MenuLink', 1, 0);
--
delete from HI_Language where ID = 10102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10102, 0, '����', 'MenuLink', 1, 0);
--
delete from HI_Language where ID = 10103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10103, 0, 'Ȩ������', 'MenuLink', 1, 0);
--
delete from HI_Language where ID = 10104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10104, 0, '����', 'MenuLink', 1, 0);
--
delete from HI_Language where ID = 10105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10105, 0, '�˵�������', 'MenuLink', 1, 0);
--
delete from HI_Language where ID = 10106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(10106, 0, '�˵�������', 'MenuLink', 1, 0);
