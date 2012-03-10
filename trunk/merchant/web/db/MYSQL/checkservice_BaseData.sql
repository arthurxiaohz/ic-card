
delete from HiMenu where ID = 400000;
--
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(400000, 0, 'checkservice', '对账服务', '对账服务', 0, 9999, 0);
--



delete from MenuLink where ID = 400100;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(400100, 0, '/tblStlOrganizationList.action', '发卡行支持表', '发卡行支持表', 400100, 9999, 400000, 0, 0);
--
delete from MenuLink where ID = 400300;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(400300, 0, '/tblStlCheckOrganizationControlList.action', '对账任务控制表', '对账任务控制表', 400300, 9999, 400000, 0, 0);
--
delete from MenuLink where ID = 400600;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(400600, 0, '/tblStlCheckDetailList.action', '对账明细记录表', '对账明细记录表', 400600, 9999, 400000, 0, 0);
--
delete from MenuLink where ID = 400800;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(400800, 0, '/tblStlErrorDetailList.action', '差错明细表', '差错明细表', 400800, 9999, 400000, 0, 0);
--
delete from MenuLink where ID = 401000;
--
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(401000, 0, '/tblStlAdjustDetailList.action', '调账申请表', '调账申请表', 401000, 9999, 400000, 0, 0);
--



delete from HI_Authority where ID = 400100;
--
delete from HI_Authority where ID = 400101;
--
delete from HI_Authority where ID = 400102;
--
delete from HI_Authority where ID = 400103;
--
delete from HI_Authority where ID = 400104;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400100, 0, 'TBLSTLORGANIZATION_LIST', 'checkservice.TblStlOrganizationList', '', '发卡行支持表查询', 1, 400100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400101, 0, 'TBLSTLORGANIZATION_VIEW', 'checkservice.TblStlOrganizationView', '', '发卡行支持表查看', 2, 400100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400102, 0, 'TBLSTLORGANIZATION_SAVE', 'checkservice.TblStlOrganizationSave', '', '发卡行支持表保存', 3, 400100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400103, 0, 'TBLSTLORGANIZATION_DEL', 'checkservice.TblStlOrganizationDel', '', '发卡行支持表删除', 4, 400100);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400104, 0, 'TBLSTLORGANIZATION_LOOKUP', 'checkservice.TblStlOrganizationLookup', '', '发卡行支持表带回', 1, 400100);
--
delete from HI_Authority where ID = 400300;
--
delete from HI_Authority where ID = 400301;
--
delete from HI_Authority where ID = 400302;
--
delete from HI_Authority where ID = 400303;
--
delete from HI_Authority where ID = 400304;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400300, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_LIST', 'checkservice.TblStlCheckOrganizationControlList', '', '对账任务控制表查询', 1, 400300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400301, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_VIEW', 'checkservice.TblStlCheckOrganizationControlView', '', '对账任务控制表查看', 2, 400300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400302, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_SAVE', 'checkservice.TblStlCheckOrganizationControlSave', '', '对账任务控制表保存', 3, 400300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400303, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_DEL', 'checkservice.TblStlCheckOrganizationControlDel', '', '对账任务控制表删除', 4, 400300);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400304, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_LOOKUP', 'checkservice.TblStlCheckOrganizationControlLookup', '', '对账任务控制表带回', 1, 400300);
--
delete from HI_Authority where ID = 400600;
--
delete from HI_Authority where ID = 400601;
--
delete from HI_Authority where ID = 400602;
--
delete from HI_Authority where ID = 400603;
--
delete from HI_Authority where ID = 400604;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400600, 0, 'TBLSTLCHECKDETAIL_LIST', 'checkservice.TblStlCheckDetailList', '', '对账明细记录表查询', 1, 400600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400601, 0, 'TBLSTLCHECKDETAIL_VIEW', 'checkservice.TblStlCheckDetailView', '', '对账明细记录表查看', 2, 400600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400602, 0, 'TBLSTLCHECKDETAIL_SAVE', 'checkservice.TblStlCheckDetailSave', '', '对账明细记录表保存', 3, 400600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400603, 0, 'TBLSTLCHECKDETAIL_DEL', 'checkservice.TblStlCheckDetailDel', '', '对账明细记录表删除', 4, 400600);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400604, 0, 'TBLSTLCHECKDETAIL_LOOKUP', 'checkservice.TblStlCheckDetailLookup', '', '对账明细记录表带回', 1, 400600);
--
delete from HI_Authority where ID = 400800;
--
delete from HI_Authority where ID = 400801;
--
delete from HI_Authority where ID = 400802;
--
delete from HI_Authority where ID = 400803;
--
delete from HI_Authority where ID = 400804;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400800, 0, 'TBLSTLERRORDETAIL_LIST', 'checkservice.TblStlErrorDetailList', '', '差错明细表查询', 1, 400800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400801, 0, 'TBLSTLERRORDETAIL_VIEW', 'checkservice.TblStlErrorDetailView', '', '差错明细表查看', 2, 400800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400802, 0, 'TBLSTLERRORDETAIL_SAVE', 'checkservice.TblStlErrorDetailSave', '', '差错明细表保存', 3, 400800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400803, 0, 'TBLSTLERRORDETAIL_DEL', 'checkservice.TblStlErrorDetailDel', '', '差错明细表删除', 4, 400800);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(400804, 0, 'TBLSTLERRORDETAIL_LOOKUP', 'checkservice.TblStlErrorDetailLookup', '', '差错明细表带回', 1, 400800);
--
delete from HI_Authority where ID = 401000;
--
delete from HI_Authority where ID = 401001;
--
delete from HI_Authority where ID = 401002;
--
delete from HI_Authority where ID = 401003;
--
delete from HI_Authority where ID = 401004;
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(401000, 0, 'TBLSTLADJUSTDETAIL_LIST', 'checkservice.TblStlAdjustDetailList', '', '调账申请表查询', 1, 401000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(401001, 0, 'TBLSTLADJUSTDETAIL_VIEW', 'checkservice.TblStlAdjustDetailView', '', '调账申请表查看', 2, 401000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(401002, 0, 'TBLSTLADJUSTDETAIL_SAVE', 'checkservice.TblStlAdjustDetailSave', '', '调账申请表保存', 3, 401000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(401003, 0, 'TBLSTLADJUSTDETAIL_DEL', 'checkservice.TblStlAdjustDetailDel', '', '调账申请表删除', 4, 401000);
--
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(401004, 0, 'TBLSTLADJUSTDETAIL_LOOKUP', 'checkservice.TblStlAdjustDetailLookup', '', '调账申请表带回', 1, 401000);
--

delete from HI_PrivilegeResource where ID = 400100;
--
delete from HI_PrivilegeResource where ID = 400101;
--
delete from HI_PrivilegeResource where ID = 400102;
--
delete from HI_PrivilegeResource where ID = 400103;
--
delete from HI_PrivilegeResource where ID = 400104;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(400100, 0, 'TBLSTLORGANIZATION_LIST', '/tblStlOrganizationList.action', 'cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager.getSecurityTblStlOrganizationList', 'TBLSTLORGANIZATION_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400101, 0, 'TBLSTLORGANIZATION_VIEW', '/tblStlOrganizationView.action', 'cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager.getSecurityTblStlOrganizationById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400102, 0, 'TBLSTLORGANIZATION_SAVE', '/tblStlOrganizationSave.action', 'cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager.saveSecurityTblStlOrganization');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400103, 0, 'TBLSTLORGANIZATION_DEL', '/tblStlOrganizationRemove.action', 'cn.net.iccard.bm.checkservice.service.TblStlOrganizationManager.removeSecurityTblStlOrganizationById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(400104, 0, 'TBLSTLORGANIZATION_LOOKUP', '/tblStlOrganizationLookup.action');
--
delete from HI_PrivilegeResource where ID = 400300;
--
delete from HI_PrivilegeResource where ID = 400301;
--
delete from HI_PrivilegeResource where ID = 400302;
--
delete from HI_PrivilegeResource where ID = 400303;
--
delete from HI_PrivilegeResource where ID = 400304;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(400300, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_LIST', '/tblStlCheckOrganizationControlList.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager.getSecurityTblStlCheckOrganizationControlList', 'TBLSTLCHECKORGANIZATIONCONTROL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400301, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_VIEW', '/tblStlCheckOrganizationControlView.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager.getSecurityTblStlCheckOrganizationControlById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400302, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_SAVE', '/tblStlCheckOrganizationControlSave.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager.saveSecurityTblStlCheckOrganizationControl');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400303, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_DEL', '/tblStlCheckOrganizationControlRemove.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckOrganizationControlManager.removeSecurityTblStlCheckOrganizationControlById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(400304, 0, 'TBLSTLCHECKORGANIZATIONCONTROL_LOOKUP', '/tblStlCheckOrganizationControlLookup.action');
--
delete from HI_PrivilegeResource where ID = 400600;
--
delete from HI_PrivilegeResource where ID = 400601;
--
delete from HI_PrivilegeResource where ID = 400602;
--
delete from HI_PrivilegeResource where ID = 400603;
--
delete from HI_PrivilegeResource where ID = 400604;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(400600, 0, 'TBLSTLCHECKDETAIL_LIST', '/tblStlCheckDetailList.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager.getSecurityTblStlCheckDetailList', 'TBLSTLCHECKDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400601, 0, 'TBLSTLCHECKDETAIL_VIEW', '/tblStlCheckDetailView.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager.getSecurityTblStlCheckDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400602, 0, 'TBLSTLCHECKDETAIL_SAVE', '/tblStlCheckDetailSave.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager.saveSecurityTblStlCheckDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400603, 0, 'TBLSTLCHECKDETAIL_DEL', '/tblStlCheckDetailRemove.action', 'cn.net.iccard.bm.checkservice.service.TblStlCheckDetailManager.removeSecurityTblStlCheckDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(400604, 0, 'TBLSTLCHECKDETAIL_LOOKUP', '/tblStlCheckDetailLookup.action');
--
delete from HI_PrivilegeResource where ID = 400800;
--
delete from HI_PrivilegeResource where ID = 400801;
--
delete from HI_PrivilegeResource where ID = 400802;
--
delete from HI_PrivilegeResource where ID = 400803;
--
delete from HI_PrivilegeResource where ID = 400804;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(400800, 0, 'TBLSTLERRORDETAIL_LIST', '/tblStlErrorDetailList.action', 'cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager.getSecurityTblStlErrorDetailList', 'TBLSTLERRORDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400801, 0, 'TBLSTLERRORDETAIL_VIEW', '/tblStlErrorDetailView.action', 'cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager.getSecurityTblStlErrorDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400802, 0, 'TBLSTLERRORDETAIL_SAVE', '/tblStlErrorDetailSave.action', 'cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager.saveSecurityTblStlErrorDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(400803, 0, 'TBLSTLERRORDETAIL_DEL', '/tblStlErrorDetailRemove.action', 'cn.net.iccard.bm.checkservice.service.TblStlErrorDetailManager.removeSecurityTblStlErrorDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(400804, 0, 'TBLSTLERRORDETAIL_LOOKUP', '/tblStlErrorDetailLookup.action');
--
delete from HI_PrivilegeResource where ID = 401000;
--
delete from HI_PrivilegeResource where ID = 401001;
--
delete from HI_PrivilegeResource where ID = 401002;
--
delete from HI_PrivilegeResource where ID = 401003;
--
delete from HI_PrivilegeResource where ID = 401004;
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(401000, 0, 'TBLSTLADJUSTDETAIL_LIST', '/tblStlAdjustDetailList.action', 'cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager.getSecurityTblStlAdjustDetailList', 'TBLSTLADJUSTDETAIL_LOOKUP');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(401001, 0, 'TBLSTLADJUSTDETAIL_VIEW', '/tblStlAdjustDetailView.action', 'cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager.getSecurityTblStlAdjustDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(401002, 0, 'TBLSTLADJUSTDETAIL_SAVE', '/tblStlAdjustDetailSave.action', 'cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager.saveSecurityTblStlAdjustDetail');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(401003, 0, 'TBLSTLADJUSTDETAIL_DEL', '/tblStlAdjustDetailRemove.action', 'cn.net.iccard.bm.checkservice.service.TblStlAdjustDetailManager.removeSecurityTblStlAdjustDetailById');
--
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(401004, 0, 'TBLSTLADJUSTDETAIL_LOOKUP', '/tblStlAdjustDetailLookup.action');
--



delete from Enumeration where ID = 400200;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(400200, 0, 'status', '可用状态', '可用状态', 0, 0);
--
delete from Enumeration where ID = 400400;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(400400, 0, 'chkStatus', '当前处理状态', '当前处理状态', 0, 0);
--
delete from Enumeration where ID = 400500;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(400500, 0, 'inProcess', '是否正在处理', '是否正在处理', 0, 0);
--
delete from Enumeration where ID = 400700;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(400700, 0, 'detailStatus', '对账明细状态', '对账明细状态', 0, 0);
--
delete from Enumeration where ID = 400900;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(400900, 0, 'discrepancyType', '差错类型', '差错类型', 0, 0);
--
delete from Enumeration where ID = 401100;
--
insert into Enumeration(ID, version, enName, displayRef, description, enumerationType, creator) values(401100, 0, 'adjustStatus', '差错类型', '差错类型', 0, 0);
--



delete from EnumerationValue where ID = 400200;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400200, 0, 'unuse', '不可用', '不可用', '0', 400200, 0);
--
delete from EnumerationValue where ID = 400201;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400201, 0, 'use', '可用', '可用', '1', 400200, 0);
--
delete from EnumerationValue where ID = 400400;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400400, 0, 'uncheck', '未对帐', '未对帐', '0', 400400, 0);
--
delete from EnumerationValue where ID = 400401;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400401, 0, 'check', '已记录明细', '已记录明细', '1', 400400, 0);
--
delete from EnumerationValue where ID = 400402;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400402, 0, 'checkfinished', '已对帐', '已对帐', '2', 400400, 0);
--
delete from EnumerationValue where ID = 400500;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400500, 0, 'unprocess', '空闲', '空闲', '0', 400500, 0);
--
delete from EnumerationValue where ID = 400501;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400501, 0, 'process', '处理中', '处理中', '1', 400500, 0);
--
delete from EnumerationValue where ID = 400700;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400700, 0, 'success', '成功', '成功', '1', 400700, 0);
--
delete from EnumerationValue where ID = 400701;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400701, 0, 'fail', '失败', '失败', '2', 400700, 0);
--
delete from EnumerationValue where ID = 400900;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400900, 0, 'longAmout', '长款', '长款', '1', 400900, 0);
--
delete from EnumerationValue where ID = 400901;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(400901, 0, 'shortAmout', '短款', '短款', '2', 400900, 0);
--
delete from EnumerationValue where ID = 401100;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(401100, 0, 'wait', '提交申请', '提交申请', '1', 401100, 0);
--
delete from EnumerationValue where ID = 401101;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(401101, 0, 'finished', '审核通过', '审核通过', '2', 401100, 0);
--
delete from EnumerationValue where ID = 401102;
--
insert into EnumerationValue(ID, version, valueName, displayRef, description, valueCode, enumeration, creator) values(401102, 0, 'finishedfail', '审核失败', '审核失败', '3', 401100, 0);
--

--
delete from HI_Language where ID = 400100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400100, 0, '发卡行支持表', 1, 0);
--
delete from HI_Language where ID = 400101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400101, 0, '机构代码', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400102, 0, '机构类型', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400103, 0, '机构名称', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400104;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400104, 0, '可用状态', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400105;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400105, 0, '场次数', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400106;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400106, 0, '描述', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400107;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400107, 0, '创建时间', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400108;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400108, 0, '最后修改时间', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400109;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400109, 0, '最后修改人', 'TblStlOrganization', 1, 0);
--
delete from HI_Language where ID = 400200;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400200, 0, '可用状态', 1, 0);
--
delete from HI_Language where ID = 400201;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400201, 0, '不可用', 'status', 1, 0);
--
delete from HI_Language where ID = 400202;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400202, 0, '可用', 'status', 1, 0);
--
delete from HI_Language where ID = 400300;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400300, 0, '对账任务控制表', 1, 0);
--
delete from HI_Language where ID = 400301;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400301, 0, '对账批次号', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400302;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400302, 0, '机构代码', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400303;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400303, 0, '机构类型', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400304;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400304, 0, '对账日期', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400305;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400305, 0, '当前处理状态', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400306;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400306, 0, '创建时间', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400307;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400307, 0, '最后修改时间', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400308;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400308, 0, '最后修改人', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400309;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400309, 0, '是否正在处理', 'TblStlCheckOrganizationControl', 1, 0);
--
delete from HI_Language where ID = 400400;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400400, 0, '当前处理状态', 1, 0);
--
delete from HI_Language where ID = 400401;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400401, 0, '未对帐', 'chkStatus', 1, 0);
--
delete from HI_Language where ID = 400402;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400402, 0, '已记录明细', 'chkStatus', 1, 0);
--
delete from HI_Language where ID = 400403;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400403, 0, '已对帐', 'chkStatus', 1, 0);
--
delete from HI_Language where ID = 400500;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400500, 0, '是否正在处理', 1, 0);
--
delete from HI_Language where ID = 400501;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400501, 0, '空闲', 'inProcess', 1, 0);
--
delete from HI_Language where ID = 400502;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400502, 0, '处理中', 'inProcess', 1, 0);
--
delete from HI_Language where ID = 400600;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400600, 0, '对账明细记录表', 1, 0);
--
delete from HI_Language where ID = 400601;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400601, 0, '对账批次号', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400602;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400602, 0, '机构代码', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400603;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400603, 0, '机构类型', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400604;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400604, 0, '对账日期', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400605;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400605, 0, '状态', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400606;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400606, 0, '创建时间', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400607;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400607, 0, '最后修改时间', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400608;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400608, 0, '最后修改人', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400609;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400609, 0, '是否正在处理', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400610;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400610, 0, '交易机构流水号', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400611;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400611, 0, '交易金额', 'TblStlCheckDetail', 1, 0);
--
delete from HI_Language where ID = 400700;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400700, 0, '对账明细状态', 1, 0);
--
delete from HI_Language where ID = 400701;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400701, 0, '成功', 'detailStatus', 1, 0);
--
delete from HI_Language where ID = 400702;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400702, 0, '失败', 'detailStatus', 1, 0);
--
delete from HI_Language where ID = 400800;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400800, 0, '差错明细表', 1, 0);
--
delete from HI_Language where ID = 400801;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400801, 0, '平台交易流水号', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400802;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400802, 0, '订单金额', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400803;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400803, 0, '订单创建时间', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400804;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400804, 0, '机构订单号', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400805;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400805, 0, '连接id', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400806;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400806, 0, '创建时间', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400807;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400807, 0, '最后修改时间', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400808;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400808, 0, '最后修改人', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400809;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400809, 0, '差错类型', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400810;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400810, 0, '描述', 'TblStlErrorDetail', 1, 0);
--
delete from HI_Language where ID = 400900;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(400900, 0, '差错类型', 1, 0);
--
delete from HI_Language where ID = 400901;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400901, 0, '长款', 'discrepancyType', 1, 0);
--
delete from HI_Language where ID = 400902;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(400902, 0, '短款', 'discrepancyType', 1, 0);
--
delete from HI_Language where ID = 401000;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(401000, 0, '调账申请表', 1, 0);
--
delete from HI_Language where ID = 401001;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401001, 0, '平台交易流水号', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401002;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401002, 0, '网关订单号', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401003;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401003, 0, '状态', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401004;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401004, 0, '创建时间', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401005;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401005, 0, '最后修改时间', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401006;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401006, 0, '最后修改人', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401007;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401007, 0, '描述', 'TblStlAdjustDetail', 1, 0);
--
delete from HI_Language where ID = 401100;
--
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(401100, 0, '差错类型', 1, 0);
--
delete from HI_Language where ID = 401101;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401101, 0, '提交申请', 'adjustStatus', 1, 0);
--
delete from HI_Language where ID = 401102;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401102, 0, '审核通过', 'adjustStatus', 1, 0);
--
delete from HI_Language where ID = 401103;
--
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(401103, 0, '审核失败', 'adjustStatus', 1, 0);
