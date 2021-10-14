package com.github.onyxiansoul.onyxiancoreapi.variable_system;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValue;
import org.jetbrains.annotations.NotNull;

/**Creates variables, AKA objects of any class registered as such. 
 * Please note that for registering the class will require a constructor that takes StructuredValue as a parameter, because the values for its creation will be passed via a structured value.
 * If you want to use a 'normal' object, such as a string, simply create a class that can act as a wrapper for that object type and register it. */
public interface VariableBuilder {
  
  /**Crafts a variable of a type from a value source, be it by returning the value of a <variable> that it represents, or constructing a variable of the class registered for the type.
   */
  public <T> T craftVariable(@NotNull StructuredValue valueSource, @NotNull String variableType) throws UnexpectedConfigurationException, MissingEntryException;

}