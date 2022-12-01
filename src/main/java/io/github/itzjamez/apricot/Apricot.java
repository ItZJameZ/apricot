package io.github.itzjamez.apricot;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.itzjamez.apricot.logger.Logger;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/} 
 **/
public class Apricot extends JavaPlugin 
{
    private static Apricot instance;

    @Override
    public void onEnable() 
    {
        instance = this;
        Logger.log("Enabled Apricot-API v" + getDescription().getVersion());
        Logger.log("------------------------------------");
        Logger.log("Apricot is a API and not meant to be used as a plugin");
        Logger.log("To learn more visit https://github.com/ItZJameZ/Apricot");
        Logger.log("------------------------------------");
    }

    @Override
    public void onDisable() 
    {
        Logger.log("Disabled Apricot-API v" + getDescription().getVersion());
    }

    public static Plugin getInstance() 
    {
        return instance;
    }
}
