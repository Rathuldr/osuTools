
package io.github.rathuldr.osuTools.beatmap;

/**
 * This class contains all data from a .osu beatmap file.
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 23, 2019
 */
public final class Beatmap {
  
  /**
   * The general beatmap data, such as the file format, the audio lead-in time, or whether or not to show an epilepsy
   * warning.
   */
  private final BeatmapGeneralData generalData;
  
  /** The beatmap data that has to do with editing and visuals. */
  private final BeatmapDesignData designData;
  
  /** Metadata for the beatmap, including the title, creator, tags, and difficulty name. */
  private final BeatmapMetadata metadata;
  
  /** Difficulty parameters such as approach rate, circle size, and the slider tick rate. */
  private final BeatmapDifficultyData difficultyData;
  
  /** Data for the map itself. */
  private final BeatmapChartData chartData;
  
  /**
   * Constructs a new Beatmap.
   * 
   * @param generalData The general beatmap data, such as the file format, the audio lead-in time, or whether or not to
   *        show an epilepsy warning.
   * @param designData The beatmap data that has to do with editing and visuals.
   * @param metadata Metadata for the beatmap, including the title, creator, tags, and difficulty name.
   * @param difficultyData Difficulty parameters such as approach rate, circle size, and the slider tick rate.
   * @param chartData Data for the map itself.
   */
  public Beatmap(final BeatmapGeneralData generalData, final BeatmapDesignData designData, final BeatmapMetadata metadata,
      final BeatmapDifficultyData difficultyData, final BeatmapChartData chartData) {
    this.generalData = generalData;
    this.designData = designData;
    this.metadata = metadata;
    this.difficultyData = difficultyData;
    this.chartData = chartData;
  }
  
  /**
   * Gets the beatmap data that has to do with editing and visuals.
   *
   * @return a BeatmapGeneralData object.
   */
  public final BeatmapGeneralData getGeneralData() {
    return this.generalData;
  }
  
  /**
   * Gets the beatmap data that has to do with editing and visuals.
   *
   * @return a BeatmapDesignData object.
   */
  public final BeatmapDesignData getDesignData() {
    return this.designData;
  }
  
  /**
   * Gets the metadata for the beatmap, including the title, creator, tags, and difficulty name.
   *
   * @return a BeatmapMetadata object.
   */
  public final BeatmapMetadata getMetadata() {
    return this.metadata;
  }
  
  /**
   * Gets difficulty parameters such as approach rate, circle size, and the slider tick rate.
   *
   * @return a BeatmapDifficultyData.
   */
  public final BeatmapDifficultyData getDifficultyData() {
    return this.difficultyData;
  }
  
  /**
   * Gets the data for the map itself.
   *
   * @return a BeatmapChartData.
   */
  public final BeatmapChartData getChartData() {
    return this.chartData;
  }
  
}
