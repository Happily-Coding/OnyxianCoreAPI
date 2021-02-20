package com.github.onyxiansoul.onyxiancoreapi.actions;

import com.github.onyxiansoul.onyxiancoreapi.actions.interpreters.RuntimeSupplier;
import java.util.Map;

/**Anything that can be executed.
 *It should not be directly implemented, instead use:
 *@CircumstancialAction if what it does/affects depends on the run circumstances, for example, the event that caused it to occur.
 *@StaticAction if the action works independently of the run circumstances, for example, it sends a console message*/
 public interface Actionable<T> {
  
  /**Executes the action, given a set of Circumstances
   * @param supplier The runtime supplier, a class that supplies a wide variety of fields, obtaining them from an object used during the supplier creation, such as an event.
   * @return A variable resulting from the action, or Void if its not meant to be a producer.
   * @throws com.github.onyxiansoul.onyxiancoreapi.actions.ImpossibleActionException If an action is impossible to perform.
   */
  public T enact(RuntimeSupplier supplier) throws ImpossibleActionException;
  
  /**Executes the action, with no circumstances. Might throw an impossibleActionException if it required circumstances*/
  public default T enact()throws ImpossibleActionException{ 
    return enact(null);
  }
  
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
