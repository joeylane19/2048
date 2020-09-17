import javax.swing.*;
import java.awt.*;
/**
 * Represents the visibile portion of the frame containing the game grid.
 *
 * @author (Joey Lane)
 * @version (2/13/19)
 */
public class GameScreen extends JFrame
{
    private Board gameBoard;
    private JPanel entirePanel;
    /**
     * Initializes the GameScreen with a 4 X 4 layout to represent the 2048 game grid.
     */
    public GameScreen()
    {
        gameBoard = new Board();
        entirePanel = gameBoard.getGamePanel();
        Space[][] gameArray = gameBoard.getGrid();
        entirePanel.setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        entirePanel.setLayout(new GridLayout(4, 4, 5, 5));
        for (int r = 0; r < gameArray.length; r++)
        {
            for (int c = 0; c < gameArray[0].length; c++)
            {
                JPanel panel = gameArray[r][c].getCurPanel();
                entirePanel.add(panel);
                
            }
        }
    }
    
    /**
     * Returns the entire game grid panel.
     * @return the entire game grid panel.
     */
    public JPanel getPanel()
    {
        return entirePanel;
    }
    
    /**
     * Returns the game board.
     * @return the game board.
     */
    public Board getGameBoard()
    {
        return gameBoard;
    }
}
