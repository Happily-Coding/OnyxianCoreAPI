package com.github.onyxiansoul.onyxiancoreapi.files.yaml;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

public interface YmlFactory {
  
  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * previously called getConfiguration, and previously located at OnyxianCoreAPI
  * @param file the file whose contents will be interpreted to a YamlConfiguration object.
  * @return a Yml Object representing the file's values.
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException  if the file couldn't be read.
  */
  public abstract YamlConfiguration create(@NotNull File file) throws UnexpectedConfigurationException;

}
