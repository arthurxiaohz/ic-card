/*    */ package org.hi.studio.generator;
/*    */ 
/*    */ import org.eclipse.jface.resource.ImageDescriptor;
/*    */ import org.eclipse.ui.plugin.AbstractUIPlugin;
/*    */ import org.osgi.framework.BundleContext;
/*    */ 
/*    */ public class Activator extends AbstractUIPlugin
/*    */ {
/*    */   public static final String PLUGIN_ID = "org.hi.studio.generator";
/*    */   private static Activator plugin;
/*    */ 
/*    */   public void start(BundleContext context)
/*    */     throws Exception
/*    */   {
/* 29 */     super.start(context);
/* 30 */     plugin = this;
/*    */   }
/*    */ 
/*    */   public void stop(BundleContext context)
/*    */     throws Exception
/*    */   {
/* 38 */     plugin = null;
/* 39 */     super.stop(context);
/*    */   }
/*    */ 
/*    */   public static Activator getDefault()
/*    */   {
/* 48 */     return plugin;
/*    */   }
/*    */ 
/*    */   public static ImageDescriptor getImageDescriptor(String path)
/*    */   {
/* 59 */     return imageDescriptorFromPlugin("org.hi.studio.generator", path);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.generator.Activator
 * JD-Core Version:    0.6.0
 */