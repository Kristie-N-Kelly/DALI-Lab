// This program is a two player trivia game in which a three sided die
// is rolled to choose from three different categories (chosen at random). 
// Whatever category it lands on it prints a corresponding question about 
// that category to just one of the players (again choosing at random who goes first). 
// They have four choices to choose from. That player then types in their guess/answer
// word for word. For example if Salt_Lake_City is displayed they would type "Salt_Lake_City".
// If they guess correctly they receive one point otherwise they don't receive any. The game
// goes back and forth between each player asking them random questions 
// based on the random category chosen.  Each player is asked a total of 5 questions.
// At the end of the game, the score is printed for both players.



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameTest{

	public static void main(String[] args) {
		//creating the game
		Game myGame = new Game();

		//creating the Array of Players
		Player [] nameOfPlayer = new Player [2];

		//getting the players names to put in the Array
		Scanner scan = new Scanner (System.in);
		System.out.println ("Enter the Name of Player 1: ");
		String name1 = scan.next();
		System.out.println ("Enter the Name of Player 2: ");
		String name2 = scan.next();

		//adding the player names to the Array
		nameOfPlayer [0] = new Player (name1);
		nameOfPlayer [1] = new Player (name2);

		//choosing who goes first randomly
		Random randomizer = new Random();
		int turn = randomizer.nextInt(2);
		int count = 0;

		//Each player gets asked 5 questions (so a total of 10 questions)
		while (count < 10) {
			int question = nameOfPlayer[turn].roll();
			System.out.println("");
			System.out.println (nameOfPlayer[turn].getName() + " it is your turn!");
			System.out.println("");
			
			//sets each category to either 0, 1 or 2, presents a corresponding question, checks the answer and prints the players score
			if (question == 0) {
				myGame.presentStateQuestion();
				boolean correct = myGame.check();
				if (correct) {
					nameOfPlayer[turn].incrementScore();
					System.out.println(nameOfPlayer[turn].getName() + " has a score of " + nameOfPlayer[turn].getScore());
				}
				turn = (turn + 1) % 2;
			}
			if (question == 1) {
				myGame.presentSongQuestion();
				boolean correct = myGame.check();
				if (correct) {
					nameOfPlayer[turn].incrementScore();
					System.out.println(nameOfPlayer[turn].getName() + " has a score of " + nameOfPlayer[turn].getScore());
				}
				turn = (turn + 1) % 2;
			}
			if (question == 2){
				myGame.presentMovieQuestion();
				boolean correct = myGame.check();
				if (correct) {
					nameOfPlayer[turn].incrementScore();
					System.out.println(nameOfPlayer[turn].getName() + " has a score of " + nameOfPlayer[turn].getScore());
				}
				turn = (turn + 1) % 2;
			}
			count++;
			//clears all of the answers in the Array after each question is asked
			myGame.clearAnswersinArrays();
		}
		
		//prints each players scores at the end of the game
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println ("Game is over");
		System.out.println("");
		System.out.println(nameOfPlayer[0].getName() + " has a final score of " + nameOfPlayer[0].getScore());
		System.out.println(nameOfPlayer[1].getName() + " has a final score of " + nameOfPlayer[1].getScore());

	}
}