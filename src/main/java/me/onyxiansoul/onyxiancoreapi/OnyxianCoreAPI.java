package me.onyxiansoul.onyxiancoreapi;

import com.sun.istack.internal.NotNull;
import me.onyxiansoul.onyxiancoreapi.actions.FunctionToRun;
import me.onyxiansoul.onyxiancoreapi.parameters.FunctionToGetValue;
import me.onyxiansoul.onyxiancoreapi.parameters.SignalType;


public interface OnyxianCoreAPI {
    
    public String getTestString();
    
    public String prefixMessage(String messageToPrefix, int prefixIndex);
    
    public Prefix createPrefix(String message);
    
    public void registerPrefix(Prefix prefix);
    
    //-------------Real API-----------------
    
    /**Register a new PlaceholderType, which can be used inside the config of all OnyxianSoul plugins.
    * all values between braces inside the config are considered placeholders. 
    * @param representedClass = the class of the value which will be obtainable from this placeholder. ie: Color.class;
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
    public void RegisterPlaceholderType( @NotNull Class representedClass, @NotNull String stringSignal, @NotNull SignalType signalType, @NotNull FunctionToGetValue functionToGetValue);
    
    /**Register a new Parameter, which can be used inside any actionType, read off the config of all OnyxianSoul plugins.
     * @param configKey = the config key which will contain the placeholder from which to obtain the value on runtime. ie: "Player:"
     * @param expectedClass = the type of object that's expected to be represented by the placeholder. ie: "Player.class"
     * @param defaultPlaceholderString = the default string from which to extract the placeholder, if the config key is missing or has a placeholder of an unexpected type. ie: "(event.player)"
     */
    public void RegisterParameter(@NotNull String configKey, @NotNull Class expectedClass, String defaultPlaceholderString);
    
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
    public void RegisterActionType(@NotNull String configSignal, @NotNull FunctionToRun actionTypeExecution, String... parametersConfigKey);
    
    
    
}
