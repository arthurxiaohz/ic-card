/*     */ package org.hi.framework.spring;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.common.tools.Matcher;
/*     */ import org.hi.common.tools.StringMatcher;
/*     */ import org.springframework.core.io.AbstractResource;
/*     */ 
/*     */ public class JarResource extends AbstractResource
/*     */ {
/*  37 */   private static Log log = LogFactory.getLog(JarResource.class);
/*     */ 
/*  41 */   private File file = null;
/*     */ 
/*  45 */   private String context = null;
/*     */ 
/*  49 */   private String path = null;
/*     */ 
/*  51 */   private File jarFile = null;
/*     */ 
/*     */   private JarResource(File jarFile, String context, String path)
/*     */   {
/*  60 */     this.context = context;
/*  61 */     this.path = path;
/*  62 */     this.jarFile = jarFile;
/*     */   }
/*     */ 
/*     */   public static synchronized JarResource[] getInstance(File jar)
/*     */   {
/*  73 */     return getInstance(jar, "*");
/*     */   }
/*     */ 
/*     */   public static synchronized JarResource[] getInstance(File jar, String extension)
/*     */   {
/*  85 */     List resources = new ArrayList();
/*  86 */     JarFile jarFile = null;
/*     */     try
/*     */     {
/*     */       try {
/*  90 */         jarFile = new JarFile(jar);
/*     */       }
/*     */       catch (IOException ioe) {
/*  93 */         throw new RuntimeException(
/*  94 */           "Could not read mapping documents from jar: " + jar.getName());
/*     */       }
/*     */ 
/*  97 */       Matcher matcher = new StringMatcher();
/*  98 */       Enumeration jarEntries = jarFile.entries();
/*  99 */       while (jarEntries.hasMoreElements())
/*     */       {
/* 101 */         ZipEntry ze = (ZipEntry)jarEntries.nextElement();
/*     */ 
/* 103 */         if (matcher.match(extension, ze.getName())) {
/* 104 */           log.info("Found mapping document in jar: " + ze.getName());
/* 105 */           BufferedReader dis = null;
/*     */           try
/*     */           {
/* 109 */             dis = new BufferedReader(new InputStreamReader(jarFile.getInputStream(ze)));
/* 110 */             StringBuffer sb = new StringBuffer();
/*     */             String line;
/* 112 */             while ((line = dis.readLine()) != null)
/*     */             {
/*     */               String line;
/* 113 */               sb.append(line).append("\n");
/*     */             }
/*     */ 
/* 116 */             resources.add(new JarResource(jar, sb.toString(), ze.getName()));
/*     */           }
/*     */           catch (Exception e) {
/* 119 */             throw new RuntimeException(
/* 120 */               "Could not read mapping documents from jar: " + jar.getName());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/* 130 */         if (jarFile != null)
/* 131 */           jarFile.close();
/*     */       }
/*     */       catch (IOException ioe)
/*     */       {
/* 135 */         log.error("could not close jar", ioe);
/*     */       }
/*     */     }
/* 138 */     return (JarResource[])resources.toArray(new JarResource[resources.size()]);
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 142 */     return "jar:" + this.file.getName() + "  resource file:[" + this.path + "]";
/*     */   }
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 150 */     return this.file.getName() + " jar resource file [" + this.path + "]";
/*     */   }
/*     */ 
/*     */   public String getFilename()
/*     */   {
/* 156 */     if (!this.path.contains("/"))
/* 157 */       return this.path;
/* 158 */     return this.path.substring(this.path.lastIndexOf("/") + 1);
/*     */   }
/*     */ 
/*     */   public File getFile()
/*     */   {
/* 165 */     return this.file;
/*     */   }
/*     */ 
/*     */   public String getPath()
/*     */   {
/* 172 */     return this.path;
/*     */   }
/*     */ 
/*     */   public URL getURL()
/*     */     throws IOException
/*     */   {
/* 179 */     return new URL("jar:" + this.jarFile.toURL() + "!/" + getPath());
/*     */   }
/*     */ 
/*     */   public InputStream getInputStream()
/*     */     throws IOException, IllegalStateException
/*     */   {
/* 187 */     return new ByteArrayInputStream(this.context.getBytes("UTF-8"));
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.spring.JarResource
 * JD-Core Version:    0.6.0
 */