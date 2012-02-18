DROP TABLE IF EXISTS Enumeration;
--
CREATE TABLE Enumeration (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    enName nvarchar (50) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (300)  NULL,
    enumerationType int   NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS EnumerationValue;
--
CREATE TABLE EnumerationValue (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    valueName nvarchar (50) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (300)  NULL,
    valueCode nvarchar (50)  NULL,
    enumeration int  NULL,
    creator int  NULL,
    primary key (id));
--

