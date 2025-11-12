package util;
import java.util.List;
import java.util.ArrayList;
/**
 * Greedy Policemen catch thieves.
 *
 * @author sonia
 *
 */

public final class CatchThieves {
   
  
  /**
   * Returns the maximum number of thieves that can be caught.
   * Each policeman can catch only one thief which is at most k away from him.
   * @param seqTP is the sequence of thieves and policemen, t or p.
   * @param distanceK represent the units away from the policemen to catch a thieve.
   * @return the maximum number of thieves that can be caught.
   */
  public final int maxCatch(final char []seqTP, final int distanceK) {
      if (seqTP == null)
        throw new IllegalArgumentException();
      if (distanceK < 0)
        throw new IllegalArgumentException();
        
      List<Integer> listOfP = new ArrayList<>();
      List<Integer> listOfT = new ArrayList<>();
      
      for (int i = 0; i < seqTP.length; i++) {
        if (seqTP[i] == 'T')
          listOfT.add(i);
        else if (seqTP[i] == 'P')
          listOfP.add(i);
      }

      int i = 0, j = 0, captures = 0;
      while (i < listOfP.size() && j < listOfT.size()) {
          if (listOfP.get(i) - listOfT.get(j) <= distanceK) {
            captures++;
            i++;
            j++;
          } else {
            j++;
          }
      }

      return captures;
  }  
}   
