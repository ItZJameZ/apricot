package io.github.itzjamez.apricot.logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class Logger
{
    public static void log(String str)
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + str);
    }

    public static void logError(String errorMessage)
    {
        log(ChatColor.RED + "[ERROR]" + errorMessage);
    }
}
