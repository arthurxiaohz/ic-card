BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_Attachment';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_Attachment (
    id number NOT NULL ,
    version number NOT NULL ,
    fileName varchar2(100) NULL,
    fileType varchar2(100) NULL,
    fileSize number(18,2) NULL,
    attachmentType number NULL,
    attachmentPath varchar2(200) NULL,
    attachDesc varchar2(200) NULL )
/---
ALTER TABLE HI_Attachment ADD (
      CONSTRAINT pk_HI_Attachment PRIMARY KEY (id)
)

/---

