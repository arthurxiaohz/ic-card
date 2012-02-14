--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 3000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(3000, 0, 'enumeration', 'ö�ٹ���', 'ö�ٹ���', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 3000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(3000, 0, '/enumerationList.action', 'ö��ʵ��', 'ö��ʵ��', 3000, 9999, 3000, 0, 0);

--
delete from MenuLink where ID = 3100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(3100, 0, '/enumerationValueList.action', 'ö��ֵ', 'ö��ֵ', 3100, 9999, 3000, 0, 0);

--
SET IDENTITY_INSERT MenuLink OFF
--
SET IDENTITY_INSERT HI_Authority ON
--
delete from HI_Authority where ID = 3000;
--
delete from HI_Authority where ID = 3001;
--
delete from HI_Authority where ID = 3002;
--
delete from HI_Authority where ID = 3003;
--
delete from HI_Authority where ID = 3004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3000, 0, 'ENUMERATION_LIST', 'enumeration.EnumerationList', '', 'ö��ʵ���ѯ', 1, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3001, 0, 'ENUMERATION_VIEW', 'enumeration.EnumerationView', '', 'ö��ʵ��鿴', 2, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3002, 0, 'ENUMERATION_SAVE', 'enumeration.EnumerationSave', '', 'ö��ʵ�屣��', 3, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3003, 0, 'ENUMERATION_DEL', 'enumeration.EnumerationDel', '', 'ö��ʵ��ɾ��', 4, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3004, 0, 'ENUMERATION_LOOKUP', 'enumeration.EnumerationLookup', '', 'ö��ʵ�����', 1, 3000);

--
delete from HI_Authority where ID = 3100;
--
delete from HI_Authority where ID = 3101;
--
delete from HI_Authority where ID = 3102;
--
delete from HI_Authority where ID = 3103;
--
delete from HI_Authority where ID = 3104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3100, 0, 'ENUMERATIONVALUE_LIST', 'enumeration.EnumerationValueList', '', 'ö��ֵ��ѯ', 1, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3101, 0, 'ENUMERATIONVALUE_VIEW', 'enumeration.EnumerationValueView', '', 'ö��ֵ�鿴', 2, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3102, 0, 'ENUMERATIONVALUE_SAVE', 'enumeration.EnumerationValueSave', '', 'ö��ֵ����', 3, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3103, 0, 'ENUMERATIONVALUE_DEL', 'enumeration.EnumerationValueDel', '', 'ö��ֵɾ��', 4, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3104, 0, 'ENUMERATIONVALUE_LOOKUP', 'enumeration.EnumerationValueLookup', '', 'ö��ֵ����', 1, 3100);

--
SET IDENTITY_INSERT HI_Authority OFF
--
SET IDENTITY_INSERT HI_PrivilegeResource ON
--
delete from HI_PrivilegeResource where ID = 3000;
--
delete from HI_PrivilegeResource where ID = 3001;
--
delete from HI_PrivilegeResource where ID = 3002;
--
delete from HI_PrivilegeResource where ID = 3003;
--
delete from HI_PrivilegeResource where ID = 3004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(3000, 0, 'ENUMERATION_LIST', '/enumerationList.action', 'org.hi.base.enumeration.service.EnumerationManager.getSecurityEnumerationList', 'ENUMERATION_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(3001, 0, 'ENUMERATION_VIEW', '/enumerationView.action', 'org.hi.base.enumeration.service.EnumerationManager.getSecurityEnumerationById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(3002, 0, 'ENUMERATION_SAVE', '/enumerationSave.action', 'org.hi.base.enumeration.service.EnumerationManager.saveSecurityEnumeration');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(3003, 0, 'ENUMERATION_DEL', '/enumerationRemove.action', 'org.hi.base.enumeration.service.EnumerationManager.removeSecurityEnumerationById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(3004, 0, 'ENUMERATION_LOOKUP', '/enumerationLookup.action');
--
delete from HI_PrivilegeResource where ID = 3100;
--
delete from HI_PrivilegeResource where ID = 3101;
--
delete from HI_PrivilegeResource where ID = 3102;
--
delete from HI_PrivilegeResource where ID = 3103;
--
delete from HI_PrivilegeResource where ID = 3104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(3100, 0, 'ENUMERATIONVALUE_LIST', '/enumerationValueList.action', 'org.hi.base.enumeration.service.EnumerationValueManager.getSecurityEnumerationValueList', 'ENUMERATIONVALUE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(3101, 0, 'ENUMERATIONVALUE_VIEW', '/enumerationValueView.action', 'org.hi.base.enumeration.service.EnumerationValueManager.getSecurityEnumerationValueById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(3102, 0, 'ENUMERATIONVALUE_SAVE', '/enumerationValueSave.action', 'org.hi.base.enumeration.service.EnumerationValueManager.saveSecurityEnumerationValue');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(3103, 0, 'ENUMERATIONVALUE_DEL', '/enumerationValueRemove.action', 'org.hi.base.enumeration.service.EnumerationValueManager.removeSecurityEnumerationValueById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(3104, 0, 'ENUMERATIONVALUE_LOOKUP', '/enumerationValueLookup.action');
--
SET IDENTITY_INSERT HI_PrivilegeResource OFF
--
SET IDENTITY_INSERT Enumeration ON
--
delete from Enumeration where ID = 3200;
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(3200, 0, 'yesNo', '�Ƿ�', '�Ƿ�', 0, 0);
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
--
delete from EnumerationValue where ID = 3200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(3200, 0, 'Yes', '��', '��', 3200, 0);
--
delete from EnumerationValue where ID = 3201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(3201, 0, 'No', '��', '��', 3200, 0);
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 3000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(3000, 0, 'ö��ʵ��', 1, 0);
--
delete from HI_Language where ID = 3001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3001, 0, 'ö������', 'Enumeration', 1, 0);
--
delete from HI_Language where ID = 3002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3002, 0, '��ʾ��Ϣ', 'Enumeration', 1, 0);
--
delete from HI_Language where ID = 3003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3003, 0, '����', 'Enumeration', 1, 0);
--
delete from HI_Language where ID = 3100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(3100, 0, 'ö��ֵ', 1, 0);
--
delete from HI_Language where ID = 3101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3101, 0, 'ö��ֵ����', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3102, 0, '��ʾ��Ϣ', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3103, 0, '����', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3104, 0, 'ö��ֵ���', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(3200, 0, '�Ƿ�', 1, 0);
--
delete from HI_Language where ID = 3201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3201, 0, '��', 'yesNo', 1, 0);
--
delete from HI_Language where ID = 3202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3202, 0, '��', 'yesNo', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--