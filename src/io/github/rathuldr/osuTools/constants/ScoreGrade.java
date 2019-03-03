
package io.github.rathuldr.osuTools.constants;

public enum ScoreGrade {
  XH, X, SH, S, A, B, C, D, F, UNKNOWN;
  
  // FIXME: This may be wrong. The documentation doesn't specify ascending/descending order.
  // TODO: 0x05 is a B, 0x09 is nothing
  public static final ScoreGrade fromByteValue(final char parseChar) {
    switch (parseChar) {
      case 0:
        return ScoreGrade.XH;
      case 1:
        return ScoreGrade.SH;
      case 2:
        return ScoreGrade.X;
      case 3:
        return ScoreGrade.S;
      case 4:
        return ScoreGrade.A;
      case 5:
        return ScoreGrade.B;
      case 6:
        return ScoreGrade.C;
      case 7:
        return ScoreGrade.D;
      case 8:
        return ScoreGrade.F;
      default:
        return ScoreGrade.UNKNOWN;
    }
  }
}
