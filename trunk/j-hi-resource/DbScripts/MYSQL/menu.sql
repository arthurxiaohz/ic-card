DROP TABLE IF EXISTS HiMenu;
--
CREATE TABLE HiMenu (
    id int auto_increment NOT NULL ,
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

DROP TABLE IF EXISTS MenuLink;
--
CREATE TABLE MenuLink (
    id int auto_increment NOT NULL ,
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

