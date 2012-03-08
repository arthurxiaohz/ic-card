DROP TABLE IF EXISTS Tbl_Mcht_Info;
--
CREATE TABLE Tbl_Mcht_Info (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    mchtNo nvarchar (18) NOT NULL,
    mchtName nvarchar (30)  NULL,
    status int   NULL,
    mchtType int   NULL,
    landline nvarchar (30)  NULL,
    mobile nvarchar (30)  NULL,
    fax nvarchar (30)  NULL,
    address nvarchar (30)  NULL,
    feeFlag int   NULL,
    days int   NULL,
    bankAccountNo nvarchar (30)  NULL,
    bankAccountName nvarchar (30)  NULL,
    bankNo nvarchar (30)  NULL,
    bankName nvarchar (30)  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mcht_Payment_Config;
--
CREATE TABLE Tbl_Mcht_Payment_Config (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMchtInfo int  NULL,
    authorized int   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mcht_Fee_Config;
--
CREATE TABLE Tbl_Mcht_Fee_Config (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMchtInfo int  NULL,
    mchtFeeType int   NULL,
    ruleValue decimal (18,2)  NULL,
    minVal int   NULL,
    maxVal int   NULL,
    isFeeReturn int   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mcht_Certificate;
--
CREATE TABLE Tbl_Mcht_Certificate (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMchtInfo int  NULL,
    certSn nvarchar (100)  NULL,
    issuerCertDn nvarchar (30)  NULL,
    certDn nvarchar (30)  NULL,
    startTime nvarchar (30)  NULL,
    endTime nvarchar (30)  NULL,
    certContent text   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mcht_Settle_Cycle_Config;
--
CREATE TABLE Tbl_Mcht_Settle_Cycle_Config (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    settleCycleType int   NULL,
    ruleValue int   NULL,
    threshold int   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

