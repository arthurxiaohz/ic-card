package org.hi.common.attachment.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.hi.common.attachment.model.Attachment;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface AttachmentManager extends Manager
{
  public abstract void saveAttachment(Attachment paramAttachment);

  public abstract void removeAttachmentById(Integer paramInteger);

  public abstract Attachment getAttachmentById(Integer paramInteger);

  public abstract List<Attachment> getAttachmentList(PageInfo paramPageInfo);

  public abstract Attachment uploadFile(File paramFile, int paramInt, String paramString1, String paramString2)
    throws IOException;

  public abstract Attachment uploadFile(File paramFile, int paramInt, String paramString1, String paramString2, String paramString3)
    throws IOException;

  public abstract Attachment uploadFile(InputStream paramInputStream, int paramInt, String paramString1, String paramString2)
    throws IOException;

  public abstract Attachment uploadFile(InputStream paramInputStream, int paramInt, String paramString1, String paramString2, String paramString3)
    throws IOException;
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.common.attachment.service.AttachmentManager
 * JD-Core Version:    0.6.0
 */