
package io.github.rathuldr.osuTools.database.osudb;

import io.github.rathuldr.osuTools.sharedtypes.DifficultyMetadata;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class DifficultyData {
  
  private final ObjectCounts objectCounts;
  private final DifficultyMetadata diffMetadata;
  private final StarDifficulties starDiffs;
  private final double sliderVelocity;
  private final int drainTimeSecs;
  private final int totalTimeMs;
  
  /**
   * Constructs a new DifficultyData.
   * 
   * @param objectCounts
   * @param diffMetadata
   * @param starDiffs
   * @param sliderVelocity
   * @param drainTimeSecs
   * @param totalTimeMs
   */
  public DifficultyData(ObjectCounts objectCounts, DifficultyMetadata diffMetadata, StarDifficulties starDiffs, double sliderVelocity, int drainTimeSecs,
      int totalTimeMs) {
    this.objectCounts = objectCounts;
    this.diffMetadata = diffMetadata;
    this.starDiffs = starDiffs;
    this.sliderVelocity = sliderVelocity;
    this.drainTimeSecs = drainTimeSecs;
    this.totalTimeMs = totalTimeMs;
  }
  
  /**
   * TODO Write getter description for getObjectCounts
   *
   * @return a ObjectCounts.
   */
  public final ObjectCounts getObjectCounts() {
    return this.objectCounts;
  }
  
  /**
   * TODO Write getter description for getDiffMetadata
   *
   * @return a DifficultyMetadata.
   */
  public final DifficultyMetadata getDiffMetadata() {
    return this.diffMetadata;
  }
  
  /**
   * TODO Write getter description for getStarDiffs
   *
   * @return a StarDifficulties.
   */
  public final StarDifficulties getStarDiffs() {
    return this.starDiffs;
  }
  
  /**
   * TODO Write getter description for getSliderVelocity
   *
   * @return a double.
   */
  public final double getSliderVelocity() {
    return this.sliderVelocity;
  }
  
  /**
   * TODO Write getter description for getDrainTimeSecs
   *
   * @return a int.
   */
  public final int getDrainTimeSecs() {
    return this.drainTimeSecs;
  }
  
  /**
   * TODO Write getter description for getTotalTimeMs
   *
   * @return a int.
   */
  public final int getTotalTimeMs() {
    return this.totalTimeMs;
  }
}
