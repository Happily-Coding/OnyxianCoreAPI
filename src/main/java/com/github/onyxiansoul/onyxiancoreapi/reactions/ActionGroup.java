package com.github.onyxiansoul.onyxiancoreapi.reactions;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import com.github.onyxiansoul.onyxiancoreapi.identity.StorageHolder;
/** A group of actions that are to be executed under certain conditions.
 * As a general rule action groups are created each time the plugin configuration is read.
 *  - This means that this storage will persist across events, however
 *  - This also means that this storage will not persist across server restarts, or configuration reloads
 * In most cases you will not need to create an action group,
 * But in particular cases, such as expanding an action map to allow friendlier configuration, you might.
 * To make one, you can use @link ActionGroupFactory.class
 */
public interface ActionGroup extends Actionable<Void>, Nameable, StorageHolder<String, Object>{
  
  /**Gets the class that this action group is meant to react to*/
  Class<?> getTriggerClass();
  
}
