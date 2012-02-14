package org.hi.studio.hsceditor.dialect;

import java.sql.Connection;
import java.sql.SQLException;
import org.hi.studio.hsceditor.visual.model.RootModel;

public abstract interface ISchemaLoader
{
  public abstract void loadSchema(RootModel paramRootModel, IDialect paramIDialect, Connection paramConnection, String[] paramArrayOfString, String paramString1, String paramString2)
    throws SQLException;
}

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.ISchemaLoader
 * JD-Core Version:    0.6.0
 */