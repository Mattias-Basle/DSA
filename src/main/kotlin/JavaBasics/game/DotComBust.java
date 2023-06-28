package JavaBasics.game;

import java.util.ArrayList;

public class DotComBust {
        private ArrayList<DotCom> dotComList = new ArrayList<>();
        private int numOfGuesses = 0;
        private GameHelper helper = new GameHelper();

        private void setUpGame() {
            DotCom dotCom1 = new DotCom();
            DotCom dotCom2 = new DotCom();
            DotCom dotCom3 = new DotCom();

            dotCom1.setName("Pets.com");
            dotCom2.setName("Go2.com");
            dotCom3.setName("FindLove.com");

            dotComList.add(dotCom1);
            dotComList.add(dotCom2);
            dotComList.add(dotCom3);

            System.out.println("Your goal is to sink 3 dot coms.");
            System.out.println("Pets.com, Go2.com, FindLove.com");
            System.out.println("Try to sink them all in the fewest number of guesses");

            for (DotCom dotComToSet : dotComList) {
                ArrayList<String> newLocation = helper.placeDotCom(3);
                dotComToSet.setLocationCells(newLocation);
            }
        }

        private void startPlaying() {
            while (!dotComList.isEmpty()) {
                String userGuess = helper.getUserInput("Enter a guess");
                checkUserGuess(userGuess);
            }
            finishGame();
        }

        private void checkUserGuess(String userGuess) {
            numOfGuesses++;
            String result = "miss";

            for (DotCom dotComToTest : dotComList) {
                result = dotComToTest.checkYourself(userGuess);
                if (result.equals("hit")) {
                    break;
                }
                if (result.equals("kill")) {
                    dotComList.remove(dotComToTest);
                    break;
                }
            }
            System.out.println(result);
        }

        private void finishGame() {
            System.out.println("All Dot Coms are dead! Your stock is worthless.");
            if (numOfGuesses <= 18) {
                System.out.println("It only took you " + numOfGuesses + " guesses.");
                System.out.println("You got out before your options sank.");
            } else {
                System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
                System.out.println("Fish are dancing with your options.");
            }
        }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
