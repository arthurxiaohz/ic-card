
delete from HiMenu where ID = 300000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(300000, 0, 'mcht', '�̻�����', '�̻�����', 0, 9999, 0);
--



delete from MenuLink where ID = 300200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(300200, 0, '/tblMchtInfoList.action', '�̻�', '�̻�', 300200, 9999, 300000, 0, 0);
--
delete from MenuLink where ID = 301100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(301100, 0, '/tblMchtUserList.action', '�̷�����Ա', '�̷�����Ա', 301100, 9999, 300000, 0, 0);
--



delete from HI_Authority where ID = 300200;
--
delete from HI_Authority where ID = 300201;
--
delete from HI_Authority where ID = 300202;
--
delete from HI_Authority where ID = 300203;
--
delete from HI_Authority where ID = 300204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300200, 0, 'TBLMCHTINFO_LIST', 'mcht.TblMchtInfoList', '', '�̻���ѯ', 1, 300200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300201, 0, 'TBLMCHTINFO_VIEW', 'mcht.TblMchtInfoView', '', '�̻��鿴', 2, 300200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300202, 0, 'TBLMCHTINFO_SAVE', 'mcht.TblMchtInfoSave', '', '�̻�����', 3, 300200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300203, 0, 'TBLMCHTINFO_DEL', 'mcht.TblMchtInfoDel', '', '�̻�ɾ��', 4, 300200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300204, 0, 'TBLMCHTINFO_LOOKUP', 'mcht.TblMchtInfoLookup', '', '�̻�����', 1, 300200);
--
delete from HI_Authority where ID = 300300;
--
delete from HI_Authority where ID = 300301;
--
delete from HI_Authority where ID = 300302;
--
delete from HI_Authority where ID = 300303;
--
delete from HI_Authority where ID = 300304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300300, 0, 'TBLMCHTPAYMENTCONFIG_LIST', 'mcht.TblMchtPaymentConfigList', '', '�̻�֧�����ò�ѯ', 1, 300300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300301, 0, 'TBLMCHTPAYMENTCONFIG_VIEW', 'mcht.TblMchtPaymentConfigView', '', '�̻�֧�����ò鿴', 2, 300300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300302, 0, 'TBLMCHTPAYMENTCONFIG_SAVE', 'mcht.TblMchtPaymentConfigSave', '', '�̻�֧�����ñ���', 3, 300300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300303, 0, 'TBLMCHTPAYMENTCONFIG_DEL', 'mcht.TblMchtPaymentConfigDel', '', '�̻�֧������ɾ��', 4, 300300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300304, 0, 'TBLMCHTPAYMENTCONFIG_LOOKUP', 'mcht.TblMchtPaymentConfigLookup', '', '�̻�֧�����ô���', 1, 300300);
--
delete from HI_Authority where ID = 300600;
--
delete from HI_Authority where ID = 300601;
--
delete from HI_Authority where ID = 300602;
--
delete from HI_Authority where ID = 300603;
--
delete from HI_Authority where ID = 300604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300600, 0, 'TBLMCHTFEECONFIG_LIST', 'mcht.TblMchtFeeConfigList', '', '�̻����������ò�ѯ', 1, 300600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300601, 0, 'TBLMCHTFEECONFIG_VIEW', 'mcht.TblMchtFeeConfigView', '', '�̻����������ò鿴', 2, 300600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300602, 0, 'TBLMCHTFEECONFIG_SAVE', 'mcht.TblMchtFeeConfigSave', '', '�̻����������ñ���', 3, 300600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300603, 0, 'TBLMCHTFEECONFIG_DEL', 'mcht.TblMchtFeeConfigDel', '', '�̻�����������ɾ��', 4, 300600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300604, 0, 'TBLMCHTFEECONFIG_LOOKUP', 'mcht.TblMchtFeeConfigLookup', '', '�̻����������ô���', 1, 300600);
--
delete from HI_Authority where ID = 300800;
--
delete from HI_Authority where ID = 300801;
--
delete from HI_Authority where ID = 300802;
--
delete from HI_Authority where ID = 300803;
--
delete from HI_Authority where ID = 300804;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300800, 0, 'TBLMCHTCERTIFICATE_LIST', 'mcht.TblMchtCertificateList', '', '�̻�֤���ѯ', 1, 300800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300801, 0, 'TBLMCHTCERTIFICATE_VIEW', 'mcht.TblMchtCertificateView', '', '�̻�֤��鿴', 2, 300800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300802, 0, 'TBLMCHTCERTIFICATE_SAVE', 'mcht.TblMchtCertificateSave', '', '�̻�֤�鱣��', 3, 300800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300803, 0, 'TBLMCHTCERTIFICATE_DEL', 'mcht.TblMchtCertificateDel', '', '�̻�֤��ɾ��', 4, 300800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300804, 0, 'TBLMCHTCERTIFICATE_LOOKUP', 'mcht.TblMchtCertificateLookup', '', '�̻�֤�����', 1, 300800);
--
delete from HI_Authority where ID = 300400;
--
delete from HI_Authority where ID = 300401;
--
delete from HI_Authority where ID = 300402;
--
delete from HI_Authority where ID = 300403;
--
delete from HI_Authority where ID = 300404;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300400, 0, 'TBLMCHTSETTLECYCLECONFIG_LIST', 'mcht.TblMchtSettleCycleConfigList', '', '�̻������������ò�ѯ', 1, 300400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300401, 0, 'TBLMCHTSETTLECYCLECONFIG_VIEW', 'mcht.TblMchtSettleCycleConfigView', '', '�̻������������ò鿴', 2, 300400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300402, 0, 'TBLMCHTSETTLECYCLECONFIG_SAVE', 'mcht.TblMchtSettleCycleConfigSave', '', '�̻������������ñ���', 3, 300400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300403, 0, 'TBLMCHTSETTLECYCLECONFIG_DEL', 'mcht.TblMchtSettleCycleConfigDel', '', '�̻�������������ɾ��', 4, 300400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(300404, 0, 'TBLMCHTSETTLECYCLECONFIG_LOOKUP', 'mcht.TblMchtSettleCycleConfigLookup', '', '�̻������������ô���', 1, 300400);
--
delete from HI_Authority where ID = 301100;
--
delete from HI_Authority where ID = 301101;
--
delete from HI_Authority where ID = 301102;
--
delete from HI_Authority where ID = 301103;
--
delete from HI_Authority where ID = 301104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(301100, 0, 'TBLMCHTUSER_LIST', 'mcht.TblMchtUserList', '', '�̷�����Ա��ѯ', 1, 301100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(301101, 0, 'TBLMCHTUSER_VIEW', 'mcht.TblMchtUserView', '', '�̷�����Ա�鿴', 2, 301100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(301102, 0, 'TBLMCHTUSER_SAVE', 'mcht.TblMchtUserSave', '', '�̷�����Ա����', 3, 301100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(301103, 0, 'TBLMCHTUSER_DEL', 'mcht.TblMchtUserDel', '', '�̷�����Աɾ��', 4, 301100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(301104, 0, 'TBLMCHTUSER_LOOKUP', 'mcht.TblMchtUserLookup', '', '�̷�����Ա����', 1, 301100);
--

delete from HI_PrivilegeResource where ID = 300200;
--
delete from HI_PrivilegeResource where ID = 300201;
--
delete from HI_PrivilegeResource where ID = 300202;
--
delete from HI_PrivilegeResource where ID = 300203;
--
delete from HI_PrivilegeResource where ID = 300204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(300200, 0, 'TBLMCHTINFO_LIST', '/tblMchtInfoList.action', 'cn.net.iccard.bm.mcht.service.TblMchtInfoManager.getSecurityTblMchtInfoList', 'TBLMCHTINFO_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300201, 0, 'TBLMCHTINFO_VIEW', '/tblMchtInfoView.action', 'cn.net.iccard.bm.mcht.service.TblMchtInfoManager.getSecurityTblMchtInfoById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300202, 0, 'TBLMCHTINFO_SAVE', '/tblMchtInfoSave.action', 'cn.net.iccard.bm.mcht.service.TblMchtInfoManager.saveSecurityTblMchtInfo');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300203, 0, 'TBLMCHTINFO_DEL', '/tblMchtInfoRemove.action', 'cn.net.iccard.bm.mcht.service.TblMchtInfoManager.removeSecurityTblMchtInfoById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(300204, 0, 'TBLMCHTINFO_LOOKUP', '/tblMchtInfoLookup.action');
--
delete from HI_PrivilegeResource where ID = 300300;
--
delete from HI_PrivilegeResource where ID = 300301;
--
delete from HI_PrivilegeResource where ID = 300302;
--
delete from HI_PrivilegeResource where ID = 300303;
--
delete from HI_PrivilegeResource where ID = 300304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(300300, 0, 'TBLMCHTPAYMENTCONFIG_LIST', '/tblMchtPaymentConfigList.action', 'cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager.getSecurityTblMchtPaymentConfigList', 'TBLMCHTPAYMENTCONFIG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300301, 0, 'TBLMCHTPAYMENTCONFIG_VIEW', '/tblMchtPaymentConfigView.action', 'cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager.getSecurityTblMchtPaymentConfigById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300302, 0, 'TBLMCHTPAYMENTCONFIG_SAVE', '/tblMchtPaymentConfigSave.action', 'cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager.saveSecurityTblMchtPaymentConfig');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300303, 0, 'TBLMCHTPAYMENTCONFIG_DEL', '/tblMchtPaymentConfigRemove.action', 'cn.net.iccard.bm.mcht.service.TblMchtPaymentConfigManager.removeSecurityTblMchtPaymentConfigById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(300304, 0, 'TBLMCHTPAYMENTCONFIG_LOOKUP', '/tblMchtPaymentConfigLookup.action');
--
delete from HI_PrivilegeResource where ID = 300600;
--
delete from HI_PrivilegeResource where ID = 300601;
--
delete from HI_PrivilegeResource where ID = 300602;
--
delete from HI_PrivilegeResource where ID = 300603;
--
delete from HI_PrivilegeResource where ID = 300604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(300600, 0, 'TBLMCHTFEECONFIG_LIST', '/tblMchtFeeConfigList.action', 'cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager.getSecurityTblMchtFeeConfigList', 'TBLMCHTFEECONFIG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300601, 0, 'TBLMCHTFEECONFIG_VIEW', '/tblMchtFeeConfigView.action', 'cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager.getSecurityTblMchtFeeConfigById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300602, 0, 'TBLMCHTFEECONFIG_SAVE', '/tblMchtFeeConfigSave.action', 'cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager.saveSecurityTblMchtFeeConfig');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300603, 0, 'TBLMCHTFEECONFIG_DEL', '/tblMchtFeeConfigRemove.action', 'cn.net.iccard.bm.mcht.service.TblMchtFeeConfigManager.removeSecurityTblMchtFeeConfigById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(300604, 0, 'TBLMCHTFEECONFIG_LOOKUP', '/tblMchtFeeConfigLookup.action');
--
delete from HI_PrivilegeResource where ID = 300800;
--
delete from HI_PrivilegeResource where ID = 300801;
--
delete from HI_PrivilegeResource where ID = 300802;
--
delete from HI_PrivilegeResource where ID = 300803;
--
delete from HI_PrivilegeResource where ID = 300804;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(300800, 0, 'TBLMCHTCERTIFICATE_LIST', '/tblMchtCertificateList.action', 'cn.net.iccard.bm.mcht.service.TblMchtCertificateManager.getSecurityTblMchtCertificateList', 'TBLMCHTCERTIFICATE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300801, 0, 'TBLMCHTCERTIFICATE_VIEW', '/tblMchtCertificateView.action', 'cn.net.iccard.bm.mcht.service.TblMchtCertificateManager.getSecurityTblMchtCertificateById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300802, 0, 'TBLMCHTCERTIFICATE_SAVE', '/tblMchtCertificateSave.action', 'cn.net.iccard.bm.mcht.service.TblMchtCertificateManager.saveSecurityTblMchtCertificate');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300803, 0, 'TBLMCHTCERTIFICATE_DEL', '/tblMchtCertificateRemove.action', 'cn.net.iccard.bm.mcht.service.TblMchtCertificateManager.removeSecurityTblMchtCertificateById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(300804, 0, 'TBLMCHTCERTIFICATE_LOOKUP', '/tblMchtCertificateLookup.action');
--
delete from HI_PrivilegeResource where ID = 300400;
--
delete from HI_PrivilegeResource where ID = 300401;
--
delete from HI_PrivilegeResource where ID = 300402;
--
delete from HI_PrivilegeResource where ID = 300403;
--
delete from HI_PrivilegeResource where ID = 300404;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(300400, 0, 'TBLMCHTSETTLECYCLECONFIG_LIST', '/tblMchtSettleCycleConfigList.action', 'cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager.getSecurityTblMchtSettleCycleConfigList', 'TBLMCHTSETTLECYCLECONFIG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300401, 0, 'TBLMCHTSETTLECYCLECONFIG_VIEW', '/tblMchtSettleCycleConfigView.action', 'cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager.getSecurityTblMchtSettleCycleConfigById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300402, 0, 'TBLMCHTSETTLECYCLECONFIG_SAVE', '/tblMchtSettleCycleConfigSave.action', 'cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager.saveSecurityTblMchtSettleCycleConfig');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(300403, 0, 'TBLMCHTSETTLECYCLECONFIG_DEL', '/tblMchtSettleCycleConfigRemove.action', 'cn.net.iccard.bm.mcht.service.TblMchtSettleCycleConfigManager.removeSecurityTblMchtSettleCycleConfigById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(300404, 0, 'TBLMCHTSETTLECYCLECONFIG_LOOKUP', '/tblMchtSettleCycleConfigLookup.action');
--
delete from HI_PrivilegeResource where ID = 301100;
--
delete from HI_PrivilegeResource where ID = 301101;
--
delete from HI_PrivilegeResource where ID = 301102;
--
delete from HI_PrivilegeResource where ID = 301103;
--
delete from HI_PrivilegeResource where ID = 301104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(301100, 0, 'TBLMCHTUSER_LIST', '/tblMchtUserList.action', 'cn.net.iccard.bm.mcht.service.TblMchtUserManager.getSecurityTblMchtUserList', 'TBLMCHTUSER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(301101, 0, 'TBLMCHTUSER_VIEW', '/tblMchtUserView.action', 'cn.net.iccard.bm.mcht.service.TblMchtUserManager.getSecurityTblMchtUserById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(301102, 0, 'TBLMCHTUSER_SAVE', '/tblMchtUserSave.action', 'cn.net.iccard.bm.mcht.service.TblMchtUserManager.saveSecurityTblMchtUser');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(301103, 0, 'TBLMCHTUSER_DEL', '/tblMchtUserRemove.action', 'cn.net.iccard.bm.mcht.service.TblMchtUserManager.removeSecurityTblMchtUserById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(301104, 0, 'TBLMCHTUSER_LOOKUP', '/tblMchtUserLookup.action');
--



delete from Enumeration where ID = 300100;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(300100, 0, 'mchtStatus', '�̻�״̬', '�̻�״̬', 0, 0);
--
delete from Enumeration where ID = 300500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(300500, 0, 'mchtSettleCycleType', '�̻�������������', '�̻�������������', 0, 0);
--
delete from Enumeration where ID = 300700;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(300700, 0, 'mchtFeeType', '�̻�����������', '�̻�����������', 0, 0);
--
delete from Enumeration where ID = 300900;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(300900, 0, 'mchtType', '�̻����', '�̻����', 0, 0);
--
delete from Enumeration where ID = 301000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(301000, 0, 'feeFlag', '�����ѽ��㷽ʽ', '�����ѽ��㷽ʽ', 0, 0);
--
delete from Enumeration where ID = 301200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(301200, 0, 'signType', '�ύ����', '�ύ����', 0, 0);
--



delete from EnumerationValue where ID = 300100;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300100, 0, 'normal', '����', '����', '', 300100, 0);
--
delete from EnumerationValue where ID = 300101;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300101, 0, 'pause', '��ͣ', '��ͣ', '', 300100, 0);
--
delete from EnumerationValue where ID = 300102;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300102, 0, 'close', '�ر�', '�ر�', '', 300100, 0);
--
delete from EnumerationValue where ID = 300500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300500, 0, 't1', 'T1', 'T1', '', 300500, 0);
--
delete from EnumerationValue where ID = 300501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300501, 0, 'tn', 'TN', 'TN', '', 300500, 0);
--
delete from EnumerationValue where ID = 300502;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300502, 0, 'week', '�ܽ�', '�ܽ�', '', 300500, 0);
--
delete from EnumerationValue where ID = 300503;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300503, 0, 'momth', '�½�', '�½�', '', 300500, 0);
--
delete from EnumerationValue where ID = 300700;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300700, 0, 'byRate', '������', '������', '', 300700, 0);
--
delete from EnumerationValue where ID = 300701;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300701, 0, 'byTrans', '�̶����', '�̶����', '', 300700, 0);
--
delete from EnumerationValue where ID = 300900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(300900, 0, 'common', '��ͨ��', '��ͨ��', '', 300900, 0);
--
delete from EnumerationValue where ID = 301000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(301000, 0, 'netting', '����', '����', '', 301000, 0);
--
delete from EnumerationValue where ID = 301001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(301001, 0, 'twoLine', '��֧������', '��֧������', '', 301000, 0);
--
delete from EnumerationValue where ID = 301200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(301200, 0, 'md5', 'MD5', 'MD5', '', 301200, 0);
--
delete from EnumerationValue where ID = 301201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(301201, 0, 'certificate', '֤��', '֤��', '', 301200, 0);
--

--
delete from HI_Language where ID = 300100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300100, 0, '�̻�״̬', 1, 0);
--
delete from HI_Language where ID = 300101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300101, 0, '����', 'mchtStatus', 1, 0);
--
delete from HI_Language where ID = 300102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300102, 0, '��ͣ', 'mchtStatus', 1, 0);
--
delete from HI_Language where ID = 300103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300103, 0, '�ر�', 'mchtStatus', 1, 0);
--
delete from HI_Language where ID = 300200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300200, 0, '�̻�', 1, 0);
--
delete from HI_Language where ID = 300201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300201, 0, '�̻���', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300202, 0, '�̻�����', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300203, 0, '״̬', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300204, 0, '�̻����', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300205, 0, '����', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300206, 0, '�ƶ��绰', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300207, 0, '����', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300208;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300208, 0, '��ַ', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300209;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300209, 0, '֧���Զ�ȷ����', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300210;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300210, 0, '�����˻��˺�', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300211;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300211, 0, '�����˻�����', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300212;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300212, 0, '�������к�', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300213;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300213, 0, '����������', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300214;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300214, 0, '����ʱ��', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300215;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300215, 0, '����޸�ʱ��', 'TblMchtInfo', 1, 0);
--
delete from HI_Language where ID = 300300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300300, 0, '�̻�֧������', 1, 0);
--
delete from HI_Language where ID = 300301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300301, 0, '�Ƿ��������֧��ƽ̨', 'TblMchtPaymentConfig', 1, 0);
--
delete from HI_Language where ID = 300302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300302, 0, 'ǩ����ʽ', 'TblMchtPaymentConfig', 1, 0);
--
delete from HI_Language where ID = 300303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300303, 0, 'MD5', 'TblMchtPaymentConfig', 1, 0);
--
delete from HI_Language where ID = 300304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300304, 0, '����ʱ��', 'TblMchtPaymentConfig', 1, 0);
--
delete from HI_Language where ID = 300305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300305, 0, '����޸�ʱ��', 'TblMchtPaymentConfig', 1, 0);
--
delete from HI_Language where ID = 300500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300500, 0, '�̻�������������', 1, 0);
--
delete from HI_Language where ID = 300501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300501, 0, 'T1', 'mchtSettleCycleType', 1, 0);
--
delete from HI_Language where ID = 300502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300502, 0, 'TN', 'mchtSettleCycleType', 1, 0);
--
delete from HI_Language where ID = 300503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300503, 0, '�ܽ�', 'mchtSettleCycleType', 1, 0);
--
delete from HI_Language where ID = 300504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300504, 0, '�½�', 'mchtSettleCycleType', 1, 0);
--
delete from HI_Language where ID = 300600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300600, 0, '�̻�����������', 1, 0);
--
delete from HI_Language where ID = 300601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300601, 0, '����������', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300602, 0, '����ֵ', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300603, 0, '��������շ�', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300604, 0, '��������շ�', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300605, 0, '�˿��Ƿ��˻�������', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300606, 0, '����ʱ��', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300607, 0, '����޸�ʱ��', 'TblMchtFeeConfig', 1, 0);
--
delete from HI_Language where ID = 300700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300700, 0, '�̻�����������', 1, 0);
--
delete from HI_Language where ID = 300701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300701, 0, '������', 'mchtFeeType', 1, 0);
--
delete from HI_Language where ID = 300702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300702, 0, '�̶����', 'mchtFeeType', 1, 0);
--
delete from HI_Language where ID = 300800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300800, 0, '�̻�֤��', 1, 0);
--
delete from HI_Language where ID = 300801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300801, 0, '֤�����к�', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300802, 0, '�䷢��DN', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300803, 0, '֤��DN', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300804, 0, '֤����Ч�ڿ�ʼʱ��', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300805, 0, '֤����Ч�ڽ���ʱ��', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300806;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300806, 0, '����ʱ��', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300807;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300807, 0, '����޸�ʱ��', 'TblMchtCertificate', 1, 0);
--
delete from HI_Language where ID = 300900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300900, 0, '�̻����', 1, 0);
--
delete from HI_Language where ID = 300901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300901, 0, '��ͨ��', 'mchtType', 1, 0);
--
delete from HI_Language where ID = 301000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(301000, 0, '�����ѽ��㷽ʽ', 1, 0);
--
delete from HI_Language where ID = 301001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(301001, 0, '����', 'feeFlag', 1, 0);
--
delete from HI_Language where ID = 301002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(301002, 0, '��֧������', 'feeFlag', 1, 0);
--
delete from HI_Language where ID = 300400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(300400, 0, '�̻�������������', 1, 0);
--
delete from HI_Language where ID = 300401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300401, 0, '����Ƶ�ȼ��', 'TblMchtSettleCycleConfig', 1, 0);
--
delete from HI_Language where ID = 300402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300402, 0, '��С������', 'TblMchtSettleCycleConfig', 1, 0);
--
delete from HI_Language where ID = 300403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(300403, 0, '������', 'TblMchtSettleCycleConfig', 1, 0);
--
delete from HI_Language where ID = 301100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(301100, 0, '�̷�����Ա', 1, 0);
--
delete from HI_Language where ID = 301200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(301200, 0, '�ύ����', 1, 0);
--
delete from HI_Language where ID = 301201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(301201, 0, 'MD5', 'signType', 1, 0);
--
delete from HI_Language where ID = 301202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(301202, 0, '֤��', 'signType', 1, 0);
