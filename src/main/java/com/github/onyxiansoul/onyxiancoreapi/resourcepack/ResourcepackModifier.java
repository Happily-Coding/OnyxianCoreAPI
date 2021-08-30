package com.github.onyxiansoul.onyxiancoreapi.resourcepack;

import java.util.Map;

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
  
  /**Creates a json file with a certain name, that extends a parent model, and assigns values to some textures
   * @param modelName the name of the file (without path)
   * @param parent the path + name of the file to use as parent
   * @param textureOverrides The map containing the name of every overwritten texture and it's value*/
  public void createItemModel(String modelName, String parent, Map<String,String> textureOverrides);
  
}
