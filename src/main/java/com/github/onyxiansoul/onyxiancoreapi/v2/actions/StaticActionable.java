package com.github.onyxiansoul.onyxiancoreapi.v2.actions;

/**An action which doesn't require any additional variables to be executed on runtime */
public interface StaticActionable<T> extends Actionable<T> {

  /**Executes the action.
   Since the static actions don't require runtime parameters, they have this method, which executes the action without requiring any runtime datasources*/
  public T enact() throws ImpossibleActionException;

}
