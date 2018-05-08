package com.thoughtworks;

import com.thoughtworks.rover.MarsRover;
import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Direction;
import com.thoughtworks.rover.universe.Plateau;

import java.io.*;
import java.util.Scanner;

public class AClass {

    /*public static void main(String args[]) {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,9);

        //When
        MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

        //then
        System.out.println(marsRover.currentLocation());

        marsRover.run("LMLMLMLMM");

        System.out.println(marsRover.currentLocation());

    }*/



    /***********************************************************************
    * Process a stream of commands and respond with a stream of status strings.
    * The input and output formats are specified in the INPUT and OUTPUT section
    * of the comments at the start of this source file
    */
    static void processCommandStream(BufferedReader input, BufferedWriter output) throws IOException {
        String line;
        int _x1 = 0, _y1 = 0;  	// Coordinates of top right of boundary
        int _x = 0, _y = 0;
        Direction d;
        Coordinates startingPosition;
        MarsRover marsRover;

        // Maximum boundary of the coordinate
        if ((line = input.readLine()) != null) {
            String[] parts = line.split(" ");
            _x1 = Integer.parseInt(parts[0]);
            _y1 = Integer.parseInt(parts[1]);
        }

        Plateau plateau = new Plateau(_x1,_y1);

        while (line != null) {
            if ((line = input.readLine()) != null) {

                String[] parts = line.split(" ");
                _x = Integer.parseInt(parts[0]);
                _y = Integer.parseInt(parts[1]);
                d = Direction.getByCode(parts[2]);
                startingPosition = new Coordinates(_x,_y);
                marsRover = new MarsRover(plateau, d, startingPosition);

                if ((line = input.readLine()) != null) {
                    marsRover.run(line);
                }

                output.write(marsRover.currentLocation() + '\n') ;
                output.flush();
            }
        }
    }

    /***********************************************************************
     * Program entry point
     * 	Processes a stream of rover commands as described in processCommandStream()
     * 	Reads input from stdin and writes output to stdout
     */
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            processCommandStream(input, output);
        } finally {
            input.close();
            output.close();
        }
    }

}


