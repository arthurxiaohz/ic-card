DROP TABLE IF EXISTS Act_Account;
--
CREATE TABLE Act_Account (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    accountNo nvarchar (22)  NULL,
    accountCatalog int   NULL,
    accountPartyType int   NULL,
    accountParty nvarchar (30)  NULL,
    accountName nvarchar (30)  NULL,
    status int   NULL,
    remark nvarchar (30)  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Act_Account_Balance;
--
CREATE TABLE Tbl_Act_Account_Balance (
    id int NOT NULL ,
    availableBalance int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Act_Account_Detail;
--
CREATE TABLE Tbl_Act_Account_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    actAccount int  NULL,
    voucherType int   NULL,
    voucherNo nvarchar (30)  NULL,
    amount int   NULL,
    debitOrCredit int   NULL,
    balance int   NULL,
    remark nvarchar (30)  NULL,
    expiredDate nvarchar (8)  NULL,
    settleStatus int   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Act_Debit_Credit_Voucher;
--
CREATE TABLE Tbl_Act_Debit_Credit_Voucher (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    voucherNo nvarchar (30)  NULL,
    actAccount int  NULL,
    amount int   NULL,
    debitOrCredit int   NULL,
    bizType int   NULL,
    bizLogId int   NULL,
    remark nvarchar (30)  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Act_Transfer_Voucher;
--
CREATE TABLE Tbl_Act_Transfer_Voucher (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    voucherNo nvarchar (30)  NULL,
    actAccountFrom int  NULL,
    actAccountTo int  NULL,
    amount int   NULL,
    bizType int   NULL,
    bizLogId int   NULL,
    remark nvarchar (30)  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

