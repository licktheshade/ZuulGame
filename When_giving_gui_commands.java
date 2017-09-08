

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class When_giving_gui_commands
{
    private Game _game;
    /**
     * Default constructor for test class TestTest
     */
    public When_giving_gui_commands()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _game = new Game();
    }

    @Test
    public void Should_finish_game_when_quit_command_given(){
        _game.guiCommand("quit");
        
        assertEquals(_game.finished, true);
    }
    
    @Test
    public void Should_create_log_file_on_game_finish(){
        _game.guiCommand("quit");
        
        // read the log file...
        boolean containsWhatYouExpect = false;
        assertEquals(containsWhatYouExpect, true);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
