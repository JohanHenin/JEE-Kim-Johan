package kava.lang;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathTest {

  @Test
  public void canAbsNegatif() {
    int result = Math.abs(-2);
    assertEquals(2,result);
  }
  
  @Test
  public void canAbsPositif() {
    int result = Math.abs(2);
    assertEquals(2,result);
  }
  
  @Test
  public void canAbsNul() {
    int result = Math.abs(0);
    assertEquals(0,result);
  }


}
