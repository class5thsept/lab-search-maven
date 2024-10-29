package edu.grinnell.csc207.util;

import java.util.function.Predicate;
import edu.grinnell.csc207.experiments.SearchExperiments;

/**
 * Assorted utilities for searching structures.
 *
 * @author Your Name Here
 * @author Your Name Here
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchUtils {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int iterativeBinarySearch(int[] vals, int i) throws Exception {
    int upperBound = vals.length;
    int lowerBound = 0;
    while (upperBound >= lowerBound) {
      int middleBound = (upperBound + lowerBound) / 2;
      if (vals[middleBound] == i) {
        return middleBound;
      } else if (vals[middleBound] > i) {
        upperBound = middleBound - 1;
      } else {
        lowerBound = middleBound + 1;
      }
      SearchExperiments.count += 1;
    }
    throw new Exception();
  } // iterativeBinarySearch

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int recursiveBinarySearch(int[] vals, int i) throws Exception {
    return recursiveBinarySearchHelper(vals,i,0,vals.length);   // STUB
  } // recursiveBinarySearch

  static int recursiveBinarySearchHelper(int[] vals, int i, int lowerBound,int upperBound) throws Exception {
    if (lowerBound > upperBound) {throw new Exception();}
    int middleBound = (int) (upperBound + lowerBound) / 2;
    if (vals[middleBound] == i) {
      return middleBound;
    } else if (vals[middleBound] < i) {
      return recursiveBinarySearchHelper(vals, i,middleBound + 1, upperBound);
    } else {
      return recursiveBinarySearchHelper(vals, i,lowerBound, middleBound -1);
    }

  } // recursiveBinarySearch

  /**
   * Search for val in a subarray of values, return the index of an 
   * instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param lb
   *   The lower bound of the area of interest (inclusive)
   * @param ub
   *   The upper bound of the area of interest (exclusive)
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i between lb and ub s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int rbsHelper(int[] vals, int lb, int ub, int i) throws Exception {
    return 0;   // STUB
  } // rbsHelper

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Search values for the first value for which pred holds.
   *
   * @param <T> 
   *   The type of values we're examining
   * @param values
   *   The iterable we're searching
   * @param pred
   *   The predicate used to determine whether or not the value is
   *   acceptable
   * 
   * @return the first mathcing element.
   *
   * @throws Exception
   *   If no matching value is found.
   */
  public static <T> T search(Iterable<T> values, Predicate<? super T> pred) 
      throws Exception {
    for (T value : values) {
      if (pred.test(value)) {
        return value;
      }
    }
    throw new Exception();
  } // search(Iterable<T>, Predicate<? super T>)

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  public static int binarySearch(int[] vals, int i) throws Exception {
    //return 0;
    return iterativeBinarySearch(vals, i);
    
    //return recursiveBinarySearch(vals, i);
  } // binarySearch

} // class SearchUtils
