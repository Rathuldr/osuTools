
package io.github.rathuldr.osuTools.sharedtypes;

public class CreatorData {
  
  private final String artistName;
  private final String artistNameUnicode;
  private final String songTitle;
  private final String songTitleUnicode;
  private final String creatorName;
  
  /**
   * Constructs a new CreatorData.
   * 
   * @param artistName
   * @param artistNameUnicode
   * @param songTitle
   * @param songTitleUnicode
   * @param creatorName
   */
  public CreatorData(String artistName, String artistNameUnicode, String songTitle, String songTitleUnicode, String creatorName) {
    this.artistName = artistName;
    this.artistNameUnicode = artistNameUnicode;
    this.songTitle = songTitle;
    this.songTitleUnicode = songTitleUnicode;
    this.creatorName = creatorName;
  }
  
  /**
   * TODO Write getter description for getArtistName
   *
   * @return a String.
   */
  public final String getArtistName() {
    return this.artistName;
  }
  
  /**
   * TODO Write getter description for getArtistNameUnicode
   *
   * @return a String.
   */
  public final String getArtistNameUnicode() {
    return this.artistNameUnicode;
  }
  
  /**
   * TODO Write getter description for getSongTitle
   *
   * @return a String.
   */
  public final String getSongTitle() {
    return this.songTitle;
  }
  
  /**
   * TODO Write getter description for getSongTitleUnicode
   *
   * @return a String.
   */
  public final String getSongTitleUnicode() {
    return this.songTitleUnicode;
  }
  
  /**
   * TODO Write getter description for getCreatorName
   *
   * @return a String.
   */
  public final String getCreatorName() {
    return this.creatorName;
  }
  
}
