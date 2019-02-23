
package io.github.rathuldr.osuTools.database.scoresdb;

import java.time.LocalDateTime;
import java.util.TreeSet;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.constants.GameplayMod;

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
}
