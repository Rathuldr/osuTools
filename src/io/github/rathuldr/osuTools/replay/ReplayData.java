
package io.github.rathuldr.osuTools.replay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.constants.GameplayMod;
import io.github.rathuldr.osuTools.sharedtypes.IntDoublePair;
import io.github.rathuldr.osuTools.sharedtypes.JudgementCounts;
import io.github.rathuldr.osuTools.util.LEBinaryParser;

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
  
  /**
   * Parses an .osr file and returns its replay data.
   * 
   * @param filepath The absolute path to the replay file.
   * @return a populated {@link ReplayData} object.
   * @throws IOException
   */
  public static final ReplayData parseReplay(final String filepath) throws IOException {
    
    // Read the file into a byte array
    final File replayFile = new File(filepath);
    final Path replayPath = Paths.get(replayFile.getAbsolutePath());
    byte[] replayData = Files.readAllBytes(replayPath);
    if (replayData == null) {
      throw new NullPointerException("Replay file \"" + replayFile.getAbsolutePath() + "\" is null.");
    }
    
    // Open a C# data parser on the replay data contents
    final LEBinaryParser parser = new LEBinaryParser(replayData);
    
    // Parse each data segment in the replay file
    final GameMode mode = GameMode.fromByteValue(parser.parseChar());
    final int version = parser.parseInt();
    final String beatmapHash = parser.parseString();
    final String playerName = parser.parseString();
    final String replayHash = parser.parseString();
    final short num300s = parser.parseShort();
    final short num100s = parser.parseShort();
    final short num50s = parser.parseShort();
    final short numGekis = parser.parseShort();
    final short numKatus = parser.parseShort();
    final short numMisses = parser.parseShort();
    final int score = parser.parseInt();
    final short highestCombo = parser.parseShort();
    final boolean isPerfectCombo = parser.parseCharAsBoolean();
    final HashSet<GameplayMod> modsUsed = GameplayMod.unpackFromBitField(parser.parseInt());
    final ArrayList<IntDoublePair> lifebarGraph = ReplayScoreData.unpackLifebarGraph(parser.parseString());
    final LocalDateTime timestamp = parser.parseDateTime();
    final ArrayList<ReplayTick> replayTicks = ReplayTick.uncompressReplayTicks(parser.parseByteArray());
    final long onlineScoreID = parser.parseLong();
    
    // Pack each data segment into their respective replay data sub-objects
    final JudgementCounts judgements = new JudgementCounts(num300s, num100s, num50s, numGekis, numKatus, numMisses);
    final ReplayMetadata metadata = new ReplayMetadata(version, beatmapHash, playerName, replayHash, onlineScoreID, timestamp);
    final ReplayOptions options = new ReplayOptions(mode, modsUsed);
    final ReplayScoreData scoreData = new ReplayScoreData(score, highestCombo, isPerfectCombo, judgements, lifebarGraph, replayTicks);
    
    // Return the packed data structure
    return new ReplayData(metadata, options, scoreData);
  }
  
}
