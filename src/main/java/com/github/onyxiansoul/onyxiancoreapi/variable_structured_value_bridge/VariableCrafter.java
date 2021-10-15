package com.github.onyxiansoul.onyxiancoreapi.variable_structured_value_bridge;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValue;

/**An element capable of producing registered variables from a structured value used in its creation. */
public interface VariableCrafter{
  
  /**Gets the Structured Value which is wrapped by this interpretable value*/
  public StructuredValue getSource();

  /**Crafts an element of a certain type, using this value source
   * @param <T> The type of the element.
   * @param variableType The name used to register the class of that type of element
   * @return The object belonging to the registered class.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException | MissingEntryException if there is an error retrieving the field or crafting the variable
  */
  public <T> T craftRegisteredT() throws UnexpectedConfigurationException, MissingEntryException;
  
  /**Crafts an element of a certain type, using this value source
   * @param <T> The type of the element.
   * @param variableType The name used to register the class of that type of element
   * @return The object belonging to the registered class.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException | MissingEntryException if there is an error retrieving the field or crafting the variable
  */
  public <T> T craft(String variableType) throws UnexpectedConfigurationException, MissingEntryException;
  
  /** Crafts the a wrapper for the value of the inner field of a certain name
   * @param fieldName the name of the field
   * @return The wrapped value of the field.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException if that field doesn't exist
   */
  public VariableCrafter getCrafterForField(String fieldName) throws UnexpectedConfigurationException;
  
  public <T> T craftFieldAsRegisteredT(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T craftFieldAsRegisteredT(int fieldNumber) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T craftField(int fieldNumber, String type) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T craftField(String fieldName, String type) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T craftOnlyFieldAsRegisteredT() throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T craftOnlyField(String type) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T craftOnlyFieldOrFieldAsT(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
 
}
