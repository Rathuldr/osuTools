
package io.github.rathuldr.osuTools.database.osudb;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ObjectCounts {
  
  private final short numHitCircles;
  private final short numSliders;
  private final short numSpinners;
  
  /**
   * Constructs a new ObjectCounts.
   * 
   * @param numHitCircles
   * @param numSliders
   * @param numSpinners
   */
  public ObjectCounts(short numHitCircles, short numSliders, short numSpinners) {
    this.numHitCircles = numHitCircles;
    this.numSliders = numSliders;
    this.numSpinners = numSpinners;
  }
  
  /**
   * TODO Write getter description for getNumHitCircles
   *
   * @return a short.
   */
  public final short getNumHitCircles() {
    return this.numHitCircles;
  }
  
  /**
   * TODO Write getter description for getNumSliders
   *
   * @return a short.
   */
  public final short getNumSliders() {
    return this.numSliders;
  }
  
  /**
   * TODO Write getter description for getNumSpinners
   *
   * @return a short.
   */
  public final short getNumSpinners() {
    return this.numSpinners;
  }
}
