package com.github.onyxiansoul.onyxiancoreapi;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.actions.ActionGroupFactory;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigUpdate;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigurableBuilder;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject.YmlObject;
import com.github.onyxiansoul.onyxiancoreapi.index_system.DuplicateEntryException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import com.github.onyxiansoul.onyxiancoreapi.resourcepack.ResourcepackModifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {

  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * @param fileName The name of the file itself without yml
  * @param configUpdates The updates that will be applied to the configuration if its not up to date.
  * @return a Yml Object representing the file's values.
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException  if the file couldn't be read.
  */
  public abstract YmlObject getConfiguration(@NotNull String fileName, @Nullable ConfigUpdate[] configUpdates) throws UnexpectedConfigurationException;

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

  /** Makes a field be read by the wrappers another field uses
    * It allows you to read a field of your choosing be read in the same way another field is, without requiring owning/having access to the original wrapper class.
    * @param fieldName The name that will represent this wrapper in the OnyxianCore index.
    * @param wrapperName The name of the field whose wrapper will be used.
   * @throws MissingEntryException if there is no previously registered variable type called wrapperName
   * @throws DuplicateEntryException if wrapperName tries to provide instructions compound or simple wrapping but fieldName already has instructions for that type of wrapping.
  */
  public abstract void assignFieldWrapper(@NotNull String fieldName, @NotNull String wrapperName) throws MissingEntryException, DuplicateEntryException;

  /** Registers a class responsible for interpreting a field when its of  (non-YML)object type, aka a field that is not a configuration section or map, and therefore has no sub-fields, for example a boolean or a biome from name.
   * That class needs to have a constructor that takes an object and needs to be an actionable of the type that it produces.
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws DuplicateEntryException If the field is already being wrapped by a class previously registered by a plugin.
   */
  public abstract void registerSimpleFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, @Nullable Object... additionalWrapperParameters) throws DuplicateEntryException;
  
  /** Registers a class responsible for interpreting a field when its of compound object type, aka a YmlObject, made from a configuration section or map, for example any action that has multiple parameters
   * That class needs to have a constructor that takes an object and needs to be an actionable of the type that it produces.
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws DuplicateEntryException If the field is already being wrapped by a class previously registered by a plugin.
   */
  public abstract void registerCompoundFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, @Nullable Object... additionalWrapperParameters) throws DuplicateEntryException;
  
  /** Assigns a field wrapper to a certain field. Field wrappers provide to transform a direct config value to a  an Actionable providing a usable version of the value.For example, in a 'biome' field, they could allow the transformation of the name of the biome, written by the user in the config, into the Biome found inside the biome enum.This allows the definition of values for the biome field such as "biome: Taiga". Please keep in mind field wrappers NEED to have a constructor taking a single, 'Object' parameter, & they should produce the usable version of the parameter using the enact method.
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param customWrapsCompound Wether the field has unique instructions on how to wrap a compound object (usually is the case for actions since the have parameters)
   * @param customWrapsLine Wether the field has unique instructions on how to wrap a single line object (usually the case for simple wrappers such as 'message' etc).
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws IllegalArgumentException If the field is already being wrapped by a class previously registered by a plugin.
   */
  public abstract void registerFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, boolean customWrapsCompound, boolean customWrapsLine, @Nullable Object... additionalWrapperParameters) throws DuplicateEntryException;
  
  /**Gets an action group factory, capable of producing action groups.
   TODO: REMOVE since configurable builder should be able to replace it.*/
  public @Deprecated abstract ActionGroupFactory getActionGroupFactory();
  
  /**Gets an action group factory, capable of producing action groups.*/
  //public abstract ReactionsFactory getReactionsFactory();
  
  /**Gets a configurable builder of a certain type of configurable*/
  public abstract ConfigurableBuilder configurableBuilder(String configurableType);
  
  /**Gets a previously registered actionable by name*/
  public abstract <T> Actionable<T> getRegisteredVariable(String fieldName) throws MissingEntryException;
  
  /**Gets a modifier of the resourcepack automatically created by the onyxian core*/
  public abstract ResourcepackModifier getResourcepackModifier();
  
  //NOTE TO SELF: There is no supplier registry, since each plugin should both create and use their own implmentations of supplier.

  /**Sets the section objects of a certain type can reference with copy: or default_from:
  * @param fieldThatReferencesIt The type of objects that can reference it.
  * @param sectionReference The section.
  * @throws IllegalArgumentException if that type of object already has a referenced section assigned.
  */
  //Removed becuase it seems pointless due to recent changes
  //public abstract void registerReferenceSection(@NotNull String fieldThatReferencesIt, @NotNull ConfigurationSection sectionReference) throws IllegalArgumentException;
}

//TODO: MIGRATE ALL CONSTRUCTED VARIABLES TO FACTORY INTERFACES PROVIDED BY THE API