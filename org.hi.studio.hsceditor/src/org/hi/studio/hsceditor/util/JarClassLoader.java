/*    */ package org.hi.studio.hsceditor.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.net.URLClassLoader;
/*    */ import java.sql.Driver;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Enumeration;
/*    */ import java.util.List;
/*    */ import java.util.jar.JarEntry;
/*    */ import java.util.jar.JarFile;
/*    */ 
/*    */ public class JarClassLoader extends URLClassLoader
/*    */ {
/*    */   public JarClassLoader(URL url)
/*    */   {
/* 16 */     super(new URL[] { url });
/*    */   }
/*    */ 
/*    */   public JarClassLoader(URL[] urls) {
/* 20 */     super(urls);
/*    */   }
/*    */ 
/*    */   public void getJDBCDriverClass(List<Class<?>> list, Class<?> cls, Class<?> org) {
/* 24 */     Class[] interfaces = cls.getInterfaces();
/* 25 */     for (int i = 0; i < interfaces.length; i++) {
/* 26 */       interfaces[i].getInterfaces();
/* 27 */       if (interfaces[i].equals(Driver.class)) {
/* 28 */         list.add(org);
/*    */       }
/*    */     }
/* 31 */     Class s = cls.getSuperclass();
/* 32 */     if (s != null)
/* 33 */       getJDBCDriverClass(list, s, org);
/*    */   }
/*    */ 
/*    */   public List<Class<?>> getJDBCDriverClass(String jarName) throws IOException, ClassNotFoundException
/*    */   {
/* 38 */     if (jarName.equals("")) {
/* 39 */       return Collections.emptyList();
/*    */     }
/* 41 */     JarFile jarFile = new JarFile(jarName);
/* 42 */     Enumeration e = jarFile.entries();
/* 43 */     ArrayList list = new ArrayList();
/* 44 */     while (e.hasMoreElements()) {
/* 45 */       JarEntry entry = (JarEntry)e.nextElement();
/* 46 */       String name = entry.getName();
/* 47 */       if (name.lastIndexOf(".class") != -1) {
/* 48 */         String ccls = name.replaceFirst(".class", "").replaceAll("/", ".");
/*    */         try {
/* 50 */           Class cls = loadClass(ccls, true);
/* 51 */           getJDBCDriverClass(list, cls, cls);
/*    */         } catch (NoClassDefFoundError localNoClassDefFoundError) {
/*    */         } catch (ClassNotFoundException localClassNotFoundException) {
/*    */         }
/*    */       }
/*    */     }
/* 57 */     return list;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.util.JarClassLoader
 * JD-Core Version:    0.6.0
 */