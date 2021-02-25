package com.github.onyxiansoul.onyxiancoreapi.utils;

import org.jetbrains.annotations.NotNull;

/**Anything whose objects can have a name.*/
public interface Nameable {
  public @NotNull default String getName(){
    return "Un-Named";
  }
  
}
