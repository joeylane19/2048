import java.util.concurrent.TimeUnit;
/**
 * Represents a version of the game 2048, a well-known single-player strategy game.
 *
 * @author (Joey Lane)
 * @version (1/30/19)
 */
public class Game
{
    /**
     * Opens and displays the game window, allowing player to begin playing.
     */
    public static void main(String[] args)
    {
        new GFrame();
    }
    
    /**
     * Opens and begins an automated 2048 simulator game.
     */
    public static void simulatedGame(String[] args)
    {
        GFrame frame = new GFrame();
        while(frame.getGameScreen().getGameBoard().getNumVacancies() > 0)
        {
            int num = (int)(Math.random() * 4);
            if (num == 0)
                frame.getGameScreen().getGameBoard().moveRight();
            if (num == 1)
                frame.getGameScreen().getGameBoard().moveDown();
            if (num ==2)
                frame.getGameScreen().getGameBoard().moveLeft();
            if (num == 3)
                frame.getGameScreen().getGameBoard().moveUp();
            for (int r = 0; r < 4; r++)
            {
                for (int c = 0; c < 4; c++)
                {
                    Space[][] grid = frame.getGameScreen().getGameBoard().getGrid();
                    if(grid[r][c].getCurBlock() != null)
                    {
                        int value = grid[r][c].getCurBlock().getCurValue();
                        grid[r][c].changeLabelTo("" + value);
                    }
                    
                }
            }
            try
            {
                Thread.sleep(50);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
