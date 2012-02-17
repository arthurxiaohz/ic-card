/*    */ package org.hi.studio.hsceditor.visual.editor;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStream;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.hi.studio.core.log.ExceptionManager;
/*    */ import org.hi.studio.core.utils.FileUtil;
/*    */ import org.hi.studio.core.xstream.XStreamSerializer;
/*    */ import org.hi.studio.hsceditor.util.IOUtils;
/*    */ import org.hi.studio.hsceditor.visual.model.RootModel;
/*    */ 
/*    */ public class VisualDBSerializer
/*    */ {
/*    */   public static InputStream serialize(RootModel model)
/*    */     throws UnsupportedEncodingException
/*    */   {
/* 25 */     return XStreamSerializer.serializeStream(model, VisualDBSerializer.class.getClassLoader());
/*    */   }
/*    */ 
/*    */   public static RootModel deserialize(InputStream in) throws UnsupportedEncodingException {
/* 29 */     String xml = IOUtils.loadStream(in, "UTF-8");
/*    */ 
/* 32 */     xml = xml.replaceAll(
/* 33 */       "net\\.java\\.amateras\\.db\\.view\\.dialect\\.ColumnType", 
/* 34 */       "org.hi.studio.hsceditor.dialect.ColumnType");
/*    */ 
/* 36 */     return (RootModel)XStreamSerializer.deserialize(
/* 37 */       new ByteArrayInputStream(xml.getBytes("UTF-8")), 
/* 38 */       VisualDBSerializer.class.getClassLoader());
/*    */   }
/*    */ 
/*    */   public static Map<String, RootModel> parseServiceList(String path)
/*    */   {
/* 48 */     Map resultMap = new HashMap();
/*    */ 
/* 50 */     List fileList = FileUtil.getChildFileByExtension(path, "hmc");
/* 51 */     for (Iterator it = fileList.iterator(); it.hasNext(); ) {
/* 52 */       String file = (String)it.next();
/*    */       try
/*    */       {
/* 55 */         FileInputStream fis = new FileInputStream(file);
/* 56 */         RootModel tempModel = deserialize(fis);
/*    */ 
/* 58 */         resultMap.put(file, tempModel);
/*    */ 
/* 60 */         fis.close();
/*    */       } catch (Exception e) {
/* 62 */         ExceptionManager.logError(e, "parseServiceList error");
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 67 */     return resultMap;
/*    */   }
/*    */ }

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.editor.VisualDBSerializer
 * JD-Core Version:    0.6.0
 */