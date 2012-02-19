
delete from HiMenu where ID = 100000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(100000, 0, 'test', '����', '����', 0, 9999, 0);
--



delete from MenuLink where ID = 100100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100100, 0, '/staffList.action', 'staff', 'staff', 100100, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100200;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100200, 0, '/nationList.action', 'Nation', 'Nation', 100200, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100300, 0, '/jobPositionList.action', 'JobPosition', 'JobPosition', 100300, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100800;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100800, 0, '/mbMchtInfList.action', '�̻���Ϣ', '�̻���Ϣ', 100800, 9999, 100000, 0, 0);
--
delete from MenuLink where ID = 100900;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(100900, 0, '/mchtSettleFeeList.action', '�̻�������', '�̻�������', 100900, 9999, 100000, 0, 0);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100100, 0, 'STAFF_LIST', 'test.StaffList', '', 'staff��ѯ', 1, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100101, 0, 'STAFF_VIEW', 'test.StaffView', '', 'staff�鿴', 2, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100102, 0, 'STAFF_SAVE', 'test.StaffSave', '', 'staff����', 3, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100103, 0, 'STAFF_DEL', 'test.StaffDel', '', 'staffɾ��', 4, 100100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100104, 0, 'STAFF_LOOKUP', 'test.StaffLookup', '', 'staff����', 1, 100100);
--
delete from HI_Authority where ID = 100200;
--
delete from HI_Authority where ID = 100201;
--
delete from HI_Authority where ID = 100202;
--
delete from HI_Authority where ID = 100203;
--
delete from HI_Authority where ID = 100204;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100200, 0, 'NATION_LIST', 'test.NationList', '', 'Nation��ѯ', 1, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100201, 0, 'NATION_VIEW', 'test.NationView', '', 'Nation�鿴', 2, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100202, 0, 'NATION_SAVE', 'test.NationSave', '', 'Nation����', 3, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100203, 0, 'NATION_DEL', 'test.NationDel', '', 'Nationɾ��', 4, 100200);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100204, 0, 'NATION_LOOKUP', 'test.NationLookup', '', 'Nation����', 1, 100200);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100300, 0, 'JOBPOSITION_LIST', 'test.JobPositionList', '', 'JobPosition��ѯ', 1, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100301, 0, 'JOBPOSITION_VIEW', 'test.JobPositionView', '', 'JobPosition�鿴', 2, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100302, 0, 'JOBPOSITION_SAVE', 'test.JobPositionSave', '', 'JobPosition����', 3, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100303, 0, 'JOBPOSITION_DEL', 'test.JobPositionDel', '', 'JobPositionɾ��', 4, 100300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100304, 0, 'JOBPOSITION_LOOKUP', 'test.JobPositionLookup', '', 'JobPosition����', 1, 100300);
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
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100400, 0, 'EXPERIENCE_LIST', 'test.ExperienceList', '', 'Experience��ѯ', 1, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100401, 0, 'EXPERIENCE_VIEW', 'test.ExperienceView', '', 'Experience�鿴', 2, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100402, 0, 'EXPERIENCE_SAVE', 'test.ExperienceSave', '', 'Experience����', 3, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100403, 0, 'EXPERIENCE_DEL', 'test.ExperienceDel', '', 'Experienceɾ��', 4, 100400);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100404, 0, 'EXPERIENCE_LOOKUP', 'test.ExperienceLookup', '', 'Experience����', 1, 100400);
--
delete from HI_Authority where ID = 100800;
--
delete from HI_Authority where ID = 100801;
--
delete from HI_Authority where ID = 100802;
--
delete from HI_Authority where ID = 100803;
--
delete from HI_Authority where ID = 100804;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100800, 0, 'MBMCHTINF_LIST', 'test.MbMchtInfList', '', '�̻���Ϣ��ѯ', 1, 100800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100801, 0, 'MBMCHTINF_VIEW', 'test.MbMchtInfView', '', '�̻���Ϣ�鿴', 2, 100800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100802, 0, 'MBMCHTINF_SAVE', 'test.MbMchtInfSave', '', '�̻���Ϣ����', 3, 100800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100803, 0, 'MBMCHTINF_DEL', 'test.MbMchtInfDel', '', '�̻���Ϣɾ��', 4, 100800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100804, 0, 'MBMCHTINF_LOOKUP', 'test.MbMchtInfLookup', '', '�̻���Ϣ����', 1, 100800);
--
delete from HI_Authority where ID = 100900;
--
delete from HI_Authority where ID = 100901;
--
delete from HI_Authority where ID = 100902;
--
delete from HI_Authority where ID = 100903;
--
delete from HI_Authority where ID = 100904;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100900, 0, 'MCHTSETTLEFEE_LIST', 'test.MchtSettleFeeList', '', '�̻������Ѳ�ѯ', 1, 100900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100901, 0, 'MCHTSETTLEFEE_VIEW', 'test.MchtSettleFeeView', '', '�̻������Ѳ鿴', 2, 100900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100902, 0, 'MCHTSETTLEFEE_SAVE', 'test.MchtSettleFeeSave', '', '�̻������ѱ���', 3, 100900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100903, 0, 'MCHTSETTLEFEE_DEL', 'test.MchtSettleFeeDel', '', '�̻�������ɾ��', 4, 100900);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(100904, 0, 'MCHTSETTLEFEE_LOOKUP', 'test.MchtSettleFeeLookup', '', '�̻������Ѵ���', 1, 100900);
--
delete from HI_Authority where ID = 101000;
--
delete from HI_Authority where ID = 101001;
--
delete from HI_Authority where ID = 101002;
--
delete from HI_Authority where ID = 101003;
--
delete from HI_Authority where ID = 101004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101000, 0, 'FRIENDS_LIST', 'test.FriendsList', '', '���Ѳ�ѯ', 1, 101000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101001, 0, 'FRIENDS_VIEW', 'test.FriendsView', '', '���Ѳ鿴', 2, 101000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101002, 0, 'FRIENDS_SAVE', 'test.FriendsSave', '', '���ѱ���', 3, 101000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101003, 0, 'FRIENDS_DEL', 'test.FriendsDel', '', '����ɾ��', 4, 101000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(101004, 0, 'FRIENDS_LOOKUP', 'test.FriendsLookup', '', '���Ѵ���', 1, 101000);
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
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100100, 0, 'STAFF_LIST', '/staffList.action', 'org.hi.test.service.StaffManager.getSecurityStaffList', 'STAFF_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100101, 0, 'STAFF_VIEW', '/staffView.action', 'org.hi.test.service.StaffManager.getSecurityStaffById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100102, 0, 'STAFF_SAVE', '/staffSave.action', 'org.hi.test.service.StaffManager.saveSecurityStaff');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100103, 0, 'STAFF_DEL', '/staffRemove.action', 'org.hi.test.service.StaffManager.removeSecurityStaffById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100104, 0, 'STAFF_LOOKUP', '/staffLookup.action');
--
delete from HI_PrivilegeResource where ID = 100200;
--
delete from HI_PrivilegeResource where ID = 100201;
--
delete from HI_PrivilegeResource where ID = 100202;
--
delete from HI_PrivilegeResource where ID = 100203;
--
delete from HI_PrivilegeResource where ID = 100204;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100200, 0, 'NATION_LIST', '/nationList.action', 'org.hi.test.service.NationManager.getSecurityNationList', 'NATION_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100201, 0, 'NATION_VIEW', '/nationView.action', 'org.hi.test.service.NationManager.getSecurityNationById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100202, 0, 'NATION_SAVE', '/nationSave.action', 'org.hi.test.service.NationManager.saveSecurityNation');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100203, 0, 'NATION_DEL', '/nationRemove.action', 'org.hi.test.service.NationManager.removeSecurityNationById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100204, 0, 'NATION_LOOKUP', '/nationLookup.action');
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
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100300, 0, 'JOBPOSITION_LIST', '/jobPositionList.action', 'org.hi.test.service.JobPositionManager.getSecurityJobPositionList', 'JOBPOSITION_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100301, 0, 'JOBPOSITION_VIEW', '/jobPositionView.action', 'org.hi.test.service.JobPositionManager.getSecurityJobPositionById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100302, 0, 'JOBPOSITION_SAVE', '/jobPositionSave.action', 'org.hi.test.service.JobPositionManager.saveSecurityJobPosition');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100303, 0, 'JOBPOSITION_DEL', '/jobPositionRemove.action', 'org.hi.test.service.JobPositionManager.removeSecurityJobPositionById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100304, 0, 'JOBPOSITION_LOOKUP', '/jobPositionLookup.action');
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
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100400, 0, 'EXPERIENCE_LIST', '/experienceList.action', 'org.hi.test.service.ExperienceManager.getSecurityExperienceList', 'EXPERIENCE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100401, 0, 'EXPERIENCE_VIEW', '/experienceView.action', 'org.hi.test.service.ExperienceManager.getSecurityExperienceById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100402, 0, 'EXPERIENCE_SAVE', '/experienceSave.action', 'org.hi.test.service.ExperienceManager.saveSecurityExperience');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100403, 0, 'EXPERIENCE_DEL', '/experienceRemove.action', 'org.hi.test.service.ExperienceManager.removeSecurityExperienceById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100404, 0, 'EXPERIENCE_LOOKUP', '/experienceLookup.action');
--
delete from HI_PrivilegeResource where ID = 100800;
--
delete from HI_PrivilegeResource where ID = 100801;
--
delete from HI_PrivilegeResource where ID = 100802;
--
delete from HI_PrivilegeResource where ID = 100803;
--
delete from HI_PrivilegeResource where ID = 100804;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100800, 0, 'MBMCHTINF_LIST', '/mbMchtInfList.action', 'org.hi.test.service.MbMchtInfManager.getSecurityMbMchtInfList', 'MBMCHTINF_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100801, 0, 'MBMCHTINF_VIEW', '/mbMchtInfView.action', 'org.hi.test.service.MbMchtInfManager.getSecurityMbMchtInfById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100802, 0, 'MBMCHTINF_SAVE', '/mbMchtInfSave.action', 'org.hi.test.service.MbMchtInfManager.saveSecurityMbMchtInf');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100803, 0, 'MBMCHTINF_DEL', '/mbMchtInfRemove.action', 'org.hi.test.service.MbMchtInfManager.removeSecurityMbMchtInfById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100804, 0, 'MBMCHTINF_LOOKUP', '/mbMchtInfLookup.action');
--
delete from HI_PrivilegeResource where ID = 100900;
--
delete from HI_PrivilegeResource where ID = 100901;
--
delete from HI_PrivilegeResource where ID = 100902;
--
delete from HI_PrivilegeResource where ID = 100903;
--
delete from HI_PrivilegeResource where ID = 100904;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(100900, 0, 'MCHTSETTLEFEE_LIST', '/mchtSettleFeeList.action', 'org.hi.test.service.MchtSettleFeeManager.getSecurityMchtSettleFeeList', 'MCHTSETTLEFEE_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100901, 0, 'MCHTSETTLEFEE_VIEW', '/mchtSettleFeeView.action', 'org.hi.test.service.MchtSettleFeeManager.getSecurityMchtSettleFeeById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100902, 0, 'MCHTSETTLEFEE_SAVE', '/mchtSettleFeeSave.action', 'org.hi.test.service.MchtSettleFeeManager.saveSecurityMchtSettleFee');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(100903, 0, 'MCHTSETTLEFEE_DEL', '/mchtSettleFeeRemove.action', 'org.hi.test.service.MchtSettleFeeManager.removeSecurityMchtSettleFeeById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(100904, 0, 'MCHTSETTLEFEE_LOOKUP', '/mchtSettleFeeLookup.action');
--
delete from HI_PrivilegeResource where ID = 101000;
--
delete from HI_PrivilegeResource where ID = 101001;
--
delete from HI_PrivilegeResource where ID = 101002;
--
delete from HI_PrivilegeResource where ID = 101003;
--
delete from HI_PrivilegeResource where ID = 101004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(101000, 0, 'FRIENDS_LIST', '/friendsList.action', 'org.hi.test.service.FriendsManager.getSecurityFriendsList', 'FRIENDS_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101001, 0, 'FRIENDS_VIEW', '/friendsView.action', 'org.hi.test.service.FriendsManager.getSecurityFriendsById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101002, 0, 'FRIENDS_SAVE', '/friendsSave.action', 'org.hi.test.service.FriendsManager.saveSecurityFriends');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(101003, 0, 'FRIENDS_DEL', '/friendsRemove.action', 'org.hi.test.service.FriendsManager.removeSecurityFriendsById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(101004, 0, 'FRIENDS_LOOKUP', '/friendsLookup.action');
--



delete from Enumeration where ID = 100500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(100500, 0, 'marriedStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 100600;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(100600, 0, 'employedStatus', '����״̬', '����״̬', 0, 0);
--
delete from Enumeration where ID = 100700;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(100700, 0, 'degree', 'ѧ��', 'ѧ��', 0, 0);
--



delete from EnumerationValue where ID = 100500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100500, 0, 'married', '�ѻ�', '�ѻ�', '0', 100500, 0);
--
delete from EnumerationValue where ID = 100501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100501, 0, 'unMarried', 'δ��', 'δ��', '1', 100500, 0);
--
delete from EnumerationValue where ID = 100600;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100600, 0, 'employed', '��ְ', '��ְ', '0', 100600, 0);
--
delete from EnumerationValue where ID = 100601;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100601, 0, 'unEmployed', '��ְ', '��ְ', '1', 100600, 0);
--
delete from EnumerationValue where ID = 100700;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100700, 0, 'highSchool', '����', '����', '0', 100700, 0);
--
delete from EnumerationValue where ID = 100701;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100701, 0, 'bachelor', '����', '����', '1', 100700, 0);
--
delete from EnumerationValue where ID = 100702;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100702, 0, 'master', '˶ʿ', '˶ʿ', '2', 100700, 0);
--
delete from EnumerationValue where ID = 100703;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(100703, 0, 'doctor', '��ʿ', '��ʿ', '3', 100700, 0);
--

--
delete from HI_Language where ID = 100100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100100, 0, 'staff', 1, 0);
--
delete from HI_Language where ID = 100101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100101, 0, 'Ա�����', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100102, 0, '����', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100103, 0, 'ѧ��', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100104, 0, 'רҵ', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100105, 0, '�볡ʱ��', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100106, 0, '����״̬', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100107, 0, '���˰���', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100108, 0, '������λ', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100109, 0, 'Ա����Ƭ', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100110;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100110, 0, '����״̬', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100111;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100111, 0, '����', 'Staff', 1, 0);
--
delete from HI_Language where ID = 100200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100200, 0, 'Nation', 1, 0);
--
delete from HI_Language where ID = 100201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100201, 0, '��������', 'Nation', 1, 0);
--
delete from HI_Language where ID = 100202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100202, 0, 'Ӣ������', 'Nation', 1, 0);
--
delete from HI_Language where ID = 100300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100300, 0, 'JobPosition', 1, 0);
--
delete from HI_Language where ID = 100301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100301, 0, '��λ����', 'JobPosition', 1, 0);
--
delete from HI_Language where ID = 100302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100302, 0, '����', 'JobPosition', 1, 0);
--
delete from HI_Language where ID = 100400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100400, 0, 'Experience', 1, 0);
--
delete from HI_Language where ID = 100401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100401, 0, '��ʼʱ��', 'Experience', 1, 0);
--
delete from HI_Language where ID = 100402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100402, 0, '����ʱ��', 'Experience', 1, 0);
--
delete from HI_Language where ID = 100403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100403, 0, '�ص�', 'Experience', 1, 0);
--
delete from HI_Language where ID = 100404;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100404, 0, '����', 'Experience', 1, 0);
--
delete from HI_Language where ID = 100405;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100405, 0, '֤����', 'Experience', 1, 0);
--
delete from HI_Language where ID = 100500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100500, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 100501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100501, 0, '�ѻ�', 'marriedStatus', 1, 0);
--
delete from HI_Language where ID = 100502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100502, 0, 'δ��', 'marriedStatus', 1, 0);
--
delete from HI_Language where ID = 100600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100600, 0, '����״̬', 1, 0);
--
delete from HI_Language where ID = 100601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100601, 0, '��ְ', 'employedStatus', 1, 0);
--
delete from HI_Language where ID = 100602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100602, 0, '��ְ', 'employedStatus', 1, 0);
--
delete from HI_Language where ID = 100700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100700, 0, 'ѧ��', 1, 0);
--
delete from HI_Language where ID = 100701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100701, 0, '����', 'degree', 1, 0);
--
delete from HI_Language where ID = 100702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100702, 0, '����', 'degree', 1, 0);
--
delete from HI_Language where ID = 100703;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100703, 0, '˶ʿ', 'degree', 1, 0);
--
delete from HI_Language where ID = 100704;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100704, 0, '��ʿ', 'degree', 1, 0);
--
delete from HI_Language where ID = 100800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100800, 0, '�̻���Ϣ', 1, 0);
--
delete from HI_Language where ID = 100801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100801, 0, '�̻���', 'MbMchtInf', 1, 0);
--
delete from HI_Language where ID = 100802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100802, 0, '�̻�����', 'MbMchtInf', 1, 0);
--
delete from HI_Language where ID = 100900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(100900, 0, '�̻�������', 1, 0);
--
delete from HI_Language where ID = 100901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(100901, 0, '����', 'MchtSettleFee', 1, 0);
--
delete from HI_Language where ID = 101000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(101000, 0, '����', 1, 0);
--
delete from HI_Language where ID = 101001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101001, 0, '����', 'Friends', 1, 0);
--
delete from HI_Language where ID = 101002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101002, 0, '����', 'Friends', 1, 0);
--
delete from HI_Language where ID = 101003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(101003, 0, '�Ա�', 'Friends', 1, 0);
