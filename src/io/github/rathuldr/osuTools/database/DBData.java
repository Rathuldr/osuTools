
package io.github.rathuldr.osuTools.database;

import io.github.rathuldr.osuTools.database.collectiondb.CollectionData;
import io.github.rathuldr.osuTools.database.osudb.OsuDBData;
import io.github.rathuldr.osuTools.database.scoresdb.ScoreData;

public final class DBData {
  
  private final CollectionData collectionData;
  private final OsuDBData osuDBData;
  private final ScoreData scoreData;
  
  /**
   * Constructs a new DBData.
   * 
   * @param collectionData
   * @param osuDBData
   * @param scoreData
   */
  public DBData(final CollectionData collectionData, final OsuDBData osuDBData, final ScoreData scoreData) {
    this.collectionData = collectionData;
    this.osuDBData = osuDBData;
    this.scoreData = scoreData;
  }
  
  /**
   * TODO Write getter description for getCollectionData
   *
   * @return a CollectionData.
   */
  public final CollectionData getCollectionData() {
    return this.collectionData;
  }
  
  /**
   * TODO Write getter description for getOsuDBData
   *
   * @return a OsuDBData.
   */
  public final OsuDBData getOsuDBData() {
    return this.osuDBData;
  }
  
  /**
   * TODO Write getter description for getScoreData
   *
   * @return a ScoreData.
   */
  public final ScoreData getScoreData() {
    return this.scoreData;
  }
  
}
