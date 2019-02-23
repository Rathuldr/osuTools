
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;
import java.util.HashSet;

public class OsuDBData {
  
  private final int osuVersion;
  private final int folderCount;
  private final boolean accountUnlocked;
  private final LocalDateTime accountUnlockTime;
  private final String playerName;
  private final HashSet<BeatmapData> beatmapData;
}
