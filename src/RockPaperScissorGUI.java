import javax.swing.*;
import java.awt.*;

public class RockPaperScissorGUI extends JFrame {

    // player buttons
    JButton rockButton, paperButton, scissorButton;

    public RockPaperScissorGUI() {
        // GUI implementation for Rock Paper Scissor game
        super("Rock Paper Scissor Game");

        setSize(450, 580);

        // Set layout to null for absolute positioning
        setLayout(null);

        // Terminate the jvm when closing the gUI
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Load GUI in the center of the screen everytime we run the application
        setLocationRelativeTo(null);
        // Add GUI components
        addGuiComponents();
    }

    private void addGuiComponents() {
        // Create and add GUI components here (buttons, labels, etc.)
        // Example: JButton rockButton = new JButton("Rock");
        // Set bounds and add to the frame
        // Create computer score label
        JLabel computerScoreLabel = new JLabel("Computer Score: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // add gui
        add(computerScoreLabel);

        // Create computer choice
        JLabel computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 100, 80);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        JLabel playerLabel = new JLabel("Player Score: 0");
        playerLabel.setBounds(0, 350, 450, 30);
        playerLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerLabel);

        // Player buttons

        // rock
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 390, 105, 80);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(rockButton);

        // paper
        paperButton = new JButton("Paper");
        paperButton.setBounds(160, 390, 105, 80);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(paperButton);

        // scissor
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(280, 390, 105, 80);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(scissorButton);
    }
}