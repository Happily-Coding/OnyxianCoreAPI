package com.github.onyxiansoul.onyxiancoreapi.variable_structured_value_bridge;

import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValue;

/**The place that allows creating variable sources*/
public interface VariableSourceFactory {
  /**Gets a value from which values can be intepreted */
  public abstract VariableSource makeVariableSource(StructuredValue structuredValue);
  
}
