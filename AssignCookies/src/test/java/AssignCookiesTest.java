package com.assignCookies;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AssignCookiesTest {
  @Test
  public void test1() {
    int result = AssignCookies.assignCookies(new int[] {1,2,3}, new int[] {1,1});
    assertEquals(1, result);
  }

  @Test
  public void test2() {
    int result = AssignCookies.assignCookies(new int[] {1,2}, new int[] {1,2,3});
    assertEquals(2, result);
  }

  @Test
  public void test3() {
    int result = AssignCookies.assignCookies(new int[] {1,2,4}, new int[] {1,1,4});
    assertEquals(2, result);
  }

  @Test
  public void test4() {
    int result = AssignCookies.assignCookies(new int[] {1,2,3}, new int[] {1,2,3});
    assertEquals(3, result);
  }
}
