package com.github.onyxiansoul.onyxiancoreapi.v2.actions;

/**An action that MANDATORILY requires an additional variable, passed to it when run.
 * A classic example would be actions that affect someone/something who was part of an event.
 * For example an action that will apply a slow potion effect to any damaged player. When run, the action will be passed a PlayerDamageEvent which they can use to obtain who to slow.
 * Without the event, the action wouldn't know who to affect, and therefore, would need to throw an exception. */
public interface CircumstancialActionable<T> extends Actionable<T> {
  
}
