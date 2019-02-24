
package io.github.rathuldr.osuTools.sharedtypes;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class DifficultyMetadata {
  
  private final double approachRate;
  private final double circleSize;
  private final double hpDrain;
  private final double overallDifficulty;
  
  /**
   * Constructs a new DifficultyMetadata.
   * 
   * @param approachRate
   * @param circleSize
   * @param hpDrain
   * @param overallDifficulty
   */
  public DifficultyMetadata(double approachRate, double circleSize, double hpDrain, double overallDifficulty) {
    this.approachRate = approachRate;
    this.circleSize = circleSize;
    this.hpDrain = hpDrain;
    this.overallDifficulty = overallDifficulty;
  }
  
  /**
   * TODO Write getter description for getApproachRate
   *
   * @return a double.
   */
  public final double getApproachRate() {
    return this.approachRate;
  }
  
  /**
   * TODO Write getter description for getCircleSize
   *
   * @return a double.
   */
  public final double getCircleSize() {
    return this.circleSize;
  }
  
  /**
   * TODO Write getter description for getHpDrain
   *
   * @return a double.
   */
  public final double getHpDrain() {
    return this.hpDrain;
  }
  
  /**
   * TODO Write getter description for getOverallDifficulty
   *
   * @return a double.
   */
  public final double getOverallDifficulty() {
    return this.overallDifficulty;
  }
}
