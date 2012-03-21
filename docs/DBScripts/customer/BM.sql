--BM menu

--BM-》系统管理-》应用配置
INSERT INTO `hi_appsetting` (`id`,`version`,`appGroup`,`appName`,`appValue`,`description`,`creator`) VALUES 
 (2,1,'CONSTANTS','ORG_MEMBER','3','',1),
 (3,2,'CONSTANTS','ROLE_MEMBER','3','',1),
 (4,2,'CONSTANTS','ORG_MERCHANT','2','',1),
 (5,2,'CONSTANTS','ROLE_MERCHANT','2','',1);
 
--BM-》部门
INSERT INTO `hi_org` (`id`,`version`,`orgName`,`orgNum`,`manager`,`parentOrg`,`address`,`description`,`creator`,`deleted`) VALUES 
 (1,1,'BM','',NULL,NULL,'','',1,0),
 (2,1,'Merchant','',NULL,NULL,'','',1,0),
 (3,1,'Member','',NULL,NULL,'','',1,0);
 
--BM-》角色
INSERT INTO `hi_role` (`id`,`version`,`roleName`,`displayRef`,`description`,`creator`) VALUES 
 (2,2,'role_merchant','通用商户管理员角色','通用商户管理员角色',1),
 (3,2,'role_member','通用会员角色','通用会员角色',1),
 (4,1,'role_bm_admin','运营管理员角色','运营管理员角色',1);