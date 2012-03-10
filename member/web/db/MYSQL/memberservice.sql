DROP TABLE IF EXISTS Tbl_Mb_Transaction_Response;
--
CREATE TABLE Tbl_Mb_Transaction_Response (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    ordedId nvarchar (50)  NULL,
    orgId int   NULL,
    orgOrdedId nvarchar (30)  NULL,
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

