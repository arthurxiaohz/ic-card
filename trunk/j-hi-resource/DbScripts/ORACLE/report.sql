BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_ExcelReportDesign';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_ExcelReportDesign (
    id number NOT NULL ,
    version number NOT NULL ,
    reportName varchar2(20) NOT NULL,
    reportNum varchar2(10) NOT NULL,
    template varchar2(100) NULL,
    createDate date NULL,
    enabled number NULL,
    actionName varchar2(100) NOT NULL,
    description varchar2(200) NULL,
    creator number  NULL )
/---
ALTER TABLE HI_ExcelReportDesign ADD (
      CONSTRAINT pk_HI_ExcelReportDesign PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_ExcelSheet';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_ExcelSheet (
    id number NOT NULL ,
    version number NOT NULL ,
    excelReportDesign number  NULL,
    sheetName varchar2(50) NOT NULL,
    sequence number(18,2) NULL,
    description varchar2(200) NULL )
/---
ALTER TABLE HI_ExcelSheet ADD (
      CONSTRAINT pk_HI_ExcelSheet PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_ExcelCell';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_ExcelCell (
    id number NOT NULL ,
    version number NOT NULL ,
    excelSheet number  NULL,
    cellColumn varchar2(10) NOT NULL,
    cellRow number NOT NULL,
    variableName varchar2(100) NULL,
    constant varchar2(100) NULL,
    isEnumeration number NULL,
    reportDataType number NULL,
    stretchingType number NULL,
    conditionCell varchar2(500) NULL,
    description varchar2(200) NULL )
/---
ALTER TABLE HI_ExcelCell ADD (
      CONSTRAINT pk_HI_ExcelCell PRIMARY KEY (id)
)

/---



