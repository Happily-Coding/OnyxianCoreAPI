package com.github.onyxiansoul.onyxiancoreapi.utils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;

public final class FileUtils {
  
  private FileUtils() {}
    
  public static void unpackOntoPluginFolder(Plugin plugin, String insidePathWithoutFinalBar, String outsidePathWithoutFinalBar, String fileNameWithExtension) throws UnavailableFileException{
    InputStream jarURL;
    try{
      InputStream jarURL11 = plugin.getResource("/plugin.yml"); 
      InputStream jarURL22 = plugin.getResource(File.pathSeparator+"plugin.yml");
      InputStream jarURL23 = plugin.getResource(File.separator+"plugin.yml");
      InputStream jarURL33 = plugin.getResource("plugin.yml");
      InputStream jarURL44 = plugin.getClass().getResourceAsStream("plugin.yml");
      InputStream jarURL55 = plugin.getClass().getResourceAsStream("/plugin.yml");
      try {
        InputStream jarURL56 = plugin.getClass().getResource("plugin.yml").openStream();
      } catch (IOException ex) {
        Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      InputStream jarURL1 = plugin.getResource(insidePathWithoutFinalBar+"/"+fileNameWithExtension); 
      InputStream jarURL2 = plugin.getResource("/"+ insidePathWithoutFinalBar+"/"+fileNameWithExtension);
      InputStream jarURL3 = plugin.getResource("plugin.yml");
      InputStream jarURL4 = plugin.getClass().getResourceAsStream(fileNameWithExtension);
      try {
        InputStream jarURL5 = plugin.getClass().getResource(fileNameWithExtension).openStream();
      } catch (IOException ex) {
        Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
      }
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
