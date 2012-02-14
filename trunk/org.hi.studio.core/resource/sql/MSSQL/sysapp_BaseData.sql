--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 5000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(5000, 0, 'sysapp', 'ϵͳ����', 'ϵͳ����', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 5000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(5000, 0, '/appSettingList.action', 'Ӧ������', 'Ӧ������', 5000, 9999, 5000, 0, 0);

--
delete from MenuLink where ID = 5100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(5100, 0, '/messageList.action', '��Ϣ', '��Ϣ', 5100, 9999, 5000, 0, 0);

--
delete from MenuLink where ID = 5200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(5200, 0, '/messageParameterList.action', '��Ϣ����', '��Ϣ����', 5200, 9999, 5000, 0, 0);

--
delete from MenuLink where ID = 5400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(5400, 0, '/hiLogList.action', 'ϵͳ��־', 'ϵͳ��־', 5400, 9999, 5000, 0, 0);

--
SET IDENTITY_INSERT MenuLink OFF
--
SET IDENTITY_INSERT HI_Authority ON
--
delete from HI_Authority where ID = 5000;
--
delete from HI_Authority where ID = 5001;
--
delete from HI_Authority where ID = 5002;
--
delete from HI_Authority where ID = 5003;
--
delete from HI_Authority where ID = 5004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5000, 0, 'APPSETTING_LIST', 'sysapp.AppSettingList', '', 'Ӧ�����ò�ѯ', 1, 5000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5001, 0, 'APPSETTING_VIEW', 'sysapp.AppSettingView', '', 'Ӧ�����ò鿴', 2, 5000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5002, 0, 'APPSETTING_SAVE', 'sysapp.AppSettingSave', '', 'Ӧ�����ñ���', 3, 5000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5003, 0, 'APPSETTING_DEL', 'sysapp.AppSettingDel', '', 'Ӧ������ɾ��', 4, 5000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5004, 0, 'APPSETTING_LOOKUP', 'sysapp.AppSettingLookup', '', 'Ӧ�����ô���', 1, 5000);

--
delete from HI_Authority where ID = 5100;
--
delete from HI_Authority where ID = 5101;
--
delete from HI_Authority where ID = 5102;
--
delete from HI_Authority where ID = 5103;
--
delete from HI_Authority where ID = 5104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5100, 0, 'MESSAGE_LIST', 'sysapp.MessageList', '', '��Ϣ��ѯ', 1, 5100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5101, 0, 'MESSAGE_VIEW', 'sysapp.MessageView', '', '��Ϣ�鿴', 2, 5100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5102, 0, 'MESSAGE_SAVE', 'sysapp.MessageSave', '', '��Ϣ����', 3, 5100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5103, 0, 'MESSAGE_DEL', 'sysapp.MessageDel', '', '��Ϣɾ��', 4, 5100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5104, 0, 'MESSAGE_LOOKUP', 'sysapp.MessageLookup', '', '��Ϣ����', 1, 5100);

--
delete from HI_Authority where ID = 5200;
--
delete from HI_Authority where ID = 5201;
--
delete from HI_Authority where ID = 5202;
--
delete from HI_Authority where ID = 5203;
--
delete from HI_Authority where ID = 5204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5200, 0, 'MESSAGEPARAMETER_LIST', 'sysapp.MessageParameterList', '', '��Ϣ������ѯ', 1, 5200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5201, 0, 'MESSAGEPARAMETER_VIEW', 'sysapp.MessageParameterView', '', '��Ϣ�����鿴', 2, 5200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5202, 0, 'MESSAGEPARAMETER_SAVE', 'sysapp.MessageParameterSave', '', '��Ϣ��������', 3, 5200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5203, 0, 'MESSAGEPARAMETER_DEL', 'sysapp.MessageParameterDel', '', '��Ϣ����ɾ��', 4, 5200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5204, 0, 'MESSAGEPARAMETER_LOOKUP', 'sysapp.MessageParameterLookup', '', '��Ϣ��������', 1, 5200);

--
delete from HI_Authority where ID = 5400;
--
delete from HI_Authority where ID = 5401;
--
delete from HI_Authority where ID = 5402;
--
delete from HI_Authority where ID = 5403;
--
delete from HI_Authority where ID = 5404;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5400, 0, 'HILOG_LIST', 'sysapp.HiLogList', '', 'ϵͳ��־��ѯ', 1, 5400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5401, 0, 'HILOG_VIEW', 'sysapp.HiLogView', '', 'ϵͳ��־�鿴', 2, 5400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5402, 0, 'HILOG_SAVE', 'sysapp.HiLogSave', '', 'ϵͳ��־����', 3, 5400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5403, 0, 'HILOG_DEL', 'sysapp.HiLogDel', '', 'ϵͳ��־ɾ��', 4, 5400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(5404, 0, 'HILOG_LOOKUP', 'sysapp.HiLogLookup', '', 'ϵͳ��־����', 1, 5400);

--
SET IDENTITY_INSERT HI_Authority OFF
--
SET IDENTITY_INSERT HI_PrivilegeResource ON
--
delete from HI_PrivilegeResource where ID = 5000;
--
delete from HI_PrivilegeResource where ID = 5001;
--
delete from HI_PrivilegeResource where ID = 5002;
--
delete from HI_PrivilegeResource where ID = 5003;
--
delete from HI_PrivilegeResource where ID = 5004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(5000, 0, 'APPSETTING_LIST', '/appSettingList.action', 'org.hi.base.sysapp.service.AppSettingManager.getSecurityAppSettingList', 'APPSETTING_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5001, 0, 'APPSETTING_VIEW', '/appSettingView.action', 'org.hi.base.sysapp.service.AppSettingManager.getSecurityAppSettingById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5002, 0, 'APPSETTING_SAVE', '/appSettingSave.action', 'org.hi.base.sysapp.service.AppSettingManager.saveSecurityAppSetting');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5003, 0, 'APPSETTING_DEL', '/appSettingRemove.action', 'org.hi.base.sysapp.service.AppSettingManager.removeSecurityAppSettingById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(5004, 0, 'APPSETTING_LOOKUP', '/appSettingLookup.action');
--
delete from HI_PrivilegeResource where ID = 5100;
--
delete from HI_PrivilegeResource where ID = 5101;
--
delete from HI_PrivilegeResource where ID = 5102;
--
delete from HI_PrivilegeResource where ID = 5103;
--
delete from HI_PrivilegeResource where ID = 5104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(5100, 0, 'MESSAGE_LIST', '/messageList.action', 'org.hi.base.sysapp.service.MessageManager.getSecurityMessageList', 'MESSAGE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5101, 0, 'MESSAGE_VIEW', '/messageView.action', 'org.hi.base.sysapp.service.MessageManager.getSecurityMessageById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5102, 0, 'MESSAGE_SAVE', '/messageSave.action', 'org.hi.base.sysapp.service.MessageManager.saveSecurityMessage');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5103, 0, 'MESSAGE_DEL', '/messageRemove.action', 'org.hi.base.sysapp.service.MessageManager.removeSecurityMessageById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(5104, 0, 'MESSAGE_LOOKUP', '/messageLookup.action');
--
delete from HI_PrivilegeResource where ID = 5200;
--
delete from HI_PrivilegeResource where ID = 5201;
--
delete from HI_PrivilegeResource where ID = 5202;
--
delete from HI_PrivilegeResource where ID = 5203;
--
delete from HI_PrivilegeResource where ID = 5204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(5200, 0, 'MESSAGEPARAMETER_LIST', '/messageParameterList.action', 'org.hi.base.sysapp.service.MessageParameterManager.getSecurityMessageParameterList', 'MESSAGEPARAMETER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5201, 0, 'MESSAGEPARAMETER_VIEW', '/messageParameterView.action', 'org.hi.base.sysapp.service.MessageParameterManager.getSecurityMessageParameterById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5202, 0, 'MESSAGEPARAMETER_SAVE', '/messageParameterSave.action', 'org.hi.base.sysapp.service.MessageParameterManager.saveSecurityMessageParameter');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5203, 0, 'MESSAGEPARAMETER_DEL', '/messageParameterRemove.action', 'org.hi.base.sysapp.service.MessageParameterManager.removeSecurityMessageParameterById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(5204, 0, 'MESSAGEPARAMETER_LOOKUP', '/messageParameterLookup.action');
--
delete from HI_PrivilegeResource where ID = 5400;
--
delete from HI_PrivilegeResource where ID = 5401;
--
delete from HI_PrivilegeResource where ID = 5402;
--
delete from HI_PrivilegeResource where ID = 5403;
--
delete from HI_PrivilegeResource where ID = 5404;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(5400, 0, 'HILOG_LIST', '/hiLogList.action', 'org.hi.base.sysapp.service.HiLogManager.getSecurityHiLogList', 'HILOG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5401, 0, 'HILOG_VIEW', '/hiLogView.action', 'org.hi.base.sysapp.service.HiLogManager.getSecurityHiLogById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5402, 0, 'HILOG_SAVE', '/hiLogSave.action', 'org.hi.base.sysapp.service.HiLogManager.saveSecurityHiLog');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(5403, 0, 'HILOG_DEL', '/hiLogRemove.action', 'org.hi.base.sysapp.service.HiLogManager.removeSecurityHiLogById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(5404, 0, 'HILOG_LOOKUP', '/hiLogLookup.action');
--
SET IDENTITY_INSERT HI_PrivilegeResource OFF
--
SET IDENTITY_INSERT Enumeration ON
--
delete from Enumeration where ID = 5300;
--
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(5300, 0, 'messageType', '��Ϣ����', '��Ϣ����', 0, 0);
--
SET IDENTITY_INSERT Enumeration OFF
--
SET IDENTITY_INSERT EnumerationValue ON
--
delete from EnumerationValue where ID = 5300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(5300, 0, 'SMS', '�ֻ�����', '�ֻ�����', 5300, 0);
--
delete from EnumerationValue where ID = 5301;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(5301, 0, 'InternalMail', '�ڲ��ʼ�', '�ڲ��ʼ�', 5300, 0);
--
delete from EnumerationValue where ID = 5302;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(5302, 0, 'ExternalMail', '�ⲿ�ʼ�', '�ⲿ�ʼ�', 5300, 0);
--
delete from EnumerationValue where ID = 5303;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(5303, 0, 'InteralMessage', '����Ϣ', '����Ϣ', 5300, 0);
--
delete from EnumerationValue where ID = 5304;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(5304, 0, 'QQ', 'QQ', 'QQ', 5300, 0);
--
delete from EnumerationValue where ID = 5305;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(5305, 0, 'MSN', 'MSN', 'MSN', 5300, 0);
--
SET IDENTITY_INSERT EnumerationValue OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 5000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(5000, 0, 'Ӧ������', 1, 0);
--
delete from HI_Language where ID = 5001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5001, 0, '����', 'AppSetting', 1, 0);
--
delete from HI_Language where ID = 5002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5002, 0, '������', 'AppSetting', 1, 0);
--
delete from HI_Language where ID = 5003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5003, 0, '����ֵ', 'AppSetting', 1, 0);
--
delete from HI_Language where ID = 5100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(5100, 0, '��Ϣ', 1, 0);
--
delete from HI_Language where ID = 5101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5101, 0, '������', 'Message', 1, 0);
--
delete from HI_Language where ID = 5102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5102, 0, '������', 'Message', 1, 0);
--
delete from HI_Language where ID = 5103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5103, 0, '��Ϣ����', 'Message', 1, 0);
--
delete from HI_Language where ID = 5104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5104, 0, '����ʱ��', 'Message', 1, 0);
--
delete from HI_Language where ID = 5105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5105, 0, '����ʱ��', 'Message', 1, 0);
--
delete from HI_Language where ID = 5106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5106, 0, '�ѷ���', 'Message', 1, 0);
--
delete from HI_Language where ID = 5107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5107, 0, '����', 'Message', 1, 0);
--
delete from HI_Language where ID = 5200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(5200, 0, '��Ϣ����', 1, 0);
--
delete from HI_Language where ID = 5201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5201, 0, '������', 'MessageParameter', 1, 0);
--
delete from HI_Language where ID = 5202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5202, 0, '����ֵ', 'MessageParameter', 1, 0);
--
delete from HI_Language where ID = 5300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(5300, 0, '��Ϣ����', 1, 0);
--
delete from HI_Language where ID = 5301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5301, 0, '�ֻ�����', 'messageType', 1, 0);
--
delete from HI_Language where ID = 5302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5302, 0, '�ڲ��ʼ�', 'messageType', 1, 0);
--
delete from HI_Language where ID = 5303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5303, 0, '�ⲿ�ʼ�', 'messageType', 1, 0);
--
delete from HI_Language where ID = 5304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5304, 0, '����Ϣ', 'messageType', 1, 0);
--
delete from HI_Language where ID = 5305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5305, 0, 'QQ', 'messageType', 1, 0);
--
delete from HI_Language where ID = 5306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5306, 0, 'MSN', 'messageType', 1, 0);
--
delete from HI_Language where ID = 5400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(5400, 0, 'ϵͳ��־', 1, 0);
--
delete from HI_Language where ID = 5401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5401, 0, '������', 'HiLog', 1, 0);
--
delete from HI_Language where ID = 5402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5402, 0, '����ʱ��', 'HiLog', 1, 0);
--
delete from HI_Language where ID = 5403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5403, 0, '����', 'HiLog', 1, 0);
--
delete from HI_Language where ID = 5404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(5404, 0, '��������', 'HiLog', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--