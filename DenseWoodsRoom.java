/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DenseWoodsRoom extends Room
{
    public DenseWoodsRoom(){
       super(4);
       description = "are in some dense woods.";
       longdescription = "The trees press in thickly around you. The forest seems spookier in these parts. You hear a soft braying";
       altdescription = "The trees press in thickly around you. Hoof marks litter the floor around you, yet all you hear is the whispering wind.";
       imageFile = "denseWoods.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("deer", new Deer(35, 300, 200, 200));
    }
}
