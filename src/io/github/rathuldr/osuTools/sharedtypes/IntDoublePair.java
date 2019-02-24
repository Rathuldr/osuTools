
package io.github.rathuldr.osuTools.sharedtypes;

import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.GameplayMod;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class IntDoublePair {
  
  private final HashSet<GameplayMod> modCombination;
  private final double value;
  
  /**
   * Constructs a new IntDoublePair.
   * 
   * @param modCombination
   * @param value
   */
  public IntDoublePair(HashSet<GameplayMod> modCombination, double value) {
    this.modCombination = modCombination;
    this.value = value;
  }
  
  /**
   * TODO Write getter description for getModCombination
   *
   * @return a HashSet<GameplayMod>.
   */
  public final HashSet<GameplayMod> getModCombination() {
    return this.modCombination;
  }
  
  /**
   * TODO Write getter description for getValue
   *
   * @return a double.
   */
  public final double getValue() {
    return this.value;
  }
}
