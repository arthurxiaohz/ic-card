
delete from HiMenu where ID = 100000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(100000, 0, 'memberservice', '会员服务', '会员服务', 0, 9999, 0);
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
delete from MenuLink where ID = 101200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101200, 0, '/tblMbPointExchangeRuleList.action', '会员积分兑换规则', '会员积分兑换规则', 101200, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101300, 0, '/tblMbCouponList.action', '会员优惠券', '会员优惠券', 101300, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101600, 0, '/tblMbPointRuleList.action', '积分规则', '积分规则', 101600, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101700, 0, '/tblMbCouponRuleList.action', '会员优惠券规则', '会员优惠券规则', 101700, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101900;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101900, 0, '/tblMbPointList.action', '会员积分', '会员积分', 101900, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 102000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(102000, 0, '/tblMbPointDetailList.action', '会员积分明细', '会员积分明细', 102000, 9999, 100000, 0, 0);
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
delete from HI_Authority where ID = 101200;
--
delete from HI_Authority where ID = 101201;
--
delete from HI_Authority where ID = 101202;
--
delete from HI_Authority where ID = 101203;
--
delete from HI_Authority where ID = 101204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101200, 0, 'TBLMBPOINTEXCHANGERULE_LIST', 'memberservice.TblMbPointExchangeRuleList', '', '会员积分兑换规则查询', 1, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101201, 0, 'TBLMBPOINTEXCHANGERULE_VIEW', 'memberservice.TblMbPointExchangeRuleView', '', '会员积分兑换规则查看', 2, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101202, 0, 'TBLMBPOINTEXCHANGERULE_SAVE', 'memberservice.TblMbPointExchangeRuleSave', '', '会员积分兑换规则保存', 3, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101203, 0, 'TBLMBPOINTEXCHANGERULE_DEL', 'memberservice.TblMbPointExchangeRuleDel', '', '会员积分兑换规则删除', 4, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101204, 0, 'TBLMBPOINTEXCHANGERULE_LOOKUP', 'memberservice.TblMbPointExchangeRuleLookup', '', '会员积分兑换规则带回', 1, 101200);
--
delete from HI_Authority where ID = 101300;
--
delete from HI_Authority where ID = 101301;
--
delete from HI_Authority where ID = 101302;
--
delete from HI_Authority where ID = 101303;
--
delete from HI_Authority where ID = 101304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101300, 0, 'TBLMBCOUPON_LIST', 'memberservice.TblMbCouponList', '', '会员优惠券查询', 1, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101301, 0, 'TBLMBCOUPON_VIEW', 'memberservice.TblMbCouponView', '', '会员优惠券查看', 2, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101302, 0, 'TBLMBCOUPON_SAVE', 'memberservice.TblMbCouponSave', '', '会员优惠券保存', 3, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101303, 0, 'TBLMBCOUPON_DEL', 'memberservice.TblMbCouponDel', '', '会员优惠券删除', 4, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101304, 0, 'TBLMBCOUPON_LOOKUP', 'memberservice.TblMbCouponLookup', '', '会员优惠券带回', 1, 101300);
--
delete from HI_Authority where ID = 101600;
--
delete from HI_Authority where ID = 101601;
--
delete from HI_Authority where ID = 101602;
--
delete from HI_Authority where ID = 101603;
--
delete from HI_Authority where ID = 101604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101600, 0, 'TBLMBPOINTRULE_LIST', 'memberservice.TblMbPointRuleList', '', '积分规则查询', 1, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101601, 0, 'TBLMBPOINTRULE_VIEW', 'memberservice.TblMbPointRuleView', '', '积分规则查看', 2, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101602, 0, 'TBLMBPOINTRULE_SAVE', 'memberservice.TblMbPointRuleSave', '', '积分规则保存', 3, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101603, 0, 'TBLMBPOINTRULE_DEL', 'memberservice.TblMbPointRuleDel', '', '积分规则删除', 4, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101604, 0, 'TBLMBPOINTRULE_LOOKUP', 'memberservice.TblMbPointRuleLookup', '', '积分规则带回', 1, 101600);
--
delete from HI_Authority where ID = 101700;
--
delete from HI_Authority where ID = 101701;
--
delete from HI_Authority where ID = 101702;
--
delete from HI_Authority where ID = 101703;
--
delete from HI_Authority where ID = 101704;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101700, 0, 'TBLMBCOUPONRULE_LIST', 'memberservice.TblMbCouponRuleList', '', '会员优惠券规则查询', 1, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101701, 0, 'TBLMBCOUPONRULE_VIEW', 'memberservice.TblMbCouponRuleView', '', '会员优惠券规则查看', 2, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101702, 0, 'TBLMBCOUPONRULE_SAVE', 'memberservice.TblMbCouponRuleSave', '', '会员优惠券规则保存', 3, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101703, 0, 'TBLMBCOUPONRULE_DEL', 'memberservice.TblMbCouponRuleDel', '', '会员优惠券规则删除', 4, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101704, 0, 'TBLMBCOUPONRULE_LOOKUP', 'memberservice.TblMbCouponRuleLookup', '', '会员优惠券规则带回', 1, 101700);
--
delete from HI_Authority where ID = 101900;
--
delete from HI_Authority where ID = 101901;
--
delete from HI_Authority where ID = 101902;
--
delete from HI_Authority where ID = 101903;
--
delete from HI_Authority where ID = 101904;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101900, 0, 'TBLMBPOINT_LIST', 'memberservice.TblMbPointList', '', '会员积分查询', 1, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101901, 0, 'TBLMBPOINT_VIEW', 'memberservice.TblMbPointView', '', '会员积分查看', 2, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101902, 0, 'TBLMBPOINT_SAVE', 'memberservice.TblMbPointSave', '', '会员积分保存', 3, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101903, 0, 'TBLMBPOINT_DEL', 'memberservice.TblMbPointDel', '', '会员积分删除', 4, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101904, 0, 'TBLMBPOINT_LOOKUP', 'memberservice.TblMbPointLookup', '', '会员积分带回', 1, 101900);
--
delete from HI_Authority where ID = 102000;
--
delete from HI_Authority where ID = 102001;
--
delete from HI_Authority where ID = 102002;
--
delete from HI_Authority where ID = 102003;
--
delete from HI_Authority where ID = 102004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102000, 0, 'TBLMBPOINTDETAIL_LIST', 'memberservice.TblMbPointDetailList', '', '会员积分明细查询', 1, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102001, 0, 'TBLMBPOINTDETAIL_VIEW', 'memberservice.TblMbPointDetailView', '', '会员积分明细查看', 2, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102002, 0, 'TBLMBPOINTDETAIL_SAVE', 'memberservice.TblMbPointDetailSave', '', '会员积分明细保存', 3, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102003, 0, 'TBLMBPOINTDETAIL_DEL', 'memberservice.TblMbPointDetailDel', '', '会员积分明细删除', 4, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102004, 0, 'TBLMBPOINTDETAIL_LOOKUP', 'memberservice.TblMbPointDetailLookup', '', '会员积分明细带回', 1, 102000);
--
delete from HI_Authority where ID = 102200;
--
delete from HI_Authority where ID = 102201;
--
delete from HI_Authority where ID = 102202;
--
delete from HI_Authority where ID = 102203;
--
delete from HI_Authority where ID = 102204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102200, 0, 'TBLMBCOUPONDETAIL_LIST', 'memberservice.TblMbCouponDetailList', '', '会员优惠券明细查询', 1, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102201, 0, 'TBLMBCOUPONDETAIL_VIEW', 'memberservice.TblMbCouponDetailView', '', '会员优惠券明细查看', 2, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102202, 0, 'TBLMBCOUPONDETAIL_SAVE', 'memberservice.TblMbCouponDetailSave', '', '会员优惠券明细保存', 3, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102203, 0, 'TBLMBCOUPONDETAIL_DEL', 'memberservice.TblMbCouponDetailDel', '', '会员优惠券明细删除', 4, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102204, 0, 'TBLMBCOUPONDETAIL_LOOKUP', 'memberservice.TblMbCouponDetailLookup', '', '会员优惠券明细带回', 1, 102200);
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
delete from HI_PrivilegeResource where ID = 101200;
--
delete from HI_PrivilegeResource where ID = 101201;
--
delete from HI_PrivilegeResource where ID = 101202;
--
delete from HI_PrivilegeResource where ID = 101203;
--
delete from HI_PrivilegeResource where ID = 101204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101200, 0, 'TBLMBPOINTEXCHANGERULE_LIST', '/tblMbPointExchangeRuleList.action', 'cn.net.iccard.member.service.TblMbPointExchangeRuleManager.getSecurityTblMbPointExchangeRuleList', 'TBLMBPOINTEXCHANGERULE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101201, 0, 'TBLMBPOINTEXCHANGERULE_VIEW', '/tblMbPointExchangeRuleView.action', 'cn.net.iccard.member.service.TblMbPointExchangeRuleManager.getSecurityTblMbPointExchangeRuleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101202, 0, 'TBLMBPOINTEXCHANGERULE_SAVE', '/tblMbPointExchangeRuleSave.action', 'cn.net.iccard.member.service.TblMbPointExchangeRuleManager.saveSecurityTblMbPointExchangeRule');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101203, 0, 'TBLMBPOINTEXCHANGERULE_DEL', '/tblMbPointExchangeRuleRemove.action', 'cn.net.iccard.member.service.TblMbPointExchangeRuleManager.removeSecurityTblMbPointExchangeRuleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101204, 0, 'TBLMBPOINTEXCHANGERULE_LOOKUP', '/tblMbPointExchangeRuleLookup.action');
--
delete from HI_PrivilegeResource where ID = 101300;
--
delete from HI_PrivilegeResource where ID = 101301;
--
delete from HI_PrivilegeResource where ID = 101302;
--
delete from HI_PrivilegeResource where ID = 101303;
--
delete from HI_PrivilegeResource where ID = 101304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101300, 0, 'TBLMBCOUPON_LIST', '/tblMbCouponList.action', 'cn.net.iccard.member.service.TblMbCouponManager.getSecurityTblMbCouponList', 'TBLMBCOUPON_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101301, 0, 'TBLMBCOUPON_VIEW', '/tblMbCouponView.action', 'cn.net.iccard.member.service.TblMbCouponManager.getSecurityTblMbCouponById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101302, 0, 'TBLMBCOUPON_SAVE', '/tblMbCouponSave.action', 'cn.net.iccard.member.service.TblMbCouponManager.saveSecurityTblMbCoupon');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101303, 0, 'TBLMBCOUPON_DEL', '/tblMbCouponRemove.action', 'cn.net.iccard.member.service.TblMbCouponManager.removeSecurityTblMbCouponById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101304, 0, 'TBLMBCOUPON_LOOKUP', '/tblMbCouponLookup.action');
--
delete from HI_PrivilegeResource where ID = 101600;
--
delete from HI_PrivilegeResource where ID = 101601;
--
delete from HI_PrivilegeResource where ID = 101602;
--
delete from HI_PrivilegeResource where ID = 101603;
--
delete from HI_PrivilegeResource where ID = 101604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101600, 0, 'TBLMBPOINTRULE_LIST', '/tblMbPointRuleList.action', 'cn.net.iccard.member.service.TblMbPointRuleManager.getSecurityTblMbPointRuleList', 'TBLMBPOINTRULE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101601, 0, 'TBLMBPOINTRULE_VIEW', '/tblMbPointRuleView.action', 'cn.net.iccard.member.service.TblMbPointRuleManager.getSecurityTblMbPointRuleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101602, 0, 'TBLMBPOINTRULE_SAVE', '/tblMbPointRuleSave.action', 'cn.net.iccard.member.service.TblMbPointRuleManager.saveSecurityTblMbPointRule');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101603, 0, 'TBLMBPOINTRULE_DEL', '/tblMbPointRuleRemove.action', 'cn.net.iccard.member.service.TblMbPointRuleManager.removeSecurityTblMbPointRuleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101604, 0, 'TBLMBPOINTRULE_LOOKUP', '/tblMbPointRuleLookup.action');
--
delete from HI_PrivilegeResource where ID = 101700;
--
delete from HI_PrivilegeResource where ID = 101701;
--
delete from HI_PrivilegeResource where ID = 101702;
--
delete from HI_PrivilegeResource where ID = 101703;
--
delete from HI_PrivilegeResource where ID = 101704;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101700, 0, 'TBLMBCOUPONRULE_LIST', '/tblMbCouponRuleList.action', 'cn.net.iccard.member.service.TblMbCouponRuleManager.getSecurityTblMbCouponRuleList', 'TBLMBCOUPONRULE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101701, 0, 'TBLMBCOUPONRULE_VIEW', '/tblMbCouponRuleView.action', 'cn.net.iccard.member.service.TblMbCouponRuleManager.getSecurityTblMbCouponRuleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101702, 0, 'TBLMBCOUPONRULE_SAVE', '/tblMbCouponRuleSave.action', 'cn.net.iccard.member.service.TblMbCouponRuleManager.saveSecurityTblMbCouponRule');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101703, 0, 'TBLMBCOUPONRULE_DEL', '/tblMbCouponRuleRemove.action', 'cn.net.iccard.member.service.TblMbCouponRuleManager.removeSecurityTblMbCouponRuleById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101704, 0, 'TBLMBCOUPONRULE_LOOKUP', '/tblMbCouponRuleLookup.action');
--
delete from HI_PrivilegeResource where ID = 101900;
--
delete from HI_PrivilegeResource where ID = 101901;
--
delete from HI_PrivilegeResource where ID = 101902;
--
delete from HI_PrivilegeResource where ID = 101903;
--
delete from HI_PrivilegeResource where ID = 101904;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101900, 0, 'TBLMBPOINT_LIST', '/tblMbPointList.action', 'cn.net.iccard.member.service.TblMbPointManager.getSecurityTblMbPointList', 'TBLMBPOINT_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101901, 0, 'TBLMBPOINT_VIEW', '/tblMbPointView.action', 'cn.net.iccard.member.service.TblMbPointManager.getSecurityTblMbPointById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101902, 0, 'TBLMBPOINT_SAVE', '/tblMbPointSave.action', 'cn.net.iccard.member.service.TblMbPointManager.saveSecurityTblMbPoint');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101903, 0, 'TBLMBPOINT_DEL', '/tblMbPointRemove.action', 'cn.net.iccard.member.service.TblMbPointManager.removeSecurityTblMbPointById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101904, 0, 'TBLMBPOINT_LOOKUP', '/tblMbPointLookup.action');
--
delete from HI_PrivilegeResource where ID = 102000;
--
delete from HI_PrivilegeResource where ID = 102001;
--
delete from HI_PrivilegeResource where ID = 102002;
--
delete from HI_PrivilegeResource where ID = 102003;
--
delete from HI_PrivilegeResource where ID = 102004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(102000, 0, 'TBLMBPOINTDETAIL_LIST', '/tblMbPointDetailList.action', 'cn.net.iccard.member.service.TblMbPointDetailManager.getSecurityTblMbPointDetailList', 'TBLMBPOINTDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(102001, 0, 'TBLMBPOINTDETAIL_VIEW', '/tblMbPointDetailView.action', 'cn.net.iccard.member.service.TblMbPointDetailManager.getSecurityTblMbPointDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(102002, 0, 'TBLMBPOINTDETAIL_SAVE', '/tblMbPointDetailSave.action', 'cn.net.iccard.member.service.TblMbPointDetailManager.saveSecurityTblMbPointDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(102003, 0, 'TBLMBPOINTDETAIL_DEL', '/tblMbPointDetailRemove.action', 'cn.net.iccard.member.service.TblMbPointDetailManager.removeSecurityTblMbPointDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(102004, 0, 'TBLMBPOINTDETAIL_LOOKUP', '/tblMbPointDetailLookup.action');
--
delete from HI_PrivilegeResource where ID = 102200;
--
delete from HI_PrivilegeResource where ID = 102201;
--
delete from HI_PrivilegeResource where ID = 102202;
--
delete from HI_PrivilegeResource where ID = 102203;
--
delete from HI_PrivilegeResource where ID = 102204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(102200, 0, 'TBLMBCOUPONDETAIL_LIST', '/tblMbCouponDetailList.action', 'cn.net.iccard.member.service.TblMbCouponDetailManager.getSecurityTblMbCouponDetailList', 'TBLMBCOUPONDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(102201, 0, 'TBLMBCOUPONDETAIL_VIEW', '/tblMbCouponDetailView.action', 'cn.net.iccard.member.service.TblMbCouponDetailManager.getSecurityTblMbCouponDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(102202, 0, 'TBLMBCOUPONDETAIL_SAVE', '/tblMbCouponDetailSave.action', 'cn.net.iccard.member.service.TblMbCouponDetailManager.saveSecurityTblMbCouponDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(102203, 0, 'TBLMBCOUPONDETAIL_DEL', '/tblMbCouponDetailRemove.action', 'cn.net.iccard.member.service.TblMbCouponDetailManager.removeSecurityTblMbCouponDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(102204, 0, 'TBLMBCOUPONDETAIL_LOOKUP', '/tblMbCouponDetailLookup.action');
--



delete from Enumeration where ID = 101400;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101400, 0, 'couponType', '优惠券类型', '优惠券类型', 0, 0);
--
delete from Enumeration where ID = 101500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101500, 0, 'pointRuleType', '积分规则类型', '积分规则类型', 0, 0);
--
delete from Enumeration where ID = 101800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101800, 0, 'couponStatus', '优惠券状态', '优惠券状态', 0, 0);
--
delete from Enumeration where ID = 102300;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102300, 0, 'merchandiseCategory', '商品类别', '商品类别', 0, 0);
--
delete from Enumeration where ID = 102400;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102400, 0, 'pointTxType', '积分交易类型', '积分交易类型', 0, 0);
--
delete from Enumeration where ID = 102500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102500, 0, 'rechargeTxStatus', '是否已计算手续费', '是否已计算手续费', 0, 0);
--
delete from Enumeration where ID = 102600;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102600, 0, 'rechargeSettleStatus', '充值结算状态', '充值结算状态', 0, 0);
--
delete from Enumeration where ID = 102700;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102700, 0, 'bankTxStatus', '银行交易状态', '银行交易状态', 0, 0);
--
delete from Enumeration where ID = 102800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102800, 0, 'checkStatus', '对账状态', '对账状态', 0, 0);
--



delete from EnumerationValue where ID = 101400;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101400, 0, 'platform', '平台优惠券', '平台优惠券', '', 101400, 0);
--
delete from EnumerationValue where ID = 101500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101500, 0, 'byRate', '按比率', '按比率', '', 101500, 0);
--
delete from EnumerationValue where ID = 101501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101501, 0, 'byTrans', '固定积分', '固定积分', '', 101500, 0);
--
delete from EnumerationValue where ID = 101800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101800, 0, 'notDraw', '未领取', '未领取', '', 101800, 0);
--
delete from EnumerationValue where ID = 101801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101801, 0, 'valid', '有效', '有效', '', 101800, 0);
--
delete from EnumerationValue where ID = 101802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101802, 0, 'used', '已使用', '已使用', '', 101800, 0);
--
delete from EnumerationValue where ID = 101803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101803, 0, 'expired', '过期', '过期', '', 101800, 0);
--
delete from EnumerationValue where ID = 102300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102300, 0, 'common', '一般', '一般', '', 102300, 0);
--
delete from EnumerationValue where ID = 102400;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102400, 0, 'txPoint', '交易积分', '交易积分', '', 102400, 0);
--
delete from EnumerationValue where ID = 102401;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102401, 0, 'pointExchange', '积分兑换', '积分兑换', '', 102400, 0);
--
delete from EnumerationValue where ID = 102402;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102402, 0, 'refundPoint', '退款回退积分', '退款回退积分', '', 102400, 0);
--
delete from EnumerationValue where ID = 102500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102500, 0, 'payprocess', '支付中', '支付中', '1', 102500, 0);
--
delete from EnumerationValue where ID = 102501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102501, 0, 'paysuccess', '支付成功', '支付成功', '2', 102500, 0);
--
delete from EnumerationValue where ID = 102502;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102502, 0, 'payfail', '支付失败', '支付失败', '9', 102500, 0);
--
delete from EnumerationValue where ID = 102600;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102600, 0, 'unsettle', '未结算', '未结算', '0', 102600, 0);
--
delete from EnumerationValue where ID = 102601;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102601, 0, 'settle', '已结算', '已结算', '1', 102600, 0);
--
delete from EnumerationValue where ID = 102700;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102700, 0, 'success', '成功', '成功', '1', 102700, 0);
--
delete from EnumerationValue where ID = 102701;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102701, 0, 'settle', '失败', '失败', '2', 102700, 0);
--
delete from EnumerationValue where ID = 102702;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102702, 0, 'cancel', '已撤单', '已撤单', '3', 102700, 0);
--
delete from EnumerationValue where ID = 102800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102800, 0, 'uncheck', '未对账', '未对账', '0', 102800, 0);
--
delete from EnumerationValue where ID = 102801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102801, 0, 'checksuccess', '对账平', '对账平', '1', 102800, 0);
--
delete from EnumerationValue where ID = 102802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102802, 0, 'checklong', '长款', '长款', '2', 102800, 0);
--
delete from EnumerationValue where ID = 102803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102803, 0, 'checkshort', '短款', '短款', '3', 102800, 0);
--

--
delete from HI_Language where ID = 100100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100100, 0, '会员信息', 1, 0);
--
delete from HI_Language where ID = 100101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100101, 0, '账号', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100102, 0, '证件类型', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100103, 0, '卡号', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100104, 0, '实名认证状态', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100105, 0, '实名认证时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100106, 0, '注册时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100107, 0, '注册方式', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100108, 0, '创建时间', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100109, 0, '最后修改时间', 'TblMbInfo', 1, 0);
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
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100302, 0, '账号', 'TblMbRechargeOrder', 1, 0);
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
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100401, 0, '交易代码', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100402, 0, '商户号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100403, 0, '交易金额', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100404, 0, '交易时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100405, 0, '交易状态', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100406, 0, '附加信息', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100407, 0, '创建时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100408, 0, '最后修改时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100409, 0, '最后修改人', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100410, 0, '持卡人卡号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100411, 0, '持卡人个人信息', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100412, 0, '平台流水号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100413, 0, '币种', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100414, 0, '账户类型', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100415;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100415, 0, '账户号码', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100416;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100416, 0, '交易完成时间', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100417;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100417, 0, ' 网关订单号', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 101100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101100, 0, '网关交易结果', 1, 0);
--
delete from HI_Language where ID = 101101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101101, 0, '对应的系统订单号', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101102, 0, '交易系统的机构号', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101103, 0, '交易系统的交易流水号', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101104, 0, '交易金额', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101105, 0, '报文的原始报文', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101106, 0, '返回报文标识订单的成功状态', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101107, 0, '发送报文的IP地址', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101108, 0, '最后修改时间', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101109, 0, '最后修改人', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101110, 0, '创建时间', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101200, 0, '会员积分兑换规则', 1, 0);
--
delete from HI_Language where ID = 101201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101201, 0, '积分', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101202, 0, '金额', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101203, 0, '有效期开始日期', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101204, 0, '有效期结束日期', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101205, 0, '创建时间', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101206, 0, '最后修改时间', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101207, 0, '最后修改人', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101300, 0, '会员优惠券', 1, 0);
--
delete from HI_Language where ID = 101301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101301, 0, '优惠券类型', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101302, 0, '优惠券金额', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101303, 0, '优惠券可用余额', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101304, 0, '优惠券状态', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101305, 0, '有效期开始时间', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101306, 0, '有效期结束时间', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101307;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101307, 0, '创建时间', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101308;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101308, 0, '最后修改时间', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101309;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101309, 0, '帐号', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101310;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101310, 0, '姓名', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101400, 0, '优惠券类型', 1, 0);
--
delete from HI_Language where ID = 101401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101401, 0, '平台优惠券', 'couponType', 1, 0);
--
delete from HI_Language where ID = 101500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101500, 0, '积分规则类型', 1, 0);
--
delete from HI_Language where ID = 101501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101501, 0, '按比率', 'pointRuleType', 1, 0);
--
delete from HI_Language where ID = 101502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101502, 0, '固定积分', 'pointRuleType', 1, 0);
--
delete from HI_Language where ID = 101600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101600, 0, '积分规则', 1, 0);
--
delete from HI_Language where ID = 101601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101601, 0, '帐号', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101602, 0, '姓名', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101603, 0, '商户号', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101604, 0, '商户名称', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101605, 0, '商户类别', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101606, 0, '有效期开始时间', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101607, 0, '有效期结束时间', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101608;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101608, 0, '起始金额', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101609;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101609, 0, '截止金额', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101610;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101610, 0, '积分规则类型', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101611;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101611, 0, '参数值', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101612;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101612, 0, '创建时间', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101613;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101613, 0, '最后修改时间', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101614;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101614, 0, '最后修改人', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101700, 0, '会员优惠券规则', 1, 0);
--
delete from HI_Language where ID = 101701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101701, 0, '帐号', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101702, 0, '姓名', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101703, 0, '商户号', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101704, 0, '商户名称', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101705, 0, '商户类别', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101706, 0, '商品类别', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101707, 0, '商品编号', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101708, 0, '优惠券类型', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101709;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101709, 0, '优惠券金额', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101710;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101710, 0, '有效期开始时间', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101711;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101711, 0, '有效期结束时间', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101712;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101712, 0, '创建时间', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101713;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101713, 0, '最后修改时间', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101800, 0, '优惠券状态', 1, 0);
--
delete from HI_Language where ID = 101801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101801, 0, '未领取', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101802, 0, '有效', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101803, 0, '已使用', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101804, 0, '过期', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101900, 0, '会员积分', 1, 0);
--
delete from HI_Language where ID = 101901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101901, 0, '帐号', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101902, 0, '姓名', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101903;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101903, 0, '积分余额', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101904;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101904, 0, '创建时间', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101905;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101905, 0, '最后修改时间', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 102000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102000, 0, '会员积分明细', 1, 0);
--
delete from HI_Language where ID = 102001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102001, 0, '积分', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102002, 0, '积分交易类型', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102003, 0, '积分变动凭证', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102004, 0, '积分余额', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102005;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102005, 0, '创建时间', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102006;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102006, 0, '最后修改时间', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102007;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102007, 0, '帐号', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102008;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102008, 0, '姓名', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102200, 0, '会员优惠券明细', 1, 0);
--
delete from HI_Language where ID = 102201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102201, 0, '优惠券使用金额', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102202, 0, '平台交易流水号', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102203, 0, '优惠券可用余额', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102204, 0, '创建时间', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102205, 0, '最后修改时间', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102300, 0, '商品类别', 1, 0);
--
delete from HI_Language where ID = 102301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102301, 0, '一般', 'merchandiseCategory', 1, 0);
--
delete from HI_Language where ID = 102400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102400, 0, '积分交易类型', 1, 0);
--
delete from HI_Language where ID = 102401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102401, 0, '交易积分', 'pointTxType', 1, 0);
--
delete from HI_Language where ID = 102402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102402, 0, '积分兑换', 'pointTxType', 1, 0);
--
delete from HI_Language where ID = 102403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102403, 0, '退款回退积分', 'pointTxType', 1, 0);
--
delete from HI_Language where ID = 102500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102500, 0, '是否已计算手续费', 1, 0);
--
delete from HI_Language where ID = 102501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102501, 0, '支付中', 'rechargeTxStatus', 1, 0);
--
delete from HI_Language where ID = 102502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102502, 0, '支付成功', 'rechargeTxStatus', 1, 0);
--
delete from HI_Language where ID = 102503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102503, 0, '支付失败', 'rechargeTxStatus', 1, 0);
--
delete from HI_Language where ID = 102600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102600, 0, '充值结算状态', 1, 0);
--
delete from HI_Language where ID = 102601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102601, 0, '未结算', 'rechargeSettleStatus', 1, 0);
--
delete from HI_Language where ID = 102602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102602, 0, '已结算', 'rechargeSettleStatus', 1, 0);
--
delete from HI_Language where ID = 102700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102700, 0, '银行交易状态', 1, 0);
--
delete from HI_Language where ID = 102701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102701, 0, '成功', 'bankTxStatus', 1, 0);
--
delete from HI_Language where ID = 102702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102702, 0, '失败', 'bankTxStatus', 1, 0);
--
delete from HI_Language where ID = 102703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102703, 0, '已撤单', 'bankTxStatus', 1, 0);
--
delete from HI_Language where ID = 102800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102800, 0, '对账状态', 1, 0);
--
delete from HI_Language where ID = 102801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102801, 0, '未对账', 'checkStatus', 1, 0);
--
delete from HI_Language where ID = 102802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102802, 0, '对账平', 'checkStatus', 1, 0);
--
delete from HI_Language where ID = 102803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102803, 0, '长款', 'checkStatus', 1, 0);
--
delete from HI_Language where ID = 102804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102804, 0, '短款', 'checkStatus', 1, 0);
