package com.github.onyxiansoul.onyxiancoreapi.configuration;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;

/**Creates a configurable of a certain type*/
public interface ConfigurableBuilder {
  
  /**Sets the value of a parameter inside the configurable
   If the value is an actionable, it'll be added as is
   If its not, it'll be wrapped by an actionable, and added.*/
  public ConfigurableBuilder param(String parameterName, Actionable<?> parameter);
  
  /**Sets the value of a parameter inside the configurable,
   It interprets the text, as if it was the value of a configuration node*/
  public ConfigurableBuilder interpretedParam(String parameterName, String textToInterpet);
  
  /**Build the configurable using a YML object with all the parameters inside the builder.*/
  public <T> T build() throws UnexpectedConfigurationException;
          
}
