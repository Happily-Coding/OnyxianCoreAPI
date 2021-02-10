package com.github.onyxiansoul.onyxiancoreapi.v2.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import org.apache.commons.lang.reflect.ConstructorUtils;

public class ReflectionUtils {

  public static <T> T create(Class objectClass, Object... constructionArguments) throws IllegalArgumentException{
    try {
      System.out.println("object class:"+ objectClass + "Construction Arguments:"+ constructionArguments);
      ConstructorUtils.invokeConstructor(objectClass, constructionArguments);
      return (T) ConstructorUtils.invokeConstructor(objectClass, constructionArguments);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
      throw new IllegalArgumentException("Could not instantiate a "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ Arrays.toString(constructionArguments),e);
    } catch (ClassCastException e){
      throw new IllegalArgumentException("Created a  "+ objectClass.getSimpleName() + " Utilizing the arguments: "+ Arrays.toString(constructionArguments) + "But it could not be cast to the required class", e);
    }
  }
}
