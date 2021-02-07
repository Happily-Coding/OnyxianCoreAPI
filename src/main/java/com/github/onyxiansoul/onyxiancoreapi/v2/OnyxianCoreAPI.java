package com.github.onyxiansoul.onyxiancoreapi.v2;

import com.github.onyxiansoul.onyxiancoreapi.event.EventDataObtainer;
import com.github.onyxiansoul.onyxiancoreapi.v2.actions.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.v2.configuration.OnyxianConfiguration;
import com.github.onyxiansoul.onyxiancoreapi.v2.configuration.exceptions.UnexpectedConfigurationException;
import org.bukkit.event.Event;


/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {

  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * @param fileName The name of the file itself without yml
  * @throws com.github.onyxiansoul.damagepotioneffects.configuration.base.exceptions.UnlocatedConfigurationException if the file couldn't be read.*/
  public abstract OnyxianConfiguration getConfiguration(String fileName) throws UnexpectedConfigurationException;
  
  //Registers an object of an actionable that is a producer (aka any action that produces a variable, and therefore can be used in the config as both a 'action' & a 'variable')
  public abstract void registerProducer(Actionable<?> actionableToRegister, String referenceName) throws IllegalArgumentException;
  
  /**Registers a producer that is constructable with values from the configuration, allowing the configuration to change it's settings (& of course, has a constructor which take YmlObject as its only parameter)*/
  public abstract void registerConfigurableProducer(Class<Actionable<?>> actionableClass, String referenceName) throws IllegalArgumentException;
  
  /*Registers an actionable that doesn't return anything, aka is only usable as an action**/
  public abstract void registerAction(Actionable<Void> actionableToRegister, String referenceName) throws IllegalArgumentException;
  
  /*Registers an actionable that doesn't return anything, aka is only usable as an action & that is constructable with values from the configuration, allowing the configuration to change it's settings(& of course, has a constructor which take YmlObject as its only parameter)**/
  public abstract void registerConfigurableAction(Class<Actionable<Void>> actionableClass, String referenceName);
  
  /**Assigns a field wrapper to a certain field. Field wrappers provide to transform a direct config value to a  an Actionable providing a usable version of the value.
   *  For example, in a 'biome' field, they could allow the transformation of the name of the biome, written by the user in the config, into the Biome found inside the biome enum.
   *  This allows the definition of values for the biome field such as "biome: Taiga".
   *  Please keep in mind field wrappers NEED to have a constructor taking a single, 'Object' parameter, & they should produce the usable version of the parameter using the enact method.
   */
  public abstract void registerFieldWrapper(Class<? extends Actionable<?>> type, String string, Object... additionalFieldWrapperParameters)  throws IllegalArgumentException;

  public abstract void registerEventDataObtainer(Class<? extends EventDataObtainer> eventDataObtainer, Class<? extends Event> eventItObtainsFrom) throws IllegalArgumentException;
  
    /**Register a new PlaceholderType, which can be used inside the config of all OnyxianSoul plugins.
    * all values between braces inside the config are considered placeholders. 
    * @param representedClass = the class of the value which will be obtainable from this placeholder. ie: Color.class;
    * @param collectionObjectType = the expected class of the object inside the collection. Should be null, unless the representedClass is a colllection.
    * @param stringSignal = The string that signals that a placeholder (aka a string inside braces) is of this type. ie: "Color:" . That example signal would make (Color:Red) a placeholder of this type.
    * @param signalType = The location of the signal inside of a placeholder. 
    *   START would mean that the first text after the start brace needs to be color to be detected as this placeholder, ie: (Color:Red);
    *   END would mean that the text to the left of the end brace needs to be color to be detected as this placeholder, ie: (redColor:);
    * @param functionToGetValue = The code that will be executed to get the value of a placeholder. for example:
    * new FunctionToGetValue(){
            @Override
            public boolean run(String cleansedPlaceholderString, EventOfType eventOfType) {
                return Color.valueOf(cleansedPlaceholderString);
            }
        };
    */  
    //public void RegisterPlaceholderType( @NotNull Class representedClass, @Nullable Class collectionObjectType, @NotNull String stringSignal, @NotNull SignalLocation signalType, @NotNull FunctionToGetValue functionToGetValue);
    
    /**Register a new ConfigParameter, which can be used inside any actionType, read off the config of all OnyxianSoul plugins.
     * @param configKey = the config key which will contain the placeholder from which to obtain the value on runtime. ie: "Player:"
     * @param expectedClass = the type of object that's expected to be represented by the placeholder. ie: "Player.class"
     * @param defaultPlaceholderString = the default string from which to extract the placeholder, if the config key is missing or has a placeholder of an unexpected type. ie: "(event.player)"
     */
    //public void RegisterConfigParameter(@NotNull String configKey, @Nullable String defaultPlaceholderString, @NotNull Class expectedClass);
    
    /**Register a new ActionType, which can be used inside the results sections of the config of all OnyxianSoul plugins, to generate an action when combined with the parameters specified on the config.
     * @param configSignal = the string that tells the plugin the action to be created is of this type. ie: "SendMessage"
     * @param actionTypeExecution = what to do when the action is triggered, ie:
     *  new FunctionToRun(){
            @Override
            public void run(Map<String, Object> parameterValues) {
                Conversable target =(Conversable) parameterValues.get("Target");
                String message  = (String) parameterValues.get("Message");
                target.sendRawMessage(message);
            }
        }
    * @param parametersConfigKey = the config key of every single parameter that should be read from the config, and therefore be available on parameterValues on the run method. Keep in mind that it needs to be a registeredParameter in the OnyxianCore.
    *  
     */
    //public void RegisterActionType(@NotNull String configSignal, @NotNull FunctionToRun actionTypeExecution, String... parametersConfigKey);
    
    //public void RunAction(String actionName, Map<String, Object> usableParameters) throws ImpossibleActionException;
    
    //public void obtainInfo();
}
