import javax.swing.*;
import java.awt.*;
/**
 * Represents a frame containing all viewable components of the game.
 *
 * @author (Joey Lane)
 * @version (2/13/19)
 */
public class GFrame extends JFrame
{
    private GameScreen gameScreen;
    private ControlScreen controlScreen;
    private JLabel score;
    /**
     * Initializes the GFrame to be a 600 X 835 frame and provides it with all of its visible assets.
     */
    public GFrame()
    {
        gameScreen = new GameScreen();
        controlScreen = new ControlScreen(gameScreen.getGameBoard());
        score = gameScreen.getGameBoard().getScoreLabel();
        setVisible(true);
        setSize(600, 835);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = .5;
        c.fill = GridBagConstraints.BOTH;
        for (int j = 0; j < 4; j++)
        {
            if (j == 1)
            {
                JPanel panel = new JPanel();
                c.gridwidth = 1;
                c.gridheight = 1;
                c.ipadx = 110;
                c.fill = GridBagConstraints.BOTH;
                c.gridx = 1;
                c.gridy = 0;
                panel.setBackground(Color.GRAY);
                ImageIcon img = new ImageIcon("2048.png");
                img = new ImageIcon(img.getImage().getScaledInstance(155, 155, Image.SCALE_DEFAULT));
                JLabel label = new JLabel("", img, JLabel.CENTER);
                panel.add(label);
                add(panel, c);
                panel.setVisible(true);
            }
            else if (j == 3)
            {
                JPanel gameGrid = gameScreen.getPanel();
                c.ipadx = 100;
                c.ipady = 100;
                c.fill = GridBagConstraints.BOTH;
                c.gridx = 0;
                c.gridy = 1;
                c.gridwidth = 3;
                c.gridheight = 2;
                gameGrid.setLayout(new GridLayout(4, 4, 5, 5));
                add(gameGrid, c);
            }
            else if (j == 2)
            {
                JPanel controlGrid = controlScreen.getPanel();
                c.ipadx = 0;
                c.ipady = 90;
                c.fill = GridBagConstraints.BOTH;
                c.gridx = 2;
                c.gridy = 0;
                add(controlGrid, c);
            }
            else if (j == 0)
            {
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 1));
                JLabel scoreIs = new JLabel(" Score: ");
                scoreIs.setForeground(Color.WHITE);
                scoreIs.setFont(new Font("SANS_SERIF", Font.PLAIN, 30));
                panel.add(scoreIs);
                score.setForeground(Color.WHITE);
                score.setFont(new Font("SANS_SERIF", Font.BOLD, 50));
                score.setHorizontalTextPosition(SwingConstants.CENTER);
                score.setText(" 0");
                panel.add(score);
                c.ipadx = 20;
                c.ipady = 0;
                c.gridwidth = 1;
                c.gridheight = 1;
                c.fill = GridBagConstraints.BOTH;
                c.gridx = j % 3;
                c.gridy = j / 3;
                panel.setBackground(Color.GRAY);
                add(panel, c);
            }
        }
    }
    
    /**
     * Returns the game screen.
     * @return the game screen.
     */
    public GameScreen getGameScreen()
    {
        return gameScreen;
    }
}