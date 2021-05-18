package com.github.onyxiansoul.onyxiancoreapi.index_system;
import org.jetbrains.annotations.NotNull;

/**An exception signaling that the index does not have the requested entry.
 Its purpose is to force handling of this very real possibility.*/
public class MissingEntryException extends Exception {
  
  /**Creates an exception of message: indexName has no entry of name: {entry}
   * @param indexName: The name of the index at which the entry is being requested.
   * @param entry: The name of the element being requested.
  */
  public MissingEntryException(@NotNull String indexName, @NotNull String entry){
    super(indexName + " has no entry of name: {"+entry+"}");
  }
}
