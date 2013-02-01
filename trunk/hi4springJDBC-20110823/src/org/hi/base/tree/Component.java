package org.hi.base.tree;

public abstract interface Component
{
  public abstract String getComponentName();

  public abstract Component getTarget();

  public abstract Component getTargetParent();
}

/* Location:           C:\Users\Angi\Desktop\hi.jar
 * Qualified Name:     org.hi.base.tree.Component
 * JD-Core Version:    0.6.0
 */