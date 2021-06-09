package com.github.onyxiansoul.onyxiancoreapi.actionable_system;
import com.github.onyxiansoul.onyxiancoreapi.actionable_system.actions.ActionGroup;
import com.github.onyxiansoul.onyxiancoreapi.identity.Nameable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**Anything that is interested en events*/
public interface Reactions extends Actionable<Void>, Serializable, Nameable {
  
  public Map<Class, Collection<ActionGroup>> getActionGroupsMap();
  
}
