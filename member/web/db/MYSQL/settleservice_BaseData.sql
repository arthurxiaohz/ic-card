
delete from HiMenu where ID = 500000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(500000, 0, 'settleservice', '清算服务', '清算服务', 0, 9999, 0);
--



delete from MenuLink where ID = 500100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500100, 0, '/tblStlCleaningDetailList.action', '清分流水表', '清分流水表', 500100, 9999, 500000, 0, 0);
--
delete from MenuLink where ID = 500500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500500, 0, '/tblStlSettleBatchList.action', '结算批次', '结算批次', 500500, 9999, 500000, 0, 0);
--



delete from HI_Authority where ID = 500100;
--
delete from HI_Authority where ID = 500101;
--
delete from HI_Authority where ID = 500102;
--
delete from HI_Authority where ID = 500103;
--
delete from HI_Authority where ID = 500104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500100, 0, 'TBLSTLCLEANINGDETAIL_LIST', 'settleservice.TblStlCleaningDetailList', '', '清分流水表查询', 1, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500101, 0, 'TBLSTLCLEANINGDETAIL_VIEW', 'settleservice.TblStlCleaningDetailView', '', '清分流水表查看', 2, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500102, 0, 'TBLSTLCLEANINGDETAIL_SAVE', 'settleservice.TblStlCleaningDetailSave', '', '清分流水表保存', 3, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500103, 0, 'TBLSTLCLEANINGDETAIL_DEL', 'settleservice.TblStlCleaningDetailDel', '', '清分流水表删除', 4, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500104, 0, 'TBLSTLCLEANINGDETAIL_LOOKUP', 'settleservice.TblStlCleaningDetailLookup', '', '清分流水表带回', 1, 500100);
--
delete from HI_Authority where ID = 500500;
--
delete from HI_Authority where ID = 500501;
--
delete from HI_Authority where ID = 500502;
--
delete from HI_Authority where ID = 500503;
--
delete from HI_Authority where ID = 500504;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500500, 0, 'TBLSTLSETTLEBATCH_LIST', 'settleservice.TblStlSettleBatchList', '', '结算批次查询', 1, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500501, 0, 'TBLSTLSETTLEBATCH_VIEW', 'settleservice.TblStlSettleBatchView', '', '结算批次查看', 2, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500502, 0, 'TBLSTLSETTLEBATCH_SAVE', 'settleservice.TblStlSettleBatchSave', '', '结算批次保存', 3, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500503, 0, 'TBLSTLSETTLEBATCH_DEL', 'settleservice.TblStlSettleBatchDel', '', '结算批次删除', 4, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500504, 0, 'TBLSTLSETTLEBATCH_LOOKUP', 'settleservice.TblStlSettleBatchLookup', '', '结算批次带回', 1, 500500);
--

delete from HI_PrivilegeResource where ID = 500100;
--
delete from HI_PrivilegeResource where ID = 500101;
--
delete from HI_PrivilegeResource where ID = 500102;
--
delete from HI_PrivilegeResource where ID = 500103;
--
delete from HI_PrivilegeResource where ID = 500104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(500100, 0, 'TBLSTLCLEANINGDETAIL_LIST', '/tblStlCleaningDetailList.action', 'cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager.getSecurityTblStlCleaningDetailList', 'TBLSTLCLEANINGDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500101, 0, 'TBLSTLCLEANINGDETAIL_VIEW', '/tblStlCleaningDetailView.action', 'cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager.getSecurityTblStlCleaningDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500102, 0, 'TBLSTLCLEANINGDETAIL_SAVE', '/tblStlCleaningDetailSave.action', 'cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager.saveSecurityTblStlCleaningDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500103, 0, 'TBLSTLCLEANINGDETAIL_DEL', '/tblStlCleaningDetailRemove.action', 'cn.net.iccard.bm.settleservice.service.TblStlCleaningDetailManager.removeSecurityTblStlCleaningDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(500104, 0, 'TBLSTLCLEANINGDETAIL_LOOKUP', '/tblStlCleaningDetailLookup.action');
--
delete from HI_PrivilegeResource where ID = 500500;
--
delete from HI_PrivilegeResource where ID = 500501;
--
delete from HI_PrivilegeResource where ID = 500502;
--
delete from HI_PrivilegeResource where ID = 500503;
--
delete from HI_PrivilegeResource where ID = 500504;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(500500, 0, 'TBLSTLSETTLEBATCH_LIST', '/tblStlSettleBatchList.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.getSecurityTblStlSettleBatchList', 'TBLSTLSETTLEBATCH_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500501, 0, 'TBLSTLSETTLEBATCH_VIEW', '/tblStlSettleBatchView.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.getSecurityTblStlSettleBatchById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500502, 0, 'TBLSTLSETTLEBATCH_SAVE', '/tblStlSettleBatchSave.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.saveSecurityTblStlSettleBatch');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500503, 0, 'TBLSTLSETTLEBATCH_DEL', '/tblStlSettleBatchRemove.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.removeSecurityTblStlSettleBatchById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(500504, 0, 'TBLSTLSETTLEBATCH_LOOKUP', '/tblStlSettleBatchLookup.action');
--



delete from Enumeration where ID = 500200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500200, 0, 'refund', '是否退款状态', '是否退款状态', 0, 0);
--
delete from Enumeration where ID = 500300;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500300, 0, 'bankFeeBack', '银行方退款交易是否退交易手续费', '银行方退款交易是否退交易手续费', 0, 0);
--
delete from Enumeration where ID = 500600;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500600, 0, 'cleanStatus', '清分状态', '清分状态', 0, 0);
--



delete from EnumerationValue where ID = 500200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500200, 0, 'noRefund', '无退款', '无退款', '1', 500200, 0);
--
delete from EnumerationValue where ID = 500201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500201, 0, 'refund', '退款订单', '退款订单', '2', 500200, 0);
--
delete from EnumerationValue where ID = 500300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500300, 0, 'noback', '不退', '不退', '1', 500300, 0);
--
delete from EnumerationValue where ID = 500301;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500301, 0, 'back', '退', '退', '2', 500300, 0);
--
delete from EnumerationValue where ID = 500600;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500600, 0, 'success', '成功', '成功', '1', 500600, 0);
--
delete from EnumerationValue where ID = 500601;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500601, 0, 'fail', '失败', '失败', '2', 500600, 0);
--

--
delete from HI_Language where ID = 500100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500100, 0, '清分流水表', 1, 0);
--
delete from HI_Language where ID = 500101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500101, 0, '平台交易流水号', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500102, 0, '商户订单号', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500103, 0, '创建时间', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500104, 0, '最后修改时间', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500105, 0, '最后修改人', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500106, 0, '订单金额', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500107, 0, '交易时间', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500108, 0, '退款原始订单', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500109, 0, '退款订单原始交易金额', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500110, 0, '退款金额', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500111, 0, '退还的手续费用', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500112, 0, '商户结算扣费金额', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500113, 0, '备注信息', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500114, 0, '交易类型', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500115, 0, '账号', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500116, 0, '积分', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500117, 0, '退还积分', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500118, 0, '商户号', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500119, 0, '商户名称', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500120, 0, '清分状态', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500121;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500121, 0, '支付金额', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500122;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500122, 0, '商户手续费', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500200, 0, '是否退款状态', 1, 0);
--
delete from HI_Language where ID = 500201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500201, 0, '无退款', 'refund', 1, 0);
--
delete from HI_Language where ID = 500202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500202, 0, '退款订单', 'refund', 1, 0);
--
delete from HI_Language where ID = 500300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500300, 0, '银行方退款交易是否退交易手续费', 1, 0);
--
delete from HI_Language where ID = 500301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500301, 0, '不退', 'bankFeeBack', 1, 0);
--
delete from HI_Language where ID = 500302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500302, 0, '退', 'bankFeeBack', 1, 0);
--
delete from HI_Language where ID = 500500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500500, 0, '结算批次', 1, 0);
--
delete from HI_Language where ID = 500501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500501, 0, '结算批次号', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500502, 0, '商户号', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500503, 0, '商户名称', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500504, 0, '开户行行号', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500505;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500505, 0, '开户行名称', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500506;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500506, 0, '银行账户账号', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500507;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500507, 0, '银行账户名称', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500508;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500508, 0, '创建时间', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500509;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500509, 0, '最后修改时间', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500510;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500510, 0, '支付总比数', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500511;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500511, 0, '支付总金额', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500512;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500512, 0, '支付总手续费', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500513;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500513, 0, '退款总笔数', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500514;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500514, 0, '退款总金额', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500515;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500515, 0, '退款总手续费', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500516;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500516, 0, '结算金额', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500600, 0, '清分状态', 1, 0);
--
delete from HI_Language where ID = 500601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500601, 0, '成功', 'cleanStatus', 1, 0);
--
delete from HI_Language where ID = 500602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500602, 0, '失败', 'cleanStatus', 1, 0);
