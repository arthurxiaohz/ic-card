package org.hi.studio.hsceditor.dialect;

import org.hi.studio.hsceditor.validator.DiagramErrors;
import org.hi.studio.hsceditor.visual.model.RootModel;
import org.hi.studio.hsceditor.visual.model.TableModel;

public abstract interface IDialect
{
  public abstract IColumnType getColumnType(int paramInt);

  public abstract IColumnType getColumnType(String paramString);

  public abstract IColumnType getDefaultColumnType();

  public abstract IColumnType[] getColumnTypes();

  public abstract IIndexType[] getIndexTypes();

  public abstract IIndexType getDefaultIndexType();

  public abstract IIndexType getIndexType(String paramString);

  public abstract String createDDL(RootModel paramRootModel, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);

  public abstract String createTableDDL(RootModel paramRootModel, TableModel paramTableModel, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, StringBuilder paramStringBuilder);

  public abstract ISchemaLoader getSchemaLoader();

  public abstract void validate(DiagramErrors paramDiagramErrors, RootModel paramRootModel);

  public abstract String getColumnMetadataSQL(String paramString);
}

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.dialect.IDialect
 * JD-Core Version:    0.6.0
 */