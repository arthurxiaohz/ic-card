package org.hi.framework.dao;

import java.io.Serializable;
import java.util.List;
import org.hi.framework.dao.impl.FilterBean;
import org.hi.framework.service.Manager;

public abstract interface Filter extends Serializable
{
  public static final String OPERATOR_LIKE = "LIKE";
  public static final String OPERATOR_EQ = "=";
  public static final String OPERATOR_NOT_EQ = "<>";
  public static final String OPERATOR_GREATER_THAN = ">";
  public static final String OPERATOR_LESS_THEN = "<";
  public static final String OPERATOR_GREATER_EQ = ">=";
  public static final String OPERATOR_LESS_EQ = "<=";
  public static final String OPERATOR_IN = "IN";
  public static final String RELATION_AND = "AND";
  public static final String RELATION_OR = "OR";
  public static final String RELATION_NOT = "NOT";

  public abstract Filter addCondition(String paramString, Object paramObject);

  public abstract Filter addCondition(String paramString1, Object paramObject, String paramString2);

  public abstract Filter addCondition(String paramString1, Object paramObject, String paramString2, String paramString3);

  public abstract String toString();

  public abstract List<FilterBean> getConditions();

  public abstract Filter addFilter(Filter paramFilter);

  public abstract Filter addFilter(Filter paramFilter, String paramString);

  public abstract void removeFilter(Filter paramFilter);

  public abstract List<List<FilterBean>> getFilterGroup();

  public abstract String getAliasName();

  public abstract void setAliasName(String paramString);

  public abstract String getSQL(Manager paramManager);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.Filter
 * JD-Core Version:    0.6.0
 */