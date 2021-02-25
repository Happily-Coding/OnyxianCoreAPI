package com.github.onyxiansoul.onyxiancoreapi.utils;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

public class InfoUtil {
  
  public static String getPluginInfo(@NotNull Plugin plugin){
    PluginDescriptionFile pluginDescription = plugin.getDescription();
    return "Plugin: " + pluginDescription.getName()+" " + pluginDescription.getVersion() +" by "+ String.join(" ", pluginDescription.getAuthors());
  }
  
}
