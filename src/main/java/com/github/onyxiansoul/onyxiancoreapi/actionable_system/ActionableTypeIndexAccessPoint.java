package com.github.onyxiansoul.onyxiancoreapi.actionable_system;

import com.github.onyxiansoul.onyxiancoreapi.index_system.DuplicateEntryException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** An access point to the actionable type index, for registering actionable types, which can be used to create actionables (via variablesources) by any plugin using the OnyxianCore
 * As you can see, this has no way of getting an actionable type, since its not necessairy. If you'd like to make an actionable of a certain type, please create and use a variable source.
 */
public interface ActionableTypeIndexAccessPoint {
  
  /** Makes a field be read by the wrappers another field uses
    * It allows you to read a field of your choosing be read in the same way another field is, without requiring owning/having access to the original wrapper class.
    * @param fieldName The name that will represent this wrapper in the OnyxianCore index.
    * @param wrapperName The name of the field whose wrapper will be used.
    * @param additionalParameters Additional parameters which will be used during the construction of the original wrapper class. This is only required if the constructor of that wrapper class needs extra parameters.
    * @throws MissingEntryException if there is no previously registered variable type called wrapperName
    * @throws DuplicateEntryException if wrapperName tries to provide instructions compound or simple wrapping but fieldName already has instructions for that type of wrapping.
    * @throws Exception If there was a problem interpreting the copying the already registered entry.
   */
  public abstract void assignFieldWrapper(@NotNull String fieldName, @NotNull String wrapperName, Object... additionalParameters) throws MissingEntryException, DuplicateEntryException, Exception;

  /** Registers a class responsible for interpreting a field when its of  (non-YML)object type, aka a field that is not a configuration section or map, and therefore has no sub-fields, for example a boolean or a biome from name.
   * That class needs to have a constructor that takes an object and needs to be an actionable of the type that it produces.
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws DuplicateEntryException If the field is already being wrapped by a class previously registered by a plugin.
   * @throws Exception If there was a problem interpreting the entry thats being registered, for example the class is missing the relevant constructor.
   */
  public abstract void registerSimpleFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, @Nullable Object... additionalWrapperParameters) throws DuplicateEntryException, Exception;
  
  /** Registers a class responsible for interpreting a field when its of compound object type, aka a StructuredValue, made from a configuration section or map, for example any action that has multiple parameters
 That class needs to have a constructor that takes an object and needs to be an actionable of the type that it produces.
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws DuplicateEntryException If the field is already being wrapped by a class previously registered by a plugin.
   * @throws Exception If there was a problem interpreting the entry that's being registered, for example the class is missing the relevant constructor.
   */
  public abstract void registerCompoundFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, @Nullable Object... additionalWrapperParameters) throws DuplicateEntryException, Exception;
  
  /** Registers a class responsible for interpreting a field that can be represented in at least this two different forms: As a variable with a single field, or as a variable with only the inline value,
   * If your actionable uses getOnlyFieldOrFieldOfName or a similar method, you should use this for registration.
   * for example: 
   * player of name: onyxtite
   * player of name:
   *   name: onyxtite
   * It registers it as both a simple and a compound field wrapper and  it makes it so the plugin never tries to interpret variable values for this variable as the compressible variable values, and therefore they are interpreted as the value of the field.
   * for example, this would make the following statement yield the player onyxtite and not the string onyxtite.
   * player of name: <server owner name> 
   * @param fieldName The name of the field & the name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * That class needs to have a constructor that takes an object and needs to be an actionable of the type that it produces.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws DuplicateEntryException If the field is already being wrapped by a class previously registered by a plugin.
   * @throws Exception If there was a problem interpreting the entry that's being registered, for example the class is missing the relevant constructor.
   */
  public abstract void registerFlexibleFieldWrapper(@NotNull String fieldName, @NotNull Class wrapperClass, @Nullable Object... additionalWrapperParameters) throws DuplicateEntryException, Exception;

  /** Removes the actionable types registered by this plugin. You can use this to make your plugin's config reload friendly:
   * Read the new actionable types, place them on a list, if no errors popup then
   * - call this method 
   * - loop through the list and register all actionable types, handling any exceptions as you see fit
   * Otherwise, don't do anything, keeping the previous config.
   */
  public abstract void removeActionableTypesOfThisPlugin();
  
}
