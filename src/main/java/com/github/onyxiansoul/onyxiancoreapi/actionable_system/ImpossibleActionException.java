package com.github.onyxiansoul.onyxiancoreapi.actionable_system;

/**The exception thrown when an action cannot be executed
  @deprecated : May be replaced by a factory method */
public class ImpossibleActionException extends Exception {

  public ImpossibleActionException(String reason, Throwable t) {
    super(reason,t);
  }

  public ImpossibleActionException(String reason) {
    super(reason);
  }

}
