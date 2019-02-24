
package io.github.rathuldr.osuTools.beatmap;

import java.util.ArrayList;

import io.github.rathuldr.osuTools.constants.SampleSet;

public final class BeatmapEditorData {
  
  private final ArrayList<Integer> editorBookmarks;
  private final SampleSet sampleSet;
  private final double distanceSpacing;
  private final int beatDivisor;
  private final int gridSize;
  private final int timelineZoom;
  
  /**
   * Constructs a new BeatmapEditorData.
   * 
   * @param editorBookmarks
   * @param sampleSet
   * @param distanceSpacing
   * @param beatDivisor
   * @param gridSize
   * @param timelineZoom
   */
  public BeatmapEditorData(ArrayList<Integer> editorBookmarks, SampleSet sampleSet, double distanceSpacing, int beatDivisor, int gridSize, int timelineZoom) {
    this.editorBookmarks = editorBookmarks;
    this.sampleSet = sampleSet;
    this.distanceSpacing = distanceSpacing;
    this.beatDivisor = beatDivisor;
    this.gridSize = gridSize;
    this.timelineZoom = timelineZoom;
  }
  
  /**
   * TODO Write getter description for getEditorBookmarks
   *
   * @return a ArrayList<Integer>.
   */
  public final ArrayList<Integer> getEditorBookmarks() {
    return this.editorBookmarks;
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
   * TODO Write getter description for getDistanceSpacing
   *
   * @return a double.
   */
  public final double getDistanceSpacing() {
    return this.distanceSpacing;
  }
  
  /**
   * TODO Write getter description for getBeatDivisor
   *
   * @return a int.
   */
  public final int getBeatDivisor() {
    return this.beatDivisor;
  }
  
  /**
   * TODO Write getter description for getGridSize
   *
   * @return a int.
   */
  public final int getGridSize() {
    return this.gridSize;
  }
  
  /**
   * TODO Write getter description for getTimelineZoom
   *
   * @return a int.
   */
  public final int getTimelineZoom() {
    return this.timelineZoom;
  }
  
}
