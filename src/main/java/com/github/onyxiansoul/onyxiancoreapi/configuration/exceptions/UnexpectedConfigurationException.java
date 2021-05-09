package com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions;

import com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject.YmlObject;

/**An exception thrown when the configuration file contains entry/entries that don't follow the plugin's config formatting and cannot be read by the plugin.
 @deprecated : Will be replaced by a factory method accessible by any plugins who want to throw this exception, in order separate and prevent exposing the implementation */
public class UnexpectedConfigurationException extends Exception {
  private static final String FOUND_A_PROBLEM = "Found a problem while ";
  private static final String THIS_HAPPENED = ". This happened inside the yml object: ";

  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. This happened inside the yml object: yourYmlObject' */
  public UnexpectedConfigurationException (String whatYouWereTryingToDo, YmlObject yourYmlObject){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo+ THIS_HAPPENED+ "");
  }
  /**Construct an exception of message: 'Found a problem while whatYouWereTryingToDo. This happened inside the yml object: yourYmlObject' and also stores the exception cause. */
  public UnexpectedConfigurationException (String whatYouWereTryingToDo, YmlObject yourYmlObject, Exception cause){
    super(FOUND_A_PROBLEM+ whatYouWereTryingToDo+ THIS_HAPPENED+ "", cause);
  }
    
}
