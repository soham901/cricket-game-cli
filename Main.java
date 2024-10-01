import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int PLAYERS_PER_TEAM = 5;
    private static int OVERS = 5;
    private static int BALLS_PER_OVER = 6;

    private static Random random = new Random();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to CLI Cricket!");
        System.out.println("Each team will bat for " + OVERS + " overs (" + (OVERS * BALLS_PER_OVER) + " balls).");

        int teamAScore = play("Team A");
        System.out.println("\nTeam A scored " + teamAScore + " runs.");

        System.out.println("\nPress Enter to start Team B's innings...");
        sc.next();

        int teamBScore = play("Team B");
        System.out.println("\nTeam B scored " + teamBScore + " runs.");

        if (teamAScore > teamBScore) {
            System.out.println("\nTeam A wins by " + (teamAScore - teamBScore) + " runs!");
        } else if (teamAScore < teamBScore) {
            System.out.println("\nTeam B wins by " + (teamBScore - teamAScore) + " runs!");
        } else {
            System.out.println("\nIt's a tie!");
        }
    }

    private static int play(String team) {
        System.out.println("\n" + team + " is batting.");
        int totalScore = 0;
        int wickets = 0;

        for (int over = 1; over <= OVERS; over++) {
            System.out.println("\nOver " + over + ":");
            for (int ball = 1; ball <= BALLS_PER_OVER; ball++) {
                if (wickets == PLAYERS_PER_TEAM - 1) {
                    System.out.println("All out!");
                    return totalScore;
                }

                System.out.print("Ball " + ball + ": Press Enter to bowl...");
                sc.next();

                int run = getRandomBall();
                if (run == -1) {
                    System.out.println("Wicket!");
                    wickets++;
                } else {
                    System.out.println(run + " runs");
                    totalScore += run;
                }

                System.out.println("Score: " + totalScore + "/" + wickets);
            }
            System.out.println("End of over " + over + ". Score: " + totalScore + "/" + wickets);
        }

        return totalScore;
    }

    private static int getRandomBall() {
        int outcome = random.nextInt(8);
        if (outcome == 7)
            return -1; // Wicket
        return outcome;
    }
}