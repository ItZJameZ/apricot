package io.github.itzjamez.apricot.builder.item;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class CompassBuilder extends ItemBuilder 
{
    private CompassMeta compassMeta;

    public CompassBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public CompassBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }

    public CompassBuilder setLodestone(Location location)
    {
        this.compassMeta = (CompassMeta) super.itemMeta;
        this.compassMeta.setLodestone(location);
        super.itemStack.setItemMeta(compassMeta);
        return this;
    }

    public CompassBuilder setLodestoneTracked(boolean tracked)
    {
        this.compassMeta = (CompassMeta) super.itemMeta;
        this.compassMeta.setLodestoneTracked(tracked);
        super.itemStack.setItemMeta(compassMeta);
        return this;
    }
}
