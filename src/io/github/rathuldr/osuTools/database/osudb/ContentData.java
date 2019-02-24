
package io.github.rathuldr.osuTools.database.osudb;

import io.github.rathuldr.osuTools.sharedtypes.DifficultyMetadata;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ContentData {
  
  private final DifficultyMetadata diffMetrics;
  private final String difficultyName;
  private final short numHitCircles;
  private final short numSliders;
  private final short numSpinners;
  private final double sliderVelocity;
  
  /**
   * Constructs a new ContentData.
   * 
   * @param diffMetrics
   * @param difficultyName
   * @param numHitCircles
   * @param numSliders
   * @param numSpinners
   * @param sliderVelocity
   */
  public ContentData(DifficultyMetadata diffMetrics, String difficultyName, short numHitCircles, short numSliders, short numSpinners, double sliderVelocity) {
    this.diffMetrics = diffMetrics;
    this.difficultyName = difficultyName;
    this.numHitCircles = numHitCircles;
    this.numSliders = numSliders;
    this.numSpinners = numSpinners;
    this.sliderVelocity = sliderVelocity;
  }
  
  /**
   * TODO Write getter description for getDiffMetrics
   *
   * @return a DifficultyMetadata.
   */
  public final DifficultyMetadata getDiffMetrics() {
    return this.diffMetrics;
  }
  
  /**
   * TODO Write getter description for getDifficultyName
   *
   * @return a String.
   */
  public final String getDifficultyName() {
    return this.difficultyName;
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
  
  /**
   * TODO Write getter description for getSliderVelocity
   *
   * @return a double.
   */
  public final double getSliderVelocity() {
    return this.sliderVelocity;
  }
  
}
