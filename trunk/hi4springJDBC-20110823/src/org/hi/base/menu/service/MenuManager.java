package org.hi.base.menu.service;

import java.util.List;
import org.hi.base.menu.model.Menu;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface MenuManager extends Manager
{
  public abstract void saveMenu(Menu paramMenu);

  public abstract void removeMenuById(Integer paramInteger);

  public abstract Menu getMenuById(Integer paramInteger);

  public abstract List<Menu> getMenuList(PageInfo paramPageInfo);

  public abstract void saveSecurityMenu(Menu paramMenu);

  public abstract void removeSecurityMenuById(Integer paramInteger);

  public abstract Menu getSecurityMenuById(Integer paramInteger);

  public abstract List<Menu> getSecurityMenuList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.service.MenuManager
 * JD-Core Version:    0.6.0
 */