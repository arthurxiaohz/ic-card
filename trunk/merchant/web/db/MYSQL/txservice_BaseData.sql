
delete from HiMenu where ID = 200000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(200000, 0, 'txservice', '���׷���', '���׷���', 0, 9999, 0);
--



delete from MenuLink where ID = 200100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200100, 0, '/tblTxPayMentOrderList.action', '���׶���', '���׶���', 200100, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200200, 0, '/tblTxTransferList.action', 'ת�˽���', 'ת�˽���', 200200, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200300, 0, '/tblTxSmsLogList.action', '������ϸ', '������ϸ', 200300, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200400, 0, '/tblTxTransferRequestList.action', 'ת�˽�������', 'ת�˽�������', 200400, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200500, 0, '/tblTxTransferResponseList.action', 'ת�˽��׽��֪ͨ', 'ת�˽��׽��֪ͨ', 200500, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200600, 0, '/tblTxPayMentRequestList.action', '�̻���������', '�̻���������', 200600, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200700, 0, '/tblTxPayMentResponseList.action', '�̻����׽��֪ͨ', '�̻����׽��֪ͨ', 200700, 9999, 200000, 0, 0);
--



delete from HI_Authority where ID = 200100;
--
delete from HI_Authority where ID = 200101;
--
delete from HI_Authority where ID = 200102;
--
delete from HI_Authority where ID = 200103;
--
delete from HI_Authority where ID = 200104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200100, 0, 'TBLTXPAYMENTORDER_LIST', 'txservice.TblTxPayMentOrderList', '', '���׶�����ѯ', 1, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200101, 0, 'TBLTXPAYMENTORDER_VIEW', 'txservice.TblTxPayMentOrderView', '', '���׶����鿴', 2, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200102, 0, 'TBLTXPAYMENTORDER_SAVE', 'txservice.TblTxPayMentOrderSave', '', '���׶�������', 3, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200103, 0, 'TBLTXPAYMENTORDER_DEL', 'txservice.TblTxPayMentOrderDel', '', '���׶���ɾ��', 4, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200104, 0, 'TBLTXPAYMENTORDER_LOOKUP', 'txservice.TblTxPayMentOrderLookup', '', '���׶�������', 1, 200100);
--
delete from HI_Authority where ID = 200200;
--
delete from HI_Authority where ID = 200201;
--
delete from HI_Authority where ID = 200202;
--
delete from HI_Authority where ID = 200203;
--
delete from HI_Authority where ID = 200204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200200, 0, 'TBLTXTRANSFER_LIST', 'txservice.TblTxTransferList', '', 'ת�˽��ײ�ѯ', 1, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200201, 0, 'TBLTXTRANSFER_VIEW', 'txservice.TblTxTransferView', '', 'ת�˽��ײ鿴', 2, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200202, 0, 'TBLTXTRANSFER_SAVE', 'txservice.TblTxTransferSave', '', 'ת�˽��ױ���', 3, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200203, 0, 'TBLTXTRANSFER_DEL', 'txservice.TblTxTransferDel', '', 'ת�˽���ɾ��', 4, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200204, 0, 'TBLTXTRANSFER_LOOKUP', 'txservice.TblTxTransferLookup', '', 'ת�˽��״���', 1, 200200);
--
delete from HI_Authority where ID = 200300;
--
delete from HI_Authority where ID = 200301;
--
delete from HI_Authority where ID = 200302;
--
delete from HI_Authority where ID = 200303;
--
delete from HI_Authority where ID = 200304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200300, 0, 'TBLTXSMSLOG_LIST', 'txservice.TblTxSmsLogList', '', '������ϸ��ѯ', 1, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200301, 0, 'TBLTXSMSLOG_VIEW', 'txservice.TblTxSmsLogView', '', '������ϸ�鿴', 2, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200302, 0, 'TBLTXSMSLOG_SAVE', 'txservice.TblTxSmsLogSave', '', '������ϸ����', 3, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200303, 0, 'TBLTXSMSLOG_DEL', 'txservice.TblTxSmsLogDel', '', '������ϸɾ��', 4, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200304, 0, 'TBLTXSMSLOG_LOOKUP', 'txservice.TblTxSmsLogLookup', '', '������ϸ����', 1, 200300);
--
delete from HI_Authority where ID = 200400;
--
delete from HI_Authority where ID = 200401;
--
delete from HI_Authority where ID = 200402;
--
delete from HI_Authority where ID = 200403;
--
delete from HI_Authority where ID = 200404;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200400, 0, 'TBLTXTRANSFERREQUEST_LIST', 'txservice.TblTxTransferRequestList', '', 'ת�˽��������ѯ', 1, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200401, 0, 'TBLTXTRANSFERREQUEST_VIEW', 'txservice.TblTxTransferRequestView', '', 'ת�˽�������鿴', 2, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200402, 0, 'TBLTXTRANSFERREQUEST_SAVE', 'txservice.TblTxTransferRequestSave', '', 'ת�˽������󱣴�', 3, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200403, 0, 'TBLTXTRANSFERREQUEST_DEL', 'txservice.TblTxTransferRequestDel', '', 'ת�˽�������ɾ��', 4, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200404, 0, 'TBLTXTRANSFERREQUEST_LOOKUP', 'txservice.TblTxTransferRequestLookup', '', 'ת�˽����������', 1, 200400);
--
delete from HI_Authority where ID = 200500;
--
delete from HI_Authority where ID = 200501;
--
delete from HI_Authority where ID = 200502;
--
delete from HI_Authority where ID = 200503;
--
delete from HI_Authority where ID = 200504;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200500, 0, 'TBLTXTRANSFERRESPONSE_LIST', 'txservice.TblTxTransferResponseList', '', 'ת�˽��׽��֪ͨ��ѯ', 1, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200501, 0, 'TBLTXTRANSFERRESPONSE_VIEW', 'txservice.TblTxTransferResponseView', '', 'ת�˽��׽��֪ͨ�鿴', 2, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200502, 0, 'TBLTXTRANSFERRESPONSE_SAVE', 'txservice.TblTxTransferResponseSave', '', 'ת�˽��׽��֪ͨ����', 3, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200503, 0, 'TBLTXTRANSFERRESPONSE_DEL', 'txservice.TblTxTransferResponseDel', '', 'ת�˽��׽��֪ͨɾ��', 4, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200504, 0, 'TBLTXTRANSFERRESPONSE_LOOKUP', 'txservice.TblTxTransferResponseLookup', '', 'ת�˽��׽��֪ͨ����', 1, 200500);
--
delete from HI_Authority where ID = 200600;
--
delete from HI_Authority where ID = 200601;
--
delete from HI_Authority where ID = 200602;
--
delete from HI_Authority where ID = 200603;
--
delete from HI_Authority where ID = 200604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200600, 0, 'TBLTXPAYMENTREQUEST_LIST', 'txservice.TblTxPayMentRequestList', '', '�̻����������ѯ', 1, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200601, 0, 'TBLTXPAYMENTREQUEST_VIEW', 'txservice.TblTxPayMentRequestView', '', '�̻���������鿴', 2, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200602, 0, 'TBLTXPAYMENTREQUEST_SAVE', 'txservice.TblTxPayMentRequestSave', '', '�̻��������󱣴�', 3, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200603, 0, 'TBLTXPAYMENTREQUEST_DEL', 'txservice.TblTxPayMentRequestDel', '', '�̻���������ɾ��', 4, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200604, 0, 'TBLTXPAYMENTREQUEST_LOOKUP', 'txservice.TblTxPayMentRequestLookup', '', '�̻������������', 1, 200600);
--
delete from HI_Authority where ID = 200700;
--
delete from HI_Authority where ID = 200701;
--
delete from HI_Authority where ID = 200702;
--
delete from HI_Authority where ID = 200703;
--
delete from HI_Authority where ID = 200704;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200700, 0, 'TBLTXPAYMENTRESPONSE_LIST', 'txservice.TblTxPayMentResponseList', '', '�̻����׽��֪ͨ��ѯ', 1, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200701, 0, 'TBLTXPAYMENTRESPONSE_VIEW', 'txservice.TblTxPayMentResponseView', '', '�̻����׽��֪ͨ�鿴', 2, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200702, 0, 'TBLTXPAYMENTRESPONSE_SAVE', 'txservice.TblTxPayMentResponseSave', '', '�̻����׽��֪ͨ����', 3, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200703, 0, 'TBLTXPAYMENTRESPONSE_DEL', 'txservice.TblTxPayMentResponseDel', '', '�̻����׽��֪ͨɾ��', 4, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200704, 0, 'TBLTXPAYMENTRESPONSE_LOOKUP', 'txservice.TblTxPayMentResponseLookup', '', '�̻����׽��֪ͨ����', 1, 200700);
--

delete from HI_PrivilegeResource where ID = 200100;
--
delete from HI_PrivilegeResource where ID = 200101;
--
delete from HI_PrivilegeResource where ID = 200102;
--
delete from HI_PrivilegeResource where ID = 200103;
--
delete from HI_PrivilegeResource where ID = 200104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200100, 0, 'TBLTXPAYMENTORDER_LIST', '/tblTxPayMentOrderList.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.getSecurityTblTxPayMentOrderList', 'TBLTXPAYMENTORDER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200101, 0, 'TBLTXPAYMENTORDER_VIEW', '/tblTxPayMentOrderView.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.getSecurityTblTxPayMentOrderById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200102, 0, 'TBLTXPAYMENTORDER_SAVE', '/tblTxPayMentOrderSave.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.saveSecurityTblTxPayMentOrder');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200103, 0, 'TBLTXPAYMENTORDER_DEL', '/tblTxPayMentOrderRemove.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.removeSecurityTblTxPayMentOrderById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200104, 0, 'TBLTXPAYMENTORDER_LOOKUP', '/tblTxPayMentOrderLookup.action');
--
delete from HI_PrivilegeResource where ID = 200200;
--
delete from HI_PrivilegeResource where ID = 200201;
--
delete from HI_PrivilegeResource where ID = 200202;
--
delete from HI_PrivilegeResource where ID = 200203;
--
delete from HI_PrivilegeResource where ID = 200204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200200, 0, 'TBLTXTRANSFER_LIST', '/tblTxTransferList.action', 'cn.net.iccard.tx.service.TblTxTransferManager.getSecurityTblTxTransferList', 'TBLTXTRANSFER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200201, 0, 'TBLTXTRANSFER_VIEW', '/tblTxTransferView.action', 'cn.net.iccard.tx.service.TblTxTransferManager.getSecurityTblTxTransferById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200202, 0, 'TBLTXTRANSFER_SAVE', '/tblTxTransferSave.action', 'cn.net.iccard.tx.service.TblTxTransferManager.saveSecurityTblTxTransfer');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200203, 0, 'TBLTXTRANSFER_DEL', '/tblTxTransferRemove.action', 'cn.net.iccard.tx.service.TblTxTransferManager.removeSecurityTblTxTransferById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200204, 0, 'TBLTXTRANSFER_LOOKUP', '/tblTxTransferLookup.action');
--
delete from HI_PrivilegeResource where ID = 200300;
--
delete from HI_PrivilegeResource where ID = 200301;
--
delete from HI_PrivilegeResource where ID = 200302;
--
delete from HI_PrivilegeResource where ID = 200303;
--
delete from HI_PrivilegeResource where ID = 200304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200300, 0, 'TBLTXSMSLOG_LIST', '/tblTxSmsLogList.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.getSecurityTblTxSmsLogList', 'TBLTXSMSLOG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200301, 0, 'TBLTXSMSLOG_VIEW', '/tblTxSmsLogView.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.getSecurityTblTxSmsLogById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200302, 0, 'TBLTXSMSLOG_SAVE', '/tblTxSmsLogSave.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.saveSecurityTblTxSmsLog');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200303, 0, 'TBLTXSMSLOG_DEL', '/tblTxSmsLogRemove.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.removeSecurityTblTxSmsLogById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200304, 0, 'TBLTXSMSLOG_LOOKUP', '/tblTxSmsLogLookup.action');
--
delete from HI_PrivilegeResource where ID = 200400;
--
delete from HI_PrivilegeResource where ID = 200401;
--
delete from HI_PrivilegeResource where ID = 200402;
--
delete from HI_PrivilegeResource where ID = 200403;
--
delete from HI_PrivilegeResource where ID = 200404;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200400, 0, 'TBLTXTRANSFERREQUEST_LIST', '/tblTxTransferRequestList.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.getSecurityTblTxTransferRequestList', 'TBLTXTRANSFERREQUEST_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200401, 0, 'TBLTXTRANSFERREQUEST_VIEW', '/tblTxTransferRequestView.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.getSecurityTblTxTransferRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200402, 0, 'TBLTXTRANSFERREQUEST_SAVE', '/tblTxTransferRequestSave.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.saveSecurityTblTxTransferRequest');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200403, 0, 'TBLTXTRANSFERREQUEST_DEL', '/tblTxTransferRequestRemove.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.removeSecurityTblTxTransferRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200404, 0, 'TBLTXTRANSFERREQUEST_LOOKUP', '/tblTxTransferRequestLookup.action');
--
delete from HI_PrivilegeResource where ID = 200500;
--
delete from HI_PrivilegeResource where ID = 200501;
--
delete from HI_PrivilegeResource where ID = 200502;
--
delete from HI_PrivilegeResource where ID = 200503;
--
delete from HI_PrivilegeResource where ID = 200504;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200500, 0, 'TBLTXTRANSFERRESPONSE_LIST', '/tblTxTransferResponseList.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.getSecurityTblTxTransferResponseList', 'TBLTXTRANSFERRESPONSE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200501, 0, 'TBLTXTRANSFERRESPONSE_VIEW', '/tblTxTransferResponseView.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.getSecurityTblTxTransferResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200502, 0, 'TBLTXTRANSFERRESPONSE_SAVE', '/tblTxTransferResponseSave.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.saveSecurityTblTxTransferResponse');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200503, 0, 'TBLTXTRANSFERRESPONSE_DEL', '/tblTxTransferResponseRemove.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.removeSecurityTblTxTransferResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200504, 0, 'TBLTXTRANSFERRESPONSE_LOOKUP', '/tblTxTransferResponseLookup.action');
--
delete from HI_PrivilegeResource where ID = 200600;
--
delete from HI_PrivilegeResource where ID = 200601;
--
delete from HI_PrivilegeResource where ID = 200602;
--
delete from HI_PrivilegeResource where ID = 200603;
--
delete from HI_PrivilegeResource where ID = 200604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200600, 0, 'TBLTXPAYMENTREQUEST_LIST', '/tblTxPayMentRequestList.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.getSecurityTblTxPayMentRequestList', 'TBLTXPAYMENTREQUEST_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200601, 0, 'TBLTXPAYMENTREQUEST_VIEW', '/tblTxPayMentRequestView.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.getSecurityTblTxPayMentRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200602, 0, 'TBLTXPAYMENTREQUEST_SAVE', '/tblTxPayMentRequestSave.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.saveSecurityTblTxPayMentRequest');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200603, 0, 'TBLTXPAYMENTREQUEST_DEL', '/tblTxPayMentRequestRemove.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.removeSecurityTblTxPayMentRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200604, 0, 'TBLTXPAYMENTREQUEST_LOOKUP', '/tblTxPayMentRequestLookup.action');
--
delete from HI_PrivilegeResource where ID = 200700;
--
delete from HI_PrivilegeResource where ID = 200701;
--
delete from HI_PrivilegeResource where ID = 200702;
--
delete from HI_PrivilegeResource where ID = 200703;
--
delete from HI_PrivilegeResource where ID = 200704;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(200700, 0, 'TBLTXPAYMENTRESPONSE_LIST', '/tblTxPayMentResponseList.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.getSecurityTblTxPayMentResponseList', 'TBLTXPAYMENTRESPONSE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200701, 0, 'TBLTXPAYMENTRESPONSE_VIEW', '/tblTxPayMentResponseView.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.getSecurityTblTxPayMentResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200702, 0, 'TBLTXPAYMENTRESPONSE_SAVE', '/tblTxPayMentResponseSave.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.saveSecurityTblTxPayMentResponse');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(200703, 0, 'TBLTXPAYMENTRESPONSE_DEL', '/tblTxPayMentResponseRemove.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.removeSecurityTblTxPayMentResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(200704, 0, 'TBLTXPAYMENTRESPONSE_LOOKUP', '/tblTxPayMentResponseLookup.action');
--



delete from Enumeration where ID = 200800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(200800, 0, 'orderTxStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 200900;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(200900, 0, 'useCoupon', '�Ƿ�ʹ���Ż�ȯ', '�Ƿ�ʹ���Ż�ȯ', 0, 0);
--
delete from Enumeration where ID = 201000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(201000, 0, 'settleStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 201100;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(201100, 0, 'hasCountFee', '�Ƿ��Ѽ���������', '�Ƿ��Ѽ���������', 0, 0);
--
delete from Enumeration where ID = 201200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(201200, 0, 'transTxStatus', 'ת�˽���״̬', 'ת�˽���״̬', 0, 0);
--



delete from EnumerationValue where ID = 200800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200800, 0, 'prepay', '��֧��', '��֧��', '1', 200800, 0);
--
delete from EnumerationValue where ID = 200801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200801, 0, 'prepaysuccess', 'Ԥ֧���ɹ�', 'Ԥ֧���ɹ�', '2', 200800, 0);
--
delete from EnumerationValue where ID = 200802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200802, 0, 'paysuccess', '��ȷ��֧��', '��ȷ��֧��', '3', 200800, 0);
--
delete from EnumerationValue where ID = 200803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200803, 0, 'backsuccess', '���˿�', '���˿�', '7', 200800, 0);
--
delete from EnumerationValue where ID = 200804;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200804, 0, 'revocationsuccess', '�ѳ���', '�ѳ���', '5', 200800, 0);
--
delete from EnumerationValue where ID = 200805;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200805, 0, 'waitrevocation', '������', '������', '4', 200800, 0);
--
delete from EnumerationValue where ID = 200806;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200806, 0, 'waitback', '���˿�', '���˿�', '6', 200800, 0);
--
delete from EnumerationValue where ID = 200807;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200807, 0, 'fail', 'ʧ��', 'ʧ��', '8', 200800, 0);
--
delete from EnumerationValue where ID = 200900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200900, 0, 'use', 'ʹ��', 'ʹ��', '1', 200900, 0);
--
delete from EnumerationValue where ID = 200901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200901, 0, 'unuse', '��ʹ��', '��ʹ��', '2', 200900, 0);
--
delete from EnumerationValue where ID = 201000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201000, 0, 'unsettle', 'δ����', 'δ����', '0', 201000, 0);
--
delete from EnumerationValue where ID = 201001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201001, 0, 'settle', '�ѽ���', '�ѽ���', '1', 201000, 0);
--
delete from EnumerationValue where ID = 201100;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201100, 0, 'unfee', 'δ����', 'δ����', '0', 201100, 0);
--
delete from EnumerationValue where ID = 201101;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201101, 0, 'fee', '�Ѽ���', '�Ѽ���', '1', 201100, 0);
--
delete from EnumerationValue where ID = 201200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201200, 0, 'unfransfer', '��ת��', '��ת��', '1', 201200, 0);
--
delete from EnumerationValue where ID = 201201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201201, 0, 'fransfersuccess', 'ת�˳ɹ�', 'ת�˳ɹ�', '2', 201200, 0);
--
delete from EnumerationValue where ID = 201202;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201202, 0, 'fransferfail', 'ת��ʧ��', 'ת��ʧ��', '3', 201200, 0);
--

--
delete from HI_Language where ID = 200100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200100, 0, '���׶���', 1, 0);
--
delete from HI_Language where ID = 200101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200101, 0, 'ƽ̨������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200102, 0, '��Ա�˺�', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200103, 0, '��������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200104, 0, '�̻���', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200105, 0, '���׷���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200106, 0, '�̻�������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200107, 0, '�������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200108, 0, '�������ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200109, 0, '����״̬', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200110, 0, '��Ʒ����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200111, 0, 'ȷ�Ϲ���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200112, 0, '�쳣����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200113, 0, '�쳣����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200114, 0, '����ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200115, 0, '����޸�ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200116, 0, '�̻�����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200117, 0, '֧�����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200200, 0, 'ת�˽���', 1, 0);
--
delete from HI_Language where ID = 200201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200201, 0, 'ƽ̨������ˮ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200202, 0, '��Ա�˺�', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200203, 0, '��������', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200204, 0, '�̻���', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200205, 0, '���׷���ʱ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200206, 0, '�̻�������ˮ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200207, 0, '���׽��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200208;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200208, 0, '����״̬', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200209;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200209, 0, '�쳣����', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200210;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200210, 0, '����ʱ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200300, 0, '������ϸ', 1, 0);
--
delete from HI_Language where ID = 200301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200301, 0, '���ͷ���ʶ', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200302, 0, '���ͷ���ˮ��', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200303, 0, '�ֻ�����', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200304, 0, '����״̬', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200305, 0, '����ʱ��', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200400, 0, 'ת�˽�������', 1, 0);
--
delete from HI_Language where ID = 200401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200401, 0, '�̻�������ˮ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200402, 0, '�̻���', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200403, 0, '���׽��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200404, 0, '�����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200405, 0, '�����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200406, 0, '����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200407, 0, '����ʱ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200408, 0, '����״̬', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200409, 0, '��������', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200410, 0, '������Ϣ', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200411, 0, 'ԭʼ����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200412, 0, '����ʱ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200413, 0, '����޸�ʱ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200414, 0, '����޸���', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200500, 0, 'ת�˽��׽��֪ͨ', 1, 0);
--
delete from HI_Language where ID = 200501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200501, 0, '���ؽӿڵİ汾��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200502, 0, 'ǩ������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200503, 0, 'ת�˽��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200504, 0, 'ƽ̨������ˮ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200505;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200505, 0, '�̻�������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200506;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200506, 0, '�̻�ת�˽��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200507;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200507, 0, '��������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200508;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200508, 0, '֧�����ʱ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200509;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200509, 0, '��չ����1', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200510;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200510, 0, '��չ����2', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200511;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200511, 0, '����ʱ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200512;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200512, 0, '����޸�ʱ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200513;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200513, 0, '����޸���', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200514;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200514, 0, '�������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200515;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200515, 0, '��������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200516;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200516, 0, '�̻����ؽ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200600, 0, '�̻���������', 1, 0);
--
delete from HI_Language where ID = 200601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200601, 0, '�̻�������ˮ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200602, 0, '�̻���', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200603, 0, '���׽��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200604, 0, '����ʱ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200605, 0, '����״̬', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200606, 0, '��������', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200607, 0, '����ʱ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200700, 0, '�̻����׽��֪ͨ', 1, 0);
--
delete from HI_Language where ID = 200701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200701, 0, '���ؽӿڵİ汾��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200702, 0, '֧�����', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200703, 0, '�̻���', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200704, 0, '�̻�������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200705, 0, '�̻��������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200706, 0, '��������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200707, 0, '��ϵͳ�еĶ���ʵ��֧�����', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200708, 0, '�������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200709;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200709, 0, '����ʱ��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200800, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 200801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200801, 0, '��֧��', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200802, 0, 'Ԥ֧���ɹ�', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200803, 0, '��ȷ��֧��', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200804, 0, '���˿�', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200805, 0, '�ѳ���', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200806;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200806, 0, '������', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200807;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200807, 0, '���˿�', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200808;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200808, 0, 'ʧ��', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200900, 0, '�Ƿ�ʹ���Ż�ȯ', 1, 0);
--
delete from HI_Language where ID = 200901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200901, 0, 'ʹ��', 'useCoupon', 1, 0);
--
delete from HI_Language where ID = 200902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200902, 0, '��ʹ��', 'useCoupon', 1, 0);
--
delete from HI_Language where ID = 201000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(201000, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 201001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201001, 0, 'δ����', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 201002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201002, 0, '�ѽ���', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 201100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(201100, 0, '�Ƿ��Ѽ���������', 1, 0);
--
delete from HI_Language where ID = 201101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201101, 0, 'δ����', 'hasCountFee', 1, 0);
--
delete from HI_Language where ID = 201102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201102, 0, '�Ѽ���', 'hasCountFee', 1, 0);
--
delete from HI_Language where ID = 201200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(201200, 0, 'ת�˽���״̬', 1, 0);
--
delete from HI_Language where ID = 201201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201201, 0, '��ת��', 'transTxStatus', 1, 0);
--
delete from HI_Language where ID = 201202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201202, 0, 'ת�˳ɹ�', 'transTxStatus', 1, 0);
--
delete from HI_Language where ID = 201203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201203, 0, 'ת��ʧ��', 'transTxStatus', 1, 0);
