
package com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.interpreted_element_system.InterpretedElement;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import javax.validation.constraints.NotNull;
import org.bukkit.event.Event;

/**A factory capable of creating runtime circumstances from events, which can be used to activate actions*/
public interface RuntimeCircumstancesFactory {
  
  /** Create runtime circumstances, which can be used to react to an event.
   * One is created per action collection reaction to a bukkit event.
   * @param triggered the element ultimately interested in the events, who holds the reactions to each event. Example: the custom block type. Query properties/methods from it here.
   * @param trigger the interpreted version of the event listened to. Query properties/methods of the bukkit event from here.
   * @param actionCollection the action which executes several subactions. Query/write properties shared between actions during one run from here.
   * @return this runtimeCircumstance object: the runtime circumstance, unique to this run of the action collection activated in reaction to a bukkit event. Query/write properties shared between actions but not between runs here.
   */
  public RuntimeCircumstances make(@NotNull Nameable triggered, @NotNull InterpretedElement trigger,  @NotNull ActionCollection actionCollection);

  
  /** Create runtime circumstances, which can be used to react to an event, automatically handling the creation of the interpreted element.
   * One is created per action collection reaction to a bukkit event.
   * @param triggered the element ultimately interested in the events, who holds the reactions to each event. Example: the custom block type. Query properties/methods from it here.
   * @param trigger the event listened to, which needs to be interpreted. Query properties/methods of the bukkit event from here.
   * @param actionCollection the action which executes several subactions. Query/write properties shared between actions during one run from here.
   * @return this runtimeCircumstance object: the runtime circumstance, unique to this run of the action collection activated in reaction to a bukkit event. Query/write properties shared between actions but not between runs here.
   */
  public RuntimeCircumstances make(@NotNull Nameable triggered, @NotNull Event trigger,  @NotNull ActionCollection actionCollection);
  
}
