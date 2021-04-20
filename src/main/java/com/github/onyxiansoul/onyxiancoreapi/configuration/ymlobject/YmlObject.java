package com.github.onyxiansoul.onyxiancoreapi.configuration.ymlobject;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.util.List;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import org.bukkit.configuration.ConfigurationSection;

public abstract class YmlObject implements Nameable{

  /**Gets the value of a field of objectType(that has been registered on the API) or throws an exception if it is invalid or wasn't found
   * @param <T> The type of the field.
   * @param fieldName The name of the field.
   * @param objectType The name of the type of variable to use to interpret this field (as it was registered in the API)
   * @param referenceSection
   * @throws IllegalArgumentException if the field was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the field
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException*/
  public abstract <T> T getFieldOfRType(String fieldName, String objectType, ConfigurationSection referenceSection) throws IllegalArgumentException, NullPointerException, UnexpectedConfigurationException;
  
  /**Gets the value of a field of objectType(that has been registered on the API) or returns a default value if its not available
   * @param <T> The type of the field.
   * @param fieldName The name of the field.
   * @param objectType The name of the type of variable (as it was registered in the API)
   * @param referenceSection
   * @param defaultValue The default value for the field
   * @return the value of the field or the default value if its not listed
   * @throws IllegalArgumentException If the field was listed, but is invalid
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException*/
  public abstract <T> T getFieldOfRTypeOrDefault(String fieldName, String objectType, ConfigurationSection referenceSection, T defaultValue) throws IllegalArgumentException, UnexpectedConfigurationException;

  /**Gets the value of a field of objectType, or returns the value of a registered variable, if the field is not available
   * @param <T> The type of the field.
   * @param fieldName The name of the field.
   * @param objectType The name of the type of variable to use to interpret this field (as it was registered in the API)
   * @param referenceSection
   * @param variableName The name the variable was registered by.
   * @return the value of the field or the default value if its not listed
   * @throws IllegalArgumentException If the field was listed, but is invalid
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException*/
  public abstract <T> T getFieldOfRTypeOrDefaultToVariable(String fieldName, String objectType, ConfigurationSection referenceSection, String variableName) throws IllegalArgumentException, UnexpectedConfigurationException;
  
  /** * Gets the value of a field, using its fieldName as its objectType.Throws an exception if it the value is invalid or wasn't found
   * @param <T> The type of the field.
   * @param fieldName: The name of the field.
   * @param referenceSection
   * @throws IllegalArgumentException if the field was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the field
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException*/
  public abstract <T> T getRField(String fieldName, ConfigurationSection referenceSection) throws IllegalArgumentException, NullPointerException, UnexpectedConfigurationException;

  /**Gets the value of a field, using its fieldName as its objectType, or returns a default value if the field is not available
   * @param <T> The type of the field.
   * @param fieldName The name of the field.
   * @param defaultValue The default value for the field
   * @param referenceSection
   * @return the value of the field or the default value if its not listed
   * @throws IllegalArgumentException If the field was listed, but is invalid
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException*/
  public abstract <T> T getRFieldOrDefault(String fieldName, T defaultValue, ConfigurationSection referenceSection) throws IllegalArgumentException, UnexpectedConfigurationException;

  /**Gets the value of a field, using its fieldName as its objectType, or returns the value of a registered variable, if the field is not available
   * @param <T> The type of the field.
   * @param fieldName The name of the field.
   * @param variableName The name the variable was registered by.
   * @param referenceSection
   * @return the value of the field or the default value if its not listed
   * @throws IllegalArgumentException If the field was listed, but is invalid
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException*/
  public abstract <T> T getRFieldOrDefaultToVariable(String fieldName, String variableName, ConfigurationSection referenceSection) throws IllegalArgumentException, UnexpectedConfigurationException;
  
  /**Gets a sub YmlObject inside of this one
   * @param <T> The type of the field
   * @param fieldName The key of the field
   * @param referenceSection
   * @return The YmlObject located inside of this one.
  */
  public abstract <T> T getYmlObject(String fieldName, ConfigurationSection referenceSection) throws IllegalArgumentException, NullPointerException, UnexpectedConfigurationException;
  
  /**Gets a list inside this YmlObject
  * @param <T> The type of the elements held in the list.
  * @param fieldName The config name of the list. 
  * @param objectTypeReferenceSection 
  * @param objectType The name of the type of variable inside the list (as it was registered in the API)
  * @return A list of the actionables produced from every value inside the config list, in the order they were on the config list.
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException
  */
  public abstract <T> List<T> getListObjects(String fieldName, ConfigurationSection objectTypeReferenceSection, String objectType) throws IllegalArgumentException, NullPointerException, UnexpectedConfigurationException;
  
  /**Gets a list inside this YmlObject
  * @param <T> The type of the elements held in the list.
  * @param fieldName The config name of the list. 
  * @param objectType The name of the type of variable inside the list (as it was registered in the API)
  * @return A list of the actionables produced from every value inside the config list, in the order they were on the config list.
  */
  public abstract <T> List<T> getSectionObjects(String fieldName, ConfigurationSection objectTypeReferenceSection, String objectType) throws IllegalArgumentException, NullPointerException, UnexpectedConfigurationException;
}

  /**Returns the value of a yml object's field using its fieldName as its objectType. If it doesn't exist, returns the definition of the yml object.
   * for example getFieldOrDefinition("color") in any of this two configs would yield red:
   * MyObject:
   *   color: red
   *   stripy: true
   * 
   * MyObject: red
   * 
   * @param <T> The type of the field.
   * @param fieldName: The name of the field.
   * @throws IllegalArgumentException if the field was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the field*/
  //public abstract <T> T getRFieldOrDefinition(String fieldName) throws IllegalArgumentException, NullPointerException,  UnexpectedConfigurationException;


  /** * Returns the value of a yml object's field of objectType.If it doesn't exist, returns the definition of the yml object. for example getFieldOrDefinition("color") in any of this two configs would yield red:
 MyObject:
   color: red
   stripy: true
 
 MyObject: red
   * 
   * @param <T> The type of the field.
   * @param fieldName The name of the field.
   * @param objectType The name of the type of variable to use to interpret this field
   * @throws IllegalArgumentException if the field was listed, but is invalid
   * @throws NullPointerException if the field isn't listed.
   * @return the value of the field*/
  //public abstract <T> T getFieldOfRTypeOrDefinition(String fieldName, String objectType) throws IllegalArgumentException;