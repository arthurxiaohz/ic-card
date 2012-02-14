package org.hi.studio.core.template;

import java.io.Writer;
import java.util.Map;

public abstract interface TemplateHelp
{
  public abstract void process(String paramString, Writer paramWriter);

  public abstract void setTemplateDir(String paramString);

  public abstract String getTemplateDir();

  public abstract void put(Object paramObject1, Object paramObject2);

  public abstract void setMap(Map paramMap);

  public abstract String getEncoding();
}

/* Location:           C:\Users\Angi\Desktop\org.zip
 * Qualified Name:     org.hi.studio.core.template.TemplateHelp
 * JD-Core Version:    0.6.0
 */