package com.github.onyxiansoul.onyxiancoreapi.utils;

import java.io.Serializable;
import org.bukkit.Location;

public class BlockLocation implements Serializable {
  private final int x;
  private final int y;
  private final int z;
  
  public BlockLocation(Location location){
    this.x = location.getBlockX();
    this.y = location.getBlockY();
    this.z = location.getBlockZ();
  }
  
}
