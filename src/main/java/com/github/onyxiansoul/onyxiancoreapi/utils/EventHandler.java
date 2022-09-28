package com.github.onyxiansoul.onyxiancoreapi.utils;

import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

/**An element that is both an event listener and executor, useful for when registering event handlers manually*/
public interface EventHandler extends Listener, EventExecutor{
  
}
