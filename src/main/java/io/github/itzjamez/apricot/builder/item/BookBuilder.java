package io.github.itzjamez.apricot.builder.item;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/}
 **/
public class BookBuilder extends ItemBuilder 
{
    private BookMeta bookMeta;

    public BookBuilder(ItemStack itemStack) 
    {
        super(itemStack);
    }

    public BookBuilder(Material material, Integer amount) 
    {
        super(material, amount);
    }
   
    public BookBuilder setAuthor(String author) 
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.setAuthor(author);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }

    public BookBuilder setTitle(String title) 
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.setAuthor(title);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }

    public BookBuilder addPage(String... pages)
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.addPage(pages);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }

    public BookBuilder setPage(Integer index, String page)
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.setPage(index, page);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }

    public BookBuilder setPages(String... pages)
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.setPages(pages);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }

    public BookBuilder setPages(List<String> pages)
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.setPages(pages);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }

    public BookBuilder setGeneration(BookMeta.Generation generation)
    {
        this.bookMeta = (BookMeta) super.itemMeta;
        this.bookMeta.setGeneration(generation);
        super.itemStack.setItemMeta(bookMeta);
        return this;
    }
}
