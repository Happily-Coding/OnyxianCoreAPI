package com.github.onyxiansoul.onyxiancoreapi.identity;

public interface Registrable {
  
  public default String getRegistrant(){
    return "Not Registered";
  }
  
}
