package io.github.itzjamez.apricot.builder.item;

import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class FireworkBuilder extends ItemBuilder
{
    private FireworkMeta fireworkMeta;
    
    public FireworkBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public FireworkBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }

    public FireworkBuilder addEffect(FireworkEffect... effect)
    {
        this.fireworkMeta = (FireworkMeta) super.itemMeta;
        this.fireworkMeta.addEffects(effect);
        super.itemStack.setItemMeta(fireworkMeta);
        return this;    
    }

    public FireworkBuilder addEffects(Iterable<FireworkEffect> effects)
    {
        this.fireworkMeta = (FireworkMeta) super.itemMeta;
        this.fireworkMeta.addEffects(effects);
        super.itemStack.setItemMeta(fireworkMeta);
        return this;    
    }

    public FireworkBuilder setPower(Integer power)
    {
        this.fireworkMeta = (FireworkMeta) super.itemMeta;
        this.fireworkMeta.setPower(power);
        super.itemStack.setItemMeta(fireworkMeta);
        return this;    
    }

}
