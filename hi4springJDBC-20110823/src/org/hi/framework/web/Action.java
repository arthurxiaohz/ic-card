package org.hi.framework.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract interface Action
{
  public static final String UNCODE_PARAMETER_KEY = "org.hi.framework.web.webwork.BaseAction.uncode_parameter_key";

  public abstract String execute()
    throws Exception;

  public abstract String getLookup();

  public abstract HttpServletRequest getRequest();

  public abstract HttpServletResponse getResponse();

  public abstract HttpSession getSession();

  public abstract String getParameter(String paramString);

  public abstract String saveFile(File paramFile, String paramString1, String paramString2)
    throws IOException;

  public abstract String perExecute(Object paramObject)
    throws Exception;

  public abstract String postExecute(Object paramObject)
    throws Exception;
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.Action
 * JD-Core Version:    0.6.0
 */