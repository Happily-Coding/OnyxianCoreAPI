package me.onyxiansoul.onyxiancoreapi.parameters;

import java.util.ArrayList;
import java.util.List;
import me.onyxiansoul.onyxiancoreapi.event.ParameteredEventType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Event;

//Clase que representa una variable definido a partir de una definición por string, y de valor obtenible ante un evento
//Con la ayuda del metodo presente en PlaceholderType
public interface Placeholder {
    
    
    //Metodo auxiliar que crea un placeholder a partir de la lecutra de la configkey ubicada en la configsection, y posterior veirificación
    //De que el placeholder obtenido sea de la clase representada
    public Placeholder getFromConfig(ConfigurationSection configSection, String configKey, String defaultValue, Class representedClass);
    
    //Metodo para obtener el valor de un placeholder, que necesite algun parametro de evento ya sea directamente o en sus inners
    //Si no lo necesita se le puede pasar null y funcionaría
    public Object getCurrentValue(ParameteredEventType eType, Event e);

}

