package org.hi.common.attachment.action;

import java.sql.Timestamp;
import java.util.Date;

import org.hi.framework.web.PageInfoView;

/**
 * 附件表的分页类
 *
 */
public class AttachmentPageInfo extends PageInfoView{

	protected  Integer  f_id;
 	protected  String  f_id_op;
	protected  String  f_fileName;
 	protected  String  f_fileName_op;
	protected  String  f_fileType;
 	protected  String  f_fileType_op;
	protected  Double  f_fileSize;
 	protected  String  f_fileSize_op;
	protected  Integer  f_attachmentType;
 	protected  String  f_attachmentType_op;
	protected  String  f_attachmentPath;
 	protected  String  f_attachmentPath_op;
	protected  String  f_attachDesc;
 	protected  String  f_attachDesc_op;


    public Integer getF_id() {
        return this.f_id;
    }
    
    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }
    
    public String getF_id_op() {
        return this.f_id_op;
    }
    
    public void setF_id_op(String f_id_op) {
        this.f_id_op = f_id_op;
    }
   
    public String getF_fileName() {
        return this.f_fileName;
    }
    
    public void setF_fileName(String f_fileName) {
        this.f_fileName = f_fileName;
    }
    
    public String getF_fileName_op() {
        return this.f_fileName_op;
    }
    
    public void setF_fileName_op(String f_fileName_op) {
        this.f_fileName_op = f_fileName_op;
    }
   
    public String getF_fileType() {
        return this.f_fileType;
    }
    
    public void setF_fileType(String f_fileType) {
        this.f_fileType = f_fileType;
    }
    
    public String getF_fileType_op() {
        return this.f_fileType_op;
    }
    
    public void setF_fileType_op(String f_fileType_op) {
        this.f_fileType_op = f_fileType_op;
    }
   
    public Double getF_fileSize() {
        return this.f_fileSize;
    }
    
    public void setF_fileSize(Double f_fileSize) {
        this.f_fileSize = f_fileSize;
    }
    
    public String getF_fileSize_op() {
        return this.f_fileSize_op;
    }
    
    public void setF_fileSize_op(String f_fileSize_op) {
        this.f_fileSize_op = f_fileSize_op;
    }
   
    public Integer getF_attachmentType() {
        return this.f_attachmentType;
    }
    
    public void setF_attachmentType(Integer f_attachmentType) {
        this.f_attachmentType = f_attachmentType;
    }
    
    public String getF_attachmentType_op() {
        return this.f_attachmentType_op;
    }
    
    public void setF_attachmentType_op(String f_attachmentType_op) {
        this.f_attachmentType_op = f_attachmentType_op;
    }
   
    public String getF_attachmentPath() {
        return this.f_attachmentPath;
    }
    
    public void setF_attachmentPath(String f_attachmentPath) {
        this.f_attachmentPath = f_attachmentPath;
    }
    
    public String getF_attachmentPath_op() {
        return this.f_attachmentPath_op;
    }
    
    public void setF_attachmentPath_op(String f_attachmentPath_op) {
        this.f_attachmentPath_op = f_attachmentPath_op;
    }
   
    public String getF_attachDesc() {
        return this.f_attachDesc;
    }
    
    public void setF_attachDesc(String f_attachDesc) {
        this.f_attachDesc = f_attachDesc;
    }
    
    public String getF_attachDesc_op() {
        return this.f_attachDesc_op;
    }
    
    public void setF_attachDesc_op(String f_attachDesc_op) {
        this.f_attachDesc_op = f_attachDesc_op;
    }
   

}
