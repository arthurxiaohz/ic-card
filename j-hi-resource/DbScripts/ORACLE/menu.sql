BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HiMenu';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HiMenu (
    id number NOT NULL ,
    version number NOT NULL ,
    menuName varchar2(100) NOT NULL,
    displayRef varchar2(200) NULL,
    description varchar2(200) NULL,
    parentMenu number  NULL,
    sequence number(18,2) NULL,
    menuType number NULL,
    creator number  NULL )
/---
ALTER TABLE HiMenu ADD (
      CONSTRAINT pk_HiMenu PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE MenuLink';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE MenuLink (
    id number NOT NULL ,
    version number NOT NULL ,
    linkUrl varchar2(200) NOT NULL,
    displayRef varchar2(200) NULL,
    description varchar2(200) NULL,
    authority number  NULL,
    sequence number(18,2) NULL,
    menu number  NULL,
    menuLinkType number NULL,
    creator number  NULL )
/---
ALTER TABLE MenuLink ADD (
      CONSTRAINT pk_MenuLink PRIMARY KEY (id)
)

/---

