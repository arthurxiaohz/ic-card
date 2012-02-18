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
     * 上传附件并产生一个attachment对象并
     * @param file 需要保存的文件
     * @param saveType 1保存到服务器，2 保存到ftp
     * @param forder 文件保存的目录 如果为"" 或者为null时 就保存在attachment目录下 
     * @return
     */
    public Attachment uploadFile(File file ,int saveType,String fileName,String forder) throws IOException ;
    
    public Attachment uploadFile(File file,int saveType,String fileName,String forder, String contextPath) throws IOException;
    
    public  Attachment uploadFile(InputStream inputStream,int saveType,String fileName,String forder) throws IOException;
    
    public Attachment uploadFile(InputStream inputStream,int saveType,String fileName,String forder, String contextPath) throws IOException ;
    
    
}
