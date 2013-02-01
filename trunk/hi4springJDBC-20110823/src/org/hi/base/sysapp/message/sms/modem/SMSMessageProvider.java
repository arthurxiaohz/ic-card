/*     */ package org.hi.base.sysapp.message.sms.modem;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import org.hi.SpringContextHolder;
/*     */ import org.hi.base.organization.model.HiUser;
/*     */ import org.hi.base.organization.service.HiUserManager;
/*     */ import org.hi.base.sysapp.message.AbstractMessageProvider;
/*     */ import org.hi.base.sysapp.message.sms.SmsListener;
/*     */ import org.hi.base.sysapp.message.sms.SmsMessenger;
/*     */ import org.hi.base.sysapp.model.Message;
/*     */ import org.hi.framework.web.BusinessException;
/*     */ 
/*     */ public class SMSMessageProvider extends AbstractMessageProvider
/*     */   implements SmsMessenger, SmsListener
/*     */ {
/*     */   public Vector eventQ;
/*  20 */   protected String smsPort = "COM4";
/*     */ 
/*     */   public String getSmsPort() {
/*  23 */     return this.smsPort;
/*     */   }
/*     */ 
/*     */   public void setSmsPort(String smsPort) {
/*  27 */     this.smsPort = smsPort;
/*  28 */     GprsSmsSend.getInstance().setSmsPort(smsPort);
/*     */   }
/*     */ 
/*     */   public SMSMessageProvider() {
/*  32 */     this.eventQ = new Vector();
/*  33 */     GprsSmsSend.getInstance().setMessenger(this);
/*     */   }
/*     */ 
/*     */   public void addListener(Object o) {
/*  37 */     this.eventQ.add(o);
/*     */   }
/*     */ 
/*     */   public void removeListener(Object o) {
/*  41 */     this.eventQ.remove(o);
/*     */   }
/*     */ 
/*     */   public SerialParameters getParameter() {
/*  45 */     return GprsSmsSend.getInstance().getParameters();
/*     */   }
/*     */ 
/*     */   public void send(String usermobile, String stMessage)
/*     */   {
/*  50 */     Sms msg = new Sms(usermobile, stMessage);
/*  51 */     GprsSmsSend.getInstance().addQueue(msg);
/*     */   }
/*     */ 
/*     */   public void SmsArrive(Vector v)
/*     */   {
/*  56 */     for (int i = 0; i < this.eventQ.size(); i++)
/*  57 */       ((SmsListener)this.eventQ.get(i)).SmsArrive(v);
/*     */   }
/*     */ 
/*     */   public String[] getAllReceivers()
/*     */   {
/*  62 */     List receivers = new ArrayList();
/*  63 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  64 */     List users = userMgr.getObjects();
/*  65 */     String userMobile = null;
/*  66 */     for (HiUser user : users) {
/*  67 */       userMobile = user.getMobile();
/*  68 */       if ((userMobile != null) && (userMobile.length() == 11))
/*  69 */         receivers.add(userMobile);
/*     */     }
/*  71 */     return (String[])receivers.toArray(new String[receivers.size()]);
/*     */   }
/*     */ 
/*     */   public String getReceivers(String ids) {
/*  75 */     HiUserManager userMgr = (HiUserManager)SpringContextHolder.getBean(HiUser.class);
/*  76 */     StringBuffer sb = new StringBuffer("");
/*  77 */     String[] users = ids.split(",");
/*  78 */     for (String userId : users) {
/*  79 */       HiUser user = (HiUser)userMgr.getObjectById(new Integer(userId));
/*  80 */       String userMobile = user.getMobile();
/*  81 */       if ((userMobile != null) && (userMobile.length() == 11))
/*  82 */         sb.append(userMobile).append(",");
/*     */     }
/*  84 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public void sendMessage(Message message) throws BusinessException
/*     */   {
/*  89 */     if ((message.getReceivers() == null) && (getParameter(message.getMessageParameters(), "ALL") == null)) {
/*  90 */       return;
/*     */     }
/*  92 */     if ((message.getMessageText() == null) || (message.getMessageText().trim().equals(""))) {
/*  93 */       return;
/*     */     }
/*     */ 
/*  96 */     String pValue = getParameter(message.getMessageParameters(), "ALL");
/*  97 */     String[] receivers = (String[])null;
/*  98 */     if (pValue != null) {
/*  99 */       if (Boolean.valueOf(pValue).booleanValue()) {
/* 100 */         receivers = getAllReceivers();
/*     */       }
/*     */     }
/*     */     else {
/* 104 */       receivers = message.getReceivers().split(",");
/*     */     }
/* 106 */     if ((receivers == null) && (receivers.length > 0)) {
/* 107 */       return;
/*     */     }
/* 109 */     for (String userMobile : receivers)
/* 110 */       send(userMobile, message.getMessageText());
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 116 */     SMSMessageProvider p = new SMSMessageProvider();
/* 117 */     Message message = new Message();
/* 118 */     message.setReceivers("13681365106");
/* 119 */     message.setMessageText("您好!");
/* 120 */     p.sendMessage(message);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.sysapp.message.sms.modem.SMSMessageProvider
 * JD-Core Version:    0.6.0
 */