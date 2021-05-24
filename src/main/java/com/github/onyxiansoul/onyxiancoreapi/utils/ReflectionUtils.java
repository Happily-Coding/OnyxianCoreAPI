package com.github.onyxiansoul.onyxiancoreapi.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import org.apache.commons.lang.reflect.ConstructorUtils;

public class ReflectionUtils {

  /**Create an object of a certain class, automatically finding the right constructor.
   * @param <T> The type of the object.
   * @param objectClass The class that holds the constructor.
   * @param constructionArguments The parameters for the construction. CANNOT contain nulls.
   * @return The created object
   */
  public static <T> T create(Class objectClass, Object... constructionArguments) throws IllegalArgumentException{
    try {
      ConstructorUtils.invokeConstructor(objectClass, constructionArguments);
      return (T) ConstructorUtils.invokeConstructor(objectClass, constructionArguments);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
      throw new IllegalArgumentException("Could not instantiate a "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ Arrays.toString(constructionArguments),e);
    } catch(NullPointerException e){
      throw new IllegalArgumentException("Caught a null pointer while trying to create a " + objectClass.getSimpleName() + " Utilizing the arguments: "+ Arrays.toString(constructionArguments)+ " This is likely the result of passing a null parameter to the create method! That is not allowed!!!");
    } catch (ClassCastException e){
      throw new IllegalArgumentException("Created a  "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ Arrays.toString(constructionArguments) + "But it could not be cast to the required class", e);
    }
  }
  
    public static <T> T create(Class objectClass, LinkedList<?> constructionArguments) throws IllegalArgumentException{
    try {
      return (T) ConstructorUtils.invokeConstructor(objectClass, constructionArguments.toArray());
    } catch(InvocationTargetException e){
      throw new IllegalArgumentException("Could not instantiate a "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ constructionArguments, e.getCause());
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new IllegalArgumentException("Could not instantiate a "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ constructionArguments + ". This may be a programming error, please report it.", e);
    } catch(NullPointerException e){
      throw new IllegalArgumentException("Caught a null pointer while trying to create a " + objectClass.getSimpleName() + " Utilizing the arguments: "+ constructionArguments+ " This is likely the result of passing a null parameter to the create method! That is not allowed!!!");
    } catch (ClassCastException e){
      throw new IllegalArgumentException("Created a  "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ constructionArguments + "But it could not be cast to the required class", e);
    }
  }
  
}
