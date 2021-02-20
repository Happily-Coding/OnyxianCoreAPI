package com.github.onyxiansoul.onyxiancoreapi.actions.interpreters;

import com.github.onyxiansoul.onyxiancoreapi.actions.interpreters.RuntimeSupplier;
import javax.validation.constraints.NotNull;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/** The base for any event data obtainer.
 *  All Onyxian plugins that require obtaining data have their unique implementation of this class
 *  Only onyxian plugins should extend this interface directly. All other plugins should extend the implementation located on the api of one of the onyxianPlugins.
 */
public abstract class EventDataSupplier <T extends Event> extends RuntimeSupplier<T> {

    public EventDataSupplier(T runtimeObject) {
      super(runtimeObject);
    }
    
    /**Get the name of the event
     * @param e = an event of this type
     * @return  The name of the event
     */
    @NotNull @Override
    public String getEventName(){
        return e.getEventName();
    }
    
    /**Get the handlers list for the event
     * @param e = an event of this type
     * @return  The handlers for the event.
     */
    @NotNull @Override
    public HandlerList getHandlersList(){
        return e.getHandlers();
    }
    
    /**Get the class of the event
     * @param e = an event of this type
     * @return  The class of the event
     */
    @NotNull @Override
    public Class<?> getEventClass(){
        return e.getClass();
    }
    
    /**Check if the event has been cancelled (usually by another plugin)
     * @param e = an event of this type
     * @return  true if it has been cancelled, false if it hasn't (or isn't cancellable).
     */
    @NotNull @Override
    public boolean isCancelled(){
        if (e instanceof Cancellable){
            return ((Cancellable) e).isCancelled();
        }
        return false;
    }

}
