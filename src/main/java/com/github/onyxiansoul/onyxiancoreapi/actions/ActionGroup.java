package com.github.onyxiansoul.onyxiancoreapi.actions;

import com.github.onyxiansoul.onyxiancoreapi.utils.Named;
import org.bukkit.event.Event;

public interface ActionGroup extends Actionable<Void>, Named{
  Class<? extends Event> getTriggerClass();
}
