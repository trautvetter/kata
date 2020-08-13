package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MissingLetter
{

  /*
   * MissingLetter (6kyu)
   * https://www.codewars.com/kata/5839edaa6754d6fec10000a2
   *
   * Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
   *
   * You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
   * The array will always contain letters in only one case.
   *
   * Example:
   * ['a','b','c','d','f'] -> 'e' ['O','Q','R','S'] -> 'P'
   */

  // My solution
  public static char findMissingLetter(char[] array) {

    int last = Character.codePointAt(array, 0);
    for (int i = 0; i < array.length; i++) {
      int current = Character.codePointAt(array, i);
      if (current - last == 2){
        return Character.toChars(current-1)[0];
      }
      last = current;
    }

    return ' ';
  }

  // Their solution
  public static char findMissingLetterTheirs(char[] array){
    char expectableLetter = array[0];
    for(char letter : array){
      if(letter != expectableLetter) break;
      expectableLetter++;
    }
    return expectableLetter;
  }

  // Test cases
  public static class SolutionTest {
    @Test
    public void exampleTests() {
      assertEquals('e', MissingLetter.findMissingLetter(new char[] { 'a','b','c','d','f' }));
      assertEquals('P', MissingLetter.findMissingLetter(new char[] { 'O','Q','R','S' }));
      assertEquals('S', MissingLetter.findMissingLetter(new char[] { 'R','T' }));
    }

    @Test
    public void exampleTestsTheirs() {
      assertEquals('e', MissingLetter.findMissingLetterTheirs(new char[] { 'a','b','c','d','f' }));
      assertEquals('P', MissingLetter.findMissingLetterTheirs(new char[] { 'O','Q','R','S' }));
      assertEquals('S', MissingLetter.findMissingLetterTheirs(new char[] { 'R','T' }));
    }
  }
}