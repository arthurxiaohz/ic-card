
delete from HiMenu where ID = 100000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(100000, 0, 'memberservice', '��Ա����', '��Ա����', 0, 9999, 0);
--



delete from MenuLink where ID = 101100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(101100, 0, '/tblMbTransactionResponseList.action', '���ؽ��׽��', '���ؽ��׽��', 101100, 9999, 100000, 0, 0);
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
