package com.github.onyxiansoul.onyxiancoreapi.configuration;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject.YmlObject;

public interface ConfigurablesFactory {
  
  public abstract <T> T makeConfigurable(String registeredType, YmlObject object) throws UnexpectedConfigurationException;
  
}
