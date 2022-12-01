package io.github.itzjamez.apricot.exceptions;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class MenuOutOfBoundsException extends RuntimeException
{
    public MenuOutOfBoundsException(Integer index, Integer menuSize) 
    {
        super(String.format("Could not add item(s) to Menu -- Passed in index (%s) is larger than Menu Size (%s)", index, menuSize));
    }
}
