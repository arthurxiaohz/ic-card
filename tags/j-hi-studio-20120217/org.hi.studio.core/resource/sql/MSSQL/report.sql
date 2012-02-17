if exists (select * from sysobjects where id = object_id(N'HI_ExcelReportDesign') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_ExcelReportDesign
--
CREATE TABLE HI_ExcelReportDesign (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    reportName nvarchar (20) NOT NULL,
    reportNum nvarchar (10) NOT NULL,
    template nvarchar (100)  NULL,
    createDate datetime   NULL,
    enabled int   NULL,
    actionName nvarchar (100) NOT NULL,
    description nvarchar (200)  NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'HI_ExcelSheet') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_ExcelSheet
--
CREATE TABLE HI_ExcelSheet (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    excelReportDesign int  NULL,
    sheetName nvarchar (50) NOT NULL,
    sequence decimal (18,2)  NULL,
    description nvarchar (200)  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'HI_ExcelCell') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_ExcelCell
--
CREATE TABLE HI_ExcelCell (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    excelSheet int  NULL,
    cellColumn nvarchar (10) NOT NULL,
    cellRow int  NOT NULL,
    variableName nvarchar (100)  NULL,
    constant nvarchar (100)  NULL,
    isEnumeration int   NULL,
    reportDataType int   NULL,
    stretchingType int   NULL,
    conditionCell nvarchar (500)  NULL,
    description nvarchar (200)  NULL,
    primary key (id));

--

