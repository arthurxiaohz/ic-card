package org.hi.base.menu.strutsmenu;

import java.util.Map;
import org.hi.framework.dao.Filter;

public abstract interface MenuFilterProcessor
{
  public abstract Filter getFilter(Map<String, String> paramMap);
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.menu.strutsmenu.MenuFilterProcessor
 * JD-Core Version:    0.6.0
 */