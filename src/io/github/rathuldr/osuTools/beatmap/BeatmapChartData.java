
package io.github.rathuldr.osuTools.beatmap;

import java.util.ArrayList;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.sharedtypes.TimingPoint;

/**
 * This class contains the beatmap play data, such as hit circles, sliders, timing points, and stack leniency.
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 24, 2019
 */
public final class BeatmapChartData {
  
  /** The game mode this beatmap is for. */
  private final GameMode gameMode;
  
  /** How likely hit objects are to be offset in a stack. */
  private final double stackLeniency;
  
  /** The {@link ArrayList} of {@link TimingPoint}s, in order of appearance. */
  private final ArrayList<BeatmapTimingPoint> timingPoints;
  
  /** The {@link ArrayList} of {@link HitObject}s, in order of appearance. */
  private final ArrayList<HitObject> hitObjects;
  
  /**
   * Constructs a new BeatmapChartData.
   * 
   * @param gameMode The game mode this beatmap is for.
   * @param stackLeniency How likely hit objects are to be offset in a stack.
   * @param timingPoints The {@link ArrayList} of {@link TimingPoint}s, in order of appearance.
   * @param hitObjects The {@link ArrayList} of {@link HitObject}s, in order of appearance.
   */
  public BeatmapChartData(GameMode gameMode, double stackLeniency, ArrayList<BeatmapTimingPoint> timingPoints, ArrayList<HitObject> hitObjects) {
    this.gameMode = gameMode;
    this.stackLeniency = stackLeniency;
    this.timingPoints = timingPoints;
    this.hitObjects = hitObjects;
  }
  
  /**
   * Gets the game mode this beatmap is for.
   *
   * @return a {@link GameMode}.
   */
  public final GameMode getGameMode() {
    return this.gameMode;
  }
  
  /**
   * Gets how likely hit objects are to be offset in a stack.
   *
   * @return a double.
   */
  public final double getStackLeniency() {
    return this.stackLeniency;
  }
  
  /**
   * Gets the {@link ArrayList} of {@link TimingPoint}s, in order of appearance.
   *
   * @return an {@link ArrayList}.
   */
  public final ArrayList<BeatmapTimingPoint> getTimingPoints() {
    return this.timingPoints;
  }
  
  /**
   * Gets the {@link ArrayList} of {@link HitObject}s, in order of appearance.
   *
   * @return an {@link ArrayList}.
   */
  public final ArrayList<HitObject> getHitObjects() {
    return this.hitObjects;
  }
}
