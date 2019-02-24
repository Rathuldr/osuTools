
package io.github.rathuldr.osuTools.database.scoresdb;

import java.util.HashSet;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class BeatmapScoreEntry {
  
  private final String beatmapHash;
  private final HashSet<ScoreEntry> scores;
  
  /**
   * Constructs a new BeatmapScoreEntry.
   * 
   * @param beatmapHash
   * @param scores
   */
  public BeatmapScoreEntry(String beatmapHash, HashSet<ScoreEntry> scores) {
    this.beatmapHash = beatmapHash;
    this.scores = scores;
  }
  
  /**
   * TODO Write getter description for getBeatmapHash
   *
   * @return a String.
   */
  public final String getBeatmapHash() {
    return this.beatmapHash;
  }
  
  /**
   * TODO Write getter description for getScores
   *
   * @return a HashSet<ScoreEntry>.
   */
  public final HashSet<ScoreEntry> getScores() {
    return this.scores;
  }
}
