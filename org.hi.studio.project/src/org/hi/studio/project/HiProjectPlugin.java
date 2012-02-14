/*    */ package org.hi.studio.project;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.eclipse.jface.resource.ImageDescriptor;
/*    */ import org.eclipse.osgi.baseadaptor.BaseData;
/*    */ import org.eclipse.osgi.baseadaptor.bundlefile.BundleFile;
/*    */ import org.eclipse.osgi.framework.internal.core.BundleHost;
/*    */ import org.eclipse.ui.plugin.AbstractUIPlugin;
/*    */ import org.osgi.framework.BundleContext;
/*    */ 
/*    */ public class HiProjectPlugin extends AbstractUIPlugin
/*    */ {
/*    */   public static final String PLUGIN_ID = "org.hi.studio.project";
/*    */   private static HiProjectPlugin plugin;
/*    */ 
/*    */   public void start(BundleContext context)
/*    */     throws Exception
/*    */   {
/* 31 */     super.start(context);
/* 32 */     plugin = this;
/*    */   }
/*    */ 
/*    */   public void stop(BundleContext context)
/*    */     throws Exception
/*    */   {
/* 40 */     plugin = null;
/* 41 */     super.stop(context);
/*    */   }
/*    */ 
/*    */   public static HiProjectPlugin getDefault()
/*    */   {
/* 50 */     return plugin;
/*    */   }
/*    */ 
/*    */   public static ImageDescriptor getImageDescriptor(String path)
/*    */   {
/* 61 */     return imageDescriptorFromPlugin("org.hi.studio.project", path);
/*    */   }
/*    */ 
/*    */   public static String getCurrentPluginDirectory()
/*    */   {
/* 69 */     BundleHost bundleHost = (BundleHost)getDefault().getBundle();
/*    */ 
/* 72 */     BaseData data = (BaseData)bundleHost.getBundleData();
/* 73 */     String currentDir = data.getBundleFile().getBaseFile().getAbsolutePath();
/* 74 */     return currentDir;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.project_5.1.8.zip
 * Qualified Name:     org.hi.studio.project.HiProjectPlugin
 * JD-Core Version:    0.6.0
 */