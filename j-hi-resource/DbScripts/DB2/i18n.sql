BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_Language';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_Language (
    id number NOT NULL ,
    version number NOT NULL ,
    keyStr varchar2(200) NOT NULL,
    service varchar2(50) NULL,
    entity varchar2(50) NULL,
    isSystem number NULL,
    creator number  NULL )
/---
ALTER TABLE HI_Language ADD (
      CONSTRAINT pk_HI_Language PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_LanguageCode';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_LanguageCode (
    id number NOT NULL ,
    version number NOT NULL ,
    languageCode varchar2(50) NOT NULL,
    description varchar2(50) NULL,
    creator number  NULL )
/---
ALTER TABLE HI_LanguageCode ADD (
      CONSTRAINT pk_HI_LanguageCode PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_languageStr';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_languageStr (
    id number NOT NULL ,
    version number NOT NULL ,
    language number  NULL,
    languageCode varchar2(50) NULL,
    value varchar2(255) NULL,
    creator number  NULL )
/---
ALTER TABLE HI_languageStr ADD (
      CONSTRAINT pk_HI_languageStr PRIMARY KEY (id)
)

/---

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE HI_Timezone';
EXCEPTION WHEN OTHERS THEN
    NULL;
END;
/---
CREATE TABLE HI_Timezone (
    id number NOT NULL ,
    version number NOT NULL ,
    timezone number NOT NULL,
    description varchar2(3000) NOT NULL,
    creator number  NULL )
/---
ALTER TABLE HI_Timezone ADD (
      CONSTRAINT pk_HI_Timezone PRIMARY KEY (id)
)

/---

