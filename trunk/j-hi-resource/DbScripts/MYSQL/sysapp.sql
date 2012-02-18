DROP TABLE IF EXISTS Hi_AppSetting;
--
CREATE TABLE Hi_AppSetting (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    appGroup nvarchar (30) NOT NULL,
    appName nvarchar (30) NOT NULL,
    appValue nvarchar (100) NOT NULL,
    description nvarchar (500)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Hi_Message;
--
CREATE TABLE Hi_Message (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    receivers nvarchar (2000) NOT NULL,
    receiverNames nvarchar (2000)  NULL,
    sender nvarchar (50)  NULL,
    messageType int   NULL,
    messageText nvarchar (3000)  NULL,
    createDate datetime   NULL,
    sendDate datetime   NULL,
    isSent int   NULL,
    description nvarchar (200)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Hi_MessageParameter;
--
CREATE TABLE Hi_MessageParameter (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    parameterKey nvarchar (50) NOT NULL,
    parameterValue nvarchar (200)  NULL,
    message int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Hi_Log;
--
CREATE TABLE Hi_Log (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    operator int  NULL,
    operateDate datetime   NULL,
    action nvarchar (30)  NULL,
    actionContext nvarchar (2000)  NULL,
    primary key (id));
--

