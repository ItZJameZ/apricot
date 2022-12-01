package io.github.itzjamez.apricot.builder.item;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class BannerBuilder extends ItemBuilder
{
    private BannerMeta bannerMeta;

    public BannerBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public BannerBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }

    public BannerBuilder addPattern(Pattern pattern)
    {
        this.bannerMeta = (BannerMeta) super.itemMeta;
        this.bannerMeta.addPattern( pattern );
        super.itemStack.setItemMeta( bannerMeta );
        return this;
    }

    public BannerBuilder setPattern(Integer index, Pattern pattern)
    {
        this.bannerMeta = (BannerMeta) super.itemMeta;
        this.bannerMeta.setPattern( index, pattern );
        super.itemStack.setItemMeta( bannerMeta );
        return this;
    }

    public BannerBuilder setPattern(List<Pattern> patterns)
    {
        this.bannerMeta = (BannerMeta) super.itemMeta;
        this.bannerMeta.setPatterns( patterns );
        super.itemStack.setItemMeta( bannerMeta );
        return this;
    }
}
