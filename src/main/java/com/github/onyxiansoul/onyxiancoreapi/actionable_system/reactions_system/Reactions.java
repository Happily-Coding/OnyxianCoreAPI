package com.github.onyxiansoul.onyxiancoreapi.actionable_system.reactions_system;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**A collection of reactions that want to react to different triggers (usually events)*/
public interface Reactions extends Serializable {
  
  /**Adds an ActionGorup to the collection*/
  public void addReaction(Reaction reaction);
  
  /**Check if the reactions are reactive to something, (usually an event)*/
  public boolean areReactiveTo(Class trigger);
  
  /**Gets the reactions as a map*/
  public Map<Class,Collection<Reaction>> getAsMap();
}
