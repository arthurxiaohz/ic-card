
delete from HiMenu where ID = 100000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(100000, 0, 'memberservice', '��Ա����', '��Ա����', 0, 9999, 0);
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
delete from MenuLink where ID = 101200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101200, 0, '/tblMbPointExchangeRuleList.action', '��Ա���ֶһ�����', '��Ա���ֶһ�����', 101200, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101300, 0, '/tblMbCouponList.action', '��Ա�Ż�ȯ', '��Ա�Ż�ȯ', 101300, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101600, 0, '/tblMbPointRuleList.action', '���ֹ���', '���ֹ���', 101600, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101700, 0, '/tblMbCouponRuleList.action', '��Ա�Ż�ȯ����', '��Ա�Ż�ȯ����', 101700, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 101900;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101900, 0, '/tblMbPointList.action', '��Ա����', '��Ա����', 101900, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 102000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(102000, 0, '/tblMbPointDetailList.action', '��Ա������ϸ', '��Ա������ϸ', 102000, 9999, 100000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101200, 0, 'TBLMBPOINTEXCHANGERULE_LIST', 'memberservice.TblMbPointExchangeRuleList', '', '��Ա���ֶһ������ѯ', 1, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101201, 0, 'TBLMBPOINTEXCHANGERULE_VIEW', 'memberservice.TblMbPointExchangeRuleView', '', '��Ա���ֶһ�����鿴', 2, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101202, 0, 'TBLMBPOINTEXCHANGERULE_SAVE', 'memberservice.TblMbPointExchangeRuleSave', '', '��Ա���ֶһ����򱣴�', 3, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101203, 0, 'TBLMBPOINTEXCHANGERULE_DEL', 'memberservice.TblMbPointExchangeRuleDel', '', '��Ա���ֶһ�����ɾ��', 4, 101200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101204, 0, 'TBLMBPOINTEXCHANGERULE_LOOKUP', 'memberservice.TblMbPointExchangeRuleLookup', '', '��Ա���ֶһ��������', 1, 101200);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101300, 0, 'TBLMBCOUPON_LIST', 'memberservice.TblMbCouponList', '', '��Ա�Ż�ȯ��ѯ', 1, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101301, 0, 'TBLMBCOUPON_VIEW', 'memberservice.TblMbCouponView', '', '��Ա�Ż�ȯ�鿴', 2, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101302, 0, 'TBLMBCOUPON_SAVE', 'memberservice.TblMbCouponSave', '', '��Ա�Ż�ȯ����', 3, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101303, 0, 'TBLMBCOUPON_DEL', 'memberservice.TblMbCouponDel', '', '��Ա�Ż�ȯɾ��', 4, 101300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101304, 0, 'TBLMBCOUPON_LOOKUP', 'memberservice.TblMbCouponLookup', '', '��Ա�Ż�ȯ����', 1, 101300);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101600, 0, 'TBLMBPOINTRULE_LIST', 'memberservice.TblMbPointRuleList', '', '���ֹ����ѯ', 1, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101601, 0, 'TBLMBPOINTRULE_VIEW', 'memberservice.TblMbPointRuleView', '', '���ֹ���鿴', 2, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101602, 0, 'TBLMBPOINTRULE_SAVE', 'memberservice.TblMbPointRuleSave', '', '���ֹ��򱣴�', 3, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101603, 0, 'TBLMBPOINTRULE_DEL', 'memberservice.TblMbPointRuleDel', '', '���ֹ���ɾ��', 4, 101600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101604, 0, 'TBLMBPOINTRULE_LOOKUP', 'memberservice.TblMbPointRuleLookup', '', '���ֹ������', 1, 101600);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101700, 0, 'TBLMBCOUPONRULE_LIST', 'memberservice.TblMbCouponRuleList', '', '��Ա�Ż�ȯ�����ѯ', 1, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101701, 0, 'TBLMBCOUPONRULE_VIEW', 'memberservice.TblMbCouponRuleView', '', '��Ա�Ż�ȯ����鿴', 2, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101702, 0, 'TBLMBCOUPONRULE_SAVE', 'memberservice.TblMbCouponRuleSave', '', '��Ա�Ż�ȯ���򱣴�', 3, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101703, 0, 'TBLMBCOUPONRULE_DEL', 'memberservice.TblMbCouponRuleDel', '', '��Ա�Ż�ȯ����ɾ��', 4, 101700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101704, 0, 'TBLMBCOUPONRULE_LOOKUP', 'memberservice.TblMbCouponRuleLookup', '', '��Ա�Ż�ȯ�������', 1, 101700);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101900, 0, 'TBLMBPOINT_LIST', 'memberservice.TblMbPointList', '', '��Ա���ֲ�ѯ', 1, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101901, 0, 'TBLMBPOINT_VIEW', 'memberservice.TblMbPointView', '', '��Ա���ֲ鿴', 2, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101902, 0, 'TBLMBPOINT_SAVE', 'memberservice.TblMbPointSave', '', '��Ա���ֱ���', 3, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101903, 0, 'TBLMBPOINT_DEL', 'memberservice.TblMbPointDel', '', '��Ա����ɾ��', 4, 101900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101904, 0, 'TBLMBPOINT_LOOKUP', 'memberservice.TblMbPointLookup', '', '��Ա���ִ���', 1, 101900);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102000, 0, 'TBLMBPOINTDETAIL_LIST', 'memberservice.TblMbPointDetailList', '', '��Ա������ϸ��ѯ', 1, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102001, 0, 'TBLMBPOINTDETAIL_VIEW', 'memberservice.TblMbPointDetailView', '', '��Ա������ϸ�鿴', 2, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102002, 0, 'TBLMBPOINTDETAIL_SAVE', 'memberservice.TblMbPointDetailSave', '', '��Ա������ϸ����', 3, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102003, 0, 'TBLMBPOINTDETAIL_DEL', 'memberservice.TblMbPointDetailDel', '', '��Ա������ϸɾ��', 4, 102000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102004, 0, 'TBLMBPOINTDETAIL_LOOKUP', 'memberservice.TblMbPointDetailLookup', '', '��Ա������ϸ����', 1, 102000);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102200, 0, 'TBLMBCOUPONDETAIL_LIST', 'memberservice.TblMbCouponDetailList', '', '��Ա�Ż�ȯ��ϸ��ѯ', 1, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102201, 0, 'TBLMBCOUPONDETAIL_VIEW', 'memberservice.TblMbCouponDetailView', '', '��Ա�Ż�ȯ��ϸ�鿴', 2, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102202, 0, 'TBLMBCOUPONDETAIL_SAVE', 'memberservice.TblMbCouponDetailSave', '', '��Ա�Ż�ȯ��ϸ����', 3, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102203, 0, 'TBLMBCOUPONDETAIL_DEL', 'memberservice.TblMbCouponDetailDel', '', '��Ա�Ż�ȯ��ϸɾ��', 4, 102200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(102204, 0, 'TBLMBCOUPONDETAIL_LOOKUP', 'memberservice.TblMbCouponDetailLookup', '', '��Ա�Ż�ȯ��ϸ����', 1, 102200);
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
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101400, 0, 'couponType', '�Ż�ȯ����', '�Ż�ȯ����', 0, 0);
--
delete from Enumeration where ID = 101500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101500, 0, 'pointRuleType', '���ֹ�������', '���ֹ�������', 0, 0);
--
delete from Enumeration where ID = 101800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(101800, 0, 'couponStatus', '�Ż�ȯ״̬', '�Ż�ȯ״̬', 0, 0);
--
delete from Enumeration where ID = 102300;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102300, 0, 'merchandiseCategory', '��Ʒ���', '��Ʒ���', 0, 0);
--
delete from Enumeration where ID = 102400;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102400, 0, 'pointTxType', '���ֽ�������', '���ֽ�������', 0, 0);
--
delete from Enumeration where ID = 102500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102500, 0, 'rechargeTxStatus', '�Ƿ��Ѽ���������', '�Ƿ��Ѽ���������', 0, 0);
--
delete from Enumeration where ID = 102600;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102600, 0, 'rechargeSettleStatus', '��ֵ����״̬', '��ֵ����״̬', 0, 0);
--
delete from Enumeration where ID = 102700;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102700, 0, 'bankTxStatus', '���н���״̬', '���н���״̬', 0, 0);
--
delete from Enumeration where ID = 102800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(102800, 0, 'checkStatus', '����״̬', '����״̬', 0, 0);
--



delete from EnumerationValue where ID = 101400;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101400, 0, 'platform', 'ƽ̨�Ż�ȯ', 'ƽ̨�Ż�ȯ', '', 101400, 0);
--
delete from EnumerationValue where ID = 101500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101500, 0, 'byRate', '������', '������', '', 101500, 0);
--
delete from EnumerationValue where ID = 101501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101501, 0, 'byTrans', '�̶�����', '�̶�����', '', 101500, 0);
--
delete from EnumerationValue where ID = 101800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101800, 0, 'notDraw', 'δ��ȡ', 'δ��ȡ', '', 101800, 0);
--
delete from EnumerationValue where ID = 101801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101801, 0, 'valid', '��Ч', '��Ч', '', 101800, 0);
--
delete from EnumerationValue where ID = 101802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101802, 0, 'used', '��ʹ��', '��ʹ��', '', 101800, 0);
--
delete from EnumerationValue where ID = 101803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(101803, 0, 'expired', '����', '����', '', 101800, 0);
--
delete from EnumerationValue where ID = 102300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102300, 0, 'common', 'һ��', 'һ��', '', 102300, 0);
--
delete from EnumerationValue where ID = 102400;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102400, 0, 'txPoint', '���׻���', '���׻���', '', 102400, 0);
--
delete from EnumerationValue where ID = 102401;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102401, 0, 'pointExchange', '���ֶһ�', '���ֶһ�', '', 102400, 0);
--
delete from EnumerationValue where ID = 102402;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102402, 0, 'refundPoint', '�˿���˻���', '�˿���˻���', '', 102400, 0);
--
delete from EnumerationValue where ID = 102500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102500, 0, 'payprocess', '֧����', '֧����', '1', 102500, 0);
--
delete from EnumerationValue where ID = 102501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102501, 0, 'paysuccess', '֧���ɹ�', '֧���ɹ�', '2', 102500, 0);
--
delete from EnumerationValue where ID = 102502;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102502, 0, 'payfail', '֧��ʧ��', '֧��ʧ��', '9', 102500, 0);
--
delete from EnumerationValue where ID = 102600;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102600, 0, 'unsettle', 'δ����', 'δ����', '0', 102600, 0);
--
delete from EnumerationValue where ID = 102601;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102601, 0, 'settle', '�ѽ���', '�ѽ���', '1', 102600, 0);
--
delete from EnumerationValue where ID = 102700;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102700, 0, 'success', '�ɹ�', '�ɹ�', '1', 102700, 0);
--
delete from EnumerationValue where ID = 102701;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102701, 0, 'settle', 'ʧ��', 'ʧ��', '2', 102700, 0);
--
delete from EnumerationValue where ID = 102702;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102702, 0, 'cancel', '�ѳ���', '�ѳ���', '3', 102700, 0);
--
delete from EnumerationValue where ID = 102800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102800, 0, 'uncheck', 'δ����', 'δ����', '0', 102800, 0);
--
delete from EnumerationValue where ID = 102801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102801, 0, 'checksuccess', '����ƽ', '����ƽ', '1', 102800, 0);
--
delete from EnumerationValue where ID = 102802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102802, 0, 'checklong', '����', '����', '2', 102800, 0);
--
delete from EnumerationValue where ID = 102803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(102803, 0, 'checkshort', '�̿�', '�̿�', '3', 102800, 0);
--

--
delete from HI_Language where ID = 100100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100100, 0, '��Ա��Ϣ', 1, 0);
--
delete from HI_Language where ID = 100101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100101, 0, '�˺�', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100102, 0, '֤������', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100103, 0, '����', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100104, 0, 'ʵ����֤״̬', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100105, 0, 'ʵ����֤ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100106, 0, 'ע��ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100107, 0, 'ע�᷽ʽ', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100108, 0, '����ʱ��', 'TblMbInfo', 1, 0);
--
delete from HI_Language where ID = 100109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100109, 0, '����޸�ʱ��', 'TblMbInfo', 1, 0);
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
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100302, 0, '�˺�', 'TblMbRechargeOrder', 1, 0);
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
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100401, 0, '���״���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100402, 0, '�̻���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100403, 0, '���׽��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100404, 0, '����ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100405, 0, '����״̬', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100406, 0, '������Ϣ', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100407, 0, '����ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100408, 0, '����޸�ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100409, 0, '����޸���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100410, 0, '�ֿ��˿���', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100411, 0, '�ֿ��˸�����Ϣ', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100412, 0, 'ƽ̨��ˮ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100413, 0, '����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100414, 0, '�˻�����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100415;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100415, 0, '�˻�����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100416;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100416, 0, '�������ʱ��', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 100417;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100417, 0, ' ���ض�����', 'TblMbTransactionRequest', 1, 0);
--
delete from HI_Language where ID = 101100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101100, 0, '���ؽ��׽��', 1, 0);
--
delete from HI_Language where ID = 101101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101101, 0, '��Ӧ��ϵͳ������', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101102, 0, '����ϵͳ�Ļ�����', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101103, 0, '����ϵͳ�Ľ�����ˮ��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101104, 0, '���׽��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101105, 0, '���ĵ�ԭʼ����', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101106, 0, '���ر��ı�ʶ�����ĳɹ�״̬', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101107, 0, '���ͱ��ĵ�IP��ַ', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101108, 0, '����޸�ʱ��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101109, 0, '����޸���', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101110, 0, '����ʱ��', 'TblMbTransactionResponse', 1, 0);
--
delete from HI_Language where ID = 101200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101200, 0, '��Ա���ֶһ�����', 1, 0);
--
delete from HI_Language where ID = 101201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101201, 0, '����', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101202, 0, '���', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101203, 0, '��Ч�ڿ�ʼ����', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101204, 0, '��Ч�ڽ�������', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101205, 0, '����ʱ��', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101206, 0, '����޸�ʱ��', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101207, 0, '����޸���', 'TblMbPointExchangeRule', 1, 0);
--
delete from HI_Language where ID = 101300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101300, 0, '��Ա�Ż�ȯ', 1, 0);
--
delete from HI_Language where ID = 101301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101301, 0, '�Ż�ȯ����', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101302, 0, '�Ż�ȯ���', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101303, 0, '�Ż�ȯ�������', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101304, 0, '�Ż�ȯ״̬', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101305, 0, '��Ч�ڿ�ʼʱ��', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101306, 0, '��Ч�ڽ���ʱ��', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101307;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101307, 0, '����ʱ��', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101308;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101308, 0, '����޸�ʱ��', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101309;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101309, 0, '�ʺ�', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101310;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101310, 0, '����', 'TblMbCoupon', 1, 0);
--
delete from HI_Language where ID = 101400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101400, 0, '�Ż�ȯ����', 1, 0);
--
delete from HI_Language where ID = 101401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101401, 0, 'ƽ̨�Ż�ȯ', 'couponType', 1, 0);
--
delete from HI_Language where ID = 101500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101500, 0, '���ֹ�������', 1, 0);
--
delete from HI_Language where ID = 101501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101501, 0, '������', 'pointRuleType', 1, 0);
--
delete from HI_Language where ID = 101502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101502, 0, '�̶�����', 'pointRuleType', 1, 0);
--
delete from HI_Language where ID = 101600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101600, 0, '���ֹ���', 1, 0);
--
delete from HI_Language where ID = 101601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101601, 0, '�ʺ�', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101602, 0, '����', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101603, 0, '�̻���', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101604, 0, '�̻�����', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101605, 0, '�̻����', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101606, 0, '��Ч�ڿ�ʼʱ��', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101607, 0, '��Ч�ڽ���ʱ��', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101608;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101608, 0, '��ʼ���', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101609;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101609, 0, '��ֹ���', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101610;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101610, 0, '���ֹ�������', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101611;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101611, 0, '����ֵ', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101612;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101612, 0, '����ʱ��', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101613;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101613, 0, '����޸�ʱ��', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101614;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101614, 0, '����޸���', 'TblMbPointRule', 1, 0);
--
delete from HI_Language where ID = 101700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101700, 0, '��Ա�Ż�ȯ����', 1, 0);
--
delete from HI_Language where ID = 101701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101701, 0, '�ʺ�', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101702, 0, '����', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101703, 0, '�̻���', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101704, 0, '�̻�����', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101705, 0, '�̻����', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101706, 0, '��Ʒ���', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101707, 0, '��Ʒ���', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101708, 0, '�Ż�ȯ����', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101709;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101709, 0, '�Ż�ȯ���', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101710;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101710, 0, '��Ч�ڿ�ʼʱ��', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101711;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101711, 0, '��Ч�ڽ���ʱ��', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101712;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101712, 0, '����ʱ��', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101713;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101713, 0, '����޸�ʱ��', 'TblMbCouponRule', 1, 0);
--
delete from HI_Language where ID = 101800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101800, 0, '�Ż�ȯ״̬', 1, 0);
--
delete from HI_Language where ID = 101801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101801, 0, 'δ��ȡ', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101802, 0, '��Ч', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101803, 0, '��ʹ��', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101804, 0, '����', 'couponStatus', 1, 0);
--
delete from HI_Language where ID = 101900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101900, 0, '��Ա����', 1, 0);
--
delete from HI_Language where ID = 101901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101901, 0, '�ʺ�', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101902, 0, '����', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101903;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101903, 0, '�������', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101904;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101904, 0, '����ʱ��', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 101905;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101905, 0, '����޸�ʱ��', 'TblMbPoint', 1, 0);
--
delete from HI_Language where ID = 102000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102000, 0, '��Ա������ϸ', 1, 0);
--
delete from HI_Language where ID = 102001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102001, 0, '����', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102002, 0, '���ֽ�������', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102003, 0, '���ֱ䶯ƾ֤', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102004, 0, '�������', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102005;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102005, 0, '����ʱ��', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102006;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102006, 0, '����޸�ʱ��', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102007;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102007, 0, '�ʺ�', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102008;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102008, 0, '����', 'TblMbPointDetail', 1, 0);
--
delete from HI_Language where ID = 102200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102200, 0, '��Ա�Ż�ȯ��ϸ', 1, 0);
--
delete from HI_Language where ID = 102201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102201, 0, '�Ż�ȯʹ�ý��', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102202, 0, 'ƽ̨������ˮ��', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102203, 0, '�Ż�ȯ�������', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102204, 0, '����ʱ��', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102205, 0, '����޸�ʱ��', 'TblMbCouponDetail', 1, 0);
--
delete from HI_Language where ID = 102300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102300, 0, '��Ʒ���', 1, 0);
--
delete from HI_Language where ID = 102301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102301, 0, 'һ��', 'merchandiseCategory', 1, 0);
--
delete from HI_Language where ID = 102400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102400, 0, '���ֽ�������', 1, 0);
--
delete from HI_Language where ID = 102401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102401, 0, '���׻���', 'pointTxType', 1, 0);
--
delete from HI_Language where ID = 102402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102402, 0, '���ֶһ�', 'pointTxType', 1, 0);
--
delete from HI_Language where ID = 102403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102403, 0, '�˿���˻���', 'pointTxType', 1, 0);
--
delete from HI_Language where ID = 102500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102500, 0, '�Ƿ��Ѽ���������', 1, 0);
--
delete from HI_Language where ID = 102501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102501, 0, '֧����', 'rechargeTxStatus', 1, 0);
--
delete from HI_Language where ID = 102502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102502, 0, '֧���ɹ�', 'rechargeTxStatus', 1, 0);
--
delete from HI_Language where ID = 102503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102503, 0, '֧��ʧ��', 'rechargeTxStatus', 1, 0);
--
delete from HI_Language where ID = 102600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102600, 0, '��ֵ����״̬', 1, 0);
--
delete from HI_Language where ID = 102601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102601, 0, 'δ����', 'rechargeSettleStatus', 1, 0);
--
delete from HI_Language where ID = 102602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102602, 0, '�ѽ���', 'rechargeSettleStatus', 1, 0);
--
delete from HI_Language where ID = 102700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102700, 0, '���н���״̬', 1, 0);
--
delete from HI_Language where ID = 102701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102701, 0, '�ɹ�', 'bankTxStatus', 1, 0);
--
delete from HI_Language where ID = 102702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102702, 0, 'ʧ��', 'bankTxStatus', 1, 0);
--
delete from HI_Language where ID = 102703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102703, 0, '�ѳ���', 'bankTxStatus', 1, 0);
--
delete from HI_Language where ID = 102800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(102800, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 102801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102801, 0, 'δ����', 'checkStatus', 1, 0);
--
delete from HI_Language where ID = 102802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102802, 0, '����ƽ', 'checkStatus', 1, 0);
--
delete from HI_Language where ID = 102803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102803, 0, '����', 'checkStatus', 1, 0);
--
delete from HI_Language where ID = 102804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(102804, 0, '�̿�', 'checkStatus', 1, 0);
