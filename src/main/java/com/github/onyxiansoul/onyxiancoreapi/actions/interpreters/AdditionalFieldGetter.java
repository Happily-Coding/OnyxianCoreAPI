package com.github.onyxiansoul.onyxiancoreapi.actions.interpreters;


public abstract class AdditionalFieldGetter<T> {
  
  /**Gets the field value, using the supplier as a source of other values, incluiding the raw object contained within.*/
  public abstract T getFieldValue(RuntimeSupplier supplier);
  
}
