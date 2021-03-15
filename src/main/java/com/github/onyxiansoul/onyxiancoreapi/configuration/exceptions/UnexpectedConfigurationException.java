package com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions;

import org.bukkit.configuration.ConfigurationSection;

/**An exception thrown when the configuration file contains entry/entries that don't follow the plugin's config formatting and cannot be read by the plugin
 @deprecated : Will be replaced by a factory method accessible by any plugins who want to throw this exception, in order separate and prevent exposing the implementation */
public class UnexpectedConfigurationException extends Exception {
    private static final String EXCEPTION_PREFIX = "Found a problem while reading: ";
    
    /**The usual constructor for generic configuration errors, located inside a section*/
    public UnexpectedConfigurationException (ConfigurationSection problematicSection, String reason){
        super(EXCEPTION_PREFIX+ getSectionName(problematicSection)+ System.lineSeparator()
                + reason );
    }
    
   /**The constructor for generic configuration errors, located in a section, that that are the the result of catching a previous exception*/
   public UnexpectedConfigurationException (ConfigurationSection problematicSection, String reason, Exception exception){
        super(EXCEPTION_PREFIX+ getSectionName(problematicSection)+System.lineSeparator()
              + reason , exception);
    }
    
    /**A constructor for configuration exceptions when the section object is unavailable or inadecuate.*/
    public UnexpectedConfigurationException (String problemLocation, String reason){
        super(EXCEPTION_PREFIX+ problemLocation+ System.lineSeparator()
              + reason);
    }
    
    /**A constructor for configuration exceptions when the section object is unavailable or inadecuate, that are a result of catchign a previous exception*/
    public UnexpectedConfigurationException (String problemLocation, String reason, Exception e){
        super(EXCEPTION_PREFIX + problemLocation+ System.lineSeparator()
              + reason , e);
    }

  private static String getSectionName(ConfigurationSection configSection) {
    String sectionPath = configSection.getCurrentPath();
    if (sectionPath.equals("")) {
      sectionPath = "MAIN_CONFIG_SECTION";
    }
    return "Configuration Section: {"+sectionPath + "}";
  }
    
    
}
