
package io.github.rathuldr.osuTools.constants;

public enum RankedStatus {
  UNKNOWN, UNSUBMITTED, PENDING, UNUSED, RANKED, APPROVED, QUALIFIED, LOVED;
  
  public static final RankedStatus fromByteValue(final char parseChar) {
    switch (parseChar) {
      case 0:
        return RankedStatus.UNKNOWN;
      case 1:
        return RankedStatus.UNSUBMITTED;
      case 2:
        return RankedStatus.PENDING;
      case 3:
        return RankedStatus.UNUSED;
      case 4:
        return RankedStatus.RANKED;
      case 5:
        return RankedStatus.APPROVED;
      case 6:
        return RankedStatus.QUALIFIED;
      case 7:
        return RankedStatus.LOVED;
      default:
        return RankedStatus.UNKNOWN;
    }
  }
}
