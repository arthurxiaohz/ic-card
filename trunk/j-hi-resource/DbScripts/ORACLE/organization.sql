BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_Org';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_Org (
    id number NOT NULL ,
    version number NOT NULL ,
    orgName varchar2(50) NOT NULL,
    orgNum varchar2(30) NULL,
    manager number  NULL,
    parentOrg number  NULL,
    address varchar2(100) NULL,
    description varchar2(500) NULL,
    creator number  NULL,
    deleted number NULL )
/---
ALTER TABLE HI_Org ADD (
      CONSTRAINT pk_HI_Org PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_User';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_User (
    id number NOT NULL ,
    version number NOT NULL ,
    userName varchar2(30) NOT NULL,
    password varchar2(100) NULL,
    country number NULL,
    timeZone number NULL,
    accountEnabled number NULL,
    accountLocked number NULL,
    expiredDate date NULL,
    credentialsExpired number NULL,
    fullName varchar2(30) NOT NULL,
    org number  NULL,
    gender number NULL,
    address varchar2(200) NULL,
    phone varchar2(50) NULL,
    mobile varchar2(50) NULL,
    zip varchar2(30) NULL,
    SSN varchar2(50) NULL,
    mail varchar2(100) NULL,
    userMgrType number NULL,
    notifyMode varchar2(200) NULL,
    description varchar2(500) NULL,
    creator number  NULL,
    deleted number NULL )
/---
ALTER TABLE HI_User ADD (
      CONSTRAINT pk_HI_User PRIMARY KEY (id)
)

/---




