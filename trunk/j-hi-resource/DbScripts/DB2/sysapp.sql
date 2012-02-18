BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Hi_AppSetting';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE Hi_AppSetting (
    id number NOT NULL ,
    version number NOT NULL ,
    appGroup varchar2(30) NOT NULL,
    appName varchar2(30) NOT NULL,
    appValue varchar2(100) NOT NULL,
    description varchar2(500) NULL,
    creator number  NULL )
/---
ALTER TABLE Hi_AppSetting ADD (
      CONSTRAINT pk_Hi_AppSetting PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Hi_Message';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE Hi_Message (
    id number NOT NULL ,
    version number NOT NULL ,
    receivers varchar2(2000) NOT NULL,
    receiverNames varchar2(2000) NULL,
    sender varchar2(50) NULL,
    messageType number NULL,
    messageText varchar2(3000) NULL,
    createDate date NULL,
    sendDate date NULL,
    isSent number NULL,
    description varchar2(200) NULL,
    creator number  NULL )
/---
ALTER TABLE Hi_Message ADD (
      CONSTRAINT pk_Hi_Message PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Hi_MessageParameter';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE Hi_MessageParameter (
    id number NOT NULL ,
    version number NOT NULL ,
    parameterKey varchar2(50) NOT NULL,
    parameterValue varchar2(200) NULL,
    message number  NULL )
/---
ALTER TABLE Hi_MessageParameter ADD (
      CONSTRAINT pk_Hi_MessageParameter PRIMARY KEY (id)
)

/---


BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Hi_Log';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE Hi_Log (
    id number NOT NULL ,
    version number NOT NULL ,
    operator number  NULL,
    operateDate date NULL,
    action varchar2(30) NULL,
    actionContext varchar2(2000) NULL )
/---
ALTER TABLE Hi_Log ADD (
      CONSTRAINT pk_Hi_Log PRIMARY KEY (id)
)

/---

