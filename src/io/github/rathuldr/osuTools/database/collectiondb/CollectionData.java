
package io.github.rathuldr.osuTools.database.collectiondb;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

import javax.swing.JProgressBar;

import io.github.rathuldr.osuTools.util.LEBinaryParser;

/**
 * Contains the version of the collections.db file and each collection's data.
 * 
 * @author Rathuldr rathuldr@gmail.com
 */
public final class CollectionData {
  
  /** The version of the collections.db file. */
  private final int version;
  
  /** The set of collections. */
  private final HashSet<CollectionEntry> collections;
  
  /**
   * Constructs a new object holding the collection data from collections.db.
   * 
   * @param version the version of the collections.db file as an int.
   * @param collections the set of collections.
   */
  public CollectionData(final int version, final HashSet<CollectionEntry> collections) {
    this.version = version;
    this.collections = collections;
  }
  
  /**
   * Gets the version of the collections.db file.
   * 
   * @return an int representing the version. e.g.: a value of 20190223 represents the version as of 02/23/2019.
   */
  public final int getVersion() {
    return this.version;
  }
  
  /**
   * Gets the set of collections.
   * 
   * @return a {@link HashSet} of {@link CollectionEntry}s.
   */
  public final HashSet<CollectionEntry> getCollections() {
    return this.collections;
  }
  
  /**
   * TODO Write description for loadFromFile
   * 
   * @param dbFile
   * @param progBar
   * @return
   * @throws IOException
   */
  public static final CollectionData loadFromFile(final File dbFile, final JProgressBar progBar) throws IOException {
    
    // Read the file into a byte array
    final Path collectionDBPath = Paths.get(dbFile.getAbsolutePath());
    byte[] collectionDBData = Files.readAllBytes(collectionDBPath);
    if (collectionDBData == null) {
      throw new NullPointerException("" + dbFile.getAbsolutePath() + "\" is empty.");
    }
    
    // Open a C# data parser on the replay data contents
    final LEBinaryParser parser = new LEBinaryParser(collectionDBData);
    
    final int version = parser.parseInt();
    
    // Parse each collection and its beatmaps
    final HashSet<CollectionEntry> collections = new HashSet<CollectionEntry>();
    final int collectionCount = parser.parseInt();
    
    // Set the progress of the
    progBar.setIndeterminate(false);
    progBar.setMaximum(collectionCount);
    
    for (int i = 0; i < collectionCount; i++) {
      
      final String collectionName = parser.parseString();
      
      // Parse each beatmap hash in this collection
      final HashSet<String> hashes = new HashSet<String>();
      final int numBeatmaps = parser.parseInt();
      
      for (int j = 0; j < numBeatmaps; j++) {
        
        // Add the current beatmap hash to the hashes collection
        final String beatmapHash = parser.parseString();
        hashes.add(beatmapHash);
        
      }
      
      // Add the collection to the collections container
      final CollectionEntry collection = new CollectionEntry(collectionName, hashes);
      collections.add(collection);
      progBar.setValue(progBar.getValue() + 1);
    }
    
    return new CollectionData(version, collections);
    
  }
  
}
