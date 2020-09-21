
package me.onyxiansoul.onyxiancoreapi.actions;

import java.util.Map;

public interface FunctionToRun {
    
    //Method to make the function actually do something. The map<String,Object> comes from obtaining every single value of each palceholder in the Map<String,Placeholder> of an action for this eventType.
    public boolean run(Map<String,Object> parameterValues);
    
}
