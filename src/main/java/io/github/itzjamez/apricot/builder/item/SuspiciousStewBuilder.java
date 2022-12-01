package io.github.itzjamez.apricot.builder.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SuspiciousStewMeta;
import org.bukkit.potion.PotionEffect;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class SuspiciousStewBuilder extends ItemBuilder
{
    private SuspiciousStewMeta stewMeta;

    public SuspiciousStewBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public SuspiciousStewBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }

    public SuspiciousStewBuilder addCustomEffect(PotionEffect effect)
    {
        this.stewMeta = (SuspiciousStewMeta) super.itemMeta;
        this.stewMeta.addCustomEffect(effect, true);
        super.itemStack.setItemMeta(stewMeta);
        return this;
    }       
}
