
delete from HiMenu where ID = 600000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(600000, 0, 'accounting', '�������', '�������', 0, 9999, 0);
--



delete from MenuLink where ID = 600200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(600200, 0, '/actAccountList.action', '�˻�', '�˻�', 600200, 9999, 600000, 0, 0);
--
delete from MenuLink where ID = 600300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(600300, 0, '/tblActAccountBalanceList.action', '�˻����', '�˻����', 600300, 9999, 600000, 0, 0);
--
delete from MenuLink where ID = 600400;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(600400, 0, '/tblActAccountDetailList.action', '�˻���ϸ', '�˻���ϸ', 600400, 9999, 600000, 0, 0);
--
delete from MenuLink where ID = 600500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(600500, 0, '/tblActDebitCreditVoucherList.action', '���ƾ֤', '���ƾ֤', 600500, 9999, 600000, 0, 0);
--
delete from MenuLink where ID = 600600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(600600, 0, '/tblActTransferVoucherList.action', 'ת��ƾ֤', 'ת��ƾ֤', 600600, 9999, 600000, 0, 0);
--



delete from HI_Authority where ID = 600200;
--
delete from HI_Authority where ID = 600201;
--
delete from HI_Authority where ID = 600202;
--
delete from HI_Authority where ID = 600203;
--
delete from HI_Authority where ID = 600204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600200, 0, 'ACTACCOUNT_LIST', 'accounting.ActAccountList', '', '�˻���ѯ', 1, 600200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600201, 0, 'ACTACCOUNT_VIEW', 'accounting.ActAccountView', '', '�˻��鿴', 2, 600200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600202, 0, 'ACTACCOUNT_SAVE', 'accounting.ActAccountSave', '', '�˻�����', 3, 600200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600203, 0, 'ACTACCOUNT_DEL', 'accounting.ActAccountDel', '', '�˻�ɾ��', 4, 600200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600204, 0, 'ACTACCOUNT_LOOKUP', 'accounting.ActAccountLookup', '', '�˻�����', 1, 600200);
--
delete from HI_Authority where ID = 600300;
--
delete from HI_Authority where ID = 600301;
--
delete from HI_Authority where ID = 600302;
--
delete from HI_Authority where ID = 600303;
--
delete from HI_Authority where ID = 600304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600300, 0, 'TBLACTACCOUNTBALANCE_LIST', 'accounting.TblActAccountBalanceList', '', '�˻�����ѯ', 1, 600300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600301, 0, 'TBLACTACCOUNTBALANCE_VIEW', 'accounting.TblActAccountBalanceView', '', '�˻����鿴', 2, 600300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600302, 0, 'TBLACTACCOUNTBALANCE_SAVE', 'accounting.TblActAccountBalanceSave', '', '�˻�����', 3, 600300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600303, 0, 'TBLACTACCOUNTBALANCE_DEL', 'accounting.TblActAccountBalanceDel', '', '�˻����ɾ��', 4, 600300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600304, 0, 'TBLACTACCOUNTBALANCE_LOOKUP', 'accounting.TblActAccountBalanceLookup', '', '�˻�������', 1, 600300);
--
delete from HI_Authority where ID = 600400;
--
delete from HI_Authority where ID = 600401;
--
delete from HI_Authority where ID = 600402;
--
delete from HI_Authority where ID = 600403;
--
delete from HI_Authority where ID = 600404;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600400, 0, 'TBLACTACCOUNTDETAIL_LIST', 'accounting.TblActAccountDetailList', '', '�˻���ϸ��ѯ', 1, 600400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600401, 0, 'TBLACTACCOUNTDETAIL_VIEW', 'accounting.TblActAccountDetailView', '', '�˻���ϸ�鿴', 2, 600400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600402, 0, 'TBLACTACCOUNTDETAIL_SAVE', 'accounting.TblActAccountDetailSave', '', '�˻���ϸ����', 3, 600400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600403, 0, 'TBLACTACCOUNTDETAIL_DEL', 'accounting.TblActAccountDetailDel', '', '�˻���ϸɾ��', 4, 600400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600404, 0, 'TBLACTACCOUNTDETAIL_LOOKUP', 'accounting.TblActAccountDetailLookup', '', '�˻���ϸ����', 1, 600400);
--
delete from HI_Authority where ID = 600500;
--
delete from HI_Authority where ID = 600501;
--
delete from HI_Authority where ID = 600502;
--
delete from HI_Authority where ID = 600503;
--
delete from HI_Authority where ID = 600504;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600500, 0, 'TBLACTDEBITCREDITVOUCHER_LIST', 'accounting.TblActDebitCreditVoucherList', '', '���ƾ֤��ѯ', 1, 600500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600501, 0, 'TBLACTDEBITCREDITVOUCHER_VIEW', 'accounting.TblActDebitCreditVoucherView', '', '���ƾ֤�鿴', 2, 600500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600502, 0, 'TBLACTDEBITCREDITVOUCHER_SAVE', 'accounting.TblActDebitCreditVoucherSave', '', '���ƾ֤����', 3, 600500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600503, 0, 'TBLACTDEBITCREDITVOUCHER_DEL', 'accounting.TblActDebitCreditVoucherDel', '', '���ƾ֤ɾ��', 4, 600500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600504, 0, 'TBLACTDEBITCREDITVOUCHER_LOOKUP', 'accounting.TblActDebitCreditVoucherLookup', '', '���ƾ֤����', 1, 600500);
--
delete from HI_Authority where ID = 600600;
--
delete from HI_Authority where ID = 600601;
--
delete from HI_Authority where ID = 600602;
--
delete from HI_Authority where ID = 600603;
--
delete from HI_Authority where ID = 600604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600600, 0, 'TBLACTTRANSFERVOUCHER_LIST', 'accounting.TblActTransferVoucherList', '', 'ת��ƾ֤��ѯ', 1, 600600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600601, 0, 'TBLACTTRANSFERVOUCHER_VIEW', 'accounting.TblActTransferVoucherView', '', 'ת��ƾ֤�鿴', 2, 600600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600602, 0, 'TBLACTTRANSFERVOUCHER_SAVE', 'accounting.TblActTransferVoucherSave', '', 'ת��ƾ֤����', 3, 600600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600603, 0, 'TBLACTTRANSFERVOUCHER_DEL', 'accounting.TblActTransferVoucherDel', '', 'ת��ƾ֤ɾ��', 4, 600600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(600604, 0, 'TBLACTTRANSFERVOUCHER_LOOKUP', 'accounting.TblActTransferVoucherLookup', '', 'ת��ƾ֤����', 1, 600600);
--

delete from HI_PrivilegeResource where ID = 600200;
--
delete from HI_PrivilegeResource where ID = 600201;
--
delete from HI_PrivilegeResource where ID = 600202;
--
delete from HI_PrivilegeResource where ID = 600203;
--
delete from HI_PrivilegeResource where ID = 600204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(600200, 0, 'ACTACCOUNT_LIST', '/actAccountList.action', 'cn.net.iccard.bm.accounting.service.ActAccountManager.getSecurityActAccountList', 'ACTACCOUNT_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600201, 0, 'ACTACCOUNT_VIEW', '/actAccountView.action', 'cn.net.iccard.bm.accounting.service.ActAccountManager.getSecurityActAccountById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600202, 0, 'ACTACCOUNT_SAVE', '/actAccountSave.action', 'cn.net.iccard.bm.accounting.service.ActAccountManager.saveSecurityActAccount');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600203, 0, 'ACTACCOUNT_DEL', '/actAccountRemove.action', 'cn.net.iccard.bm.accounting.service.ActAccountManager.removeSecurityActAccountById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(600204, 0, 'ACTACCOUNT_LOOKUP', '/actAccountLookup.action');
--
delete from HI_PrivilegeResource where ID = 600300;
--
delete from HI_PrivilegeResource where ID = 600301;
--
delete from HI_PrivilegeResource where ID = 600302;
--
delete from HI_PrivilegeResource where ID = 600303;
--
delete from HI_PrivilegeResource where ID = 600304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(600300, 0, 'TBLACTACCOUNTBALANCE_LIST', '/tblActAccountBalanceList.action', 'cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager.getSecurityTblActAccountBalanceList', 'TBLACTACCOUNTBALANCE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600301, 0, 'TBLACTACCOUNTBALANCE_VIEW', '/tblActAccountBalanceView.action', 'cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager.getSecurityTblActAccountBalanceById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600302, 0, 'TBLACTACCOUNTBALANCE_SAVE', '/tblActAccountBalanceSave.action', 'cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager.saveSecurityTblActAccountBalance');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600303, 0, 'TBLACTACCOUNTBALANCE_DEL', '/tblActAccountBalanceRemove.action', 'cn.net.iccard.bm.accounting.service.TblActAccountBalanceManager.removeSecurityTblActAccountBalanceById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(600304, 0, 'TBLACTACCOUNTBALANCE_LOOKUP', '/tblActAccountBalanceLookup.action');
--
delete from HI_PrivilegeResource where ID = 600400;
--
delete from HI_PrivilegeResource where ID = 600401;
--
delete from HI_PrivilegeResource where ID = 600402;
--
delete from HI_PrivilegeResource where ID = 600403;
--
delete from HI_PrivilegeResource where ID = 600404;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(600400, 0, 'TBLACTACCOUNTDETAIL_LIST', '/tblActAccountDetailList.action', 'cn.net.iccard.bm.accounting.service.TblActAccountDetailManager.getSecurityTblActAccountDetailList', 'TBLACTACCOUNTDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600401, 0, 'TBLACTACCOUNTDETAIL_VIEW', '/tblActAccountDetailView.action', 'cn.net.iccard.bm.accounting.service.TblActAccountDetailManager.getSecurityTblActAccountDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600402, 0, 'TBLACTACCOUNTDETAIL_SAVE', '/tblActAccountDetailSave.action', 'cn.net.iccard.bm.accounting.service.TblActAccountDetailManager.saveSecurityTblActAccountDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600403, 0, 'TBLACTACCOUNTDETAIL_DEL', '/tblActAccountDetailRemove.action', 'cn.net.iccard.bm.accounting.service.TblActAccountDetailManager.removeSecurityTblActAccountDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(600404, 0, 'TBLACTACCOUNTDETAIL_LOOKUP', '/tblActAccountDetailLookup.action');
--
delete from HI_PrivilegeResource where ID = 600500;
--
delete from HI_PrivilegeResource where ID = 600501;
--
delete from HI_PrivilegeResource where ID = 600502;
--
delete from HI_PrivilegeResource where ID = 600503;
--
delete from HI_PrivilegeResource where ID = 600504;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(600500, 0, 'TBLACTDEBITCREDITVOUCHER_LIST', '/tblActDebitCreditVoucherList.action', 'cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager.getSecurityTblActDebitCreditVoucherList', 'TBLACTDEBITCREDITVOUCHER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600501, 0, 'TBLACTDEBITCREDITVOUCHER_VIEW', '/tblActDebitCreditVoucherView.action', 'cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager.getSecurityTblActDebitCreditVoucherById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600502, 0, 'TBLACTDEBITCREDITVOUCHER_SAVE', '/tblActDebitCreditVoucherSave.action', 'cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager.saveSecurityTblActDebitCreditVoucher');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600503, 0, 'TBLACTDEBITCREDITVOUCHER_DEL', '/tblActDebitCreditVoucherRemove.action', 'cn.net.iccard.bm.accounting.service.TblActDebitCreditVoucherManager.removeSecurityTblActDebitCreditVoucherById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(600504, 0, 'TBLACTDEBITCREDITVOUCHER_LOOKUP', '/tblActDebitCreditVoucherLookup.action');
--
delete from HI_PrivilegeResource where ID = 600600;
--
delete from HI_PrivilegeResource where ID = 600601;
--
delete from HI_PrivilegeResource where ID = 600602;
--
delete from HI_PrivilegeResource where ID = 600603;
--
delete from HI_PrivilegeResource where ID = 600604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(600600, 0, 'TBLACTTRANSFERVOUCHER_LIST', '/tblActTransferVoucherList.action', 'cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager.getSecurityTblActTransferVoucherList', 'TBLACTTRANSFERVOUCHER_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600601, 0, 'TBLACTTRANSFERVOUCHER_VIEW', '/tblActTransferVoucherView.action', 'cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager.getSecurityTblActTransferVoucherById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600602, 0, 'TBLACTTRANSFERVOUCHER_SAVE', '/tblActTransferVoucherSave.action', 'cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager.saveSecurityTblActTransferVoucher');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(600603, 0, 'TBLACTTRANSFERVOUCHER_DEL', '/tblActTransferVoucherRemove.action', 'cn.net.iccard.bm.accounting.service.TblActTransferVoucherManager.removeSecurityTblActTransferVoucherById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(600604, 0, 'TBLACTTRANSFERVOUCHER_LOOKUP', '/tblActTransferVoucherLookup.action');
--



delete from Enumeration where ID = 600700;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(600700, 0, 'accountPartyType', '����������', '����������', 0, 0);
--
delete from Enumeration where ID = 600800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(600800, 0, 'voucherType', 'ƾ֤����', 'ƾ֤����', 0, 0);
--
delete from Enumeration where ID = 600900;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(600900, 0, 'debitOrCredit', '�������', '�������', 0, 0);
--
delete from Enumeration where ID = 601000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(601000, 0, 'bizType', 'ҵ������', 'ҵ������', 0, 0);
--
delete from Enumeration where ID = 601100;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(601100, 0, 'accountCatalog', '�˻�����', '�˻�����', 0, 0);
--
delete from Enumeration where ID = 601200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(601200, 0, 'settleStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 601300;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(601300, 0, 'accountStatus', '�˺�״̬', '�˺�״̬', 0, 0);
--



delete from EnumerationValue where ID = 600700;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600700, 0, 'member', '��Ա', '��Ա', '', 600700, 0);
--
delete from EnumerationValue where ID = 600701;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600701, 0, 'mcht', '�̻�', '�̻�', '', 600700, 0);
--
delete from EnumerationValue where ID = 600702;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600702, 0, 'platform', 'ƽ̨', 'ƽ̨', '', 600700, 0);
--
delete from EnumerationValue where ID = 600800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600800, 0, 'debitOrCredit', '���', '���', '', 600800, 0);
--
delete from EnumerationValue where ID = 600801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600801, 0, 'transfer', 'ת��', 'ת��', '', 600800, 0);
--
delete from EnumerationValue where ID = 600900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600900, 0, 'debit', '��', '��', '', 600900, 0);
--
delete from EnumerationValue where ID = 600901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(600901, 0, 'credit', '��', '��', '', 600900, 0);
--
delete from EnumerationValue where ID = 601000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601000, 0, 'confirmPay', 'ȷ��֧��', 'ȷ��֧��', '', 601000, 0);
--
delete from EnumerationValue where ID = 601001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601001, 0, 'prepaid', 'Ԥ֧��', 'Ԥ֧��', '', 601000, 0);
--
delete from EnumerationValue where ID = 601002;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601002, 0, 'settlement', '����', '����', '', 601000, 0);
--
delete from EnumerationValue where ID = 601003;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601003, 0, 'cancel', '����', '����', '', 601000, 0);
--
delete from EnumerationValue where ID = 601004;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601004, 0, 'confirmRefund', 'ȷ���˿�', 'ȷ���˿�', '', 601000, 0);
--
delete from EnumerationValue where ID = 601005;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601005, 0, 'bankCharge', '������ֵ', '������ֵ', '', 601000, 0);
--
delete from EnumerationValue where ID = 601006;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601006, 0, 'cashCharge', '�ֽ��ֵ', '�ֽ��ֵ', '', 601000, 0);
--
delete from EnumerationValue where ID = 601007;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601007, 0, 'onlineToOffline', '����ת����', '����ת����', '', 601000, 0);
--
delete from EnumerationValue where ID = 601100;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601100, 0, 'feeAccount', '�������˻�', '�������˻�', '', 601100, 0);
--
delete from EnumerationValue where ID = 601101;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601101, 0, 'virtualAccount', '�����˻�', '�����˻�', '', 601100, 0);
--
delete from EnumerationValue where ID = 601102;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601102, 0, 'guaranteeAccount', '�����˻�', '�����˻�', '', 601100, 0);
--
delete from EnumerationValue where ID = 601200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601200, 0, 'toSettled', '������', '������', '', 601200, 0);
--
delete from EnumerationValue where ID = 601201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601201, 0, 'settled', '�Ѵ���', '�Ѵ���', '', 601200, 0);
--
delete from EnumerationValue where ID = 601300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601300, 0, 'normal', '����', '����', '', 601300, 0);
--
delete from EnumerationValue where ID = 601301;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601301, 0, 'canceled', '��ע��', '��ע��', '', 601300, 0);
--
delete from EnumerationValue where ID = 601302;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(601302, 0, 'frozen', '�Ѷ���', '�Ѷ���', '', 601300, 0);
--

--
delete from HI_Language where ID = 600200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600200, 0, '�˻�', 1, 0);
--
delete from HI_Language where ID = 600201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600201, 0, '�˺�', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600202, 0, '�˻�����', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600203;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600203, 0, '����������', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600204;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600204, 0, '������', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600205;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600205, 0, '��������', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600206;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600206, 0, '״̬', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600207;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600207, 0, '��ע', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600208;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600208, 0, '����ʱ��', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600209;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600209, 0, '����޸�ʱ��', 'ActAccount', 1, 0);
--
delete from HI_Language where ID = 600300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600300, 0, '�˻����', 1, 0);
--
delete from HI_Language where ID = 600301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600301, 0, '�������', 'TblActAccountBalance', 1, 0);
--
delete from HI_Language where ID = 600400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600400, 0, '�˻���ϸ', 1, 0);
--
delete from HI_Language where ID = 600401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600401, 0, '�˺�', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600402, 0, '�˻�����', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600403, 0, '����������', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600404, 0, '������', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600405, 0, '��������', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600406;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600406, 0, 'ƾ֤����', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600407;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600407, 0, 'ƾ֤��', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600408;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600408, 0, '���', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600409;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600409, 0, '�������', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600410;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600410, 0, '���', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600411;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600411, 0, '��ע', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600412;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600412, 0, '��ֹ����', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600413;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600413, 0, '����״̬', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600414;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600414, 0, '����ʱ��', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600415;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600415, 0, '����޸�ʱ��', 'TblActAccountDetail', 1, 0);
--
delete from HI_Language where ID = 600500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600500, 0, '���ƾ֤', 1, 0);
--
delete from HI_Language where ID = 600501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600501, 0, 'ƾ֤��', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600502, 0, '�˺�', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600503, 0, '���', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600504, 0, '�������', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600505;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600505, 0, 'ҵ������', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600506;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600506, 0, 'ҵ����ˮ', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600507;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600507, 0, '��ע', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600508;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600508, 0, '����ʱ��', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600509;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600509, 0, '����޸�ʱ��', 'TblActDebitCreditVoucher', 1, 0);
--
delete from HI_Language where ID = 600600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600600, 0, 'ת��ƾ֤', 1, 0);
--
delete from HI_Language where ID = 600601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600601, 0, 'ƾ֤��', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600602, 0, '�����˺�', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600603, 0, '�����˺�', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600604, 0, '���', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600605, 0, 'ҵ������', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600606, 0, 'ҵ����ˮ', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600607, 0, '��ע', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600608;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600608, 0, '����ʱ��', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600609;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600609, 0, '����޸�ʱ��', 'TblActTransferVoucher', 1, 0);
--
delete from HI_Language where ID = 600700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600700, 0, '����������', 1, 0);
--
delete from HI_Language where ID = 600701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600701, 0, '��Ա', 'accountPartyType', 1, 0);
--
delete from HI_Language where ID = 600702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600702, 0, '�̻�', 'accountPartyType', 1, 0);
--
delete from HI_Language where ID = 600703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600703, 0, 'ƽ̨', 'accountPartyType', 1, 0);
--
delete from HI_Language where ID = 600800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600800, 0, 'ƾ֤����', 1, 0);
--
delete from HI_Language where ID = 600801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600801, 0, '���', 'voucherType', 1, 0);
--
delete from HI_Language where ID = 600802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600802, 0, 'ת��', 'voucherType', 1, 0);
--
delete from HI_Language where ID = 600900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(600900, 0, '�������', 1, 0);
--
delete from HI_Language where ID = 600901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600901, 0, '��', 'debitOrCredit', 1, 0);
--
delete from HI_Language where ID = 600902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(600902, 0, '��', 'debitOrCredit', 1, 0);
--
delete from HI_Language where ID = 601000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(601000, 0, 'ҵ������', 1, 0);
--
delete from HI_Language where ID = 601001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601001, 0, 'ȷ��֧��', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601002, 0, 'Ԥ֧��', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601003, 0, '����', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601004, 0, '����', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601005;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601005, 0, 'ȷ���˿�', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601006;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601006, 0, '������ֵ', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601007;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601007, 0, '�ֽ��ֵ', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601008;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601008, 0, '����ת����', 'bizType', 1, 0);
--
delete from HI_Language where ID = 601100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(601100, 0, '�˻�����', 1, 0);
--
delete from HI_Language where ID = 601101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601101, 0, '�������˻�', 'accountCatalog', 1, 0);
--
delete from HI_Language where ID = 601102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601102, 0, '�����˻�', 'accountCatalog', 1, 0);
--
delete from HI_Language where ID = 601103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601103, 0, '�����˻�', 'accountCatalog', 1, 0);
--
delete from HI_Language where ID = 601200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(601200, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 601201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601201, 0, '������', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 601202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601202, 0, '�Ѵ���', 'settleStatus', 1, 0);
--
delete from HI_Language where ID = 601300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(601300, 0, '�˺�״̬', 1, 0);
--
delete from HI_Language where ID = 601301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601301, 0, '����', 'accountStatus', 1, 0);
--
delete from HI_Language where ID = 601302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601302, 0, '��ע��', 'accountStatus', 1, 0);
--
delete from HI_Language where ID = 601303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(601303, 0, '�Ѷ���', 'accountStatus', 1, 0);
