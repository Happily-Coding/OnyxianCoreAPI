package com.github.onyxiansoul.onyxiancoreapi.structured_value_system;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**The place that allows creating structured values*/
public interface StructuredValueFactory {
  
  /**Creates a structured value with a certain parent, a certain key, and a value depending on the value object
   * @param key The key of the structured value.
   * @param value Any type of value
    * If its a List, Map, or YamlConfiguration|Memory Section, it will be transformed into a list of fields the new structured value will hold.
    * If its a structured value, it will be used as a single field inside the new structured value.
    * If its any other kind of value, it will be used as a non structured final value of the created structured value. 
   * @param parent The parent of this structured value (can be null if it shouldn't have one)
   * @return  the new structured value
   */
  public abstract StructuredValue create(@Nullable StructuredValue parent, @NotNull String key, @Nullable Object value);
  
}
