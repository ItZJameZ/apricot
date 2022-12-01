package io.github.itzjamez.apricot.builder.item;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class TropicalFishBucketBuilder extends ItemBuilder
{
    private TropicalFishBucketMeta bucketMeta; 

    public TropicalFishBucketBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public TropicalFishBucketBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }
    
    public TropicalFishBucketBuilder setBodyColor(DyeColor color)
    {
        this.bucketMeta = (TropicalFishBucketMeta) super.itemMeta;
        this.bucketMeta.setBodyColor(color);
        super.itemStack.setItemMeta(bucketMeta);
        return this;
    }
    
    public TropicalFishBucketBuilder setPattern(TropicalFish.Pattern pattern)    
    {
        this.bucketMeta = (TropicalFishBucketMeta) super.itemMeta;
        this.bucketMeta.setPattern(pattern);
        super.itemStack.setItemMeta(bucketMeta);
        return this;
    }
    
    public TropicalFishBucketBuilder setPatternColor(DyeColor color)
    {
        this.bucketMeta = (TropicalFishBucketMeta) super.itemMeta;
        this.bucketMeta.setPatternColor(color);
        super.itemStack.setItemMeta(bucketMeta);
        return this;
    }    
}
