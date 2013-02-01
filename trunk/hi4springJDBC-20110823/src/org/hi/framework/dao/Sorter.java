package org.hi.framework.dao;

import java.io.Serializable;
import java.util.Map;

public abstract interface Sorter extends Serializable
{
  public static final String ORDER_ASC = "ASC";
  public static final String ORDER_DESC = "DESC";

  public abstract Sorter addSort(String paramString);

  public abstract Sorter addSort(String paramString1, String paramString2);

  public abstract String toString();

  public abstract Map<String, String> getSorts();
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.dao.Sorter
 * JD-Core Version:    0.6.0
 */