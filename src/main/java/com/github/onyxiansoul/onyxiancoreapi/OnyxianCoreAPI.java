package com.github.onyxiansoul.onyxiancoreapi;

import com.github.onyxiansoul.onyxiancoreapi.actions.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigUpdate;
import com.github.onyxiansoul.onyxiancoreapi.configuration.OnyxianConfiguration;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;


/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {

  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * @param fileName The name of the file itself without yml
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException  if the file couldn't be read.
  */
  public abstract OnyxianConfiguration getConfiguration(String fileName, ConfigUpdate[] configUpdates) throws UnexpectedConfigurationException;
  
  /**Registers an object of an actionable, AKA an element that can run, and can produce a variable, and therefore can be used in the config as both a 'action' & a 'variable')
  * Configurable objects inside Onyxian Plugins, use almost exclusevily producers as variables, this allows for the value of a field to be modifiable by parameters obtained at runtime, such as the value of a placeholder, or the event that triggered an action.
  * @param <T1> The type of variable that will be produced by the actionable. Can be Void if its an action that doesn't produce any variable.
  * @param <T2> Any class implementing actionable.
  * @param referenceName The name that will represent this actionable in the OnyxianCore index.
  * @param actionableToRegister The actionable to register.
  */
  public abstract <T1,T2 extends Actionable<T1>> void registerActionable(String referenceName, T2 actionableToRegister) throws IllegalArgumentException;
  
  /**Assigns a field wrapper to a certain field. Field wrappers provide to transform a direct config value to a  an Actionable providing a usable version of the value.
   *  For example, in a 'biome' field, they could allow the transformation of the name of the biome, written by the user in the config, into the Biome found inside the biome enum.
   *  This allows the definition of values for the biome field such as "biome: Taiga".
   *  Please keep in mind field wrappers NEED to have a constructor taking a single, 'Object' parameter, & they should produce the usable version of the parameter using the enact method.
   * @param referenceName The name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws IllegalArgumentException If the field is already being wrapped by a class previously registered by a plugin.
   */
  public abstract void registerFieldWrapper(String referenceName, Class wrapperClass, Object... additionalWrapperParameters)  throws IllegalArgumentException;
  
  //There is no actionable registry access since they should be directly read from the config.
  
  //There is no supplier registry, since each plugin should both create and use their own implmentations of supplier.

}
