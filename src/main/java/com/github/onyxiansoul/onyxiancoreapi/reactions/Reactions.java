package com.github.onyxiansoul.onyxiancoreapi.reactions;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.Actionable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**A collection of ActionGroups that want to react to different triggers (usually events)*/
public interface Reactions extends Actionable<Void>, Serializable {
  
  /**Adds an ActionGorup to the collection*/
  public void addActionGroup(ActionGroup actionGroup);
  
  /**Check if the reactions are reactive to something, (usually an event)*/
  public boolean areReactiveTo(Class trigger);
  
  /**Gets the reactions as a map class, action group*/
  public Map<Class,Collection<ActionGroup>> getAsMap();
}
