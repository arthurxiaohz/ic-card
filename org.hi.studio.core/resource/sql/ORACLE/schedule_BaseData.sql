
delete from HiMenu where ID = 4000;
/---
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(4000, 0, 'schedule', '任务管理', '任务管理', 0, 9999, 0);
/---

delete from MenuLink where ID = 4000;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(4000, 0, '/jobDetailDefList.action', '工作项定义', '工作项定义', 4000, 9999, 4000, 0, 0);
/---
delete from MenuLink where ID = 4100;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(4100, 0, '/triggerDefList.action', '触发器', '触发器', 4100, 9999, 4000, 0, 0);
/---

delete from HI_Authority where ID = 4000;
/---
delete from HI_Authority where ID = 4001;
/---
delete from HI_Authority where ID = 4002;
/---
delete from HI_Authority where ID = 4003;
/---
delete from HI_Authority where ID = 4004;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4000, 0, 'JOBDETAILDEF_LIST', 'schedule.JobDetailDefList', '', '工作项定义查询', 1, 4000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4001, 0, 'JOBDETAILDEF_VIEW', 'schedule.JobDetailDefView', '', '工作项定义查看', 2, 4000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4002, 0, 'JOBDETAILDEF_SAVE', 'schedule.JobDetailDefSave', '', '工作项定义保存', 3, 4000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4003, 0, 'JOBDETAILDEF_DEL', 'schedule.JobDetailDefDel', '', '工作项定义删除', 4, 4000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4004, 0, 'JOBDETAILDEF_LOOKUP', 'schedule.JobDetailDefLookup', '', '工作项定义带回', 1, 4000);
/---

delete from HI_Authority where ID = 4100;
/---
delete from HI_Authority where ID = 4101;
/---
delete from HI_Authority where ID = 4102;
/---
delete from HI_Authority where ID = 4103;
/---
delete from HI_Authority where ID = 4104;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4100, 0, 'TRIGGERDEF_LIST', 'schedule.TriggerDefList', '', '触发器查询', 1, 4100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4101, 0, 'TRIGGERDEF_VIEW', 'schedule.TriggerDefView', '', '触发器查看', 2, 4100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4102, 0, 'TRIGGERDEF_SAVE', 'schedule.TriggerDefSave', '', '触发器保存', 3, 4100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4103, 0, 'TRIGGERDEF_DEL', 'schedule.TriggerDefDel', '', '触发器删除', 4, 4100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(4104, 0, 'TRIGGERDEF_LOOKUP', 'schedule.TriggerDefLookup', '', '触发器带回', 1, 4100);
/---


delete from HI_PrivilegeResource where ID = 4000;
/---
delete from HI_PrivilegeResource where ID = 4001;
/---
delete from HI_PrivilegeResource where ID = 4002;
/---
delete from HI_PrivilegeResource where ID = 4003;
/---
delete from HI_PrivilegeResource where ID = 4004;
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(4000, 0, 'JOBDETAILDEF_LIST', '/jobDetailDefList.action', 'org.hi.base.schedule.service.JobDetailDefManager.getSecurityJobDetailDefList', 'JOBDETAILDEF_LOOKUP');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(4001, 0, 'JOBDETAILDEF_VIEW', '/jobDetailDefView.action', 'org.hi.base.schedule.service.JobDetailDefManager.getSecurityJobDetailDefById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(4002, 0, 'JOBDETAILDEF_SAVE', '/jobDetailDefSave.action', 'org.hi.base.schedule.service.JobDetailDefManager.saveSecurityJobDetailDef');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(4003, 0, 'JOBDETAILDEF_DEL', '/jobDetailDefRemove.action', 'org.hi.base.schedule.service.JobDetailDefManager.removeSecurityJobDetailDefById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(4004, 0, 'JOBDETAILDEF_LOOKUP', '/jobDetailDefLookup.action');
/---

delete from HI_PrivilegeResource where ID = 4100;
/---
delete from HI_PrivilegeResource where ID = 4101;
/---
delete from HI_PrivilegeResource where ID = 4102;
/---
delete from HI_PrivilegeResource where ID = 4103;
/---
delete from HI_PrivilegeResource where ID = 4104;
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(4100, 0, 'TRIGGERDEF_LIST', '/triggerDefList.action', 'org.hi.base.schedule.service.TriggerDefManager.getSecurityTriggerDefList', 'TRIGGERDEF_LOOKUP');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(4101, 0, 'TRIGGERDEF_VIEW', '/triggerDefView.action', 'org.hi.base.schedule.service.TriggerDefManager.getSecurityTriggerDefById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(4102, 0, 'TRIGGERDEF_SAVE', '/triggerDefSave.action', 'org.hi.base.schedule.service.TriggerDefManager.saveSecurityTriggerDef');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(4103, 0, 'TRIGGERDEF_DEL', '/triggerDefRemove.action', 'org.hi.base.schedule.service.TriggerDefManager.removeSecurityTriggerDefById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(4104, 0, 'TRIGGERDEF_LOOKUP', '/triggerDefLookup.action');
/---




/---
delete from HI_Language where ID = 4000;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(4000, 0, '工作项定义', 1, 0);
/---
delete from HI_Language where ID = 4001;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4001, 0, '工作名称', 'JobDetailDef', 1, 0);
/---
delete from HI_Language where ID = 4002;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4002, 0, '类全名', 'JobDetailDef', 1, 0);
/---
delete from HI_Language where ID = 4003;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4003, 0, '工作描述', 'JobDetailDef', 1, 0);
/---
delete from HI_Language where ID = 4100;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(4100, 0, '触发器', 1, 0);
/---
delete from HI_Language where ID = 4101;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4101, 0, '触发名称', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4102;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4102, 0, '工作项', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4103;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4103, 0, '优先级', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4104;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4104, 0, '开始时间', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4105;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4105, 0, '截止时间', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4106;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4106, 0, '表达式', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4107;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4107, 0, '激活', 'TriggerDef', 1, 0);
/---
delete from HI_Language where ID = 4108;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(4108, 0, '触发器描述', 'TriggerDef', 1, 0);
