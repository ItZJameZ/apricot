package io.github.itzjamez.apricot.builder.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import io.github.itzjamez.apricot.exceptions.InvalidItemException;
import io.github.itzjamez.apricot.exceptions.MenuInvalidColumn;
import io.github.itzjamez.apricot.exceptions.MenuInvalidParameterException;
import io.github.itzjamez.apricot.exceptions.MenuInvalidRow;
import io.github.itzjamez.apricot.exceptions.MenuOutOfBoundsException;
import io.github.itzjamez.apricot.util.NumberUtil;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/} 
 * <br><br> Used to Create Menu's to make a Menu that needs Pages use <b>PaginatedMenuBuilder</b>
 * @see PaginatedMenuBuilder
 **/
public abstract class MenuBuilder implements InventoryHolder
{
    /** Inventory object */
    protected Inventory inventory;

    /** Minimum Amount of Rows that Can be in the Menu <b><em>*Do Not Edit*</em></b> */ 
    protected final Integer MIN_ROWS = 1;

    /** Maximum Amount of Rows that Can be in the Menu <b><em>*Do Not Edit*</em></b> */ 
    protected final Integer MAX_ROWS = 6;

    /** Row Length <b><em>*Do Not Edit*</em></b> */ 
    protected final Integer ROW_LENGTH = 9;

    /** Name of Menu */
    public abstract String getMenuName();

    /** Amount of Rows in the Menu */
    public abstract Integer getRows();

    /** EventHandler for Menu */
    public abstract void handleMenu(InventoryEvent event);

    /** Returns Max Inventory Size */
    public Integer getMaxInventorySize()
    {
        return (getRows() * this.ROW_LENGTH);
    }

    /** Calulates Index With passed in Row and Column i.e (X & Y) */
    private Integer getIndexFromXY(Integer row, Integer column) 
    {
        return (((row - 1) * this.ROW_LENGTH) + (column - 1));
    }

    /** Sets Item in the Menu with passed in Row & Column */
    public void setItem(Integer row, Integer column, ItemStack itemStack) 
    {
        if (!NumberUtil.withinRange(row, this.MIN_ROWS, getRows()))
        {
            throw new MenuInvalidRow(String.valueOf(row));
        }

        if (!NumberUtil.withinRange(column, 1, 9))
        {
            throw new MenuInvalidColumn(String.valueOf(column));
        }

        setItem( getIndexFromXY(row, column) , itemStack);
    }

    /** Sets Item in the Menu with passed in Index */
    public void setItem(Integer index, ItemStack itemStack)
    {
        if (index > getMaxInventorySize())
        {
            throw new MenuOutOfBoundsException(index, getMaxInventorySize());
        }

        if (itemStack == null || itemStack.getType() == null || itemStack.getType().isAir())
        {
            throw new InvalidItemException();
        }

        this.inventory.setItem(index, itemStack);
    }

    /** Set Contents of Menu */
    public void setItems(ItemStack[] items)
    {
        if (items.length > getMaxInventorySize())
        {
            throw new MenuOutOfBoundsException(items.length, getMaxInventorySize());
        }
        
        this.inventory.setContents(items);          
    }

    /** Creates the Inventory */
    public Inventory create()
    {
        if (getMenuName() == null)
        {
            throw new MenuInvalidParameterException("Name");
        }

        if (getRows() < this.MIN_ROWS || getRows() > this.MAX_ROWS || getRows() == null)
        {
            throw new MenuInvalidParameterException("Row Count -- Needs to be between 1 - 6");
        }

        return Bukkit.createInventory(this, getMaxInventorySize(), getMenuName());
    }

    /** Open the Menu */
    public void open(Player player) 
    {
        player.openInventory(this.inventory);
    }
}
