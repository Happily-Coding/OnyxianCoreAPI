package com.github.onyxiansoul.onyxiancoreapi.configuration;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.util.LinkedList;
import org.bukkit.configuration.ConfigurationSection;

public interface OnyxianConfiguration {   
  
  /**
   *
   * @param path
   * @param value
   * @param additionsAreCommented
   * @param replacementsAreCommentedInsertions
   * @param valueShouldBeNameless
   * @throws UnexpectedConfigurationException
   */
  public void setLoseless(String path, Object value, boolean additionsAreCommented, boolean replacementsAreCommentedInsertions, boolean valueShouldBeNameless) throws UnexpectedConfigurationException;
    
  /**
   *
   * @param <T>
   * @param fieldName
   * @param containingSection
   * @param referenceSection
   * @param objectType
   * @return
   * @throws UnexpectedConfigurationException
   */
  public <T> T getConfigObject(String fieldName, ConfigurationSection containingSection, ConfigurationSection referenceSection, String objectType) throws UnexpectedConfigurationException;
    
  /**
   *
   * @param parentSection
   * @param key
   * @return
   * @throws UnexpectedConfigurationException
   */
  public ConfigurationSection getValidSection(ConfigurationSection parentSection, String key) throws UnexpectedConfigurationException;
    
  /**
   *
   * @param <T>
   * @param fieldName
   * @param containingSection
   * @param objectTypeReferenceSection
   * @param objectType
   * @return
   * @throws UnexpectedConfigurationException
   */
  public <T> LinkedList<T> getSectionObjects(String fieldName, ConfigurationSection containingSection, ConfigurationSection objectTypeReferenceSection, String objectType) throws UnexpectedConfigurationException;
    
  /**
   *
   * @param <T>
   * @param fieldName
   * @param containingSection
   * @param objectTypeReferenceSection
   * @param objectType
   * @return
   * @throws UnexpectedConfigurationException
   */
  public <T> LinkedList<T> getListObjects(String fieldName, ConfigurationSection containingSection, ConfigurationSection objectTypeReferenceSection, String objectType) throws UnexpectedConfigurationException;

}
//TODO: COMPLETE JAVADOC