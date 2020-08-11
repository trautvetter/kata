package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FixStringCase {


  /* Fix String case (7kyu/fundamentals)
   * https://www.codewars.com/kata/5b180e9fedaa564a7000009a
   *
   * In this Kata, you will be given a string that may have mixed uppercase and lowercase letters and your 
   * task is to convert that string to either lowercase only or uppercase only based on:
   * 
   * make as few changes as possible.
   * if the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
   * For example:
   * 
   * solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
   * solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e" to uppercase.
   * solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
   */

  // My solution
  public static String solve(final String str) {
    int countUppercase = 0;
    int countLowercase = 0;
    
    String[] chars = str.split("");
    
    for (int i = 0; i < chars.length; i++) {
      if (chars[i].equals(chars[i].toLowerCase())) {
        countLowercase++;
        continue;
      }
      countUppercase++;
    }
    
    if (countUppercase > countLowercase) {
      return str.toUpperCase();
    }
    
    return str.toLowerCase();

  }

  // Their solution (not necessarily the best)
  public static String solveTheirs(String str) {
    return str.chars().filter(Character::isLowerCase).count() >= str.chars().filter(Character::isUpperCase).count()
        ? str.toLowerCase()
        : str.toUpperCase();
  }

  // Test cases
  public static class SampleTest {
    @Test
    public void BasicTests() {
        assertEquals("code", FixStringCase.solve("code"));
        assertEquals("CODE", FixStringCase.solve("CODe"));
        assertEquals("code", FixStringCase.solve("COde"));
        assertEquals("code", FixStringCase.solve("Code"));
        assertEquals("", FixStringCase.solve(""));
    }
    @Test
    public void BasicTestsTheirs() {
      assertEquals("code", FixStringCase.solveTheirs("code"));
      assertEquals("CODE", FixStringCase.solveTheirs("CODe"));
      assertEquals("code", FixStringCase.solveTheirs("COde"));
      assertEquals("code", FixStringCase.solveTheirs("Code"));
      assertEquals("", FixStringCase.solveTheirs(""));
    }
  }

}
