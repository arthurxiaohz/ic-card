if exists (select * from sysobjects where id = object_id(N'HI_Org') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_Org
--
CREATE TABLE HI_Org (
    id int IDENTITY (1, 1) NOT NULL ,
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

if exists (select * from sysobjects where id = object_id(N'HI_User') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_User
--
CREATE TABLE HI_User (
    id int IDENTITY (1, 1) NOT NULL ,
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

