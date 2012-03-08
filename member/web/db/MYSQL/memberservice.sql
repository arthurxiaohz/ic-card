DROP TABLE IF EXISTS Tbl_Mb_Info;
--
CREATE TABLE Tbl_Mb_Info (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    userName nvarchar (30) NOT NULL,
    certificateTypeId nvarchar (1)  NULL,
    cardNo nvarchar (30) NOT NULL,
    realNameStatus nvarchar (1) NOT NULL,
    realNameTime nvarchar (14) NOT NULL,
    registerTime nvarchar (14) NOT NULL,
    registerWay nvarchar (1) NOT NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NULL,
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
    userName nvarchar (30)  NULL,
    accountType nvarchar (2)  NULL,
    accountNo nvarchar (20)  NULL,
    pan nvarchar (30)  NULL,
    chinfo nvarchar (80)  NULL,
    txTypeId nvarchar (4)  NULL,
    mchtTxTime nvarchar (14)  NULL,
    txAmount int   NULL,
    txIp nvarchar (100)  NULL,
    plTxTime nvarchar (90)  NULL,
    txStatus int   NULL,
    errorCode nvarchar (10)  NULL,
    errorMsg nvarchar (1024)  NULL,
    settleBatchNo nvarchar (20)  NULL,
    settleStatus int  NOT NULL,
    settleDate nvarchar (8)  NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    bankTxStatus int   NULL,
    checkBatchNo nvarchar (20)  NULL,
    checkStatus int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Transaction_Request;
--
CREATE TABLE Tbl_Mb_Transaction_Request (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    trancode nvarchar (4)  NULL,
    mchtNo nvarchar (18)  NULL,
    amount int   NULL,
    trxTime nvarchar (14)  NULL,
    txStatus nvarchar (1)  NULL,
    msgext nvarchar (30)  NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    pan nvarchar (19)  NULL,
    chinfo nvarchar (80)  NULL,
    plTxTraceNo nvarchar (20)  NULL,
    currencyType nvarchar (3)  NULL,
    accountType nvarchar (2)  NULL,
    accountNo nvarchar (20)  NULL,
    plTxTime nvarchar (30)  NULL,
    orderId nvarchar (50)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Transaction_Response;
--
CREATE TABLE Tbl_Mb_Transaction_Response (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    ordedId nvarchar (50)  NULL,
    orgId int   NULL,
    orgOrdedId nvarchar (1)  NULL,
    amount int   NULL,
    context nvarchar (1024)  NULL,
    state int   NULL,
    sourceIp nvarchar (100)  NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    createdDatetime datetime   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Point_Exchange_Rule;
--
CREATE TABLE Tbl_Mb_Point_Exchange_Rule (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    point int   NULL,
    amount int   NULL,
    startDatetime datetime   NULL,
    endDatetime datetime   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Coupon;
--
CREATE TABLE Tbl_Mb_Coupon (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    couponType nvarchar (30)  NULL,
    amount int   NULL,
    balance int   NULL,
    couponStatus int   NULL,
    startDatetime datetime   NULL,
    endDatetime datetime   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    tblMbInfo int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Point_Rule;
--
CREATE TABLE Tbl_Mb_Point_Rule (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMbInfo int  NULL,
    tblMchtInfo int  NULL,
    mchtType int   NULL,
    startDatetime datetime   NULL,
    endDatetime datetime   NULL,
    minAmount nvarchar (30)  NULL,
    maxAmount nvarchar (30)  NULL,
    pointRuleType int   NULL,
    ruleValue decimal (18,2)  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Coupon_Rule;
--
CREATE TABLE Tbl_Mb_Coupon_Rule (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMbInfo int  NULL,
    tblMchtInfo int  NULL,
    mchtType int   NULL,
    merchandiseCategory int   NULL,
    merchandiseNo nvarchar (30)  NULL,
    couponType int   NULL,
    amount int   NULL,
    startDatetime datetime   NULL,
    endDatetime datetime   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Point;
--
CREATE TABLE Tbl_Mb_Point (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMbInfo int  NULL,
    balance int   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Point_Detail;
--
CREATE TABLE Tbl_Mb_Point_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    point int   NULL,
    pointTxType int   NULL,
    voucherNo int   NULL,
    balance int   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    tblMbInfo int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Mb_Coupon_Detail;
--
CREATE TABLE Tbl_Mb_Coupon_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    amount nvarchar (30)  NULL,
    plTxTraceNo nvarchar (30)  NULL,
    balance nvarchar (30)  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    tblMbCoupon int  NULL,
    creator int  NULL,
    primary key (id));
--

