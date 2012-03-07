
delete from HiMenu where ID = 200000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(200000, 0, 'txservice', '���׷���', '���׷���', 0, 9999, 0);
--



delete from MenuLink where ID = 200100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(200100, 0, '/tblTxPayMentOrderList.action', '������ѯ', '������ѯ', 200100, 9999, 200000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200100, 0, 'TBLTXPAYMENTORDER_LIST', 'txservice.TblTxPayMentOrderList', '', '������ѯ��ѯ', 1, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200101, 0, 'TBLTXPAYMENTORDER_VIEW', 'txservice.TblTxPayMentOrderView', '', '������ѯ�鿴', 2, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200102, 0, 'TBLTXPAYMENTORDER_SAVE', 'txservice.TblTxPayMentOrderSave', '', '������ѯ����', 3, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200103, 0, 'TBLTXPAYMENTORDER_DEL', 'txservice.TblTxPayMentOrderDel', '', '������ѯɾ��', 4, 200100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(200104, 0, 'TBLTXPAYMENTORDER_LOOKUP', 'txservice.TblTxPayMentOrderLookup', '', '������ѯ����', 1, 200100);
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
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(200100, 0, '������ѯ', 1, 0);
--
delete from HI_Language where ID = 200101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200101, 0, 'ƽ̨������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200102, 0, 'ƽ̨��Ա��', 'TblTxPayMentOrder', 1, 0);
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
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200106, 0, 'ԭʼ���׷���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200107, 0, '�̻�������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200108, 0, 'ԭʼ�̻�������ˮ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200109, 0, '���׽��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200110, 0, '���׽��֪ͨ��ַ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200111, 0, '����IP��ַ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200112, 0, '�������ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200113, 0, '����״̬', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200114, 0, 'ƾ֤��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200115, 0, '����ƾ֤��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200116, 0, '�Ƿ�ʹ���Ż�ȯ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200117, 0, '�Ż�ȯ��Ϣ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200118, 0, '�����̻��Ż�ȯ��Ϣ', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200119, 0, '��ƷչʾURL', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200120, 0, '��Ʒ����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200121;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200121, 0, '�������ֻ�����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200122;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200122, 0, '��֤��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200123;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200123, 0, 'ȷ����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200124;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200124, 0, 'ȷ�Ϲ���ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200125;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200125, 0, '�쳣����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200126;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200126, 0, '�쳣����', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200127;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200127, 0, '�������κ�', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200128;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200128, 0, '����״̬', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200129;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200129, 0, '��������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200130;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200130, 0, '�����ѽ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200131;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200131, 0, '�Ƿ��Ѽ���������', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200132;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200132, 0, '����ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200133;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200133, 0, '����޸�ʱ��', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200134;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200134, 0, '����޸���', 'TblTxPayMentOrder', 1, 0);
--
delete from HI_Language where ID = 200135;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(200135, 0, '���׺�̨֪ͨ��ַ', 'TblTxPayMentOrder', 1, 0);
