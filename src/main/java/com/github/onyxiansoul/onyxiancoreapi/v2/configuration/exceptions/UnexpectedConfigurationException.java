package com.github.onyxiansoul.onyxiancoreapi.v2.configuration.exceptions;

import com.github.onyxiansoul.onyxiancoreapi.v2.configuration.util.ConfigurationUtil;
import org.bukkit.configuration.ConfigurationSection;

/**An exception thrown when the configuration file contains entry/entries that don't follow the plugin's config formatting
 and cannot be read by the plugin*/
public class UnexpectedConfigurationException extends Exception {
           
    /**The usual constructor for generic configuration errors, located inside a section*/
    public UnexpectedConfigurationException (ConfigurationSection problematicSection, String reason){
        super("Found a problem while reading: " + ConfigurationUtil.getSectionName(problematicSection)+ System.lineSeparator()
                + reason );
    }
    
   /**The constructor for generic configuration errors, located in a section, that that are the the result of catching a previous exception*/
   public UnexpectedConfigurationException (ConfigurationSection problematicSection, String reason, Exception exception){
        super("Found a problem while reading : " + ConfigurationUtil.getSectionName(problematicSection)+System.lineSeparator()
              + reason , exception);
    }
    
    /**A constructor for configuration exceptions when the section object is unavailable or inadecuate.*/
    public UnexpectedConfigurationException (String problemLocation, String reason){
        super("Found a problem while reading: " + problemLocation+ System.lineSeparator()
              + reason);
    }
    
    /**A constructor for configuration exceptions when the section object is unavailable or inadecuate, that are a result of catchign a previous exception*/
    public UnexpectedConfigurationException (String problemLocation, String reason, Exception e){
        super("Found a problem while reading the section: " + problemLocation+ System.lineSeparator()
              + reason , e);
    }

}
