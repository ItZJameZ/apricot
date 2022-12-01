package io.github.itzjamez.apricot.exceptions;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class MenuInvalidRow extends RuntimeException
{
    public MenuInvalidRow(String row) 
    {
        super(String.format("Could not add item to Row -- Passed in Row (%s) is Invalid, Needs to be between 1 - 6", row));
    }
}
