import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Represents the 2048 game grid itself.
 *
 * @author (Joey Lane)
 * @version (2/13/19)
 */
public class Board
{
    private Space[][] grid;
    private int numVacancies;
    private int score;
    private JLabel scoreLabel;
    private JPanel gamePanel;
    /**
     * Initializes the Board to be a 4 X 4 grid starting with two default blocks in random spaces of the grid.
     */
    public Board()
    {
        grid = new Space[4][4];
        numVacancies = 14;
        int score = 0;
        scoreLabel = new JLabel();
        gamePanel = new JPanel();
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                grid[r][c] = new Space();
            }
        }
        int row1 = (int)(Math.random() * 4);
        int col1 = (int)(Math.random() * 4);
        int row2 = (int)(Math.random() * 4);
        int col2 = (int)(Math.random() * 4);
        while (col1 == col2 && row1 == row2)
        {
            row2 = (int)(Math.random() * 4);
            col2 = (int)(Math.random() * 4);
        }
        grid[row1][col1].insertBlock();
        grid[row2][col2].insertBlock();
    }
    
    /**
     * Returns the Board's grid.
     * @return the Board's grid.
     */
    public Space[][] getGrid()
    {
        return grid;
    }
    
    /**
     * Returns the game's panel.
     * @return the game's panel.
     */
    public JPanel getGamePanel()
    {
        return gamePanel;
    }
    
    /**
     * Returns the score's label.
     * @return the score's label.
     */
    public JLabel getScoreLabel()
    {
        return scoreLabel;
    }
    
    /**
     * Returns the score.
     * @return the score.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Returns the number of vacancies.
     * @return the number of vacancies.
     */
    public int getNumVacancies()
    {
        return numVacancies;
    }
    
    /**
     * Returns the Space at a given row and column of the grid.
     * @return the desired Space.
     * @param row desired row.
     * @param col desired column.
     */
    public Space getSpace(int row, int col)
    {
        return grid[row][col];
    }
    
    /**
     * Adds a Block to a random Space in the grid (if not full). Ends the game if no moves can be made.
     */
    public void addBlock()
    {
        int row = (int)(Math.random() * 4);
        int col = (int)(Math.random() * 4);
        while (grid[row][col].getCurBlock() != null)
        {
            row = (int)(Math.random() * 4);
            col = (int)(Math.random() * 4);
        }
        grid[row][col].insertBlock();
        numVacancies--;
        if (numVacancies == 0)
        {
            boolean gameOver = true;
            for (int r = 0; r < grid.length; r++)
            {
                for (int c = 0; c < grid[0].length; c++)
                {
                    if (r < 3 && grid[r][c].getCurBlock().getCurValue() == grid[r+1][c].getCurBlock().getCurValue())
                        gameOver = false;
                    else if (r > 0 && grid[r][c].getCurBlock().getCurValue() == grid[r-1][c].getCurBlock().getCurValue())
                        gameOver = false;
                    else if (c < 3 && grid[r][c].getCurBlock().getCurValue() == grid[r][c+1].getCurBlock().getCurValue())
                        gameOver = false;
                    else if (c > 0 && grid[r][c].getCurBlock().getCurValue() == grid[r][c-1].getCurBlock().getCurValue())
                        gameOver = false;
                }
            }
            if (gameOver)
                lose();
        }
    }
    
    /**
     * Sends the game into "Game Over" mode and allows the player to start a new game if they so choose.
     */
    public void lose()
    {
        gamePanel.removeAll();
        JButton message = new JButton();
        message.setBackground(Color.GRAY);
        message.setText("Game Over! Click here to play again");
        message.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new GFrame();
            }
        });
        gamePanel.add(message);
    }
    
    /**
     * Sets all of the Blocks' values to their values that were temporarily locked away. Also changes the Spaces' backgrounds to their block's number-specific color.
     */
    public void unlockAll()
    {
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                Block b = grid[r][c].getCurBlock();
                if (b != null)
                {
                    b.setCurValue(b.getLockedValue());
                    grid[r][c].getCurLabel().setText("" + grid[r][c].getCurBlock().getCurValue());
                    if (grid[r][c].getCurBlock().getCurValue() == 2)
                    {
                        grid[r][c].getCurPanel().setBackground(new Color(238, 228, 218));
                        grid[r][c].getCurLabel().setVerticalAlignment(JLabel.CENTER);
                    }    
                    
                    if (grid[r][c].getCurBlock().getCurValue() == 4)
                        grid[r][c].getCurPanel().setBackground(new Color(237, 224, 200));
                    if (grid[r][c].getCurBlock().getCurValue() == 8)
                        grid[r][c].getCurPanel().setBackground(new Color(242, 177, 121));
                    if (grid[r][c].getCurBlock().getCurValue() == 16)
                        grid[r][c].getCurPanel().setBackground(new Color(245, 149, 99));
                    if (grid[r][c].getCurBlock().getCurValue() == 32)
                        grid[r][c].getCurPanel().setBackground(new Color(246, 124, 95));
                    if (grid[r][c].getCurBlock().getCurValue() == 64)
                        grid[r][c].getCurPanel().setBackground(new Color(246, 94, 59));
                    if (grid[r][c].getCurBlock().getCurValue() == 128)
                    {
                        grid[r][c].getCurPanel().setBackground(new Color(237, 207, 114));
                        grid[r][c].getCurLabel().setVerticalTextPosition(JLabel.CENTER);
                    }
                    if (grid[r][c].getCurBlock().getCurValue() == 256)
                        grid[r][c].getCurPanel().setBackground(new Color(239, 220, 53));
                    if (grid[r][c].getCurBlock().getCurValue() == 512)
                        grid[r][c].getCurPanel().setBackground(new Color(255, 237, 63));
                    if (grid[r][c].getCurBlock().getCurValue() == 1024)
                        grid[r][c].getCurPanel().setBackground(new Color(255, 255, 0));
                    if (grid[r][c].getCurBlock().getCurValue() == 2048)
                        grid[r][c].getCurPanel().setBackground(new Color(255, 153, 0));
                    
                    if (grid[r][c].getCurBlock().getCurValue() > 4)
                        grid[r][c].getCurLabel().setForeground(new Color(255, 255, 255));
                    if (grid[r][c].getCurBlock().getCurValue() > 64)
                    {
                        grid[r][c].getCurLabel().setFont(new Font("SANS_SERIF", Font.BOLD, 50));
                        grid[r][c].getCurLabel().setText("" + grid[r][c].getCurBlock().getCurValue());
                    }
                }
            }
        }
        updateScore();
    }
    
    /**
     * Updates the scoreboard to the current score.
     */
    public void updateScore()
    {
        scoreLabel.setText(" " + score);
        if (score > 999)
            scoreLabel.setFont(new Font("SANS_SERIF", Font.BOLD, 35));
    }
    
    /**
     * Slides the Blocks to the left of the grid.
     */
    public void moveLeft()
    {
        int numChanges = 0;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 1; c < grid[0].length; c++)
            {
                if (grid[r][c].getCurBlock() != null)
                {
                    if (grid[r][c-1].getCurBlock() == null)
                    {
                        grid[r][c-1].insertExistentBlock(grid[r][c].getCurBlock());
                        grid[r][c].nullifyBlock();
                        numChanges++;
                        if (c != 1)
                        {
                            c = c - 2;
                        }
                    }
                    else
                    {
                        int value = grid[r][c].getCurBlock().getCurValue();
                        if (grid[r][c-1].getCurBlock().getCurValue() == value)
                        {
                            grid[r][c-1].getCurBlock().setCurValue(2 * value);
                            grid[r][c-1].getCurBlock().lock();
                            grid[r][c-1].getCurLabel().setText("" + grid[r][c-1].getCurBlock().getCurValue());
                            grid[r][c].nullifyBlock();
                            numChanges++;
                            score += value*2;
                            if (c > 1 && grid[r][c-2].getCurBlock().getCurValue() != grid[r][c-1].getCurBlock().getCurValue())
                            {
                                c = 0;
                            }
                            numVacancies++;
                        }
                    }
                }
            }
        }
        unlockAll();
        if (numChanges > 0)
        {
            addBlock();
        }
    }
    
    /**
     * Slides the Blocks to the right of the grid.
     */
    public void moveRight()
    {
        int numChanges = 0;
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = grid[0].length - 2; c >= 0; c--)
            {
                if (grid[r][c].getCurBlock() != null)
                {
                    if (grid[r][c+1].getCurBlock() == null)
                    {
                        grid[r][c+1].insertExistentBlock(grid[r][c].getCurBlock());
                        grid[r][c].nullifyBlock();
                        numChanges++;
                        if (c != 2)
                        {
                            c = c + 2;
                        }
                    }
                    else
                    {
                        int value = grid[r][c].getCurBlock().getCurValue();
                        if (grid[r][c+1].getCurBlock().getCurValue() == value)
                        {
                            grid[r][c+1].getCurBlock().setCurValue(2 * value);
                            grid[r][c+1].getCurBlock().lock();
                            grid[r][c+1].getCurLabel().setText("" + grid[r][c+1].getCurBlock().getCurValue());
                            grid[r][c].nullifyBlock();
                            numChanges++;
                            score += value*2;
                            if (c < 2 && grid[r][c+2].getCurBlock().getCurValue() != grid[r][c+1].getCurBlock().getCurValue())
                            {
                                c = 3;
                            }
                            numVacancies++;
                        }
                    }
                }
            }
        }
        unlockAll();
        if (numChanges > 0)
        {
            addBlock();
        }
    }
    
    /**
     * Slides the Blocks to the bottom of the grid.
     */
    public void moveDown()
    {
        int numChanges = 0;
        for (int c = 0; c < grid[0].length; c++)
        {
            for (int r = grid.length - 2; r >= 0; r--)
            {
                if (grid[r][c].getCurBlock() != null)
                {
                    if (grid[r+1][c].getCurBlock() == null)
                    {
                        grid[r+1][c].insertExistentBlock(grid[r][c].getCurBlock());
                        grid[r][c].nullifyBlock();
                        numChanges++;
                        if (r != 2)
                        {
                            r = r + 2;
                        }
                    }
                    else
                    {
                        int value = grid[r][c].getCurBlock().getCurValue();
                        if (grid[r+1][c].getCurBlock().getCurValue() == value)
                        {
                            grid[r+1][c].getCurBlock().setCurValue(2 * value);
                            grid[r+1][c].getCurBlock().lock();
                            grid[r+1][c].getCurLabel().setText("" + grid[r+1][c].getCurBlock().getCurValue());
                            grid[r][c].nullifyBlock();
                            numChanges++;
                            score += value*2;
                            if (r < 2 && grid[r+2][c].getCurBlock().getCurValue() != grid[r+1][c].getCurBlock().getCurValue())
                            {
                                r = 3;
                            }
                            numVacancies++;
                        }
                    }
                }
            }
        }
        unlockAll();
        if (numChanges > 0)
        {
            addBlock();
        }
    }
    
    /**
     * Slides the Blocks to the top of the grid.
     */
    public void moveUp()
    {
        int numChanges = 0;
        for (int c = 0; c < grid[0].length; c++)
        {
            for (int r = 1; r < grid.length; r++)
            {
                if (grid[r][c].getCurBlock() != null)
                {
                    if (grid[r-1][c].getCurBlock() == null)
                    {
                        grid[r-1][c].insertExistentBlock(grid[r][c].getCurBlock());
                        grid[r][c].nullifyBlock();
                        numChanges++;
                        if (r != 1)
                        {
                            r = r - 2;
                        }
                    }
                    else
                    {
                        int value = grid[r][c].getCurBlock().getCurValue();
                        if (grid[r-1][c].getCurBlock().getCurValue() == value)
                        {
                            grid[r-1][c].getCurBlock().setCurValue(2 * value);
                            grid[r-1][c].getCurBlock().lock();
                            grid[r-1][c].getCurLabel().setText("" + grid[r-1][c].getCurBlock().getCurValue());
                            grid[r][c].nullifyBlock();
                            numChanges++;
                            score += value*2;
                            if (r > 1 && grid[r-2][c].getCurBlock().getCurValue() != grid[r-1][c].getCurBlock().getCurValue())
                            {
                                r = 0;
                            }
                            numVacancies++;
                        }
                    }
                    
                }
            }
        }
        unlockAll();
        if (numChanges > 0)
        {
            addBlock();
        }
    }
}    
