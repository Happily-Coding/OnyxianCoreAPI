package com.github.onyxiansoul.onyxiancoreapi.index_system;
import org.jetbrains.annotations.NotNull;

/**An exception signaling that the index does not have the requested entry.
 Its purpose is to force handling of this very real possibility.*/
public class DuplicateEntryException extends Exception {
  
  /**Creates an exception of message: newRegistrant is attempting to register {entry} to indexName index but it already has an entry which was registered by previousRegistrant;
   * @param indexName: The name of the index at which the entry is being requested.
   * @param entry: The name of the element being requested.
  */
  public DuplicateEntryException(@NotNull String indexName, @NotNull String entry, String newRegistrant, String previousRegistrant){
    super("{"+newRegistrant+"}"+" is attempting to register {"+ entry+ "} to "+indexName + " index, but it already has an entry which was registered by "+previousRegistrant);
  }
}
