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

    
}
