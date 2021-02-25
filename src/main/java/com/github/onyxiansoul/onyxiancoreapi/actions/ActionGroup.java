package com.github.onyxiansoul.onyxiancoreapi.actions;

import org.bukkit.event.Event;
import com.github.onyxiansoul.onyxiancoreapi.utils.Nameable;

public interface ActionGroup extends Actionable<Void>, Nameable{
  Class<? extends Event> getTriggerClass();
}
