package com.github.onyxiansoul.onyxiancoreapi.configuration;

public abstract class ConfigUpdate {
  private final String semanticVersionString;
  
  public ConfigUpdate(String semanticVersionString){
    this.semanticVersionString = semanticVersionString;
  }
  
  public abstract void apply(OnyxianConfiguration configurationToApplyTo);
  
  public final String getVersion(){
    return semanticVersionString;
  }
}
