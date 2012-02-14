--
SET IDENTITY_INSERT HiMenu ON
--
delete from HiMenu where ID = 42000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(42000, 0, 'i18n', '���ʻ�', '���ʻ�', 0, 9999, 0);
--
SET IDENTITY_INSERT HiMenu OFF
--
SET IDENTITY_INSERT MenuLink ON
--
delete from MenuLink where ID = 42100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(42100, 0, '/languageList.action', '��������Ϣ', '��������Ϣ', 42100, 9999, 42000, 1, 0);

--
delete from MenuLink where ID = 42200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(42200, 0, '/languageCodeList.action', '���Ա���', '���Ա���', 42200, 9999, 42000, 1, 0);

--
delete from MenuLink where ID = 42400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(42400, 0, '/timezoneList.action', 'ʱ��', 'ʱ��', 42400, 9999, 42000, 1, 0);

--
SET IDENTITY_INSERT MenuLink OFF
--
SET IDENTITY_INSERT HI_Language ON
--
delete from HI_Language where ID = 42100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(42100, 0, '��������Ϣ', 1, 0);
--
delete from HI_Language where ID = 42101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42101, 0, 'Keyֵ', 'Language', 1, 0);
--
delete from HI_Language where ID = 42102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42102, 0, '����', 'Language', 1, 0);
--
delete from HI_Language where ID = 42103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42103, 0, 'ʵ��', 'Language', 1, 0);
--
delete from HI_Language where ID = 42200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(42200, 0, '���Ա���', 1, 0);
--
delete from HI_Language where ID = 42201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42201, 0, '���Ա���', 'LanguageCode', 1, 0);
--
delete from HI_Language where ID = 42202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42202, 0, '����', 'LanguageCode', 1, 0);
--
delete from HI_Language where ID = 42300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(42300, 0, '������ֵ', 1, 0);
--
delete from HI_Language where ID = 42301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42301, 0, '���Դ���', 'LanguageStr', 1, 0);
--
delete from HI_Language where ID = 42302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42302, 0, 'ֵ', 'LanguageStr', 1, 0);
--
delete from HI_Language where ID = 42400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(42400, 0, 'ʱ��', 1, 0);
--
delete from HI_Language where ID = 42401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42401, 0, 'ʱ��ֵ', 'Timezone', 1, 0);
--
delete from HI_Language where ID = 42402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(42402, 0, '����', 'Timezone', 1, 0);
--
SET IDENTITY_INSERT HI_Language OFF
--