
delete from HiMenu where ID = 200000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(200000, 0, 'txservice', '���ײ�ѯ', '���ײ�ѯ', 0, 9999, 0);
--



delete from MenuLink where ID = 100100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100100, 0, '/tblTxPayMentOrderList.action', '������ѯ', '������ѯ', 100100, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 100200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100200, 0, '/tblTxTransferList.action', 'ת�˲�ѯ', 'ת�˲�ѯ', 100200, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 100300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100300, 0, '/tblTxSmsLogList.action', '������ϸ', '������ϸ', 100300, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 100400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100400, 0, '/tblTxTransferRequestList.action', 'ת������ԭʼ����', 'ת������ԭʼ����', 100400, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 100500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100500, 0, '/tblTxTransferResponseList.action', 'ת�˽��֪ͨ', 'ת�˽��֪ͨ', 100500, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 100600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100600, 0, '/tblTxPayMentRequestList.action', '�̻�����ԭʼ����', '�̻�����ԭʼ����', 100600, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 100700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100700, 0, '/tblTxPayMentResponseList.action', '�̻����֪ͨ', '�̻����֪ͨ', 100700, 9999, 200000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100100, 0, 'TBLTXPAYMENTORDER_LIST', 'txservice.TblTxPayMentOrderList', '', '������ѯ��ѯ', 1, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100101, 0, 'TBLTXPAYMENTORDER_VIEW', 'txservice.TblTxPayMentOrderView', '', '������ѯ�鿴', 2, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100102, 0, 'TBLTXPAYMENTORDER_SAVE', 'txservice.TblTxPayMentOrderSave', '', '������ѯ����', 3, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100103, 0, 'TBLTXPAYMENTORDER_DEL', 'txservice.TblTxPayMentOrderDel', '', '������ѯɾ��', 4, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100104, 0, 'TBLTXPAYMENTORDER_LOOKUP', 'txservice.TblTxPayMentOrderLookup', '', '������ѯ����', 1, 100100);
--
delete from HI_Authority where ID = 100200;
--
delete from HI_Authority where ID = 100201;
--
delete from HI_Authority where ID = 100202;
--
delete from HI_Authority where ID = 100203;
--
delete from HI_Authority where ID = 100204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100200, 0, 'TBLTXTRANSFER_LIST', 'txservice.TblTxTransferList', '', 'ת�˲�ѯ��ѯ', 1, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100201, 0, 'TBLTXTRANSFER_VIEW', 'txservice.TblTxTransferView', '', 'ת�˲�ѯ�鿴', 2, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100202, 0, 'TBLTXTRANSFER_SAVE', 'txservice.TblTxTransferSave', '', 'ת�˲�ѯ����', 3, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100203, 0, 'TBLTXTRANSFER_DEL', 'txservice.TblTxTransferDel', '', 'ת�˲�ѯɾ��', 4, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100204, 0, 'TBLTXTRANSFER_LOOKUP', 'txservice.TblTxTransferLookup', '', 'ת�˲�ѯ����', 1, 100200);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100300, 0, 'TBLTXSMSLOG_LIST', 'txservice.TblTxSmsLogList', '', '������ϸ��ѯ', 1, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100301, 0, 'TBLTXSMSLOG_VIEW', 'txservice.TblTxSmsLogView', '', '������ϸ�鿴', 2, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100302, 0, 'TBLTXSMSLOG_SAVE', 'txservice.TblTxSmsLogSave', '', '������ϸ����', 3, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100303, 0, 'TBLTXSMSLOG_DEL', 'txservice.TblTxSmsLogDel', '', '������ϸɾ��', 4, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100304, 0, 'TBLTXSMSLOG_LOOKUP', 'txservice.TblTxSmsLogLookup', '', '������ϸ����', 1, 100300);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100400, 0, 'TBLTXTRANSFERREQUEST_LIST', 'txservice.TblTxTransferRequestList', '', 'ת������ԭʼ���Ĳ�ѯ', 1, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100401, 0, 'TBLTXTRANSFERREQUEST_VIEW', 'txservice.TblTxTransferRequestView', '', 'ת������ԭʼ���Ĳ鿴', 2, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100402, 0, 'TBLTXTRANSFERREQUEST_SAVE', 'txservice.TblTxTransferRequestSave', '', 'ת������ԭʼ���ı���', 3, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100403, 0, 'TBLTXTRANSFERREQUEST_DEL', 'txservice.TblTxTransferRequestDel', '', 'ת������ԭʼ����ɾ��', 4, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100404, 0, 'TBLTXTRANSFERREQUEST_LOOKUP', 'txservice.TblTxTransferRequestLookup', '', 'ת������ԭʼ���Ĵ���', 1, 100400);
--
delete from HI_Authority where ID = 100500;
--
delete from HI_Authority where ID = 100501;
--
delete from HI_Authority where ID = 100502;
--
delete from HI_Authority where ID = 100503;
--
delete from HI_Authority where ID = 100504;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100500, 0, 'TBLTXTRANSFERRESPONSE_LIST', 'txservice.TblTxTransferResponseList', '', 'ת�˽��֪ͨ��ѯ', 1, 100500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100501, 0, 'TBLTXTRANSFERRESPONSE_VIEW', 'txservice.TblTxTransferResponseView', '', 'ת�˽��֪ͨ�鿴', 2, 100500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100502, 0, 'TBLTXTRANSFERRESPONSE_SAVE', 'txservice.TblTxTransferResponseSave', '', 'ת�˽��֪ͨ����', 3, 100500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100503, 0, 'TBLTXTRANSFERRESPONSE_DEL', 'txservice.TblTxTransferResponseDel', '', 'ת�˽��֪ͨɾ��', 4, 100500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100504, 0, 'TBLTXTRANSFERRESPONSE_LOOKUP', 'txservice.TblTxTransferResponseLookup', '', 'ת�˽��֪ͨ����', 1, 100500);
--
delete from HI_Authority where ID = 100600;
--
delete from HI_Authority where ID = 100601;
--
delete from HI_Authority where ID = 100602;
--
delete from HI_Authority where ID = 100603;
--
delete from HI_Authority where ID = 100604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100600, 0, 'TBLTXPAYMENTREQUEST_LIST', 'txservice.TblTxPayMentRequestList', '', '�̻�����ԭʼ���Ĳ�ѯ', 1, 100600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100601, 0, 'TBLTXPAYMENTREQUEST_VIEW', 'txservice.TblTxPayMentRequestView', '', '�̻�����ԭʼ���Ĳ鿴', 2, 100600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100602, 0, 'TBLTXPAYMENTREQUEST_SAVE', 'txservice.TblTxPayMentRequestSave', '', '�̻�����ԭʼ���ı���', 3, 100600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100603, 0, 'TBLTXPAYMENTREQUEST_DEL', 'txservice.TblTxPayMentRequestDel', '', '�̻�����ԭʼ����ɾ��', 4, 100600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100604, 0, 'TBLTXPAYMENTREQUEST_LOOKUP', 'txservice.TblTxPayMentRequestLookup', '', '�̻�����ԭʼ���Ĵ���', 1, 100600);
--
delete from HI_Authority where ID = 100700;
--
delete from HI_Authority where ID = 100701;
--
delete from HI_Authority where ID = 100702;
--
delete from HI_Authority where ID = 100703;
--
delete from HI_Authority where ID = 100704;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100700, 0, 'TBLTXPAYMENTRESPONSE_LIST', 'txservice.TblTxPayMentResponseList', '', '�̻����֪ͨ��ѯ', 1, 100700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100701, 0, 'TBLTXPAYMENTRESPONSE_VIEW', 'txservice.TblTxPayMentResponseView', '', '�̻����֪ͨ�鿴', 2, 100700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100702, 0, 'TBLTXPAYMENTRESPONSE_SAVE', 'txservice.TblTxPayMentResponseSave', '', '�̻����֪ͨ����', 3, 100700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100703, 0, 'TBLTXPAYMENTRESPONSE_DEL', 'txservice.TblTxPayMentResponseDel', '', '�̻����֪ͨɾ��', 4, 100700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100704, 0, 'TBLTXPAYMENTRESPONSE_LOOKUP', 'txservice.TblTxPayMentResponseLookup', '', '�̻����֪ͨ����', 1, 100700);
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
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100100, 0, 'TBLTXPAYMENTORDER_LIST', '/tblTxPayMentOrderList.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.getSecurityTblTxPayMentOrderList', 'TBLTXPAYMENTORDER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100101, 0, 'TBLTXPAYMENTORDER_VIEW', '/tblTxPayMentOrderView.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.getSecurityTblTxPayMentOrderById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100102, 0, 'TBLTXPAYMENTORDER_SAVE', '/tblTxPayMentOrderSave.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.saveSecurityTblTxPayMentOrder');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100103, 0, 'TBLTXPAYMENTORDER_DEL', '/tblTxPayMentOrderRemove.action', 'cn.net.iccard.tx.service.TblTxPayMentOrderManager.removeSecurityTblTxPayMentOrderById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100104, 0, 'TBLTXPAYMENTORDER_LOOKUP', '/tblTxPayMentOrderLookup.action');
--
delete from HI_PrivilegeResource where ID = 100200;
--
delete from HI_PrivilegeResource where ID = 100201;
--
delete from HI_PrivilegeResource where ID = 100202;
--
delete from HI_PrivilegeResource where ID = 100203;
--
delete from HI_PrivilegeResource where ID = 100204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100200, 0, 'TBLTXTRANSFER_LIST', '/tblTxTransferList.action', 'cn.net.iccard.tx.service.TblTxTransferManager.getSecurityTblTxTransferList', 'TBLTXTRANSFER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100201, 0, 'TBLTXTRANSFER_VIEW', '/tblTxTransferView.action', 'cn.net.iccard.tx.service.TblTxTransferManager.getSecurityTblTxTransferById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100202, 0, 'TBLTXTRANSFER_SAVE', '/tblTxTransferSave.action', 'cn.net.iccard.tx.service.TblTxTransferManager.saveSecurityTblTxTransfer');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100203, 0, 'TBLTXTRANSFER_DEL', '/tblTxTransferRemove.action', 'cn.net.iccard.tx.service.TblTxTransferManager.removeSecurityTblTxTransferById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100204, 0, 'TBLTXTRANSFER_LOOKUP', '/tblTxTransferLookup.action');
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
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100300, 0, 'TBLTXSMSLOG_LIST', '/tblTxSmsLogList.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.getSecurityTblTxSmsLogList', 'TBLTXSMSLOG_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100301, 0, 'TBLTXSMSLOG_VIEW', '/tblTxSmsLogView.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.getSecurityTblTxSmsLogById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100302, 0, 'TBLTXSMSLOG_SAVE', '/tblTxSmsLogSave.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.saveSecurityTblTxSmsLog');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100303, 0, 'TBLTXSMSLOG_DEL', '/tblTxSmsLogRemove.action', 'cn.net.iccard.tx.service.TblTxSmsLogManager.removeSecurityTblTxSmsLogById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100304, 0, 'TBLTXSMSLOG_LOOKUP', '/tblTxSmsLogLookup.action');
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
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100400, 0, 'TBLTXTRANSFERREQUEST_LIST', '/tblTxTransferRequestList.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.getSecurityTblTxTransferRequestList', 'TBLTXTRANSFERREQUEST_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100401, 0, 'TBLTXTRANSFERREQUEST_VIEW', '/tblTxTransferRequestView.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.getSecurityTblTxTransferRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100402, 0, 'TBLTXTRANSFERREQUEST_SAVE', '/tblTxTransferRequestSave.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.saveSecurityTblTxTransferRequest');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100403, 0, 'TBLTXTRANSFERREQUEST_DEL', '/tblTxTransferRequestRemove.action', 'cn.net.iccard.tx.service.TblTxTransferRequestManager.removeSecurityTblTxTransferRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100404, 0, 'TBLTXTRANSFERREQUEST_LOOKUP', '/tblTxTransferRequestLookup.action');
--
delete from HI_PrivilegeResource where ID = 100500;
--
delete from HI_PrivilegeResource where ID = 100501;
--
delete from HI_PrivilegeResource where ID = 100502;
--
delete from HI_PrivilegeResource where ID = 100503;
--
delete from HI_PrivilegeResource where ID = 100504;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100500, 0, 'TBLTXTRANSFERRESPONSE_LIST', '/tblTxTransferResponseList.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.getSecurityTblTxTransferResponseList', 'TBLTXTRANSFERRESPONSE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100501, 0, 'TBLTXTRANSFERRESPONSE_VIEW', '/tblTxTransferResponseView.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.getSecurityTblTxTransferResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100502, 0, 'TBLTXTRANSFERRESPONSE_SAVE', '/tblTxTransferResponseSave.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.saveSecurityTblTxTransferResponse');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100503, 0, 'TBLTXTRANSFERRESPONSE_DEL', '/tblTxTransferResponseRemove.action', 'cn.net.iccard.tx.service.TblTxTransferResponseManager.removeSecurityTblTxTransferResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100504, 0, 'TBLTXTRANSFERRESPONSE_LOOKUP', '/tblTxTransferResponseLookup.action');
--
delete from HI_PrivilegeResource where ID = 100600;
--
delete from HI_PrivilegeResource where ID = 100601;
--
delete from HI_PrivilegeResource where ID = 100602;
--
delete from HI_PrivilegeResource where ID = 100603;
--
delete from HI_PrivilegeResource where ID = 100604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100600, 0, 'TBLTXPAYMENTREQUEST_LIST', '/tblTxPayMentRequestList.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.getSecurityTblTxPayMentRequestList', 'TBLTXPAYMENTREQUEST_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100601, 0, 'TBLTXPAYMENTREQUEST_VIEW', '/tblTxPayMentRequestView.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.getSecurityTblTxPayMentRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100602, 0, 'TBLTXPAYMENTREQUEST_SAVE', '/tblTxPayMentRequestSave.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.saveSecurityTblTxPayMentRequest');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100603, 0, 'TBLTXPAYMENTREQUEST_DEL', '/tblTxPayMentRequestRemove.action', 'cn.net.iccard.tx.service.TblTxPayMentRequestManager.removeSecurityTblTxPayMentRequestById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100604, 0, 'TBLTXPAYMENTREQUEST_LOOKUP', '/tblTxPayMentRequestLookup.action');
--
delete from HI_PrivilegeResource where ID = 100700;
--
delete from HI_PrivilegeResource where ID = 100701;
--
delete from HI_PrivilegeResource where ID = 100702;
--
delete from HI_PrivilegeResource where ID = 100703;
--
delete from HI_PrivilegeResource where ID = 100704;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100700, 0, 'TBLTXPAYMENTRESPONSE_LIST', '/tblTxPayMentResponseList.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.getSecurityTblTxPayMentResponseList', 'TBLTXPAYMENTRESPONSE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100701, 0, 'TBLTXPAYMENTRESPONSE_VIEW', '/tblTxPayMentResponseView.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.getSecurityTblTxPayMentResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100702, 0, 'TBLTXPAYMENTRESPONSE_SAVE', '/tblTxPayMentResponseSave.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.saveSecurityTblTxPayMentResponse');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100703, 0, 'TBLTXPAYMENTRESPONSE_DEL', '/tblTxPayMentResponseRemove.action', 'cn.net.iccard.tx.service.TblTxPayMentResponseManager.removeSecurityTblTxPayMentResponseById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100704, 0, 'TBLTXPAYMENTRESPONSE_LOOKUP', '/tblTxPayMentResponseLookup.action');
--



delete from Enumeration where ID = 100800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(100800, 0, 'txStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 100900;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(100900, 0, 'useCoupon', '�Ƿ�ʹ���Ż�ȯ', '�Ƿ�ʹ���Ż�ȯ', 0, 0);
--
delete from Enumeration where ID = 101000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101000, 0, 'settleStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 101100;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101100, 0, 'hasCountFee', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 101200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101200, 0, 'transTxStatus', '����״̬', '����״̬', 0, 0);
--



delete from EnumerationValue where ID = 100800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100800, 0, 'prepay', '��֧��', '��֧��', '1', 100800, 0);
--
delete from EnumerationValue where ID = 100801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100801, 0, 'prepaysuccess', 'Ԥ֧���ɹ�', 'Ԥ֧���ɹ�', '2', 100800, 0);
--
delete from EnumerationValue where ID = 100802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100802, 0, 'paysuccess', '��ȷ��֧��', '��ȷ��֧��', '3', 100800, 0);
--
delete from EnumerationValue where ID = 100803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100803, 0, 'backsuccess', '���˿�', '���˿�', '4', 100800, 0);
--
delete from EnumerationValue where ID = 100804;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100804, 0, 'revocationsuccess', '�ѳ���', '�ѳ���', '5', 100800, 0);
--
delete from EnumerationValue where ID = 100900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100900, 0, 'use', 'ʹ��', 'ʹ��', '1', 100900, 0);
--
delete from EnumerationValue where ID = 100901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100901, 0, 'unuse', '��ʹ��', '��ʹ��', '2', 100900, 0);
--
delete from EnumerationValue where ID = 101000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101000, 0, 'unsettle', 'δ����', 'δ����', '1', 101000, 0);
--
delete from EnumerationValue where ID = 101001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101001, 0, 'settle', '�ѽ���', '�ѽ���', '2', 101000, 0);
--
delete from EnumerationValue where ID = 101100;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101100, 0, 'unfee', 'δ����', 'δ����', '1', 101100, 0);
--
delete from EnumerationValue where ID = 101101;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101101, 0, 'fee', '�Ѽ���', '�Ѽ���', '2', 101100, 0);
--
delete from EnumerationValue where ID = 101200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101200, 0, 'unfransfer', '��ת��', '��ת��', '1', 101200, 0);
--
delete from EnumerationValue where ID = 101201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101201, 0, 'fransfersuccess', 'ת�˳ɹ�', 'ת�˳ɹ�', '2', 101200, 0);
--
delete from EnumerationValue where ID = 101202;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101202, 0, 'fransferfail', 'ת��ʧ��', 'ת��ʧ��', '3', 101200, 0);
--

--
delete from HI_Language where ID = 100100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100100, 0, '������ѯ', 1, 0);
--
delete from HI_Language where ID = 100101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100101, 0, 'ƽ̨������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100102, 0, 'ƽ̨��Ա��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100103, 0, '��������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100104, 0, '�̻���', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100105, 0, '���׷���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100106, 0, 'ԭʼ���׷���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100107, 0, '�̻�������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100108, 0, 'ԭʼ�̻�������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100109, 0, '���׽��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100110, 0, '���׽��֪ͨ��ַ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100111, 0, '����IP��ַ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100112, 0, '�������ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100113, 0, '����״̬', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100114, 0, 'ƾ֤��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100115, 0, '����ƾ֤��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100116, 0, '�Ƿ�ʹ���Ż�ȯ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100117, 0, '�Ż�ȯ��Ϣ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100118, 0, '�����̻��Ż�ȯ��Ϣ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100119, 0, '��ƷչʾURL', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100120, 0, '��Ʒ����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100121;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100121, 0, '�������ֻ�����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100122;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100122, 0, '��֤��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100123;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100123, 0, 'ȷ����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100124;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100124, 0, 'ȷ�Ϲ���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100125;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100125, 0, '�쳣����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100126;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100126, 0, '�쳣����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100127;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100127, 0, '�������κ�', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100128;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100128, 0, '����״̬', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100129;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100129, 0, '��������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100130;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100130, 0, '�����ѽ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100131;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100131, 0, '�Ƿ��Ѽ���������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100132;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100132, 0, '����ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100133;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100133, 0, '����޸�ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100134;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100134, 0, '����޸���', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 100200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100200, 0, 'ת�˲�ѯ', 1, 0);
--
delete from HI_Language where ID = 100201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100201, 0, 'ƽ̨������ˮ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100202, 0, 'ƽ̨��Ա��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100203, 0, '��������', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100204, 0, '�̻���', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100205, 0, '���׷���ʱ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100206, 0, '�̻�������ˮ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100207, 0, '���׽��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100208;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100208, 0, '���׽��֪ͨ��ַ', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100209;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100209, 0, '����IP��ַ', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100210;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100210, 0, '�������ʱ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100211;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100211, 0, '����״̬', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100212;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100212, 0, 'ƾ֤��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100213;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100213, 0, '�쳣����', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100214;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100214, 0, '�쳣����', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100215;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100215, 0, '�������κ�', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100216;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100216, 0, '����״̬', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100217;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100217, 0, '��������', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100218;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100218, 0, '�����ѽ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100219;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100219, 0, '�Ƿ��Ѽ���������', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100220;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100220, 0, '����ʱ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100221;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100221, 0, '����޸�ʱ��', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100222;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100222, 0, '����޸���', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 100300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100300, 0, '������ϸ', 1, 0);
--
delete from HI_Language where ID = 100301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100301, 0, '���ͷ���ʶ', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100302, 0, '���ͷ���ˮ��', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100303, 0, '�ֻ�����', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100304, 0, '��������', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100305, 0, '����״̬', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100306, 0, '����ʱ��', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100307;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100307, 0, '����޸�ʱ��', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100308;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100308, 0, '����޸���', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 100400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100400, 0, 'ת������ԭʼ����', 1, 0);
--
delete from HI_Language where ID = 100401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100401, 0, '�̻�������ˮ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100402, 0, '�̻���', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100403, 0, '���׽��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100404, 0, '�����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100405, 0, '�����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100406, 0, '����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100407, 0, '����ʱ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100408, 0, '����״̬', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100409, 0, '��������', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100410, 0, '������Ϣ', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100411, 0, 'ԭʼ����', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100412, 0, '����ʱ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100413, 0, '����޸�ʱ��', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100414, 0, '����޸���', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 100500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100500, 0, 'ת�˽��֪ͨ', 1, 0);
--
delete from HI_Language where ID = 100501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100501, 0, '֪ͨ��¼id��ʶ', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100502, 0, '���ؽӿڵİ汾��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100503, 0, 'ǩ������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100504, 0, 'ת�˽��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100505;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100505, 0, 'ƽ̨������ˮ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100506;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100506, 0, '�̻�������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100507;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100507, 0, '�̻�ת�˽��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100508;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100508, 0, '��������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100509;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100509, 0, '֧�����ʱ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100510;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100510, 0, '��չ����1', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100511;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100511, 0, '��չ����2', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100512;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100512, 0, '����ʱ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100513;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100513, 0, '����޸�ʱ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100514;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100514, 0, '����޸���', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100515;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100515, 0, '�������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100516;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100516, 0, '��������', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100517;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100517, 0, '�̻����ؽ��', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 100600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100600, 0, '�̻�����ԭʼ����', 1, 0);
--
delete from HI_Language where ID = 100601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100601, 0, '�̻�������ˮ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100602, 0, 'ԭʼ�̻�������ˮ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100603, 0, '�̻���', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100604, 0, '���׽��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100605, 0, 'ԭʼ���׷���ʱ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100606, 0, '����ʱ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100607, 0, '����״̬', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100608;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100608, 0, '��������', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100609;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100609, 0, '������Ϣ', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100610;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100610, 0, 'ԭʼ����', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100611;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100611, 0, '����ʱ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100612;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100612, 0, '����޸�ʱ��', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100613;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100613, 0, '����޸���', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 100700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100700, 0, '�̻����֪ͨ', 1, 0);
--
delete from HI_Language where ID = 100701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100701, 0, '֪ͨ��¼id��ʶ', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100702, 0, '���ؽӿڵİ汾��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100703, 0, 'ǩ������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100704, 0, '֧�����', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100705, 0, '�̻���', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100706, 0, '�̻�������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100707, 0, '�̻��������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100708, 0, '��������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100709;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100709, 0, '��ϵͳ�еĶ���ʵ��֧�����', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100710;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100710, 0, '֧�����ʱ��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100711;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100711, 0, '��չ����1', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100712;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100712, 0, '��չ����2', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100713;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100713, 0, '�������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100714;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100714, 0, '��������', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100715;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100715, 0, '�̻����ؽ��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100716;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100716, 0, '����ʱ��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100717;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100717, 0, '����޸�ʱ��', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100718;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100718, 0, '����޸���', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 100800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100800, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 100801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100801, 0, '��֧��', 'txStatus', 1, 0);
--
delete from HI_Language where ID = 100802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100802, 0, 'Ԥ֧���ɹ�', 'txStatus', 1, 0);
--
delete from HI_Language where ID = 100803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100803, 0, '��ȷ��֧��', 'txStatus', 1, 0);
--
delete from HI_Language where ID = 100804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100804, 0, '���˿�', 'txStatus', 1, 0);
--
delete from HI_Language where ID = 100805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100805, 0, '�ѳ���', 'txStatus', 1, 0);
--
delete from HI_Language where ID = 100900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100900, 0, '�Ƿ�ʹ���Ż�ȯ', 1, 0);
--
delete from HI_Language where ID = 100901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100901, 0, 'ʹ��', 'useCoupon', 1, 0);
--
delete from HI_Language where ID = 100902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100902, 0, '��ʹ��', 'useCoupon', 1, 0);
--
delete from HI_Language where ID = 101000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101000, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 101001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101001, 0, 'δ����', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 101002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101002, 0, '�ѽ���', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 101100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101100, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 101101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101101, 0, 'δ����', 'hasCountFee', 1, 0);
--
delete from HI_Language where ID = 101102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101102, 0, '�Ѽ���', 'hasCountFee', 1, 0);
--
delete from HI_Language where ID = 101200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101200, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 101201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101201, 0, '��ת��', 'transTxStatus', 1, 0);
--
delete from HI_Language where ID = 101202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101202, 0, 'ת�˳ɹ�', 'transTxStatus', 1, 0);
--
delete from HI_Language where ID = 101203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101203, 0, 'ת��ʧ��', 'transTxStatus', 1, 0);
