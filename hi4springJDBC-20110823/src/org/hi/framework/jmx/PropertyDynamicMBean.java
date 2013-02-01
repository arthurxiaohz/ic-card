/*     */ package org.hi.framework.jmx;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeSet;
/*     */ import javax.management.Attribute;
/*     */ import javax.management.AttributeList;
/*     */ import javax.management.AttributeNotFoundException;
/*     */ import javax.management.DynamicMBean;
/*     */ import javax.management.InvalidAttributeValueException;
/*     */ import javax.management.MBeanAttributeInfo;
/*     */ import javax.management.MBeanException;
/*     */ import javax.management.MBeanInfo;
/*     */ import javax.management.MBeanOperationInfo;
/*     */ import javax.management.ReflectionException;
/*     */ 
/*     */ public class PropertyDynamicMBean
/*     */   implements DynamicMBean
/*     */ {
/*     */   private final String propertyFileName;
/*     */   private final Properties properties;
/*     */ 
/*     */   public PropertyDynamicMBean(String propertyFileName)
/*     */     throws IOException
/*     */   {
/*  29 */     this.propertyFileName = propertyFileName;
/*  30 */     this.properties = new Properties();
/*  31 */     load();
/*     */   }
/*     */ 
/*     */   public synchronized String getAttribute(String name) throws AttributeNotFoundException
/*     */   {
/*  36 */     String value = this.properties.getProperty(name);
/*  37 */     if (value != null) {
/*  38 */       return value;
/*     */     }
/*  40 */     throw new AttributeNotFoundException("No such property: " + name);
/*     */   }
/*     */ 
/*     */   public synchronized void setAttribute(Attribute attribute) throws InvalidAttributeValueException, MBeanException, AttributeNotFoundException
/*     */   {
/*  45 */     String name = attribute.getName();
/*  46 */     if (this.properties.getProperty(name) == null)
/*  47 */       throw new AttributeNotFoundException(name);
/*  48 */     Object value = attribute.getValue();
/*  49 */     if (!(value instanceof String)) {
/*  50 */       throw new InvalidAttributeValueException(
/*  51 */         "Attribute value not a string: " + value);
/*     */     }
/*  53 */     this.properties.setProperty(name, (String)value);
/*     */     try {
/*  55 */       save();
/*     */     } catch (IOException e) {
/*  57 */       throw new MBeanException(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public synchronized AttributeList getAttributes(String[] names) {
/*  62 */     AttributeList list = new AttributeList();
/*  63 */     for (String name : names) {
/*  64 */       String value = this.properties.getProperty(name);
/*  65 */       if (value != null)
/*  66 */         list.add(new Attribute(name, value));
/*     */     }
/*  68 */     return list;
/*     */   }
/*     */ 
/*     */   public synchronized AttributeList setAttributes(AttributeList list) {
/*  72 */     Attribute[] attrs = (Attribute[])list.toArray(new Attribute[0]);
/*  73 */     AttributeList retlist = new AttributeList();
/*  74 */     for (Attribute attr : attrs) {
/*  75 */       String name = attr.getName();
/*  76 */       Object value = attr.getValue();
/*  77 */       if ((this.properties.getProperty(name) != null) && ((value instanceof String))) {
/*  78 */         this.properties.setProperty(name, (String)value);
/*  79 */         retlist.add(new Attribute(name, value));
/*     */       }
/*     */     }
/*     */     try {
/*  83 */       save();
/*     */     } catch (IOException e) {
/*  85 */       return new AttributeList();
/*     */     }
/*  87 */     return retlist;
/*     */   }
/*     */ 
/*     */   public Object invoke(String name, Object[] args, String[] sig) throws MBeanException, ReflectionException
/*     */   {
/*  92 */     if ((name.equals("reload")) && 
/*  93 */       ((args == null) || (args.length == 0)) && (
/*  94 */       (sig == null) || (sig.length == 0))) {
/*     */       try {
/*  96 */         load();
/*  97 */         return null;
/*     */       } catch (IOException e) {
/*  99 */         throw new MBeanException(e);
/*     */       }
/*     */     }
/* 102 */     throw new ReflectionException(new NoSuchMethodException(name));
/*     */   }
/*     */ 
/*     */   public synchronized MBeanInfo getMBeanInfo() {
/* 106 */     SortedSet names = new TreeSet();
/* 107 */     for (Iterator localIterator1 = this.properties.keySet().iterator(); localIterator1.hasNext(); ) { Object name = localIterator1.next();
/* 108 */       names.add((String)name); }
/* 109 */     MBeanAttributeInfo[] attrs = new MBeanAttributeInfo[names.size()];
/* 110 */     Iterator it = names.iterator();
/* 111 */     for (int i = 0; i < attrs.length; i++) {
/* 112 */       String name = (String)it.next();
/* 113 */       attrs[i] = 
/* 119 */         new MBeanAttributeInfo(name, 
/* 115 */         "java.lang.String", 
/* 116 */         "Property " + name, 
/* 117 */         true, 
/* 118 */         true, 
/* 119 */         false);
/*     */     }
/* 121 */     MBeanOperationInfo[] opers = { 
/* 122 */       new MBeanOperationInfo(
/* 123 */       "reload", 
/* 124 */       "Reload properties from file", 
/* 125 */       null, 
/* 126 */       "void", 
/* 127 */       1) };
/*     */ 
/* 129 */     return new MBeanInfo(
/* 130 */       getClass().getName(), 
/* 131 */       "Property Manager MBean", 
/* 132 */       attrs, 
/* 133 */       null, 
/* 134 */       opers, 
/* 135 */       null);
/*     */   }
/*     */ 
/*     */   private void load() throws IOException {
/* 139 */     InputStream input = new FileInputStream(this.propertyFileName);
/* 140 */     this.properties.load(input);
/* 141 */     input.close();
/*     */   }
/*     */ 
/*     */   private void save() throws IOException {
/* 145 */     String newPropertyFileName = this.propertyFileName + "$$new";
/* 146 */     File file = new File(newPropertyFileName);
/* 147 */     OutputStream output = new FileOutputStream(file);
/* 148 */     String comment = "Written by " + getClass().getName();
/* 149 */     this.properties.store(output, comment);
/* 150 */     output.close();
/* 151 */     if (!file.renameTo(new File(this.propertyFileName)))
/* 152 */       throw new IOException("Rename " + newPropertyFileName + " to " + 
/* 153 */         this.propertyFileName + " failed");
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.jmx.PropertyDynamicMBean
 * JD-Core Version:    0.6.0
 */