BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Enumeration';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE Enumeration (
    id number NOT NULL ,
    version number NOT NULL ,
    enName varchar2(50) NOT NULL,
    displayRef varchar2(200) NULL,
    description varchar2(300) NULL,
    enumerationType number NULL,
    creator number  NULL )
/---
ALTER TABLE Enumeration ADD (
      CONSTRAINT pk_Enumeration PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE EnumerationValue';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE EnumerationValue (
    id number NOT NULL ,
    version number NOT NULL ,
    valueName varchar2(50) NOT NULL,
    displayRef varchar2(200) NULL,
    description varchar2(300) NULL,
    valueCode varchar2(50) NULL,
    enumeration number  NULL,
    creator number  NULL )
/---
ALTER TABLE EnumerationValue ADD (
      CONSTRAINT pk_EnumerationValue PRIMARY KEY (id)
)

/---


