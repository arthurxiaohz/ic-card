DROP TABLE IF EXISTS HI_Language;
--
CREATE TABLE HI_Language (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    keyStr nvarchar (200) NOT NULL,
    service nvarchar (50)  NULL,
    entity nvarchar (50)  NULL,
    isSystem int   NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_LanguageCode;
--
CREATE TABLE HI_LanguageCode (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    languageCode nvarchar (50) NOT NULL,
    description nvarchar (50)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_languageStr;
--
CREATE TABLE HI_languageStr (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    language int  NULL,
    languageCode nvarchar (50)  NULL,
    value nvarchar (255)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_Timezone;
--
CREATE TABLE HI_Timezone (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    timezone int  NOT NULL,
    description nvarchar (3000) NOT NULL,
    creator int  NULL,
    primary key (id));
--

