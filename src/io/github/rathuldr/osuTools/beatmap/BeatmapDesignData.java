
package io.github.rathuldr.osuTools.beatmap;

/**
 * Contains editor and visual data for the beatmap.
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 24, 2019
 */
public class BeatmapDesignData {
  
  /** Editor data, such as the beat divisor and bookmarks. */
  private final BeatmapEditorData editorData;
  
  /** Visual data, such as combo colors, what the preferred skin is, and storyboard options. */
  private final BeatmapAestheticData aestheticData;
  
  /**
   * Constructs a new BeatmapDesignData.
   * 
   * @param editorData Editor data, such as the beat divisor and bookmarks.
   * @param aestheticData Visual data, such as combo colors, what the preferred skin is, and storyboard options.
   */
  public BeatmapDesignData(BeatmapEditorData editorData, BeatmapAestheticData aestheticData) {
    this.editorData = editorData;
    this.aestheticData = aestheticData;
  }
  
  /**
   * Gets the editor data, such as the beat divisor and bookmarks.
   *
   * @return a BeatmapEditorData.
   */
  public final BeatmapEditorData getEditorData() {
    return this.editorData;
  }
  
  /**
   * Gets the visual data, such as combo colors, what the preferred skin is, and storyboard options.
   *
   * @return a BeatmapAestheticData.
   */
  public final BeatmapAestheticData getAestheticData() {
    return this.aestheticData;
  }
  
}
