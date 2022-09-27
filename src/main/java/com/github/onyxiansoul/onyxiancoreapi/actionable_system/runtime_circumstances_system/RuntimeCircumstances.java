package com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.interpreted_element_system.InterpretedElement;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import com.github.onyxiansoul.onyxiancoreapi.identity.StorageHolder;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

/** An element that represents the circumstances under which an action collection was triggered by an event.
 * From it actions can access things that remain the same across events:
 *  - The element that held reactions for events. see @getReactiveElement
 *  - the action collection executed in reaction to the event. see @getActionCollection
 * 
 * And things that changes across events:
 *  - the event which caused the reaction. see @getTrigger
 *  - a shared storage space where actions can access, store, or modify values, to interact with other actions in the collection. see @getStorage
 * 
 * @param <EventT> The type of event, that triggered the reaction.
 * @param <ReactiveElementT> The type of object that reacted to the trigger (for example a block evolution)
 */
public interface RuntimeCircumstances<EventT extends Event, ReactiveElementT extends Nameable> extends StorageHolder<String,Object> {

 /**Get the element that has the action collections that are triggered as reactions to events. Its Persistent across all events.*/
  public @NotNull ReactiveElementT getReactiveElement();

  /** Gets the action collection which this action belongs to. Its persistent across al events.*/
  public @NotNull ActionCollection getActionCollection();

  /**Get the easy to query version of the event that triggered the reaction. Its unique per event, but shared by all the action collections that might want to query the event.*/
  public @NotNull InterpretedElement<EventT> getTrigger();
}
