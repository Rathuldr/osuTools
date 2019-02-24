
package io.github.rathuldr.osuTools.replay;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ReplayData {
  
  private final ReplayMetadata metadata;
  private final ReplayOptions options;
  private final ReplayScoreData score;
  
  /**
   * Constructs a new ReplayData.
   * 
   * @param metadata
   * @param options
   * @param score
   */
  public ReplayData(ReplayMetadata metadata, ReplayOptions options, ReplayScoreData score) {
    this.metadata = metadata;
    this.options = options;
    this.score = score;
  }
  
  /**
   * TODO Write getter description for getMetadata
   *
   * @return a ReplayMetadata.
   */
  public final ReplayMetadata getMetadata() {
    return this.metadata;
  }
  
  /**
   * TODO Write getter description for getOptions
   *
   * @return a ReplayOptions.
   */
  public final ReplayOptions getOptions() {
    return this.options;
  }
  
  /**
   * TODO Write getter description for getScore
   *
   * @return a ReplayScoreData.
   */
  public final ReplayScoreData getScore() {
    return this.score;
  }
  
}