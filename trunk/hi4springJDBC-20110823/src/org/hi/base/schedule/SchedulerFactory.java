package org.hi.base.schedule;

public abstract interface SchedulerFactory
{
  public abstract void restart()
    throws Exception;

  public abstract boolean isRunning()
    throws Exception;

  public abstract void start()
    throws Exception;

  public abstract void stop()
    throws Exception;

  public abstract void shutdown()
    throws Exception;
}

/* Location:           C:\Users\Angi\Desktop\framework-boss-core-1.0.1.jar
 * Qualified Name:     org.hi.base.schedule.SchedulerFactory
 * JD-Core Version:    0.6.0
 */