
package io.github.rathuldr.osuTools.replay;

import java.util.ArrayList;
import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.GameKey;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ReplayTick {
  
  private final long timeDelta;
  private final double xPos;
  private final double yPos;
  private final HashSet<GameKey> keyCombo;
  
  /**
   * Constructs a new ReplayTick.
   * 
   * @param timeDelta
   * @param xPos
   * @param yPos
   * @param keyCombo
   */
  public ReplayTick(long timeDelta, double xPos, double yPos, HashSet<GameKey> keyCombo) {
    this.timeDelta = timeDelta;
    this.xPos = xPos;
    this.yPos = yPos;
    this.keyCombo = keyCombo;
  }
  
  /**
   * TODO Write getter description for getTimeDelta
   *
   * @return a long.
   */
  public final long getTimeDelta() {
    return this.timeDelta;
  }
  
  /**
   * TODO Write getter description for getxPos
   *
   * @return a double.
   */
  public final double getxPos() {
    return this.xPos;
  }
  
  /**
   * TODO Write getter description for getyPos
   *
   * @return a double.
   */
  public final double getyPos() {
    return this.yPos;
  }
  
  /**
   * TODO Write getter description for getKeyCombo
   *
   * @return a HashSet<GameKey>.
   */
  public final HashSet<GameKey> getKeyCombo() {
    return this.keyCombo;
  }
  
  /**
   * 
   * TODO Write description for uncompressReplayTicks
   * 
   * @param parseByteArray
   * @return
   */
  public static final ArrayList<ReplayTick> uncompressReplayTicks(final Object parseByteArray) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
