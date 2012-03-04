
delete from HiMenu where ID = 100000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(100000, 0, 'memberservice', '会员交易查询', '会员交易查询', 0, 9999, 0);
--



delete from MenuLink where ID = 100100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100100, 0, '/tblMbInfoList.action', '会员信息', '会员信息', 100100, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100300, 0, '/tblMbRechargeOrderList.action', '充值订单', '充值订单', 100300, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100400, 0, '/tblMbTransactionRequestList.action', '网关交易请求', '网关交易请求', 100400, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101100, 0, '/tblMbTransactionResponseList.action', '网关交易结果', '网关交易结果', 101100, 9999, 100000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100100, 0, 'TBLMBINFO_LIST', 'memberservice.TblMbInfoList', '', '会员信息查询', 1, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100101, 0, 'TBLMBINFO_VIEW', 'memberservice.TblMbInfoView', '', '会员信息查看', 2, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100102, 0, 'TBLMBINFO_SAVE', 'memberservice.TblMbInfoSave', '', '会员信息保存', 3, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100103, 0, 'TBLMBINFO_DEL', 'memberservice.TblMbInfoDel', '', '会员信息删除', 4, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100104, 0, 'TBLMBINFO_LOOKUP', 'memberservice.TblMbInfoLookup', '', '会员信息带回', 1, 100100);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100300, 0, 'TBLMBRECHARGEORDER_LIST', 'memberservice.TblMbRechargeOrderList', '', '充值订单查询', 1, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100301, 0, 'TBLMBRECHARGEORDER_VIEW', 'memberservice.TblMbRechargeOrderView', '', '充值订单查看', 2, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100302, 0, 'TBLMBRECHARGEORDER_SAVE', 'memberservice.TblMbRechargeOrderSave', '', '充值订单保存', 3, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100303, 0, 'TBLMBRECHARGEORDER_DEL', 'memberservice.TblMbRechargeOrderDel', '', '充值订单删除', 4, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100304, 0, 'TBLMBRECHARGEORDER_LOOKUP', 'memberservice.TblMbRechargeOrderLookup', '', '充值订单带回', 1, 100300);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100400, 0, 'TBLMBTRANSACTIONREQUEST_LIST', 'memberservice.TblMbTransactionRequestList', '', '网关交易请求查询', 1, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100401, 0, 'TBLMBTRANSACTIONREQUEST_VIEW', 'memberservice.TblMbTransactionRequestView', '', '网关交易请求查看', 2, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100402, 0, 'TBLMBTRANSACTIONREQUEST_SAVE', 'memberservice.TblMbTransactionRequestSave', '', '网关交易请求保存', 3, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100403, 0, 'TBLMBTRANSACTIONREQUEST_DEL', 'memberservice.TblMbTransactionRequestDel', '', '网关交易请求删除', 4, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100404, 0, 'TBLMBTRANSACTIONREQUEST_LOOKUP', 'memberservice.TblMbTransactionRequestLookup', '', '网关交易请求带回', 1, 100400);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101100, 0, 'TBLMBTRANSACTIONRESPONSE_LIST', 'memberservice.TblMbTransactionResponseList', '', '网关交易结果查询', 1, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101101, 0, 'TBLMBTRANSACTIONRESPONSE_VIEW', 'memberservice.TblMbTransactionResponseView', '', '网关交易结果查看', 2, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101102, 0, 'TBLMBTRANSACTIONRESPONSE_SAVE', 'memberservice.TblMbTransactionResponseSave', '', '网关交易结果保存', 3, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101103, 0, 'TBLMBTRANSACTIONRESPONSE_DEL', 'memberservice.TblMbTransactionResponseDel', '', '网关交易结果删除', 4, 101100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101104, 0, 'TBLMBTRANSACTIONRESPONSE_LOOKUP', 'memberservice.TblMbTransactionResponseLookup', '', '网关交易结果带回', 1, 101100);
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
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100100, 0, '会员信息', 1, 0);
--
delete from HI_Language where ID = 100101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100101, 0, '平台交易流水号', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100102, 0, '平台会员号', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100103, 0, '交易类型', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100104, 0, '证件号码', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100105, 0, '真实姓名', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100106, 0, '性别', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100107, 0, '住址', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100108, 0, '邮政编码', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100109, 0, '手机', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100110, 0, '固定电话', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100111, 0, 'Email地址', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100112, 0, '登录密码', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100113, 0, '卡号', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100114, 0, '实名认证状态', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100115, 0, '实名认证时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100116, 0, '注册时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100117, 0, '注册方式', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100118, 0, '创建时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100119, 0, '最后修改时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100120, 0, '最后修改人', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100300, 0, '充值订单', 1, 0);
--
delete from HI_Language where ID = 100301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100301, 0, '平台交易流水号', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100302, 0, '平台会员号', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100303, 0, '账户类型', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100304, 0, '账户号码', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100305, 0, '持卡人卡号', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100306, 0, '持卡人个人信息', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100307;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100307, 0, '交易类型', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100308;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100308, 0, '交易发生时间', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100309;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100309, 0, '交易金额', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100310;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100310, 0, '交易IP地址', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100311;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100311, 0, '交易完成时间', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100312;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100312, 0, '交易状态', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100313;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100313, 0, '异常代码', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100314;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100314, 0, '实名认证状态', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100315;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100315, 0, '结算批次号', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100316;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100316, 0, '结算状态', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100317;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100317, 0, '结算日期', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100318;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100318, 0, '创建时间', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100319;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100319, 0, '最后修改时间', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100320;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100320, 0, '最后修改人', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100321;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100321, 0, '银行交易状态', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100322;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100322, 0, '对账批次号', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100323;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100323, 0, '对账状态', 'TblMbRechargeOrder', 1, 0);
--
delete from HI_Language where ID = 100400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100400, 0, '网关交易请求', 1, 0);
--
delete from HI_Language where ID = 100401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100401, 0, '请求号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100402, 0, '交易代码', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100403, 0, '商户号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100404, 0, '交易金额', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100405, 0, '交易时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100406, 0, '交易状态', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100407, 0, '附加信息', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100408, 0, '创建时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100409, 0, '最后修改时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100410, 0, '最后修改人', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100411, 0, '持卡人卡号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100412, 0, '持卡人个人信息', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100413, 0, '平台流水号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100414, 0, '币种', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100415;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100415, 0, '账户类型', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100416;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100416, 0, '账户号码', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100417;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100417, 0, '交易完成时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 101100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101100, 0, '网关交易结果', 1, 0);
--
delete from HI_Language where ID = 101101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101101, 0, '通知记录id标识', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101102, 0, '对应的系统订单号', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101103, 0, '交易系统的机构号', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101104, 0, '交易系统的交易流水号', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101105, 0, '交易金额', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101106, 0, '报文的原始报文', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101107, 0, '返回报文标识订单的成功状态', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101108, 0, '发送报文的IP地址', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101109, 0, '最后修改时间', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101110, 0, '最后修改人', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101111, 0, '创建时间', 'TblMbTransactionResponse', 1, 0);
