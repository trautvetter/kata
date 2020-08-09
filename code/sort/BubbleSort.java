package kata.code.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort
{

//  procedure bubbleSort( A : list of sortable items )
//  n = length(A)
//  repeat
//      newn = 0
//      for i = 1 to n-1 inclusive do
//          if A[i-1] > A[i] then
//              swap(A[i-1], A[i])
//              newn = i
//          end if
//      end for
//      n = newn
//  until n <= 1
//  end procedure

  public static void main(String[] args)
  {

    int size = 10;
    Integer[] nums = new Integer[size];// {9,8,7,5,5,7,3,2,1,4,8,6,5,4,7,8,9,6,2,5,3,6,1,4,7,8,51,2,3,9};
    Random r = new Random();
    int low = 0;
    int high = 10 + 1;
    for (int i = 0; i < size; i++)
    {
      nums[i] = r.nextInt(high - low) + low;
    }

    int n = nums.length;

    int buffer;

    int loopCounter = 0;

    System.out.println(loopCounter + ": " + Arrays.toString(nums));

    while (n > 1)
    {

      int newn = 0;
      for (int i = 1; i <= n-1; i++)
      {
        loopCounter++;
        if (nums[i-1] > nums[i])
        {
          // swap
          buffer = nums[i-1];
          nums[i-1] = nums[i];
          nums[i] = buffer;
          newn = i;
        }
        System.out.println(loopCounter + ": " + Arrays.toString(nums));
      }
      n = newn;
    }

  }

}
