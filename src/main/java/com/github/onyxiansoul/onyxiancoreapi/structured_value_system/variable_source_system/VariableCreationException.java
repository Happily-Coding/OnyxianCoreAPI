package com.github.onyxiansoul.onyxiancoreapi.structured_value_system.variable_source_system;

import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.variable_source_system.VariableSource;

/**An exception thrown when ta variable could not be created from its source values
 @deprecated : Will be replaced by a factory method accessible by any plugins who want to throw this exception, in order separate and prevent exposing the implementation */
public class VariableCreationException extends Exception{
  private static final String FOUND_A_PROBLEM = "Found a problem while ";
  private static final String THIS_HAPPENED = ". This happened while using the variable source: ";

  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. This happened inside the structured value: yourVariableSource' */
  public VariableCreationException (String whatYouWereTryingToDo, VariableSource yourVariableSource){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo+ THIS_HAPPENED+ yourVariableSource);
  }
  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. This happened inside the structured value: yourVariableSource' and also stores the exception cause. */
  public VariableCreationException (String whatYouWereTryingToDo, VariableSource yourVariableSource, Exception cause){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo+ THIS_HAPPENED+ yourVariableSource, cause);
  }
  
  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo, and also stores the exception cause. It should be used only if there is no VariableSource at the point the exception is thrown*/
  public VariableCreationException(String whatYouWereTryingToDo, Exception cause){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo, cause);
  }

  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. It should be used only if there is no VariableSource at the point the exception is thrown*/
  public VariableCreationException(String whatYouWereTryingToDo){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo);
  }
}
