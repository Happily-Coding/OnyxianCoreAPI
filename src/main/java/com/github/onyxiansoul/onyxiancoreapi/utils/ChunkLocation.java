package com.github.onyxiansoul.onyxiancoreapi.utils;

import org.bukkit.Location;

public class ChunkLocation {
    private final int x;
    private final int z;
    
    //Create the chunk location from chunk x and z
    public ChunkLocation(int x, int z){
        this.x = x;
        this.z = z;
    }
    
    //Create the chunk location from a normal location
    public ChunkLocation(Location location){
        this.x=location.getChunk().getX();
        this.z=location.getChunk().getZ();
    }
    
    public int getX(){ return x;}
    public int getZ(){ return z;}

    @Override
    public String toString() {
        return "ChunkLocation{" + "x=" + x + ", z=" + z + '}';
    }

    @Override
    public int hashCode() {
      int hash = 5;
      hash = 71 * hash + this.x;
      hash = 71 * hash + this.z;
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
      final ChunkLocation other = (ChunkLocation) obj;
      if (this.x != other.x) {
        return false;
      }
      if (this.z != other.z) {
        return false;
      }
      return true;
    }

    
}
