DROP TABLE IF EXISTS Tbl_Stl_Organization;
--
CREATE TABLE Tbl_Stl_Organization (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    orgId nvarchar (11) NOT NULL,
    orgType nvarchar (1)  NULL,
    orgName nvarchar (100)  NULL,
    status int   NULL,
    fieldTimes int   NULL,
    extDesc nvarchar (100)  NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Stl_Check_Organization_Control;
--
CREATE TABLE Tbl_Stl_Check_Organization_Control (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    checkBatchId nvarchar (20) NOT NULL,
    orgId nvarchar (11)  NULL,
    orgType nvarchar (1)  NULL,
    checkDate nvarchar (8)  NULL,
    status int   NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    inProcess int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Stl_Check_Detail;
--
CREATE TABLE Tbl_Stl_Check_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    checkBatchId nvarchar (20) NOT NULL,
    orgId nvarchar (11)  NULL,
    orgType nvarchar (1)  NULL,
    checkDate nvarchar (8)  NULL,
    status int   NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    inProcess int   NULL,
    txOrgOrderId nvarchar (20)  NULL,
    txAmount int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Stl_Error_Detail;
--
CREATE TABLE Tbl_Stl_Error_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plTxTraceNo nvarchar (20) NOT NULL,
    amount int   NULL,
    orderCreateDatetime datetime   NULL,
    orgOrderId nvarchar (20)  NULL,
    connectionId int   NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    discrepancyType int   NULL,
    description nvarchar (100)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Stl_Adjust_Detail;
--
CREATE TABLE Tbl_Stl_Adjust_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plTxTraceNo nvarchar (20) NOT NULL,
    orderId nvarchar (20)  NULL,
    status int   NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    description nvarchar (100)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

