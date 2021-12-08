
package com.github.onyxiansoul.onyxiancoreapi.identity;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/**Any elements that holds a map, that can be used for storing/retrieving values based on a key*/
public interface StorageHolder<KeyT,ValueT> {
  public @NotNull Map<KeyT,ValueT> getStorage();
}
