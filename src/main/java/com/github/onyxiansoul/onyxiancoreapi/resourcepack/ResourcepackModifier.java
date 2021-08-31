package com.github.onyxiansoul.onyxiancoreapi.resourcepack;

/**Responsible for modifiying the resourcepack that is packaged by the onyxiancore.*/
public interface ResourcepackModifier {
  
  /**Modifies the file of an item, so that when an item stack of that type has a certain custom model data number it uses the model of fileToModify
   * @param fileToModify the name (with path) of the file to modify
   * @param customModelDataNumber the custom model data to use inside the predicate
   * @param fileToPointTo the name (with path) of the json file that is going to be used as the model on that custom model data.
   */
  public void addCustomModelToItem(String fileToModify, Integer customModelDataNumber, String fileToPointTo);
  
  /**Modifies the file of the item chosen inside resourcepack config for custom item models
   * @param customModelDataNumber the custom model data to use inside the predicate
   * @param fileToPointTo the name (with path) of the json file that is going to be used as the model on that custom model data.
   */
  public void addCustomModelToConfiguratedItem(Integer customModelDataNumber, String fileToPointTo);
  
}
