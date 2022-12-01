package io.github.itzjamez.apricot.exceptions;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class MenuInvalidColumn extends RuntimeException
{
    public MenuInvalidColumn(String column) 
    {
        super(String.format("Could not add item to Menu -- Passed in Column (%s) is Invalid, Needs to be between 1 - 9", column));
    }
}
