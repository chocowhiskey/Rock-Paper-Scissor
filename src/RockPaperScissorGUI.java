import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RockPaperScissorGUI extends JFrame implements ActionListener {

    // player buttons
    JButton rockButton, paperButton, scissorButton;

    JLabel computerChoice;

    JLabel computerScoreLabel, playerScoreLabel;

    RockPaperScissor rockPaperScissor;

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

        // Initialize backend ob
        rockPaperScissor = new RockPaperScissor();

        // Add GUI components
        addGuiComponents();
    }

    private void addGuiComponents() {
        // Create and add GUI components here (buttons, labels, etc.)
        // Example: JButton rockButton = new JButton("Rock");
        // Set bounds and add to the frame
        // Create computer score label
        computerScoreLabel = new JLabel("Computer Score: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // add gui
        add(computerScoreLabel);

        // Create computer choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 100, 80);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        playerScoreLabel = new JLabel("Player Score: 0");
        playerScoreLabel.setBounds(0, 350, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // Player buttons

        // rock
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 390, 105, 80);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        // paper
        paperButton = new JButton("Paper");
        paperButton.setBounds(160, 390, 105, 80);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(paperButton);

        // scissor
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(280, 390, 105, 80);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(scissorButton);

        showDialog("Test MEssage");
    }

    private void showDialog(String message) {
        JDialog resultDialog = new JDialog(this, "Game Result", true);
        resultDialog.setSize(300, 150);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        JLabel resultJLabel = new JLabel(message);
        resultJLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultJLabel, BorderLayout.CENTER);

        // Try again button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computerChoice.setText("?");
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks here
        String playerChoice = e.getActionCommand().toString();

        // Play rock paper scissor and store result into string
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        // Load computers choice
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        // Update score
        computerScoreLabel.setText("Computer Score: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player Score: " + rockPaperScissor.getPlayerScore());

        // Show result dialog
        showDialog(result);
    }
}