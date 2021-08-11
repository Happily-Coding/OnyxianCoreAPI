package com.github.onyxiansoul.onyxiancoreapi.actionable_system;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.actions.ActionGroup;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import java.io.Serializable;
import java.util.Map;

/**A collection of ActionGroups that want to react to different triggers (usually events)*/
public interface Reactions extends Actionable<Void>, Serializable, Nameable {
  
  /**Adds an ActionGorup to the collection*/
  public void addActionGroup(ActionGroup actionGroup);
  
  /**Check if the reactions for a reactant(usually event)*/
  public boolean areReactiveTo(Class trigger);
  
  /**Gets the reactions as a map class, action group*/
  public Map<Class,ActionGroup> getAsMap();
}
