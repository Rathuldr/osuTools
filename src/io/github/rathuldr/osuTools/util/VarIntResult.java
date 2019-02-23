
package io.github.rathuldr.osuTools.util;

import java.math.BigInteger;

/**
 * This class contains the resulting value of a C# ULEB128 and the number of bytes it occupies.
 * 
 * @author Rathuldr rathuldr@gmail.com
 */
public class VarIntResult {
  
  /** The value of the ULEB128. */
  private final BigInteger value;
  
  /** The number of bytes the ULEB128 occupied. */
  private final int bytesParsed;
  
  /**
   * Constructs a new VarIntResult.
   * 
   * @param value the value of the ULEB128.
   * @param bytesParsed the number of bytes the ULEB128 occupied.
   */
  public VarIntResult(final BigInteger value, final int bytesParsed) {
    this.value = value;
    this.bytesParsed = bytesParsed;
  }
  
  /**
   * Gets the resulting value of the ULEB128.
   * 
   * @return the value as a {@link BigInteger}.
   */
  public final BigInteger getValue() {
    return this.value;
  }
  
  /**
   * Gets the number of bytes occupied by this ULEB128.
   * 
   * @return an int.
   */
  public final int getBytesParsed() {
    return this.bytesParsed;
  }
  
}
