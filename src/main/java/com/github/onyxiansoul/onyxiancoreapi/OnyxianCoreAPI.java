package com.github.onyxiansoul.onyxiancoreapi;

import javax.validation.constraints.NotNull;
import com.github.onyxiansoul.onyxiancoreapi.actions.FunctionToRun;
import com.github.onyxiansoul.onyxiancoreapi.parameters.FunctionToGetValue;
import com.github.onyxiansoul.onyxiancoreapi.parameters.SignalLocation;
import java.util.Map;
import org.jetbrains.annotations.Nullable;


/**The OnyxianCoreAPI. Developers can access it to get info or expand the functionality of every OnyxianPlugin on the server.*/
public interface OnyxianCoreAPI {
    
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
    public void RegisterPlaceholderType( @NotNull Class representedClass, @Nullable Class collectionObjectType, @NotNull String stringSignal, @NotNull SignalLocation signalType, @NotNull FunctionToGetValue functionToGetValue);
    
    /**Register a new ConfigParameter, which can be used inside any actionType, read off the config of all OnyxianSoul plugins.
     * @param configKey = the config key which will contain the placeholder from which to obtain the value on runtime. ie: "Player:"
     * @param expectedClass = the type of object that's expected to be represented by the placeholder. ie: "Player.class"
     * @param defaultPlaceholderString = the default string from which to extract the placeholder, if the config key is missing or has a placeholder of an unexpected type. ie: "(event.player)"
     */
    public void RegisterConfigParameter(@NotNull String configKey, @Nullable String defaultPlaceholderString, @NotNull Class expectedClass);
    
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
    
    public void RunAction(String actionName, Map<String, Object> usableParameters) throws ImpossibleActionException;
}
