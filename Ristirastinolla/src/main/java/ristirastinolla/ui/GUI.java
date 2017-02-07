package ristirastinolla.ui;

import graphics.DrawField;
import java.awt.*;
import javax.swing.*;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class GUI extends JFrame implements Runnable {

    private Game game;
    private Board board;
    private JLabel gameStatusBar;
    private DrawField field;
    private JButton restartButton;

    public GUI() {
    }

    @Override
    public void run() {

        field = new DrawField();
        field.setPreferredSize(new Dimension(500, 500));
        
        repaint(); //TODO

        gameStatusBar = new JLabel("Test test");
        gameStatusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        restartButton = new JButton("RESTART");
        restartButton.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(field, BorderLayout.CENTER);
        container.add(restartButton, BorderLayout.SOUTH);
        container.add(gameStatusBar, BorderLayout.NORTH);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Ristirastinolla");
        setVisible(true);
        setResizable(false);
        
        new Game(3, 3, new Board(3, 3));

    }

    private void createComponents(Container container) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    }

}
