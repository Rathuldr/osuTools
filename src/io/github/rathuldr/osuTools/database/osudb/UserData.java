
package io.github.rathuldr.osuTools.database.osudb;

import java.time.LocalDateTime;

import io.github.rathuldr.osuTools.constants.ScoreGrade;

public class UserData {
  
  final ScoreGrade stdGrade;
  final ScoreGrade taikoGrade;
  final ScoreGrade ctbGrade;
  final ScoreGrade maniaGrade;
  final LocalDateTime lastPlayedTime;
  final short localOffsetMs;
  final char maniaScrollSpeed;
  final boolean ignoreBeatmapSounds;
  final boolean ignoreBeatmapSkin;
  final boolean disableVideo;
  final boolean visualOverride; // Does this mean disable storyboard?
  final boolean isUnplayed;
}
