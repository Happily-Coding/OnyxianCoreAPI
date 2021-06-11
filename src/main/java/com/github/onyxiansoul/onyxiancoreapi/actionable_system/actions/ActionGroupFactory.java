package com.github.onyxiansoul.onyxiancoreapi.actionable_system.actions;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import java.util.List;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ActionGroupFactory {
  /** Gets an ActionGroup containing an action with a single condition */
  public abstract ActionGroup makeActionGroup(@NotNull Actionable action, @Nullable Actionable<Boolean> condition, @Nullable Class<? extends Event> triggerClass, @NotNull String name);
  
  /** Gets an ActionGroup with certain actions and conditions*/
  public abstract ActionGroup makeActionGroup(@NotNull List<Actionable> actions, @Nullable List<Actionable<Boolean>> conditions, @Nullable Class<? extends Event> triggerClass, @NotNull String name);
  
}
