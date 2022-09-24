package com.github.onyxiansoul.onyxiancoreapi.reactions;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.event_reaction_system.Reaction;
import java.util.List;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 @deprecated Variable source should be used instead.*/
public interface ReactionFactory {
  
  /** Gets an Reaction containing an action with a single condition */
  public abstract Reaction makeActionGroup(@NotNull Actionable action, @Nullable Actionable<Boolean> condition, @Nullable Class<? extends Event> triggerClass, @NotNull String name);
  
  /** Gets an Reaction with certain actions and conditions*/
  public abstract Reaction makeActionGroup(@NotNull List<Actionable<?>> actions, @Nullable List<Actionable<Boolean>> conditions, @Nullable Class<? extends Event> triggerClass, @NotNull String name);
  
}
