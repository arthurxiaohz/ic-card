
delete from HiMenu where ID = 500000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(500000, 0, 'settleservice', '清算服务', '清算服务', 0, 9999, 0);
--



delete from MenuLink where ID = 500100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500100, 0, '/tblStlCleaningDetailList.action', '清分流水表', '清分流水表', 500100, 9999, 500000, 0, 0);
--
delete from MenuLink where ID = 500700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500700, 0, '/tblStlSettleApplyList.action', '结算申请', '结算申请', 500700, 9999, 500000, 0, 0);
--
delete from MenuLink where ID = 500900;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500900, 0, '/tblStlSettleBatchList.action', '结算批次', '结算批次', 500900, 9999, 500000, 0, 0);
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
delete from HI_Authority where ID = 500700;
--
delete from HI_Authority where ID = 500701;
--
delete from HI_Authority where ID = 500702;
--
delete from HI_Authority where ID = 500703;
--
delete from HI_Authority where ID = 500704;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500700, 0, 'TBLSTLSETTLEAPPLY_LIST', 'settleservice.TblStlSettleApplyList', '', '结算申请查询', 1, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500701, 0, 'TBLSTLSETTLEAPPLY_VIEW', 'settleservice.TblStlSettleApplyView', '', '结算申请查看', 2, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500702, 0, 'TBLSTLSETTLEAPPLY_SAVE', 'settleservice.TblStlSettleApplySave', '', '结算申请保存', 3, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500703, 0, 'TBLSTLSETTLEAPPLY_DEL', 'settleservice.TblStlSettleApplyDel', '', '结算申请删除', 4, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500704, 0, 'TBLSTLSETTLEAPPLY_LOOKUP', 'settleservice.TblStlSettleApplyLookup', '', '结算申请带回', 1, 500700);
--
delete from HI_Authority where ID = 500900;
--
delete from HI_Authority where ID = 500901;
--
delete from HI_Authority where ID = 500902;
--
delete from HI_Authority where ID = 500903;
--
delete from HI_Authority where ID = 500904;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500900, 0, 'TBLSTLSETTLEBATCH_LIST', 'settleservice.TblStlSettleBatchList', '', '结算批次查询', 1, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500901, 0, 'TBLSTLSETTLEBATCH_VIEW', 'settleservice.TblStlSettleBatchView', '', '结算批次查看', 2, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500902, 0, 'TBLSTLSETTLEBATCH_SAVE', 'settleservice.TblStlSettleBatchSave', '', '结算批次保存', 3, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500903, 0, 'TBLSTLSETTLEBATCH_DEL', 'settleservice.TblStlSettleBatchDel', '', '结算批次删除', 4, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500904, 0, 'TBLSTLSETTLEBATCH_LOOKUP', 'settleservice.TblStlSettleBatchLookup', '', '结算批次带回', 1, 500900);
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
delete from HI_PrivilegeResource where ID = 500700;
--
delete from HI_PrivilegeResource where ID = 500701;
--
delete from HI_PrivilegeResource where ID = 500702;
--
delete from HI_PrivilegeResource where ID = 500703;
--
delete from HI_PrivilegeResource where ID = 500704;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(500700, 0, 'TBLSTLSETTLEAPPLY_LIST', '/tblStlSettleApplyList.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager.getSecurityTblStlSettleApplyList', 'TBLSTLSETTLEAPPLY_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500701, 0, 'TBLSTLSETTLEAPPLY_VIEW', '/tblStlSettleApplyView.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager.getSecurityTblStlSettleApplyById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500702, 0, 'TBLSTLSETTLEAPPLY_SAVE', '/tblStlSettleApplySave.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager.saveSecurityTblStlSettleApply');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500703, 0, 'TBLSTLSETTLEAPPLY_DEL', '/tblStlSettleApplyRemove.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleApplyManager.removeSecurityTblStlSettleApplyById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(500704, 0, 'TBLSTLSETTLEAPPLY_LOOKUP', '/tblStlSettleApplyLookup.action');
--
delete from HI_PrivilegeResource where ID = 500900;
--
delete from HI_PrivilegeResource where ID = 500901;
--
delete from HI_PrivilegeResource where ID = 500902;
--
delete from HI_PrivilegeResource where ID = 500903;
--
delete from HI_PrivilegeResource where ID = 500904;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(500900, 0, 'TBLSTLSETTLEBATCH_LIST', '/tblStlSettleBatchList.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.getSecurityTblStlSettleBatchList', 'TBLSTLSETTLEBATCH_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500901, 0, 'TBLSTLSETTLEBATCH_VIEW', '/tblStlSettleBatchView.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.getSecurityTblStlSettleBatchById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500902, 0, 'TBLSTLSETTLEBATCH_SAVE', '/tblStlSettleBatchSave.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.saveSecurityTblStlSettleBatch');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(500903, 0, 'TBLSTLSETTLEBATCH_DEL', '/tblStlSettleBatchRemove.action', 'cn.net.iccard.bm.settleservice.service.TblStlSettleBatchManager.removeSecurityTblStlSettleBatchById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(500904, 0, 'TBLSTLSETTLEBATCH_LOOKUP', '/tblStlSettleBatchLookup.action');
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
delete from Enumeration where ID = 500800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500800, 0, 'settleApplyStatus', '结算申请状态', '结算申请状态', 0, 0);
--
delete from Enumeration where ID = 501000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(501000, 0, 'settleBatchStatus', '结算批次状态', '结算批次状态', 0, 0);
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
delete from EnumerationValue where ID = 500800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500800, 0, 'checking', '审核中', '审核中', '', 500800, 0);
--
delete from EnumerationValue where ID = 500801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500801, 0, 'checkPass', '审核通过', '审核通过', '', 500800, 0);
--
delete from EnumerationValue where ID = 500802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500802, 0, 'checkFail', '审核不通过', '审核不通过', '', 500800, 0);
--
delete from EnumerationValue where ID = 500803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500803, 0, 'settling', '结算中', '结算中', '', 500800, 0);
--
delete from EnumerationValue where ID = 500804;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500804, 0, 'settled', '已结算', '已结算', '', 500800, 0);
--
delete from EnumerationValue where ID = 500805;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500805, 0, 'settleFail', '结算失败', '结算失败', '', 500800, 0);
--
delete from EnumerationValue where ID = 501000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(501000, 0, 'toSettle', '待结算', '待结算', '', 501000, 0);
--
delete from EnumerationValue where ID = 501001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(501001, 0, 'settled', '已结算', '已结算', '', 501000, 0);
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
--
delete from HI_Language where ID = 500700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500700, 0, '结算申请', 1, 0);
--
delete from HI_Language where ID = 500701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500701, 0, '商户号', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500702, 0, '商户名称', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500703, 0, '账户可用余额', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500704, 0, '申请结算金额', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500705, 0, '状态', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500706, 0, '备注', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500707, 0, '结算日', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500708, 0, '结算批次号', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500800, 0, '结算申请状态', 1, 0);
--
delete from HI_Language where ID = 500801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500801, 0, '审核中', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500802, 0, '审核通过', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500803, 0, '审核不通过', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500804, 0, '结算中', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500805, 0, '已结算', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500806;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500806, 0, '结算失败', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500900, 0, '结算批次', 1, 0);
--
delete from HI_Language where ID = 500901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500901, 0, '结算批次号', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500902, 0, '结算日', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500903;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500903, 0, '总条数', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500904;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500904, 0, '总金额', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500905;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500905, 0, '状态', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 501000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(501000, 0, '结算批次状态', 1, 0);
--
delete from HI_Language where ID = 501001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(501001, 0, '待结算', 'settleBatchStatus', 1, 0);
--
delete from HI_Language where ID = 501002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(501002, 0, '已结算', 'settleBatchStatus', 1, 0);
