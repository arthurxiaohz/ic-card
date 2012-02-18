BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_Authority';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_Authority (
    id number NOT NULL ,
    version number NOT NULL ,
    authorityName varchar2(200) NOT NULL,
    displayRef varchar2(200) NULL,
    propertedResource varchar2(200) NULL,
    description varchar2(500) NULL,
    authorityType number NULL,
    menuLink number  NULL )
/---
ALTER TABLE HI_Authority ADD (
      CONSTRAINT pk_HI_Authority PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_Role';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_Role (
    id number NOT NULL ,
    version number NOT NULL ,
    roleName varchar2(200) NOT NULL,
    displayRef varchar2(200) NULL,
    description varchar2(500) NULL,
    creator number  NULL )
/---
ALTER TABLE HI_Role ADD (
      CONSTRAINT pk_HI_Role PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_SecurityGroup';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_SecurityGroup (
    id number NOT NULL ,
    version number NOT NULL ,
    groupName varchar2(200) NOT NULL,
    displayRef varchar2(200) NULL,
    description varchar2(500) NULL )
/---
ALTER TABLE HI_SecurityGroup ADD (
      CONSTRAINT pk_HI_SecurityGroup PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_UserAuthority';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_UserAuthority (
    id number NOT NULL ,
    version number NOT NULL ,
    securityUser number  NULL,
    authority number  NULL,
    org number  NULL,
    scope number NULL,
    roleAuthority number  NULL )
/---
ALTER TABLE HI_UserAuthority ADD (
      CONSTRAINT pk_HI_UserAuthority PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_UserRole';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_UserRole (
    id number NOT NULL ,
    version number NOT NULL ,
    securityUser number  NULL,
    role number  NULL )
/---
ALTER TABLE HI_UserRole ADD (
      CONSTRAINT pk_HI_UserRole PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_UserGroup';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_UserGroup (
    id number NOT NULL ,
    version number NOT NULL ,
    securityUser number  NULL,
    securityGroup number  NULL )
/---
ALTER TABLE HI_UserGroup ADD (
      CONSTRAINT pk_HI_UserGroup PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_RoleAuthority';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_RoleAuthority (
    id number NOT NULL ,
    version number NOT NULL ,
    role number  NULL,
    authority number  NULL,
    org number  NULL,
    scope number NULL )
/---
ALTER TABLE HI_RoleAuthority ADD (
      CONSTRAINT pk_HI_RoleAuthority PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_GroupRole';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_GroupRole (
    id number NOT NULL ,
    version number NOT NULL ,
    securityGroup number  NULL,
    role number  NULL )
/---
ALTER TABLE HI_GroupRole ADD (
      CONSTRAINT pk_HI_GroupRole PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_PrivilegeResource';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_PrivilegeResource (
    id number NOT NULL ,
    version number NOT NULL ,
    authorityName varchar2(200) NOT NULL,
    viewLayer varchar2(200) NULL,
    veiwExtAuthNames varchar2(200) NULL,
    businessLayer varchar2(500) NULL,
    bizExtAuthNames varchar2(200) NULL )
/---
ALTER TABLE HI_PrivilegeResource ADD (
      CONSTRAINT pk_HI_PrivilegeResource PRIMARY KEY (id)
)

/---


