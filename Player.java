import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;
/**
 * Creates a new player upon starting the game.
 * 
 * @author 162224
 * @version 15/11
 * 
 */
public class Player
{
    //The player variables are their name and inventory
    public String playerName; 
    public HashMap<String, Item> inventory;
    public HashMap<String, Creature> friends;
    public HashMap<String, Creature> defeated;

    public Player()
    {
        inventory = new HashMap<String, Item>();
        friends = new HashMap<String, Creature>();
        defeated = new HashMap<String, Creature>();
    }
    


    /**
     * Retrieves an item from the inventory.
     * @param Item string description
     * @return Item object
     */
    
     public Item getItem(String content)
    {
        return inventory.get(content);
    }
    
     /**
     * Adds an item to the inventory.
     */
     public void addItem(String content, Item item)
    {
        inventory.put(content, item);
    }
    
    /**
     * Removes an item from the inventory.
     */
     public void removeItem(String item)
    {
        inventory.remove(item);
    }
    
    /**
     *Brings a companion with you on your journey.
     */
     public void addCompanion(String friend, Creature companion)
    {
        friends.put(friend, companion);
    }
    
    /**
     *Stores which bosses have been defeated.
     */
     public void addBoss(String dead, Creature boss)
    {
        defeated.put(dead, boss);
    }
    
    /**
     *Removes a companion from the players friends.
     */
    
    public void removeCompanion(String friend)
    {
        friends.remove(friend);
    }
    
    /**
     * Retrieves an item from the inventory.
     * @param Creature string description
     * @return Creature object
     */
    
    public Creature getCompanion(String friend)
    {
        return friends.get(friend);
    }
    
    /**
     * Prints a list of the items the player currently posseses.
     */
    public void viewInventory()
    {
       for (Item item : inventory.values()){
            String itemD = item.itemDesc;       
            System.out.println(itemD);
        } 
    }
    
    /**
     * Prints a list of the companions the player currently posseses.
     */
    public void viewCompanions()
    {
        
        for (Creature companion : friends.values()) {
        System.out.println(companion.name);
        }
     
    }
}
