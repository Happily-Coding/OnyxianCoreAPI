package com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.interpreted_element_system;

import com.github.onyxiansoul.onyxiancoreapi.index_system.DuplicateEntryException;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/**An access point to the interpreted element type index, for registering interpreted element types, which can be used to create interpreted elements of events by any plugin using the OnyxianCore*/
public interface InterpretedElementTypeIndexAccessPoint {

  /** Registers a class that can be used to create interpreted elements of a certain class of event.The interpreted element can then be queried for values common to multiple event types, for example 'trigger block', using the correct implementation for this event.
  * @param <InterpretableT> The type of event that can be interpreted by this interpreted element type
  * @param <InterpretedElementT> The interpreted element type which can interpret the event
  * @param interpretableClass The class of the interpreted element type (the class of a bukkit event)
  * @param interpretedElementClass The class of the interpreted element type (the class of the event interpreter, which has a constructor taking that event type as only parameter).
  * @throws DuplicateEntryException if a variable referenceName has been registered to referenceName
  */
  public abstract <InterpretableT extends Event ,InterpretedElementT extends InterpretedElement<InterpretableT>> void registerInterpretedElementType(@NotNull Class<InterpretableT> interpretableClass, @NotNull Class<InterpretedElementT> interpretedElementClass) throws DuplicateEntryException;
  
  /** Removes the interpreted element types registered by this plugin. You can use this to make your plugin's config reload friendly:
   * Read the new interpreted element types, place them on a list, if no errors popup then
   * - call this method 
   * - loop through the list and register all interpreted element types, handling any exceptions as you see fit
   * Otherwise, don't do anything, keeping the previous config.
   */
  public abstract void removeIntepretedElementTypesOfThisPlugin();
  
}
