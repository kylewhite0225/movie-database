import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.HashMap;

/*
Author: Kyle White
Course: CS401 Algorithms
Date: 6/4/2021
 */

/*
The MovieDatabase class contains a single Hashmap<String, RedBlackBST<T, HashSet<Movie>>> object
which is implemented as generic in order to store multiple different types of RedBlacBST objects,
with different key parameters.
 */

public class MovieDatabase<T extends Comparable<T>> {
    private HashMap<String, RedBlackBST<T, HashSet<Movie>>> map;

    /*
    Default constructor initiates the HashMap.
     */
    public MovieDatabase() {
        map = new HashMap<>();
    }

    /*
    addRBT method adds a RedBlackBST object to the HashMap member map.
    @param key  The desired HashMap key
    @param tree The RedBlackBST to be accessed by the key
     */
    public void addRBT(String key, RedBlackBST<T, HashSet<Movie>> tree) {
        map.put(key, tree);
    }

    /*
    The getDB method returns the HashMap stored in map
     */
    public RedBlackBST<T, HashSet<Movie>> getDB(String key) {
        return map.get(key);
    }

    /*
    Overridden equals method to prevent errors.
    @param obj  The object to compare against.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
