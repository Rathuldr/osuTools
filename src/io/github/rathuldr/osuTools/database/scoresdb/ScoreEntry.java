
package io.github.rathuldr.osuTools.database.scoresdb;

import java.time.LocalDateTime;
import java.util.TreeSet;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.constants.GameplayMod;
import io.github.rathuldr.osuTools.sharedtypes.JudgementCounts;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ScoreEntry {
  
  private final GameMode gameMode;
  private final int version;
  private final String beatmapHash;
  private final String playerName;
  private final String replayHash;
  private final JudgementCounts judgements;
  private final int score;
  private final short maxCombo;
  private final TreeSet<GameplayMod> modsUsed;
  private final LocalDateTime timestamp;
  private final long onlineScoreID;
  
  /**
   * Constructs a new ScoreEntry.
   * 
   * @param gameMode
   * @param version
   * @param beatmapHash
   * @param playerName
   * @param replayHash
   * @param judgements
   * @param score
   * @param maxCombo
   * @param modsUsed
   * @param timestamp
   * @param onlineScoreID
   */
  public ScoreEntry(GameMode gameMode, int version, String beatmapHash, String playerName, String replayHash, JudgementCounts judgements, int score,
      short maxCombo, TreeSet<GameplayMod> modsUsed, LocalDateTime timestamp, long onlineScoreID) {
    this.gameMode = gameMode;
    this.version = version;
    this.beatmapHash = beatmapHash;
    this.playerName = playerName;
    this.replayHash = replayHash;
    this.judgements = judgements;
    this.score = score;
    this.maxCombo = maxCombo;
    this.modsUsed = modsUsed;
    this.timestamp = timestamp;
    this.onlineScoreID = onlineScoreID;
  }
  
  /**
   * TODO Write getter description for getGameMode
   *
   * @return a GameMode.
   */
  public final GameMode getGameMode() {
    return this.gameMode;
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
   * TODO Write getter description for getJudgements
   *
   * @return a JudgementCounts.
   */
  public final JudgementCounts getJudgements() {
    return this.judgements;
  }
  
  /**
   * TODO Write getter description for getScore
   *
   * @return a int.
   */
  public final int getScore() {
    return this.score;
  }
  
  /**
   * TODO Write getter description for getMaxCombo
   *
   * @return a short.
   */
  public final short getMaxCombo() {
    return this.maxCombo;
  }
  
  /**
   * TODO Write getter description for getModsUsed
   *
   * @return a TreeSet<GameplayMod>.
   */
  public final TreeSet<GameplayMod> getModsUsed() {
    return this.modsUsed;
  }
  
  /**
   * TODO Write getter description for getTimestamp
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getTimestamp() {
    return this.timestamp;
  }
  
  /**
   * TODO Write getter description for getOnlineScoreID
   *
   * @return a long.
   */
  public final long getOnlineScoreID() {
    return this.onlineScoreID;
  }
}
