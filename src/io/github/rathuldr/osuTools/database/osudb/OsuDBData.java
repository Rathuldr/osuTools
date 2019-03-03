
package io.github.rathuldr.osuTools.database.osudb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JProgressBar;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.constants.GameplayMod;
import io.github.rathuldr.osuTools.constants.RankedStatus;
import io.github.rathuldr.osuTools.constants.ScoreGrade;
import io.github.rathuldr.osuTools.sharedtypes.CreatorData;
import io.github.rathuldr.osuTools.sharedtypes.DifficultyMetadata;
import io.github.rathuldr.osuTools.sharedtypes.IntDoublePair;
import io.github.rathuldr.osuTools.sharedtypes.TimingPoint;
import io.github.rathuldr.osuTools.util.LEBinaryParser;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public class OsuDBData {
  
  private static final int FORMAT_CHANGE_VER = 20140609;
  
  private final int osuVersion;
  private final int folderCount;
  private final boolean accountUnlocked;
  private final LocalDateTime accountUnlockTime;
  private final String playerName;
  private final HashSet<BeatmapData> beatmapData;
  
  /**
   * Constructs a new OsuDBData.
   * 
   * @param osuVersion
   * @param folderCount
   * @param accountUnlocked
   * @param accountUnlockTime
   * @param playerName
   * @param beatmapData
   */
  public OsuDBData(int osuVersion, int folderCount, boolean accountUnlocked, LocalDateTime accountUnlockTime, String playerName,
      HashSet<BeatmapData> beatmapData) {
    this.osuVersion = osuVersion;
    this.folderCount = folderCount;
    this.accountUnlocked = accountUnlocked;
    this.accountUnlockTime = accountUnlockTime;
    this.playerName = playerName;
    this.beatmapData = beatmapData;
  }
  
  /**
   * TODO Write getter description for getOsuVersion
   *
   * @return a int.
   */
  public final int getOsuVersion() {
    return this.osuVersion;
  }
  
  /**
   * TODO Write getter description for getFolderCount
   *
   * @return a int.
   */
  public final int getFolderCount() {
    return this.folderCount;
  }
  
  /**
   * TODO Write getter description for isAccountUnlocked
   *
   * @return a boolean.
   */
  public final boolean isAccountUnlocked() {
    return this.accountUnlocked;
  }
  
  /**
   * TODO Write getter description for getAccountUnlockTime
   *
   * @return a LocalDateTime.
   */
  public final LocalDateTime getAccountUnlockTime() {
    return this.accountUnlockTime;
  }
  
  /**
   * TODO Write getter description for getPlayerName
   *
   * @return a String.
   */
  public final String getPlayerName() {
    return this.playerName;
  }
  
  /**
   * TODO Write getter description for getBeatmapData
   *
   * @return a HashSet<BeatmapData>.
   */
  public final HashSet<BeatmapData> getBeatmapData() {
    return this.beatmapData;
  }
  
  /**
   * TODO Write description for loadFromFile
   * 
   * @param dbFile
   * @param progBar
   * @return
   * @throws IOException
   */
  public static final OsuDBData loadFromFile(final File dbFile, final JProgressBar progBar) throws IOException {
    
    // Read the file into a byte array
    final Path osuDBPath = Paths.get(dbFile.getAbsolutePath());
    byte[] osuDBData = Files.readAllBytes(osuDBPath);
    if (osuDBData == null) {
      throw new NullPointerException("" + dbFile.getAbsolutePath() + "\" is empty.");
    }
    
    // Open a C# data parser on the replay data contents
    final LEBinaryParser parser = new LEBinaryParser(osuDBData);
    
    final int version = parser.parseInt();
    final int folderCount = parser.parseInt();
    final boolean acctUnlocked = parser.parseCharAsBoolean();
    final LocalDateTime unlockTime = parser.parseDateTime();
    final String playerName = parser.parseString();
    final int numBeatmaps = parser.parseInt();
    
    // Now that we know a maximum value for the progress bar, set it
    progBar.setMaximum(numBeatmaps);
    progBar.setIndeterminate(false);
    
    parser.parseInt();
    
    // Go through every beatmap's data
    final HashSet<BeatmapData> beatmapSet = new HashSet<BeatmapData>();
    for (int i = 0; i < numBeatmaps; i++) {
      
      final String artist = parser.parseString();
      
      final String artistUni = parser.parseString();
      final String songTitle = parser.parseString();
      final String songTitleUni = parser.parseString();
      final String creator = parser.parseString();
      final String difficulty = parser.parseString();
      
      final String audioFileName = parser.parseString();
      final String beatmapHash = parser.parseString();
      final String osuFileName = parser.parseString();
      final RankedStatus rankedStatus = RankedStatus.fromByteValue(parser.parseChar());
      
      final short numHitCircles = parser.parseShort();
      final short numSliders = parser.parseShort();
      final short numSpinners = parser.parseShort();
      
      final LocalDateTime lastModTime = parser.parseDateTime();
      
      // AR, CS, HP, and OD require conditional parsing -- changed to floating point after 06/09/2014
      double approachRate = -1;
      double circleSize = -1;
      double hpDrain = -1;
      double overallDiff = -1;
      if (version < FORMAT_CHANGE_VER) {
        approachRate = parser.parseChar();
        circleSize = parser.parseChar();
        hpDrain = parser.parseChar();
        overallDiff = parser.parseChar();
      } else {
        approachRate = parser.parseFloat();
        circleSize = parser.parseFloat();
        hpDrain = parser.parseFloat();
        overallDiff = parser.parseFloat();
      }
      
      final double sliderVelocity = parser.parseDouble();
      
      // Parse calculated star difficulties
      HashSet<IntDoublePair> stdStarDiffs = null;
      HashSet<IntDoublePair> taikoStarDiffs = null;
      HashSet<IntDoublePair> ctbStarDiffs = null;
      HashSet<IntDoublePair> maniaStarDiffs = null;
      if (version >= FORMAT_CHANGE_VER) {
        
        // Parse standard star diffs
        stdStarDiffs = new HashSet<IntDoublePair>();
        final int stdPermCount = parser.parseInt();
        
        for (int perm = 0; perm < stdPermCount; perm++) {
          
          final IntDoublePair idp = parser.parseIntDoublePair();
          stdStarDiffs.add(idp);
        }
        
        // Parse taiko star diffs
        taikoStarDiffs = new HashSet<IntDoublePair>();
        final int taikoPermCount = parser.parseInt();
        for (int perm = 0; perm < taikoPermCount; perm++) {
          
          final IntDoublePair idp = parser.parseIntDoublePair();
          taikoStarDiffs.add(idp);
        }
        
        // Parse ctb star diffs
        ctbStarDiffs = new HashSet<IntDoublePair>();
        final int ctbPermCount = parser.parseInt();
        for (int perm = 0; perm < ctbPermCount; perm++) {
          
          final IntDoublePair idp = parser.parseIntDoublePair();
          ctbStarDiffs.add(idp);
        }
        
        // Parse mania star diffs
        maniaStarDiffs = new HashSet<IntDoublePair>();
        final int maniaPermCount = parser.parseInt();
        for (int perm = 0; perm < maniaPermCount; perm++) {
          
          final IntDoublePair idp = parser.parseIntDoublePair();
          maniaStarDiffs.add(idp);
        }
        
      }
      
      final int drainTime = parser.parseInt();
      final int totalTimeMs = parser.parseInt();
      final int previewTime = parser.parseInt();
      
      // Parse timing points
      final ArrayList<TimingPoint> timingPoints = new ArrayList<TimingPoint>();
      final int numTimingPoints = parser.parseInt();
      for (int currTp = 0; currTp < numTimingPoints; currTp++) {
        final double bpm = parser.parseDouble();
        final double offset = parser.parseDouble();
        final boolean inherited = parser.parseCharAsBoolean();
        final TimingPoint tp = new TimingPoint(bpm, offset, inherited);
        timingPoints.add(tp);
      }
      
      final int beatmapID = parser.parseInt();
      final int beatmapSetID = parser.parseInt();
      final int threadID = parser.parseInt();
      final ScoreGrade stdGrade = ScoreGrade.fromByteValue(parser.parseChar());
      final ScoreGrade taikoGrade = ScoreGrade.fromByteValue(parser.parseChar());
      final ScoreGrade ctbGrade = ScoreGrade.fromByteValue(parser.parseChar());
      final ScoreGrade maniaGrade = ScoreGrade.fromByteValue(parser.parseChar());
      final short localOffset = parser.parseShort();
      final double stackLeniency = parser.parseFloat();
      final GameMode mode = GameMode.fromByteValue(parser.parseChar());
      final String source = parser.parseString();
      
      // Parse and process beatmap tags
      final HashSet<String> tags = new HashSet<String>();
      final String tagStr = parser.parseString();
      final String[] tagTokens = tagStr.split("\\s+");
      for (final String s : tagTokens) {
        tags.add(s);
      }
      
      final short onlineOffset = parser.parseShort();
      final String titleFont = parser.parseString();
      final boolean isUnplayed = parser.parseCharAsBoolean();
      final LocalDateTime lastPlayTime = parser.parseDateTime();
      final boolean isOsz2 = parser.parseCharAsBoolean();
      final String folderName = parser.parseString();
      final LocalDateTime lastOnlineCheck = parser.parseDateTime();
      final boolean ignoreSound = parser.parseCharAsBoolean();
      final boolean ignoreSkin = parser.parseCharAsBoolean();
      final boolean disableStoryboard = parser.parseCharAsBoolean();
      final boolean disableVideo = parser.parseCharAsBoolean();
      final boolean visualOverride = parser.parseCharAsBoolean();
      
      // Parse some unknown value that existed before 06/09/2014
      if (version < FORMAT_CHANGE_VER) {
        parser.parseShort();
      }
      
      parser.parseInt();
      final char maniaScrollSpeed = parser.parseChar();
      
      parser.parseInt();
      
      final StarDifficulties starDiffs = new StarDifficulties(stdStarDiffs, taikoStarDiffs, ctbStarDiffs, maniaStarDiffs);
      final DifficultyMetadata diffMeta = new DifficultyMetadata(approachRate, circleSize, hpDrain, overallDiff);
      final ContentData contentData = new ContentData(diffMeta, mode, difficulty, sliderVelocity);
      final CreatorData creatorData = new CreatorData(artist, artistUni, songTitle, songTitleUni, creator);
      final EditorData editorData = new EditorData(timingPoints, stackLeniency, previewTime);
      final CreationData creationData = new CreationData(creatorData, editorData, titleFont, lastModTime);
      final ObjectCounts objectCounts = new ObjectCounts(numHitCircles, numSliders, numSpinners);
      final DifficultyData diffData = new DifficultyData(objectCounts, diffMeta, starDiffs, sliderVelocity, drainTime, totalTimeMs);
      final FilesysData filesysData = new FilesysData(audioFileName, beatmapHash, osuFileName, folderName);
      final OnlineData onlineData = new OnlineData(rankedStatus, source, tags, lastOnlineCheck, beatmapID, beatmapSetID, threadID, onlineOffset, isOsz2);
      final UserData userData = new UserData(stdGrade, taikoGrade, ctbGrade, maniaGrade, lastPlayTime, localOffset, maniaScrollSpeed, ignoreSound, ignoreSkin,
          disableVideo, visualOverride, isUnplayed);
      final BeatmapData beatmapData = new BeatmapData(creationData, filesysData, onlineData, diffData, userData);
      
      beatmapSet.add(beatmapData);
      progBar.setValue(progBar.getValue() + 1);
    }
    
    final OsuDBData result = new OsuDBData(version, folderCount, acctUnlocked, unlockTime, playerName, beatmapSet);
    return result;
  }
  
}
