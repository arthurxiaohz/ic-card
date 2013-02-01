/*    */ package org.hi.base.sysapp.model;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.hi.base.sysapp.model.original.MessageAbstract;
/*    */ 
/*    */ public class Message extends MessageAbstract
/*    */ {
/*    */   public void putMessageParameter(String key, String value)
/*    */   {
/* 12 */     MessageParameter messageParameter = new MessageParameter();
/* 13 */     messageParameter.setParameterKey(key);
/* 14 */     messageParameter.setParameterValue(value);
/* 15 */     if (getMessageParameters() == null) {
/* 16 */       List messageParameters = new ArrayList();
/* 17 */       setMessageParameters(messageParameters);
/*    */     }
/*    */ 
/* 20 */     getMessageParameters().add(messageParameter);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.model.Message
 * JD-Core Version:    0.6.0
 */