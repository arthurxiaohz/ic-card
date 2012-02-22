--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = ${service.baseData?c};
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(${service.baseData?c}, 0, '${service.serviceName}', '${service.description}', '${service.description}', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
<#list service.entity as entity><#if entity.entityType != 2 && serviceTool.hasInEntity(entity.entityName, entitySet)><#if serviceTool.getParentEntity(entity, allServices)?exists><#else>
--
delete from MenuLink where ID = ${serviceTool.getSeedData(service,entity)?c};
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(${serviceTool.getSeedData(service,entity)?c}, 0, '/${entity.entityName?uncap_first}List.action', '${entity.entityLabel}', '${entity.entityLabel}', ${serviceTool.getSeedData(service,entity)?c}, 9999, ${service.baseData?c}, 0, 0);

</#if></#if></#list>
--
SET IDENTITY_INSERT MenuLink OFF
--
SET IDENTITY_INSERT HI_Authority ON
<#list service.entity as entity><#if entity.entityType != 2 && serviceTool.hasInEntity(entity.entityName, entitySet)>
--
delete from HI_Authority where ID = ${serviceTool.getSeedData(service,entity)?c};
--
delete from HI_Authority where ID = ${(serviceTool.getSeedData(service,entity)+1)?c};
--
delete from HI_Authority where ID = ${(serviceTool.getSeedData(service,entity)+2)?c};
--
delete from HI_Authority where ID = ${(serviceTool.getSeedData(service,entity)+3)?c};
--
delete from HI_Authority where ID = ${(serviceTool.getSeedData(service,entity)+4)?c};
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(${serviceTool.getSeedData(service,entity)?c}, 0, '${entity.entityName?upper_case}_LIST', '${service.serviceName}.${entity.entityName?cap_first}List', '', '${entity.entityLabel}查询', 1, ${serviceTool.getSeedData(service,entity)?c});
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(${(serviceTool.getSeedData(service,entity)+1)?c}, 0, '${entity.entityName?upper_case}_VIEW', '${service.serviceName}.${entity.entityName?cap_first}View', '', '${entity.entityLabel}查看', 2, ${serviceTool.getSeedData(service,entity)?c});
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(${(serviceTool.getSeedData(service,entity)+2)?c}, 0, '${entity.entityName?upper_case}_SAVE', '${service.serviceName}.${entity.entityName?cap_first}Save', '', '${entity.entityLabel}保存', 3, ${serviceTool.getSeedData(service,entity)?c});
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(${(serviceTool.getSeedData(service,entity)+3)?c}, 0, '${entity.entityName?upper_case}_DEL', '${service.serviceName}.${entity.entityName?cap_first}Del', '', '${entity.entityLabel}删除', 4, ${serviceTool.getSeedData(service,entity)?c});
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(${(serviceTool.getSeedData(service,entity)+4)?c}, 0, '${entity.entityName?upper_case}_LOOKUP', '${service.serviceName}.${entity.entityName?cap_first}Lookup', '', '${entity.entityLabel}带回', 1, ${serviceTool.getSeedData(service,entity)?c});

</#if></#list>
--
SET IDENTITY_INSERT HI_Authority OFF
--
SET IDENTITY_INSERT HI_PrivilegeResource ON
<#list service.entity as entity><#if entity.entityType != 2 && serviceTool.hasInEntity(entity.entityName, entitySet)>
--
delete from HI_PrivilegeResource where ID = ${serviceTool.getSeedData(service,entity)?c};
--
delete from HI_PrivilegeResource where ID = ${(serviceTool.getSeedData(service,entity)+1)?c};
--
delete from HI_PrivilegeResource where ID = ${(serviceTool.getSeedData(service,entity)+2)?c};
--
delete from HI_PrivilegeResource where ID = ${(serviceTool.getSeedData(service,entity)+3)?c};
--
delete from HI_PrivilegeResource where ID = ${(serviceTool.getSeedData(service,entity)+4)?c};
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(${serviceTool.getSeedData(service,entity)?c}, 0, '${entity.entityName?upper_case}_LIST', '/${entity.entityName?uncap_first}List.action', '${service.packageName}.service.${entity.entityName?cap_first}Manager.getSecurity${entity.entityName?cap_first}List', '${entity.entityName?upper_case}_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(${(serviceTool.getSeedData(service,entity)+1)?c}, 0, '${entity.entityName?upper_case}_VIEW', '/${entity.entityName?uncap_first}View.action', '${service.packageName}.service.${entity.entityName?cap_first}Manager.getSecurity${entity.entityName?cap_first}ById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(${(serviceTool.getSeedData(service,entity)+2)?c}, 0, '${entity.entityName?upper_case}_SAVE', '/${entity.entityName?uncap_first}Save.action', '${service.packageName}.service.${entity.entityName?cap_first}Manager.saveSecurity${entity.entityName?cap_first}');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(${(serviceTool.getSeedData(service,entity)+3)?c}, 0, '${entity.entityName?upper_case}_DEL', '/${entity.entityName?uncap_first}Remove.action', '${service.packageName}.service.${entity.entityName?cap_first}Manager.removeSecurity${entity.entityName?cap_first}ById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(${(serviceTool.getSeedData(service,entity)+4)?c}, 0, '${entity.entityName?upper_case}_LOOKUP', '/${entity.entityName?uncap_first}Lookup.action');
</#if></#list>
--
SET IDENTITY_INSERT HI_PrivilegeResource OFF
--
SET IDENTITY_INSERT Enumeration ON
<#list service.entity as entity><#if entity.entityType == 2 && serviceTool.hasInEntity(entity.entityName, entitySet)>
--
delete from Enumeration where ID = ${serviceTool.getSeedData(service,entity)?c};
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(${serviceTool.getSeedData(service,entity)?c}, 0, '${entity.entityName?uncap_first}', '${entity.entityLabel}', '${entity.entityLabel}', 0, 0);
</#if></#list>
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
<#list service.entity as entity><#if entity.entityType == 2 && serviceTool.hasInEntity(entity.entityName, entitySet)><#list entity.enumeration as enumeration>
--
delete from EnumerationValue where ID = ${(serviceTool.getSeedData(service,entity) + enumeration_index)?c};
--
insert into EnumerationValue(ID, version, valueName, displayRef, description,<#if enumeration.enuCode??> valueCode,</#if> enumeration, creator) values(${(serviceTool.getSeedData(service,entity) + enumeration_index)?c}, 0, '${enumeration.enuValue}', '${enumeration.enuLabel}', '${enumeration.enuLabel}',<#if enumeration.enuCode??> '${enumeration.enuCode}',</#if> ${serviceTool.getSeedData(service,entity)?c}, 0);
</#list></#if></#list>
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
<#list service.entity as entity><#if entity.entityType != 2 && serviceTool.hasInEntity(entity.entityName, entitySet)>
--
delete from HI_Language where ID = ${serviceTool.getSeedData(service,entity)?c};
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(${serviceTool.getSeedData(service,entity)?c}, 0, '${entity.entityLabel}', 1, 0);
<#list serviceTool.getDisplayFields(entity) as field>
--
delete from HI_Language where ID = ${(serviceTool.getSeedData(service,entity)+field_index+1)?c};
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(${(serviceTool.getSeedData(service,entity)+field_index+1)?c}, 0, '${field.fieldLabel}', '${entity.entityName}', 1, 0);
</#list></#if><#if entity.entityType == 2 && serviceTool.hasInEntity(entity.entityName, entitySet)>
--
delete from HI_Language where ID = ${serviceTool.getSeedData(service,entity)?c};
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(${serviceTool.getSeedData(service,entity)?c}, 0, '${entity.entityLabel}', 1, 0);
<#list entity.enumeration as enumeration>
--
delete from HI_Language where ID = ${(serviceTool.getSeedData(service,entity)+enumeration_index+1)?c};
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(${(serviceTool.getSeedData(service,entity)+enumeration_index+1)?c}, 0, '${enumeration.enuLabel}', '${entity.entityName?uncap_first}', 1, 0);
</#list></#if></#list>
--
SET IDENTITY_INSERT HI_Language OFF
--