
delete from HiMenu where ID = 6000;
/---
insert into HiMenu(ID, version, menuName, displayRef, description, parentMenu, sequence, creator) values(6000, 0, 'attachment', '����', '����', 0, 9999, 0);
/---

delete from MenuLink where ID = 6000;
/---
insert into MenuLink(ID, version, linkUrl, displayRef, description, authority, sequence, menu, menuLinkType, creator) values(6000, 0, '/attachmentList.action', '����', '����', 6000, 9999, 6000, 0, 0);
/---

delete from HI_Authority where ID = 6000;
/---
delete from HI_Authority where ID = 6001;
/---
delete from HI_Authority where ID = 6002;
/---
delete from HI_Authority where ID = 6003;
/---
delete from HI_Authority where ID = 6004;
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(6000, 0, 'ATTACHMENT_LIST', 'attachment.AttachmentList', '', '������ѯ', 1, 6000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(6001, 0, 'ATTACHMENT_VIEW', 'attachment.AttachmentView', '', '�����鿴', 2, 6000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(6002, 0, 'ATTACHMENT_SAVE', 'attachment.AttachmentSave', '', '��������', 3, 6000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(6003, 0, 'ATTACHMENT_DEL', 'attachment.AttachmentDel', '', '����ɾ��', 4, 6000);
/---
insert into HI_Authority(ID, version, authorityName, displayRef, propertedResource, description, authorityType, menuLink) values(6004, 0, 'ATTACHMENT_LOOKUP', 'attachment.AttachmentLookup', '', '��������', 1, 6000);
/---


delete from HI_PrivilegeResource where ID = 6000;
/---
delete from HI_PrivilegeResource where ID = 6001;
/---
delete from HI_PrivilegeResource where ID = 6002;
/---
delete from HI_PrivilegeResource where ID = 6003;
/---
delete from HI_PrivilegeResource where ID = 6004;
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer, bizExtAuthNames) values(6000, 0, 'ATTACHMENT_LIST', '/attachmentList.action', 'org.hi.common.attachment.service.AttachmentManager.getSecurityAttachmentList', 'ATTACHMENT_LOOKUP');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(6001, 0, 'ATTACHMENT_VIEW', '/attachmentView.action', 'org.hi.common.attachment.service.AttachmentManager.getSecurityAttachmentById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(6002, 0, 'ATTACHMENT_SAVE', '/attachmentSave.action', 'org.hi.common.attachment.service.AttachmentManager.saveSecurityAttachment');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer, businessLayer) values(6003, 0, 'ATTACHMENT_DEL', '/attachmentRemove.action', 'org.hi.common.attachment.service.AttachmentManager.removeSecurityAttachmentById');
/---
insert into HI_PrivilegeResource(ID, version, authorityName, viewLayer) values(6004, 0, 'ATTACHMENT_LOOKUP', '/attachmentLookup.action');
/---




/---
delete from HI_Language where ID = 6000;
/---
insert into HI_Language(ID, version, keyStr, creator, isSystem) values(6000, 0, '����', 1, 0);
/---
delete from HI_Language where ID = 6001;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(6001, 0, '�ļ���', 'Attachment', 1, 0);
/---
delete from HI_Language where ID = 6002;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(6002, 0, '�ļ�����', 'Attachment', 1, 0);
/---
delete from HI_Language where ID = 6003;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(6003, 0, '�ļ���С', 'Attachment', 1, 0);
/---
delete from HI_Language where ID = 6004;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(6004, 0, '��������', 'Attachment', 1, 0);
/---
delete from HI_Language where ID = 6005;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(6005, 0, '����', 'Attachment', 1, 0);
/---
delete from HI_Language where ID = 6006;
/---
insert into HI_Language(ID, version, keyStr, entity, creator, isSystem) values(6006, 0, '�������', 'Attachment', 1, 0);
