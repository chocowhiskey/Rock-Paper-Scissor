import java.util.Random;

public class RockPaperScissor {
    private static final String[] choices = { "Rock", "Paper", "Scissors" };

    // Getter methods
    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    // Store computer choice so we can retrieve the value and display it to the
    // frontend
    private String computerChoice;

    // Store the scores
    private int computerScore, playerScore;

    private Random random;

    // Constructor
    public RockPaperScissor() {
        random = new Random();
    }

    public String playRockPaperScissor(String playerChoice) {
        // Generate computer choice
        computerChoice = choices[random.nextInt(choices.length)];

        // Determine the winner
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie! Both chose " + playerChoice + ".";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            playerScore++;
            return "You win! " + playerChoice + " beats " + computerChoice + ".";
        } else {
            computerScore++;
            return "You lose! " + computerChoice + " beats " + playerChoice + ".";
        }
    }

}
