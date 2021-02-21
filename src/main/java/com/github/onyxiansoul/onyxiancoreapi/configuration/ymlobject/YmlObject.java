package com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject;

import com.github.onyxiansoul.onyxiancoreapi.actions.Actionable;
import java.util.List;

public abstract class YmlObject {
  /**Gets the name of the YmlObject, usually the name of the section*/
  public abstract String getName();

  /**Gets the value of a fieldOfInterest, or throws an exception if it is invalid or wasn't found
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param objectType The name of the type of variable (as it was registered in the API)
   * @throws IllegalArgumentException if the fieldOfInterest was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the fieldOfInterest*/
  public abstract <T extends Actionable> T getField(String fieldName, String objectType) throws IllegalArgumentException, NullPointerException;

   /**Gets the value of a fieldOfInterest, using its fieldName as its objectType. Throws an exception if it the value is invalid or wasn't found
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName: The name of the fieldOfInterest.
   * @throws IllegalArgumentException if the fieldOfInterest was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the fieldOfInterest*/
  public abstract <T extends Actionable> T getField(String fieldName) throws IllegalArgumentException, NullPointerException;

  /**Gets a fieldOfInterest or returns a default value if its not available
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param objectType The name of the type of variable (as it was registered in the API)
   * @param defaultValue The default value for the fieldOfInterest
   * @return the value of the fieldOfInterest or the default value if its not listed
   * @throws IllegalArgumentException If the fieldOfInterest was listed, but is invalid*/
  public abstract <T extends Actionable<T1>, T1> T getField(String fieldName, String objectType, T defaultValue) throws IllegalArgumentException;

  /**Gets a fieldOfInteres, using its fieldName as its objectType, or returns a default value if the field is not available
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param defaultValue The default value for the fieldOfInterest
   * @return the value of the fieldOfInterest or the default value if its not listed
   * @throws IllegalArgumentException If the fieldOfInterest was listed, but is invalid*/
  public abstract <T extends Actionable<T1>, T1> T getField(String fieldName, T defaultValue) throws IllegalArgumentException, NullPointerException;

  /**Gets a list inside this YmlObject
  * @param <T> The type of the elements held in the list.
  * @param fieldName The config name of the list. 
  * @param objectType The name of the type of variable inside the list (as it was registered in the API)
  * @return A list of the actionables produced from every value inside the config list, in the order they were on the config list.
  */
  public abstract <T extends Actionable> List<T> getListField(String fieldName, String objectType) throws IllegalArgumentException, NullPointerException;
  
  /**Gets a list inside this YmlObject
  * @param <T> The type of the elements held in the list.
  * @param fieldName The config name of the list. 
  * @param objectType The name of the type of variable inside the list (as it was registered in the API)
  * @return A list of the actionables produced from every value inside the config list, in the order they were on the config list.
  */
  public abstract <T extends Actionable> List<T> getSectionListField(String fieldName, String objectType) throws IllegalArgumentException, NullPointerException;
  
    
}
