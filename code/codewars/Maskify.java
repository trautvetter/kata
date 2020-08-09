package kata.code.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Maskify {

  /* maskify
   *
   * Mask all but the last 4 characters with a hash
   */

  // My solution
  public static String maskify(String str) {

    final String hash = "#";
    String hashes = "";

    // Length of the part of the string that will remain unmasked will
    // be 4 if the string is longer than 4 to begin with
    int keepLength = str.length();
    if (str.length() > 4){
      keepLength = 4;
    }

    // Generate a string of hashes the required length of the mask
    for (int i = 0; i < str.length() - keepLength; ++i ){
      hashes += hash;
    }

    // Concatenate the mask and the unmasked portion of the original string and return
    return hashes + str.substring(str.length()-keepLength , str.length());
  }


  // Test cases
  public static class SolutionTest {
    @Test
    public void testSolution() {
      assertEquals("############5616", Maskify.maskify("4556364607935616"));
      assertEquals("#######5616",      Maskify.maskify(     "64607935616"));
      assertEquals("1",                Maskify.maskify(               "1"));
      assertEquals("",                 Maskify.maskify(                ""));

      // "What was the name of your first pet?"
      assertEquals("##ippy",                                    Maskify.maskify("Skippy")                                  );
      assertEquals("####################################man!",  Maskify.maskify("Nananananananananananananananana Batman!"));
    }
  }

}
