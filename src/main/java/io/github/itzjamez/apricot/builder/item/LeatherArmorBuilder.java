package io.github.itzjamez.apricot.builder.item;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class LeatherArmorBuilder extends ItemBuilder 
{
    private LeatherArmorMeta leatherArmorMeta;

    public LeatherArmorBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public LeatherArmorBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }

    public LeatherArmorBuilder setColor(Color color)
    {
        this.leatherArmorMeta = (LeatherArmorMeta) super.itemMeta;
        this.leatherArmorMeta.setColor(color);
        super.itemStack.setItemMeta(leatherArmorMeta);
        return this;
    }

    public LeatherArmorBuilder setRandomColor()
    {
        Integer min = 0, max = 255, number = new Random().nextInt(max - min + 1) + min;

        setColor(Color.fromRGB(number, number, number));
        return this;
    }
    
}
