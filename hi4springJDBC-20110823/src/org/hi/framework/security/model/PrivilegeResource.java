/*    */ package org.hi.framework.security.model;
/*    */ 
/*    */ import org.hi.framework.security.model.original.PrivilegeResourceAbstract;
/*    */ 
/*    */ public class PrivilegeResource extends PrivilegeResourceAbstract
/*    */ {
/*    */   public void setAuthorityName(String authorityName)
/*    */   {
/*  9 */     authorityName = authorityName == null ? null : authorityName.trim();
/* 10 */     super.setAuthorityName(authorityName);
/*    */   }
/*    */ 
/*    */   public void setViewLayer(String viewLayer)
/*    */   {
/* 15 */     viewLayer = viewLayer == null ? null : viewLayer.trim();
/* 16 */     super.setViewLayer(viewLayer);
/*    */   }
/*    */ 
/*    */   public void setVeiwExtAuthNames(String veiwExtAuthNames)
/*    */   {
/* 21 */     veiwExtAuthNames = veiwExtAuthNames == null ? null : veiwExtAuthNames.trim();
/* 22 */     super.setVeiwExtAuthNames(veiwExtAuthNames);
/*    */   }
/*    */ 
/*    */   public void setBusinessLayer(String businessLayer) {
/* 26 */     businessLayer = businessLayer == null ? null : businessLayer.trim();
/* 27 */     super.setBusinessLayer(businessLayer);
/*    */   }
/*    */ 
/*    */   public void setBizExtAuthNames(String bizExtAuthNames) {
/* 31 */     bizExtAuthNames = bizExtAuthNames == null ? null : bizExtAuthNames.trim();
/* 32 */     super.setBusinessLayer(bizExtAuthNames);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.security.model.PrivilegeResource
 * JD-Core Version:    0.6.0
 */