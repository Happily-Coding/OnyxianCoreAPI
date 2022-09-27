package com.github.onyxiansoul.onyxiancoreapi.actionable_system.reactions_system;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import java.util.List;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 @deprecated Variable source should be used instead.*/
public interface ReactionFactory {
  
  /** Gets an Reaction containing an action with a single condition */
  public abstract Reaction makeReaction(@NotNull Actionable action, @Nullable Actionable<Boolean> condition, @Nullable Class<? extends Event> triggerClass, @NotNull String name);
  
  /** Gets an Reaction with certain actions and conditions*/
  public abstract Reaction makeReaction(@NotNull List<Actionable<?>> actions, @Nullable List<Actionable<Boolean>> conditions, @Nullable Class<? extends Event> triggerClass, @NotNull String name);
  
}
