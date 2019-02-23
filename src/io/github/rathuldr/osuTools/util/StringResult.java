
package io.github.rathuldr.osuTools.util;

/**
 * This class contains the resulting C# String parsed and the number of bytes it occupies.
 * 
 * @author Rathuldr rathuldr@gmail.com
 */
public class StringResult {
  
  /** The resulting String that was parsed. */
  private final String resultStr;
  
  /** The number of bytes that the C# String occupies. */
  private final int totalBytes;
  
  /**
   * Constructs a new StringResult.
   * 
   * @param resultStr the resulting C# String.
   * @param totalBytes the number of bytes the C# String occupies.
   */
  public StringResult(final String resultStr, final int totalBytes) {
    this.resultStr = resultStr;
    this.totalBytes = totalBytes;
  }
  
  /**
   * Gets the resulting String.
   * 
   * @return the resulting String.
   */
  public final String getResultStr() {
    return this.resultStr;
  }
  
  /**
   * Gets the number of bytes the C# string occupies.
   * 
   * @return an int.
   */
  public final int getTotalBytes() {
    return this.totalBytes;
  }
}
