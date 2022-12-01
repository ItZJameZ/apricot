package io.github.itzjamez.apricot.files;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public abstract class YamlFile
{
    private File file = null;
    private YamlConfiguration yaml = new YamlConfiguration();

    public YamlFile(String path)
    {
        this.file = new File(path);
        load();
    }

    public String getName()
    {
        return this.file.getName();
    }

    public Object get(String path)
    {
        return this.yaml.get(path);
    }

    public Integer getInt(String path)
    {
        return this.yaml.getInt(path);
    }

    public Double getDouble(String path)
    {
        return this.yaml.getDouble(path);
    }

    public String getString(String path)
    {
        return this.yaml.getString(path);
    }

    public Boolean getBoolean(String path)
    {
        return this.yaml.getBoolean(path);
    }

    public List<String> getStringList(String path)
    {
        return this.yaml.getStringList(path);
    }

    public void createNewStringList(String path, List<String> list)
    {
        this.yaml.set(path, list);
        save();
    }

    public void addToStringList(String path, String obj)
    {
        this.yaml.getStringList(path).add(obj);
        save();
    }

    public void removeFromStringList(String path, String obj)
    {
        this.yaml.getStringList(path).remove(obj);
        save();
    }

    public List<Integer> getIntegerList(String path)
    {
        return this.yaml.getIntegerList(path);
    }

    public void createNewIntegerList(String path, List<Integer> list)
    {
        this.yaml.set(path, list);
        save();
    }

    public void addToIntegerList(String path, Integer obj)
    {
        this.yaml.getIntegerList(path).add(Integer.valueOf(obj));
        save();
    }

    public void removeFromIntegerList(String path, Integer obj)
    {
        this.yaml.getIntegerList(path).remove(obj);
        save();
    }

    public void increment(String path)
    {
        increment(path, 1);
        save();
    }

    public void decrement(String path)
    {
        decrement(path, 1);
        save();
    }

    public void increment(String path, Integer value)
    {
        this.yaml.set(path, getInt(path) + value);
        save();
    }

    public void decrement(String path, Integer value)
    {
        this.yaml.set(path, getInt(path) - value);
        save();
    }

    public ConfigurationSection getConfigurationSection(String s)
    {
        return this.yaml.getConfigurationSection(s);
    }

    public void createConfigurationSection(String s)
    {
        this.yaml.createSection(s);
        save();
    }

    public YamlConfigurationOptions options()
    {
        return this.yaml.options();
    }

    public void createFile()
    {
        if (!this.file.exists())
        {
            try
            {
                this.file.createNewFile();
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void load()
    {
        try
        {
            this.yaml.load(this.file);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void save()
    {
        try
        {
            this.yaml.save(this.file);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void delete()
    {
        if (this.file.exists())
        {
            try
            {
                this.file.delete();
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void reload()
    {
        save();
        load();
    }

    public void add(String s, Object o)
    {
        if (!contains(s))
        {
            set(s, o);
            save();
        }
    }

    public void remove(String s)
    {
        set(s, null);
        save();
    }

    public Boolean contains(String s)
    {
        return this.yaml.contains(s);
    }

    public void set(String path, Object value)
    {
        this.yaml.set(path, value);
        save();
    }

    public Boolean doesFileExist()
    {
        if (!this.file.exists())
        {
            return false;
        }
        return true;
    }

    public void addDefault(String path, Object obj)
    {
        if (!this.yaml.contains(path))
        {
            set(path, obj);
        }
    }

    public void clear()
    {
        delete();
        createFile();
    }
}
