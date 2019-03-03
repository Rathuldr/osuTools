
package io.github.rathuldr.osuTools.gui.launcher;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import io.github.rathuldr.osuTools.database.DBData;

/**
 * TODO Write description for .
 * 
 * @author Rathuldr rathuldr@gmail.com
 * @since Feb 24, 2019
 */
public final class OsuToolsLoadingFrame extends JFrame {
  
  /** Default serial version. */
  private static final long serialVersionUID = 1L;
  
  private static final String WINDOW_TITLE = "osu!Tools - Loading...";
  
  private static final int WINDOW_LENGTH = 320;
  
  private static final int WINDOW_HEIGHT = 240;
  
  final OsuToolsLoadingPanel launcherPanel;
  
  /**
   * Constructs a new OsuToolsLauncherFrame.
   */
  public OsuToolsLoadingFrame() {
    super();
    
    this.setTitle(WINDOW_TITLE);
    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    this.setLayout(null);
    this.setUndecorated(true);
    
    this.launcherPanel = new OsuToolsLoadingPanel();
    this.add(this.launcherPanel);
    
    this.setVisible(true);
    this.setSize(this.getPreferredSize());
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    
    final SwingWorker<Void, Void> loadWorker = new SwingWorker<Void, Void>() {
      
      @Override
      protected Void doInBackground() throws Exception {
        OsuToolsLoadingFrame.this.launcherPanel.loadDBFiles();
        return null;
      }
      
    };
    loadWorker.execute();
    
  }
  
  public final boolean isDataLoaded() {
    return this.launcherPanel.isDataLoaded();
  }
  
  public final DBData getDBData() {
    return this.launcherPanel.getDBData();
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
    return new Dimension(WINDOW_LENGTH, WINDOW_HEIGHT);
  }
  
}
