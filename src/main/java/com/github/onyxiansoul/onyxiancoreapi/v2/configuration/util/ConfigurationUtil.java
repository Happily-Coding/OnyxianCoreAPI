package com.github.onyxiansoul.onyxiancoreapi.v2.configuration.util;

import com.github.onyxiansoul.onyxiancoreapi.v2.actions.ImpossibleActionException;
import com.github.onyxiansoul.onyxiancoreapi.v2.configuration.ymlobject.YmlObject;
import org.bukkit.configuration.ConfigurationSection;
import org.apache.commons.lang.StringUtils;

/**Class that contains utility methods to aid in the reading of the configuration*/
public final class ConfigurationUtil {
  
    /**Prevent the pointless instatiation of this class*/
    private ConfigurationUtil(){};

  public static String getSectionName(ConfigurationSection configSection) {
    String sectionPath = configSection.getCurrentPath();
    if (sectionPath.equals("")) {
      sectionPath = "MAIN_CONFIG_SECTION";
    }
    return "Configuration Section: {"+sectionPath + "}";
  }

    public static String getActionableType(YmlObject object) throws IllegalArgumentException{
      try{
        return (String) object.getField("action type", "action type").enact(null); //Podria ser remplazable por directo invocar string
      }
      catch(ClassCastException |ImpossibleActionException | IllegalArgumentException | NullPointerException e){
        throw new IllegalArgumentException("Could not find the action type of: "+ object.toString(), e);
      }
    }

  public static boolean isLocalReferenceAttempt(String stringToCheck) {
    String homogeniezedStringToCheck = StringUtils.strip(stringToCheck.toUpperCase());
    if (homogeniezedStringToCheck.startsWith("(LOCAL:") && homogeniezedStringToCheck.endsWith(")")) {
      return true;
    }
    return false;
  }

  public static boolean isCopyAttempt(String stringToCheck) {
    String homogeniezedStringToCheck = StringUtils.strip(stringToCheck.toUpperCase());
    if (homogeniezedStringToCheck.startsWith("(COPY:") && homogeniezedStringToCheck.endsWith(")")) {
      return true;
    }
    return false;
  }
    

    
    /**Tranforms a section into a LinkedHashMultiMap of its values (String, Value)*/
    /*public static LinkedHashMultimap<String,LinkedHashMultimap<String,Object>> transformSectionToMap(ConfigurationSection configSection){
        LinkedHashMultimap<String,LinkedHashMultimap<String,Object>> nameValuesMap = LinkedHashMultimap.create();//Map<ConfigSectionName, configSectionKeyValueMap>
        LinkedHashMultimap<String,Object> multimapEquivalent = LinkedHashMultimap.create(); //Map<key,value>
        nameValuesMap.put(configSection.getName(), multimapEquivalent);
        for(Entry<String,Object> entry: configSection.getValues(false).entrySet()){ //found key x, that is a config section
            String entryKey = entry.getKey();
            Object valueToPut = entry.getValue();
            if(valueToPut instanceof ConfigurationSection){ //Process it if its a configuration section
                ConfigurationSection valueToPutAsSection =(ConfigurationSection) valueToPut;
                LinkedHashMultimap<String,LinkedHashMultimap<String,Object>> valueToPutSectionAsMap = transformSectionToMap(valueToPutAsSection);
                valueToPut = valueToPutSectionAsMap.get(entryKey);
            }
            multimapEquivalent.put(entry.getKey(), valueToPut);
        }
        return nameValuesMap;
    }*/

}
