package com.github.onyxiansoul.onyxiancoreapi.configuration.util;

import com.github.onyxiansoul.onyxiancoreapi.actions.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.actions.ImpossibleActionException;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject.YmlObject;
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
      Actionable<String> field = object.getField("action type", "action type");
      return field.enact(null);
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

}
