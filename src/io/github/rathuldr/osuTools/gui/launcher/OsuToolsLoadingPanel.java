
package io.github.rathuldr.osuTools.gui.launcher;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import io.github.rathuldr.osuTools.database.DBData;
import io.github.rathuldr.osuTools.database.collectiondb.CollectionData;
import io.github.rathuldr.osuTools.database.osudb.OsuDBData;
import io.github.rathuldr.osuTools.database.scoresdb.ScoreData;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Mar 2, 2019
 */
public class OsuToolsLoadingPanel extends JPanel {
  
  /** Default serial version. */
  private static final long serialVersionUID = 1L;
  
  private static final int PANEL_LENGTH = 320;
  
  private static final int PANEL_HEIGHT = 240;
  
  private static final int PANEL_PADDING = 8;
  
  private static final int COMPONENT_HEIGHT = 24;
  
  private static final int COMPONENT_PADDING = 8;
  
  /** Displays the progress of loading osu! data. */
  private final JProgressBar progBar;
  
  /** The status that will be displayed above the progress bar. */
  private final JLabel statusLabel;
  
  /** The data loaded from the collections.db file. */
  private CollectionData collectionData;
  
  /** The data loaded from the osu.db file. */
  private OsuDBData osuDBData;
  
  /** The data loaded from the scores.db file. */
  private ScoreData scoreData;
  
  /** The user's osu! directory. */
  private String osuDirectory;
  
  /** Whether the data has been loaded or not. */
  private boolean isDataLoaded = false;
  
  /**
   * Constructs a new OsuToolsLoadingPanel.
   * 
   */
  public OsuToolsLoadingPanel() {
    
    // Don't use a layout manager because they're all trash
    this.setLayout(null);
    
    // Initialize the progress bar
    this.progBar = new JProgressBar();
    this.progBar.setIndeterminate(true);
    
    // Initialize the loading status text
    this.statusLabel = new JLabel(LauncherStrings.PROGBAR_PREFIX);
    
    // A list of components to add to the panel in order of addition
    final JComponent[] panelComponents = { this.statusLabel, this.progBar };
    
    // Add each component to the panel and set the panel's size
    for (int i = 0; i < panelComponents.length; i++) {
      addComponent(panelComponents[i], i);
    }
    
    this.setSize(this.getPreferredSize());
    this.setVisible(true);
    
  }
  
  /**
   * TODO Write description for loadDBFiles
   *
   */
  public final void loadDBFiles() {
    
    // Load the data from each .db file
    for (int i = 0; i < LauncherStrings.OSU_DB_NAMES.length; i++) {
      
      final String dbFile = LauncherStrings.OSU_DB_NAMES[i];
      
      System.out.println("For " + dbFile + ":");
      this.statusLabel.setText(LauncherStrings.PROGBAR_PREFIX + String.format(LauncherStrings.PROGBAR_REQ_FILE, dbFile));
      
      File currDBFile = null;
      
      // If we've found the osu! directory, use it for the .db files
      if (this.osuDirectory != null) {
        
        System.out.println("  Using osu! directory: \"" + this.osuDirectory + "\".");
        
        // Ensure that the expected .db file exists in the osu! directory
        currDBFile = new File(this.osuDirectory + dbFile);
        if (!currDBFile.canRead()) {
          
          System.out.println("  File \"" + currDBFile.getAbsolutePath() + "\" not found, disabling user osu!dir.");
          
          // If not, assume we haven't found the osu! directory, or that there's something wrong (possibly Windows
          // placing some files in virtual store or appdata)
          this.osuDirectory = null;
          
        }
      }
      
      // If we haven't found the osu! directory, try to locate the file using a default osu! directory
      if (this.osuDirectory == null) {
        
        System.out.println("  User osu!dir not enabled.");
        
        for (final String osuDefaultDir : LauncherStrings.OSU_DIRS_WINDOWS) {
          currDBFile = new File(osuDefaultDir + dbFile);
          
          System.out.println("  Searching for default osu! file \"" + currDBFile.getAbsolutePath() + "\".");
          
          // We've found the file, so ask the user if it's correct
          if (currDBFile.canRead()) {
            playDialogSound("exclamation");
            final String[] foundOptions = { "Yes", "No", "Cancel" };
            int defRetChoice = JOptionPane.showOptionDialog(this, String.format(LauncherStrings.DEFAULT_DB_FOUND_STR, currDBFile.getAbsolutePath()),
                LauncherStrings.DEFAULT_DB_FOUND_TITLE, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, foundOptions, foundOptions[0]);
            
            switch (defRetChoice) {
              
              // Yes -- Do nothing
              case 0:
              break;
            
              // No -- Prompt them to find the correct one
              case 1:
                currDBFile = chooseDataFile(dbFile);
              break;
            
              // Assume they canceled or closed the dialog box
              default:
                cancelLoad();
            }
            
            break;
          }
          
        }
        
      }
      
      // Load the current .db file's data into memory
      this.statusLabel.setText(LauncherStrings.PROGBAR_PREFIX + String.format(LauncherStrings.PROGBAR_LOAD_STRING, currDBFile.getName()));
      try {
        
        switch (i) {
          
          // collection.db
          case 0:
            this.collectionData = CollectionData.loadFromFile(currDBFile, this.progBar);
          break;
        
          // osu!.db
          case 1:
            this.osuDBData = OsuDBData.loadFromFile(currDBFile, this.progBar);
          break;
        
          // scores.db
          case 2:
            this.scoreData = ScoreData.loadFromFile(currDBFile, this.progBar);
          break;
          default:
            throw new IllegalArgumentException("Unknown i value! (OsuToolsLoadingPanel.java:switch(i).");
        }
        
      } catch (final IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    this.isDataLoaded = true;
    System.out.println("Data files loaded successfully.");
  }
  
  /**
   * TODO Write description for isDataLoaded
   * 
   * @return
   */
  public final boolean isDataLoaded() {
    return this.isDataLoaded;
  }
  
  /**
   * TODO Write description for getLoadedData
   * 
   * @return
   */
  public final DBData getDBData() {
    return new DBData(this.collectionData, this.osuDBData, this.scoreData);
  }
  
  @Override
  public Dimension getMinimumSize() {
    return this.getPreferredSize();
  }
  
  @Override
  public Dimension getMaximumSize() {
    return this.getPreferredSize();
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(PANEL_LENGTH, PANEL_HEIGHT);
  }
  
  /**
   * TODO Write description for addComponent
   * 
   * @param comp
   * @param row
   */
  private final void addComponent(final JComponent comp, final int row) {
    comp.setBounds(PANEL_PADDING, PANEL_PADDING + (COMPONENT_HEIGHT + COMPONENT_PADDING) * row, PANEL_LENGTH - PANEL_PADDING * 2, COMPONENT_HEIGHT);
    comp.setVisible(true);
    this.add(comp);
  }
  
  /**
   * TODO Write description for cancelLoad
   *
   */
  private final void cancelLoad() {
    
    // User cancelled, so shutdown
    playDialogSound("hand");
    JOptionPane.showMessageDialog(this, LauncherStrings.FILE_NOT_LOCATED, LauncherStrings.FILE_NOT_LOCATED_TITLE, JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    
  }
  
  /**
   * TODO Write description for playDialogSound
   * 
   * @param winSound
   */
  private static final void playDialogSound(final String winSound) {
    final Runnable errSound = (Runnable) Toolkit.getDefaultToolkit().getDesktopProperty("win.sound." + winSound);
    if (errSound != null) errSound.run();
  }
  
  /**
   * TODO Write description for chooseDataFile
   * 
   * @param targetName
   * @return
   */
  private final File chooseDataFile(final String targetName) {
    
    // The .db file wasn't found automatically, so ask the user
    boolean dbFileFound = false;
    File chosenFile = null;
    while (!dbFileFound) {
      
      // Prompt the user to locate their osu! directory
      playDialogSound("exclamation");
      JOptionPane.showMessageDialog(this, String.format(LauncherStrings.DB_LOCATE_STR, targetName), String.format(LauncherStrings.DB_LOCATE_TITLE, targetName),
          JOptionPane.INFORMATION_MESSAGE);
      final JFileChooser osuDirChooser = new JFileChooser();
      osuDirChooser.setDialogTitle("Locate " + targetName);
      final int chooserRetVal = osuDirChooser.showOpenDialog(this);
      if (chooserRetVal == JFileChooser.APPROVE_OPTION) {
        
        chosenFile = osuDirChooser.getSelectedFile();
        final String chosenFileName = chosenFile.getName();
        
        // If the file is correct, assume it exists in the user's osu! directory and use that for all other .db file
        // existence tests
        if (chosenFileName.equalsIgnoreCase(targetName)) {
          dbFileFound = true;
        }
        
      } else {
        cancelLoad();
      }
      
    }
    
    if (chosenFile == null) {
      throw new NullPointerException("chosenFile is null! (OsuToolsLoadingPanel.java:chooseDataFile(String).");
    }
    
    this.osuDirectory = chosenFile.getParentFile().getAbsolutePath() + "/";
    return chosenFile;
  }
  
}
