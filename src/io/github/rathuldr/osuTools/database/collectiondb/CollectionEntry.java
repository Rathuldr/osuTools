
package io.github.rathuldr.osuTools.database.collectiondb;

import java.util.HashSet;

/**
 * This class contains a collection name and a set of beatmap hashes in that collection.
 * 
 * @author Rathuldr rathuldr@gmail.com
 */
public final class CollectionEntry {
  
  /** The collection name. */
  private final String name;
  
  /** The Set of beatmap hashes in the collection. */
  private final HashSet<String> hashes;
  
  /**
   * Constructs a new CollectionEntry.
   * 
   * @param name the collection name as a String.
   * @param hashes the beatmap hashes in this collection as a Set.
   */
  public CollectionEntry(final String name, final HashSet<String> hashes) {
    this.name = name;
    this.hashes = hashes;
  }
  
  /**
   * Gets the collection name.
   * 
   * @return the collection name as a String.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Gets the set of beatmap hashes in the collection.
   * 
   * @return the set of beatmap hashes as a Set.
   */
  public HashSet<String> getHashes() {
    return this.hashes;
  }
}
