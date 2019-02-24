
package io.github.rathuldr.osuTools.sharedtypes;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public final class TimingPoint {
  
  private final double bpm;
  private final double offset;
  private final boolean isInherited;
  
  /**
   * Constructs a new TimingPoint.
   * 
   * @param bpm
   * @param offset
   * @param isInherited
   */
  public TimingPoint(double bpm, double offset, boolean isInherited) {
    this.bpm = bpm;
    this.offset = offset;
    this.isInherited = isInherited;
  }
  
  /**
   * TODO Write getter description for getBpm
   *
   * @return a double.
   */
  public final double getBpm() {
    return this.bpm;
  }
  
  /**
   * TODO Write getter description for getOffset
   *
   * @return a double.
   */
  public final double getOffset() {
    return this.offset;
  }
  
  /**
   * TODO Write getter description for isInherited
   *
   * @return a boolean.
   */
  public final boolean isInherited() {
    return this.isInherited;
  }
}
