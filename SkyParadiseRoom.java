 /**
 * Write a description of class EnchantedForestRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkyParadiseRoom extends Room
{
    public SkyParadiseRoom(){
      super(9);
      description = "see the passage open onto a Sky Paradise";
      longdescription = "The view before you is breathtaking.\nWhilst the cloud passage descends below you, you can also see some whispy clouds above you, and some thick clouds much further down.\nConveniently, there are whispy steps to take you to these locations.";
      imageFile = "skyParadise.jpg";
    }
    
    @Override protected void setItems(){
                  
    }
    
    @Override protected void setCreatures(){

    }
}
