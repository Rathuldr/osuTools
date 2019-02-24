
package io.github.rathuldr.osuTools.beatmap;

import java.util.HashSet;

import io.github.rathuldr.osuTools.sharedtypes.CreatorData;

public final class BeatmapMetadata {
  
  private final CreatorData creatorData;
  private final String difficultyName;
  private final String source;
  private final HashSet<String> tags;
  private final int beatmapID;
  private final int beatmapSetID;
  
  /**
   * Constructs a new BeatmapMetadata.
   * 
   * @param creatorData
   * @param difficultyName
   * @param source
   * @param tags
   * @param beatmapID
   * @param beatmapSetID
   */
  public BeatmapMetadata(CreatorData creatorData, String difficultyName, String source, HashSet<String> tags, int beatmapID, int beatmapSetID) {
    this.creatorData = creatorData;
    this.difficultyName = difficultyName;
    this.source = source;
    this.tags = tags;
    this.beatmapID = beatmapID;
    this.beatmapSetID = beatmapSetID;
  }
  
  /**
   * TODO Write getter description for getCreatorData
   *
   * @return a CreatorData.
   */
  public final CreatorData getCreatorData() {
    return this.creatorData;
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
   * TODO Write getter description for getSource
   *
   * @return a String.
   */
  public final String getSource() {
    return this.source;
  }
  
  /**
   * TODO Write getter description for getTags
   *
   * @return a HashSet<String>.
   */
  public final HashSet<String> getTags() {
    return this.tags;
  }
  
  /**
   * TODO Write getter description for getBeatmapID
   *
   * @return a int.
   */
  public final int getBeatmapID() {
    return this.beatmapID;
  }
  
  /**
   * TODO Write getter description for getBeatmapSetID
   *
   * @return a int.
   */
  public final int getBeatmapSetID() {
    return this.beatmapSetID;
  }
  
}
