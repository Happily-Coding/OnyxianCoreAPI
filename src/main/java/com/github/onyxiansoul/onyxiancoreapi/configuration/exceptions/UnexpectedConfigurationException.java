package com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions;

import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValue;

/**An exception thrown when the configuration file contains entry/entries that don't follow the plugin's config formatting and cannot be read by the plugin.
 @deprecated : Will be replaced by a factory method accessible by any plugins who want to throw this exception, in order separate and prevent exposing the implementation */
public class UnexpectedConfigurationException extends Exception {
  private static final String FOUND_A_PROBLEM = "Found a problem while ";
  private static final String THIS_HAPPENED = ". This happened inside the structured value: ";

  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. This happened inside the structured value: yourStructuredValue' */
  public UnexpectedConfigurationException (String whatYouWereTryingToDo, StructuredValue yourStructuredValue){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo+ THIS_HAPPENED+ yourStructuredValue);
  }
  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. This happened inside the structured value: yourStructuredValue' and also stores the exception cause. */
  public UnexpectedConfigurationException (String whatYouWereTryingToDo, StructuredValue yourStructuredValue, Exception cause){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo+ THIS_HAPPENED+ yourStructuredValue, cause);
  }
  
  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo, and also stores the exception cause. It should be used only if there is no StructuredValue at the point the exception is thrown*/
  public UnexpectedConfigurationException(String whatYouWereTryingToDo, Exception cause){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo, cause);
  }

  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. It should be used only if there is no StructuredValue at the point the exception is thrown*/
  public UnexpectedConfigurationException(String whatYouWereTryingToDo){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo);
  }
}
