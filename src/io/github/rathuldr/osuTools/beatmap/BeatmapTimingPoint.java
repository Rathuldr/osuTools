
package io.github.rathuldr.osuTools.beatmap;

import io.github.rathuldr.osuTools.constants.SampleSet;

public class BeatmapTimingPoint {
  
  private final int offsetMs;
  private final double msPerBeat;
  private final int timeSignature;
  private final SampleSet sampleSet;
  private final int defaultCustomIndex;
  private final int defaultHitsoundVolume;
  private final boolean isInherited;
  private final boolean isKiai;
  
  /**
   * Constructs a new BeatmapTimingPoint.
   * 
   * @param offsetMs
   * @param msPerBeat
   * @param timeSignature
   * @param sampleSet
   * @param defaultCustomIndex
   * @param defaultHitsoundVolume
   * @param isInherited
   * @param isKiai
   */
  public BeatmapTimingPoint(int offsetMs, double msPerBeat, int timeSignature, SampleSet sampleSet, int defaultCustomIndex, int defaultHitsoundVolume,
      boolean isInherited, boolean isKiai) {
    this.offsetMs = offsetMs;
    this.msPerBeat = msPerBeat;
    this.timeSignature = timeSignature;
    this.sampleSet = sampleSet;
    this.defaultCustomIndex = defaultCustomIndex;
    this.defaultHitsoundVolume = defaultHitsoundVolume;
    this.isInherited = isInherited;
    this.isKiai = isKiai;
  }
  
  /**
   * TODO Write getter description for getOffsetMs
   *
   * @return a int.
   */
  public final int getOffsetMs() {
    return this.offsetMs;
  }
  
  /**
   * TODO Write getter description for getMsPerBeat
   *
   * @return a double.
   */
  public final double getMsPerBeat() {
    return this.msPerBeat;
  }
  
  /**
   * TODO Write getter description for getTimeSignature
   *
   * @return a int.
   */
  public final int getTimeSignature() {
    return this.timeSignature;
  }
  
  /**
   * TODO Write getter description for getSampleSet
   *
   * @return a SampleSet.
   */
  public final SampleSet getSampleSet() {
    return this.sampleSet;
  }
  
  /**
   * TODO Write getter description for getDefaultCustomIndex
   *
   * @return a int.
   */
  public final int getDefaultCustomIndex() {
    return this.defaultCustomIndex;
  }
  
  /**
   * TODO Write getter description for getDefaultHitsoundVolume
   *
   * @return a int.
   */
  public final int getDefaultHitsoundVolume() {
    return this.defaultHitsoundVolume;
  }
  
  /**
   * TODO Write getter description for isInherited
   *
   * @return a boolean.
   */
  public final boolean isInherited() {
    return this.isInherited;
  }
  
  /**
   * TODO Write getter description for isKiai
   *
   * @return a boolean.
   */
  public final boolean isKiai() {
    return this.isKiai;
  }
}
