--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 3000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(3000, 0, 'enumeration', '枚举管理', '枚举管理', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 3000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(3000, 0, '/enumerationList.action', '枚举实体', '枚举实体', 3000, 9999, 3000, 0, 0);

--
delete from MenuLink where ID = 3100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(3100, 0, '/enumerationValueList.action', '枚举值', '枚举值', 3100, 9999, 3000, 0, 0);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3000, 0, 'ENUMERATION_LIST', 'enumeration.EnumerationList', '', '枚举实体查询', 1, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3001, 0, 'ENUMERATION_VIEW', 'enumeration.EnumerationView', '', '枚举实体查看', 2, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3002, 0, 'ENUMERATION_SAVE', 'enumeration.EnumerationSave', '', '枚举实体保存', 3, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3003, 0, 'ENUMERATION_DEL', 'enumeration.EnumerationDel', '', '枚举实体删除', 4, 3000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3004, 0, 'ENUMERATION_LOOKUP', 'enumeration.EnumerationLookup', '', '枚举实体带回', 1, 3000);

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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3100, 0, 'ENUMERATIONVALUE_LIST', 'enumeration.EnumerationValueList', '', '枚举值查询', 1, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3101, 0, 'ENUMERATIONVALUE_VIEW', 'enumeration.EnumerationValueView', '', '枚举值查看', 2, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3102, 0, 'ENUMERATIONVALUE_SAVE', 'enumeration.EnumerationValueSave', '', '枚举值保存', 3, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3103, 0, 'ENUMERATIONVALUE_DEL', 'enumeration.EnumerationValueDel', '', '枚举值删除', 4, 3100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(3104, 0, 'ENUMERATIONVALUE_LOOKUP', 'enumeration.EnumerationValueLookup', '', '枚举值带回', 1, 3100);

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
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(3200, 0, 'yesNo', '是否', '是否', 0, 0);
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
--
delete from EnumerationValue where ID = 3200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(3200, 0, 'Yes', '是', '是', 3200, 0);
--
delete from EnumerationValue where ID = 3201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(3201, 0, 'No', '否', '否', 3200, 0);
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 3000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(3000, 0, '枚举实体', 1, 0);
--
delete from HI_Language where ID = 3001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3001, 0, '枚举名称', 'Enumeration', 1, 0);
--
delete from HI_Language where ID = 3002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3002, 0, '显示信息', 'Enumeration', 1, 0);
--
delete from HI_Language where ID = 3003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3003, 0, '描述', 'Enumeration', 1, 0);
--
delete from HI_Language where ID = 3100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(3100, 0, '枚举值', 1, 0);
--
delete from HI_Language where ID = 3101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3101, 0, '枚举值名称', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3102, 0, '显示信息', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3103, 0, '描述', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3104, 0, '枚举值编号', 'EnumerationValue', 1, 0);
--
delete from HI_Language where ID = 3200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(3200, 0, '是否', 1, 0);
--
delete from HI_Language where ID = 3201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3201, 0, '是', 'yesNo', 1, 0);
--
delete from HI_Language where ID = 3202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(3202, 0, '否', 'yesNo', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--