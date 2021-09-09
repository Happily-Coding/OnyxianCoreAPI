package com.github.onyxiansoul.onyxiancoreapi.utils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.bukkit.plugin.Plugin;

public final class FileUtils {
  
  private FileUtils() {}
    
  public static void unpackOntoPluginFolder(Plugin plugin, String insidePathWithoutFinalBar, String outsidePathWithoutFinalBar, String fileNameWithExtension) throws IOException{
    //InputStream jarURL = plugin.getResource(insidePathWithoutFinalBar+"/"+fileNameWithExtension);
    InputStream jarURL = plugin.getClass().getResourceAsStream(insidePathWithoutFinalBar+"/"+fileNameWithExtension);
    File outsideFolder = new File(plugin.getDataFolder(),outsidePathWithoutFinalBar);
    if(!outsideFolder.exists()) outsideFolder.mkdirs();
    File fileOutside = new File(outsideFolder, fileNameWithExtension);
    if(!fileOutside.exists()) Files.copy(jarURL, fileOutside.toPath());    
  }
  
}
