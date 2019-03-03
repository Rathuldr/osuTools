
package io.github.rathuldr.osuTools.gui.launcher;

public class LauncherStrings {
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static final String PROGBAR_PREFIX = "Status: ";
  
  public static final String PROGBAR_LOAD_STRING = "loading %s";
  
  public static final String PROGBAR_REQ_FILE = "Waiting on file %s";
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static final String DB_FNF_STR = "Could not find file %s in a known default osu! directory. Please locate the data file.";
  
  public static final String DB_FNF_TITLE = "Missing File";
  
  public static final String DB_LOCATE_STR = "Please locate the file %s in your osu! directory. If the other .db files exist in this directory, they will be used";
  
  public static final String DB_LOCATE_TITLE = "Find %s";
  
  public static final String FILE_NOT_LOCATED = "A required data file was not located. Please ensure the data files "
      + "exist in your osu! directory and re-launch the program.";
  
  public static final String FILE_NOT_LOCATED_TITLE = "Data File Required";

  public final static String DEFAULT_DB_FOUND_TITLE = "Default Data File Found";
  
  public final static String DEFAULT_DB_FOUND_STR = "The osu! data file %s was found. Use this data file?";
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public static final String[] OSU_DB_NAMES = { "collection.db", "osu!.db", "scores.db" };
  
  public static final String[] OSU_DIRS_WINDOWS = { "C:/Program Files/osu!/", "C:/Program Files (x86)/osu!/",
      System.getProperty("user.home") + "/AppData/Local/osu!/" };
  
}
