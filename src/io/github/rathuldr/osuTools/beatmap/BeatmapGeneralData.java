
package io.github.rathuldr.osuTools.beatmap;

public final class BeatmapGeneralData {
  
  private final short osuFileFormat;
  private final String audioFilePath;
  private final int audioLeadInMs;
  private final int audioPreviewTime;
  private final int countdownOffset;
  private final boolean doCountdown;
  private final boolean epilepsyWarning;
  
  /**
   * Constructs a new BeatmapGeneralData.
   * 
   * @param osuFileFormat
   * @param audioFilePath
   * @param audioLeadInMs
   * @param audioPreviewTime
   * @param countdownOffset
   * @param doCountdown
   * @param epilepsyWarning
   */
  public BeatmapGeneralData(short osuFileFormat, String audioFilePath, int audioLeadInMs, int audioPreviewTime, int countdownOffset, boolean doCountdown,
      boolean epilepsyWarning) {
    this.osuFileFormat = osuFileFormat;
    this.audioFilePath = audioFilePath;
    this.audioLeadInMs = audioLeadInMs;
    this.audioPreviewTime = audioPreviewTime;
    this.countdownOffset = countdownOffset;
    this.doCountdown = doCountdown;
    this.epilepsyWarning = epilepsyWarning;
  }
  
  /**
   * TODO Write getter description for getOsuFileFormat
   *
   * @return a short.
   */
  public final short getOsuFileFormat() {
    return this.osuFileFormat;
  }
  
  /**
   * TODO Write getter description for getAudioFilePath
   *
   * @return a String.
   */
  public final String getAudioFilePath() {
    return this.audioFilePath;
  }
  
  /**
   * TODO Write getter description for getAudioLeadInMs
   *
   * @return a int.
   */
  public final int getAudioLeadInMs() {
    return this.audioLeadInMs;
  }
  
  /**
   * TODO Write getter description for getAudioPreviewTime
   *
   * @return a int.
   */
  public final int getAudioPreviewTime() {
    return this.audioPreviewTime;
  }
  
  /**
   * TODO Write getter description for getCountdownOffset
   *
   * @return a int.
   */
  public final int getCountdownOffset() {
    return this.countdownOffset;
  }
  
  /**
   * TODO Write getter description for isDoCountdown
   *
   * @return a boolean.
   */
  public final boolean isDoCountdown() {
    return this.doCountdown;
  }
  
  /**
   * TODO Write getter description for isEpilepsyWarning
   *
   * @return a boolean.
   */
  public final boolean isEpilepsyWarning() {
    return this.epilepsyWarning;
  }
}
