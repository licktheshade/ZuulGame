import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Abstract class Drawable - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Drawable
{
    private String imageFile;
    private int top;
    private int left;
    private int width;
    private int height;
    
    public Drawable(int x, int y, int w, int h, String image){
        top = y;
        left = x;
        width = w;
        height = h;
        imageFile = image;
    }
    
    public JLabel getUi(){
        JLabel result = new JLabel();
        result.setBounds(left, top, width, height);
        result.setIcon(new ImageIcon(imageFile));
        return result;
    }
    
    public JLabel getSmallUi(){
        JLabel result = new JLabel();
        result.setBackground(Color.BLACK);
        
        ImageIcon icon = new ImageIcon(imageFile);
        Image img = icon.getImage();
        BufferedImage buff = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = buff.createGraphics();
        g.drawImage(img,0,0,50,50,Color.BLACK,null);
        ImageIcon newicon = new ImageIcon(buff);

        result.setIcon(newicon);
        return result;
        
    }
}
