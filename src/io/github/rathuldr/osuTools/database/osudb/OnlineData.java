
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;
import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.RankedStatus;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class OnlineData {
  
  private final RankedStatus rankedStatus;
  private final String songSource;
  private final HashSet<String> songTags;
  private final LocalDateTime lastOsuRepoCheckTime;
  private final int beatmapID;
  private final int beatmapSetID;
  private final int threadID;
  private final short onlineOffset;
  private final boolean isFormat2Osz;
  
  /**
   * Constructs a new OnlineData.
   * 
   * @param rankedStatus
   * @param songSource
   * @param songTags
   * @param lastOsuRepoCheckTime
   * @param beatmapID
   * @param beatmapSetID
   * @param threadID
   * @param onlineOffset
   * @param isFormat2Osz
   */
  public OnlineData(RankedStatus rankedStatus, String songSource, HashSet<String> songTags, LocalDateTime lastOsuRepoCheckTime, int beatmapID, int beatmapSetID,
      int threadID, short onlineOffset, boolean isFormat2Osz) {
    this.rankedStatus = rankedStatus;
    this.songSource = songSource;
    this.songTags = songTags;
    this.lastOsuRepoCheckTime = lastOsuRepoCheckTime;
    this.beatmapID = beatmapID;
    this.beatmapSetID = beatmapSetID;
    this.threadID = threadID;
    this.onlineOffset = onlineOffset;
    this.isFormat2Osz = isFormat2Osz;
  }
  
  /**
   * TODO Write getter description for getRankedStatus
   *
   * @return a RankedStatus.
   */
  public final RankedStatus getRankedStatus() {
    return this.rankedStatus;
  }
  
  /**
   * TODO Write getter description for getSongSource
   *
   * @return a String.
   */
  public final String getSongSource() {
    return this.songSource;
  }
  
  /**
   * TODO Write getter description for getSongTags
   *
   * @return a HashSet<String>.
   */
  public final HashSet<String> getSongTags() {
    return this.songTags;
  }
  
  /**
   * TODO Write getter description for getLastOsuRepoCheckTime
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getLastOsuRepoCheckTime() {
    return this.lastOsuRepoCheckTime;
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
  
  /**
   * TODO Write getter description for getThreadID
   *
   * @return a int.
   */
  public final int getThreadID() {
    return this.threadID;
  }
  
  /**
   * TODO Write getter description for getOnlineOffset
   *
   * @return a short.
   */
  public final short getOnlineOffset() {
    return this.onlineOffset;
  }
  
  /**
   * TODO Write getter description for isFormat2Osz
   *
   * @return a boolean.
   */
  public final boolean isFormat2Osz() {
    return this.isFormat2Osz;
  }
}
