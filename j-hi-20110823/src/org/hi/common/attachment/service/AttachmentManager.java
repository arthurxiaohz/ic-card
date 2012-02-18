package org.hi.common.attachment.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hi.common.attachment.model.Attachment;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public interface AttachmentManager extends Manager{
    
    public void saveAttachment(Attachment attachment);

    public void removeAttachmentById(Integer id);

    public Attachment getAttachmentById(Integer id);

    public List<Attachment> getAttachmentList(PageInfo pageInfo);
    
    
    /**
     * �ϴ�����������һ��attachment����
     * @param file ��Ҫ������ļ�
     * @param saveType 1���浽��������2 ���浽ftp
     * @param forder �ļ������Ŀ¼ ���Ϊ"" ����Ϊnullʱ �ͱ�����attachmentĿ¼�� 
     * @return
     */
    public Attachment uploadFile(File file ,int saveType,String fileName,String forder) throws IOException ;
    
    public Attachment uploadFile(File file,int saveType,String fileName,String forder, String contextPath) throws IOException;
    
    public  Attachment uploadFile(InputStream inputStream,int saveType,String fileName,String forder) throws IOException;
    
    public Attachment uploadFile(InputStream inputStream,int saveType,String fileName,String forder, String contextPath) throws IOException ;
    
    
}
