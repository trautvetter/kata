package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class StringReversal {

  /* String reversal maintaining position of spaces
   *
   * In this Kata, we are going to reverse a string while maintaining the spaces (if any) in their original place.
   * All input will be lower case letters and in some cases spaces.
   */

  // My solution
  public static String solve(String s) {

    final String SPACE = " ";

    String[] reverse = new String[s.length()];
    String[] forward = s.split("");

    // Loop through
    for (int i = 0; i < s.length(); ++i) {
      if (forward[i].equals(SPACE)) {
        reverse[i] = SPACE;
      }
    }

    for (int i = forward.length-1, j = 0; i >= 0; --i) {
      if (!forward[i].equals(SPACE)) {

        if (reverse[j] != null && reverse[j].equals(SPACE)) {
          j++;
        }

        reverse[j] = forward[i];
        j++;

      }
    }

    return String.join("", reverse);
  }

  // My updated solution
  public static String solveUpdated(String s) {

    final char SPACE = ' ';

    char[] reverse = new char[s.length()];

    // Loop through the string and put spaces into the same positions in the reverse char[]
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == SPACE) {
        reverse[i] = SPACE;
      }
    }

    for (int i = s.length()-1, j = 0; i >= 0; --i) {
      if (s.charAt(i) != SPACE) {
        // Skip spaces
        if (reverse[j] == SPACE) {
          j++;
        }
        // Copy in each char
        reverse[j] = s.charAt(i);
        j++;
      }
    }

    return new String(reverse);
  }

  // Their solution
  public static String solveTheirs(String s){
    StringBuilder str = new StringBuilder(s.replaceAll(" ", "")).reverse();
    IntStream.range(0, s.length())
            .filter(i -> s.charAt(i) == ' ')   // filters out all space chars and returns a stream consisting of that space element
            .forEach(j -> str.insert(j, ' ')); // inserts a space in the reversed string if the stream return by filter above has elements
    return str.toString();
  }


  // Test cases
  public static class StringReversalTest {
    @Test
    public void test() {
      assertEquals("srawedoc",StringReversal.solve("codewars"));
      assertEquals("srawedoc",StringReversal.solveTheirs("codewars"));
      assertEquals("srawedoc",StringReversal.solveUpdated("codewars"));
      assertEquals("edoc ruoy",StringReversal.solve("your code"));
      assertEquals("edoc ruoy",StringReversal.solveTheirs("your code"));
      assertEquals("edoc ruoy",StringReversal.solveUpdated("your code"));
      assertEquals("skco redo cruoy",StringReversal.solve("your code rocks"));
      assertEquals("skco redo cruoy",StringReversal.solveTheirs("your code rocks"));
      assertEquals("skco redo cruoy",StringReversal.solveUpdated("your code rocks"));
    }
  }

}
