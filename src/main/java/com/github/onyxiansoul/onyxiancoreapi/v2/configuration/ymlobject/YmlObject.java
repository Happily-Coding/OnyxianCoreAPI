package com.github.onyxiansoul.onyxiancoreapi.v2.configuration.ymlobject;

import com.github.onyxiansoul.onyxiancoreapi.v2.actions.Actionable;

public abstract class YmlObject {

    /**Gets the value of a fieldOfInterest, or throws an exception if it is invalid or wasn't found
     * @param <T> The type of the fieldOfInterest.
     * @param fieldName: The name of the fieldOfInterest.
     * @throws IllegalArgumentException if the fieldOfInterest was listed, but is invalid
     * @throws NullPointerException if the field isn't listed.
     * @return the value of the fieldOfInterest*/
    public abstract <T> Actionable<T> getField(String fieldName) throws IllegalArgumentException, NullPointerException;
    
    /**Gets a fieldOfInterest or returns a default value if its not available
     * @param <T> The type of the fieldOfInterest.
     * @param fieldName The name of the fieldOfInterest.
     * @param defaultValue The default value for the fieldOfInterest
     * @return the value of the fieldOfInterest or the default value if its not listed
     * @throws IllegalArgumentException If the fieldOfInterest was listed, but is invalid*/
    public abstract <T,T2 extends Actionable<T>> T2 getField(String fieldName, Actionable<T> defaultValue) throws IllegalArgumentException;
        
    public abstract String getName();
}
