package com.thoughtworksinc;

import org.junit.Test;
import static org.junit.Assert.*;

public class FailingTest {
   @Test
   public void testThatFails() {
       Rover rover = new Rover();
       rover.setPosition(1, 2, 1);  // N= 1, E=2, S=3, W=4
       rover.process("LMLMLMLMM");
       rover.printPosition(); // prints 1 3 N

       rover.setPosition(3, 3, 2);
       rover.process("MMRMMRMRRM");
       rover.printPosition(); // prints 5 1 E
       //assertTrue("This should fail", false);
   }
}
