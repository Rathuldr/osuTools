package io.github.rathuldr.osuTools.database.scoresdb;

import java.util.HashSet;

public class ScoreData {
  private final int version;
  private final HashSet<BeatmapScoreEntry> beatmaps;
}
