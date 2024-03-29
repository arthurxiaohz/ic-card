DROP TABLE IF EXISTS Tbl_Stl_Cleaning_Detail;
--
CREATE TABLE Tbl_Stl_Cleaning_Detail (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plTxTraceNo nvarchar (20) NOT NULL,
    mchtOrderId nvarchar (50)  NULL,
    createdDatetime datetime  NOT NULL,
    lastUpdatedDatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    orderAmount int   NULL,
    transTime nvarchar (14)  NULL,
    refundOrderId nvarchar (30)  NULL,
    refundOrderAmt int   NULL,
    refundAmt int   NULL,
    refundFee int   NULL,
    mchtSettleAmount int   NULL,
    reMark nvarchar (100)  NULL,
    transType nvarchar (30)  NULL,
    userName nvarchar (30)  NULL,
    balance int   NULL,
    backBalance int   NULL,
    mchtNo nvarchar (18)  NULL,
    mchtName nvarchar (30)  NULL,
    cleanStatus int   NULL,
    payAmount int   NULL,
    fee int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Stl_Settle_Apply;
--
CREATE TABLE Tbl_Stl_Settle_Apply (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    tblMchtInfo int  NULL,
    availableBalance int   NULL,
    amount int   NULL,
    settleApplyStatus int   NULL,
    auditOpinion text   NULL,
    remark nvarchar (200)  NULL,
    tblStlSettleBatch int  NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Stl_Settle_Batch;
--
CREATE TABLE Tbl_Stl_Settle_Batch (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    settleBatchNo nvarchar (11)  NULL,
    settleDate datetime   NULL,
    totalCount int   NULL,
    totalAmount int   NULL,
    settleBatchStatus int   NULL,
    remark text   NULL,
    createdDateTime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int  NULL,
    creator int  NULL,
    primary key (id));
--

