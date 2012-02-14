package org.hi.studio.hsceditor.dialect;

public abstract interface IColumnType
{
  public abstract String getName();

  public abstract String getLogicalName();

  public abstract boolean supportSize();

  public abstract int getType();
}

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.IColumnType
 * JD-Core Version:    0.6.0
 */