package com.github.onyxiansoul.onyxiancoreapi.actionable_system.reactions_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.ImpossibleActionException;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.ActionCollection;

/** An element that can react to an object of some type, usually an event.
 */
public interface Reaction extends ActionCollection{
  
  public Class<?> getTriggerClass() throws ImpossibleActionException;
  
}
