
package io.github.rathuldr.osuTools.database.osudb;

import java.util.ArrayList;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.sharedtypes.TimingPoint;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class EditorData {
  
  private final ArrayList<TimingPoint> timingPoints;
  private final GameMode mode;
  private final String difficultyName;
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
  public EditorData(ArrayList<TimingPoint> timingPoints, GameMode mode, String difficultyName, double stackLeniency, int previewTimeMs) {
    this.timingPoints = timingPoints;
    this.mode = mode;
    this.difficultyName = difficultyName;
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
   * TODO Write getter description for getMode
   *
   * @return a GameMode.
   */
  public final GameMode getMode() {
    return this.mode;
  }
  
  /**
   * TODO Write getter description for getDifficultyName
   *
   * @return a String.
   */
  public final String getDifficultyName() {
    return this.difficultyName;
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
