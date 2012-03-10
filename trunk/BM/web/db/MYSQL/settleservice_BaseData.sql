
delete from HiMenu where ID = 500000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(500000, 0, 'settleservice', '�������', '�������', 0, 9999, 0);
--



delete from MenuLink where ID = 500100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500100, 0, '/tblStlCleaningDetailList.action', '�����ˮ��', '�����ˮ��', 500100, 9999, 500000, 0, 0);
--
delete from MenuLink where ID = 500700;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500700, 0, '/tblStlSettleApplyList.action', '��������', '��������', 500700, 9999, 500000, 0, 0);
--
delete from MenuLink where ID = 500900;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500900, 0, '/tblStlSettleBatchList.action', '��������', '��������', 500900, 9999, 500000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500700, 0, 'TBLSTLSETTLEAPPLY_LIST', 'settleservice.TblStlSettleApplyList', '', '���������ѯ', 1, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500701, 0, 'TBLSTLSETTLEAPPLY_VIEW', 'settleservice.TblStlSettleApplyView', '', '��������鿴', 2, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500702, 0, 'TBLSTLSETTLEAPPLY_SAVE', 'settleservice.TblStlSettleApplySave', '', '�������뱣��', 3, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500703, 0, 'TBLSTLSETTLEAPPLY_DEL', 'settleservice.TblStlSettleApplyDel', '', '��������ɾ��', 4, 500700);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500704, 0, 'TBLSTLSETTLEAPPLY_LOOKUP', 'settleservice.TblStlSettleApplyLookup', '', '�����������', 1, 500700);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500900, 0, 'TBLSTLSETTLEBATCH_LIST', 'settleservice.TblStlSettleBatchList', '', '�������β�ѯ', 1, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500901, 0, 'TBLSTLSETTLEBATCH_VIEW', 'settleservice.TblStlSettleBatchView', '', '�������β鿴', 2, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500902, 0, 'TBLSTLSETTLEBATCH_SAVE', 'settleservice.TblStlSettleBatchSave', '', '�������α���', 3, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500903, 0, 'TBLSTLSETTLEBATCH_DEL', 'settleservice.TblStlSettleBatchDel', '', '��������ɾ��', 4, 500900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(500904, 0, 'TBLSTLSETTLEBATCH_LOOKUP', 'settleservice.TblStlSettleBatchLookup', '', '�������δ���', 1, 500900);
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
delete from Enumeration where ID = 500800;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(500800, 0, 'settleApplyStatus', '��������״̬', '��������״̬', 0, 0);
--
delete from Enumeration where ID = 501000;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(501000, 0, 'settleBatchStatus', '��������״̬', '��������״̬', 0, 0);
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
delete from EnumerationValue where ID = 500800;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500800, 0, 'checking', '�����', '�����', '', 500800, 0);
--
delete from EnumerationValue where ID = 500801;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500801, 0, 'checkPass', '���ͨ��', '���ͨ��', '', 500800, 0);
--
delete from EnumerationValue where ID = 500802;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500802, 0, 'checkFail', '��˲�ͨ��', '��˲�ͨ��', '', 500800, 0);
--
delete from EnumerationValue where ID = 500803;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500803, 0, 'settling', '������', '������', '', 500800, 0);
--
delete from EnumerationValue where ID = 500804;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500804, 0, 'settled', '�ѽ���', '�ѽ���', '', 500800, 0);
--
delete from EnumerationValue where ID = 500805;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(500805, 0, 'settleFail', '����ʧ��', '����ʧ��', '', 500800, 0);
--
delete from EnumerationValue where ID = 501000;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(501000, 0, 'toSettle', '������', '������', '', 501000, 0);
--
delete from EnumerationValue where ID = 501001;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(501001, 0, 'settled', '�ѽ���', '�ѽ���', '', 501000, 0);
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
--
delete from HI_Language where ID = 500700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500700, 0, '��������', 1, 0);
--
delete from HI_Language where ID = 500701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500701, 0, '�̻���', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500702, 0, '�̻�����', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500703, 0, '�˻��������', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500704, 0, '���������', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500705;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500705, 0, '״̬', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500706;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500706, 0, '��ע', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500707;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500707, 0, '������', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500708;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500708, 0, '�������κ�', 'TblStlSettleApply', 1, 0);
--
delete from HI_Language where ID = 500800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500800, 0, '��������״̬', 1, 0);
--
delete from HI_Language where ID = 500801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500801, 0, '�����', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500802, 0, '���ͨ��', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500803, 0, '��˲�ͨ��', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500804, 0, '������', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500805, 0, '�ѽ���', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500806;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500806, 0, '����ʧ��', 'settleApplyStatus', 1, 0);
--
delete from HI_Language where ID = 500900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(500900, 0, '��������', 1, 0);
--
delete from HI_Language where ID = 500901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500901, 0, '�������κ�', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500902, 0, '������', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500903;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500903, 0, '������', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500904;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500904, 0, '�ܽ��', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 500905;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(500905, 0, '״̬', 'TblStlSettleBatch', 1, 0);
--
delete from HI_Language where ID = 501000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(501000, 0, '��������״̬', 1, 0);
--
delete from HI_Language where ID = 501001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(501001, 0, '������', 'settleBatchStatus', 1, 0);
--
delete from HI_Language where ID = 501002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(501002, 0, '�ѽ���', 'settleBatchStatus', 1, 0);
