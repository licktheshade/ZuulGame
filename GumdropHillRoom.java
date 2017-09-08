/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumdropHillRoom extends Room
{
    public GumdropHillRoom(){
       super(3);
       description = "have come to the top of Gumdrop Hill";
       longdescription = "After an arduous trek up the slope, the world spans out before you.\nYou can see the enchanted forest below, but also a smoking mountain to the south. Past that, you see the glimmer of the sea and a beautiful swathe of clouds above.";
       imageFile = "gumdropHill.jpg";
    }
    
    @Override protected void setItems(){
        contents.put("mushroom", new Mushroom(200, 400, 120, 120));               
    }
    
    @Override protected void setCreatures(){
        
    }
}
