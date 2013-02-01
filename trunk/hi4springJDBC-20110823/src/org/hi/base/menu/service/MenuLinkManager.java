package org.hi.base.menu.service;

import java.util.List;
import org.hi.base.menu.model.MenuLink;
import org.hi.framework.paging.PageInfo;
import org.hi.framework.service.Manager;

public abstract interface MenuLinkManager extends Manager
{
  public abstract void saveMenuLink(MenuLink paramMenuLink);

  public abstract void removeMenuLinkById(Integer paramInteger);

  public abstract MenuLink getMenuLinkById(Integer paramInteger);

  public abstract List<MenuLink> getMenuLinkList(PageInfo paramPageInfo);

  public abstract void saveSecurityMenuLink(MenuLink paramMenuLink);

  public abstract void removeSecurityMenuLinkById(Integer paramInteger);

  public abstract MenuLink getSecurityMenuLinkById(Integer paramInteger);

  public abstract List<MenuLink> getSecurityMenuLinkList(PageInfo paramPageInfo);
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.menu.service.MenuLinkManager
 * JD-Core Version:    0.6.0
 */