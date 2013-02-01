/*     */ package org.hi.common.util;
/*     */ 
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import ognl.NullHandler;
/*     */ import ognl.Ognl;
/*     */ import ognl.OgnlException;
/*     */ import ognl.OgnlRuntime;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.hi.framework.model.BaseObject;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class BeanUtil
/*     */ {
/*  53 */   protected static final Log log = LogFactory.getLog("org.hi.common.util.BeanUtil");
/*     */ 
/*  55 */   private static final Set<String> unIncludes = new HashSet();
/*     */ 
/*  57 */   static { unIncludes.add("class");
/*  58 */     unIncludes.add("parentEntity");
/*  59 */     unIncludes.add("oldValue");
/*  60 */     unIncludes.add("dirty");
/*  61 */     unIncludes.add("dataSymbol");
/*  62 */     unIncludes.add("cascadeDirty");
/*  63 */     unIncludes.add("target");
/*  64 */     unIncludes.add("targetParent");
/*  65 */     unIncludes.add("primarykey");
/*     */   }
/*     */ 
/*     */   public static Object getPropertyValue(Object bean, String propertyName)
/*     */   {
/*     */     try
/*     */     {
/*  76 */       return PropertyUtils.getProperty(bean, propertyName);
/*     */     }
/*     */     catch (Exception e) {
/*  79 */       if (!hasPropertyName(bean, propertyName))
/*  80 */         log.trace("org.hi.common.util.BeanUtil.getPropertyValue propertyName:" + propertyName, e); 
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   public static boolean hasPropertyName(Object bean, String propertyName)
/*     */   {
/*  93 */     String[] propertyNames = StringUtils.strToStrArray(propertyName, ".");
/*  94 */     Class clzz = bean.getClass();
/*  95 */     Field field = null;
/*     */ 
/*  97 */     for (int i = 0; i < propertyNames.length; i++)
/*     */     {
/* 100 */       field = hasClassField(clzz, propertyNames[i]);
/* 101 */       if (field == null) {
/* 102 */         return false;
/*     */       }
/* 104 */       clzz = field.getType();
/*     */     }
/*     */ 
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */   public static Class getProperyClass(Object bean, String propertyName) {
/*     */     try {
/* 112 */       return PropertyUtils.getPropertyType(bean, propertyName);
/*     */     }
/*     */     catch (Exception e) {
/* 115 */       log.trace("org.hi.common.util.BeanUtil.getProperyClass propertyName:" + propertyName, e);
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   private static Field hasClassField(Class clazz, String fieldName)
/*     */   {
/*     */     try
/*     */     {
/* 129 */       return clazz.getDeclaredField(fieldName);
/*     */     } catch (Exception e) {
/* 131 */       if (clazz.equals(Object.class))
/* 132 */         return null; 
/*     */     }
/* 133 */     return hasClassField(clazz.getSuperclass(), fieldName);
/*     */   }
/*     */ 
/*     */   public static String getPropertyValueToStr(Object bean, String propertyName)
/*     */   {
/* 143 */     Object val = getPropertyValue(bean, propertyName);
/*     */ 
/* 145 */     if (val == null) {
/* 146 */       return null;
/*     */     }
/* 148 */     return val.toString();
/*     */   }
/*     */ 
/*     */   public static void setPropertyValue(Object bean, String propertyName, Object value)
/*     */   {
/*     */     try
/*     */     {
/* 159 */       PropertyUtils.setProperty(bean, propertyName, value);
/*     */     } catch (Exception e) {
/* 161 */       log.trace("org.hi.common.util.BeanUtil.setPropertyValue propertyName:" + propertyName + " value:" + value, e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void ognlPropertyValue(Object bean, String propertyName, Object value)
/*     */   {
/*     */     try
/*     */     {
/* 174 */       NullHandler oldNullHandler = OgnlRuntime.getNullHandler(Object.class);
/* 175 */       OgnlRuntime.setNullHandler(Object.class, new StanderNullHandler());
/* 176 */       Ognl.setValue(propertyName, bean, value);
/* 177 */       OgnlRuntime.setNullHandler(Object.class, oldNullHandler);
/*     */     } catch (OgnlException e) {
/* 179 */       log.trace("OgnlException", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void ognlPropertyValue(Object bean, String propertyName)
/*     */   {
/*     */   }
/*     */ 
/*     */   public static Object CreateObject(String className)
/*     */   {
/* 199 */     Object obj = null;
/*     */     try {
/* 201 */       obj = Class.forName(className, true, Thread.currentThread().getContextClassLoader()).newInstance();
/*     */     } catch (Exception e) {
/* 203 */       log.trace("org.hi.common.util.BeanUtil.CreateObject className:" + className, e);
/*     */     }
/* 205 */     return obj;
/*     */   }
/*     */ 
/*     */   /** @deprecated */
/*     */   protected static List encapsulationBeans(List set, String propertyNames, Class clazz)
/*     */   {
/* 217 */     List result = new ArrayList();
/* 218 */     String[] propertyNamesArray = StringUtils.strToStrArray(propertyNames);
/* 219 */     for (Iterator iter = set.iterator(); iter.hasNext(); ) {
/* 220 */       Object bean = CreateObject(clazz.getName());
/*     */ 
/* 222 */       Object obj = iter.next();
/* 223 */       Object[] valueArray = (Object[])null;
/* 224 */       if (obj.getClass().isArray()) {
/* 225 */         valueArray = (Object[])obj;
/*     */       }
/*     */       else {
/* 228 */         valueArray = new Object[1];
/* 229 */         valueArray[0] = obj;
/*     */       }
/*     */ 
/* 232 */       for (int i = 0; i < valueArray.length; i++) {
/* 233 */         ognlPropertyValue(bean, propertyNamesArray[i], valueArray[i]);
/*     */       }
/* 235 */       result.add(bean);
/*     */     }
/* 237 */     return result;
/*     */   }
/*     */ 
/*     */   public static void setBean2Bean(Object resouce, Object targer)
/*     */   {
/* 248 */     PropertyDescriptor[] targerProperties = PropertyUtils.getPropertyDescriptors(targer);
/* 249 */     PropertyDescriptor[] resouceProperties = PropertyUtils.getPropertyDescriptors(resouce);
/* 250 */     for (PropertyDescriptor resouceDescriptor : resouceProperties) {
/* 251 */       String resourceName = resouceDescriptor.getName();
/* 252 */       Class resourceClass = resouceDescriptor.getPropertyType();
/* 253 */       for (PropertyDescriptor targerDescriptor : targerProperties) {
/* 254 */         String targerName = targerDescriptor.getName();
/* 255 */         Class targerClass = targerDescriptor.getPropertyType();
/* 256 */         if ((!resourceName.equals(targerName)) || (!resourceClass.equals(targerClass))) continue;
/*     */         try {
/* 258 */           Object val = getPropertyValue(resouce, resourceName);
/* 259 */           if (val == null)
/*     */             break;
/* 261 */           if ((val instanceof Collection)) {
/* 262 */             Collection resourceCol = (Collection)val;
/* 263 */             if (resourceCol.size() < 1) break;
/* 264 */             Collection targerCol = null;
/* 265 */             if ((val instanceof List))
/* 266 */               targerCol = new ArrayList();
/* 267 */             else if ((val instanceof Set))
/* 268 */               targerCol = new LinkedHashSet();
/*     */             else
/* 270 */               targerCol = (Collection)CreateObject(val.getClass().getName());
/* 271 */             Field field = null;
/*     */             try {
/* 273 */               field = targer.getClass().getDeclaredField(targerName);
/*     */             } catch (NoSuchFieldException e) {
/* 275 */               field = targer.getClass().getSuperclass().getDeclaredField(targerName);
/*     */             }
/* 277 */             field.setAccessible(true);
/* 278 */             field.set(targer, targerCol);
/* 279 */             targerDescriptor.setValue(targerName, targerCol);
/* 280 */             for (Iterator localIterator = resourceCol.iterator(); localIterator.hasNext(); ) { Object resourceObj = localIterator.next();
/* 281 */               Object targerObj = CreateObject(resourceObj.getClass().getName());
/* 282 */               setBean2Bean(resourceObj, targerObj);
/* 283 */               targerCol.add(targerObj);
/*     */             }
/* 280 */             break;
/*     */           }
/*     */ 
/* 287 */           setPropertyValue(targer, targerName, getPropertyValue(resouce, resourceName));
/*     */         }
/*     */         catch (Throwable localThrowable)
/*     */         {
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String getCollection2XML(Collection<Object> collection, String collName, String elementName)
/*     */   {
/* 313 */     if ((collection == null) || (collection.size() == 0)) return "";
/* 314 */     StringBuffer sb = new StringBuffer("<" + collName + ">").append("\n");
/* 315 */     for (Iterator localIterator = collection.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 316 */       sb.append(getBean2XML(object, elementName, 1, new StringBuffer(), new HashSet())); }
/* 317 */     sb.append("</" + collName + ">");
/*     */ 
/* 319 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getBean2XML(Object bean, String elementName)
/*     */   {
/* 329 */     String xml = getBean2XML(bean, elementName, 0, new StringBuffer(), new HashSet());
/* 330 */     return xml;
/*     */   }
/*     */ 
/*     */   private static String getBean2XML(Object bean, String elementName, int deep, StringBuffer sb, Set<String> classes) {
/* 334 */     if (bean == null)
/* 335 */       return null; try {
/* 336 */       bean.hashCode(); } catch (Exception e) {
/* 337 */       return null;
/* 338 */     }String beanHash = String.valueOf(bean.hashCode());
/* 339 */     if ((classes.contains(beanHash)) && (!originalType(bean))) {
/* 340 */       return null;
/*     */     }
/* 342 */     classes.add(beanHash);
/*     */ 
/* 344 */     if ((bean instanceof Collection)) {
/* 345 */       for (Iterator localIterator = ((Collection)bean).iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
/* 346 */         getBean2XML(obj, elementName, deep, sb, classes);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 351 */       for (int i = 0; i < deep; i++) {
/* 352 */         sb.append("\t");
/*     */       }
/* 354 */       if (elementName == null) {
/* 355 */         elementName = StringUtils.lowerFrist(bean.getClass().getSimpleName());
/*     */       }
/* 357 */       sb.append("<").append(elementName).append(">");
/* 358 */       if (!originalType(bean)) {
/* 359 */         sb.append("\n");
/*     */       }
/*     */     }
/* 362 */     if (originalType(bean)) {
/* 363 */       if ((bean instanceof Date)) {
/* 364 */         sb.append(StringUtils.DateToStr((Date)bean, "yyyy-MM-dd HH:mm:ss"));
/* 365 */       } else if ((bean instanceof String)) {
/* 366 */         bean = StringUtils.replace((String)bean, "<", "&lt;");
/* 367 */         bean = StringUtils.replace((String)bean, ">", "&gt;");
/* 368 */         bean = StringUtils.replace((String)bean, "&", "&amp;");
/* 369 */         sb.append(bean);
/*     */       }
/*     */       else {
/* 372 */         sb.append(bean.toString());
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 377 */       PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
/* 378 */       for (PropertyDescriptor propertyDescriptor : beanProperties) {
/* 379 */         if ((propertyDescriptor.getReadMethod() == null) || (propertyDescriptor.getWriteMethod() == null))
/*     */           continue;
/* 381 */         String propertyName = propertyDescriptor.getName();
/* 382 */         Object propertyValue = getPropertyValue(bean, propertyName);
/*     */ 
/* 384 */         getBean2XML(propertyValue, propertyName, deep + 1, sb, classes);
/*     */       }
/*     */     }
/*     */ 
/* 388 */     if (!(bean instanceof Collection)) {
/* 389 */       if (!originalType(bean)) {
/* 390 */         for (int i = 0; i < deep; i++)
/* 391 */           sb.append("\t");
/*     */       }
/* 393 */       sb.append("</").append(elementName).append(">").append("\n");
/*     */     }
/* 395 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   protected static boolean originalType(Object bean)
/*     */   {
/* 404 */     return ((bean instanceof Boolean)) || ((bean instanceof Character)) || 
/* 400 */       ((bean instanceof Double)) || ((bean instanceof Float)) || 
/* 401 */       ((bean instanceof Integer)) || ((bean instanceof Long)) || 
/* 402 */       ((bean instanceof Short)) || ((bean instanceof String)) || 
/* 403 */       ((bean instanceof Date)) || ((bean instanceof Locale)) || 
/* 404 */       ((bean instanceof Timestamp));
/*     */   }
/*     */ 
/*     */   public static Object getXML2BeanByInputStream(InputStream is, Class clazz)
/*     */   {
/* 415 */     if (is == null)
/* 416 */       return null;
/* 417 */     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*     */     try {
/* 419 */       DocumentBuilder builder = factory.newDocumentBuilder();
/* 420 */       Document doc = builder.parse(is);
/* 421 */       Object localObject2 = getXML2Bean(doc.getDocumentElement(), clazz);
/*     */       return localObject2;
/*     */     }
/*     */     catch (Exception e) {
/* 424 */       e.printStackTrace();
/*     */     }
/*     */     finally {
/* 427 */       if (is != null)
/*     */         try {
/* 429 */           is.close();
/*     */         } catch (IOException e) {
/* 431 */           e.printStackTrace();
/*     */         }
/*     */     }
/* 434 */     return null;
/*     */   }
/*     */ 
/*     */   public static Object getXML2Bean(String xml, Class clazz)
/*     */   {
/* 444 */     InputStream is = null;
/*     */     try {
/* 446 */       is = new ByteArrayInputStream(xml.getBytes("utf-8"));
/*     */     } catch (UnsupportedEncodingException e) {
/* 448 */       e.printStackTrace();
/*     */     }
/* 450 */     return getXML2BeanByInputStream(is, clazz);
/*     */   }
/*     */ 
/*     */   private static Object getXML2Bean(Node node, Class clazz) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ParseException, NoSuchFieldException {
/* 454 */     Object bean = CreateObject(clazz.getName());
/* 455 */     PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
/* 456 */     NodeList nodeList = node.getChildNodes();
/*     */ 
/* 458 */     for (PropertyDescriptor propertyDescriptor : beanProperties) {
/* 459 */       if ((propertyDescriptor.getReadMethod() == null) || (propertyDescriptor.getWriteMethod() == null))
/*     */         continue;
/* 461 */       String propertyName = propertyDescriptor.getName();
/* 462 */       Class propertyClass = originalWrapper(propertyDescriptor.getPropertyType());
/* 463 */       Object value = null;
/* 464 */       for (int i = 0; i < nodeList.getLength(); i++) {
/* 465 */         Node propertyNode = nodeList.item(i);
/* 466 */         if (propertyNode.getNodeType() != 1)
/*     */           continue;
/* 468 */         Element element = (Element)propertyNode;
/* 469 */         if (!element.getTagName().equals(propertyName))
/*     */         {
/*     */           continue;
/*     */         }
/* 473 */         if (Collection.class.isAssignableFrom(propertyClass)) {
/* 474 */           if (getPropertyValue(bean, propertyName) != null) {
/*     */             continue;
/*     */           }
/* 477 */           Field field = hasClassField(clazz, propertyName);
/* 478 */           ParameterizedType type = (ParameterizedType)field.getGenericType();
/* 479 */           Type[] types = type.getActualTypeArguments();
/* 480 */           Class elementClass = (Class)types[0];
/*     */ 
/* 483 */           Collection deails = null;
/* 484 */           if (List.class.isAssignableFrom(propertyClass))
/* 485 */             deails = new ArrayList();
/* 486 */           if (Set.class.isAssignableFrom(propertyClass)) {
/* 487 */             deails = new HashSet();
/*     */           }
/* 489 */           for (int j = 0; j < nodeList.getLength(); j++) {
/* 490 */             Node elementNode = nodeList.item(j);
/* 491 */             if (elementNode.getNodeType() != 1)
/*     */               continue;
/* 493 */             Element nodeElement = (Element)elementNode;
/* 494 */             if (!nodeElement.getTagName().equals(propertyName)) {
/*     */               continue;
/*     */             }
/* 497 */             deails.add(getXML2Bean(nodeElement, elementClass));
/*     */           }
/*     */ 
/* 501 */           setPropertyValue(bean, propertyName, deails);
/*     */         }
/* 506 */         else if ((!propertyClass.equals(Boolean.class)) && (!propertyClass.equals(Character.class)) && 
/* 507 */           (!propertyClass.equals(Double.class)) && (!propertyClass.equals(Float.class)) && 
/* 508 */           (!propertyClass.equals(Integer.class)) && (!propertyClass.equals(Long.class)) && 
/* 509 */           (!propertyClass.equals(Short.class)) && (!propertyClass.equals(String.class)) && 
/* 510 */           (!propertyClass.equals(Date.class)) && (!propertyClass.equals(Timestamp.class))) {
/* 511 */           value = getXML2Bean(element, propertyClass);
/* 512 */           setPropertyValue(bean, propertyName, value);
/*     */         }
/*     */         else
/*     */         {
/* 517 */           String textContent = element.getTextContent();
/* 518 */           if ((propertyClass.equals(Date.class)) || (propertyClass.equals(Timestamp.class))) {
/* 519 */             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 520 */             value = formatter.parse(textContent);
/* 521 */             if (propertyClass.equals(Timestamp.class))
/* 522 */               value = new Timestamp(((Date)value).getTime());
/*     */           }
/*     */           else
/*     */           {
/* 526 */             Constructor constructor = propertyClass.getConstructor(new Class[] { String.class });
/* 527 */             value = constructor.newInstance(new Object[] { textContent });
/*     */           }
/* 529 */           setPropertyValue(bean, propertyName, value);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 534 */     return bean;
/*     */   }
/*     */ 
/*     */   public static Class originalWrapper(Class clazz)
/*     */   {
/* 543 */     if (clazz.equals(Boolean.TYPE)) return Boolean.class;
/* 544 */     if (clazz.equals(Integer.TYPE)) return Integer.class;
/* 545 */     if (clazz.equals(Double.TYPE)) return Double.class;
/* 546 */     if (clazz.equals(Float.TYPE)) return Float.class;
/* 547 */     if (clazz.equals(Character.TYPE)) return Character.class;
/* 548 */     if (clazz.equals(Long.TYPE)) return Long.class;
/* 549 */     if (clazz.equals(Short.TYPE)) return Short.class;
/* 550 */     return clazz;
/*     */   }
/*     */ 
/*     */   public static String getCollection2JSON(Collection col, String collName)
/*     */   {
/* 560 */     return getCollection2JSON(col, collName, null, false);
/*     */   }
/*     */ 
/*     */   public static String getCollection2JSON(Collection col, String collName, String properies, boolean isObject)
/*     */   {
/* 570 */     if (col == null)
/* 571 */       return "";
/* 572 */     StringBuffer sb = new StringBuffer("");
/* 573 */     if (isObject)
/* 574 */       sb.append("{");
/* 575 */     if (collName != null) {
/* 576 */       sb.append("\"").append(collName).append("\"");
/* 577 */       sb.append(":");
/*     */     }
/* 579 */     sb.append(getCollection2JSONValue(col, collName, properies, 0));
/*     */ 
/* 581 */     if (isObject)
/* 582 */       sb.append("}");
/* 583 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   protected static String getCollection2JSONValue(Collection col, String collName, String properies, int level) {
/* 587 */     if (col == null) {
/* 588 */       return "[]";
/*     */     }
/* 590 */     StringBuffer sb = new StringBuffer("");
/* 591 */     sb.append("[");
/* 592 */     int i = 0;
/* 593 */     for (Iterator localIterator = col.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 594 */       if (i > 0)
/* 595 */         sb.append(",");
/* 596 */       i++;
/* 597 */       sb.append(getBean2JSON(object, properies, level));
/*     */     }
/* 599 */     sb.append("]");
/*     */ 
/* 601 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static String getBean2JSON(Object bean)
/*     */   {
/* 610 */     return getBean2JSON(bean, null);
/*     */   }
/*     */ 
/*     */   public static String getBean2JSON(Object bean, String properies)
/*     */   {
/* 622 */     return getBean2JSON(bean, properies, 0);
/*     */   }
/*     */ 
/*     */   private static String getBean2JSON(Object bean, String properies, int level) {
/* 626 */     if (bean == null)
/* 627 */       return "";
/* 628 */     StringBuffer sb = new StringBuffer("{");
/* 629 */     List propertisList = new ArrayList();
/*     */     PropertyDescriptor propertyDescriptor;
/* 630 */     if (properies == null) {
/* 631 */       PropertyDescriptor[] beanProperties = PropertyUtils.getPropertyDescriptors(bean);
/*     */ 
/* 633 */       for (propertyDescriptor : beanProperties) {
/* 634 */         String propertyName = propertyDescriptor.getName();
/* 635 */         if (unIncludes.contains(propertyName))
/*     */           continue;
/* 637 */         propertisList.add(propertyName);
/*     */       }
/*     */     }
/*     */     else {
/* 641 */       propertisList = StringUtils.strToArrayList(properies);
/*     */     }
/*     */ 
/* 644 */     Map map = new HashMap();
/*     */     int index;
/* 645 */     for (String propertyName : propertisList) {
/* 646 */       if (propertyName.indexOf(".") > 0) {
/* 647 */         index = propertyName.indexOf(".");
/* 648 */         String domainName = propertyName.substring(0, index);
/* 649 */         String endName = propertyName.substring(index + 1);
/* 650 */         if (map.get(domainName) == null) {
/* 651 */           List doaminProperties = new ArrayList();
/* 652 */           doaminProperties.add(endName);
/* 653 */           map.put(domainName, doaminProperties);
/*     */         }
/*     */         else {
/* 656 */           ((List)map.get(domainName)).add(endName);
/*     */         }
/*     */       }
/*     */       else {
/* 660 */         map.put(propertyName, null);
/*     */       }
/*     */     }
/* 663 */     int i = 0;
/* 664 */     for (Map.Entry entry : map.entrySet())
/*     */     {
/* 666 */       if (i > 0)
/* 667 */         sb.append(",");
/* 668 */       i++;
/* 669 */       String propertyName = (String)entry.getKey();
/*     */ 
/* 671 */       Object val = getPropertyValue(bean, propertyName);
/* 672 */       Class propertyClazz = getProperyClass(bean, propertyName);
/* 673 */       sb.append("\"").append(propertyName).append("\"");
/* 674 */       sb.append(":");
/*     */ 
/* 676 */       if (Collection.class.isAssignableFrom(propertyClazz)) {
/* 677 */         String collProperties = null;
/* 678 */         if (entry.getValue() != null) {
/* 679 */           collProperties = StringUtils.CollectionToStr((Collection)entry.getValue());
/*     */         }
/* 681 */         level++; sb.append(getCollection2JSONValue((Collection)val, propertyName, collProperties, level));
/* 682 */         level--;
/*     */       }
/* 684 */       else if (BaseObject.class.isAssignableFrom(propertyClazz)) {
/* 685 */         if ((entry.getValue() != null) || (level < 1)) {
/* 686 */           if (val == null) {
/* 687 */             Class properyClass = getProperyClass(bean, propertyName);
/* 688 */             val = CreateObject(properyClass.getName());
/*     */           }
/* 690 */           level++; sb.append(getBean2JSON(val, entry.getValue() == null ? null : StringUtils.CollectionToStr((Collection)entry.getValue()), level));
/* 691 */           level--;
/*     */         }
/* 693 */         if ((entry.getValue() == null) && (level >= 1))
/* 694 */           sb.append("\"\"");
/*     */       }
/*     */       else
/*     */       {
/* 698 */         sb.append("\"");
/* 699 */         if (val == null)
/* 700 */           sb.append("");
/* 701 */         else if ((val instanceof Date))
/* 702 */           sb.append(StringUtils.DateToStr((Date)val, "yyyy-MM-dd"));
/* 703 */         else if ((val instanceof Timestamp)) {
/* 704 */           sb.append(StringUtils.DateToStr(new Date(((Timestamp)val).getTime()), "yyyy-MM-dd hh:mm:ss"));
/*     */         }
/*     */         else {
/* 707 */           sb.append(StringUtils.escapeHtml(getPropertyValueToStr(bean, propertyName)));
/*     */         }
/*     */ 
/* 710 */         sb.append("\"");
/*     */       }
/*     */     }
/*     */ 
/* 714 */     sb.append("}");
/* 715 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.common.util.BeanUtil
 * JD-Core Version:    0.6.0
 */