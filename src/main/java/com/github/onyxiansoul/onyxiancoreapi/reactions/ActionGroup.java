package com.github.onyxiansoul.onyxiancoreapi.reactions;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
/** A group of actions that are to be executed under certain conditions.
 * In most cases you will not need to create this,
 * But in particular cases, such as expanding an action map to allow friendlier configuration, you might.
 * To make one, you can use @link ActionGroupFactory.class
 */
public interface ActionGroup extends Actionable<Void>, Nameable{
  
  /**Gets the class that this action group is meant to react to*/
  Class<?> getTriggerClass();
  
  /**Gets the storage of the action group.
   * Action groups are created each time the plugin configuration is read.
   * This means that this storage will persist across events, however
   * This also means that this storage will not persist across server restarts, or configuration reloads
   * Also please keep in mind this method may be moved to @link Actionable in the future.
   */
  public @NotNull Map<String,?> getStorage();
}
