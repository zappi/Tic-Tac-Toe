/**
 *This class creates the graphical elements for the game
 */
package ristirastinolla.ui;

import ristirastinolla.graphics.DrawBoard;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class GUI extends JFrame implements Runnable {

    private Game game;
    private Board board;
    private JLabel gameStatusBar;
    private DrawBoard field;
    private JButton restartButton;

    public GUI() {

        this.board = new Board(3, 3);
        this.game = new Game(3, 3, board);

    }

    /**
     * This method starts the game and does what is required
     */
    @Override
    public void run() {

        field = new DrawBoard(board);
        field.setPreferredSize(new Dimension(500, 500));

        gameStatusBar = new JLabel(game.returnPlayer() + "'s turn");
        gameStatusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));

        restartButton = new JButton("RESTART");
        restartButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(field, BorderLayout.CENTER);
        container.add(restartButton, BorderLayout.SOUTH);
        container.add(gameStatusBar, BorderLayout.NORTH);

        restartButton.addActionListener(new RestartbuttonListener(restartButton, game, this));
        field.addMouseListener(new ClickListener(game, field, this, gameStatusBar));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Ristirastinolla");
        setVisible(true);
        setResizable(false);
    }

    /**
     * This method creates main components
     */
    private void createComponents(Container container) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    }

}
