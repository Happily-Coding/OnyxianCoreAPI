package com.github.onyxiansoul.onyxiancoreapi.structured_value_system;

import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigUpdate;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**The place that allows creating structured values*/
public interface StructuredValueFactory {
  
  /**Creates a structured value with a certain parent, a certain key, and a value depending on the value object
   * @param key The key of the structured value.
   * @param value Any type of value.
   * @param parent The parent of this structured value (can be null if it shouldn't have one)
    * If its a List, Map, or Memory Section, it will be transformed into a list of fields the new structured value will hold.
    * If its a structured value, it will be used as a single field inside the new structured value.
    * If its any other kind of value, it will be used as a non structured final value of the created structured value. 
   * @return  the new structured value
   */
  public abstract StructuredValue create(@Nullable StructuredValue parent, @NotNull String key, @Nullable Object value);
  
  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * previously called getConfiguration, and previously located at OnyxianCoreAPI
  * @param fileName The name of the file itself without yml
  * @param configUpdates The updates that will be applied to the configuration if its not up to date.
  * @return a Yml Object representing the file's values.
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException  if the file couldn't be read.
  * @deprecated Will be replaced for a method that takes a configuration file as a parameter instead.
  */
  public abstract @Deprecated StructuredValue create(@NotNull String fileName, @Nullable ConfigUpdate[] configUpdates) throws UnexpectedConfigurationException;
  
}
