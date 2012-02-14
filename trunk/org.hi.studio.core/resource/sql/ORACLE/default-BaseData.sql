CREATE SEQUENCE HIBERNATE_SEQUENCE MINVALUE 1 MAXVALUE 999999999999999999999999 INCREMENT BY 1 NOCYCLE
/---���Ӹ������ò˵�����
delete from MenuLink where ID = 2701;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2701, 0, '/securityUserList.action', '�û�����', '�û�����', 2999, 9999, 2000, 0, 0);
/---
delete from MenuLink where ID = 1200;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(1200, 0, '/personalSettingView.action', '��������', '��������', 1200, 9999, 1000, 0, 0);
/---
delete from MenuLink where ID = 2200;
/---
delete from MenuLink where ID = 2400;
/---
delete from MenuLink where ID = 2500;
/---
delete from MenuLink where ID = 2600;
/---
delete from MenuLink where ID = 2700;
/---
delete from MenuLink where ID = 12100;
/---
delete from MenuLink where ID = 12200;

/---�������
delete from HiMenu where ID = 4000;
/--
delete from MenuLink where ID = 4000;
/---
delete from MenuLink where ID = 4100;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(4100, 0, '/triggerDefList.action', '������', '������', 4100, 9999, 5000, 1, 0);
/---Ȩ��
delete from MenuLink where ID = 2000;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2000, 0, '/authorityList.action', 'Ȩ��', 'Ȩ��', 2000, 9999, 2000,1, 0);
/---Ȩ����Դ
delete from MenuLink where ID = 2800;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(2800, 0, '/privilegeResourceList.action', 'Ȩ����Դ', 'Ȩ����Դ', 2800, 9999, 2000, 1, 0);
/---��Ϣ
delete from MenuLink where ID = 5100;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(5100, 0, '/messageList.action', '��Ϣ', '��Ϣ', 5100, 9999, 5000,1, 0);
/---��Ϣ����
delete from MenuLink where ID = 5200;

/---����sa��������Ա�û�
delete from Hi_User where ID=1;
/---
insert  into Hi_User(id,version,userName,password,country,timeZone,accountEnabled,accountLocked,expiredDate,credentialsExpired,fullName,org,gender,address,phone,mobile,zip,SSN,mail,userMgrType,description,creator,deleted) values (1,52,'sa','c12e01f2a13ff5587e1e9e4aedb8242d',NULL,NULL,NULL,NULL,NULL,NULL,'administrator',1,NULL,'ss12','12','','',NULL,'',1400,NULL,NULL,0);

/---���Ա��û����͡�Ȩ�޷�Χ���Ƿ�ö����Ϊϵͳ��
delete from Enumeration where ID = 1200;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1200, 0, 'gender', '�Ա�', '�Ա�', 1, 0);
/---
delete from Enumeration where ID = 1400;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(1400, 0, 'userType', '�û�����', '�û�����', 1, 0);
/---
delete from Enumeration where ID = 2900;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(2900, 0, 'securityScope', 'Ȩ�޷�Χ', 'Ȩ�޷�Χ', 1, 0);
/---
delete from Enumeration where ID = 3200;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(3200, 0, 'yesNo', '�Ƿ�', '�Ƿ�', 1, 0);

/---����ϵͳ����Ȩ��
delete from HI_Authority where ID = 2999;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(2999, 0, 'SYSTEM_USER_MANAGE', '�û�����', '', '�û�����', 0, 2701);
/---Ȩ��
delete from HI_Authority where ID = 2000;
/---
delete from HI_Authority where ID = 2001;
/---
delete from HI_Authority where ID = 2002;
/---
delete from HI_Authority where ID = 2003;
/---
delete from HI_Authority where ID = 2004;
/---�û���ɫ
delete from HI_Authority where ID = 2400;
/---
delete from HI_Authority where ID = 2401;
/---
delete from HI_Authority where ID = 2402;
/---
delete from HI_Authority where ID = 2403;
/---
delete from HI_Authority where ID = 2404;
/---�û���
delete from HI_Authority where ID = 2200;
/---
delete from HI_Authority where ID = 2201;
/---
delete from HI_Authority where ID = 2202;
/---
delete from HI_Authority where ID = 2203;
/---
delete from HI_Authority where ID = 2204;
/---�û�����
delete from HI_Authority where ID = 2500;
/---
delete from HI_Authority where ID = 2501;
/---
delete from HI_Authority where ID = 2502;
/---
delete from HI_Authority where ID = 2503;
/---
delete from HI_Authority where ID = 2504;
/---��ɫȨ��
delete from HI_Authority where ID = 2600;
/---
delete from HI_Authority where ID = 2601;
/---
delete from HI_Authority where ID = 2602;
/---
delete from HI_Authority where ID = 2603;
/---
delete from HI_Authority where ID = 2604;
/---�����ɫ
delete from HI_Authority where ID = 2700;
/---
delete from HI_Authority where ID = 2701;
/---
delete from HI_Authority where ID = 2702;
/---
delete from HI_Authority where ID = 2703;
/---
delete from HI_Authority where ID = 2704;
/---Ȩ����Դ
delete from HI_Authority where ID = 2900;
/---
delete from HI_Authority where ID = 2901;
/---
delete from HI_Authority where ID = 2902;
/---
delete from HI_Authority where ID = 2903;
/---
delete from HI_Authority where ID = 2904;
/---��־�Ĵ����뱣��
delete from HI_Authority where ID = 5402;
/---
delete from HI_Authority where ID = 5404;

/---Ȩ��
delete from HI_PrivilegeResource where ID = 2000;
/---
delete from HI_PrivilegeResource where ID = 2001;
/---
delete from HI_PrivilegeResource where ID = 2002;
/---
delete from HI_PrivilegeResource where ID = 2003;
/---
delete from HI_PrivilegeResource where ID = 2004;
/---�û���
delete from HI_PrivilegeResource where ID = 2200;
/---
delete from HI_PrivilegeResource where ID = 2201;
/---
delete from HI_PrivilegeResource where ID = 2202;
/---
delete from HI_PrivilegeResource where ID = 2203;
/---
delete from HI_PrivilegeResource where ID = 2204;
/---�û���ɫ
delete from HI_PrivilegeResource where ID = 2400;
/---
delete from HI_PrivilegeResource where ID = 2401;
/---
delete from HI_PrivilegeResource where ID = 2402;
/---
delete from HI_PrivilegeResource where ID = 2403;
/---
delete from HI_PrivilegeResource where ID = 2404;
/---�û�����
delete from HI_PrivilegeResource where ID = 2500;
/---
delete from HI_PrivilegeResource where ID = 2501;
/---
delete from HI_PrivilegeResource where ID = 2502;
/---
delete from HI_PrivilegeResource where ID = 2503;
/---
delete from HI_PrivilegeResource where ID = 2504;
/---��ɫȨ��
delete from HI_PrivilegeResource where ID = 2600;
/---
delete from HI_PrivilegeResource where ID = 2601;
/---
delete from HI_PrivilegeResource where ID = 2602;
/---
delete from HI_PrivilegeResource where ID = 2603;
/---
delete from HI_PrivilegeResource where ID = 2604;
/---�����ɫ
delete from HI_PrivilegeResource where ID = 2700;
/---
delete from HI_PrivilegeResource where ID = 2701;
/---
delete from HI_PrivilegeResource where ID = 2702;
/---
delete from HI_PrivilegeResource where ID = 2703;
/---
delete from HI_PrivilegeResource where ID = 2704;
/---Ȩ����Դ
delete from HI_PrivilegeResource where ID = 2900;
/---
delete from HI_PrivilegeResource where ID = 2901;
/---
delete from HI_PrivilegeResource where ID = 2902;
/---
delete from HI_PrivilegeResource where ID = 2903;
/---
delete from HI_PrivilegeResource where ID = 2904;
/---��־�Ĵ����뱣��
delete from HI_PrivilegeResource where ID = 5402;
/---
delete from HI_PrivilegeResource where ID = 5404;

/---ϵͳ��Ӧ������
delete from Hi_AppSetting;
/---
insert into Hi_AppSetting(id,version, appGroup, appName, appValue,description, creator) values(1, 0, 'HOSTING', 'WEB_HOSTING', 'http://localhost:8080', 'Ӧ�÷�������ַ', 0);


/---��������ȫ��ɾ��
delete from HiMenu where ID = 6000;
/---
delete from MenuLink where ID = 6000;
/---
delete from HI_Authority where ID = 6000;
/---
delete from HI_Authority where ID = 6001;
/---
delete from HI_Authority where ID = 6002;
/---
delete from HI_Authority where ID = 6003;
/---
delete from HI_Authority where ID = 6004;
/---
delete from HI_PrivilegeResource where ID = 6000;
/---
delete from HI_PrivilegeResource where ID = 6001;
/---
delete from HI_PrivilegeResource where ID = 6002;
/---
delete from HI_PrivilegeResource where ID = 6003;
/---
delete from HI_PrivilegeResource where ID = 6004;

/---��ʼ������������
delete from HI_Language where id =3;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(3, 5, '��ѯ����', null, '', 1, 1);
/---
delete from HI_Language where id =4;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(4, 0, '�½�', null, '', 1, 1);
/---
delete from HI_Language where id =5;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(5, 0, '��ѯ', null, '', 1, 1);
/---
delete from HI_Language where id =6;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(6, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =8;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(8, 6, '�б�', null, '', 1, 1);
/---
delete from HI_Language where id =9;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(9, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =10;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(10, 0, '���Ҵ���', null, '', 1, 1);
/---
delete from HI_Language where id =11;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(11, 0, 'ɾ��', null, '', 1, 1);
/---
delete from HI_Language where id =12;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(12, 0, '�鿴', null, '', 1, 1);
/---
delete from HI_Language where id =13;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(13, 0, '�༭', null, '', 1, 1);
/---
delete from HI_Language where id =14;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(14, 3, 'ȡ��ȫѡ', null, '', 1, 1);
/---
delete from HI_Language where id =15;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(15, 0, 'ȫѡ', null, '', 1, 1);
/---
delete from HI_Language where id =16;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(16, 0, '����ɾ��', null, '', 1, 1);
/---
delete from HI_Language where id =17;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(17, 2, '�༭ҳ��', null, '', 1, 1);
/---
delete from HI_Language where id =18;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(18, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =19;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(19, 0, '�ر�', null, '', 1, 1);
/---
delete from HI_Language where id =20;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(20, 1, '�鿴ҳ��', null, '', 1, 1);
/---
delete from HI_Language where id =22;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(22, 0, '������', null, '', 1, 1);
/---
delete from HI_Language where id =23;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(23, 0, '��ҳ��', null, '', 1, 1);
/---
delete from HI_Language where id =24;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(24, 0, 'βҳ', null, '', 1, 1);
/---
delete from HI_Language where id =25;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(25, 0, '��һҳ', null, '', 1, 1);
/---
delete from HI_Language where id =26;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(26, 0, '��һҳ', null, '', 1, 1);
/---
delete from HI_Language where id =27;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(27, 0, '��ҳ', null, '', 1, 1);
/---
delete from HI_Language where id =28;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(28, 0, '��', null, '', 1, 1);
/---
delete from HI_Language where id =29;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(29, 0, 'ҳ', null, '', 1, 1);
/---
delete from HI_Language where id =30;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(30, 0, '��ת', null, '', 1, 1);
/---
delete from HI_Language where id =31;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(31, 0, 'ȫ��', null, '', 1, 1);
/---
delete from HI_Language where id =32;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(32, 0, '������', null, '', 1, 1);
/---
delete from HI_Language where id =33;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(33, 0, 'С��', null, '', 1, 1);
/---
delete from HI_Language where id =34;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(34, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =35;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(35, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =36;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(36, 0, 'С�ڵ���', null, '', 1, 1);
/---
delete from HI_Language where id =37;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(37, 0, '���ڵ���', null, '', 1, 1);
/---
delete from HI_Language where id =38;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(38, 1, '��ѡ����Ҫ�ϴ��ĸ���', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =39;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(39, 1, '�ϴ�', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =40;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(40, 3, '����ѡ����Ҫ�ϴ����ļ�!', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =41;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(41, 0, 'Ȩ�޹���', null, '', 1, 1);
/---
delete from HI_Language where id =42;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(42, 0, '������ϸ��Ϣ', null, '', 1, 1);
/---
delete from HI_Language where id =43;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(43, 0, '��û�в����˹��ܵ�Ȩ��', null, '', 1, 1);
/---
delete from HI_Language where id =44;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(44, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =45;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(45, 0, 'δ�ҵ�Action', null, 'ExcelReportDesign', 1, 1);
/---
delete from HI_Language where id =46;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(46, 0, '�ϴ��ļ�����', null, 'Attachment', 1, 1);
/---
delete from HI_Language where id =47;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(47, 0, 'Action����ʧ��', null, '', 1, 1);
/---
delete from HI_Language where id =48;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(48, 0, '����һ���û�,���ܷ��ɽ�ɫ', null, 'Role', 1, 1);
/---
delete from HI_Language where id =49;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(49, 1, '�����û������ǹ���Ա,���������Լ������Ľ�ɫ�ſ���Ϊ�ý�ɫ�����û�', null, 'Role', 1, 1);
/---
delete from HI_Language where id =50;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(50, 0, '��������Ա������Ȩ', null, 'Role', 1, 1);
/---
delete from HI_Language where id =51;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(51, 0, '����һ���û�,����ɾ������ɫ', null, 'Role', 1, 1);
/---
delete from HI_Language where id =52;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(52, 0, '�����û�����Ϊ����Ա,ֻ��ɾ�����Լ��������Ľ�ɫ', null, 'Role', 1, 1);
/---
delete from HI_Language where id =53;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(53, 0, '��ɫ���ظ�', null, 'Role', 1, 1);
/---
delete from HI_Language where id =54;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(54, 0, 'ϵͳ�޷�ʶ�������û�����', null, '', 1, 1);
/---
delete from HI_Language where id =55;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(55, 0, '����һ���û�,�����޸��봴����ɫ', null, 'Role', 1, 1);
/---
delete from HI_Language where id =56;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(56, 1, '�����û��ǹ���Ա,����ֻ�ܱ༭���Լ������Ľ�ɫ!', null, 'Role', 1, 1);
/---
delete from HI_Language where id =57;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(57, 0, '��ҳ���е������Ѿ�����д��������ˢ��ҳ������±༭�ü�¼', null, '', 1, 1);
/---
delete from HI_Language where id =58;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(58, 0, 'Action����ֵʱ����', null, '', 1, 1);
/---
delete from HI_Language where id =59;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(59, 0, '�����ʼ�ʧ��', null, '', 1, 1);
/---
delete from HI_Language where id =61;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(61, 0, '��ѡ��Ҫ��Ȩ���û�', null, 'Role', 1, 1);
/---
delete from HI_Language where id =62;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(62, 0, 'HIƽ̨', null, '', 1, 1);
/---
delete from HI_Language where id =63;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(63, 0, '�û���', null, '', 1, 1);
/---
delete from HI_Language where id =64;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(64, 0, '����', null, '', 1, 1);
/---
delete from HI_Language where id =65;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(65, 0, '��֤��', null, '', 1, 1);
/---
delete from HI_Language where id =66;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(66, 0, '��û�е�½�ɹ�', null, '', 1, 1);
/---
delete from HI_Language where id =67;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(67, 0, '���ܵ�ԭ��', null, '', 1, 1);
/---
delete from HI_Language where id =68;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(68, 0, '��ӭ', null, '', 1, 1);
/---
delete from HI_Language where id =69;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(69, 0, '��½', null, '', 1, 1);
/---
delete from HI_Language where id =70;
/---
insert into HI_Language(id, version, keyStr, service, entity, isSystem, creator) values(70, 0, '�˳�', null, '', 1, 1);
/---

delete from HI_LanguageCode where id =1;
/---
insert into HI_LanguageCode(id, version, languageCode, description, creator) values(1, 2, 'zh_CN', '�й�����', 1);
/---
delete from HI_LanguageCode where id =2;
/---
insert into HI_LanguageCode(id, version, languageCode, description, creator) values(2, 0, 'en_US', '����Ӣ��', 1);
/---

delete from HI_languageStr where id =2;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(2, 8, 3, 'zh_CN', '��ѯ����', 1);
/---
delete from HI_languageStr where id =3;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(3, 0, 4, 'zh_CN', '�½�', 1);
/---
delete from HI_languageStr where id =4;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(4, 0, 5, 'zh_CN', '��ѯ', 1);
/---
delete from HI_languageStr where id =5;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(5, 0, 6, 'zh_CN', '����', 1);
/---
delete from HI_languageStr where id =7;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(7, 1, 8, 'zh_CN', '{1}�б�', 1);
/---
delete from HI_languageStr where id =8;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(8, 1, 9, 'zh_CN', '����', 1);
/---
delete from HI_languageStr where id =9;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(9, 0, 10, 'zh_CN', '���Ҵ���', 1);
/---
delete from HI_languageStr where id =10;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(10, 0, 11, 'zh_CN', 'ɾ��{1}', 1);
/---
delete from HI_languageStr where id =11;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(11, 0, 12, 'zh_CN', '�鿴{1}', 1);
/---
delete from HI_languageStr where id =12;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(12, 0, 13, 'zh_CN', '�༭{1}', 1);
/---
delete from HI_languageStr where id =13;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(13, 0, 14, 'zh_CN', 'ȡ��ȫѡ', 1);
/---
delete from HI_languageStr where id =14;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(14, 0, 15, 'zh_CN', 'ȫѡ', 1);
/---
delete from HI_languageStr where id =15;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(15, 0, 16, 'zh_CN', '����ɾ��', 1);
/---
delete from HI_languageStr where id =16;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(16, 1, 17, 'zh_CN', '{1}�༭ҳ��', 1);
/---
delete from HI_languageStr where id =17;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(17, 0, 18, 'zh_CN', '����', 1);
/---
delete from HI_languageStr where id =18;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(18, 0, 19, 'zh_CN', '�ر�', 1);
/---
delete from HI_languageStr where id =19;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(19, 1, 20, 'zh_CN', '{1}�鿴ҳ��', 1);
/---
delete from HI_languageStr where id =27;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(27, 0, 22, 'zh_CN', '��{1}��', 1);
/---
delete from HI_languageStr where id =29;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(29, 0, 23, 'zh_CN', '��{1}ҳ', 1);
/---
delete from HI_languageStr where id =31;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(31, 0, 24, 'zh_CN', 'βҳ', 1);
/---
delete from HI_languageStr where id =33;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(33, 0, 25, 'zh_CN', '��һҳ', 1);
/---
delete from HI_languageStr where id =35;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(35, 0, 26, 'zh_CN', '��һҳ', 1);
/---
delete from HI_languageStr where id =37;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(37, 0, 27, 'zh_CN', '��ҳ', 1);
/---
delete from HI_languageStr where id =39;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(39, 0, 28, 'zh_CN', '��', 1);
/---
delete from HI_languageStr where id =41;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(41, 0, 29, 'zh_CN', 'ҳ', 1);
/---
delete from HI_languageStr where id =43;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(43, 0, 30, 'zh_CN', '��ת', 1);
/---
delete from HI_languageStr where id =45;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(45, 0, 31, 'zh_CN', 'ȫ��', 1);
/---
delete from HI_languageStr where id =47;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(47, 0, 32, 'zh_CN', '������', 1);
/---
delete from HI_languageStr where id =49;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(49, 0, 33, 'zh_CN', 'С��', 1);
/---
delete from HI_languageStr where id =51;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(51, 0, 34, 'zh_CN', '����', 1);
/---
delete from HI_languageStr where id =53;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(53, 0, 35, 'zh_CN', '����', 1);
/---
delete from HI_languageStr where id =55;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(55, 0, 36, 'zh_CN', 'С�ڵ���', 1);
/---
delete from HI_languageStr where id =57;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(57, 0, 37, 'zh_CN', '���ڵ���', 1);
/---
delete from HI_languageStr where id =59;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(59, 0, 38, 'zh_CN', '��ѡ����Ҫ�ϴ��ĸ���', 1);
/---
delete from HI_languageStr where id =60;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(60, 0, 39, 'zh_CN', '�ϴ�', 1);
/---
delete from HI_languageStr where id =61;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(61, 0, 40, 'zh_CN', '����ѡ����Ҫ�ϴ����ļ���', 1);
/---
delete from HI_languageStr where id =62;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(62, 0, 41, 'zh_CN', 'Ȩ�޹���', 1);
/---
delete from HI_languageStr where id =63;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(63, 0, 42, 'zh_CN', '������ϸ��Ϣ', 1);
/---
delete from HI_languageStr where id =64;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(64, 0, 43, 'zh_CN', '��û�в����˹��ܵ�Ȩ��', 1);
/---
delete from HI_languageStr where id =65;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(65, 0, 44, 'zh_CN', '����', 1);
/---
delete from HI_languageStr where id =66;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(66, 0, 45, 'zh_CN', '��ϵͳ��û����action:{1}  ��Ӧ�ı������,���������ȷ���Ƿ��ڼ���״̬', 1);
/---
delete from HI_languageStr where id =67;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(67, 0, 46, 'zh_CN', '�ϴ��ļ�����������ϴ�{1}MB �ĸ���.', 1);
/---
delete from HI_languageStr where id =68;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(68, 0, 47, 'zh_CN', '{1}����ʧ��!', 1);
/---
delete from HI_languageStr where id =69;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(69, 0, 48, 'zh_CN', '����һ���û�,���ܷ��ɽ�ɫ', 1);
/---
delete from HI_languageStr where id =70;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(70, 0, 49, 'zh_CN', '�����û������ǹ���Ա,���������Լ������Ľ�ɫ�ſ���Ϊ�ý�ɫ�����û�', 1);
/---
delete from HI_languageStr where id =71;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(71, 0, 50, 'zh_CN', '��ѡ����û���{1}�ǳ�������Ա,����ҪΪ��������Ա��Ȩ', 1);
/---
delete from HI_languageStr where id =72;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(72, 0, 51, 'zh_CN', '����һ���û�,����ɾ������ɫ', 1);
/---
delete from HI_languageStr where id =73;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(73, 0, 52, 'zh_CN', '�����û�����Ϊ����Ա,ֻ��ɾ�����Լ��������Ľ�ɫ', 1);
/---
delete from HI_languageStr where id =74;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(74, 0, 53, 'zh_CN', '��ɫ����{1}�Ѿ����ڣ��������ظ��Ľ�ɫ����', 1);
/---
delete from HI_languageStr where id =75;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(75, 1, 54, 'zh_CN', 'ϵͳ�޷�ʶ�������û�����!', 1);
/---
delete from HI_languageStr where id =76;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(76, 0, 55, 'zh_CN', '����һ���û�,�����޸��봴����ɫ!', 1);
/---
delete from HI_languageStr where id =77;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(77, 0, 56, 'zh_CN', '�����û��ǹ���Ա,����ֻ�ܱ༭���Լ������Ľ�ɫ!', 1);
/---
delete from HI_languageStr where id =78;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(78, 0, 57, 'zh_CN', '��ҳ���е������Ѿ�����д��������ˢ��ҳ������±༭�ü�¼!', 1);
/---
delete from HI_languageStr where id =79;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(79, 0, 58, 'zh_CN', '�ڸ�action����ֵʱ����{1}���ԣ�', 1);
/---
delete from HI_languageStr where id =80;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(80, 0, 59, 'zh_CN', '�����ʼ�ʧ��', 1);
/---
delete from HI_languageStr where id =82;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(82, 0, 61, 'zh_CN', '��ѡ��Ҫ��Ȩ���û�', 1);
/---
delete from HI_languageStr where id =83;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(83, 0, 62, 'zh_CN', 'HIƽ̨', 1);
/---
delete from HI_languageStr where id =84;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(84, 0, 63, 'zh_CN', '�û���', 1);
/---
delete from HI_languageStr where id =85;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(85, 0, 64, 'zh_CN', '�ܡ���', 1);
/---
delete from HI_languageStr where id =86;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(86, 0, 65, 'zh_CN', '��֤��', 1);
/---
delete from HI_languageStr where id =87;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(87, 0, 66, 'zh_CN', '��û�е�½�ɹ���������һ�Ρ�', 1);
/---
delete from HI_languageStr where id =88;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(88, 0, 67, 'zh_CN', '���ܵ�ԭ��: ��������û������������', 1);
/---
delete from HI_languageStr where id =89;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(89, 0, 68, 'zh_CN', '��ӭ', 1);
/---
delete from HI_languageStr where id =90;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(90, 0, 69, 'zh_CN', '��½', 1);
/---
delete from HI_languageStr where id =91;
/---
insert into HI_languageStr(id, version, language, languageCode, value, creator) values(91, 0, 70, 'zh_CN', '�˳�', 1);


