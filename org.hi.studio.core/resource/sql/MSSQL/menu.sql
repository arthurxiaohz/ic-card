if exists (select * from sysobjects where id = object_id(N'HiMenu') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HiMenu
--
CREATE TABLE HiMenu (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    menuName nvarchar (100) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (200)  NULL,
    parentMenu int  NULL,
    sequence decimal (18,2)  NULL,
    menuType int   NULL,
    creator int  NULL,
    primary key (id));

--

if exists (select * from sysobjects where id = object_id(N'MenuLink') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table MenuLink
--
CREATE TABLE MenuLink (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    linkUrl nvarchar (200) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (200)  NULL,
    authority int  NULL,
    sequence decimal (18,2)  NULL,
    menu int  NULL,
    menuLinkType int   NULL,
    creator int  NULL,
    primary key (id));

--

