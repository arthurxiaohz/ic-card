if exists (select * from sysobjects where id = object_id(N'HI_Attachment') and OBJECTPROPERTY(id, N'IsUserTable') = 1)
drop table HI_Attachment
--
CREATE TABLE HI_Attachment (
    id int IDENTITY (1, 1) NOT NULL ,
    version int NOT NULL ,
    fileName nvarchar (100)  NULL,
    fileType nvarchar (100)  NULL,
    fileSize decimal (18,2)  NULL,
    attachmentType int   NULL,
    attachmentPath nvarchar (200)  NULL,
    attachDesc nvarchar (200)  NULL,
    primary key (id));

--

