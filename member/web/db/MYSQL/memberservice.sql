DROP TABLE IF EXISTS Tbl_Mb_Info;
--
CREATE TABLE Tbl_Mb_Info (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plNo nvarchar (18) NOT NULL,
    userName nvarchar (100) NOT NULL,
    certificateTypeId nvarchar (1)  NULL,
    certificateNo nvarchar (50)  NULL,
    realName nvarchar (30) NOT NULL,
    sex nvarchar (1) NOT NULL,
    address nvarchar (256) NOT NULL,
    zipCode nvarchar (6) NOT NULL,
    mobile nvarchar (30) NOT NULL,
    phone nvarchar (50) NOT NULL,
    email nvarchar (90) NOT NULL,
    password nvarchar (50) NOT NULL,
    cardNo nvarchar (30) NOT NULL,
    realNameStatus nvarchar (1) NOT NULL,
    realNameTime nvarchar (14) NOT NULL,
    registerTime nvarchar (14) NOT NULL,
    registerWay nvarchar (1) NOT NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy nvarchar (30) NOT NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Recharge_Order;
--
CREATE TABLE Tbl_Mb_Recharge_Order (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plTxTraceNo nvarchar (20) NOT NULL,
    plNo nvarchar (18)  NULL,
    accountType nvarchar (2)  NULL,
    accountNo nvarchar (20)  NULL,
    pan nvarchar (30)  NULL,
    chinfo nvarchar (80)  NULL,
    txTypeId nvarchar (4)  NULL,
    mchtTxTime nvarchar (14)  NULL,
    txAmount int   NULL,
    txIp nvarchar (100)  NULL,
    plTxTime nvarchar (90)  NULL,
    txStatus nvarchar (1)  NULL,
    errorCode nvarchar (10)  NULL,
    errorMsg nvarchar (1024)  NULL,
    settleBatchNo nvarchar (20)  NULL,
    settleStatus nvarchar (1) NOT NULL,
    settleDate nvarchar (8)  NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy nvarchar (30)  NULL,
    bankTxStatus nvarchar (1)  NULL,
    checkBatchNo nvarchar (20)  NULL,
    checkStatus nvarchar (1)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Transaction_Request;
--
CREATE TABLE Tbl_Mb_Transaction_Request (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    requestId nvarchar (20) NOT NULL,
    trancode nvarchar (4)  NULL,
    mchtNo nvarchar (18)  NULL,
    amount int   NULL,
    trxTime nvarchar (14)  NULL,
    txStatus nvarchar (1)  NULL,
    msgext nvarchar (30)  NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy nvarchar (30)  NULL,
    pan nvarchar (19)  NULL,
    chinfo nvarchar (80)  NULL,
    plTxTraceNo nvarchar (20)  NULL,
    currencyType nvarchar (3)  NULL,
    accountType nvarchar (2)  NULL,
    accountNo nvarchar (20)  NULL,
    plTxTime nvarchar (30)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Transaction_Response;
--
CREATE TABLE Tbl_Mb_Transaction_Response (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    responseId nvarchar (20) NOT NULL,
    ordedId nvarchar (50)  NULL,
    orgId int   NULL,
    orgOrdedId nvarchar (1)  NULL,
    amount int   NULL,
    context nvarchar (1024)  NULL,
    state int   NULL,
    sourceIp nvarchar (100)  NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy nvarchar (30)  NULL,
    createdDatetime datetime   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

