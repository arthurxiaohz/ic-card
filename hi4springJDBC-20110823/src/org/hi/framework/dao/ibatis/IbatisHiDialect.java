package org.hi.framework.dao.ibatis;

import java.util.List;
import org.apache.ibatis.mapping.ParameterMapping;
import org.hi.framework.dao.HiDialect;

public abstract interface IbatisHiDialect extends HiDialect
{
  public static final String HI_PROPERTY_DIALET_KEY = "ibatis.dialect";
  public static final String IBATIS_KEYGENERATETYPE_POST = "post";
  public static final String IBATIS_KEYGENERATETYPE_PRE = "pre";

  public abstract String getSelectKey(String paramString);

  public abstract String getKeyGenerateType();

  public abstract String processInsertSql(String paramString1, String paramString2);

  public abstract String processInsertSqlFor3(String paramString1, String paramString2, List<ParameterMapping> paramList);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.framework.dao.ibatis.IbatisHiDialect
 * JD-Core Version:    0.6.0
 */