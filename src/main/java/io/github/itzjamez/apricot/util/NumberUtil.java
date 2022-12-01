package io.github.itzjamez.apricot.util;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class NumberUtil 
{
    /** Checks if <b>value</b> is within range of <b>min</b> and <b>max</b> */
    public static Boolean withinRange(Integer vaue, Integer min, Integer max)
    {
        return (vaue > min && vaue < max);
    }    
}
