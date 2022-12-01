package io.github.itzjamez.apricot.builder.item;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class PotionBuilder extends ItemBuilder
{
    private PotionMeta potionMeta;

    public PotionBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public PotionBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }
 
    public PotionBuilder addCustomEffect(PotionEffect effect)
    {
        this.potionMeta = (PotionMeta) super.itemMeta;
        this.potionMeta.addCustomEffect(effect, true);
        super.itemStack.setItemMeta(potionMeta);
        return this;
    }   

    public PotionBuilder setColor(Color color)
    {
        this.potionMeta = (PotionMeta) super.itemMeta;
        this.potionMeta.setColor(color);
        super.itemStack.setItemMeta(potionMeta);
        return this;
    }
}
