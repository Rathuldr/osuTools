
package io.github.rathuldr.osuTools.database.scoresdb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashSet;

import javax.swing.JProgressBar;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.constants.GameplayMod;
import io.github.rathuldr.osuTools.sharedtypes.JudgementCounts;
import io.github.rathuldr.osuTools.util.LEBinaryParser;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class ScoreData {
  
  private final int version;
  private final HashSet<BeatmapScoreEntry> beatmaps;
  
  /**
   * Constructs a new ScoreData.
   * 
   * @param version
   * @param beatmaps
   */
  public ScoreData(int version, HashSet<BeatmapScoreEntry> beatmaps) {
    this.version = version;
    this.beatmaps = beatmaps;
  }
  
  /**
   * TODO Write getter description for getVersion
   *
   * @return a int.
   */
  public final int getVersion() {
    return this.version;
  }
  
  /**
   * TODO Write getter description for getBeatmaps
   *
   * @return a HashSet<BeatmapScoreEntry>.
   */
  public final HashSet<BeatmapScoreEntry> getBeatmaps() {
    return this.beatmaps;
  }
  
  /**
   * TODO Write description for loadFromFile
   * 
   * @param dbFile
   * @param progBar
   * @return
   * @throws IOException
   */
  public static final ScoreData loadFromFile(final File dbFile, final JProgressBar progBar) throws IOException {
    
    // Read the file into a byte array
    final Path scoreDBPath = Paths.get(dbFile.getAbsolutePath());
    byte[] scoreDBData = Files.readAllBytes(scoreDBPath);
    if (scoreDBData == null) {
      throw new NullPointerException("" + dbFile.getAbsolutePath() + "\" is empty.");
    }
    
    // Open a C# data parser on the replay data contents
    final LEBinaryParser parser = new LEBinaryParser(scoreDBData);
    
    final int version = parser.parseInt();
    final int numBeatmaps = parser.parseInt();
    
    // Set up the progress bar
    progBar.setMaximum(numBeatmaps);
    progBar.setIndeterminate(false);
    
    // For each beatmap
    final HashSet<BeatmapScoreEntry> beatmapScores = new HashSet<BeatmapScoreEntry>();
    for (int i = 0; i < numBeatmaps; i++) {
      
      final String beatmapHash = parser.parseString();
      final int numScores = parser.parseInt();
      
      // For each score on that beatmap
      final HashSet<ScoreEntry> scoreSet = new HashSet<ScoreEntry>();
      for (int j = 0; j < numScores; j++) {
        
        GameMode mode = null;
        try {
          mode = GameMode.fromByteValue(parser.parseChar());
        } catch (final IllegalArgumentException ia) {
          System.out.println("Hash=\"" + beatmapHash + "\"");
        }
        
        final int scoreVersion = parser.parseInt();
        final String beatmapHash2 = parser.parseString();
        final String playerName = parser.parseString();
        final String replayHash = parser.parseString();
        final short num300s = parser.parseShort();
        final short num100s = parser.parseShort();
        final short num50s = parser.parseShort();
        final short numGeki = parser.parseShort();
        final short numKatu = parser.parseShort();
        final short numMisses = parser.parseShort();
        final int score = parser.parseInt();
        final short maxCombo = parser.parseShort();
        final boolean isPerfectCombo = parser.parseCharAsBoolean();
        final HashSet<GameplayMod> mods = GameplayMod.unpackFromBitField(parser.parseInt());
        parser.parseString();
        final LocalDateTime timestamp = parser.parseDateTime();
        parser.parseInt();
        final long onlineID = parser.parseLong();
        
        final JudgementCounts judgements = new JudgementCounts(num300s, num100s, num50s, numGeki, numKatu, numMisses);
        
        final ScoreEntry entry = new ScoreEntry(mode, scoreVersion, beatmapHash2, playerName, replayHash, judgements, score, maxCombo, isPerfectCombo, mods,
            timestamp, onlineID);
        
        scoreSet.add(entry);
      }
      
      // Rarely, there may be an extra 8 bytes after a beatmap's scores. This exploits the fact that a String must come
      // next (next byte must be 0x0B) to check for these extra bytes.
      if (!parser.isAtEndOfStream()) {
        final char nextMapByte = parser.peekByte();
        if (nextMapByte != LEBinaryParser.STRING_START_BYTE) {
          parser.parseLong();
        }
        
      }
      
      final BeatmapScoreEntry bse = new BeatmapScoreEntry(beatmapHash, scoreSet);
      beatmapScores.add(bse);
      
      // Increment the progress bar
      progBar.setValue(progBar.getValue() + 1);
      
    }
    
    final ScoreData result = new ScoreData(version, beatmapScores);
    return result;
  }
}
