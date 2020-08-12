package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class SupemarketQueue {

  /*
   * https://www.codewars.com/kata/57b06f90e298a7b53d000a86 (6kyu)
   *
   * There is a queue for the self-checkout tills at the supermarket.
   * Your task is write a function to calculate the total time required for all the customers to check out.
   *
   * input:
   * customers: an array of positive integers representing the queue. Each integer represents a customer, and its value is the amount of time they require to check out.
   * n: a positive integer, the number of checkout tills.
   *
   * output:
   * The function should return an integer, the total time required.
   *
   * There is only ONE queue serving many tills, and
   * The order of the queue NEVER changes, and
   * The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
   *
   */

  // My solution


  public static int solveSuperMarketQueue(int[] customers, int n) {

    List<Stack<Integer>> tills = new ArrayList<>();
    int totaltime = 0;
    int queueSize = customers.length;
    int currentCustomer = 0;
    int tillOccupancyCount = 0;

    // Create a stack to represent each till
    for (int i = 0; i < n; i++) {
      tills.add(new Stack<Integer>());
    }

    boolean addTime = false;
    while (queueSize > 0 || tillOccupancyCount > 0) {

      // Fill up tills with customers
      for (Stack<Integer> till : tills) {
        // Till is available
        if (till.isEmpty()) {
          // Push a customer into the till if there are still any in the queue
          if (queueSize > 0) {
            till.add(customers[currentCustomer++]);
            tillOccupancyCount++;
            queueSize--;
          }
        }
      }

      for (Stack<Integer> till : tills) {
        // Decrement the number of minutes the customer has remaining, or remove them from the till
        if (!till.isEmpty()) {
          // only add time to the count if there was some change to the customer's record of time
          addTime = true;
          int minsRemaining = till.pop();
          if (minsRemaining > 1) {
            till.push(minsRemaining - 1);
          } else {
            till.empty();
            tillOccupancyCount--;
          }
        }
      }

      // Time is added collectively for all tills
      if (addTime) {
        totaltime++;
        addTime = false;
      }

    }

    return totaltime;
  }


  // Their solution
  public static int solveSuperMarketQueueTheirs(int[] customers, int n) {
    // Create array representing n tills
    int[] tills = new int[n];

    for(int i = 0; i < customers.length; i++){

      // Add each customer's time to the next available till
      // represented by the tills being sorted in ascending order. The number represents the
      // number of minutes until the till becomes available, thus we add
      // the next customer to the next available till
      tills[0] += customers[i];

      // Sorts ascending - thus moves tills with higher numbers to the end and lower number to
      // beginning. i.e. lowest number aka the till with the lowest number of minutes until it becomes available will
      // be in position 0 so that the next customer will go to that till.
      Arrays.sort(tills);
    }
    return tills[n-1];
  }


  // Test cases
  public static class SolutionTest {
    @Test
    public void testNormalCondition() {
      assertEquals(9, SupemarketQueue.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
      assertEquals(9, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
      assertEquals(0, SupemarketQueue.solveSuperMarketQueue(new int[] {}, 1));
      assertEquals(0, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
      assertEquals(15, SupemarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
      assertEquals(15, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    @Test
    public void testTwoTillsManyCustomers() {
      assertEquals(9, SupemarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 2));
      assertEquals(9, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] { 1, 2, 3, 4, 5 }, 2));
    }

    @Test
    public void testTwoTillsThreeCustomers() {
      assertEquals(4, SupemarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3 }, 2));
      assertEquals(4, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] { 1, 2, 3 }, 2));
    }

    @Test
    public void testRandomValues() {
      assertEquals(22, SupemarketQueue.solveSuperMarketQueue(new int[] { 1,5,6,4,1,7,6,1,3,6,7,6,5,5,7,4 }, 4));
      assertEquals(22, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] { 1,5,6,4,1,7,6,1,3,6,7,6,5,5,7,4 }, 4));
    }

    @Test
    public void testFiveSix() {
      assertEquals(7, SupemarketQueue.solveSuperMarketQueue(new int[] { 4,6,7,1,1 }, 6));
      assertEquals(7, SupemarketQueue.solveSuperMarketQueueTheirs(new int[] { 4,6,7,1,1 }, 6));
    }

  }

}
