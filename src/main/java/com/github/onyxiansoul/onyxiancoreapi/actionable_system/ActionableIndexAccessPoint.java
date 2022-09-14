package com.github.onyxiansoul.onyxiancoreapi.actionable_system;

import com.github.onyxiansoul.onyxiancoreapi.index_system.DuplicateEntryException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import org.jetbrains.annotations.NotNull;

/**An access point to the actionable index, for registering or getting registered actionables which can be used by any plugin using the OnyxianCore*/
public interface ActionableIndexAccessPoint {
  
  /**Registers an object of an actionable, AKA an element that can run, and can produce a variable, and therefore can be used in the config as both a 'action' & a 'variable')
  * Configurable objects inside Onyxian Plugins, use almost exclusevily producers as variables, this allows for the value of a field to be modifiable by parameters obtained at runtime, such as the value of a placeholder, or the event that triggered an action.
  * @param <T1> The type of variable that will be produced by the actionable. Can be Void if its an action that doesn't produce any variable.
  * @param <T2> Any class implementing actionable.
  * @param referenceName The name that will represent this actionable in the OnyxianCore index.
  * @param actionableToRegister The actionable to register.
  * @throws DuplicateEntryException if a variable referenceName has been registered to referenceName
  */
  public abstract <T1,T2 extends Actionable<T1>> void registerActionable(@NotNull String referenceName, @NotNull T2 actionableToRegister) throws DuplicateEntryException;
  
  /**Registers an actionable that simply wraps a value, and returns it any time its enacted
   * @param <T> The type of object produced by the actionable
   * @param referenceName The name of the actionable inside the config & the name that will represent this wrapper in the OnyxianCore index.
   * @param value The value the actionable will wrap (and then return at runtime whenever enacted).
   * @throws DuplicateEntryException if a variable referenceName has been registered to referenceName*/
  public abstract <T> void registerWrapperActionable(@NotNull String referenceName, T value) throws DuplicateEntryException;

  /**Gets a previously registered actionable by name*/
  public abstract <T> Actionable<T> getRegisteredVariable(String fieldName) throws MissingEntryException;
  
  /** Removes the actionables registered by this plugin. You can use this to make your plugin's config reload friendly:
   * Read the new actionables, place them on a list, if no errors popup then
   * - call this method 
   * - loop through the list and register all actionables, handling any exceptions as you see fit
   * Otherwise, don't do anything, keeping the previous config.
   */
  public abstract void removeActionablesOfThisPlugin();
  
}
