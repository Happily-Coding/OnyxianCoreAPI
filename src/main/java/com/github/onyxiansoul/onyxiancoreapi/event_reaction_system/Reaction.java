package com.github.onyxiansoul.onyxiancoreapi.event_reaction_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import com.github.onyxiansoul.onyxiancoreapi.identity.StorageHolder;

/** An element that can react to an object of some type, usually an event.
 */
public interface Reaction extends Actionable<Void>, Nameable, StorageHolder<String, Object>{
  
  public Class<?> getTriggerClass();
  
}
