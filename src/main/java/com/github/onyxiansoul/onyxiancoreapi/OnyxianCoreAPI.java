package com.github.onyxiansoul.onyxiancoreapi;

import com.github.onyxiansoul.onyxiancoreapi.actions.Actionable;
import com.github.onyxiansoul.onyxiancoreapi.configuration.ConfigUpdate;
import com.github.onyxiansoul.onyxiancoreapi.configuration.OnyxianConfiguration;
import com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException;


/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {

  /**Load a configuration from a file in the plugin folder, creating that file from the template inside the jar if it doesn't exist.
  * @param fileName The name of the file itself without yml
  * @throws com.github.onyxiansoul.onyxiancoreapi.configuration.exceptions.UnexpectedConfigurationException  if the file couldn't be read.
  */
  public abstract OnyxianConfiguration getConfiguration(String fileName, ConfigUpdate[] configUpdates) throws UnexpectedConfigurationException;
  
  /**Registers an object of an actionable, AKA an element that can run, and can produce a variable, and therefore can be used in the config as both a 'action' & a 'variable')
  * Configurable objects inside Onyxian Plugins, use almost exclusevily producers as variables, this allows for the value of a field to be modifiable by parameters obtained at runtime, such as the value of a placeholder, or the event that triggered an action.
  * @param <T1> The type of variable that will be produced by the actionable. Can be Void if its an action that doesn't produce any variable.
  * @param <T2> Any class implementing actionable.
  * @param referenceName The name that will represent this actionable in the OnyxianCore index.
  * @param actionableToRegister The actionable to register.
  */
  public abstract <T1,T2 extends Actionable<T1>> void registerActionable(String referenceName, T2 actionableToRegister) throws IllegalArgumentException;
  
  /**Assigns a field wrapper to a certain field. Field wrappers provide to transform a direct config value to a  an Actionable providing a usable version of the value.
   *  For example, in a 'biome' field, they could allow the transformation of the name of the biome, written by the user in the config, into the Biome found inside the biome enum.
   *  This allows the definition of values for the biome field such as "biome: Taiga".
   *  Please keep in mind field wrappers NEED to have a constructor taking a single, 'Object' parameter, & they should produce the usable version of the parameter using the enact method.
   * @param referenceName The name that will represent this wrapper in the OnyxianCore index.
   * @param wrapperClass The class of wrapper that will be constructed with the value of the field, in order to wrap it.
   * @param additionalWrapperParameters The additional parameters that will be used in the construction of the wrapper class.
   * @throws IllegalArgumentException If the field is already being wrapped by a class previously registered by a plugin.
   */
  public abstract void registerFieldWrapper(String referenceName, Class<? extends Actionable> wrapperClass, Object... additionalWrapperParameters)  throws IllegalArgumentException;
  
  //public abstract void registerInterpreter(Class<? extends DataInterpreter> eventDataObtainer, Class interpretedClass) throws IllegalArgumentException;
  
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
