package org.hi.common.attachment.model;

import java.math.BigDecimal;

import org.hi.common.attachment.model.original.AttachmentAbstract;


public class Attachment extends AttachmentAbstract{

	private String icoPath="common/sysimage/file/";
	private String errorImg="common/sysimage/file/unknow.gif";
	private java.text.DecimalFormat   df =new   java.text.DecimalFormat("#.##");   
	
	public String getFileNameImage() {
		return getImage() +this.fileName;
	 
	}

	public String getImageICO()
	{
		String extFileName="unknow";
		if (this.getFileName()  != null && this.getFileName().lastIndexOf(".")>0)
			extFileName = this.getFileName().substring(fileName.lastIndexOf(".")+1);
		return icoPath + extFileName + ".gif";
		
	}
	
	/**组装一个图片路径地址给image标签
	 * @return
	 */
	private String getImage()
	{
		String extFileName="unknow";
		if (this.getFileName()  != null && this.getFileName().lastIndexOf(".")>0)
			extFileName = this.getFileName().substring(fileName.lastIndexOf(".")+1);
		return "<image src='" + icoPath + extFileName + ".gif" + 
		"' border='0' onerror=javascript:this.src='"+ errorImg + "' />" ;
	}

	/**得到图片文件的大小
	 * @return
	 */
	public String getDetailInfo() {
		
		return getImage() + this.getFileName() + "  大小:" + this.getFileSize()+ "KB " ;
	}
	
	/**通过DecimalFormat类来格式化上传文件的大小。
	 * @return
	 */
	public String getAttachmentSize()
	{
		if(this.getFileSize() == null || this.getFileSize() ==0d)
			return "0" + "KB";
		if ( this.getFileSize() >1024 )
			return df.format(  this.getFileSize()/1024 ) + "MB";
		else
			return df.format ( this.getFileSize() )+ "KB " ;
		
		
	}


	

}