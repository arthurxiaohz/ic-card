DROP TABLE IF EXISTS HI_ExcelReportDesign;
--
CREATE TABLE HI_ExcelReportDesign (
    id int auto_increment NOT NULL ,
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

DROP TABLE IF EXISTS HI_ExcelSheet;
--
CREATE TABLE HI_ExcelSheet (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    excelReportDesign int  NULL,
    sheetName nvarchar (50) NOT NULL,
    sequence decimal (18,2)  NULL,
    description nvarchar (200)  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_ExcelCell;
--
CREATE TABLE HI_ExcelCell (
    id int auto_increment NOT NULL ,
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

