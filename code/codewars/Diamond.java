package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Diamond {


  /* Diamond (6kyu/fundamentals/Strings)
   * https://www.codewars.com/kata/5503013e34137eeeaa001648
   *
   *You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters.
   * Trailing spaces should be removed, and every line must be terminated with a newline character (\n).
   *
   * Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.
   *
   * A size 3 diamond:
   *
   *   *
   *  ***
   *   *
   * ...which would appear as a string of " *\n***\n *\n"
   */

  private static final String SPACE = " ";
  private static final String STAR = "*";
  private static final String NEWLINE = "\n";

  private static String addStars(int numStars, int numSpaces) {
    String ret = "";

    if (numStars == 0) {
      return ret;
    }

    while (numSpaces > 0) {
      ret += SPACE;
      numSpaces--;
    }
    while (numStars > 0) {
      ret += STAR;
      numStars--;
    }

    ret += NEWLINE;
    return ret;
  }

  // My solution
  public static String print(final int n) {

    if (n < 1 || n % 2 == 0) {
      return null;
    }

    int midPoint = n/2;
    String[] stars = new String[n];

    int numSpaces = midPoint;
    int numStars = 1;
    for (int i = 0; i < n; i++) {
      if (i < midPoint) {
        stars[i] = addStars(numStars, numSpaces);
        numStars+=2;
        numSpaces--;
      } else {
        stars[i] = addStars(numStars, numSpaces);
        numStars-=2;
        numSpaces++;
      }
    }

    for (int y = 0; y < stars.length; y++) {
      System.out.print(stars[y]);
    }
    System.out.println("-----");

    return String.join("", stars);

  }

  // Their solution (not necessarily the best)
  public static String printTheirs(int n) {
    if (n % 2 == 0 || n < 0) {
      return null;
    }
    StringBuilder diamond = new StringBuilder();
    for (int i = 1; i <= n; i+=2) {
      appendLine(diamond, i, n);
    }
    for (int i = n-2; i > 0; i-=2) {
      appendLine(diamond, i, n);
    }
    return diamond.toString();
  }

  private static void appendLine(StringBuilder diamond, int size, int totalSize) {
    int spaces = (totalSize-size)/2;
    for (int j = 0; j < spaces; j++) {
      diamond.append(" ");
    }
    for (int j = 0; j < size; j++) {
      diamond.append("*");
    }
    diamond.append("\n");
  }


  // Test cases
  public static class DiamondTest {
    @Test
    public void testDiamond3() {
      StringBuffer expected = new StringBuffer();
      expected.append(" *\n");
      expected.append("***\n");
      expected.append(" *\n");

      assertEquals(expected.toString(), Diamond.print(3));
      assertEquals(expected.toString(), Diamond.printTheirs(3));
    }

    @Test
    public void testDiamond5() {
      StringBuffer expected = new StringBuffer();
      expected.append("  *\n");
      expected.append(" ***\n");
      expected.append("*****\n");
      expected.append(" ***\n");
      expected.append("  *\n");

      assertEquals(expected.toString(), Diamond.print(5));
      assertEquals(expected.toString(), Diamond.printTheirs(5));
    }

    @Test
    public void testDiamond1() {
      StringBuffer expected = new StringBuffer();
      expected.append("*\n");
      assertEquals(expected.toString(), Diamond.print(1));
      assertEquals(expected.toString(), Diamond.printTheirs(1));
    }

    @Test
    public void testDiamond0() {
      assertEquals(null, Diamond.print(0));
      assertEquals(null, Diamond.printTheirs(0));
    }

    @Test
    public void testDiamondMinus2() {
      assertEquals(null, Diamond.print(-2));
      assertEquals(null, Diamond.printTheirs(-2));
    }

    @Test
    public void testDiamond2() {
      assertEquals(null, Diamond.print(2));
      assertEquals(null, Diamond.printTheirs(2));
    }
  }

}
