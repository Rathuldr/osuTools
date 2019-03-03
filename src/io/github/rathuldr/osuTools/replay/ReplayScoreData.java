
package io.github.rathuldr.osuTools.replay;

import java.util.ArrayList;

import io.github.rathuldr.osuTools.sharedtypes.IntDoublePair;
import io.github.rathuldr.osuTools.sharedtypes.JudgementCounts;

public final class ReplayScoreData {
  
  private final int score;
  private final short highestCombo;
  private final boolean isPerfectCombo;
  private final JudgementCounts judgements;
  private final ArrayList<IntDoublePair> lifebarGraph;
  private final ArrayList<ReplayTick> replayTicks;
  
  /**
   * Constructs a new ReplayScoreData.
   * 
   * @param score
   * @param highestCombo
   * @param isPerfectCombo
   * @param judgements
   * @param lifebarGraph
   * @param replayTicks
   */
  public ReplayScoreData(int score, short highestCombo, boolean isPerfectCombo, JudgementCounts judgements, ArrayList<IntDoublePair> lifebarGraph,
      ArrayList<ReplayTick> replayTicks) {
    this.score = score;
    this.highestCombo = highestCombo;
    this.isPerfectCombo = isPerfectCombo;
    this.judgements = judgements;
    this.lifebarGraph = lifebarGraph;
    this.replayTicks = replayTicks;
  }
  
  /**
   * TODO Write getter description for getScore
   *
   * @return a int.
   */
  public final int getScore() {
    return this.score;
  }
  
  /**
   * TODO Write getter description for getHighestCombo
   *
   * @return a short.
   */
  public final short getHighestCombo() {
    return this.highestCombo;
  }
  
  /**
   * TODO Write getter description for isPerfectCombo
   *
   * @return a boolean.
   */
  public final boolean isPerfectCombo() {
    return this.isPerfectCombo;
  }
  
  /**
   * TODO Write getter description for getJudgements
   *
   * @return a JudgementCounts.
   */
  public final JudgementCounts getJudgements() {
    return this.judgements;
  }
  
  /**
   * TODO Write getter description for getLifebarGraph
   *
   * @return a ArrayList<IntDoublePair>.
   */
  public final ArrayList<IntDoublePair> getLifebarGraph() {
    return this.lifebarGraph;
  }
  
  /**
   * TODO Write getter description for getReplayTicks
   *
   * @return a ArrayList<ReplayTick>.
   */
  public final ArrayList<ReplayTick> getReplayTicks() {
    return this.replayTicks;
  }

  /**
   * 
   * TODO Write description for unpackLifebarGraph
   * 
   * @param parseString
   * @return
   */
  public static ArrayList<IntDoublePair> unpackLifebarGraph(String parseString) {
    // TODO Auto-generated method stub
    return null;
  }
}
