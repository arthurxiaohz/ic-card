package org.hi.framework.web.webwork;

import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.AroundInterceptor;

public class NothingInterceptor extends AroundInterceptor
{
  protected void after(ActionInvocation dispatcher, String result)
    throws Exception
  {
  }

  protected void before(ActionInvocation invocation)
    throws Exception
  {
  }
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.framework.web.webwork.NothingInterceptor
 * JD-Core Version:    0.6.0
 */