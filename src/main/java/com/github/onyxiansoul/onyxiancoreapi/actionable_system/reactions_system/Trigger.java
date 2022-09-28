
package com.github.onyxiansoul.onyxiancoreapi.actionable_system.reactions_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.ImpossibleActionException;
import org.bukkit.event.Event;

public interface Trigger extends Actionable<Boolean> {
  
  /**Gets the event class configured inside this trigger
   @throws ImpossibleActionException if the actionable thats supossed to give the event class fails to execute.*/
  public Class<? extends Event> getEventClass() throws ImpossibleActionException;

}
