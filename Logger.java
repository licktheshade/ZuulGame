import java.awt.event.*;
import javax.swing.*;;

/**
 * This class handles the output of the user input and system messages either on the console or a JTextArea
 * 
 * @author 162224 
 * @version 2
 */

public class Logger{
    private final static String newline = "\n";

    public static Boolean _toConsole = false;
    
    private static JTextArea _text;

    
    /**
     * The Logger is set on game setup - either by providing a JText area or null to play on the console
     */     
    public static void setLogger(JTextArea text){
        if (_text != null) {return;}
        
        _text = text;
        _toConsole = text == null;
    }

    /**
     * Output of the user message on console or JTextArea
     */     
    public static void Log(String msg){
        if (_toConsole){
            System.out.println(msg + newline);
        }
        else {

            _text.setText(_text.getText() + msg + newline);            
        }

    }
}