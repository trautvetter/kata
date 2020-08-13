package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class Metro {

  /* Number of people in the bus (7kyu/fundamentals)
   * https://www.codewars.com/kata/5648b12ce68d9daa6b000099
   *
   * There is a bus moving in the city, and it takes and drop some people in each bus stop.
   *
   * You are provided with a list (or array) of integer arrays (or tuples). Each integer array has two items which represent number of people get into bus
   * (The first item) and number of people get off the bus (The second item) in a bus stop.
   *
   * Your task is to return number of people who are still in the bus after the last bus station (after the last array). Even though it is the last bus stop,
   * the bus is not empty and some people are still in the bus, and they are probably sleeping there :D
   *
   * Take a look on the test cases.
   * The number of people in the bus is always >= 0. So the return integer can't be negative.
   *
   * The second value in the first integer array is 0, since the bus is empty in the first bus stop.
   */

  // My solution
  public static int countPassengers(ArrayList<int[]> stops) {

    // Start with an empty bus
    int countOfPassengers = 0;

    for (int i = 0; i < stops.size(); i++) {
      countOfPassengers += stops.get(i)[0];
      countOfPassengers -= stops.get(i)[1];
    }

    return countOfPassengers;
  }

  // Their solution
  public static int countPassengersTheirs(ArrayList<int[]> stops) {
    return stops.stream()
                .mapToInt(x -> x[0] - x[1])
                .sum();
  }


  // Test cases
  public static class MetroTest {

    @Test
    public void test1() {
      ArrayList<int[]> list = new ArrayList<int[]>();
      list.add(new int[] {10,0});
      list.add(new int[] {3,5});
      list.add(new int[] {2,5});
      assertEquals(5, Metro.countPassengers(list));
    }
    @Test
    public void test2() {
      ArrayList<int[]> list = new ArrayList<int[]>();
      list.add(new int[] {10,0});
      list.add(new int[] {3,5});
      list.add(new int[] {2,5});
      assertEquals(5, Metro.countPassengersTheirs(list));
    }
  }

}
