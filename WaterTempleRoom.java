 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterTempleRoom extends Room
{
    public WaterTempleRoom(){
      super(13);
      description = "emerge into the Water Temple";
      longdescription = "Almost dominating your view is a huge, gated enclosure with fancy gold statues and animal-shaped hedges.\nIt seems whoever is in there could help you get home.";
      imageFile = "waterTemple.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){

    }
}
