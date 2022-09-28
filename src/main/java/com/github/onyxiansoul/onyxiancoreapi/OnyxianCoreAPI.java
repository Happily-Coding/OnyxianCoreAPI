package com.github.onyxiansoul.onyxiancoreapi;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.ActionableIndexAccessPoint;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.ActionableTypeIndexAccessPoint;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.RuntimeCircumstancesFactory;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.interpreted_element_system.InterpretedElementFactory;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.runtime_circumstances_system.interpreted_element_system.InterpretedElementTypeIndexAccessPoint;
import com.github.onyxiansoul.onyxiancoreapi.files.FileFactory;
import com.github.onyxiansoul.onyxiancoreapi.files.yaml.YmlFactory;
import com.github.onyxiansoul.onyxiancoreapi.resourcepack.ResourcepackModifier;
import com.github.onyxiansoul.onyxiancoreapi.resourcepack.ResourcepackPackager;
import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.StructuredValueFactory;
import com.github.onyxiansoul.onyxiancoreapi.structured_value_system.variable_source_system.VariableSourceFactory;
import org.jetbrains.annotations.NotNull;

/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {
  /**Gets a factory capable of unpacking files from the plugin jar, getting them from the plugin folder and creating file objects */
  public abstract @NotNull FileFactory getFileFactory();
  
  /** Gets a factory capable of making YamlConfiguration objects from existing configurations*/
  public abstract @NotNull YmlFactory getYmlFactory ();
  
  /**Gets a factory capable of making structured values, be it from configuration files, or key value pairs */
  public abstract @NotNull StructuredValueFactory getStructuredValueFactory();
  
  /**Gets a factory capable of creating variable sources to wrap and interpret structured values*/
  public abstract @NotNull VariableSourceFactory getVariableSourceFactory();

  /**Gets a factory capable of creating interpreted elements to wrap and interpret events*/
  public abstract @NotNull InterpretedElementFactory getInterpretedElementFactory();
  
  /** Gets an access point to the actionable index, for registering or getting registered actionables which can be used by any plugin using the OnyxianCore*/
  public abstract @NotNull ActionableIndexAccessPoint getActionableIndexAccessPoint();
  
  /** Gets an access point to the actionable type index, for registering actionable types, which can be used to create actionables (via variablesources) by any plugin using the OnyxianCore */
  public abstract @NotNull ActionableTypeIndexAccessPoint getActionableTypeIndexAccessPoint();
  
  /** Gets an access point to the interpreted element type index, for registering interpreted element types, which can be used to create interpreted elements of events by any plugin using the OnyxianCore */
  public abstract @NotNull InterpretedElementTypeIndexAccessPoint getInterpretedElementTypeIndexAccessPoint();
  
  /** Gets a factory capable of creating runtime circumstances from events, which can be used to activate actions*/
  public abstract @NotNull RuntimeCircumstancesFactory getRuntimeCircumstancesFactory();
  
  /**Gets an object capable of modifiying the files of the resourcepack used by the onyxian core*/
  public abstract ResourcepackModifier getResourcepackModifier();
  
  /** Gets an object capable of re-packaging the resourcepack used by the onyxian core*/
  public abstract ResourcepackPackager getResourcepackPackager();
  
}