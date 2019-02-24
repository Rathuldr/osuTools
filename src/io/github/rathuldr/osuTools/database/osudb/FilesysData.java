
package io.github.rathuldr.osuTools.database.osudb;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class FilesysData {
  
  private final String audioFileName;
  private final String beatmapHash;
  private final String osuFileName;
  private final String folderName;
  
  /**
   * Constructs a new FilesysData.
   * 
   * @param audioFileName
   * @param beatmapHash
   * @param osuFileName
   * @param folderName
   */
  public FilesysData(String audioFileName, String beatmapHash, String osuFileName, String folderName) {
    this.audioFileName = audioFileName;
    this.beatmapHash = beatmapHash;
    this.osuFileName = osuFileName;
    this.folderName = folderName;
  }
  
  /**
   * TODO Write getter description for getAudioFileName
   *
   * @return a String.
   */
  public final String getAudioFileName() {
    return this.audioFileName;
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
   * TODO Write getter description for getOsuFileName
   *
   * @return a String.
   */
  public final String getOsuFileName() {
    return this.osuFileName;
  }
  
  /**
   * TODO Write getter description for getFolderName
   *
   * @return a String.
   */
  public final String getFolderName() {
    return this.folderName;
  }
}
