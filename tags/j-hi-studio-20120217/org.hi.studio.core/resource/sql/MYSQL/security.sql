DROP TABLE IF EXISTS HI_Authority;
--
CREATE TABLE HI_Authority (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    authorityName nvarchar (200) NOT NULL,
    displayRef nvarchar (200)  NULL,
    propertedResource nvarchar (200)  NULL,
    description nvarchar (500)  NULL,
    authorityType int   NULL,
    menuLink int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_Role;
--
CREATE TABLE HI_Role (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    roleName nvarchar (200) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (500)  NULL,
    creator int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_SecurityGroup;
--
CREATE TABLE HI_SecurityGroup (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    groupName nvarchar (200) NOT NULL,
    displayRef nvarchar (200)  NULL,
    description nvarchar (500)  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_UserAuthority;
--
CREATE TABLE HI_UserAuthority (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    securityUser int  NULL,
    authority int  NULL,
    org int  NULL,
    scope int   NULL,
    roleAuthority int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_UserRole;
--
CREATE TABLE HI_UserRole (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    securityUser int  NULL,
    role int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_UserGroup;
--
CREATE TABLE HI_UserGroup (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    securityUser int  NULL,
    securityGroup int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_RoleAuthority;
--
CREATE TABLE HI_RoleAuthority (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    role int  NULL,
    authority int  NULL,
    org int  NULL,
    scope int   NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_GroupRole;
--
CREATE TABLE HI_GroupRole (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    securityGroup int  NULL,
    role int  NULL,
    primary key (id));
--

DROP TABLE IF EXISTS HI_PrivilegeResource;
--
CREATE TABLE HI_PrivilegeResource (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    authorityName nvarchar (200) NOT NULL,
    viewLayer nvarchar (200)  NULL,
    veiwExtAuthNames nvarchar (200)  NULL,
    businessLayer nvarchar (500)  NULL,
    bizExtAuthNames nvarchar (200)  NULL,
    primary key (id));
--

