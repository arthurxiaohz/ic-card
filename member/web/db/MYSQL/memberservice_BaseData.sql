
delete from HiMenu where ID = 100000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(100000, 0, 'memberservice', '��Ա���ײ�ѯ', '��Ա���ײ�ѯ', 0, 9999, 0);
--



delete from MenuLink where ID = 100100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100100, 0, '/tblMbInfoList.action', '��Ա��Ϣ', '��Ա��Ϣ', 100100, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100300, 0, '/tblMbRechargeOrderList.action', '��ֵ����', '��ֵ����', 100300, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100400, 0, '/tblMbTransactionRequestList.action', '���ؽ�������', '���ؽ�������', 100400, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101100, 0, '/tblMbTransactionResponseList.action', '���ؽ��׽��', '���ؽ��׽��', 101100, 9999, 100000, 0, 0);
--



delete from HI_Authority where ID = 100100;
--
delete from HI_Authority where ID = 100101;
--
delete from HI_Authority where ID = 100102;
--
delete from HI_Authority where ID = 100103;
--
delete from HI_Authority where ID = 100104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100100, 0, 'TBLMBINFO_LIST', 'memberservice.TblMbInfoList', '', '��Ա��Ϣ��ѯ', 1, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100101, 0, 'TBLMBINFO_VIEW', 'memberservice.TblMbInfoView', '', '��Ա��Ϣ�鿴', 2, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100102, 0, 'TBLMBINFO_SAVE', 'memberservice.TblMbInfoSave', '', '��Ա��Ϣ����', 3, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100103, 0, 'TBLMBINFO_DEL', 'memberservice.TblMbInfoDel', '', '��Ա��Ϣɾ��', 4, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100104, 0, 'TBLMBINFO_LOOKUP', 'memberservice.TblMbInfoLookup', '', '��Ա��Ϣ����', 1, 100100);
--
delete from HI_Authority where ID = 100300;
--
delete from HI_Authority where ID = 100301;
--
delete from HI_Authority where ID = 100302;
--
delete from HI_Authority where ID = 100303;
--
delete from HI_Authority where ID = 100304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100300, 0, 'TBLMBRECHARGEORDER_LIST', 'memberservice.TblMbRechargeOrderList', '', '��ֵ������ѯ', 1, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100301, 0, 'TBLMBRECHARGEORDER_VIEW', 'memberservice.TblMbRechargeOrderView', '', '��ֵ�����鿴', 2, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100302, 0, 'TBLMBRECHARGEORDER_SAVE', 'memberservice.TblMbRechargeOrderSave', '', '��ֵ��������', 3, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100303, 0, 'TBLMBRECHARGEORDER_DEL', 'memberservice.TblMbRechargeOrderDel', '', '��ֵ����ɾ��', 4, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100304, 0, 'TBLMBRECHARGEORDER_LOOKUP', 'memberservice.TblMbRechargeOrderLookup', '', '��ֵ��������', 1, 100300);
--
delete from HI_Authority where ID = 100400;
--
delete from HI_Authority where ID = 100401;
--
delete from HI_Authority where ID = 100402;
--
delete from HI_Authority where ID = 100403;
--
delete from HI_Authority where ID = 100404;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100400, 0, 'TBLMBTRANSACTIONREQUEST_LIST', 'memberservice.TblMbTransactionRequestList', '', '���ؽ��������ѯ', 1, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100401, 0, 'TBLMBTRANSACTIONREQUEST_VIEW', 'memberservice.TblMbTransactionRequestView', '', '���ؽ�������鿴', 2, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100402, 0, 'TBLMBTRANSACTIONREQUEST_SAVE', 'memberservice.TblMbTransactionRequestSave', '', '���ؽ������󱣴�', 3, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100403, 0, 'TBLMBTRANSACTIONREQUEST_DEL', 'memberservice.TblMbTransactionRequestDel', '', '���ؽ�������ɾ��', 4, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100404, 0, 'TBLMBTRANSACTIONREQUEST_LOOKUP', 'memberservice.TblMbTransactionRequestLookup', '', '���ؽ����������', 1, 100400);
--
delete from HI_Authority where ID = 101100;
--
delete from HI_Authority where ID = 101101;
--
delete from HI_Authority where ID = 101102;
--
delete from HI_Authority where ID = 101103;
--
delete from HI_Authority where ID = 101104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101100, 0, 'TBLMBTRANSACTIONRESPONSE_LIST', 'memberservice.TblMbTransactionResponseList', '', '���ؽ��׽����ѯ', 1, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101101, 0, 'TBLMBTRANSACTIONRESPONSE_VIEW', 'memberservice.TblMbTransactionResponseView', '', '���ؽ��׽���鿴', 2, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101102, 0, 'TBLMBTRANSACTIONRESPONSE_SAVE', 'memberservice.TblMbTransactionResponseSave', '', '���ؽ��׽������', 3, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101103, 0, 'TBLMBTRANSACTIONRESPONSE_DEL', 'memberservice.TblMbTransactionResponseDel', '', '���ؽ��׽��ɾ��', 4, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101104, 0, 'TBLMBTRANSACTIONRESPONSE_LOOKUP', 'memberservice.TblMbTransactionResponseLookup', '', '���ؽ��׽������', 1, 101100);
--

delete from HI_PrivilegeResource where ID = 100100;
--
delete from HI_PrivilegeResource where ID = 100101;
--
delete from HI_PrivilegeResource where ID = 100102;
--
delete from HI_PrivilegeResource where ID = 100103;
--
delete from HI_PrivilegeResource where ID = 100104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100100, 0, 'TBLMBINFO_LIST', '/tblMbInfoList.action', 'cn.net.iccard.member.service.TblMbInfoManager.getSecurityTblMbInfoList', 'TBLMBINFO_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100101, 0, 'TBLMBINFO_VIEW', '/tblMbInfoView.action', 'cn.net.iccard.member.service.TblMbInfoManager.getSecurityTblMbInfoById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100102, 0, 'TBLMBINFO_SAVE', '/tblMbInfoSave.action', 'cn.net.iccard.member.service.TblMbInfoManager.saveSecurityTblMbInfo');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100103, 0, 'TBLMBINFO_DEL', '/tblMbInfoRemove.action', 'cn.net.iccard.member.service.TblMbInfoManager.removeSecurityTblMbInfoById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100104, 0, 'TBLMBINFO_LOOKUP', '/tblMbInfoLookup.action');
--
delete from HI_PrivilegeResource where ID = 100300;
--
delete from HI_PrivilegeResource where ID = 100301;
--
delete from HI_PrivilegeResource where ID = 100302;
--
delete from HI_PrivilegeResource where ID = 100303;
--
delete from HI_PrivilegeResource where ID = 100304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100300, 0, 'TBLMBRECHARGEORDER_LIST', '/tblMbRechargeOrderList.action', 'cn.net.iccard.member.service.TblMbRechargeOrderManager.getSecurityTblMbRechargeOrderList', 'TBLMBRECHARGEORDER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100301, 0, 'TBLMBRECHARGEORDER_VIEW', '/tblMbRechargeOrderView.action', 'cn.net.iccard.member.service.TblMbRechargeOrderManager.getSecurityTblMbRechargeOrderById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100302, 0, 'TBLMBRECHARGEORDER_SAVE', '/tblMbRechargeOrderSave.action', 'cn.net.iccard.member.service.TblMbRechargeOrderManager.saveSecurityTblMbRechargeOrder');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100303, 0, 'TBLMBRECHARGEORDER_DEL', '/tblMbRechargeOrderRemove.action', 'cn.net.iccard.member.service.TblMbRechargeOrderManager.removeSecurityTblMbRechargeOrderById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100304, 0, 'TBLMBRECHARGEORDER_LOOKUP', '/tblMbRechargeOrderLookup.action');
--
delete from HI_PrivilegeResource where ID = 100400;
--
delete from HI_PrivilegeResource where ID = 100401;
--
delete from HI_PrivilegeResource where ID = 100402;
--
delete from HI_PrivilegeResource where ID = 100403;
--
delete from HI_PrivilegeResource where ID = 100404;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100400, 0, 'TBLMBTRANSACTIONREQUEST_LIST', '/tblMbTransactionRequestList.action', 'cn.net.iccard.member.service.TblMbTransactionRequestManager.getSecurityTblMbTransactionRequestList', 'TBLMBTRANSACTIONREQUEST_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100401, 0, 'TBLMBTRANSACTIONREQUEST_VIEW', '/tblMbTransactionRequestView.action', 'cn.net.iccard.member.service.TblMbTransactionRequestManager.getSecurityTblMbTransactionRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100402, 0, 'TBLMBTRANSACTIONREQUEST_SAVE', '/tblMbTransactionRequestSave.action', 'cn.net.iccard.member.service.TblMbTransactionRequestManager.saveSecurityTblMbTransactionRequest');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100403, 0, 'TBLMBTRANSACTIONREQUEST_DEL', '/tblMbTransactionRequestRemove.action', 'cn.net.iccard.member.service.TblMbTransactionRequestManager.removeSecurityTblMbTransactionRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100404, 0, 'TBLMBTRANSACTIONREQUEST_LOOKUP', '/tblMbTransactionRequestLookup.action');
--
delete from HI_PrivilegeResource where ID = 101100;
--
delete from HI_PrivilegeResource where ID = 101101;
--
delete from HI_PrivilegeResource where ID = 101102;
--
delete from HI_PrivilegeResource where ID = 101103;
--
delete from HI_PrivilegeResource where ID = 101104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101100, 0, 'TBLMBTRANSACTIONRESPONSE_LIST', '/tblMbTransactionResponseList.action', 'cn.net.iccard.member.service.TblMbTransactionResponseManager.getSecurityTblMbTransactionResponseList', 'TBLMBTRANSACTIONRESPONSE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101101, 0, 'TBLMBTRANSACTIONRESPONSE_VIEW', '/tblMbTransactionResponseView.action', 'cn.net.iccard.member.service.TblMbTransactionResponseManager.getSecurityTblMbTransactionResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101102, 0, 'TBLMBTRANSACTIONRESPONSE_SAVE', '/tblMbTransactionResponseSave.action', 'cn.net.iccard.member.service.TblMbTransactionResponseManager.saveSecurityTblMbTransactionResponse');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101103, 0, 'TBLMBTRANSACTIONRESPONSE_DEL', '/tblMbTransactionResponseRemove.action', 'cn.net.iccard.member.service.TblMbTransactionResponseManager.removeSecurityTblMbTransactionResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101104, 0, 'TBLMBTRANSACTIONRESPONSE_LOOKUP', '/tblMbTransactionResponseLookup.action');
--







--
delete from HI_Language where ID = 100100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100100, 0, '��Ա��Ϣ', 1, 0);
--
delete from HI_Language where ID = 100101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100101, 0, 'ƽ̨������ˮ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100102, 0, 'ƽ̨��Ա��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100103, 0, '��������', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100104, 0, '֤������', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100105, 0, '��ʵ����', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100106, 0, '�Ա�', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100107, 0, 'סַ', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100108, 0, '��������', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100109, 0, '�ֻ�', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100110, 0, '�̶��绰', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100111, 0, 'Email��ַ', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100112, 0, '��¼����', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100113, 0, '����', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100114, 0, 'ʵ����֤״̬', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100115, 0, 'ʵ����֤ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100116, 0, 'ע��ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100117, 0, 'ע�᷽ʽ', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100118, 0, '����ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100119, 0, '����޸�ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100120, 0, '����޸���', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100300, 0, '��ֵ����', 1, 0);
--
delete from HI_Language where ID = 100301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100301, 0, 'ƽ̨������ˮ��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100302, 0, 'ƽ̨��Ա��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100303, 0, '�˻�����', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100304, 0, '�˻�����', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100305, 0, '�ֿ��˿���', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100306, 0, '�ֿ��˸�����Ϣ', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100307;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100307, 0, '��������', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100308;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100308, 0, '���׷���ʱ��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100309;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100309, 0, '���׽��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100310;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100310, 0, '����IP��ַ', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100311;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100311, 0, '�������ʱ��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100312;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100312, 0, '����״̬', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100313;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100313, 0, '�쳣����', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100314;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100314, 0, 'ʵ����֤״̬', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100315;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100315, 0, '�������κ�', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100316;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100316, 0, '����״̬', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100317;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100317, 0, '��������', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100318;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100318, 0, '����ʱ��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100319;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100319, 0, '����޸�ʱ��', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100320;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100320, 0, '����޸���', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100321;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100321, 0, '���н���״̬', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100322;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100322, 0, '�������κ�', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100323;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100323, 0, '����״̬', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100400, 0, '���ؽ�������', 1, 0);
--
delete from HI_Language where ID = 100401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100401, 0, '�����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100402, 0, '���״���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100403, 0, '�̻���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100404, 0, '���׽��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100405, 0, '����ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100406, 0, '����״̬', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100407, 0, '������Ϣ', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100408, 0, '����ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100409, 0, '����޸�ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100410, 0, '����޸���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100411, 0, '�ֿ��˿���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100412, 0, '�ֿ��˸�����Ϣ', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100413, 0, 'ƽ̨��ˮ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100414, 0, '����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100415;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100415, 0, '�˻�����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100416;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100416, 0, '�˻�����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100417;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100417, 0, '�������ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 101100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101100, 0, '���ؽ��׽��', 1, 0);
--
delete from HI_Language where ID = 101101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101101, 0, '֪ͨ��¼id��ʶ', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101102, 0, '��Ӧ��ϵͳ������', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101103, 0, '����ϵͳ�Ļ�����', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101104, 0, '����ϵͳ�Ľ�����ˮ��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101105, 0, '���׽��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101106, 0, '���ĵ�ԭʼ����', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101107, 0, '���ر��ı�ʶ�����ĳɹ�״̬', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101108, 0, '���ͱ��ĵ�IP��ַ', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101109, 0, '����޸�ʱ��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101110, 0, '����޸���', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101111, 0, '����ʱ��', 'TblMbTransactionResponse', 1, 0);
