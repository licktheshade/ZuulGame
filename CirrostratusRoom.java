 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CirrostratusRoom extends Room
{
    public CirrostratusRoom(){
      super(10);
      description = "are very high up in the Cirrostratus";
      longdescription = "Whilst you look around, you take care not to look directly down.\nAs you marvel at the sky around you, a small figure darts into your vision. Believe it or not, it's a winged cat!\nIt playfully paws at the clouds and seems unpreturbed by your presence.";
      altdescription = "The sight around you is beautiful, but devoid of any excitement.";
      imageFile = "cirrostratus.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("cat", new Cat(450, 375, 100, 100));
    }
}
