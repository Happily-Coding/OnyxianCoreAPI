package com.github.onyxiansoul.onyxiancoreapi;

import com.github.onyxiansoul.onyxiancoreapi.actions.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigUpdate;
import com.github.onyxiansoul.onyxiancoreapi.configuration.OnyxianConfiguration;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {

  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * @param fileName The name of the file itself without yml
   *@param configUpdates
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException  if the file couldn't be read.
  */
  public abstract OnyxianConfiguration getConfiguration(@NotNull String fileName, @Nullable ConfigUpdate[] configUpdates) throws UnexpectedConfigurationException;

  /**Registers an object of an actionable, AKA an element that can run, and can produce a variable, and therefore can be used in the config as both a 'action' & a 'variable')
  * Configurable objects inside Onyxian Plugins, use almost exclusevily producers as variables, this allows for the value of a field to be modifiable by parameters obtained at runtime, such as the value of a placeholder, or the event that triggered an action.
  * @param <T1> The type of variable that will be produced by the actionable. Can be Void if its an action that doesn't produce any variable.
  * @param <T2> Any class implementing actionable.
  * @param referenceName The name that will represent this actionable in the OnyxianCore index.
  * @param actionableToRegister The actionable to register.
  */
  public abstract <T1,T2 extends Actionable<T1>> void registerActionable(@NotNull String referenceName, @NotNull T2 actionableToRegister) throws IllegalArgumentException;
  //There is no actionable registry access since they should be directly read from the config.

  /** Assigns a field wrapper to a certain field. Field wrappers provide to transform a direct config value to a  an Actionable providing a usable version of the value.For example, in a 'biome' field, they could allow the transformation of the name of the biome, written by the user in the config, into the Biome found inside the biome enum.This allows the definition of values for the biome field such as "biome: Taiga". Please keep in mind field wrappers NEED to have a constructor taking a single, 'Object' parameter, & they should produce the usable version of the parameter using the enact method.
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param customWrapsCompound Wether the field has unique instructions on how to wrap a compound object (usually is the case for actions since the have parameters)
   * @param customWrapsLine Wether the field has unique instructions on how to wrap a single line object (usually the case for simple wrappers such as 'message' etc).
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws IllegalArgumentException If the field is already being wrapped by a class previously registered by a plugin.
   */
  public abstract void registerFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, boolean customWrapsCompound, boolean customWrapsLine,@Nullable Object... additionalWrapperParameters)  throws IllegalArgumentException;

  /** Makes a field by read by an already registered wrapper
    * It allows you to read a field of your choosing be read in the same way another field is, without requiring owning/having access to the original wrapper class.
    * @param fieldName The name that will represent this wrapper in the OnyxianCore index.
    * @param wrapperName The name of the field whose wrapper will be used.
  */
  public abstract void assignWrapperToField(@NotNull String fieldName, @NotNull String wrapperName)  throws IllegalArgumentException;

  /**Sets the section objects of a certain type can reference with copy: or default_from:
  * @param fieldThatReferencesIt The type of objects that can reference it.
  * @param sectionReference The section.
  * @throws IllegalArgumentException if that type of object already has a referenced section assigned.
  */
  public abstract void registerReferenceSection(@NotNull String fieldThatReferencesIt, @NotNull ConfigurationSection sectionReference) throws IllegalArgumentException;

  //There is no supplier registry, since each plugin should both create and use their own implmentations of supplier.

}
