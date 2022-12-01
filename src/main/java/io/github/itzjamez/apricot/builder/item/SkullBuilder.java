package io.github.itzjamez.apricot.builder.item;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class SkullBuilder extends ItemBuilder
{
    private SkullMeta skullMeta;

    public SkullBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }

    public SkullBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }
    
    public SkullBuilder setOwner(OfflinePlayer owner)
    {
        this.skullMeta = (SkullMeta) super.itemMeta;
        this.skullMeta.setOwningPlayer(owner);
        super.itemStack.setItemMeta(skullMeta);
        return this;
    }

    public SkullBuilder setOwner(PlayerProfile profile)
    {
        this.skullMeta = (SkullMeta) super.itemMeta;
        this.skullMeta.setOwnerProfile(profile);
        super.itemStack.setItemMeta(skullMeta);
        return this;
    }
}
