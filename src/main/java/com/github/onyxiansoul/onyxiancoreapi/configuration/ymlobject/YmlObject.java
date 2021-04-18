package com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.util.List;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import org.bukkit.configuration.ConfigurationSection;

public abstract class YmlObject implements Nameable{

  /**Gets the value of a fieldOfInterest, or throws an exception if it is invalid or wasn't found
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param objectType The name of the type of variable (as it was registered in the API)
   * @throws IllegalArgumentException if the fieldOfInterest was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the fieldOfInterest*/
  public abstract <T> T getFieldWithType(String fieldName, String objectType) throws IllegalArgumentException, NullPointerException;

  /**Gets the value of a fieldOfInterest, using its fieldName as its objectType. Throws an exception if it the value is invalid or wasn't found
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName: The name of the fieldOfInterest.
   * @throws IllegalArgumentException if the fieldOfInterest was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the fieldOfInterest*/
  public abstract <T> T getField(String fieldName) throws IllegalArgumentException, NullPointerException;
 
  /**Gets a fieldOfInterest or returns a default value if its not available
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param objectType The name of the type of variable (as it was registered in the API)
   * @param defaultValue The default value for the fieldOfInterest
   * @return the value of the fieldOfInterest or the default value if its not listed
   * @throws IllegalArgumentException If the fieldOfInterest was listed, but is invalid*/
  public abstract <T> T getFieldWithTypeOrDefault(String fieldName, String objectType, T defaultValue) throws IllegalArgumentException;

  /**Gets a fieldOfInteres, using its fieldName as its objectType, or returns a default value if the field is not available
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param defaultValue The default value for the fieldOfInterest
   * @return the value of the fieldOfInterest or the default value if its not listed
   * @throws IllegalArgumentException If the fieldOfInterest was listed, but is invalid*/
  public abstract <T> T getFieldOrDefault(String fieldName, T defaultValue) throws IllegalArgumentException, NullPointerException;

  /**Gets a fieldOfInteres, using its fieldName as its objectType, or returns a registered variable, if the field is not available
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName The name of the fieldOfInterest.
   * @param defaultValue The default value for the fieldOfInterest
   * @return the value of the fieldOfInterest or the default value if its not listed
   * @throws IllegalArgumentException If the fieldOfInterest was listed, but is invalid*/
  public abstract <T> T getFieldOrDefaultToVariable(String fieldName, String variableName) throws IllegalArgumentException, NullPointerException;
  
  /**If the object has a field matching fieldName, returns the value of a field of fieldName, otherwise returns Otherwise, returns the actionable used as definition as if it was the field.
   * for example getFieldOrDefinition("color") in any of this two configs would yield red:
   * MyObject:
   *   color: red
   *   stripy: true
   * 
   * MyObject: red
   * 
   * @param <T> The type of the fieldOfInterest.
   * @param fieldName: The name of the fieldOfInterest.
   * @throws IllegalArgumentException if the fieldOfInterest was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the fieldOfInterest*/
  public abstract <T> T getFieldOrDefinition(String fieldName) throws IllegalArgumentException, NullPointerException;
  
  /**Gets a list inside this YmlObject
  * @param <T> The type of the elements held in the list.
  * @param fieldName The config name of the list. 
  * @param objectType The name of the type of variable inside the list (as it was registered in the API)
  * @return A list of the actionables produced from every value inside the config list, in the order they were on the config list.
  */
  public abstract <T> List<T> getListField(String fieldName, String objectType) throws IllegalArgumentException, NullPointerException;
  
  /**Gets a list inside this YmlObject
  * @param <T> The type of the elements held in the list.
  * @param fieldName The config name of the list. 
  * @param objectType The name of the type of variable inside the list (as it was registered in the API)
  * @return A list of the actionables produced from every value inside the config list, in the order they were on the config list.
  */
  public abstract <T> List<T> getSectionListField(String fieldName, String objectType) throws IllegalArgumentException, NullPointerException;
  
  /**Sets the reference section for this object & completes the YmlObject values using its values for default_from & copy fields
   * This is used by the core but its unlikely that you should need it as an external plugin.
   * @param referenceSection The section containing ymlobjects used to produced elements of the same type as the object represented by this YmlObject
   * @throws UnexpectedConfigurationException if there was a problem while using the new reference section to modify the values of the YmlObject.
   */
  public abstract void setReferenceSection(ConfigurationSection referenceSection) throws UnexpectedConfigurationException;
}
