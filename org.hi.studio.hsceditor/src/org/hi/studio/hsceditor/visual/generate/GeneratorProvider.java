/*    */ package org.hi.studio.hsceditor.visual.generate;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.eclipse.core.runtime.IConfigurationElement;
/*    */ import org.eclipse.core.runtime.IExtension;
/*    */ import org.eclipse.core.runtime.IExtensionPoint;
/*    */ import org.eclipse.core.runtime.IExtensionRegistry;
/*    */ import org.eclipse.core.runtime.Platform;
/*    */ import org.hi.studio.hsceditor.DBPlugin;
/*    */ 
/*    */ public class GeneratorProvider
/*    */ {
/* 20 */   private static List<IGenerator> contributedGenerators = null;
/*    */ 
/*    */   public static IGenerator[] getGeneraters() {
/* 23 */     if (contributedGenerators == null)
/*    */     {
/* 25 */       contributedGenerators = new ArrayList();
/*    */ 
/* 27 */       IExtensionRegistry registry = Platform.getExtensionRegistry();
/* 28 */       IExtensionPoint point = registry.getExtensionPoint("org.hi.studio.hsceditor.generators");
/* 29 */       IExtension[] extensions = point.getExtensions();
/*    */ 
/* 31 */       for (int i = 0; i < extensions.length; i++) {
/* 32 */         IConfigurationElement[] elements = extensions[i].getConfigurationElements();
/* 33 */         for (int j = 0; j < elements.length; j++) {
/*    */           try {
/* 35 */             if ("generator".equals(elements[j].getName())) {
/* 36 */               IGenerator generator = (IGenerator)elements[j].createExecutableExtension("class");
/* 37 */               contributedGenerators.add(generator);
/*    */             }
/*    */           } catch (Exception ex) {
/* 40 */             DBPlugin.logException(ex);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 46 */     return (IGenerator[])contributedGenerators.toArray(new IGenerator[contributedGenerators.size()]);
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.GeneratorProvider
 * JD-Core Version:    0.6.0
 */