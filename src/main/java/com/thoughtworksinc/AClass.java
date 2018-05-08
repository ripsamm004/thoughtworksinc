package com.thoughtworksinc;

public class AClass {

    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, 1);  // N= 1, E=2, S=3, W=4
        rover.process("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N

        rover.setPosition(3, 3, 2);
        rover.process("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E

    }

}


