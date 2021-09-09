package com.github.onyxiansoul.onyxiancoreapi.utils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Objects;
import org.bukkit.plugin.Plugin;

public final class FileUtils {
  
  private FileUtils() {}
    
  public static void unpackOntoPluginFolder(Plugin plugin, String insidePathWithoutFinalBar, String outsidePathWithoutFinalBar, String fileNameWithExtension) throws UnavailableFileException{
    InputStream jarURL;
    try{
      //jarURL = plugin.getResource(insidePathWithoutFinalBar+"/"+fileNameWithExtension); 
      jarURL = Objects.requireNonNull(plugin.getClass().getResourceAsStream(insidePathWithoutFinalBar+"/"+fileNameWithExtension));
    }
    catch(RuntimeException e){
      throw new UnavailableFileException(insidePathWithoutFinalBar, fileNameWithExtension,e);
    }
    try{
      File outsideFolder = new File(plugin.getDataFolder(),outsidePathWithoutFinalBar);
      if(!outsideFolder.exists()) outsideFolder.mkdirs();
      File fileOutside = new File(outsideFolder, fileNameWithExtension);
      if(!fileOutside.exists()) Files.copy(jarURL, fileOutside.toPath());
    }
    catch(IOException | RuntimeException e){
      throw new UnavailableFileException(outsidePathWithoutFinalBar, fileNameWithExtension,e);
    }
  }
  
}
