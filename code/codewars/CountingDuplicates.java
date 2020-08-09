package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.*;

public class CountingDuplicates {


  /* Count the number of Duplicates
   *
   * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric
   * digits that occur more than once in the input string. The input string can be assumed to contain only alphabets
   * (both uppercase and lowercase) and numeric digits.
   */

  // My solution
  public static int duplicateCount(String text) {

    if (text.length() == 0) {
      return 0;
    }

    int count = 0;

    String[] chars = text.toLowerCase().split("");
    List<String> checkedChars = new ArrayList<>();

    for (int i = 0; i < chars.length; ++i)
    {
      if (!checkedChars.contains(chars[i])) {
        for (int j = 0; j < i || (j > i && j < chars.length); ++j) {
          if (chars[i].compareTo(chars[j])==0) {
            count++;
            checkedChars.add(chars[i]);
          }
        }
      }
    }

    return count;
  }

  // Their solution (not necessarily the best)
  public static int duplicateCountTheirs(String text) {
    int ans = 0;
    text = text.toLowerCase();
    while (text.length() > 0) {
      String firstLetter = text.substring(0,1);
      text = text.substring(1);
      if (text.contains(firstLetter)) ans ++;
      text = text.replace(firstLetter, "");
    }
    return ans;
  }

  // Test cases
  public static class SolutionTest {
    @Test
    public void abcdeReturnsZero() {
      assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
      assertEquals(0, CountingDuplicates.duplicateCountTheirs("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
      assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
      assertEquals(1, CountingDuplicates.duplicateCountTheirs("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
      assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));
      assertEquals(1, CountingDuplicates.duplicateCountTheirs("indivisibility"));
    }

    @Test
    public void reallyLongStringContainingDuplicatesReturnsThree() {
      String testThousandA = new String(new char[1000]).replace('\0', 'a');
      String testHundredB = new String(new char[100]).replace('\0', 'b');
      String testTenC = new String(new char[10]).replace('\0', 'c');
      String test1CapitalA = new String(new char[1]).replace('\0', 'A');
      String test1d = new String(new char[1]).replace('\0', 'd');
      String test = test1d + test1CapitalA + testTenC + testHundredB + testThousandA;

      assertEquals(3, CountingDuplicates.duplicateCount(test));
      assertEquals(3, CountingDuplicates.duplicateCountTheirs(test));
    }
  }

}
