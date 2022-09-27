
package com.github.onyxiansoul.onyxiancoreapi.actionable_system.reactions_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import org.bukkit.event.Event;

public interface Trigger extends Actionable<Boolean> {
  
  public Class<? extends Event> getEventClass();

}
