package com.thoughtworks;

import com.thoughtworks.rover.MarsRover;
import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Direction;
import com.thoughtworks.rover.universe.Plateau;

public class AClass {

    public static void main(String args[]) {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,9);

        //When
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

        //then
        System.out.println(marsRover.currentLocation());

        marsRover.run("LMLMLMLMM");

        System.out.println(marsRover.currentLocation());

    }

}


