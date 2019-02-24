
package io.github.rathuldr.osuTools.sharedtypes;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class JudgementCounts {
  
  private final short numPerfects;
  private final short numCloses;
  private final short numWayOffs;
  private final short numGekiOrMaxes;
  private final short numKatuOrMania100s;
  private final short numMisses;
  
  /**
   * Constructs a new JudgementCounts.
   * 
   * @param numPerfects
   * @param numCloses
   * @param numWayOffs
   * @param numGekiOrMaxes
   * @param numKatuOrMania100s
   * @param numMisses
   */
  public JudgementCounts(short numPerfects, short numCloses, short numWayOffs, short numGekiOrMaxes, short numKatuOrMania100s, short numMisses) {
    this.numPerfects = numPerfects;
    this.numCloses = numCloses;
    this.numWayOffs = numWayOffs;
    this.numGekiOrMaxes = numGekiOrMaxes;
    this.numKatuOrMania100s = numKatuOrMania100s;
    this.numMisses = numMisses;
  }
  
  /**
   * TODO Write getter description for getNumPerfects
   *
   * @return a short.
   */
  public final short getNumPerfects() {
    return this.numPerfects;
  }
  
  /**
   * TODO Write getter description for getNumCloses
   *
   * @return a short.
   */
  public final short getNumCloses() {
    return this.numCloses;
  }
  
  /**
   * TODO Write getter description for getNumWayOffs
   *
   * @return a short.
   */
  public final short getNumWayOffs() {
    return this.numWayOffs;
  }
  
  /**
   * TODO Write getter description for getNumGekiOrMaxes
   *
   * @return a short.
   */
  public final short getNumGekiOrMaxes() {
    return this.numGekiOrMaxes;
  }
  
  /**
   * TODO Write getter description for getNumKatuOrMania100s
   *
   * @return a short.
   */
  public final short getNumKatuOrMania100s() {
    return this.numKatuOrMania100s;
  }
  
  /**
   * TODO Write getter description for getNumMisses
   *
   * @return a short.
   */
  public final short getNumMisses() {
    return this.numMisses;
  }
}
