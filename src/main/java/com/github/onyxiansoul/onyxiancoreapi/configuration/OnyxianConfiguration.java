package com.github.onyxiansoul.onyxiancoreapi.configuration;

import com.github.onyxiansoul.onyxiancoreapi.actions.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;
import java.util.LinkedList;
import org.bukkit.configuration.ConfigurationSection;

public interface OnyxianConfiguration {   
  
  	public void setLoseless(String path, Object value, boolean additionsAreCommented, boolean replacementsAreCommentedInsertions, boolean valueShouldBeNameless);
    
    public abstract <T> T getConfigObject(String fieldName, ConfigurationSection containingSection, ConfigurationSection referenceSection, String objectType) throws UnexpectedConfigurationException;
    
    public <T> LinkedList<T> getSectionObjects(String fieldName, ConfigurationSection containingSection, ConfigurationSection objectTypeReferenceSection, String objectType) throws UnexpectedConfigurationException;
    
    public <T> LinkedList<T> getListObjects(String fieldName, ConfigurationSection containingSection, ConfigurationSection objectTypeReferenceSection, String objectType) throws UnexpectedConfigurationException;

    //TODO: Hay cosas que no tienen sentido que sean actionables pero si legibles de la configuración. Reworkear para que se pueda? Se deberian construir igual simplemente es tener o no el actionable me da la impresión.
    //CROSS THAT BRIDGE WHEN YOU COME TO IT I GUESS PERO LAS RELACIONES SON UN CLARO EJEMPLO Y DEBE HABER OTRO. EJ BLOQUES?
    //Definitivamente hacer que haya metodos que no devuelvan actionable. dejar los que devuelven actionable para las variables internas yu sar los otros para los objectos que las usan.
    
    //INDIVIDUALS-------------------------------------------------------------------------------------
    
    /**Gets a configurable (aka any object type registered in the util) defined in a map that is part of list of objects
     * @param <T> The type of the configurable
     * @param configurableType The class of the configurable type.
     * @param objectEntry The map obtained from the list. It consists of <Name, MapOfFieldValues>.
     * @param listName The name of the list, so it can be displayed in case of any errors.
     * @param cousinSection An additional section, that contains objects of the same type, from which the entry can obtain some of it's values.
     * @return The configurable created from the entry.
     * @throws com.github.onyxiansoul.damagepotioneffects.configuration.base.exceptions.UnexpectedConfigurationException If the object field values couldn't be properly read.
     */
    //public abstract <T> T getConfigurableFromListedMap(Class<T> configurableType, Map<String,Object> objectEntry, String listName, ConfigurationSection cousinSection) throws UnexpectedConfigurationException;
      
    //INDIVIDUALS-------------------------------------------------------------------------------------
    
    
    //LISTS-------------------------------------------------------------------------------------------
    
    /**Read all the configurables (aka any object type registered in the util) from a list.
     * @param <T> The type of the configurable
     * @param configurableType The class of the configurable type.
     * @param listedObjects The list of objects that should be configurables or references to one.
     * @param listName The name of the list, in order to use it on all debug messages
     * @param cousinSection An additional section, that contains objects of the same configurable type.
     * @return The list of all configurables that were defined or referenced inside the list of objects.
     * @throws com.github.onyxiansoul.damagepotioneffects.configuration.base.exceptions.UnexpectedConfigurationException If an object inside the list is not a valid reference
     * @throws com.github.onyxiansoul.damagepotioneffects.configuration.base.exceptions.UnlocatedConfigurationException If an objet inside the list can't be created
     */
    //public abstract <T> List<T> getConfigurablesFromList(Class<T> configurableType, ConfigurationSection containingSection, String listName, ConfigurationSection cousinSection) throws UnexpectedConfigurationException;
    
    /**Read all the configurables (aka any object type registered in the util) from a section
     * @param <T> The type of the configurable
     * @param configurableType The class of the configurable type.
     * @param configurablesSection The section that contains all the objects that should be configurables or references to one.
     * @param cousinSection An additional section, that contains objects of the same configurable type.
     * @return The list of all configurables that were defined or referenced inside the list of objects.
     * @throws com.github.onyxiansoul.damagepotioneffects.configuration.base.exceptions.UnexpectedConfigurationException If an object inside the section is not a valid object/reference
     * @throws com.github.onyxiansoul.damagepotioneffects.configuration.base.exceptions.UnlocatedConfigurationException If an objet inside the section can't be created
     */
    //public abstract <T> List<T> getConfigurablesFromSection(Class<T> configurableType, ConfigurationSection configurablesSection, ConfigurationSection cousinSection) throws UnexpectedConfigurationException;
    
    //LISTS-------------------------------------------------------------------------------------------

    //RELATIONS---------------------------------------------------------------------------------------
    /**Get all the configurable elements of one type, that are related to each configurable element of a second type, for example, all potion effects that should trigger on a certain type of damage
     * @param <K> The key element type. ie: a certain fenomena
     * @param <V> The value element type. ie: everything that should happen because of that fenomena.
     * @param relationsSection The section that lists all relationships (as configuration sections) ie: EFFECTS_PER_FENOMENA
     * @param keyType The class of the key element. Used to know how to read it.
     * @param keyName The config name of the key element. Used to know where to read it from.
     * @param kSection A reference section where elements of key type may already be defined.
     * @param valueType The class of the value element. Used to know how to read it.
     * @param vSection A reference section where elements of value type may already be defined.
     * @param valueName The config name of the key element. Used to know what subsection to read it from.
     * @return A Map of <KeyElement, LIST of all valueElements related to it, in the order they appeared on the config>. May be empty, if there are problems reading it.
     */
    //public abstract @NotNull <K,V> LinkedListMultimap<K,V> getRelationMap(ConfigurationSection relationsSection, Class<K> keyType, String keyName, ConfigurationSection kSection, Class<V> valueType, ConfigurationSection vSection,  String valueName) throws UnexpectedConfigurationException;
    
    //RELATIONS---------------------------------------------------------------------------------------
    
    //VALID-------------------------------------------------------------------------------------------
    //public abstract ConfigurationSection getValidSection(ConfigurationSection parentSection, String key) throws UnexpectedConfigurationException;
    
    //VALID-------------------------------------------------------------------------------------------



}
