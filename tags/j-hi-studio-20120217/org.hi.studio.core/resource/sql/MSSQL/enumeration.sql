if exists (select * from sysobjects where id = object_id(N'Enumeration') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table Enumeration
--
CREATE TABLE Enumeration (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    enName nvarchar (50) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (300)  NULL,
    enumerationType int   NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'EnumerationValue') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table EnumerationValue
--
CREATE TABLE EnumerationValue (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    valueName nvarchar (50) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (300)  NULL,
    valueCode nvarchar (50)  NULL,
    enumeration int  NULL,
    creator int  NULL,
    primary key (id));

--

