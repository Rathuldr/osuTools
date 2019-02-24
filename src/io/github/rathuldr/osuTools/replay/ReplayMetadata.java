
package io.github.rathuldr.osuTools.replay;

import java.time.LocalDateTime;

public final class ReplayMetadata {
  
  private final int gameVersion;
  private final String beatmapHash;
  private final String playerName;
  private final String replayHash;
  private final long onlineScoreID;
  private final LocalDateTime timestamp;
  
  /**
   * Constructs a new ReplayMetadata.
   * 
   * @param gameVersion
   * @param beatmapHash
   * @param playerName
   * @param replayHash
   * @param onlineScoreID
   * @param timestamp
   */
  public ReplayMetadata(int gameVersion, String beatmapHash, String playerName, String replayHash, long onlineScoreID, LocalDateTime timestamp) {
    this.gameVersion = gameVersion;
    this.beatmapHash = beatmapHash;
    this.playerName = playerName;
    this.replayHash = replayHash;
    this.onlineScoreID = onlineScoreID;
    this.timestamp = timestamp;
  }
  
  /**
   * TODO Write getter description for getGameVersion
   *
   * @return a int.
   */
  public final int getGameVersion() {
    return this.gameVersion;
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
   * TODO Write getter description for getPlayerName
   *
   * @return a String.
   */
  public final String getPlayerName() {
    return this.playerName;
  }
  
  /**
   * TODO Write getter description for getReplayHash
   *
   * @return a String.
   */
  public final String getReplayHash() {
    return this.replayHash;
  }
  
  /**
   * TODO Write getter description for getOnlineScoreID
   *
   * @return a long.
   */
  public final long getOnlineScoreID() {
    return this.onlineScoreID;
  }
  
  /**
   * TODO Write getter description for getTimestamp
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getTimestamp() {
    return this.timestamp;
  }
}
