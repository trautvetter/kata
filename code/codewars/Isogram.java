package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class Isogram {

  /* Isograms
   *
   * An isogram is a word that has no repeating letters, consecutive or non-consecutive.
   * Implement a function that determines whether a string that contains only letters is an isogram.
   * Assume the empty string is an isogram. Ignore letter case.
   */

  // My solution
  public static boolean  isIsogram(String str) {

    if (str.length() == 0) {
      return true;
    }

    List<String> letters = new ArrayList<>();

    String[] chars = str.split("");
    for (int i = 0; i < chars.length; ++i){
      // If the letter is already in the hash this str is not an isogram
      if (letters.contains(chars[i].toLowerCase())) {
        return false;
      } else {
        letters.add(chars[i].toLowerCase());
      }
    }

    return true;
  }

  // Their solution
  public static boolean isIsogramTheirs(String str) {

    if (str.toLowerCase().chars().distinct().count() == str.length()) {
      return true;
    }

    return false;
  }


  // Test cases
  public static class IsogramTests {
    @Test
    public void FixedTests() {
      assertEquals(true, Isogram.isIsogram("Dermatoglyphics"));
      assertEquals(true, Isogram.isIsogram("isogram"));
      assertEquals(false, Isogram.isIsogram("moose"));
      assertEquals(false, Isogram.isIsogram("isIsogram"));
      assertEquals(false, Isogram.isIsogram("aba"));
      assertEquals(false, Isogram.isIsogram("moOse"));
      assertEquals(true, Isogram.isIsogram("thumbscrewjapingly"));
      assertEquals(true, Isogram.isIsogram(""));

      assertEquals(true, Isogram.isIsogramTheirs("Dermatoglyphics"));
      assertEquals(true, Isogram.isIsogramTheirs("isogram"));
      assertEquals(false, Isogram.isIsogramTheirs("moose"));
      assertEquals(false, Isogram.isIsogramTheirs("isIsogram"));
      assertEquals(false, Isogram.isIsogramTheirs("aba"));
      assertEquals(false, Isogram.isIsogramTheirs("moOse"));
      assertEquals(true, Isogram.isIsogramTheirs("thumbscrewjapingly"));
      assertEquals(true, Isogram.isIsogramTheirs(""));
    }
  }

}
