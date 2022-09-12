package com.github.onyxiansoul.onyxiancoreapi.files;
import java.io.File;
import org.jetbrains.annotations.NotNull;

public interface FileFactory {
  
  /** Gets a file from a certain path inside the plugin folder, or unpacks it from a certain path inside the plugin jar, if it didn't exist inside the plugin folder, and then gets it.
   * @param fileNameWithExtension the name of the file to grab, with its extension for example config.yml
   * @param pluginFolderSubPath the path where the file should be located in the plugin folder, for example "" for the file to be in the main folder, or "configs" to be inside the configs folder, or "configs/world" to be inside the world folder inside configs.
   * @param pluginJarSubPath the path of the file inside the jar, for example "" for the file to be in the main folder, or "configs" to be inside the configs folder, or "configs/world" to be inside the world folder inside configs.
   * @return The file, located outside the plugin folder.
   * @throws com.github.onyxiansoul.onyxiancoreapi.utils.UnavailableFileException If the file couldn't be obtained.
   */
  public File unpackIfNecessairyAndGet(@NotNull String fileNameWithExtension, @NotNull String pluginFolderSubPath, @NotNull String pluginJarSubPath) throws UnavailableFileException;
  
}
