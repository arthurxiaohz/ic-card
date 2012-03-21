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