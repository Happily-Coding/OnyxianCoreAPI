package com.github.onyxiansoul.onyxiancoreapi.reactions;

import org.bukkit.event.Event;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
/** A group of actions that are to be executed under certain conditions.
 * In most cases you will not need to create this,
 * But in particular cases, such as expanding an action map to allow friendlier configuration, you might.
 * To make one, you can use @link ActionGroupFactory.class
 */
public interface ActionGroup extends Actionable<Void>, Nameable{
  Class<? extends Event> getTriggerClass();
}
