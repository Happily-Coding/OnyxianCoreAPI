package com.github.onyxiansoul.onyxiancoreapi.actionable_system;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.RuntimeCircumstances;
import java.io.Serializable;

/**Anything that can be executed.
 * To create an aditional action type, you should implement this & register it with the core's API
 * Extends serializable, so the api can give a clone of actionable instead of the actionable itself, to safeguard it from modification.
 */
 public interface Actionable<T> extends Serializable {
  
  /**Executes the action, given a set of Circumstances
   * @param supplier The runtime supplier, a class that supplies a wide variety of fields, obtaining them from an object used during the supplier creation, such as an event.
   * @return A variable resulting from the action, or Void if its not meant to be a producer.
   * @throws com.github.onyxiansoul.onyxiancoreapi.actionable_system.ImpossibleActionException If an action is impossible to perform.
   */
  T enact(RuntimeCircumstances supplier) throws ImpossibleActionException;
  
  /**Executes the action, with no circumstances. Might throw an impossibleActionException if it required circumstances*/
  default T enact()throws ImpossibleActionException{ 
    return enact(null);
  }
  
  /**Get the type of object this actionable produces
   * @return the class of object this transformer produces*/
  default Class<?> getT() {
    try {
        return this.getClass().getMethod("enact", RuntimeCircumstances.class).getReturnType();
        //return this.getClass().getMethod("enact", Map.class).getReturnType();
    } catch (NoSuchMethodException | SecurityException ex) {
        throw new IllegalArgumentException("Could not find the type of an actionable. This is really unexpected! "+ this.getClass());
    }
  }
    
}
