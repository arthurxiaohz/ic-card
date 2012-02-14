package org.hi.studio.hsceditor.visual.generate;

import org.eclipse.core.resources.IFile;
import org.hi.studio.hsceditor.visual.model.RootModel;

public abstract interface IGenerator
{
  public abstract String getGeneratorName();

  public abstract void execute(IFile paramIFile, RootModel paramRootModel);
}

/* Location:           C:\Users\Angi\Desktop\org.hi.studio.hsceditor_5.1.8.zip
 * Qualified Name:     org.hi.studio.hsceditor.visual.generate.IGenerator
 * JD-Core Version:    0.6.0
 */