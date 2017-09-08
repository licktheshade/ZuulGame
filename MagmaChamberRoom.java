 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagmaChamberRoom extends Room
{
    public MagmaChamberRoom(){
      super(7);
      description = "are in an extremely hot Magma Chamber";
      longdescription = "The heat is worse than on the surface. Just as you try and leave, you see a succubus.\nShe looks at you with mild curiosity, but otherwise ignores you as she reclines in the lava.\nPerhaps she would be willing to help you?";
      altdescription = "You are being stifled in the overwhelming heat. This place is empty and sweltering.";
      imageFile = "magmaChamber.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){
       creatures.put("succubus", new Succubus(400, 75, 150, 150));
    }
}
