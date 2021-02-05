package com.github.onyxiansoul.onyxiancoreapi.v2.actions;

import java.util.Map;

/**Anything that can be executed.
 *It should not be directly implemented, instead use:
 *@CircumstancialAction if what it does/affects depends on the run circumstances, for example, the event that caused it to occur.
 *@StaticAction if the action works independently of the run circumstances, for example, it sends a console message*/
 public interface Actionable<T> {
  
  /**Executes the action, given a set of Circumstances*/
  public T enact(Map<String,Object> runCircumstances) throws ImpossibleActionException;

  
  
    /**Get the type of object this actionable produces
     * @return the class of object this transformer produces*/
    default Class<?> getT() {
      try {
          return this.getClass().getMethod("enact", Map.class).getReturnType();
      } catch (NoSuchMethodException | SecurityException ex) {
          throw new IllegalArgumentException("Could not find the type of an actionable. This is really unexpected! "+ this.getClass());
      }
    }
    
    
    
}
