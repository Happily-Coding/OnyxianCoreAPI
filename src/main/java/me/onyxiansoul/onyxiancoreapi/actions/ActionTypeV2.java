/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.onyxiansoul.onyxiancoreapi.actions;

import java.util.Map;
import java.util.function.BiFunction;
import me.onyxiansoul.onyxiancoreapi.event.EventOfType;
import me.onyxiansoul.onyxiancoreapi.parameters.Placeholder;
import me.onyxiansoul.onyxiancoreapi.parameters.PrePlaceholder;

/**
 *
 * @author Uriel
 */
public interface ActionTypeV2 {
    
    
    /**
     Gets the configuration key which the plugin uses to identify a section as an action of this type.
     */
    public String getActionConfigKey();

    /**
     Gets the function actions of this type run when triggered
     */
    public boolean run(EventOfType eventOfType, Map<String,Placeholder> parameters);
    
    /**
     * Gets the pre-placeholder variables read when creating an action of this type from a config file.
     */
    public PrePlaceholder[] getVariablesRequired();
    

    
}
