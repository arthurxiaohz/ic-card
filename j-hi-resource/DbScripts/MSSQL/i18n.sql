if exists (select * from sysobjects where id = object_id(N'HI_Language') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_Language
--
CREATE TABLE HI_Language (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    keyStr nvarchar (200) NOT NULL,
    service nvarchar (50)  NULL,
    entity nvarchar (50)  NULL,
    isSystem int   NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'HI_LanguageCode') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_LanguageCode
--
CREATE TABLE HI_LanguageCode (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    languageCode nvarchar (50) NOT NULL,
    description nvarchar (50)  NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'HI_languageStr') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_languageStr
--
CREATE TABLE HI_languageStr (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    language int  NULL,
    languageCode nvarchar (50)  NULL,
    value nvarchar (255)  NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'HI_Timezone') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_Timezone
--
CREATE TABLE HI_Timezone (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    timezone int  NOT NULL,
    description nvarchar (3000) NOT NULL,
    creator int  NULL,
    primary key (id));

--

