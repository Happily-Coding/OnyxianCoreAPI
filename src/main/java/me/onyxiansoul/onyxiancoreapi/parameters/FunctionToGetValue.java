
package me.onyxiansoul.onyxiancoreapi.parameters;

import java.util.Map;

public interface FunctionToGetValue {
    
    /*public default Object getValueSafely(Map<String, Object> availableValues){
        try{
            return getValue(availableValues);
        }
        catch (ClassCastException e){
            
        }
    }*/
    
    //method to get the value of a parameter
    Object getValue (Map<String, Object> availableValues) throws Exception;
    
}
