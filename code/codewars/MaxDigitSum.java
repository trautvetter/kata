package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class MaxDigitSum
{

  /*
   * MaxDigitSum (6kyu)
   * https://www.codewars.com/kata/5b162ed4c8c47ea2f5000023
   *
   * In this Kata, you will be given an integer n and your task will be to return the largest integer that is <= n and
   * has the highest digit sum.
   * solve(100) = 99. Digit Sum for 99 = 9 + 9 = 18. No other number <= 100 has a higher digit sum.
   * solve(10) = 9
   * solve(48) = 48. Note that 39 is also an option, but 48 is larger.
   */

  // Their solution
  public static long solveTheirs(long n)
  {

    System.out.println("number (n): " + n);

    if (n < 10)
    {
      return n;
    }

    long m = n, e = 1;
    System.out.println("m: " + m);
    System.out.println("e: (1) " + e);
    System.out.println("  while (m >= 10)");
    while (m >= 10)
    {
      m /= 10;
      e *= 10;
      System.out.println("    m /= 10: " + m);
      System.out.println("    e *= 10: " + e);
      System.out.println("    - ");
    }

    System.out.println("- ");
    System.out.println("m: " + m);
    System.out.println("e: " + e);
    System.out.println("--- ");

    long t = m * e + (e - 1);

    System.out.println("t: " + t);


    if (t == n)
    {
      return t;
    }

    for (e = 1;; e *= 10)
    {
      System.out.println("e: " + e);
      if (t - e <= n)
      {
        System.out.println("answer: " + (t - e) );
        System.out.println("-------------------");
        return t - e;
      }
    }
  }

  // My solution: This works but it is highly inefficient and times out
  public static long solve(long n)
  {
    long highestNum = 0;
    long highestSum = 0;
    LinkedList<Long> stack = new LinkedList<>();

    for (long i = n; i >= 0; i--)
    {

      long number = i;

      while (number > 0)
      {
        stack.push(number % 10);
        number = number / 10;
      }

      while (!stack.isEmpty())
      {
        number += stack.pop();
      }

      if (number > highestSum)
      {
        highestNum = i;
        highestSum = number;
      }

    }

    return highestNum;
  }

  // Test cases
  public static class SolutionTest
  {
    @Test
    public void singleDigitTests()
    {
      assertEquals(1L, MaxDigitSum.solve(1L));
      assertEquals(2L, MaxDigitSum.solve(2L));
    }

    @Test
    public void basicTests()
    {
      assertEquals(18L, MaxDigitSum.solve(18L));
      assertEquals(48L, MaxDigitSum.solve(48L));
      assertEquals(99L, MaxDigitSum.solve(100L));
      assertEquals(9L, MaxDigitSum.solve(10L));
      assertEquals(99L, MaxDigitSum.solve(110L));
      assertEquals(1999L, MaxDigitSum.solve(2090L));
      //assertEquals(9999989L, MaxDigitSum.solve(9999992L));
      //assertEquals(999999999989L, MaxDigitSum.solve(999999999992L));
    }

    @Test
    public void theirTests()
    {
      assertEquals(18L, MaxDigitSum.solveTheirs(18L));
      assertEquals(48L, MaxDigitSum.solveTheirs(48L));
      assertEquals(99L, MaxDigitSum.solveTheirs(100L));
      assertEquals(9L, MaxDigitSum.solveTheirs(10L));
      assertEquals(99L, MaxDigitSum.solveTheirs(110L));
      assertEquals(1999L, MaxDigitSum.solveTheirs(2090L));
      assertEquals(9999989L, MaxDigitSum.solveTheirs(9999992L));
      assertEquals(999999999989L, MaxDigitSum.solveTheirs(999999999992L));
    }

  }

}
