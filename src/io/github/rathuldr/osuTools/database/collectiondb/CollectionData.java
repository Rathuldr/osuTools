
package io.github.rathuldr.osuTools.database.collectiondb;

import java.util.HashSet;

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
}
