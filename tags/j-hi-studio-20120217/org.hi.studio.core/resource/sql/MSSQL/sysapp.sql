if exists (select * from sysobjects where id = object_id(N'Hi_AppSetting') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table Hi_AppSetting
--
CREATE TABLE Hi_AppSetting (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    appGroup nvarchar (30) NOT NULL,
    appName nvarchar (30) NOT NULL,
    appValue nvarchar (100) NOT NULL,
    description nvarchar (500)  NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'Hi_Message') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table Hi_Message
--
CREATE TABLE Hi_Message (
    id int IDENTITY (1, 1) NOT NULL ,
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

if exists (select * from sysobjects where id = object_id(N'Hi_MessageParameter') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table Hi_MessageParameter
--
CREATE TABLE Hi_MessageParameter (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    parameterKey nvarchar (50) NOT NULL,
    parameterValue nvarchar (200)  NULL,
    message int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'Hi_Log') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table Hi_Log
--
CREATE TABLE Hi_Log (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    operator int  NULL,
    operateDate datetime   NULL,
    action nvarchar (30)  NULL,
    actionContext nvarchar (2000)  NULL,
    primary key (id));

--

