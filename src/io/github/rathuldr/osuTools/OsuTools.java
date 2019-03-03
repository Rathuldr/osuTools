
package io.github.rathuldr.osuTools;

import javax.swing.SwingUtilities;

import io.github.rathuldr.osuTools.database.DBData;
import io.github.rathuldr.osuTools.gui.launcher.OsuToolsLoadingFrame;

public class OsuTools {
  
  static OsuToolsLoadingFrame launcher;
  
  public static void main(final String[] args) {
    
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        
        launcher = new OsuToolsLoadingFrame();
        
      }
      
    });
    
    while (launcher == null || !launcher.isDataLoaded()) {}
    
    final DBData dbData = launcher.getDBData();
    System.out.println("Got data.");
    
  }
  
}
