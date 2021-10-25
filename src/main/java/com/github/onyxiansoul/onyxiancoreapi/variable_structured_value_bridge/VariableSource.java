package com.github.onyxiansoul.onyxiancoreapi.variable_structured_value_bridge;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import java.util.Collection;

/**An element capable of producing registered variables from a structured value used in its creation. */
public interface VariableSource{
  
  /**Crafts an element of the registered type for the structured value's key, using it as value source.
   * @param <T> The type of the element.
   * @return The object belonging to the registered class.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException | MissingEntryException if there is an error retrieving the field or crafting the variable
  */
  public <T> T craft() throws UnexpectedConfigurationException, MissingEntryException;
  
  /**Crafts an element of a certain type, using this value source
   * @param <T> The type of the element.
   * @param variableType The name used to register the class of that type of element
   * @return The object belonging to the registered class.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException | MissingEntryException if there is an error retrieving the field or crafting the variable
  */
  public <T> T craft(String variableType) throws UnexpectedConfigurationException, MissingEntryException;
  
  public VariableSource getVariableSourceOfField(String fieldName) throws UnexpectedConfigurationException;
  
  public VariableSource getVariableSourceOfField(int fieldNumber) throws UnexpectedConfigurationException;
  
  public VariableSource getVariableSourceOfOnlyField() throws UnexpectedConfigurationException;
  
  public VariableSource getGetVariableSourceOfOnlyFieldOrFieldOfName(String fieldName) throws UnexpectedConfigurationException;
  
  public Collection<VariableSource> getVariableSourcesOfAllFields() throws UnexpectedConfigurationException;
  
  public <T> T getField(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getField(int fieldNumber) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getOnlyField() throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getOnlyFieldOrFieldOfName(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
  
}
