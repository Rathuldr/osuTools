
package io.github.rathuldr.osuTools.constants;

public enum GameMode {
  STANDARD, TAIKO, CATCH_THE_BEAT, MANIA;
  
  public static final GameMode fromByteValue(final char parseChar) {
    switch (parseChar) {
      case 0:
        return GameMode.STANDARD;
      case 1:
        return GameMode.TAIKO;
      case 2:
        return GameMode.CATCH_THE_BEAT;
      case 3:
        return GameMode.MANIA;
      default:
        throw new IllegalArgumentException("GameMode translation received unknown byte value.");
    }
  }
}
