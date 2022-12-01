package io.github.itzjamez.apricot.builder.commands;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import io.github.itzjamez.apricot.logger.Logger;
import lombok.Getter;

@Getter
/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public abstract class CommandBuilder implements TabExecutor
{
    protected List<String> usage;
    protected HashMap<Integer, List<String>> tab = new HashMap<>();

    /** Name of Command */
    public abstract String getCommandName();

    /** Permission for Command. */
    public abstract String getPermission();

    /** Put code for the Command Here */
    public abstract Boolean run(CommandSender sender, String[] args);

    public static CommandMap commandMap;

    public void sendUsageMessage(CommandSender sender)
    {
        for (String string : usage) 
        {            
            sender.sendMessage(string);
        }
    }

    public void register()
    {
        Boolean success = true;

        try
        {
            ReflectCommand cmd = new ReflectCommand(getCommandName());

            getCommandMap().register(null, cmd);
            cmd.setExecutor(this);
        }
        catch (Exception ex)
        {
            success = false;
            ex.printStackTrace();
        }

        if (!success)
        {
            Logger.logError("Could not load Command -- (" + getCommandName() + ")");
        }
    }

    final CommandMap getCommandMap()
    {
        if (commandMap == null)
        {
            try
            {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                commandMap = (CommandMap) f.get(Bukkit.getServer());
                return getCommandMap();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (commandMap != null)
        {
            return commandMap;
        }
        return getCommandMap();
    }

    private final class ReflectCommand extends Command
    {
        private CommandBuilder exe = null;

        protected ReflectCommand(String command)
        {
            super(command);
        }

        public void setExecutor(CommandBuilder exe)
        {
            this.exe = exe;
        }

        @Override
        public boolean execute(CommandSender sender, String commandLabel, String[] args)
        {
            if (exe != null)
            {
                return exe.onCommand(sender, this, commandLabel, args);
            }
            return false;
        }

        @Override
        public List<String> tabComplete(CommandSender sender, String alais, String[] args)
        {
            if (exe != null)
            {
                return exe.onTabComplete(sender, this, alais, args);
            }
            return null;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (this.tab != null)
        {
            List<String> list = new ArrayList<String>();

            int length = args.length;

            if (this.tab.containsKey(length))
            {
                return this.tab.get(length);
            }

            return list;
        }

        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        run(sender, args);
        return false;
    }
}
