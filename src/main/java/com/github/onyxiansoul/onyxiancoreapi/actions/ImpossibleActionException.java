package com.github.onyxiansoul.onyxiancoreapi.actions;

/**The exception thrown when an action cannot be executed*/
public class ImpossibleActionException extends Exception {

  public ImpossibleActionException(String reason, Exception e) {
    super(reason,e);
  }

  public ImpossibleActionException(String reason) {
    super(reason);
  }

}
