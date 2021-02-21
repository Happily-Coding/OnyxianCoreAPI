package com.github.onyxiansoul.onyxiancoreapi.actions;

/**The exception thrown when an action cannot be executed*/
public class ImpossibleActionException extends Exception {

  public ImpossibleActionException(String reason, Throwable t) {
    super(reason,t);
  }

  public ImpossibleActionException(String reason) {
    super(reason);
  }

}
