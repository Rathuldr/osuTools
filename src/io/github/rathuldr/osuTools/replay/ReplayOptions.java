
package io.github.rathuldr.osuTools.replay;

import java.util.HashSet;

import io.github.rathuldr.osuTools.constants.GameMode;
import io.github.rathuldr.osuTools.constants.GameplayMod;

public final class ReplayOptions {
  
  private final GameMode gameMode;
  private final HashSet<GameplayMod> modsUsed;
  
  /**
   * Constructs a new ReplayOptions.
   * 
   * @param gameMode
   * @param modsUsed
   */
  public ReplayOptions(GameMode gameMode, HashSet<GameplayMod> modsUsed) {
    this.gameMode = gameMode;
    this.modsUsed = modsUsed;
  }
  
  /**
   * TODO Write getter description for getGameMode
   *
   * @return a GameMode.
   */
  public final GameMode getGameMode() {
    return this.gameMode;
  }
  
  /**
   * TODO Write getter description for getModsUsed
   *
   * @return a HashSet<GameplayMod>.
   */
  public final HashSet<GameplayMod> getModsUsed() {
    return this.modsUsed;
  }
}
