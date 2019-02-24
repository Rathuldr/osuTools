
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class OsuDBData {
  
  private final int osuVersion;
  private final int folderCount;
  private final boolean accountUnlocked;
  private final LocalDateTime accountUnlockTime;
  private final String playerName;
  private final HashSet<BeatmapData> beatmapData;
  
  /**
   * Constructs a new OsuDBData.
   * 
   * @param osuVersion
   * @param folderCount
   * @param accountUnlocked
   * @param accountUnlockTime
   * @param playerName
   * @param beatmapData
   */
  public OsuDBData(int osuVersion, int folderCount, boolean accountUnlocked, LocalDateTime accountUnlockTime, String playerName,
      HashSet<BeatmapData> beatmapData) {
    this.osuVersion = osuVersion;
    this.folderCount = folderCount;
    this.accountUnlocked = accountUnlocked;
    this.accountUnlockTime = accountUnlockTime;
    this.playerName = playerName;
    this.beatmapData = beatmapData;
  }
  
  /**
   * TODO Write getter description for getOsuVersion
   *
   * @return a int.
   */
  public final int getOsuVersion() {
    return this.osuVersion;
  }
  
  /**
   * TODO Write getter description for getFolderCount
   *
   * @return a int.
   */
  public final int getFolderCount() {
    return this.folderCount;
  }
  
  /**
   * TODO Write getter description for isAccountUnlocked
   *
   * @return a boolean.
   */
  public final boolean isAccountUnlocked() {
    return this.accountUnlocked;
  }
  
  /**
   * TODO Write getter description for getAccountUnlockTime
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getAccountUnlockTime() {
    return this.accountUnlockTime;
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
   * TODO Write getter description for getBeatmapData
   *
   * @return a HashSet<BeatmapData>.
   */
  public final HashSet<BeatmapData> getBeatmapData() {
    return this.beatmapData;
  }
}
