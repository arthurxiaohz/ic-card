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
    bgNotifyUrl nvarchar (256)  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--
