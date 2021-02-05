package com.github.onyxiansoul.onyxiancoreapi.v2.actions;

import java.util.Map;

/**An action which doesn't require any additional variables to be executed on runtime */
public interface StaticActionable<T> extends Actionable<T> {

  /**Executes the action.
   Since the static actions don't require runtime parameters, they have this method, which executes the action without requiring any runtime datasources*/
  public T enact() throws ImpossibleActionException;
  
  @Override
  public default T enact(Map<String,Object> runtimeParmaeters) throws ImpossibleActionException{
    return enact();
  }

}
