package io.github.itzjamez.apricot.builder.item;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class CrossbowBuilder extends ItemBuilder
{
    private CrossbowMeta crossbowMeta;

    public CrossbowBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public CrossbowBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }
    
    public CrossbowBuilder setChargedProjectiles(List<ItemStack> projectiles)
    {
        this.crossbowMeta = (CrossbowMeta) super.itemMeta;
        this.crossbowMeta.setChargedProjectiles(projectiles);
        super.itemStack.setItemMeta(crossbowMeta);
        return this;    
    }
    
    public CrossbowBuilder addChargedProjectile(ItemStack projectile)
    {
        this.crossbowMeta = (CrossbowMeta) super.itemMeta;
        this.crossbowMeta.addChargedProjectile(projectile);
        super.itemStack.setItemMeta(crossbowMeta);
        return this;    
    }
}
