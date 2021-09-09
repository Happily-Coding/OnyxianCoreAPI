package com.github.onyxiansoul.onyxiancoreapi.utils;

/**An exception signaling a file is missing, or inaccesible*/
public class UnavailableFileException extends Exception {
  private static final String craftMessage(String location, String fileName){
    return "could not find or access the file "+ fileName + " that should be inside of " + location;
  }
  
  /**A constructor to craft the exception with a message indicating the file that was missing and the path it was searched at, and any exception that was the caus
   * @param location The location of the file
   * @param fileName The name of the file (with the extension ideally)
   * @param cause The cause of the problem
   */
  public UnavailableFileException(String location, String fileName, Throwable cause){
    super(craftMessage(location,fileName), cause);
  }
}
