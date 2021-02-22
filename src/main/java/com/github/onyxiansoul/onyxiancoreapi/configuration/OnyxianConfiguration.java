package com.github.onyxiansoul.onyxiancoreapi.configuration;

import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.util.LinkedList;
import org.bukkit.configuration.ConfigurationSection;

public interface OnyxianConfiguration {   
  
  	public void setLoseless(String path, Object value, boolean additionsAreCommented, boolean replacementsAreCommentedInsertions, boolean valueShouldBeNameless);
    
    public <T> T getConfigObject(String fieldName, ConfigurationSection containingSection, ConfigurationSection referenceSection, String objectType) throws UnexpectedConfigurationException;
    
    public ConfigurationSection getValidSection(ConfigurationSection parentSection, String key) throws UnexpectedConfigurationException;
    
    public <T> LinkedList<T> getSectionObjects(String fieldName, ConfigurationSection containingSection, ConfigurationSection objectTypeReferenceSection, String objectType) throws UnexpectedConfigurationException;
    
    public <T> LinkedList<T> getListObjects(String fieldName, ConfigurationSection containingSection, ConfigurationSection objectTypeReferenceSection, String objectType) throws UnexpectedConfigurationException;

}
