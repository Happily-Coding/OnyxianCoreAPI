package com.github.onyxiansoul.onyxiancoreapi.configuration;

import com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject.YmlObject;

public abstract class ConfigUpdate {
  private final String semanticVersionString;
  
  public ConfigUpdate(String semanticVersionString){
    this.semanticVersionString = semanticVersionString;
  }
  
  public abstract void apply(YmlObject configurationToApplyTo); //TODO: REFACTOR
  
  public final String getVersion(){
    return semanticVersionString;
  }
}
