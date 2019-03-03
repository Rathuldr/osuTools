
package io.github.rathuldr.osuTools.constants;

import java.util.HashSet;

public enum GameplayMod {
  
  //@formatter:off
  NO_FAIL, EASY, TOUCH_DEVICE, HIDDEN, HARD_ROCK, SUDDEN_DEATH, DOUBLE_TIME, RELAX, HALF_TIME, NIGHTCORE,
  FLASHLIGHT, AUTOPLAY, SPUN_OUT, AUTO_PILOT, PERFECT, KEYS_1, KEYS_2, KEYS_3, KEYS_4, KEYS_5, KEYS_6,
  KEYS_7, KEYS_8, KEYS_9, KEYMOD_ON, FADE_IN, RANDOM, CINEMA, TARGET_PRACTICE, CO_OP;
  //@formatter:on
  
  public static final HashSet<GameplayMod> unpackFromBitField(int bitField) {
    final HashSet<GameplayMod> result = new HashSet<GameplayMod>();
    
    // FIXME: **** Finish unpackFromBitField in GameplayMod.java.
    for (int i = 0; i < 32; i++) {
      
    }
    
    return result;
  }
}

// See https://osu.ppy.sh/help/wiki/osu!_File_Formats/Osr_(file_format)#mods