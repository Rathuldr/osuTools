
package io.github.rathuldr.osuTools.database.osudb;

import java.util.ArrayList;

import io.github.rathuldr.osuTools.sharedtypes.TimingPoint;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class EditorData {
  
  private final ArrayList<TimingPoint> timingPoints;
  private final double stackLeniency;
  private final int previewTimeMs;
  
  /**
   * Constructs a new EditorData.
   * 
   * @param timingPoints
   * @param mode
   * @param difficultyName
   * @param stackLeniency
   * @param previewTimeMs
   */
  public EditorData(ArrayList<TimingPoint> timingPoints, double stackLeniency, int previewTimeMs) {
    this.timingPoints = timingPoints;
    this.stackLeniency = stackLeniency;
    this.previewTimeMs = previewTimeMs;
  }
  
  /**
   * TODO Write getter description for getTimingPoints
   *
   * @return a ArrayList<TimingPoint>.
   */
  public final ArrayList<TimingPoint> getTimingPoints() {
    return this.timingPoints;
  }
  
  /**
   * TODO Write getter description for getStackLeniency
   *
   * @return a double.
   */
  public final double getStackLeniency() {
    return this.stackLeniency;
  }
  
  /**
   * TODO Write getter description for getPreviewTimeMs
   *
   * @return a int.
   */
  public final int getPreviewTimeMs() {
    return this.previewTimeMs;
  }
  
}
