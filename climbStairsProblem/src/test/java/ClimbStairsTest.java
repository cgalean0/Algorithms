package climbStairsProblem;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
public class ClimbStairsTest {
  
  private static Stream<Arguments> providerClimbStairsProblem(){
    return Stream.of(
        Arguments.of(1, 1),
        Arguments.of(2, 2),
        Arguments.of(3, 3),
        Arguments.of(6, 13)
    );
  }


  @ParameterizedTest
  @MethodSource("providerClimbStairsProblem")
  public void solvedProblemTest(int n, int expected) {
    ClimbStairs cs = new ClimbStairs();
    int result = cs.climbStairsSolutionMEMO(n);
    assertEquals(expected, result);
  }
}
