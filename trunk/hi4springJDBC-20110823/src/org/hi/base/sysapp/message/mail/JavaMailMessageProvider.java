/*     */ package org.hi.base.sysapp.message.mail;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.mail.MessagingException;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiUserManager;
/*     */ import org.hi.base.sysapp.message.AbstractMessageProvider;
/*     */ import org.hi.base.sysapp.model.Message;
/*     */ import org.hi.base.sysapp.model.MessageParameter;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ import org.springframework.mail.javamail.JavaMailSenderImpl;
/*     */ import org.springframework.mail.javamail.MimeMessageHelper;
/*     */ 
/*     */ public class JavaMailMessageProvider extends AbstractMessageProvider
/*     */ {
/*     */   protected static final String MESSAGE_PARAMETER_BCC = "BCC";
/*     */   protected static final String MESSAGE_PARAMETER_CC = "CC";
/*     */   protected String host;
/*     */   protected int port;
/*     */   protected String encoding;
/*     */   protected String userName;
/*     */   protected String password;
/*     */   protected String from;
/*     */ 
/*     */   public void sendMessage(Message message)
/*     */     throws BusinessException
/*     */   {
/*  34 */     if ((message.getReceivers() == null) && (getParameter(message.getMessageParameters(), "ALL") == null)) {
/*  35 */       return;
/*     */     }
/*  37 */     JavaMailSenderImpl sender = new JavaMailSenderImpl();
/*  38 */     sender.setHost(getHost());
/*  39 */     sender.setPort(getPort());
/*  40 */     sender.setUsername(getUserName());
/*  41 */     sender.setPassword(getPassword());
/*  42 */     MimeMessage mimeMessage = sender.createMimeMessage();
/*     */     try {
/*  44 */       MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, getEncoding());
/*  45 */       helper.setFrom(this.from);
/*  46 */       helper.setText(message.getMessageText());
/*  47 */       String pValue = null;
/*     */ 
/*  51 */       pValue = getParameter(message.getMessageParameters(), "ALL");
/*  52 */       String[] receivers = (String[])null;
/*  53 */       if (pValue != null) {
/*  54 */         if (Boolean.valueOf(pValue).booleanValue()) {
/*  55 */           receivers = getAllReceivers();
/*     */         }
/*     */       }
/*     */       else {
/*  59 */         receivers = message.getReceivers().split(",");
/*     */       }
/*  61 */       if ((receivers == null) && (receivers.length > 0)) {
/*  62 */         return;
/*     */       }
/*  64 */       helper.setTo(receivers);
/*     */ 
/*  68 */       pValue = getParameter(message.getMessageParameters(), "SUBJECT");
/*  69 */       if (pValue != null) {
/*  70 */         helper.setSubject(pValue);
/*     */       }
/*     */ 
/*  73 */       pValue = getParameter(message.getMessageParameters(), "CC");
/*  74 */       if (pValue != null) {
/*  75 */         String[] cc = pValue.split(",");
/*  76 */         helper.setCc(cc);
/*     */       }
/*     */ 
/*  80 */       pValue = getParameter(message.getMessageParameters(), "BCC");
/*  81 */       if (pValue != null) {
/*  82 */         String[] bcc = pValue.split(",");
/*  83 */         helper.setBcc(bcc);
/*     */       }
/*     */     }
/*     */     catch (MessagingException e) {
/*  87 */       new BusinessException(I18NUtil.getString("发送邮件失败"));
/*     */     }
/*  89 */     sender.send(mimeMessage);
/*  90 */     sentProcess(message);
/*     */   }
/*     */ 
/*     */   public String[] getAllReceivers()
/*     */   {
/*  95 */     List receivers = new ArrayList();
/*  96 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  97 */     List users = userMgr.getObjects();
/*  98 */     String userMail = null;
/*  99 */     for (HiUser user : users) {
/* 100 */       userMail = user.getMail();
/* 101 */       if ((userMail != null) && (userMail.indexOf("@") > 0))
/* 102 */         receivers.add(userMail);
/*     */     }
/* 104 */     return (String[])receivers.toArray(new String[receivers.size()]);
/*     */   }
/*     */ 
/*     */   public String getReceivers(String ids) {
/* 108 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/* 109 */     StringBuffer sb = new StringBuffer("");
/* 110 */     String[] users = ids.split(",");
/* 111 */     for (String userId : users) {
/* 112 */       HiUser user = (HiUser)userMgr.getObjectById(new Integer(userId));
/* 113 */       String userMail = user.getMail();
/* 114 */       if ((userMail != null) && (userMail.indexOf("@") > 0))
/* 115 */         sb.append(userMail).append(",");
/*     */     }
/* 117 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public void setHost(String host) {
/* 121 */     this.host = host;
/*     */   }
/*     */ 
/*     */   public void setPort(int port) {
/* 125 */     this.port = port;
/*     */   }
/*     */ 
/*     */   public void setEncoding(String encoding) {
/* 129 */     this.encoding = encoding;
/*     */   }
/*     */ 
/*     */   public void setUserName(String userName) {
/* 133 */     this.userName = userName;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/* 137 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public void setFrom(String from) {
/* 141 */     this.from = from;
/*     */   }
/*     */ 
/*     */   public String getHost() {
/* 145 */     return this.host == null ? "smtp.cltc.com.cn" : this.host;
/*     */   }
/*     */ 
/*     */   public String getUserName() {
/* 149 */     return this.userName == null ? "zhanghao" : this.userName;
/*     */   }
/*     */   public String getPassword() {
/* 152 */     return this.password == null ? "111111" : this.password;
/*     */   }
/*     */   public String getFrom() {
/* 155 */     return this.from == null ? "zhanghao@cltc.com.cn" : this.from;
/*     */   }
/*     */ 
/*     */   public String getEncoding() {
/* 159 */     return this.encoding == null ? "UTF-8" : this.encoding;
/*     */   }
/*     */ 
/*     */   public int getPort() {
/* 163 */     return this.port == 0 ? 25 : this.port;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 168 */     JavaMailMessageProvider provider = new JavaMailMessageProvider();
/* 169 */     Message message = new Message();
/* 170 */     message.setSender("zhanghao@cltc.com.cn");
/* 171 */     message.setReceivers("zhanghao@cltc.com.cn");
/* 172 */     message.setMessageText("test text");
/* 173 */     List list = new ArrayList();
/*     */ 
/* 175 */     MessageParameter subject = new MessageParameter();
/* 176 */     subject.setParameterKey("SUBJECT");
/* 177 */     subject.setParameterValue("测试邮件");
/* 178 */     list.add(subject);
/*     */ 
/* 180 */     MessageParameter cc = new MessageParameter();
/* 181 */     cc.setParameterKey("CC");
/* 182 */     cc.setParameterValue("zhanghao@cltc.com.cn");
/* 183 */     list.add(cc);
/*     */ 
/* 185 */     MessageParameter bcc = new MessageParameter();
/* 186 */     bcc.setParameterKey("BCC");
/* 187 */     bcc.setParameterValue("hao_zhang_pk@qq.com");
/* 188 */     list.add(bcc);
/*     */ 
/* 190 */     message.setMessageParameters(list);
/*     */ 
/* 192 */     provider.sendMessage(message);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.sysapp.message.mail.JavaMailMessageProvider
 * JD-Core Version:    0.6.0
 */