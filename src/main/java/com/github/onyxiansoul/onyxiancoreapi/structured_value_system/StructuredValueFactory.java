package com.github.onyxiansoul.onyxiancoreapi.structured_value_system;

import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigUpdate;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**The place that allows creating structured values*/
public interface StructuredValueFactory {
  
  public abstract StructuredValue create(@NotNull String key, @Nullable Object value);
  
  public abstract StructuredValue create (@NotNull Object value);
  
  public abstract StructuredValue create();
  
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
