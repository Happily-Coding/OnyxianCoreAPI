package me.onyxiansoul.onyxiancoreapi.actions;

import java.util.function.BiFunction;
import me.onyxiansoul.onyxiancoreapi.event.EventOfType;
import me.onyxiansoul.onyxiancoreapi.parameters.PrePlaceholder;

/** A type of action. 
 * Each type of action is identified in the config via the config key,
 * Has a function that determines what an actino of this type does, for example send a message
 * And a list of variables that are used by that action to help make the behavior more specfic, ie who to send the message, and what message to send
 * This variables are pre-placeholders, since they simply represent a type of placeholder.
 * For example, they could be a string pre-placeholder.
 */
public interface ActionType {
    
    
    /**
     Gets the configuration key which the plugin uses to identify a section as an action of this type.
     */
    public String getActionConfigKey();

    /**
     Gets the function actions of this type run when triggered
     */
    public BiFunction<EventOfType, Action, Boolean> getFunctionToRun();
    
    /**
     * Gets the pre-placeholder variables read when creating an action of this type from a config file.
     */
    public PrePlaceholder[] getVariablesRequired();
    
}
