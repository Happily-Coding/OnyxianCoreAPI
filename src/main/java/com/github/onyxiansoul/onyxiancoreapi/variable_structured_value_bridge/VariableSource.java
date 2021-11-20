package com.github.onyxiansoul.onyxiancoreapi.variable_structured_value_bridge;

import com.github.onyxiansoul.onyxiancoreapi.actionable_system.ImpossibleActionException;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import com.github.onyxiansoul.onyxiancoreapi.index_system.MissingEntryException;
import java.util.Collection;

/**An element capable of producing registered variables from a structured value used in its creation. */
public interface VariableSource{
  
  /**Get the key of the structured value being used as a source*/
  public String getSourceKey();
  
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
  
  /**Gets the non structured value of this object, or throws an error if it doens't exist.
   Allows for values like booleans, numbers or strings to be accessible for intepretation by the plugin on the end nodes of configuration
   for example: 
   * server name: my cool server*/
  public Object getInnerNonStructuredValue() throws UnexpectedConfigurationException;
  
  public VariableSource getVariableSourceOfField(String fieldName) throws UnexpectedConfigurationException;
  
  public VariableSource getVariableSourceOfField(int fieldNumber) throws UnexpectedConfigurationException;
  
  public VariableSource getVariableSourceOfOnlyField() throws UnexpectedConfigurationException;
  
  public VariableSource getVariableSourceOfOnlyFieldOrFieldOfName(String fieldName) throws UnexpectedConfigurationException;
  
  /**If this variable source has no inner fields, return this source, if the variable source has a single field return the source of that field, if the variable source has multiple fields, return the source of the field of fieldName
   * Basicly, its a way to allow pre-processing of a field with another field type, ie(processing a biome name string), and using that string to create the biome variable*/
  public VariableSource getVariableSourceOfOnlyFieldOrFieldOfNameOrThis(String fieldName) throws UnexpectedConfigurationException;
  
  public Collection<VariableSource> getVariableSourcesOfAllFields() throws UnexpectedConfigurationException;
  
  public <T> T getField(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getField(int fieldNumber) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getOnlyField() throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getOnlyFieldOrFieldOfName(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
  
  /**Create a variable of a cretain type from: This variable source if it has no inner fields OR the variable source of the only field this variable source has (if it has only one) OR the variable source of the field of fieldName, if it has multiple fields
   * Basicly, its a way to allow pre-processing of a field to create a variable, that can be used to create the intended variable. For example: processing a biome name string, and using that string to create the biome variable*/
  public <T> T getOnlyFieldOrFieldOfNameOrThisAs(String fieldName, String variableType) throws UnexpectedConfigurationException, MissingEntryException;
  
  /**Create a variable of the fieldName type from: This variable source if it has no inner fields OR the variable source of the only field this variable source has (if it has only one) OR the variable source of the field of fieldName, if it has multiple fields
   * Basicly, its a way to allow pre-processing of a field to create a variable, that can be used to create the intended variable. For example: processing a biome name string, and using that string to create the biome variable*/
  public <T> T getOnlyFieldOrFieldOfNameOrThis(String fieldName) throws UnexpectedConfigurationException, MissingEntryException;
  
  public <T> T getFieldOrRegisteredVariable(String fieldName, String registeredVariableName) throws UnexpectedConfigurationException, MissingEntryException;
  
  /**Gets the variable value of a certain field that produces an action, or a registered variable, and then enacts it to get the actual value.*/
  public <T> T getFieldOrRegisteredVariableWrappedValue(String fieldName, String registeredVariableName) throws UnexpectedConfigurationException, MissingEntryException, ImpossibleActionException;
  
  /**Gets the variable value of a certain field that produces an action, and then enacts it to get the actual value.
   Its meant to be used when reading configuration values that need to be immediately available, not reliying on runtime circumstances for example 'enable bstats'*/
  public <T> T getFieldWrappedValue(String fieldName) throws UnexpectedConfigurationException, MissingEntryException, ImpossibleActionException;
    
  /**Gets the variable value of a certain field, and then enacts it to get the actual value, or if that field doesn't exist, returns the default value
   Its meant to be used when reading configuration values that need to be immediately available, not reliying on runtime circumstances for example 'enable bstats', but that may not exist.*/
  public <T> T getFieldWrappedValueOrDefault(String fieldName, T defaultValue) throws UnexpectedConfigurationException, MissingEntryException, ImpossibleActionException;

  /**Gets the value of a field, or returns a default value if its not available. Meant to be used mainly for fields that arent actionable*/
  public <T> T getFieldOrDefault(String field, T defaultValue) throws UnexpectedConfigurationException, MissingEntryException, ImpossibleActionException;
  
  /**Checks if this variable source has an inner source of a certain name
   @deprecated may be removed since it doesn't seem to have any use with the way you should read configurations*/
  public boolean containsField(String fieldName);
  
  /**Checks if this value source has no other sources inside
   * returns true if this value has no inner value sources, meaning its a simple value*/
  public boolean lacksInnerStructuredValues();
  
}
