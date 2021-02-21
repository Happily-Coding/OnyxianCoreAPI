package com.github.onyxiansoul.onyxiancoreapi.configuration;

public abstract class ConfigUpdate {
  protected final String semanticVersionString;
  
  public ConfigUpdate(String semanticVersionString){
    this.semanticVersionString = semanticVersionString;
  }
  
  public abstract void apply(OnyxianConfiguration configurationToApplyTo);
  
}
