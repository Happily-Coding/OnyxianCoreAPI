
package me.onyxiansoul.onyxiancoreapi.parameters;

import me.onyxiansoul.onyxiancoreapi.event.EventOfType;

public interface FunctionToGetValue {
    
    //method to get the value of a parameter
    public boolean run (String cleansedPlaceholderString, EventOfType eventOfType);
    
}
