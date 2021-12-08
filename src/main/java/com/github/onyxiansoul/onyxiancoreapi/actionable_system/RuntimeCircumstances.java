package com.github.onyxiansoul.onyxiancoreapi.actionable_system;

import com.github.onyxiansoul.onyxiancoreapi.reactions.ActionGroup;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

/** An element that represents the circumstances in which an action was triggered.
 * It allows an action to know:
 *  - What action group its a part of,
 *  - Which element contains that action group,
 *  - What caused that element to trigger the action group
 * It also allows the action to store values, making them available to other actions of the same action group, which are triggered later.
 * @param <InterpretedT> The type of object(usually an event), that triggered the reaction.
 * @param <TriggeredT> The type of object that reacted to the trigger (for example a block evolution)
 */
public class RuntimeCircumstances<InterpretedT, TriggeredT> {
  /**The element that has action groups. Persistent across all events, but shared only by runtime suppliers whose action group belongs to the same triggered*/
  protected final TriggeredT triggered;
  
  /**The action group which is one of the triggered reactions. Persistent across al events, but not shared by any runtime suppliers.*/
  protected final ActionGroup actionGroup;
  
  /**The interpreted element (usually an event) that the RuntimeCircumstances uses as its source, and whose interpretation it allows. Not persistent through the events, but shared across all runtime suppliers that react to an event.*/
  protected final InterpretedElement<InterpretedT> trigger;
  
  /**A storage space available for the runtime supplier. As such, its not persistent through the events, and its exclusive to each action group*/
  protected final Map<String,Object> supplierStorage;


  public RuntimeCircumstances(@NotNull InterpretedElement<InterpretedT> trigger, @NotNull TriggeredT triggered, @NotNull ActionGroup actionGroup){
    this.trigger = trigger;
    this.triggered = triggered;
    this.actionGroup = actionGroup;
    this.supplierStorage = new HashMap<>();
  }

  /**Get the easy to query version of the element that triggered the reaction*/
  public @NotNull InterpretedElement<InterpretedT> getTrigger(){
    return trigger;
  }
  
  /**Gets the element that contains the action group, and was triggered by the trigger*/
  public @NotNull TriggeredT getReactiveElement(){
    return triggered;
  }
  
  /** Gets the action group to which this action belongs to.*/
  public @NotNull ActionGroup getActionGroup(){
    return actionGroup;
  }
  
  /**Gets the storage specific for this runtime supplier, its not persistent throughout the events, and its exclusive to each action group. */
  public @NotNull Map<String,Object> getStorage(){
    return supplierStorage;
  }
    
}
