
package com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import com.github.onyxiansoul.onyxiancoreapi.identity.StorageHolder;

/**A collection of actions that can be executed at once, and can hold values shared across actions, in order to allow them to cooperate*/
public interface ActionCollection extends Nameable, Actionable<Void>, StorageHolder<String,Object>{

}
