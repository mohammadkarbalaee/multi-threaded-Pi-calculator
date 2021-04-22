package sbu.cs.exception;

import java.util.List;

public class Reader {

    /**
     * declare 2 Exception class. 1 for UnrecognizedCommand and 1 for NotImplementedCommand
     * iterate on function inputs and check for commands and throw exception when needed.
     *
     * @param args
     */
    public void readTwitterCommands(List<String> args) {
        throw new RuntimeException();
    }

    /**
     * function inputs are String but odd positions must be integer parsable
     * a valid input is like -> "ap", "2", "beheshti", "3992", "20"
     * throw BadInput exception when the string is not parsable.
     *
     * @param args
     */
    public void read(String...args) {

    }
}
