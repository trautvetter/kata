package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HighestScoringWord
{

  /*
   * HighestScoringWord (6kyu)
   * https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
   *
   * Given a string of words, you need to find the highest scoring word.
   *
   * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
   *
   * You need to return the highest scoring word as a string.
   * If two words score the same, return the word that appears earliest in the original string.
   *
   * All letters will be lowercase and all inputs will be valid.
   */

  // My solution
  public static String high(String s) {

    Map<Character, Integer> alphabetChars = new HashMap<>();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    for (int c = 0; c < alphabet.length(); c++) {
      alphabetChars.put(alphabet.charAt(c), c+1);
    }

    String[] words = s.split(" ");
    int[] scores = new int[words.length];

    int highestScore = 0;
    int highestIdx = 0;
    for (int i = 0; i < words.length; i++) {

      int sum = 0;
      for (int j = 0; j < words[i].length(); j++) {
        sum += alphabetChars.get(words[i].charAt(j));
      }
      scores[i] = sum;
      if (sum > highestScore) {
        highestScore = sum;
        highestIdx = i;
      }
    }

    System.out.println("score: " + scores[highestIdx] + "(" + words[highestIdx] + ")");
    return words[highestIdx];
  }

  // Test cases
  public static class SolutionTest {

    @Test
    public void sampleTest0() {
      assertEquals("volcano", HighestScoringWord.high("climbing volcano"));
    }

    @Test
    public void sampleTest1() {
      assertEquals("taxi", HighestScoringWord.high("man i need a taxi up to ubud"));
    }

    @Test
    public void sampleTest2() {
      assertEquals("volcano", HighestScoringWord.high("what time are we climbing up to the volcano"));
    }

    @Test
    public void sampleTest3() {
      assertEquals("semynak", HighestScoringWord.high("take me to semynak"));
    }
  }

}
