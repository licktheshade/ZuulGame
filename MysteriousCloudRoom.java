 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MysteriousCloudRoom extends Room
{
    public MysteriousCloudRoom(){
      super(8);
      description = "have discovered a mysterious Cloud Passage";
      longdescription = "It is hard to see with the thick clouds all around. However, you know the ground you stand on belongs to the volcanos.\nYou can see the passage raising into the sky, but also, to the east, a strange, flickering portal hovers in the air.";
      imageFile = "mysteriousCloud.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){

    }
}
