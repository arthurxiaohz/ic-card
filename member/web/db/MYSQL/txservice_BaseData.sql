
delete from HiMenu where ID = 200000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(200000, 0, 'txservice', '交易服务', '交易服务', 0, 9999, 0);
--



delete from MenuLink where ID = 200100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200100, 0, '/tblTxPayMentOrderList.action', '订单查询', '订单查询', 200100, 9999, 200000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200100, 0, 'TBLTXPAYMENTORDER_LIST', 'txservice.TblTxPayMentOrderList', '', '订单查询查询', 1, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200101, 0, 'TBLTXPAYMENTORDER_VIEW', 'txservice.TblTxPayMentOrderView', '', '订单查询查看', 2, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200102, 0, 'TBLTXPAYMENTORDER_SAVE', 'txservice.TblTxPayMentOrderSave', '', '订单查询保存', 3, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200103, 0, 'TBLTXPAYMENTORDER_DEL', 'txservice.TblTxPayMentOrderDel', '', '订单查询删除', 4, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200104, 0, 'TBLTXPAYMENTORDER_LOOKUP', 'txservice.TblTxPayMentOrderLookup', '', '订单查询带回', 1, 200100);
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







--
delete from HI_Language where ID = 200100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200100, 0, '订单查询', 1, 0);
--
delete from HI_Language where ID = 200101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200101, 0, '平台交易流水号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200102, 0, '平台会员号', 'TblTxPayMentOrder', 1, 0);
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
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200106, 0, '原始交易发生时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200107, 0, '商户交易流水号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200108, 0, '原始商户交易流水号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200109, 0, '交易金额', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200110, 0, '交易结果通知地址', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200111, 0, '交易IP地址', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200112, 0, '交易完成时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200113, 0, '交易状态', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200114, 0, '凭证号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200115, 0, '撤销凭证号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200116, 0, '是否使用优惠券', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200117, 0, '优惠券信息', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200118, 0, '返回商户优惠券信息', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200119, 0, '商品展示URL', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200120, 0, '商品描述', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200121;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200121, 0, '付款人手机号码', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200122;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200122, 0, '验证码', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200123;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200123, 0, '确认码', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200124;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200124, 0, '确认过期时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200125;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200125, 0, '异常代码', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200126;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200126, 0, '异常描述', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200127;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200127, 0, '结算批次号', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200128;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200128, 0, '结算状态', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200129;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200129, 0, '结算日期', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200130;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200130, 0, '手续费金额', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200131;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200131, 0, '是否已计算手续费', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200132;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200132, 0, '创建时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200133;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200133, 0, '最后修改时间', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200134;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200134, 0, '最后修改人', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200135;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200135, 0, '交易后台通知地址', 'TblTxPayMentOrder', 1, 0);
