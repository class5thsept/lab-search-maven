package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.function.Predicate;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Assorted experiments for searching structures.
 *
 * @author Your Name Here
 * @author Your Name Here
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchExperiments {
  /**
   * Run our experimens.
   *
   * @param args
   *   Command-line arguments. Ignored.
   */
  public static int count = 0;
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] tmp =
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike",
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    
    Predicate<String> shortLength = i -> (i.length() < 5);

    try {
      String ex1c = SearchUtils.search(strings, shortLength);
      pen.println("The first string of fewer than five letters is " + ex1c);
    } catch (Exception e) {
      pen.println("There are no strings of fewer than five letters.");
    } // try/catch

    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch

    try {
      String ex2g = SearchUtils.search(strings, (s) -> s.contains("u"));
      pen.println("The first string of exactly six letters is " + ex2g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch



    try {
      Integer randNum =  Integer.valueOf((int) (Math.random() * 1000));
      Integer[] largeTmp = new Integer[1000];
      for(int i = 0; i < largeTmp.length; i++){
        largeTmp[i] = Integer.valueOf(i);
      }
      ArrayList<Integer> large = new ArrayList<Integer>(Arrays.asList(largeTmp));
      int result = SearchUtils.search(large, (n) -> n.equals(randNum));
      pen.println("Index of the random number is " + result);    
      pen.println("Count " + SearchExperiments.count); 
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch
    

    pen.close();
  } // main(String[])
} // class SearchUtils
