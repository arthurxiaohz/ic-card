/*    */ package org.hi.studio.core.plugin;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.eclipse.jface.resource.ImageDescriptor;
/*    */ import org.eclipse.osgi.baseadaptor.BaseData;
/*    */ import org.eclipse.osgi.baseadaptor.bundlefile.BundleFile;
/*    */ import org.eclipse.osgi.framework.internal.core.BundleHost;
/*    */ import org.eclipse.ui.plugin.AbstractUIPlugin;
/*    */ import org.osgi.framework.BundleContext;
/*    */ 
/*    */ public class HiCorePlugin extends AbstractUIPlugin
/*    */ {
/*    */   public static final String PLUGIN_ID = "org.hi.studio.core";
/*    */   private static HiCorePlugin plugin;
/*    */ 
/*    */   public void start(BundleContext context)
/*    */     throws Exception
/*    */   {
/* 33 */     super.start(context);
/* 34 */     plugin = this;
/*    */   }
/*    */ 
/*    */   public void stop(BundleContext context)
/*    */     throws Exception
/*    */   {
/* 42 */     plugin = null;
/* 43 */     super.stop(context);
/*    */   }
/*    */ 
/*    */   public static HiCorePlugin getDefault()
/*    */   {
/* 52 */     return plugin;
/*    */   }
/*    */ 
/*    */   public static ImageDescriptor getImageDescriptor(String path)
/*    */   {
/* 63 */     return imageDescriptorFromPlugin("org.hi.studio.core", path);
/*    */   }
/*    */ 
/*    */   public static String getCurrentPluginDirectory()
/*    */   {
/* 71 */     BundleHost bundleHost = (BundleHost)getDefault().getBundle();
/*    */ 
/* 74 */     BaseData data = (BaseData)bundleHost.getBundleData();
/* 75 */     String currentDir = data.getBundleFile().getBaseFile().getAbsolutePath();
/* 76 */     return currentDir;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.plugin.HiCorePlugin
 * JD-Core Version:    0.6.0
 */