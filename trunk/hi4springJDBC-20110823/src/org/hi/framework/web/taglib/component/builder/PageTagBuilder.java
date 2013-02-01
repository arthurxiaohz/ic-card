/*     */ package org.hi.framework.web.taglib.component.builder;
/*     */ 
/*     */ import org.hi.framework.HiConfigHolder;
/*     */ import org.hi.framework.paging.Page;
/*     */ import org.hi.framework.web.taglib.component.TagBuilder;
/*     */ import org.hi.framework.web.taglib.component.TagBuilderFactory;
/*     */ import org.hi.framework.web.taglib.component.TagInfoBean;
/*     */ import org.hi.framework.web.taglib.component.bean.PageTagBean;
/*     */ import org.hi.i18n.util.I18NUtil;
/*     */ 
/*     */ public class PageTagBuilder
/*     */   implements TagBuilder
/*     */ {
/*     */   public String build(TagInfoBean bean)
/*     */   {
/*  19 */     PageTagBean pageBean = (PageTagBean)bean;
/*  20 */     StringBuffer sb = new StringBuffer();
/*  21 */     Page page = pageBean.getPage();
/*  22 */     String currentPage = pageBean.getCurrentPage();
/*  23 */     int maxPage = page.getTotalPage();
/*  24 */     int startPage = getStartPage(currentPage);
/*  25 */     int endPage = getEndPage(currentPage, maxPage);
/*     */ 
/*  27 */     String totalCountStr = "共" + page.getTotalRecords() + "条 ";
/*  28 */     if (HiConfigHolder.getI18NLanguage() != null)
/*     */     {
/*  30 */       totalCountStr = I18NUtil.getStringByParameter("总条数", page.getTotalRecords());
/*     */     }
/*  32 */     sb.append(totalCountStr);
/*  33 */     sb.append(getFirstPageStr(currentPage, pageBean));
/*  34 */     sb.append(getBackPageStr(currentPage, pageBean));
/*     */ 
/*  37 */     for (int i = startPage; i <= endPage; i++)
/*     */     {
/*  39 */       if (currentPage.equals(new Integer(i).toString()))
/*     */       {
/*  41 */         sb.append(currentPageStr(new Integer(i).toString(), pageBean));
/*     */       }
/*     */       else {
/*  44 */         sb.append(anchorPageStr(new Integer(i).toString(), i, pageBean));
/*     */       }
/*     */     }
/*     */ 
/*  48 */     String totalPagesStr = " 共" + page.getTotalPage() + "页";
/*  49 */     if (HiConfigHolder.getI18NLanguage() != null) {
/*  50 */       totalPagesStr = I18NUtil.getStringByParameter("总页数", page.getTotalPage());
/*     */     }
/*  52 */     sb.append(getFrontPageStr(currentPage, maxPage, pageBean));
/*  53 */     sb.append(getLastPageStr(currentPage, maxPage, pageBean));
/*  54 */     sb.append(totalPagesStr);
/*  55 */     sb.append(goPage(pageBean));
/*     */ 
/*  57 */     sb.append(getHiddenInput(pageBean));
/*  58 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   private String currentPageStr(String currntPage, PageTagBean pageBean) {
/*  62 */     TagBuilder builder = TagBuilderFactory.getTextTagBuilder();
/*  63 */     TagInfoBean bean = new TagInfoBean();
/*  64 */     bean.setDefaultValue(currntPage);
/*  65 */     String html = builder.build(bean);
/*  66 */     if (pageBean.getCurrentPageClass() != null) {
/*  67 */       html = "<span class=\"" + pageBean.getCurrentPageClass() + "\">" + html + "</span>";
/*     */     }
/*     */ 
/*  70 */     return html + "&nbsp;";
/*     */   }
/*     */ 
/*     */   private String getLastPageStr(String currentPage2, int maxPage, PageTagBean pageBean) {
/*  74 */     int currentPage_i = new Integer(currentPage2).intValue();
/*     */ 
/*  76 */     if (currentPage_i >= maxPage) {
/*  77 */       return textPageStr(I18NUtil.getString("尾页"));
/*     */     }
/*     */ 
/*  80 */     return anchorPageStr(I18NUtil.getString("尾页"), maxPage, pageBean);
/*     */   }
/*     */ 
/*     */   private String getFrontPageStr(String currentPage2, int maxPage, PageTagBean pageBean)
/*     */   {
/*  85 */     int currentPage_i = new Integer(currentPage2).intValue();
/*     */ 
/*  87 */     if (currentPage_i >= maxPage) {
/*  88 */       return textPageStr(I18NUtil.getString("下一页"));
/*     */     }
/*     */ 
/*  91 */     return anchorPageStr(I18NUtil.getString("下一页"), currentPage_i + 1, pageBean);
/*     */   }
/*     */ 
/*     */   private String getBackPageStr(String currentPage2, PageTagBean pageBean)
/*     */   {
/*  97 */     int currentPage_i = new Integer(currentPage2).intValue();
/*     */ 
/*  99 */     if (currentPage_i == 1) {
/* 100 */       return textPageStr(I18NUtil.getString("上一页"));
/*     */     }
/*     */ 
/* 103 */     return anchorPageStr(I18NUtil.getString("上一页"), currentPage_i - 1, pageBean);
/*     */   }
/*     */ 
/*     */   private String getFirstPageStr(String currentPage2, PageTagBean pageBean) {
/* 107 */     int currentPage_i = new Integer(currentPage2).intValue();
/*     */ 
/* 109 */     if (currentPage_i == 1) {
/* 110 */       return textPageStr(I18NUtil.getString("首页"));
/*     */     }
/*     */ 
/* 113 */     return anchorPageStr(I18NUtil.getString("首页"), 1, pageBean);
/*     */   }
/*     */ 
/*     */   private String anchorPageStr(String string, int i, PageTagBean pageBean)
/*     */   {
/* 118 */     TagBuilder builder = TagBuilderFactory.getAnchorTagBuilder();
/*     */ 
/* 120 */     TagInfoBean bean = new TagInfoBean();
/*     */ 
/* 122 */     bean.setUrl("javascript:" + buildJS(i, pageBean));
/*     */ 
/* 124 */     bean.setDefaultValue(string);
/*     */ 
/* 126 */     return builder.build(bean) + "&nbsp;";
/*     */   }
/*     */ 
/*     */   private String textPageStr(String string) {
/* 130 */     TagBuilder builder = TagBuilderFactory.getTextTagBuilder();
/*     */ 
/* 132 */     TagInfoBean bean = new TagInfoBean();
/*     */ 
/* 134 */     bean.setDefaultValue(string);
/*     */ 
/* 136 */     return builder.build(bean) + "&nbsp;";
/*     */   }
/*     */ 
/*     */   private int getEndPage(String currentPage2, int maxPage) {
/* 140 */     int pageNum = HiConfigHolder.getCurrnetMiddlePage() * 2 - 2;
/* 141 */     int returnValue = 1;
/* 142 */     int startPage = getStartPage(currentPage2);
/* 143 */     returnValue = startPage + pageNum;
/*     */ 
/* 145 */     if (returnValue > maxPage) {
/* 146 */       return maxPage;
/*     */     }
/* 148 */     return returnValue;
/*     */   }
/*     */ 
/*     */   private int getStartPage(String currentPage2)
/*     */   {
/* 154 */     int middlePage = HiConfigHolder.getCurrnetMiddlePage() - 1;
/* 155 */     int returnValue = 1;
/* 156 */     int currPageNum = 1;
/*     */     try
/*     */     {
/* 159 */       currPageNum = new Integer(currentPage2).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 163 */       currPageNum = 1;
/*     */     }
/*     */ 
/* 166 */     returnValue = currPageNum - middlePage;
/* 167 */     if (returnValue < 1) {
/* 168 */       return 1;
/*     */     }
/*     */ 
/* 171 */     return returnValue;
/*     */   }
/*     */ 
/*     */   private String goPage(PageTagBean bean)
/*     */   {
/* 176 */     StringBuffer sb = new StringBuffer();
/* 177 */     String textClass = bean.getTextClass();
/* 178 */     String buttonClass = bean.getButtonClass();
/* 179 */     String readOnly = "";
/* 180 */     if (bean.getPage().getTotalPage() <= 1) {
/* 181 */       readOnly = " readonly ";
/*     */     }
/* 183 */     sb.append(I18NUtil.getString("到") + "<input type=\"text\"");
/* 184 */     sb.append(" name=\"pageOrder\"");
/* 185 */     sb.append(" id=\"pageOrder\"");
/* 186 */     sb.append(" size=\"1\"");
/* 187 */     sb.append(readOnly);
/* 188 */     sb.append(" maxlength=\"3\"");
/* 189 */     if (textClass != null)
/* 190 */       sb.append(" class=\"" + textClass + "\"");
/* 191 */     sb.append(" />" + I18NUtil.getString("页"));
/*     */ 
/* 193 */     sb.append("<input type='button'");
/* 194 */     sb.append(" name='button'");
/* 195 */     if (buttonClass != null)
/* 196 */       sb.append(" class=\"" + buttonClass + "\"");
/* 197 */     sb.append(" onclick=\"javascript:checkThenSubmit('" + bean.getPageBeanName() + "','" + bean.getUrl() + 
/* 198 */       "','" + bean.getForm() + "',document.getElementById('pageOrder').value,'" + bean.getPage().getTotalPage() + "')\"");
/* 199 */     sb.append(" value='" + I18NUtil.getString("跳转") + "'");
/* 200 */     sb.append(" />");
/*     */ 
/* 202 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   private String getHiddenInput(PageTagBean bean) {
/* 206 */     StringBuffer sb = new StringBuffer();
/* 207 */     sb.append("<input type='hidden'");
/* 208 */     sb.append(" value='" + bean.getCurrentPage() + "'");
/* 209 */     sb.append(" name='" + bean.getPageBeanName() + ".currentPage'");
/* 210 */     sb.append(" id='" + bean.getPageBeanName() + ".currentPage'");
/* 211 */     sb.append(" />");
/*     */ 
/* 214 */     sb.append("<input type='hidden'");
/* 215 */     sb.append(" value='" + bean.getCurrentPage() + "'");
/* 216 */     sb.append(" name='currentPage'");
/* 217 */     sb.append(" id='currentPage'");
/* 218 */     sb.append(" />");
/*     */ 
/* 220 */     if (bean.getLookup() != null) {
/* 221 */       sb.append("<input type='hidden' name='lookup' value='1' id='lookup'/>");
/*     */     }
/* 223 */     String pageSize = bean.getPageSize();
/* 224 */     if (pageSize != null) {
/* 225 */       sb.append("<input type='hidden' name='pageInfo.pageSize' value='" + pageSize + "' id='pageInfo.pageSize'/>");
/*     */     }
/* 227 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   private String buildJS(int i, PageTagBean pageBean)
/*     */   {
/* 232 */     if (pageBean.getForm() == null)
/* 233 */       pageBean.setForm("formSearch");
/* 234 */     return "pageSubmit('" + pageBean.getPageBeanName() + "','" + pageBean.getUrl() + 
/* 235 */       "','" + pageBean.getForm() + "','" + i + 
/* 236 */       "')";
/*     */   }
/*     */ }

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.taglib.component.builder.PageTagBuilder
 * JD-Core Version:    0.6.0
 */