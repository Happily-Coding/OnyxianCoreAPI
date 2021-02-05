package com.github.onyxiansoul.onyxiancoreapi.v2.actions;

import java.util.Map;

/**Anything that can be executed.
 *It should not be directly implemented, instead use:
 *@CircumstancialAction if what it does/affects depends on the run circumstances, for example, the event that caused it to occur.
 *@StaticAction if the action works independently of the run circumstances, for example, it sends a console message*/
 public interface Actionable<T> {
  
  /**Executes the action, given a set of Circumstances*/
  public T enact(Map<String,Object> runCircumstances) throws ImpossibleActionException;

}
