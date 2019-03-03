
package io.github.rathuldr.osuTools.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.GameplayMod;
import io.github.rathuldr.osuTools.sharedtypes.IntDoublePair;

/**
 * This class handles parsing Little Endian data from osu! databases, such as <code>osu!.db</code> or
 * <code>collections.db</code>.
 * 
 * @author Rathuldr rathuldr@gmail.com
 */
public class LEBinaryParser {
  
  /** The byte that marks the start of a C# string. */
  public static final char STRING_START_BYTE = 0x0b;
  
  /** The number of bytes in a C# DateTime object. */
  public static final int NUM_BYTES_DATETIME = 8;
  
  /** The number of bytes in a C# double. */
  public static final int NUM_BYTES_DOUBLE = 8;
  
  /** The number of bytes in a C# float. */
  public static final int NUM_BYTES_FLOAT = 4;
  
  /** The number of bytes in a C# long. */
  public static final int NUM_BYTES_LONG = 8;
  
  /** The number of bytes in a C# int. */
  public static final int NUM_BYTES_INT = 4;
  
  /** The number of bytes in a C# short. */
  public static final int NUM_BYTES_SHORT = 2;
  
  /** The number of bytes in a C# char. */
  public static final int NUM_BYTES_CHAR = 1;
  
  /** The internal byte array. */
  private final byte[] byteArr;
  
  /** The current offset into the byte array. */
  private int currOffset;
  
  /**
   * Constructs a new LEBinaryParser with the given byte array as its internal data.
   * 
   * @param byteArr the byte array to parse.
   */
  public LEBinaryParser(final byte[] byteArr) {
    this.byteArr = byteArr;
    this.currOffset = 0;
  }
  
  /**
   * TODO Write description for isAtEndOfStream
   * 
   * @return
   */
  public final boolean isAtEndOfStream() {
    return this.currOffset >= (this.byteArr.length - 1);
  }
  
  /**
   * TODO Write description for peekByte
   * 
   * @return
   */
  public final char peekByte() {
    return (char) this.byteArr[this.currOffset];
  }
  
  /**
   * TODO Write description for parseIntDoublePair
   * 
   * @return
   */
  public final IntDoublePair parseIntDoublePair() {
    this.parseChar();
    
    final int permFlags = this.parseInt();
    
    this.parseChar();
    
    final double starRating = this.parseDouble();
    final HashSet<GameplayMod> modSet = GameplayMod.unpackFromBitField(permFlags);
    
    return new IntDoublePair(modSet, starRating);
  }
  
  /**
   * Consumes and parses a C# DateTime value at the current position.
   * 
   * @return a LocalDateTime in the user's system default time zone.
   */
  public final LocalDateTime parseDateTime() {
    final LocalDateTime result = getDateTime(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_DATETIME;
    return result;
  }
  
  /**
   * Consumes and parses a C# String value at the current position.
   * 
   * @return the String data.
   */
  public final String parseString() {
    final StringResult strRes = getString(this.byteArr, this.currOffset);
    this.currOffset += strRes.getTotalBytes();
    return strRes.getResultStr();
  }
  
  /**
   * Consumes and parses a C# ULEB128 at the current position.
   * 
   * @return the value parsed as a BigInteger.
   */
  public final BigInteger parseVarInt() {
    final VarIntResult viRes = getVarInt(this.byteArr, this.currOffset);
    this.currOffset += viRes.getBytesParsed();
    return viRes.getValue();
  }
  
  /**
   * Consumes and parses a C# double at the current position.
   * 
   * @return the value parsed as a double.
   */
  public final double parseDouble() {
    final double result = getDouble(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_DOUBLE;
    return result;
  }
  
  /**
   * Consumes and parses a C# float at the current position.
   * 
   * @return the value parsed as a float.
   */
  public final float parseFloat() {
    final float result = getFloat(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_FLOAT;
    return result;
  }
  
  /**
   * Consumes and parses a C# long at the current position.
   * 
   * @return the value parsed as a long.
   */
  public final long parseLong() {
    final long result = getLong(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_LONG;
    return result;
  }
  
  /**
   * Consumes and parses a C# int at the current position.
   * 
   * @return the value parsed as an int.
   */
  public final int parseInt() {
    final int result = getInt(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_INT;
    return result;
  }
  
  /**
   * Consumes and parses a C# short at the current position.
   * 
   * @return the value parsed as a short.
   */
  public final short parseShort() {
    final short result = getShort(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_SHORT;
    return result;
  }
  
  /**
   * Consumes and parses a C# char at the current position.
   * 
   * @return the value parsed as a char.
   */
  public final char parseChar() {
    final char result = getChar(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_CHAR;
    return result;
  }
  
  /**
   * Consumes and parses a C# byte at the current position and treats it as a boolean.
   * 
   * @return true if the byte parsed is non-zero.
   */
  public final boolean parseCharAsBoolean() {
    final boolean result = getCharAsBoolean(this.byteArr, this.currOffset);
    this.currOffset += NUM_BYTES_CHAR;
    return result;
  }
  
  /**
   * Converts a C# DateTime value into a LocalDateTime at the specified position in the given byte array.
   * 
   * @param dat the byte array.
   * @param offset the point where the desired DateTime to convert starts.
   * @return a LocalDateTime in the user's system default time zone.
   */
  public static final LocalDateTime getDateTime(final byte[] dat, final int offset) {
    final long winTicks = getLong(dat, offset);
    final long javaTicks = winTicksToJavaTime(winTicks);
    final Instant inst = Instant.ofEpochMilli(javaTicks);
    return inst.atZone(ZoneId.systemDefault()).toLocalDateTime();
  }
  
  /**
   * Returns a String from a byte array.
   * 
   * @param dat the byte array.
   * @param offset the index the String begins at (counting the <code>0x0b</code>).
   * 
   * @return the String data.
   */
  public static final StringResult getString(final byte[] dat, int offset) {
    
    // Return the empty string if there is no entry
    final long leVal = getLEVal(dat, offset, NUM_BYTES_CHAR);
    
    if (leVal == 0) return new StringResult("", 1);
    
    final VarIntResult viResult = getVarInt(dat, offset);
    final BigInteger viValue = viResult.getValue();
    final int viBytes = viResult.getBytesParsed();
    
    if (viValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
      throw new IllegalArgumentException("String length is too large.");
    }
    final int strLen = viValue.intValue();
    
    // Get the String's data
    final char[] strData = new char[strLen];
    for (int i = 0; i < strLen; i++) {
      strData[i] = getChar(dat, offset + viBytes + i + 1);
    }
    
    return new StringResult(new String(strData), viBytes + strLen + 1);
    
  }
  
  /**
   * Converts a .NET ULEB128 at the given offset from a byte array to a structure containing a BigInteger and the number
   * of bytes containing the ULEB128.
   * 
   * @param b the byte array.
   * @param offset the position to start parsing an ULEB128.
   * @return a structure containing the value parsed as a BigInteger and the number of bytes parsed.
   */
  public static final VarIntResult getVarInt(final byte[] b, final int offset) {
    
    BigInteger strLen = BigInteger.ZERO;
    
    int i = 1;
    int byteCount = 0;
    
    while (true) {
      
      if (byteCount > 9) break;
      
      final int currVal = (int) getLEVal(b, offset + (i++), NUM_BYTES_CHAR);
      strLen = strLen.or(BigInteger.valueOf((currVal & 0x0000007f) << (byteCount * 7)));
      
      if (currVal < 128) {
        break;
      }
      byteCount++;
    }
    
    byteCount++;
    
    return new VarIntResult(strLen, byteCount);
  }
  
  /**
   * Returns the value of the byte array at the given offset as a double (8 bytes).
   * 
   * @param b the byte array.
   * @param offset the position to start parsing a double.
   * 
   * @return a double.
   */
  public static final double getDouble(final byte[] b, final int offset) {
    final long bytesLong = getLEVal(b, offset, NUM_BYTES_DOUBLE);
    return ByteBuffer.allocate(NUM_BYTES_DOUBLE).putLong(bytesLong).getDouble(0);
  }
  
  /**
   * Returns the value of the byte array at the given offset as a float (4 bytes).
   * 
   * @param b the byte array.
   * @param offset the position to start parsing a float.
   * 
   * @return a float.
   */
  public static final float getFloat(final byte[] b, final int offset) {
    final int bytesInt = (int) getLEVal(b, offset, NUM_BYTES_FLOAT);
    return ByteBuffer.allocate(NUM_BYTES_FLOAT).putInt(bytesInt).getFloat(0);
  }
  
  /**
   * Returns the value of the byte array at the given offset as a long (8 bytes).
   * 
   * @param b the byte array.
   * @param offset the position to start parsing a long.
   * 
   * @return a long.
   */
  public static final long getLong(final byte[] b, final int offset) {
    return getLEVal(b, offset, NUM_BYTES_LONG);
  }
  
  /**
   * Returns the value of the byte array at the given offset as an int (4 bytes).
   * 
   * @param b the byte array.
   * @param offset the position to start parsing an int.
   * 
   * @return an int.
   */
  public static final int getInt(final byte[] b, final int offset) {
    return (int) getLEVal(b, offset, NUM_BYTES_INT);
  }
  
  /**
   * Returns the value of the byte array at the given offset as a short (2 bytes).
   * 
   * @param b the byte array.
   * @param offset the position to start parsing a short.
   * 
   * @return a short.
   */
  public static final short getShort(final byte[] b, final int offset) {
    return (short) getLEVal(b, offset, NUM_BYTES_SHORT);
  }
  
  /**
   * Returns the value of the byte array at the given offset as a char (1 byte).
   * 
   * @param b the byte array.
   * @param offset the position to start parsing a <code>char</code>.
   * 
   * @return a char.
   */
  public static final char getChar(final byte[] b, final int offset) {
    return (char) getLEVal(b, offset, NUM_BYTES_CHAR);
  }
  
  /**
   * Returns the value of the byte array at the given offset as a boolean.
   * 
   * @param b the byte array.
   * @param offset the position to start parsing a <code>boolean</code>.
   * 
   * @return true if the byte was non-zero; false otherwise.
   */
  public static final boolean getCharAsBoolean(final byte[] b, final int offset) {
    final char c = getChar(b, offset);
    return c != 0;
  }
  
  /**
   * Returns the logarithm base-2 of the given value. This can be used to determine the number of bits required to store
   * a number.
   * 
   * @param n the value to take the log_2 of, as a double.
   * @return the result of log_2(n), as a double.
   */
  public static final double log2(final double n) {
    
    // WHY IS THIS FUNCTION NOT BUILT-IN!?
    return (Math.log(n) / Math.log(2));
  }
  
  /**
   * Returns an int representation of a Little-Endian byte range.
   * 
   * @param dat the byte array to parse.
   * @param offset the index to start at.
   * @param size the size of the value.
   * @return a converted int.
   */
  private static final long getLEVal(final byte[] dat, final int offset, final int size) {
    
    // Get the first byte
    long result = 0;
    
    // Shift and mask byte-by-byte until the desired length
    for (int i = 0; i < size; i++) {
      
      final long byteVal = Byte.toUnsignedLong(dat[offset + i]);
      result |= (byteVal << (8 * i));
    }
    
    return result;
  }
  
  /**
   * Converts Windows ticks to Java ticks.
   * 
   * @param ticks the number of 100ns .NET ticks since 1/1/0001 to convert.
   * @return a long representing the number of millisecond Java ticks since 1/1/1970.
   */
  private static final long winTicksToJavaTime(final long ticks) {
    return (ticks - 621_355_968_000_000_000L) / 10_000L;
  }
  
  /**
   * 
   * TODO Write description for parseByteArray
   * 
   * @return
   */
  public Object parseByteArray() {
    // FIXME Auto-generated method stub
    return null;
  }
  
}
