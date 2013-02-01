/*     */ package org.hi.common.util;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ 
/*     */ public class JSONObject
/*     */ {
/*  31 */   private Map<String, JSONInfo> objects = new HashMap();
/*     */ 
/*     */   public JSONObject(String jsonPropertyName, Object obj)
/*     */   {
/*  39 */     if ((jsonPropertyName != null) && (obj != null))
/*  40 */       this.objects.put(jsonPropertyName, new JSONInfo(obj, null));
/*     */   }
/*     */ 
/*     */   public JSONObject(String jsonPropertyName, Object obj, String objectProperties)
/*     */   {
/*  53 */     if ((jsonPropertyName != null) && (obj != null))
/*  54 */       this.objects.put(jsonPropertyName, new JSONInfo(obj, objectProperties));
/*     */   }
/*     */ 
/*     */   public void addJSONObject(String jsonPropertyName, Object obj)
/*     */   {
/*  63 */     addJSONObject(jsonPropertyName, obj, null);
/*     */   }
/*     */ 
/*     */   public void addJSONObject(String jsonPropertyName, Object obj, String objectProperties)
/*     */   {
/*  75 */     if ((jsonPropertyName != null) && (obj != null))
/*  76 */       this.objects.put(jsonPropertyName, new JSONInfo(obj, objectProperties));
/*     */   }
/*     */ 
/*     */   public void removeJSONObject(String jsonPropertyName)
/*     */   {
/*  84 */     this.objects.remove(jsonPropertyName);
/*     */   }
/*     */ 
/*     */   public boolean isJSONObject(String jsonPropertyName)
/*     */   {
/*  93 */     return this.objects.containsKey(jsonPropertyName);
/*     */   }
/*     */ 
/*     */   public Object getJSONObject(String jsonPropertyName)
/*     */   {
/* 102 */     if (this.objects.get(jsonPropertyName) == null)
/* 103 */       return null;
/* 104 */     return ((JSONInfo)this.objects.get(jsonPropertyName)).getObj();
/*     */   }
/*     */ 
/*     */   public String getJSON()
/*     */   {
/* 112 */     return toString();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 120 */     StringBuffer sb = new StringBuffer("{");
/* 121 */     int i = 0;
/* 122 */     for (Map.Entry entry : this.objects.entrySet()) {
/* 123 */       JSONInfo info = (JSONInfo)entry.getValue();
/* 124 */       String jsonPropertyName = (String)entry.getKey();
/* 125 */       if (info == null) {
/*     */         continue;
/*     */       }
/* 128 */       if (i > 0)
/* 129 */         sb.append(",");
/* 130 */       i++;
/*     */ 
/* 132 */       sb.append("\"").append(jsonPropertyName).append("\"");
/* 133 */       sb.append(":");
/*     */ 
/* 135 */       Object obj = info.getObj();
/*     */ 
/* 137 */       if (((obj instanceof String)) || ((obj instanceof Date)) || ((obj instanceof Timestamp))) {
/* 138 */         sb.append("\"");
/*     */       }
/* 140 */       if ((obj instanceof Collection))
/* 141 */         sb.append(BeanUtil.getCollection2JSON((Collection)obj, null, info.getProperties(), false));
/* 142 */       else if ((obj instanceof BaseObject))
/* 143 */         sb.append(BeanUtil.getBean2JSON(obj, info.getProperties()));
/* 144 */       else if ((obj instanceof Date))
/* 145 */         sb.append(StringUtils.DateToStr((Date)obj, "yyyy-MM-dd"));
/* 146 */       else if ((obj instanceof Timestamp))
/* 147 */         sb.append(StringUtils.DateToStr(new Date(((Timestamp)obj).getTime()), "yyyy-MM-dd hh:mm:ss"));
/*     */       else {
/* 149 */         sb.append(obj.toString());
/*     */       }
/* 151 */       if (((obj instanceof String)) || ((obj instanceof Date)) || ((obj instanceof Timestamp))) {
/* 152 */         sb.append("\"");
/*     */       }
/*     */     }
/* 155 */     sb.append("}");
/* 156 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static Object json2Bean(String json, Class clazz)
/*     */   {
/* 166 */     GsonBuilder builder = new GsonBuilder();
/* 167 */     Gson gson = builder.create();
/* 168 */     return gson.fromJson(json, clazz);
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.JSONObject
 * JD-Core Version:    0.6.0
 */