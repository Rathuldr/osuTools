
package io.github.rathuldr.osuTools.beatmap;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Contains visual data for a beatmap, such as combo colors, what the preferred skin is, and storyboard options.
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 24, 2019
 */
public final class BeatmapAestheticData {
  
  /** An {@link ArrayList} of {@link Color}s that will be applied to each hit circle, in order of appearance. */
  private final ArrayList<Color> comboColors;
  
  /** The {@link Color} of the slider body. */
  private final Color sliderBodyColor;
  
  /** FIXME: !! I don't know what this is. !! */
  private final Color sliderTrackOverrideColor;
  
  /** The {@link Color} of the slider's borders. */
  private final Color sliderBorderColor;
  
  /** The skin that the beatmap will prefer to use, if it exists. */
  private final String preferredSkin;
  
  /** Whether to letterbox the screen on breaks (two horizontal black bars on the top and bottom of the play area. */
  private final boolean letterboxDuringBreaks;
  
  /** Whether to draw the storyboard before combo fire (no longer used). */
  private final boolean storyboardBeforeComboFire;
  
  /** Whether the storyboard is widescreen-compatible. */
  private final boolean storyboardIsWidescreen;
  
  /** FIXME: Whether the storyboard can use elements from the user's current skin? */
  private final boolean canStoryboardUseUserSkinResources;
  
  /**
   * Constructs a new BeatmapAestheticData.
   * 
   * @param comboColors an {@link ArrayList} of {@link Color}s that will be applied to each hit circle, in order of
   *        appearance.
   * @param sliderBodyColor the {@link Color} of the slider body.
   * @param sliderTrackOverrideColor FIXME: !! I don't know what this is. !!
   * @param sliderBorderColor The {@link Color} of the slider's borders.
   * @param preferredSkin The skin that the beatmap will prefer to use, if it exists.
   * @param letterboxDuringBreaks Whether to letterbox the screen on breaks (two horizontal black bars on the top and
   *        bottom of the play area.
   * @param storyboardBeforeComboFire Whether to draw the storyboard before combo fire (no longer used).
   * @param storyboardIsWidescreen Whether the storyboard is widescreen-compatible.
   * @param canStoryboardUseUserSkinResources Whether the storyboard can use elements from the user's current skin?
   */
  public BeatmapAestheticData(final ArrayList<Color> comboColors, final Color sliderBodyColor, final Color sliderTrackOverrideColor,
      final Color sliderBorderColor, final String preferredSkin, final boolean letterboxDuringBreaks, final boolean storyboardBeforeComboFire,
      final boolean storyboardIsWidescreen, final boolean canStoryboardUseUserSkinResources) {
    this.comboColors = comboColors;
    this.sliderBodyColor = sliderBodyColor;
    this.sliderTrackOverrideColor = sliderTrackOverrideColor;
    this.sliderBorderColor = sliderBorderColor;
    this.preferredSkin = preferredSkin;
    this.letterboxDuringBreaks = letterboxDuringBreaks;
    this.storyboardBeforeComboFire = storyboardBeforeComboFire;
    this.storyboardIsWidescreen = storyboardIsWidescreen;
    this.canStoryboardUseUserSkinResources = canStoryboardUseUserSkinResources;
  }
  
  /**
   * Gets an {@link ArrayList} of {@link Color}s that will be applied to each hit circle, in order of appearance.
   *
   * @return an {@link ArrayList}.
   */
  public final ArrayList<Color> getComboColors() {
    return this.comboColors;
  }
  
  /**
   * Gets the {@link Color} of the slider body.
   *
   * @return a {@link Color}.
   */
  public final Color getSliderBodyColor() {
    return this.sliderBodyColor;
  }
  
  /**
   * FIXME: !! I don't know what this is. !!
   *
   * @return a {@link Color}.
   */
  public final Color getSliderTrackOverrideColor() {
    return this.sliderTrackOverrideColor;
  }
  
  /**
   * Gets the {@link Color} of the slider's borders.
   *
   * @return a {@link Color}.
   */
  public final Color getSliderBorderColor() {
    return this.sliderBorderColor;
  }
  
  /**
   * Gets the skin that the beatmap will prefer to use, if it exists.
   *
   * @return a {@link String}.
   */
  public final String getPreferredSkin() {
    return this.preferredSkin;
  }
  
  /**
   * Gets whether to letterbox the screen on breaks (two horizontal black bars on the top and bottom of the play area.
   *
   * @return a boolean.
   */
  public final boolean letterboxDuringBreaks() {
    return this.letterboxDuringBreaks;
  }
  
  /**
   * Gets whether to draw the storyboard before combo fire (no longer used).
   *
   * @return a boolean.
   */
  public final boolean storyboardBeforeComboFire() {
    return this.storyboardBeforeComboFire;
  }
  
  /**
   * Gets whether the storyboard is widescreen-compatible.
   *
   * @return a boolean.
   */
  public final boolean storyboardIsWidescreen() {
    return this.storyboardIsWidescreen;
  }
  
  /**
   * FIXME: Gets whether the storyboard can use elements from the user's current skin?
   *
   * @return a boolean.
   */
  public final boolean canStoryboardUseUserSkinResources() {
    return this.canStoryboardUseUserSkinResources;
  }
}
