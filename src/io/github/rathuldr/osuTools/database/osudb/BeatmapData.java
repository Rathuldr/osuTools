
package io.github.rathuldr.osuTools.database.osudb;

/**
 * TODO Write description for BeatmapData.
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 *
 */
public class BeatmapData {
  
  private final CreationData creationData;
  private final FilesysData filesysData;
  private final OnlineData onlineData;
  private final DifficultyData difficultyData;
  private final UserData userData;
  
  /**
   * Constructs a new BeatmapData.
   * 
   * @param creationData
   * @param filesysData
   * @param onlineData
   * @param difficultyData
   * @param userData
   */
  public BeatmapData(CreationData creationData, FilesysData filesysData, OnlineData onlineData, DifficultyData difficultyData, UserData userData) {
    this.creationData = creationData;
    this.filesysData = filesysData;
    this.onlineData = onlineData;
    this.difficultyData = difficultyData;
    this.userData = userData;
  }
  
  /**
   * TODO Write getter description for getCreationData
   *
   * @return a CreationData.
   */
  public final CreationData getCreationData() {
    return this.creationData;
  }
  
  /**
   * TODO Write getter description for getFilesysData
   *
   * @return a FilesysData.
   */
  public final FilesysData getFilesysData() {
    return this.filesysData;
  }
  
  /**
   * TODO Write getter description for getOnlineData
   *
   * @return a OnlineData.
   */
  public final OnlineData getOnlineData() {
    return this.onlineData;
  }
  
  /**
   * TODO Write getter description for getDifficultyData
   *
   * @return a DifficultyData.
   */
  public final DifficultyData getDifficultyData() {
    return this.difficultyData;
  }
  
  /**
   * TODO Write getter description for getUserData
   *
   * @return a UserData.
   */
  public final UserData getUserData() {
    return this.userData;
  }
  
}
