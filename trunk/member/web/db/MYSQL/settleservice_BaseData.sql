
delete from HiMenu where ID = 500000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(500000, 0, 'settleservice', '�������', '�������', 0, 9999, 0);
--



delete from MenuLink where ID = 500100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(500100, 0, '/tblStlCleaningDetailList.action', '�����ˮ��', '�����ˮ��', 500100, 9999, 500000, 0, 0);
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
