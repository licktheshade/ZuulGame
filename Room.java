import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * The room may also contain, and additionally store Items or Creatures (both Companions and Bosses)
 * 
 * @author 162224
 * @version 13/11
 * 
 */

public abstract class Room 
{   
    public int RoomID;
    protected String description;
    protected String longdescription;
    protected String altdescription;
    protected HashMap<String, Room> exits; // stores exits of this room.
    protected HashMap<String, Item> contents; //stores contents of the room.
    public HashMap<String, Creature> creatures; //stores contents of the room.
    public String imageFile;
    
    /**
     * Create a room which is given an ID as a parameter. The descriptions generated are dependent on that ID.
     * @param description The room's description.
     * @param longdescription A detailed description of the room.
     * @param altdescription If the room is altered some way, a different description is provided.
     */
    public Room(int roomId) 
    {      
        RoomID = roomId;
        exits = new HashMap<String, Room>();
        contents = new HashMap<String, Item>();
        creatures = new HashMap<String, Creature>();
        setItems();
        setCreatures();                
    }

    protected abstract void setItems();
    protected abstract void setCreatures();
    
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
     /**
     * Removes a stored item from the room.
     */
    public void removeItem(Item item)
    {
        contents.remove(item);
    }
    
    
    /**
     * @return The short description of the room
     */
    public String getShortDescription()
    {
        return "You " + description + ".\n" + getExitString();
    }

    /**
     * @returns a longer description of the room. If the room has been emptied of creatures, an alternate description is provided.
     * 
     */
    public String getLongDescription()
    {
        if (creatures.isEmpty()&&altdescription!=null){
          return altdescription;
        }
        else{
        return longdescription;
    }
    }

    /**
     * Return a string describing the room's exits.
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
     /**
     *Retrieves a stored item from the room.
     *@return Item
     */
    public Item getItem(String itemName)
    {
        return contents.get(itemName);
    }
    
    /**
     *Retrieves a stored creature from the room.
     *@return Creature
     */
    public Creature getCreature(String creature)
    {
       return creatures.get(creature);
    }
    
    /**
     *Removes a stored creature from the room.
     */
    public void removeCreature(String creature)
    {
        creatures.remove(creature);
    }
    
    public JPanel getUI()
    {
     JPanel result = new JPanel();
     //result.setLayout(null);
     //result.setBounds(0, 0, 650, 500);
     JLabel bg = getBackground();
     result.add(bg);
     
     for(Item item : contents.values()){
         bg.add(item.getUi());
     }
     
     for(Creature creature : creatures.values()){
         bg.add(creature.getUi());
     }
        
     result.setVisible(true);
     return result;
    }
    
    private JLabel getBackground(){
        JLabel background = new JLabel();
        //background.setBounds(0, 0, 650, 500);
        background.setIcon(new ImageIcon(imageFile));
        background.setVisible(true);
        return background;
    }
}

