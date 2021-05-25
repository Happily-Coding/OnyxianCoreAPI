package com.github.onyxiansoul.onyxiancoreapi.index_system;
import org.jetbrains.annotations.NotNull;

/**An exception signaling that the index does not have the requested entry.
 Its purpose is to force handling of this very real possibility.*/
public class DuplicateEntryException extends Exception {
  
  /**Creates an exception of message: indexName already has an entry of name: {entry} and can't register another one like {registrant} is requesting.
   * @param indexName: The name of the index at which the entry is being requested.
   * @param entry: The name of the element being requested.
  */
  public DuplicateEntryException(@NotNull String indexName, @NotNull String entry, String registrant){
    super(indexName + " already has an entry of name: {"+entry+"} and can't register another one like {"+registrant+"} is requesting." );
  }
}
