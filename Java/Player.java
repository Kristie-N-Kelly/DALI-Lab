
import java.util.Random;


public class Player {
    //instance variables
    private String name;
    private int score;

    //constructor
    public Player (String name) {
        //gets the players name inputed
    this.name = name;  
    }

    //methods
    public int roll() {
        // rolls a die (need 1-3) for the categories
        Random randomizer = new Random();
        int die = randomizer.nextInt(3);
        return die;
    }
   
    public void incrementScore() {
        //increments the score
    score ++;
    }
   
    //getters and setters
    public String getName() {
        //gets the name
    return name;
    }

    public int getScore() {
       //gets the score
    return score;
    }

}
