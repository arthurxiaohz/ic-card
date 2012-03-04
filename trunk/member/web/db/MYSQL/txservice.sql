DROP TABLE IF EXISTS Tbl_Tx_PayMent_Order;
--
CREATE TABLE Tbl_Tx_PayMent_Order (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plTxTraceNo nvarchar (20) NOT NULL,
    memberNO nvarchar (18)  NULL,
    txTypeId nvarchar (4)  NULL,
    mchtNo nvarchar (18)  NULL,
    mchtTxTime nvarchar (14)  NULL,
    lastMchtTxTime nvarchar (14)  NULL,
    mchtTxTraceNo nvarchar (50)  NULL,
    lastMchtTxTraceNo nvarchar (50)  NULL,
    txAmount int   NULL,
    notifyUrl nvarchar (256)  NULL,
    txIp nvarchar (100)  NULL,
    plTxTime nvarchar (14)  NULL,
    txStatus int   NULL,
    voucherNo nvarchar (30)  NULL,
    backVoucherNo nvarchar (30)  NULL,
    useCoupon int   NULL,
    couponMsg nvarchar (300)  NULL,
    resCouponMsg nvarchar (300)  NULL,
    showUrl nvarchar (400)  NULL,
    txBody nvarchar (400)  NULL,
    payerPhone nvarchar (11)  NULL,
    verifyCode nvarchar (10)  NULL,
    confirmCode nvarchar (50)  NULL,
    orderExpireDatetime nvarchar (14)  NULL,
    errorCode nvarchar (10)  NULL,
    errorMsg nvarchar (1000)  NULL,
    settleBatchNo nvarchar (20)  NULL,
    settleStatus int   NULL,
    settleDate nvarchar (8)  NULL,
    feeAmount int   NULL,
    hasCountFee int   NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Tx_Transfer;
--
CREATE TABLE Tbl_Tx_Transfer (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    plTxTraceNo nvarchar (20) NOT NULL,
    memberNO nvarchar (18)  NULL,
    txTypeId nvarchar (4)  NULL,
    mchtNo nvarchar (18)  NULL,
    mchtTxTime nvarchar (14)  NULL,
    mchtTxTraceNo nvarchar (50)  NULL,
    txAmount int   NULL,
    notifyUrl nvarchar (256)  NULL,
    txIp nvarchar (100)  NULL,
    plTxTime nvarchar (14)  NULL,
    txStatus int   NULL,
    voucherNo nvarchar (30)  NULL,
    errorCode nvarchar (10)  NULL,
    errorMsg nvarchar (1000)  NULL,
    settleBatchNo nvarchar (20)  NULL,
    settleStatus int   NULL,
    settleDate nvarchar (8)  NULL,
    feeAmount int   NULL,
    hasCountFee int   NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Tx_Sms_Log;
--
CREATE TABLE Tbl_Tx_Sms_Log (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    senderId nvarchar (15)  NULL,
    seqNo nvarchar (50)  NULL,
    phoneNum nvarchar (11)  NULL,
    phoneMessage nvarchar (512)  NULL,
    status nvarchar (1)  NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDdatetime datetime  NOT NULL,
    lastUpdatedBy int  NOT NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Tx_Transfer_Request;
--
CREATE TABLE Tbl_Tx_Transfer_Request (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    mchtTxTraceNo nvarchar (50) NOT NULL,
    mchtNo nvarchar (18)  NULL,
    amount nvarchar (18)  NULL,
    cardBalance nvarchar (14)  NULL,
    cardSequence int   NULL,
    cardNo nvarchar (50)  NULL,
    mchtTxTime nvarchar (14)  NULL,
    txStatus nvarchar (1)  NULL,
    txTypeId nvarchar (1)  NULL,
    msgext nvarchar (30)  NULL,
    mchtRawMessage nvarchar (3000)  NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Tx_Transfer_Response;
--
CREATE TABLE Tbl_Tx_Transfer_Response (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    responseId nvarchar (20) NOT NULL,
    versionNo nvarchar (100)  NULL,
    signMsg nvarchar (1024)  NULL,
    transferResult nvarchar (1)  NULL,
    plTxTraceNo nvarchar (20)  NULL,
    merchantOrderNo nvarchar (50)  NULL,
    transferAmount int   NULL,
    txTypeId nvarchar (1)  NULL,
    payDatetime nvarchar (14)  NULL,
    ext1 nvarchar (3000)  NULL,
    ext2 datetime   NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    errorCode nvarchar (10)  NULL,
    context nvarchar (3000)  NULL,
    responseContent nvarchar (30)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Tx_PayMent_Request;
--
CREATE TABLE Tbl_Tx_PayMent_Request (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    mchtTxTraceNo nvarchar (50) NOT NULL,
    lastMchtTxTraceNo nvarchar (50)  NULL,
    mchtNo nvarchar (18)  NULL,
    amount nvarchar (18)  NULL,
    lastMchtTxTime nvarchar (14)  NULL,
    mchtTxTime nvarchar (14)  NULL,
    txStatus nvarchar (1)  NULL,
    txTypeId nvarchar (1)  NULL,
    msgext nvarchar (30)  NULL,
    mchtRawMessage nvarchar (3000)  NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Tbl_Tx_PayMent_Response;
--
CREATE TABLE Tbl_Tx_PayMent_Response (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    responseId nvarchar (20) NOT NULL,
    versionNo nvarchar (100)  NULL,
    signMsg nvarchar (1024)  NULL,
    payResult nvarchar (1)  NULL,
    mchtNo nvarchar (18)  NULL,
    merchantOrderNo nvarchar (50)  NULL,
    orderAmount int   NULL,
    txTypeId nvarchar (1)  NULL,
    payAmount int   NULL,
    payDatetime nvarchar (14)  NULL,
    ext1 nvarchar (3000)  NULL,
    ext2 datetime   NULL,
    errorCode nvarchar (10)  NULL,
    context nvarchar (3000)  NULL,
    responseContent nvarchar (30)  NULL,
    createdDatetime datetime   NULL,
    lastUpdatedDatetime datetime   NULL,
    lastUpdatedBy int   NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

