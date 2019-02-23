
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;
import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.RankedStatus;

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
}
