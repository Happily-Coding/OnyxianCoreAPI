package com.github.onyxiansoul.onyxiancoreapi.structured_value_system.variable_source_system;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.files.UnavailableFileException;
import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValue;
import org.jetbrains.annotations.NotNull;

/**The place that allows creating variable sources*/
public interface VariableSourceFactory {
  
  /**Gets a value from which values can be intepreted */
  public abstract VariableSource makeVariableSource(StructuredValue structuredValue);
  
  /**A utility method that calls many factory methods commonly used in a chain to get a variable source from a configuration file (file> yaml configuration > structured value > variable source)
   * @param fileNameWithoutExtension the name of the file to grab, without its extension for example config (instead of config.yml)
   * @param pluginFolderSubPath the path where the file should be located in the plugin folder, for example "" for the file to be in the main folder, or "configs" to be inside the configs folder, or "configs/world" to be inside the world folder inside configs.
   * @param pluginJarSubPath the path of the file inside the jar, for example "" for the file to be in the main folder, or "configs" to be inside the configs folder, or "configs/world" to be inside the world folder inside configs.
   * @return The file, located outside the plugin folder.
   * @throws com.github.onyxiansoul.onyxiancoreapi.files.UnavailableFileException If the file couldn't be obtained.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException if it couldn't be interpreted.
   */
  public VariableSource makeVariableSourceFromFile(@NotNull String fileNameWithoutExtension, @NotNull String pluginFolderSubPath, @NotNull String pluginJarSubPath) throws UnavailableFileException, UnexpectedConfigurationException;
}
