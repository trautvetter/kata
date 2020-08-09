package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.*;

public class FindOutlier {


  /* Count the number of Duplicates
   *
   * You are given an array (which will have a length of at least 3, but could be very large) containing integers.
   * The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
   * Write a method that takes the array as an argument and returns this "outlier" N.
   */

  // My solution
  static int find(int[] integers) {
    int countOdd = 0;
    int countEven = 0;

    int lastEven = 0;
    int lastOdd = 0;

    for (int i = 0; i < integers.length; ++i) {
      if (integers[i] % 2 == 0) {
        lastEven = integers[i];
        countEven++;
      } else {
        lastOdd = integers[i];
        countOdd++;
      }

      // The test for early return
      if (countOdd > 1 && countEven == 1) {
        return lastEven;
      }

      if (countEven > 1 && countOdd == 1) {
        return lastOdd;
      }
    }

    return 0;
  }

  // Their solution (not necessarily the best)
  public static int findTheirs(int[] integers) {
    // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

    // We only need the first 3 integers to determine whether we are chasing odds or evens.
    // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
    // It will be 0 for even numbers and 1 for odd numbers.
    // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
    int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
    int mod = (sum == 0 || sum == 1) ? 1 : 0;

    return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
            .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
  }

  // Test cases
  public static class OutlierTest {
    @Test
    public void testExample() {
      int[] exampleTest1 = {2,6,8,-10,3};
      int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
      int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
      assertEquals(3, FindOutlier.find(exampleTest1));
      assertEquals(3, FindOutlier.findTheirs(exampleTest1));
      assertEquals(206847684, FindOutlier.find(exampleTest2));
      assertEquals(206847684, FindOutlier.findTheirs(exampleTest2));
      assertEquals(0, FindOutlier.find(exampleTest3));
      assertEquals(0, FindOutlier.findTheirs(exampleTest3));
    }}

}
