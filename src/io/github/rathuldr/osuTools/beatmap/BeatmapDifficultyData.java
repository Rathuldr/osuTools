
package io.github.rathuldr.osuTools.beatmap;

import io.github.rathuldr.osuTools.sharedtypes.DifficultyMetadata;

public final class BeatmapDifficultyData {
  
  private final DifficultyMetadata difficultyMetadata;
  private final double sliderMultiplier;
  private final double sliderTickRate;
  
  /**
   * Constructs a new BeatmapDifficultyData.
   * 
   * @param difficultyMetadata
   * @param sliderMultiplier
   * @param sliderTickRate
   */
  public BeatmapDifficultyData(DifficultyMetadata difficultyMetadata, double sliderMultiplier, double sliderTickRate) {
    this.difficultyMetadata = difficultyMetadata;
    this.sliderMultiplier = sliderMultiplier;
    this.sliderTickRate = sliderTickRate;
  }
  
  /**
   * TODO Write getter description for getDifficultyMetadata
   *
   * @return a DifficultyMetadata.
   */
  public final DifficultyMetadata getDifficultyMetadata() {
    return this.difficultyMetadata;
  }
  
  /**
   * TODO Write getter description for getSliderMultiplier
   *
   * @return a double.
   */
  public final double getSliderMultiplier() {
    return this.sliderMultiplier;
  }
  
  /**
   * TODO Write getter description for getSliderTickRate
   *
   * @return a double.
   */
  public final double getSliderTickRate() {
    return this.sliderTickRate;
  }
}
