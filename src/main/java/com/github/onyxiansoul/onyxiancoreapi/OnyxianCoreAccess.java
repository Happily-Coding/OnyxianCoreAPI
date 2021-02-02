package com.github.onyxiansoul.onyxiancoreapi;

import org.bukkit.plugin.Plugin;

/**The class which gives your plugin access to the OnyxianCoreAPI*/
public interface OnyxianCoreAccess {
  
  /**Get the API to get information about or extend the functionality of the onyxiancore.*/
  public OnyxianCoreAPI getOnyxianCoreAPI(Plugin plugin);
  
}
