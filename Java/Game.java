
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {
//variables
private String category;
private String a;
private String b;
private String c;
private String d;

//creates all the Array Lists needed for each category
private ArrayList <String> States = new ArrayList<String>();
private ArrayList <String> Capitals = new ArrayList <String>();
private ArrayList <String> Song = new ArrayList <String>();
private ArrayList <String> Artist = new ArrayList <String>();
private ArrayList <String> Movie = new ArrayList <String>();
private ArrayList <String> Character = new ArrayList <String>();

private ArrayList<String> StateMultipleChoice = new ArrayList <String>();
private ArrayList<String> SongMultipleChoice = new ArrayList <String>();
private ArrayList<String> MovieMultipleChoice = new ArrayList <String>();

private ArrayList<String> CorrectAnswer1 = new ArrayList<String>();
private ArrayList<String> CorrectAnswer2 = new ArrayList<String>();
private ArrayList<String> CorrectAnswer3 = new ArrayList<String>();

private ArrayList <String> statetmpList = new ArrayList <String>();
private ArrayList <String> songtmpList = new ArrayList <String>();
private ArrayList <String> MovietmpList = new ArrayList <String>();

//States and Capitals category method
public void presentStateQuestion() {
category = "States and Capitals!";
//creates an Array of states and capitals and puts them in their specific Array List
String [] stateName = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
"Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
"Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
"New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
"Wisconsin", "Wyoming"};
 
//makes sure the List is clear/empty then fills it again
for(String states: stateName) {
States.remove(states);
}

for (String states: stateName){
States.add(states);
}

String [] capitalName = {"Montgomery", "Juneau", "Phoenix", "Little_Rock", "Sacremento", "Denver",
"Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield",
"Indianapolis", "Des_Moines", "Topeka", "Frankfort", "Baton_Rouge", "Augusta", "Annapolis",
"Boston", "Lansing", "Saint_Paul", "Jackson", "Jefferson_City", "Helena", "Lincoln",
"Carson_City", "Concord", "Trenton", "Santa_Fe", "Albany", "Raleigh", "Bismark", "Columbus",
"Oklahoma_City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville",
"Austin", "Salt_Lake_City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"};

//makes sure the List is clear/empty then fills it again
for (String capitals: capitalName) {
Capitals.remove(capitals);
}

for (String capitals: capitalName){
Capitals.add(capitals);
}

//picks a random state for the question that's in the size of the Array List
Random stateRandom = new Random();
Random capitalRandom = new Random();

int stateIndex = stateRandom.nextInt(States.size());
 
//sets the capital index to the same number of the state index to match up the answers
int capitalIndex = stateIndex;

//prints the category and question
System.out.println (category);
System.out.println("What is the Capital of " + States.get(stateIndex) + "?");
System.out.println ("");

//picks random numbers for the changing size of the capital ArrayList 
int shuffledIndex1 = capitalRandom.nextInt(49);
int shuffledIndex2 = capitalRandom.nextInt(48);
int shuffledIndex3 = capitalRandom.nextInt(47);

//gets the corresponding capital index and removes it from the ArrayList
a = Capitals.get(capitalIndex);
Capitals.remove(capitalIndex);
b = Capitals.get(shuffledIndex1);
Capitals.remove(shuffledIndex1);
c = Capitals.get(shuffledIndex2);
Capitals.remove(shuffledIndex2);
d = Capitals.get(shuffledIndex3);

//puts the correct answer of the States and Capitals category question into its own ArrayList
CorrectAnswer1.add(a);

//adds the 3 random choices as well as the correct answer (which is a)
StateMultipleChoice.add(a);
StateMultipleChoice.add(b);
StateMultipleChoice.add(c);
StateMultipleChoice.add(d);

//shuffles the current ArrayList by removing a random index
        //and adding it to a temporary list
while (!StateMultipleChoice.isEmpty()) {
Random randomizer = new Random();
int randomIndex = randomizer.nextInt(StateMultipleChoice.size());
String removedChoice = StateMultipleChoice.remove(randomIndex);
statetmpList.add(removedChoice);
}

//prints your choices
int i = 0;
while (i < 4) {
System.out.println(statetmpList.get(i));
i++;
} 
//clears the temporary list every time
statetmpList.clear();
}

//Song and Artist category method
//does the same thing as above but for the next two categories
public void presentSongQuestion() {
category ="Songs and Artists!";
String [] SongName = {"Smells Like Teen Spirit", "Vogue", "Under the Bridge", "U Can't Touch This",
"Enter Sandman", "Sabatoge", "My Name Is", "Genie In a Bottle", "Ice Ice Baby",
"Beat It", "I Try", "I Gotta Feeling", "Hey Ya", "Hollaback Girl", "Crazy", "Switch",
"Low", "Apologize", "Viva La Vida", "Closer", "Cyclone", "Love Lockdown", "Single Ladies",
"Best I Ever Had"};

for (String song: SongName){
Song.remove(song);
}

for (String song: SongName){
Song.add(song);
}

Random SongRandom = new Random();
Random ArtistRandom = new Random();

int songIndex = SongRandom.nextInt(24);

String [] ArtistName = {"Nirvana", "Madonna", "Red_Hot_Chili_Peppers", "MC_Hammer", "Metallica", "Beastie_Boys",
"Eminem", "Christina_Aguilera", "Vanilla_Ice", "Michael_Jackson", "Macy_Gray", "Black_Eyed_Peas",
"Outkast", "Gwen_Stefani", "Gnarls_Barkley", "Will_Smith", "Flo_Rida", "One_Republic", "Coldplay",
"Ne-Yo", "Baby_Bash", "Kanye_West", "Beyonce", "Drake"};

for (String artist : ArtistName){
Artist.remove(artist);
}

for (String artist : ArtistName){
Artist.add(artist);
}


int artistIndex = songIndex;

System.out.println (category);
System.out.println ("");
System.out.println("Who sings the song " + Song.get(songIndex) + "?");
System.out.println ("");


Song.remove(songIndex);
int songShuffleIndex1 = ArtistRandom.nextInt(23);
int songShuffleIndex2 = ArtistRandom.nextInt(22);
int songShuffleIndex3 = ArtistRandom.nextInt(21);

a = Artist.get(artistIndex);
Artist.remove(artistIndex);
b = Artist.get(songShuffleIndex1);
Artist.remove(songShuffleIndex1);
c = Artist.get(songShuffleIndex2);
Artist.remove(songShuffleIndex2);
d = Artist.get(songShuffleIndex3);

CorrectAnswer2.add(a);

SongMultipleChoice.add(a);
SongMultipleChoice.add(b);
SongMultipleChoice.add(c);
SongMultipleChoice.add(d);


while (!SongMultipleChoice.isEmpty()) {
Random randomizer = new Random();
int randomIndex = randomizer.nextInt(SongMultipleChoice.size());
String removedChoice = SongMultipleChoice.remove(randomIndex);
songtmpList.add(removedChoice);
}

int i = 0;
while (i < 4) {
System.out.println(songtmpList.get(i));
i++;
}
songtmpList.clear();
}

    //Movies and Main Character category method
public void presentMovieQuestion() {
category = "Movies and Main Character!";
String [] movieName = {"Transformers", "Troy", "Die Hard", "Divergent", "Hunger Games", "Drive", "Lord of the Rings",
"Rambo", "Terminator", "Saving Private Ryan", "Spider Man", "Braveheart", "Home Alone", "Casino Royale",
"The Bourne Ultimatum", "Pirates of the Caribbean", "The Karate Kid", "The Proposal", "The Host",
"Just go with It", "The Wedding Date", "Christmas with the Kranks", "Cadet Kelly", "School of Rock"};

for (String movie: movieName){
Movie.remove(movie);
}

for (String movie: movieName){
Movie.add(movie);
}


Random movieRandom = new Random();
Random characterRandom = new Random();

int movieIndex = movieRandom.nextInt(24);


String [] CharacterName = {"Shia_LaBeouf", "Brad_Pitt", "Bruce_Willis", "Shailene_Woodley", "Jennifer_Lawrence",
"Ryan_Gosling", "Elijah_Wood", "Sylvester_Stallone", "Arnold_Schwarzenegger", "Tom_Hanks", "Tobey_Maguire",
"Mel_Gibson", "Macaulay_Culkin", "Daniel_Craig", "Matt_Damon", "Johny_Depp", "Ralph_Maccio", "Sandra_Bullock",
"Saoirse_Ronan", "Jennifer_Aniston", "Debra_Messing", "Tim_Allen", "Hilary_Duff", "Jack_Black" };

for (String characters : CharacterName){
Character.remove(characters);
}

for (String characters : CharacterName){
Character.add(characters);
}


int CharacterIndex = movieIndex;
System.out.println (category);
System.out.println ("");
System.out.println("Who is the Main Character in the Movie " + Movie.get(movieIndex) + "?");
System.out.println ("");

Movie.remove(movieIndex);
int MovieshuffleIndex1 = characterRandom.nextInt(23);
int MovieshuffleIndex2 = characterRandom.nextInt(22);
int MovieshuffleIndex3 = characterRandom.nextInt(21);

a = Character.get(CharacterIndex);
Character.remove(CharacterIndex);
b = Character.get(MovieshuffleIndex1);
Character.remove(MovieshuffleIndex1);
c = Character.get(MovieshuffleIndex2);
Character.remove(MovieshuffleIndex2);
d = Character.get(MovieshuffleIndex3);


CorrectAnswer3.add(a);
MovieMultipleChoice.add(a);
MovieMultipleChoice.add(b);
MovieMultipleChoice.add(c);
MovieMultipleChoice.add(d);

while (!MovieMultipleChoice.isEmpty()) {
Random randomizer = new Random();
int randomIndex = randomizer.nextInt(MovieMultipleChoice.size());
String removedChoice = MovieMultipleChoice.remove(randomIndex);
MovietmpList.add(removedChoice);
}

int i = 0;
while (i < 4) {
System.out.println(MovietmpList.get(i));
i++;
}

MovietmpList.clear();
}    

 
//clears the answers in the ArrayList each time around
public void clearAnswersinArrays () {
CorrectAnswer1.clear();
CorrectAnswer2.clear();
CorrectAnswer3.clear();
}

//method for checking our answer
public boolean check () {
if (category == "States and Capitals!") {
String answer1;
Scanner answer1Scanner = new Scanner (System.in);
System.out.println("");
System.out.println("Please Enter Your Answer Here: ");
answer1 = answer1Scanner.next();
//compares our answer to the correct answer
if (CorrectAnswer1.contains(answer1)) {
System.out.println ("");
System.out.println ("Correct!");
System.out.println ("You got a point!");
return true;
} else {
System.out.println ("");
System.out.println("False!");
System.out.println ("You did not get a point");
return false;   
}
}
if (category == "Songs and Artists!") {
String answer2;
Scanner answer2Scanner = new Scanner (System.in);
System.out.println("");
System.out.println("Please Enter Your Answer Here: ");
answer2 = answer2Scanner.next();
//compares our answer to the correct answer
if (CorrectAnswer2.contains(answer2)) {
System.out.println ("");
System.out.println ("Correct!");
System.out.println ("You got a point!");
return true;
}else {
System.out.println ("");
System.out.println("False!");
System.out.println ("You did not get a point");
return false;   
}
} 
if (category == "Movies and Main Character!") {
String answer3;
Scanner answer3Scanner = new Scanner (System.in);
System.out.println("");
System.out.println("Please Enter Your Answer Here: ");
answer3 = answer3Scanner.next();
//compares our answer to the correct answer
if (CorrectAnswer3.contains(answer3)) {
System.out.println ("");
System.out.println ("Correct!");
System.out.println ("You got a point!");
return true;
} else {
System.out.println ("");
System.out.println("False!");
System.out.println ("You did not get a point");
return false;   
}
} else {
System.out.print("I should not be here");
return true;
}
}
}
