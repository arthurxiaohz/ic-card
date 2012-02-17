/*     */ package org.hi.studio.core.utils;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import org.eclipse.core.runtime.Plugin;
/*     */ import org.eclipse.jface.resource.ImageDescriptor;
/*     */ import org.eclipse.swt.graphics.Image;
/*     */ import org.hi.studio.core.log.LogMessage;
/*     */ import org.hi.studio.core.plugin.HiCorePlugin;
/*     */ import org.osgi.framework.Bundle;
/*     */ 
/*     */ public class ImageUtil
/*     */ {
/*  24 */   private HashMap fImageRegistry = new HashMap(10);
/*     */ 
/*  26 */   private HashMap fTemplateRegistry = new HashMap(10);
/*     */   private static ImageUtil resourceInstance;
/*     */ 
/*     */   public static ImageUtil getInstance()
/*     */   {
/*  42 */     if (resourceInstance == null) {
/*  43 */       resourceInstance = new ImageUtil();
/*     */     }
/*     */ 
/*  46 */     return resourceInstance;
/*     */   }
/*     */ 
/*     */   public Image getImage(String path)
/*     */   {
/*  60 */     ImageDescriptor descriptor = getImageDescriptor(path);
/*     */ 
/*  62 */     Image result = (Image)this.fImageRegistry.get(descriptor);
/*  63 */     if (result != null) {
/*  64 */       return result;
/*     */     }
/*  66 */     result = descriptor.createImage();
/*     */ 
/*  69 */     if (result != null) {
/*  70 */       this.fImageRegistry.put(descriptor, result);
/*     */     }
/*  72 */     return result;
/*     */   }
/*     */ 
/*     */   public ImageDescriptor getImageDescriptor(String path)
/*     */   {
/*  86 */     Plugin plugin = HiCorePlugin.getDefault();
/*     */ 
/*  88 */     if ((plugin == null) || (plugin.getBundle() == null)) {
/*  89 */       LogMessage.logInfo("鎻掍欢涓虹┖");
/*  90 */       return null;
/*     */     }
/*  92 */     URL baseUrl = plugin.getBundle().getEntry("/");
/*  93 */     URL url = null;
/*     */     try {
/*  95 */       url = new URL(baseUrl, path);
/*     */     } catch (MalformedURLException e) {
/*  97 */       LogMessage.logError(plugin.toString() + ":鑾峰彇鍥剧墖URL鍑洪敊", e);
/*     */     }
/*  99 */     return ImageDescriptor.createFromURL(url) == null ? 
/* 100 */       ImageDescriptor.getMissingImageDescriptor() : 
/* 101 */       ImageDescriptor.createFromURL(url);
/*     */   }
/*     */ 
/*     */   public String getString()
/*     */   {
/* 109 */     return "";
/*     */   }
/*     */ 
/*     */   public String getTemplateString(String path)
/*     */   {
/* 117 */     Plugin plugin = HiCorePlugin.getDefault();
/* 118 */     String result = null;
/*     */     try
/*     */     {
/* 122 */       URL baseUrl = plugin.getBundle().getEntry("/");
/* 123 */       URL url = new URL(baseUrl, path);
/* 124 */       result = (String)this.fTemplateRegistry.get(url);
/* 125 */       if (result != null) {
/* 126 */         return result;
/*     */       }
/*     */ 
/* 129 */       File tempFile = new File(url.toURI());
/*     */ 
/* 132 */       result = FileUtil.readByEncoding(tempFile, "utf-8");
/*     */ 
/* 134 */       this.fTemplateRegistry.put(url, result);
/*     */     }
/*     */     catch (Exception e) {
/* 137 */       LogMessage.logError(plugin.toString() + ":鑾峰彇妯℃澘鏂囦欢鍑洪敊", e);
/*     */     }
/*     */ 
/* 140 */     return result;
/*     */   }
/*     */ 
/*     */   public void dispose()
/*     */   {
/* 148 */     for (Iterator iter = this.fImageRegistry.values().iterator(); iter.hasNext(); ) {
/* 149 */       Image image = (Image)iter.next();
/* 150 */       image.dispose();
/*     */     }
/* 152 */     this.fImageRegistry.clear();
/*     */ 
/* 157 */     this.fTemplateRegistry.clear();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.utils.ImageUtil
 * JD-Core Version:    0.6.0
 */