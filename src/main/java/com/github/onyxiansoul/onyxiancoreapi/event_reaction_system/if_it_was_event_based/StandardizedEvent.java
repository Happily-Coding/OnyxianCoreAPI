package com.github.onyxiansoul.onyxiancoreapi.event_reaction_system.if_it_was_event_based;

import javax.validation.constraints.NotNull;
import org.bukkit.event.Event;

public abstract class StandardizedEvent<OriginalEventType> extends Event implements InterpretedElementI<OriginalEventType> {
  
  /**The original element (usually an event) to be interpreted. Put simply, the data source available for all methods to query */
  protected final OriginalEventType originalEvent;
  
  public StandardizedEvent(@NotNull OriginalEventType originalEvent){
    this.originalEvent = originalEvent;
  }
  
  /**Gets the element is being interpreted
   * @return the element that is being interpreted, and was used to created this intepreted element.*/
  public @NotNull OriginalEventType getRawSource(){
    return originalEvent;
  }
}
