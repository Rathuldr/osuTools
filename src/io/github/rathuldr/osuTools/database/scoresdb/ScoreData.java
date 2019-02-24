
package io.github.rathuldr.osuTools.database.scoresdb;

import java.util.HashSet;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ScoreData {
  
  private final int version;
  private final HashSet<BeatmapScoreEntry> beatmaps;
  
  /**
   * Constructs a new ScoreData.
   * 
   * @param version
   * @param beatmaps
   */
  public ScoreData(int version, HashSet<BeatmapScoreEntry> beatmaps) {
    this.version = version;
    this.beatmaps = beatmaps;
  }
  
  /**
   * TODO Write getter description for getVersion
   *
   * @return a int.
   */
  public final int getVersion() {
    return this.version;
  }
  
  /**
   * TODO Write getter description for getBeatmaps
   *
   * @return a HashSet<BeatmapScoreEntry>.
   */
  public final HashSet<BeatmapScoreEntry> getBeatmaps() {
    return this.beatmaps;
  }
}
