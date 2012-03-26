--menu

--系统管理-》应用配置
INSERT INTO `hi_appsetting` (`id`,`version`,`appGroup`,`appName`,`appValue`,`description`,`creator`) VALUES 
 (2,1,'CONSTANTS','ORG_MEMBER','3','',1),
 (3,2,'CONSTANTS','ROLE_MEMBER','3','',1),
 (4,2,'CONSTANTS','ORG_MERCHANT','2','',1),
 (5,2,'CONSTANTS','ROLE_MERCHANT','2','',1),
 (6,2,'BACKTOPLURL','ALIPAY','http://localhost:8080/member/AlipayNotifyServlet','支付宝返回平台地址',1),
 (7,2,'SENDTOBANKURL','ALIPAY','http://localhost:8080/NewTxService/BankTxControl','请求到支付宝地址',1);
 
--部门
INSERT INTO `hi_org` (`id`,`version`,`orgName`,`orgNum`,`manager`,`parentOrg`,`address`,`description`,`creator`,`deleted`) VALUES 
 (1,1,'BM','',NULL,NULL,'','',1,0),
 (2,1,'Merchant','',NULL,NULL,'','',1,0),
 (3,1,'Member','',NULL,NULL,'','',1,0);
 
--权限
INSERT INTO `hi_authority` (`id`,`version`,`authorityName`,`displayRef`,`propertedResource`,`description`,`authorityType`,`menuLink`) VALUES 
 (600605,1,'FUND_REPORT_DOWNLOAD','资金划付报表查询下载','资金划付报表查询下载','资金划付报表查询下载',NULL,500900),
 (600606,1,'SETTLE','结算','结算','结算',NULL,500700);
 
--角色
INSERT INTO `hi_role` (`id`,`version`,`roleName`,`displayRef`,`description`,`creator`) VALUES 
 (1,1,'role_bm_admin','运营管理员角色','运营管理员角色',1),
 (2,2,'role_merchant','通用商户管理员角色','通用商户管理员角色',1),
 (3,2,'role_member','通用会员角色','通用会员角色',1);
 
--角色权限
 
--资金划付报表（通过页面功能，编辑修改，重新上传附件即可）
INSERT INTO `hi_excelreportdesign` (`id`,`version`,`reportName`,`reportNum`,`template`,`createDate`,`enabled`,`actionName`,`description`,`creator`) VALUES 
 (1,4,'资金划付报表查询下载','0001','upload/report/20120311/1331406417586.xls','2012-03-01 00:00:00',3200,'cn.net.iccard.bm.report.action.FundReportAction','资金划付报表查询下载',1);

--积分规则
INSERT INTO `tbl_mb_point_rule` (`id`,`version`,`tblMbInfo`,`tblMchtInfo`,`mchtType`,`startDatetime`,`endDatetime`,`minAmount`,`maxAmount`,`pointRuleType`,`ruleValue`,`createdDateTime`,`lastUpdatedDatetime`,`lastUpdatedBy`,`creator`) VALUES 
 (1,1,NULL,NULL,NULL,'2012-03-01 00:00:00','2012-03-31 00:00:00','0','100000000000',101501,'20.00','2012-03-11 02:16:06','2012-03-16 00:00:00',NULL,1);