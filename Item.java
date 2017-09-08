
/**
 * Abstract class Item is the superclass for all item objects which have unique features
 * 
 * @author 162224
 * @version 03/11
 */
public abstract class Item extends Drawable
{
    //Item description to be called if the player views inventory
    public String itemDesc;
    
    
    public Item(int x, int y, int w, int h, String image){
        super(x, y, w, h, image);
    }
    
    //Abstract method to be uniquely implemented within the subclass
    public abstract void UseItem(Game game);
    
    
}

