package com.github.onyxiansoul.onyxiancoreapi.configuration;

import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValue;

public abstract class ConfigUpdate {
  private final String semanticVersionString;
  
  public ConfigUpdate(String semanticVersionString){
    this.semanticVersionString = semanticVersionString;
  }
  
  public abstract void apply(StructuredValue configurationToApplyTo); //TODO: REFACTOR
  
  public final String getVersion(){
    return semanticVersionString;
  }
}
