package com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.interpreted_element_system;

import org.bukkit.event.Event;

public interface InterpretedElementFactory {
  
  /**Create and interpreted element wrapping the event to be able to query it more easily and universally*/
  public InterpretedElement create(Event event);
}
