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

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 13 * hash + this.x;
    hash = 13 * hash + this.y;
    hash = 13 * hash + this.z;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BlockLocation other = (BlockLocation) obj;
    if (this.x != other.x) {
      return false;
    }
    if (this.y != other.y) {
      return false;
    }
    if (this.z != other.z) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("BlockLocation{x=").append(x);
    sb.append(", y=").append(y);
    sb.append(", z=").append(z);
    sb.append('}');
    return sb.toString();
  }
  
}
