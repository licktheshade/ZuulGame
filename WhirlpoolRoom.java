 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhirlpoolRoom extends Room
{
    public WhirlpoolRoom(){
      super(14);
      description = "are swirling down and down a whirlpool";
      longdescription = "Even though the whirlpool is terrifying, you feel you can move about easily in it.\nSurprisingly, you see a bear swimming about nearby.\nHe seems a bit scary.";
      altdescription = "Although being in the whirlpool is unsettling, you're a bit more relaxed without the presence of a random bear.";
      imageFile = "whirlpool.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("bear", new Bear(350, 200, 295, 295));
    }
}
