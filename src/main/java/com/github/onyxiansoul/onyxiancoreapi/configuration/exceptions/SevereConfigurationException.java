package com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions;

/**A configuration exception so severe the plugin can't properly function.*/
public class SevereConfigurationException extends Exception {
    
    public SevereConfigurationException(String message, Exception e){
        super("The configuration file has a Severe Issue that will prevent the plugin from functioning: " + System.lineSeparator()
                + message, e);
    }
    
}
