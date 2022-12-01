package io.github.itzjamez.apricot.builder.menu;

/**
 * @author ItZ_JameZ_ -- {@link http://itzjamez.github.io/} 
 **/
public abstract class PaginatedMenuBuilder extends MenuBuilder
{
    //TODO add more features
    // test

    /** Represents what page the Menu is on */
    protected Integer page = 1;

    protected Integer index = 0;
    
    final protected Integer maxItemsPerPage;
    
    public PaginatedMenuBuilder(Integer maxItemsPerPage) 
    {
        this.maxItemsPerPage = maxItemsPerPage;
    }

    public abstract Integer getPage();
} 
