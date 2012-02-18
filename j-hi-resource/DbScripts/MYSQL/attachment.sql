DROP TABLE IF EXISTS HI_Attachment;
--
CREATE TABLE HI_Attachment (
    id int auto_increment NOT NULL ,
    version int NOT NULL ,
    fileName nvarchar (100)  NULL,
    fileType nvarchar (100)  NULL,
    fileSize decimal (18,2)  NULL,
    attachmentType int   NULL,
    attachmentPath nvarchar (200)  NULL,
    attachDesc nvarchar (200)  NULL,
    primary key (id));
--

