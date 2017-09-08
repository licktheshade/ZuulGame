/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VolcanoHellRoom extends Room
{
    public VolcanoHellRoom(){
       super(5);
       description = "are in Volcano Hell";
       longdescription = "The landscape is barren and craggy. Heat radiates of the lava nearby, however you can hear the splash of water.\nA yawning chasm opens before you, and to the west a swirling of clouds.";
       imageFile = "volcanoHell.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){

    }
}
