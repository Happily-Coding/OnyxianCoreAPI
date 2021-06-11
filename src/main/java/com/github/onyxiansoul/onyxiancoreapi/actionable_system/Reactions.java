package com.github.onyxiansoul.onyxiancoreapi.actionable_system;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.actions.ActionGroup;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import java.io.Serializable;

/**A collection of ActionGroups that want to react to different events*/
public interface Reactions extends Actionable<Void>, Serializable, Nameable {
  
  /**Adds an ActionGorup to the collection*/
  public void addActionGroup(ActionGroup actionGroup);
  
}
