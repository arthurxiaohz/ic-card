
delete from HiMenu where ID = 12000;
/---
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(12000, 0, 'report', '报表管理', '报表管理', 0, 9999, 0);
/---

delete from MenuLink where ID = 12000;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(12000, 0, '/excelReportDesignList.action', 'Excel报表设计', 'Excel报表设计', 12000, 9999, 12000, 0, 0);
/---
delete from MenuLink where ID = 12100;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(12100, 0, '/excelSheetList.action', '工作表', '工作表', 12100, 9999, 12000, 0, 0);
/---
delete from MenuLink where ID = 12200;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(12200, 0, '/excelCellList.action', '单元格', '单元格', 12200, 9999, 12000, 0, 0);
/---

delete from HI_Authority where ID = 12000;
/---
delete from HI_Authority where ID = 12001;
/---
delete from HI_Authority where ID = 12002;
/---
delete from HI_Authority where ID = 12003;
/---
delete from HI_Authority where ID = 12004;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12000, 0, 'EXCELREPORTDESIGN_LIST', 'report.ExcelReportDesignList', '', 'Excel报表设计查询', 1, 12000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12001, 0, 'EXCELREPORTDESIGN_VIEW', 'report.ExcelReportDesignView', '', 'Excel报表设计查看', 2, 12000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12002, 0, 'EXCELREPORTDESIGN_SAVE', 'report.ExcelReportDesignSave', '', 'Excel报表设计保存', 3, 12000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12003, 0, 'EXCELREPORTDESIGN_DEL', 'report.ExcelReportDesignDel', '', 'Excel报表设计删除', 4, 12000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12004, 0, 'EXCELREPORTDESIGN_LOOKUP', 'report.ExcelReportDesignLookup', '', 'Excel报表设计带回', 1, 12000);
/---

delete from HI_Authority where ID = 12100;
/---
delete from HI_Authority where ID = 12101;
/---
delete from HI_Authority where ID = 12102;
/---
delete from HI_Authority where ID = 12103;
/---
delete from HI_Authority where ID = 12104;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12100, 0, 'EXCELSHEET_LIST', 'report.ExcelSheetList', '', '工作表查询', 1, 12100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12101, 0, 'EXCELSHEET_VIEW', 'report.ExcelSheetView', '', '工作表查看', 2, 12100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12102, 0, 'EXCELSHEET_SAVE', 'report.ExcelSheetSave', '', '工作表保存', 3, 12100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12103, 0, 'EXCELSHEET_DEL', 'report.ExcelSheetDel', '', '工作表删除', 4, 12100);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12104, 0, 'EXCELSHEET_LOOKUP', 'report.ExcelSheetLookup', '', '工作表带回', 1, 12100);
/---

delete from HI_Authority where ID = 12200;
/---
delete from HI_Authority where ID = 12201;
/---
delete from HI_Authority where ID = 12202;
/---
delete from HI_Authority where ID = 12203;
/---
delete from HI_Authority where ID = 12204;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12200, 0, 'EXCELCELL_LIST', 'report.ExcelCellList', '', '单元格查询', 1, 12200);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12201, 0, 'EXCELCELL_VIEW', 'report.ExcelCellView', '', '单元格查看', 2, 12200);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12202, 0, 'EXCELCELL_SAVE', 'report.ExcelCellSave', '', '单元格保存', 3, 12200);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12203, 0, 'EXCELCELL_DEL', 'report.ExcelCellDel', '', '单元格删除', 4, 12200);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(12204, 0, 'EXCELCELL_LOOKUP', 'report.ExcelCellLookup', '', '单元格带回', 1, 12200);
/---


delete from HI_PrivilegeResource where ID = 12000;
/---
delete from HI_PrivilegeResource where ID = 12001;
/---
delete from HI_PrivilegeResource where ID = 12002;
/---
delete from HI_PrivilegeResource where ID = 12003;
/---
delete from HI_PrivilegeResource where ID = 12004;
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(12000, 0, 'EXCELREPORTDESIGN_LIST', '/excelReportDesignList.action', 'org.hi.base.report.excel.service.ExcelReportDesignManager.getSecurityExcelReportDesignList', 'EXCELREPORTDESIGN_LOOKUP');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12001, 0, 'EXCELREPORTDESIGN_VIEW', '/excelReportDesignView.action', 'org.hi.base.report.excel.service.ExcelReportDesignManager.getSecurityExcelReportDesignById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12002, 0, 'EXCELREPORTDESIGN_SAVE', '/excelReportDesignSave.action', 'org.hi.base.report.excel.service.ExcelReportDesignManager.saveSecurityExcelReportDesign');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12003, 0, 'EXCELREPORTDESIGN_DEL', '/excelReportDesignRemove.action', 'org.hi.base.report.excel.service.ExcelReportDesignManager.removeSecurityExcelReportDesignById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(12004, 0, 'EXCELREPORTDESIGN_LOOKUP', '/excelReportDesignLookup.action');
/---

delete from HI_PrivilegeResource where ID = 12100;
/---
delete from HI_PrivilegeResource where ID = 12101;
/---
delete from HI_PrivilegeResource where ID = 12102;
/---
delete from HI_PrivilegeResource where ID = 12103;
/---
delete from HI_PrivilegeResource where ID = 12104;
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(12100, 0, 'EXCELSHEET_LIST', '/excelSheetList.action', 'org.hi.base.report.excel.service.ExcelSheetManager.getSecurityExcelSheetList', 'EXCELSHEET_LOOKUP');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12101, 0, 'EXCELSHEET_VIEW', '/excelSheetView.action', 'org.hi.base.report.excel.service.ExcelSheetManager.getSecurityExcelSheetById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12102, 0, 'EXCELSHEET_SAVE', '/excelSheetSave.action', 'org.hi.base.report.excel.service.ExcelSheetManager.saveSecurityExcelSheet');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12103, 0, 'EXCELSHEET_DEL', '/excelSheetRemove.action', 'org.hi.base.report.excel.service.ExcelSheetManager.removeSecurityExcelSheetById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(12104, 0, 'EXCELSHEET_LOOKUP', '/excelSheetLookup.action');
/---

delete from HI_PrivilegeResource where ID = 12200;
/---
delete from HI_PrivilegeResource where ID = 12201;
/---
delete from HI_PrivilegeResource where ID = 12202;
/---
delete from HI_PrivilegeResource where ID = 12203;
/---
delete from HI_PrivilegeResource where ID = 12204;
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(12200, 0, 'EXCELCELL_LIST', '/excelCellList.action', 'org.hi.base.report.excel.service.ExcelCellManager.getSecurityExcelCellList', 'EXCELCELL_LOOKUP');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12201, 0, 'EXCELCELL_VIEW', '/excelCellView.action', 'org.hi.base.report.excel.service.ExcelCellManager.getSecurityExcelCellById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12202, 0, 'EXCELCELL_SAVE', '/excelCellSave.action', 'org.hi.base.report.excel.service.ExcelCellManager.saveSecurityExcelCell');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(12203, 0, 'EXCELCELL_DEL', '/excelCellRemove.action', 'org.hi.base.report.excel.service.ExcelCellManager.removeSecurityExcelCellById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(12204, 0, 'EXCELCELL_LOOKUP', '/excelCellLookup.action');
/---


delete from Enumeration where ID = 12300;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(12300, 0, 'reportDataType', '数据类型', '数据类型', 0, 0);
/---
delete from Enumeration where ID = 12400;
/---
insert into Enumeration(ID, version, enName, displayRef, description,enumerationType, creator) values(12400, 0, 'stretchingType', '伸展方式', '伸展方式', 0, 0);
/---

delete from EnumerationValue where ID = 12300;
/---
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(12300, 0, 'Element', '元素', '元素', 12300, 0);
/---
delete from EnumerationValue where ID = 12301;
/---
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(12301, 0, 'Collection', '集合', '集合', 12300, 0);
/---
delete from EnumerationValue where ID = 12400;
/---
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(12400, 0, 'Vertical', '纵向', '纵向', 12400, 0);
/---
delete from EnumerationValue where ID = 12401;
/---
insert into EnumerationValue(ID, version, valueName, displayRef, description, enumeration, creator) values(12401, 0, 'Horizontal', '横向', '横向', 12400, 0);
/---

/---
delete from HI_Language where ID = 12000;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(12000, 0, 'Excel报表设计', 1, 0);
/---
delete from HI_Language where ID = 12001;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12001, 0, '报表名称', 'ExcelReportDesign', 1, 0);
/---
delete from HI_Language where ID = 12002;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12002, 0, '报表编号', 'ExcelReportDesign', 1, 0);
/---
delete from HI_Language where ID = 12003;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12003, 0, '创建时间', 'ExcelReportDesign', 1, 0);
/---
delete from HI_Language where ID = 12004;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12004, 0, '激活', 'ExcelReportDesign', 1, 0);
/---
delete from HI_Language where ID = 12005;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12005, 0, '描述', 'ExcelReportDesign', 1, 0);
/---
delete from HI_Language where ID = 12100;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(12100, 0, '工作表', 1, 0);
/---
delete from HI_Language where ID = 12101;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12101, 0, '工作表名称', 'ExcelSheet', 1, 0);
/---
delete from HI_Language where ID = 12102;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12102, 0, '序列', 'ExcelSheet', 1, 0);
/---
delete from HI_Language where ID = 12103;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12103, 0, '描述', 'ExcelSheet', 1, 0);
/---
delete from HI_Language where ID = 12200;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(12200, 0, '单元格', 1, 0);
/---
delete from HI_Language where ID = 12201;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12201, 0, '列', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12202;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12202, 0, '行', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12203;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12203, 0, '变量名', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12204;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12204, 0, '常量', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12205;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12205, 0, '枚举类型', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12206;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12206, 0, '数据类型', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12207;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12207, 0, '伸展方式', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12208;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12208, 0, '条件', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12209;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12209, 0, '描述', 'ExcelCell', 1, 0);
/---
delete from HI_Language where ID = 12300;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(12300, 0, '数据类型', 1, 0);
/---
delete from HI_Language where ID = 12301;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12301, 0, '元素', 'reportDataType', 1, 0);
/---
delete from HI_Language where ID = 12302;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12302, 0, '集合', 'reportDataType', 1, 0);
/---
delete from HI_Language where ID = 12400;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(12400, 0, '伸展方式', 1, 0);
/---
delete from HI_Language where ID = 12401;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12401, 0, '纵向', 'stretchingType', 1, 0);
/---
delete from HI_Language where ID = 12402;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(12402, 0, '横向', 'stretchingType', 1, 0);
