package model;

import util.Amount; 
import java.time.*;
import integration.Item;
import integration.ItemCatalog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Represents the actual sale done in the application
 */
public class Sale {
    private Summary summary;
    private LocalTime saleTime;
    private HashMap<Integer, Item> shoppingCart = new HashMap<>();

    /**
     * Creates a new instance of the Sale
     */
    public Sale() {
        this.summary = new Summary();
        setTimeOfSale();
    }

    /**
     * Get the summary of all products
     * 
     * @return the calculated sum of the products
     */
    public Summary getSummary() { return summary; }

    /**
     * Get the list of items
     * 
     * @return the list of items
     */
    public HashMap<String, Item> getShoppingCart() { return shoppingCart; }

    /**
     * Registers items and adds them to the shoppingcart
     * 
     * @param item the item and its information
     * @return the items and price
     */
    public String registerItems(Item item) {
        if(shoppingCartContains(item)) {
            updateItemQuantityAndPrice(item);
        }
        else {
            addNewItem(item);
        }
    }
  
    private boolean shoppingCartContains(Item item) {
        return shoppingCart.containsKey(item.getItemID());
    }

    private void updateItemQuantityAndPrice(Item item) {
        Item itemAlreadyExist = shoppingCart.get(item.getItemID());
        itemAlreadyExist.increaseQuantity(item.getItemQuantity());
        shoppingCart.put(itemAlreadyExist.getItemID(), itemAlreadyExist);
        summary.SummarizeSale(item);
    } 

    private void addNewItem(Item item) {
        shoppingCart.put(item.getItemID(), item);
        summary.SummarizeSale(item);
    }

    private void setTimeOfSale(Item item) {
        saleTime = LocalTime.now();
    }

    
    
    
}
