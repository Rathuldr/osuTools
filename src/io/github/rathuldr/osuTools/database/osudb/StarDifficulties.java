
package io.github.rathuldr.osuTools.database.osudb;

import java.util.HashSet;

import io.github.rathuldr.osuTools.sharedtypes.IntDoublePair;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class StarDifficulties {
  
  private final HashSet<IntDoublePair> standardDiffs;
  private final HashSet<IntDoublePair> taikoDiffs;
  private final HashSet<IntDoublePair> ctbDiffs;
  private final HashSet<IntDoublePair> maniaDiffs;
  
  /**
   * Constructs a new StarDifficulties.
   * 
   * @param standardDiffs
   * @param taikoDiffs
   * @param ctbDiffs
   * @param maniaDiffs
   */
  public StarDifficulties(HashSet<IntDoublePair> standardDiffs, HashSet<IntDoublePair> taikoDiffs, HashSet<IntDoublePair> ctbDiffs,
      HashSet<IntDoublePair> maniaDiffs) {
    this.standardDiffs = standardDiffs;
    this.taikoDiffs = taikoDiffs;
    this.ctbDiffs = ctbDiffs;
    this.maniaDiffs = maniaDiffs;
  }
  
  /**
   * TODO Write getter description for getStandardDiffs
   *
   * @return a HashSet<IntDoublePair>.
   */
  public final HashSet<IntDoublePair> getStandardDiffs() {
    return this.standardDiffs;
  }
  
  /**
   * TODO Write getter description for getTaikoDiffs
   *
   * @return a HashSet<IntDoublePair>.
   */
  public final HashSet<IntDoublePair> getTaikoDiffs() {
    return this.taikoDiffs;
  }
  
  /**
   * TODO Write getter description for getCtbDiffs
   *
   * @return a HashSet<IntDoublePair>.
   */
  public final HashSet<IntDoublePair> getCtbDiffs() {
    return this.ctbDiffs;
  }
  
  /**
   * TODO Write getter description for getManiaDiffs
   *
   * @return a HashSet<IntDoublePair>.
   */
  public final HashSet<IntDoublePair> getManiaDiffs() {
    return this.maniaDiffs;
  }
}
