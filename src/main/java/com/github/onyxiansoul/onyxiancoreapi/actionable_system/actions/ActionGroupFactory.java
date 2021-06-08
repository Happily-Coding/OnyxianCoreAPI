package com.github.onyxiansoul.onyxiancoreapi.actionable_system.actions;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ActionGroupFactory {
  /** Gets an ActionGroup containing an action with a single condition */
  public abstract ActionGroup getSimpleActionGroup(@NotNull Actionable action, @Nullable Actionable<Boolean> condition, Class triggerClass);
  
  /** Gets an ActionGroup with certain actions and conditions*/
  public abstract ActionGroup getActionGroup(@NotNull List<Actionable> actions, @Nullable List<Actionable<Boolean>> conditions, Class triggerClass);
  
}
