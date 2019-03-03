
package io.github.rathuldr.osuTools.database.osudb;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.sharedtypes.DifficultyMetadata;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ContentData {
  
  private final DifficultyMetadata diffMetrics;
  private final GameMode gameMode;
  private final String difficultyName;
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
  public ContentData(final DifficultyMetadata diffMetrics, final GameMode gameMode, final String difficultyName, final double sliderVelocity) {
    this.diffMetrics = diffMetrics;
    this.gameMode = gameMode;
    this.difficultyName = difficultyName;
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
   * TODO Write description for getGameMode
   * 
   * @return
   */
  public GameMode getGameMode() {
    return this.gameMode;
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
   * TODO Write getter description for getSliderVelocity
   *
   * @return a double.
   */
  public final double getSliderVelocity() {
    return this.sliderVelocity;
  }
  
}
