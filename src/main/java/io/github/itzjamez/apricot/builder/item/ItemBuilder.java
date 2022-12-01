package io.github.itzjamez.apricot.builder.item;

import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.itzjamez.apricot.util.StringUtil;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class ItemBuilder 
{
    protected ItemStack itemStack;
    protected ItemMeta itemMeta;

    public ItemBuilder(Material material, Integer amount) 
    {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(ItemStack itemStack) 
    {
        this.itemStack = itemStack;
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder setAmount(Integer amount)
    {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setType(Material material)
    {
        this.itemStack.setType(material);
        return this;
    }

    public ItemBuilder setItemMeta(ItemMeta itemMeta)
    {
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, Integer level)
    {
        this.itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment)
    {
        addEnchantment(enchantment, enchantment.getStartLevel());
        return this;
    }

    public ItemBuilder addEnchantment(Map<Enchantment,Integer> enchantments)
    {
        this.itemStack.addUnsafeEnchantments(enchantments);
        return this;
    }

    public ItemBuilder setName(String name)
    {
        this.itemMeta = this.itemStack.getItemMeta();
        this.itemMeta.setDisplayName( StringUtil.colorizeString(name) );
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemBuilder setLore(List<String> lore)
    {
        this.itemMeta = this.itemStack.getItemMeta();
        this.itemMeta.setLore( StringUtil.colorizeStringList(lore) );
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }
        
    public ItemBuilder setUnbreakable(Boolean zoolean)
    { 
        this.itemMeta = this.itemStack.getItemMeta();
        this.itemMeta.setUnbreakable(zoolean);
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemBuilder addFlag(ItemFlag itemFlag)
    { 
        this.itemMeta = this.itemStack.getItemMeta();
        this.itemMeta.addItemFlags(itemFlag);
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemBuilder addAttributeModifier(Attribute attribute, AttributeModifier modifier)
    {
        this.itemMeta = this.itemStack.getItemMeta();
        this.itemMeta.addAttributeModifier(attribute, modifier);
        this.itemStack.setItemMeta(this.itemMeta);
        return this;
    }

    public ItemBuilder setDamage(Integer damageAmount)
    {
        Damageable damageable = (Damageable) this.itemStack.getItemMeta();
        damageable.setDamage(damageAmount);
        this.itemStack.setItemMeta( damageable );
        return this;
    }

    public ItemStack create()
    {
        return this.itemStack; 
    }
}
