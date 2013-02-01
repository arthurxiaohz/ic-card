/*    */ package org.hi.framework.web.taglib.component.bean;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class Token
/*    */   implements Serializable
/*    */ {
/*    */   public static final String TOKEN_LIST_NAME = "session.token";
/*    */   public static final String TOKEN_STRING_NAME = "token";
/* 12 */   private List<String> tokenValues = new ArrayList();
/*    */ 
/*    */   protected String generateTokenString(HttpSession session) {
/* 15 */     return System.currentTimeMillis() + session.getId();
/*    */   }
/*    */ 
/*    */   public String getTokenString(HttpSession session)
/*    */   {
/* 22 */     String tokenStr = generateTokenString(session);
/* 23 */     return tokenStr;
/*    */   }
/*    */ 
/*    */   public void delEndToken()
/*    */   {
/* 29 */     if (this.tokenValues.size() > 0)
/* 30 */       this.tokenValues.remove(this.tokenValues.size() - 1);
/*    */   }
/*    */ 
/*    */   public boolean isTokenStringValid(String tokenStr)
/*    */   {
/* 38 */     if (tokenStr == null) {
/* 39 */       return true;
/*    */     }
/* 41 */     if (this.tokenValues.contains(tokenStr)) {
/* 42 */       return false;
/*    */     }
/* 44 */     this.tokenValues.add(tokenStr);
/* 45 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.bean.Token
 * JD-Core Version:    0.6.0
 */