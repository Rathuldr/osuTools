
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;

import io.github.rathuldr.osuTools.sharedtypes.CreatorData;

public class CreationData {
  
  private final CreatorData creatorData;
  private final EditorData editorData;
  private final String songTitleFont;
  private final LocalDateTime lastModificationTime;
  
  /**
   * Constructs a new CreationData.
   * 
   * @param creatorData
   * @param editorData
   * @param songTitleFont
   * @param lastModificationTime
   */
  public CreationData(CreatorData creatorData, EditorData editorData, String songTitleFont, LocalDateTime lastModificationTime) {
    this.creatorData = creatorData;
    this.editorData = editorData;
    this.songTitleFont = songTitleFont;
    this.lastModificationTime = lastModificationTime;
  }
  
  /**
   * TODO Write getter description for getCreatorData
   *
   * @return a CreatorData.
   */
  public final CreatorData getCreatorData() {
    return this.creatorData;
  }
  
  /**
   * TODO Write getter description for getEditorData
   *
   * @return a EditorData.
   */
  public final EditorData getEditorData() {
    return this.editorData;
  }
  
  /**
   * TODO Write getter description for getSongTitleFont
   *
   * @return a String.
   */
  public final String getSongTitleFont() {
    return this.songTitleFont;
  }
  
  /**
   * TODO Write getter description for getLastModificationTime
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getLastModificationTime() {
    return this.lastModificationTime;
  }
  
}
