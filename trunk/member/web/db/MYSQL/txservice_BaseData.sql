
delete from HiMenu where ID = 200000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(200000, 0, 'txservice', '交易服务', '交易服务', 0, 9999, 0);
--



delete from MenuLink where ID = 200100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200100, 0, '/tblTxPayMentOrderList.action', '交易订单', '交易订单', 200100, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200200, 0, '/tblTxTransferList.action', '转账交易', '转账交易', 200200, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200300, 0, '/tblTxSmsLogList.action', '短信明细', '短信明细', 200300, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200400, 0, '/tblTxTransferRequestList.action', '转账交易请求', '转账交易请求', 200400, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200500, 0, '/tblTxTransferResponseList.action', '转账交易结果通知', '转账交易结果通知', 200500, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200600, 0, '/tblTxPayMentRequestList.action', '商户交易请求', '商户交易请求', 200600, 9999, 200000, 0, 0);
--
delete from MenuLink where ID = 200700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200700, 0, '/tblTxPayMentResponseList.action', '商户交易结果通知', '商户交易结果通知', 200700, 9999, 200000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200100, 0, 'TBLTXPAYMENTORDER_LIST', 'txservice.TblTxPayMentOrderList', '', '交易订单查询', 1, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200101, 0, 'TBLTXPAYMENTORDER_VIEW', 'txservice.TblTxPayMentOrderView', '', '交易订单查看', 2, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200102, 0, 'TBLTXPAYMENTORDER_SAVE', 'txservice.TblTxPayMentOrderSave', '', '交易订单保存', 3, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200103, 0, 'TBLTXPAYMENTORDER_DEL', 'txservice.TblTxPayMentOrderDel', '', '交易订单删除', 4, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200104, 0, 'TBLTXPAYMENTORDER_LOOKUP', 'txservice.TblTxPayMentOrderLookup', '', '交易订单带回', 1, 200100);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200200, 0, 'TBLTXTRANSFER_LIST', 'txservice.TblTxTransferList', '', '转账交易查询', 1, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200201, 0, 'TBLTXTRANSFER_VIEW', 'txservice.TblTxTransferView', '', '转账交易查看', 2, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200202, 0, 'TBLTXTRANSFER_SAVE', 'txservice.TblTxTransferSave', '', '转账交易保存', 3, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200203, 0, 'TBLTXTRANSFER_DEL', 'txservice.TblTxTransferDel', '', '转账交易删除', 4, 200200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200204, 0, 'TBLTXTRANSFER_LOOKUP', 'txservice.TblTxTransferLookup', '', '转账交易带回', 1, 200200);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200300, 0, 'TBLTXSMSLOG_LIST', 'txservice.TblTxSmsLogList', '', '短信明细查询', 1, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200301, 0, 'TBLTXSMSLOG_VIEW', 'txservice.TblTxSmsLogView', '', '短信明细查看', 2, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200302, 0, 'TBLTXSMSLOG_SAVE', 'txservice.TblTxSmsLogSave', '', '短信明细保存', 3, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200303, 0, 'TBLTXSMSLOG_DEL', 'txservice.TblTxSmsLogDel', '', '短信明细删除', 4, 200300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200304, 0, 'TBLTXSMSLOG_LOOKUP', 'txservice.TblTxSmsLogLookup', '', '短信明细带回', 1, 200300);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200400, 0, 'TBLTXTRANSFERREQUEST_LIST', 'txservice.TblTxTransferRequestList', '', '转账交易请求查询', 1, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200401, 0, 'TBLTXTRANSFERREQUEST_VIEW', 'txservice.TblTxTransferRequestView', '', '转账交易请求查看', 2, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200402, 0, 'TBLTXTRANSFERREQUEST_SAVE', 'txservice.TblTxTransferRequestSave', '', '转账交易请求保存', 3, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200403, 0, 'TBLTXTRANSFERREQUEST_DEL', 'txservice.TblTxTransferRequestDel', '', '转账交易请求删除', 4, 200400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200404, 0, 'TBLTXTRANSFERREQUEST_LOOKUP', 'txservice.TblTxTransferRequestLookup', '', '转账交易请求带回', 1, 200400);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200500, 0, 'TBLTXTRANSFERRESPONSE_LIST', 'txservice.TblTxTransferResponseList', '', '转账交易结果通知查询', 1, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200501, 0, 'TBLTXTRANSFERRESPONSE_VIEW', 'txservice.TblTxTransferResponseView', '', '转账交易结果通知查看', 2, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200502, 0, 'TBLTXTRANSFERRESPONSE_SAVE', 'txservice.TblTxTransferResponseSave', '', '转账交易结果通知保存', 3, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200503, 0, 'TBLTXTRANSFERRESPONSE_DEL', 'txservice.TblTxTransferResponseDel', '', '转账交易结果通知删除', 4, 200500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200504, 0, 'TBLTXTRANSFERRESPONSE_LOOKUP', 'txservice.TblTxTransferResponseLookup', '', '转账交易结果通知带回', 1, 200500);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200600, 0, 'TBLTXPAYMENTREQUEST_LIST', 'txservice.TblTxPayMentRequestList', '', '商户交易请求查询', 1, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200601, 0, 'TBLTXPAYMENTREQUEST_VIEW', 'txservice.TblTxPayMentRequestView', '', '商户交易请求查看', 2, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200602, 0, 'TBLTXPAYMENTREQUEST_SAVE', 'txservice.TblTxPayMentRequestSave', '', '商户交易请求保存', 3, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200603, 0, 'TBLTXPAYMENTREQUEST_DEL', 'txservice.TblTxPayMentRequestDel', '', '商户交易请求删除', 4, 200600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200604, 0, 'TBLTXPAYMENTREQUEST_LOOKUP', 'txservice.TblTxPayMentRequestLookup', '', '商户交易请求带回', 1, 200600);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200700, 0, 'TBLTXPAYMENTRESPONSE_LIST', 'txservice.TblTxPayMentResponseList', '', '商户交易结果通知查询', 1, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200701, 0, 'TBLTXPAYMENTRESPONSE_VIEW', 'txservice.TblTxPayMentResponseView', '', '商户交易结果通知查看', 2, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200702, 0, 'TBLTXPAYMENTRESPONSE_SAVE', 'txservice.TblTxPayMentResponseSave', '', '商户交易结果通知保存', 3, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200703, 0, 'TBLTXPAYMENTRESPONSE_DEL', 'txservice.TblTxPayMentResponseDel', '', '商户交易结果通知删除', 4, 200700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200704, 0, 'TBLTXPAYMENTRESPONSE_LOOKUP', 'txservice.TblTxPayMentResponseLookup', '', '商户交易结果通知带回', 1, 200700);
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
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(200800, 0, 'orderTxStatus', '交易状态', '交易状态', 0, 0);
--
delete from Enumeration where ID = 200900;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(200900, 0, 'useCoupon', '是否使用优惠券', '是否使用优惠券', 0, 0);
--
delete from Enumeration where ID = 201000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(201000, 0, 'settleStatus', '结算状态', '结算状态', 0, 0);
--
delete from Enumeration where ID = 201100;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(201100, 0, 'hasCountFee', '是否已计算手续费', '是否已计算手续费', 0, 0);
--
delete from Enumeration where ID = 201200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(201200, 0, 'transTxStatus', '转账交易状态', '转账交易状态', 0, 0);
--



delete from EnumerationValue where ID = 200800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200800, 0, 'prepay', '待支付', '待支付', '1', 200800, 0);
--
delete from EnumerationValue where ID = 200801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200801, 0, 'prepaysuccess', '预支付成功', '预支付成功', '2', 200800, 0);
--
delete from EnumerationValue where ID = 200802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200802, 0, 'paysuccess', '已确认支付', '已确认支付', '3', 200800, 0);
--
delete from EnumerationValue where ID = 200803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200803, 0, 'backsuccess', '已退款', '已退款', '7', 200800, 0);
--
delete from EnumerationValue where ID = 200804;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200804, 0, 'revocationsuccess', '已撤销', '已撤销', '5', 200800, 0);
--
delete from EnumerationValue where ID = 200805;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200805, 0, 'waitrevocation', '待撤销', '待撤销', '4', 200800, 0);
--
delete from EnumerationValue where ID = 200806;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200806, 0, 'waitback', '待退款', '待退款', '6', 200800, 0);
--
delete from EnumerationValue where ID = 200807;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200807, 0, 'fail', '失败', '失败', '8', 200800, 0);
--
delete from EnumerationValue where ID = 200900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200900, 0, 'use', '使用', '使用', '1', 200900, 0);
--
delete from EnumerationValue where ID = 200901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(200901, 0, 'unuse', '不使用', '不使用', '2', 200900, 0);
--
delete from EnumerationValue where ID = 201000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201000, 0, 'unsettle', '未结算', '未结算', '0', 201000, 0);
--
delete from EnumerationValue where ID = 201001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201001, 0, 'settle', '已结算', '已结算', '1', 201000, 0);
--
delete from EnumerationValue where ID = 201100;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201100, 0, 'unfee', '未计算', '未计算', '0', 201100, 0);
--
delete from EnumerationValue where ID = 201101;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201101, 0, 'fee', '已计算', '已计算', '1', 201100, 0);
--
delete from EnumerationValue where ID = 201200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201200, 0, 'unfransfer', '待转帐', '待转帐', '1', 201200, 0);
--
delete from EnumerationValue where ID = 201201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201201, 0, 'fransfersuccess', '转账成功', '转账成功', '2', 201200, 0);
--
delete from EnumerationValue where ID = 201202;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(201202, 0, 'fransferfail', '转账失败', '转账失败', '3', 201200, 0);
--

--
delete from HI_Language where ID = 200100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200100, 0, '交易订单', 1, 0);
--
delete from HI_Language where ID = 200101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200101, 0, '平台交易流水号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200102, 0, '会员账号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200103, 0, '交易类型', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200104, 0, '商户号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200105, 0, '交易发生时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200106, 0, '商户交易流水号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200107, 0, '订单金额', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200108, 0, '交易完成时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200109, 0, '交易状态', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200110, 0, '商品描述', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200111, 0, '确认过期时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200112, 0, '异常代码', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200113, 0, '异常描述', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200114, 0, '创建时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200115, 0, '最后修改时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200116, 0, '商户名称', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200117, 0, '支付金额', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200200, 0, '转账交易', 1, 0);
--
delete from HI_Language where ID = 200201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200201, 0, '平台交易流水号', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200202, 0, '会员账号', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200203, 0, '交易类型', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200204, 0, '商户号', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200205, 0, '交易发生时间', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200206, 0, '商户交易流水号', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200207, 0, '交易金额', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200208;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200208, 0, '交易状态', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200209;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200209, 0, '异常代码', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200210;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200210, 0, '创建时间', 'TblTxTransfer', 1, 0);
--
delete from HI_Language where ID = 200300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200300, 0, '短信明细', 1, 0);
--
delete from HI_Language where ID = 200301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200301, 0, '发送方标识', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200302, 0, '发送方流水号', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200303, 0, '手机号码', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200304, 0, '发送状态', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200305, 0, '创建时间', 'TblTxSmsLog', 1, 0);
--
delete from HI_Language where ID = 200400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200400, 0, '转账交易请求', 1, 0);
--
delete from HI_Language where ID = 200401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200401, 0, '商户交易流水号', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200402, 0, '商户号', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200403, 0, '交易金额', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200404, 0, '卡余额', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200405, 0, '卡序号', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200406, 0, '卡号', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200407, 0, '交易时间', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200408, 0, '交易状态', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200409, 0, '交易类型', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200410, 0, '附加信息', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200411, 0, '原始报文', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200412, 0, '创建时间', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200413, 0, '最后修改时间', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200414, 0, '最后修改人', 'TblTxTransferRequest', 1, 0);
--
delete from HI_Language where ID = 200500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200500, 0, '转账交易结果通知', 1, 0);
--
delete from HI_Language where ID = 200501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200501, 0, '返回接口的版本号', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200502, 0, '签名内容', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200503, 0, '转账结果', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200504, 0, '平台交易流水号', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200505;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200505, 0, '商户订单号', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200506;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200506, 0, '商户转账金额', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200507;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200507, 0, '交易类型', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200508;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200508, 0, '支付完成时间', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200509;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200509, 0, '扩展参数1', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200510;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200510, 0, '扩展参数2', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200511;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200511, 0, '创建时间', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200512;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200512, 0, '最后修改时间', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200513;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200513, 0, '最后修改人', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200514;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200514, 0, '错误代码', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200515;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200515, 0, '报文内容', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200516;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200516, 0, '商户返回结果', 'TblTxTransferResponse', 1, 0);
--
delete from HI_Language where ID = 200600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200600, 0, '商户交易请求', 1, 0);
--
delete from HI_Language where ID = 200601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200601, 0, '商户交易流水号', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200602, 0, '商户号', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200603, 0, '交易金额', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200604, 0, '交易时间', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200605, 0, '交易状态', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200606, 0, '交易类型', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200607, 0, '创建时间', 'TblTxPayMentRequest', 1, 0);
--
delete from HI_Language where ID = 200700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200700, 0, '商户交易结果通知', 1, 0);
--
delete from HI_Language where ID = 200701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200701, 0, '返回接口的版本号', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200702, 0, '支付结果', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200703, 0, '商户号', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200704, 0, '商户订单号', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200705, 0, '商户订单金额', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200706, 0, '交易类型', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200707, 0, '在系统中的订单实际支付金额', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200708, 0, '错误代码', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200709;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200709, 0, '创建时间', 'TblTxPayMentResponse', 1, 0);
--
delete from HI_Language where ID = 200800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200800, 0, '交易状态', 1, 0);
--
delete from HI_Language where ID = 200801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200801, 0, '待支付', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200802, 0, '预支付成功', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200803, 0, '已确认支付', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200804, 0, '已退款', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200805, 0, '已撤销', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200806;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200806, 0, '待撤销', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200807;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200807, 0, '待退款', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200808;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200808, 0, '失败', 'orderTxStatus', 1, 0);
--
delete from HI_Language where ID = 200900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200900, 0, '是否使用优惠券', 1, 0);
--
delete from HI_Language where ID = 200901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200901, 0, '使用', 'useCoupon', 1, 0);
--
delete from HI_Language where ID = 200902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200902, 0, '不使用', 'useCoupon', 1, 0);
--
delete from HI_Language where ID = 201000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(201000, 0, '结算状态', 1, 0);
--
delete from HI_Language where ID = 201001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201001, 0, '未结算', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 201002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201002, 0, '已结算', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 201100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(201100, 0, '是否已计算手续费', 1, 0);
--
delete from HI_Language where ID = 201101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201101, 0, '未计算', 'hasCountFee', 1, 0);
--
delete from HI_Language where ID = 201102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201102, 0, '已计算', 'hasCountFee', 1, 0);
--
delete from HI_Language where ID = 201200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(201200, 0, '转账交易状态', 1, 0);
--
delete from HI_Language where ID = 201201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201201, 0, '待转帐', 'transTxStatus', 1, 0);
--
delete from HI_Language where ID = 201202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201202, 0, '转账成功', 'transTxStatus', 1, 0);
--
delete from HI_Language where ID = 201203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(201203, 0, '转账失败', 'transTxStatus', 1, 0);
