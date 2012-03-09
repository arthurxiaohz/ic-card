
delete from HiMenu where ID = 500000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(500000, 0, 'settleservice', '�������', '�������', 0, 9999, 0);
--



delete from MenuLink where ID = 500100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500100, 0, '/tblStlCleaningDetailList.action', '�����ˮ��', '�����ˮ��', 500100, 9999, 500000, 0, 0);
--
delete from MenuLink where ID = 500500;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500500, 0, '/tblStlSettleBatchList.action', '��������', '��������', 500500, 9999, 500000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500100, 0, 'TBLSTLCLEANINGDETAIL_LIST', 'settleservice.TblStlCleaningDetailList', '', '�����ˮ���ѯ', 1, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500101, 0, 'TBLSTLCLEANINGDETAIL_VIEW', 'settleservice.TblStlCleaningDetailView', '', '�����ˮ��鿴', 2, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500102, 0, 'TBLSTLCLEANINGDETAIL_SAVE', 'settleservice.TblStlCleaningDetailSave', '', '�����ˮ����', 3, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500103, 0, 'TBLSTLCLEANINGDETAIL_DEL', 'settleservice.TblStlCleaningDetailDel', '', '�����ˮ��ɾ��', 4, 500100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500104, 0, 'TBLSTLCLEANINGDETAIL_LOOKUP', 'settleservice.TblStlCleaningDetailLookup', '', '�����ˮ�����', 1, 500100);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500500, 0, 'TBLSTLSETTLEBATCH_LIST', 'settleservice.TblStlSettleBatchList', '', '�������β�ѯ', 1, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500501, 0, 'TBLSTLSETTLEBATCH_VIEW', 'settleservice.TblStlSettleBatchView', '', '�������β鿴', 2, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500502, 0, 'TBLSTLSETTLEBATCH_SAVE', 'settleservice.TblStlSettleBatchSave', '', '�������α���', 3, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500503, 0, 'TBLSTLSETTLEBATCH_DEL', 'settleservice.TblStlSettleBatchDel', '', '��������ɾ��', 4, 500500);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500504, 0, 'TBLSTLSETTLEBATCH_LOOKUP', 'settleservice.TblStlSettleBatchLookup', '', '�������δ���', 1, 500500);
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
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500200, 0, 'refund', '�Ƿ��˿�״̬', '�Ƿ��˿�״̬', 0, 0);
--
delete from Enumeration where ID = 500300;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500300, 0, 'bankFeeBack', '���з��˿���Ƿ��˽���������', '���з��˿���Ƿ��˽���������', 0, 0);
--
delete from Enumeration where ID = 500600;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500600, 0, 'cleanStatus', '���״̬', '���״̬', 0, 0);
--



delete from EnumerationValue where ID = 500200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500200, 0, 'noRefund', '���˿�', '���˿�', '1', 500200, 0);
--
delete from EnumerationValue where ID = 500201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500201, 0, 'refund', '�˿��', '�˿��', '2', 500200, 0);
--
delete from EnumerationValue where ID = 500300;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500300, 0, 'noback', '����', '����', '1', 500300, 0);
--
delete from EnumerationValue where ID = 500301;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500301, 0, 'back', '��', '��', '2', 500300, 0);
--
delete from EnumerationValue where ID = 500600;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500600, 0, 'success', '�ɹ�', '�ɹ�', '1', 500600, 0);
--
delete from EnumerationValue where ID = 500601;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500601, 0, 'fail', 'ʧ��', 'ʧ��', '2', 500600, 0);
--

--
delete from HI_Language where ID = 500100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500100, 0, '�����ˮ��', 1, 0);
--
delete from HI_Language where ID = 500101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500101, 0, 'ƽ̨������ˮ��', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500102, 0, '�̻�������', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500103, 0, '����ʱ��', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500104, 0, '����޸�ʱ��', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500105, 0, '����޸���', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500106, 0, '�������', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500107, 0, '����ʱ��', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500108, 0, '�˿�ԭʼ����', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500109, 0, '�˿��ԭʼ���׽��', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500110, 0, '�˿���', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500111, 0, '�˻�����������', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500112;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500112, 0, '�̻�����۷ѽ��', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500113;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500113, 0, '��ע��Ϣ', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500114;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500114, 0, '��������', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500115;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500115, 0, '�˺�', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500116;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500116, 0, '����', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500117;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500117, 0, '�˻�����', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500118;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500118, 0, '�̻���', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500119;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500119, 0, '�̻�����', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500120;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500120, 0, '���״̬', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500121;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500121, 0, '֧�����', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500122;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500122, 0, '�̻�������', 'TblStlCleaningDetail', 1, 0);
--
delete from HI_Language where ID = 500200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500200, 0, '�Ƿ��˿�״̬', 1, 0);
--
delete from HI_Language where ID = 500201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500201, 0, '���˿�', 'refund', 1, 0);
--
delete from HI_Language where ID = 500202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500202, 0, '�˿��', 'refund', 1, 0);
--
delete from HI_Language where ID = 500300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500300, 0, '���з��˿���Ƿ��˽���������', 1, 0);
--
delete from HI_Language where ID = 500301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500301, 0, '����', 'bankFeeBack', 1, 0);
--
delete from HI_Language where ID = 500302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500302, 0, '��', 'bankFeeBack', 1, 0);
--
delete from HI_Language where ID = 500500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500500, 0, '��������', 1, 0);
--
delete from HI_Language where ID = 500501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500501, 0, '�������κ�', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500502, 0, '�̻���', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500503;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500503, 0, '�̻�����', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500504;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500504, 0, '�������к�', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500505;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500505, 0, '����������', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500506;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500506, 0, '�����˻��˺�', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500507;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500507, 0, '�����˻�����', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500508;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500508, 0, '����ʱ��', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500509;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500509, 0, '����޸�ʱ��', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500510;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500510, 0, '֧���ܱ���', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500511;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500511, 0, '֧���ܽ��', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500512;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500512, 0, '֧����������', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500513;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500513, 0, '�˿��ܱ���', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500514;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500514, 0, '�˿��ܽ��', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500515;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500515, 0, '�˿���������', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500516;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500516, 0, '������', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500600, 0, '���״̬', 1, 0);
--
delete from HI_Language where ID = 500601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500601, 0, '�ɹ�', 'cleanStatus', 1, 0);
--
delete from HI_Language where ID = 500602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500602, 0, 'ʧ��', 'cleanStatus', 1, 0);
