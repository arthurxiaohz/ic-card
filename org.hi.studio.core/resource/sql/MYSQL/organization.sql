DROP TABLE IF EXISTS HI_Org;
--
CREATE TABLE HI_Org (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    orgName nvarchar (50) NOT NULL,
    orgNum nvarchar (30)  NULL,
    manager int  NULL,
    parentOrg int  NULL,
    address nvarchar (100)  NULL,
    description nvarchar (500)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_User;
--
CREATE TABLE HI_User (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    userName nvarchar (30) NOT NULL,
    password nvarchar (100)  NULL,
    country int   NULL,
    timeZone int   NULL,
    accountEnabled int   NULL,
    accountLocked int   NULL,
    expiredDate datetime   NULL,
    credentialsExpired int   NULL,
    fullName nvarchar (30) NOT NULL,
    org int  NULL,
    gender int   NULL,
    address nvarchar (200)  NULL,
    phone nvarchar (50)  NULL,
    mobile nvarchar (50)  NULL,
    zip nvarchar (30)  NULL,
    SSN nvarchar (50)  NULL,
    mail nvarchar (100)  NULL,
    userMgrType int   NULL,
    notifyMode nvarchar (200)  NULL,
    description nvarchar (500)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

