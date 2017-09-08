/**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IdyllicGladeRoom extends Room
{
    public IdyllicGladeRoom(){
       super(2);
       description = "come across an Idyllic Glade";            
       longdescription = "You find yourself coming to an opening in the thicket. Long green grass stirs gently in the breeze.\nThe ground is littered with large, purple herbs.";
       imageFile = "idyllicGlade.jpg";
    }
    
    @Override protected void setItems(){
        contents.put("herb", new Herb(450, 350, 100, 100));    
        contents.put("herb2", new Herb(375, 300, 100, 100));
    }
    
    @Override protected void setCreatures(){
        
    }
}