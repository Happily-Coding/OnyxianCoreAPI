package com.github.onyxiansoul.onyxiancoreapi.v2.utils;

import com.google.common.collect.LinkedListMultimap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;

//TODO: MOVE TO API!
public class CollectionUtils {
    
    //Should be called externaly only when trying to read particular map entries from a list.
    //Uses hashmap nodes instead of AbstractMap.SimpleENtry
    /*public static LinkedList<Entry<String,Object>> createNamedListFromMap(Map<String, Object> baseMap){
        LinkedList<Entry<String,Object>> namedList= new LinkedList<>();
        namedList.addAll(baseMap.entrySet());
        for(Entry<String,Object> entry: namedList){
            if(entry.getValue() instanceof ConfigurationSection){
                ConfigurationSection entryAsConfigurationSection = (ConfigurationSection) entry.getValue();
                entry.setValue(createNamedListFromMap(entryAsConfigurationSection.getValues(false)));
            }
        }
        return namedList;
    }*/
    
    public static<K,V> HashMap<K,V> safelyCastMap(Map mapToCast, Class<K> keyClass, Class<V> valueClass){
        Set<Entry> entriesToCast = mapToCast.entrySet();
        HashMap<K,V> newMap =new HashMap<>();
        
        for (Entry entry : entriesToCast) {
            K key = keyClass.cast(entry.getKey());
            V value = valueClass.cast(entry.getValue());
            newMap.put(key, value);
         }
        return newMap;
    }
          
    /** Transform a map that has creators as values to a map that has their creation as values.
     * @param <K> The key type
     * @param <V1>The original (creator) value type.
     * @param <V2>The new (created) value type.
     * @param creatablesMap The map that contains creator values
     * @return A map of key, value, where all the keys or values that extend creator have been replaced by their creation, and all else is unmodified.*/
    /*public static <K, V1 extends Creator <V2>, V2> LinkedListMultimap<K,V2> getMapWithCreatedsValues(LinkedListMultimap<K, V1> creatablesMap){
        LinkedListMultimap<K,V2> createdsMap = LinkedListMultimap.create();
        Set<K> keys =creatablesMap.keySet();
        for(K key: keys){
            List<V1> creators = creatablesMap.get(key);
            for(V1 v1: creators){
                createdsMap.put(key, v1.create());
            }
        }
        return createdsMap;
    }
    */
}
