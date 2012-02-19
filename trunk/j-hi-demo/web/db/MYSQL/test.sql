DROP TABLE IF EXISTS Staff;
--
CREATE TABLE Staff (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    useNum nvarchar (30)  NULL,
    nativePlace nvarchar (30)  NULL,
    degree int   NULL,
    specialty nvarchar (30)  NULL,
    jobDate datetime   NULL,
    marry int   NULL,
    interest nvarchar (30)  NULL,
    jobPosition int  NULL,
    photo_attachment int  NULL,
    employedStatus int   NULL,
    nation int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Nation;
--
CREATE TABLE Nation (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    chineseName nvarchar (30)  NULL,
    englishName nvarchar (30)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS JobPosition;
--
CREATE TABLE JobPosition (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    name nvarchar (30)  NULL,
    description nvarchar (30)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Experience;
--
CREATE TABLE Experience (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    startTime datetime  NOT NULL,
    endTime datetime  NOT NULL,
    place nvarchar (30) NOT NULL,
    task nvarchar (30) NOT NULL,
    people nvarchar (30) NOT NULL,
    staff int  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS MbMchtInf;
--
CREATE TABLE MbMchtInf (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    mchtCd nvarchar (15) NOT NULL,
    mchtName nvarchar (30) NOT NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS MchtSettleFee;
--
CREATE TABLE MchtSettleFee (
    id int NOT NULL ,
    byRate decimal (5,2) NOT NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS Friends;
--
CREATE TABLE Friends (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    name nvarchar (30) NOT NULL,
    age int  NOT NULL,
    gentle int   NULL,
    staff int  NULL,
    creator int  NULL,
    deleted int   NULL,
    primary key (id));
--

