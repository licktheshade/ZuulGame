 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EyeoftheStormRoom extends Room
{
    public EyeoftheStormRoom(){
      super(15);
      description = "have come to the Eye of the Storm";
      longdescription = "You're at the bottom of the whirlpool where the current is much calmer, and you float about with ease.\nFloating about you are several bottles filled with liquids of all sorts of colours. You also note that you can descend further right through the middle of the pool.";
      imageFile = "eyeoftheStorm.png";
    }
    
    @Override protected void setItems(){
      contents.put("potion", new Potion(150, 300, 75, 75));
      contents.put("potion2", new Potion(450, 225, 75, 75));
    }
    
    @Override protected void setCreatures(){

    }
}
