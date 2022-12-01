package io.github.itzjamez.apricot;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import io.github.itzjamez.apricot.builder.commands.CommandBuilder;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public final class ApricotCommand extends CommandBuilder
{
    @Override
    public String getCommandName() 
    {
        return "Apricot";
    }

    @Override
    public String getPermission() 
    {
        return null;
    }

    @Override
    public Boolean run(CommandSender sender, String[] args) 
    {
        sender.sendMessage(ChatColor.YELLOW + "Apricot API v" + Apricot.getInstance().getDescription().getVersion() + " made by ItZ_JameZ_" + ChatColor.WHITE + "http://itzjamez.github.io/");   
        sender.sendMessage(ChatColor.YELLOW + Apricot.getInstance().getDescription().getDescription());
        return false;
    }
}
