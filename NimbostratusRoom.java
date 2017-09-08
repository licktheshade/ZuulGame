
/**
 * Write a description of class NimbostratusRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NimbostratusRoom extends Room
{
    public NimbostratusRoom(){
      super(11);
      description = "are in the middle of the sky in the Nimbostratus";
      longdescription = "Three cloud staircases are in the vicinity.\nOne to take you very high up, one to take you further down, and one that descends back down to the earth.\nThe clouds are laden with glittering and alluring crystals.";
      imageFile = "nimbostratus.jpg";
    }
    
    @Override protected void setItems(){
        contents.put("crystals", new Crystals(450, 350, 100, 100));    
        contents.put("crystals2", new Crystals(375, 300, 100, 100));                  
    }
    
    @Override protected void setCreatures(){

    }
}
