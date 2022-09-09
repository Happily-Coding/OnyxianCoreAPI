package com.github.onyxiansoul.onyxiancoreapi.structured_value_system;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**A key, value pair, which can have a simple value, or a list of key value pairs, which can be queried.
 * It's similar to a virtual representation of a json node.
 */
public interface StructuredValue{
  
  /**Gets the key that holds the value
   * @return the key*/
  public abstract @NotNull String getKey();
  
  /**Checks if this is the final value of a tree, meaning, it has no inner values*/
  public abstract @NotNull boolean lacksInnerStructuredValues();
   
  /**Gets the value of this value if it doens't have any inner structured values (aka key value pairs) inside.
   * @return the value assigned to this value's key, which can be null if it was configured that way
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException if this value has inner values
   * to verify that this structured valeu has no inner structured value pairs you can use @link lacksInnerStructuredValues
   */
  public abstract @NotNull Object getInnerNonStructuredValue() throws UnexpectedConfigurationException;
  
  /**Gets a copy of the list of inner values this value holds.
   * for example, in this configuration it'd give the value of key 'value1' and the one of key 'value 2'
   * key:
   *   value1: value
   *   value2:
   *     subvalue: 2
   *     subvalue: 3
   * returns an empty list if its a final value.
   */
  public abstract @NotNull List<StructuredValue> getInnerValuesCopy();
  
  /** Checks if this value has an inner value of a certain name.
   * @param name the key of the inner value
   * @return true if it has an inner value
   */
  public abstract @NotNull boolean hasInnerValueOfName(String name);
  
  /**Gets an inner value of a certain name,
   * @param name the key that the inner value has
   * @return the requested inner value
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException if that value doesn't exist.
   */
  public abstract @NotNull StructuredValue getInnerValue(String name) throws UnexpectedConfigurationException;
  
  /**Gets the xth inner value present in this value.
   * @param valueNumber the number of inner value to retrieve (must be < to the number of inner values present)
   * @return the requested inner value
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException
   */
  public abstract @NotNull StructuredValue getInnerValue(int valueNumber) throws UnexpectedConfigurationException;
  
  /**Checks if this value has a single value, be it a value, or an object
   * @return true if it has a single value, be it an inner field or a final value*/
  public abstract @NotNull boolean hasSingleValue();
  
  /**Gets the only value present inside this value
   * @return the only value this object has.
   * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException If it has no, or multiple values
   */
  public abstract @NotNull StructuredValue getOnlyInnerValue() throws UnexpectedConfigurationException;

  /**Checks if this object was originated from another value*/
  public abstract @NotNull boolean hasParent();
  
  /**Gets the value that originated this one.*/
  public abstract @Nullable StructuredValue getParent();
  
  /** Gets the full node path to this value (basically a concatenation of the keys of all parents up to this point (included)) */
  public abstract @NotNull String getPath();
  
  /**Get this object, as a relatively simple string
   * @return a simplified version of this object as string*/
  public abstract @NotNull String toSimplifiedString();
  
  /**Moves this object to a certain position inside another parent
   * @param newParent The parent that will now hold this structured value
   * @param positionInsideParent The number of field this structured value will be inside the parent. if there were any fields at or after that position, they will be moved to the right, like in a list.
   */
  public abstract void relocate(StructuredValue newParent, @NotNull int positionInsideParent);

  /**Moves this object to the first free position inside another parent
   * @param newParent The parent that will now hold this structured value
   */
  public abstract void relocate (StructuredValue newParent);

  /** Adds as an inner value at the specified position of this Structured value.
   * @param valueToAdd the structured value to add as an inner value
   * @param position The number of field valueToAdd will become inside this structured value.
   * 
   * For example if you called addInnerValue(valueToAdd,0), and
   * This structured value was 
   * Human:
   *   Name: Onyxtite
   * 
   * and valueToAdd was:
   *   nickname: the awesome
   * 
   * This structured value would become
   * Human:
   *   nickname: the awesome
   *   Name: Onyxtite
   */
  public abstract void addInnerValue(@NotNull StructuredValue valueToAdd, @NotNull int position);

  /**
   * Adds as an inner value at the first free position of this Structured value.
   * @param valueToAdd the structured value to add as an inner value
   * For example if this structured value was 
   * Human:
   *   Name: Onyxtite
   * and valueToAdd was:
   *   nickname: the awesome
   * 
   * This structured value would become
   * Human:
   *   Name: Onyxtite
   *   nickname: the awesome
   */
  public abstract void addInnerValue(@NotNull StructuredValue valueToAdd);
  
  /** Replaces the value inner value that has valueToReplace's key for valueToReplace
   * @param valueToReplace the replacement value that will be put at valueToReplace's key
   */
  public abstract void replaceInnerValue(StructuredValue valueToReplace, StructuredValue replacement);

  public abstract void removeInnerValue(int position);
  
  public abstract void replaceInnerNonStructuredValue(Object newValue);
  
}