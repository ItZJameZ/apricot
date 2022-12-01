package io.github.itzjamez.apricot.exceptions;

public class MenuInvalidParameterException extends RuntimeException
{
    public MenuInvalidParameterException(String parameter) 
    {
        super("Could Not Load Menu -- Invalid " + parameter);
    }
}
