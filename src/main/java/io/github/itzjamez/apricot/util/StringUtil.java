package io.github.itzjamez.apricot.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class StringUtil
{
    public static String colorizeString(String string) 
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static List<String> colorizeStringList(List<String> list) 
    {
        List<String> result = new ArrayList<>();

        for (String string : list) 
        {
            string = colorizeString(string);
        }

        return result;
    }


    public static String colorizeAlternatingStringList(List<String> list, ChatColor colorOne, ChatColor colorTwo) 
    {
        String result = "";
        
        for (String string : list)
        {
            result = String.valueOf(result) + ((list.indexOf(string) % 2 == 0) ? colorOne : colorTwo) + string + " ";
        }

        return result;    
    }
}
