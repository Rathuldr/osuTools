
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;

import io.github.rathuldr.osuTools.constants.ScoreGrade;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class UserData {
  
  private final ScoreGrade stdGrade;
  private final ScoreGrade taikoGrade;
  private final ScoreGrade ctbGrade;
  private final ScoreGrade maniaGrade;
  private final LocalDateTime lastPlayedTime;
  private final short localOffsetMs;
  private final char maniaScrollSpeed;
  private final boolean ignoreBeatmapSounds;
  private final boolean ignoreBeatmapSkin;
  private final boolean disableVideo;
  private final boolean visualOverride; // Does this mean disable storyboard?
  private final boolean isUnplayed;
  
  /**
   * Constructs a new UserData.
   * 
   * @param stdGrade
   * @param taikoGrade
   * @param ctbGrade
   * @param maniaGrade
   * @param lastPlayedTime
   * @param localOffsetMs
   * @param maniaScrollSpeed
   * @param ignoreBeatmapSounds
   * @param ignoreBeatmapSkin
   * @param disableVideo
   * @param visualOverride
   * @param isUnplayed
   */
  public UserData(ScoreGrade stdGrade, ScoreGrade taikoGrade, ScoreGrade ctbGrade, ScoreGrade maniaGrade, LocalDateTime lastPlayedTime, short localOffsetMs,
      char maniaScrollSpeed, boolean ignoreBeatmapSounds, boolean ignoreBeatmapSkin, boolean disableVideo, boolean visualOverride, boolean isUnplayed) {
    this.stdGrade = stdGrade;
    this.taikoGrade = taikoGrade;
    this.ctbGrade = ctbGrade;
    this.maniaGrade = maniaGrade;
    this.lastPlayedTime = lastPlayedTime;
    this.localOffsetMs = localOffsetMs;
    this.maniaScrollSpeed = maniaScrollSpeed;
    this.ignoreBeatmapSounds = ignoreBeatmapSounds;
    this.ignoreBeatmapSkin = ignoreBeatmapSkin;
    this.disableVideo = disableVideo;
    this.visualOverride = visualOverride;
    this.isUnplayed = isUnplayed;
  }
  
  /**
   * TODO Write getter description for getStdGrade
   *
   * @return a ScoreGrade.
   */
  public final ScoreGrade getStdGrade() {
    return this.stdGrade;
  }
  
  /**
   * TODO Write getter description for getTaikoGrade
   *
   * @return a ScoreGrade.
   */
  public final ScoreGrade getTaikoGrade() {
    return this.taikoGrade;
  }
  
  /**
   * TODO Write getter description for getCtbGrade
   *
   * @return a ScoreGrade.
   */
  public final ScoreGrade getCtbGrade() {
    return this.ctbGrade;
  }
  
  /**
   * TODO Write getter description for getManiaGrade
   *
   * @return a ScoreGrade.
   */
  public final ScoreGrade getManiaGrade() {
    return this.maniaGrade;
  }
  
  /**
   * TODO Write getter description for getLastPlayedTime
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getLastPlayedTime() {
    return this.lastPlayedTime;
  }
  
  /**
   * TODO Write getter description for getLocalOffsetMs
   *
   * @return a short.
   */
  public final short getLocalOffsetMs() {
    return this.localOffsetMs;
  }
  
  /**
   * TODO Write getter description for getManiaScrollSpeed
   *
   * @return a char.
   */
  public final char getManiaScrollSpeed() {
    return this.maniaScrollSpeed;
  }
  
  /**
   * TODO Write getter description for isIgnoreBeatmapSounds
   *
   * @return a boolean.
   */
  public final boolean isIgnoreBeatmapSounds() {
    return this.ignoreBeatmapSounds;
  }
  
  /**
   * TODO Write getter description for isIgnoreBeatmapSkin
   *
   * @return a boolean.
   */
  public final boolean isIgnoreBeatmapSkin() {
    return this.ignoreBeatmapSkin;
  }
  
  /**
   * TODO Write getter description for isDisableVideo
   *
   * @return a boolean.
   */
  public final boolean isDisableVideo() {
    return this.disableVideo;
  }
  
  /**
   * TODO Write getter description for isVisualOverride
   *
   * @return a boolean.
   */
  public final boolean isVisualOverride() {
    return this.visualOverride;
  }
  
  /**
   * TODO Write getter description for isUnplayed
   *
   * @return a boolean.
   */
  public final boolean isUnplayed() {
    return this.isUnplayed;
  }
}
