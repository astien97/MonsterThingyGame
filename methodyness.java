import java.util.Scanner;

public class methodyness{
  public static void main(String[] args){
    int players;

    printInstructions();
    players = getPlayers();
    String[] name = new String[players];
    String[] element = new String[players];
    int[] hp = new int[players];
    int[] playerNum = new int[players];
    for (int i=0; i<players; i++){
      name[i] = getName();
      element[i] = getElement();
      hp[i] = 50;
      playerNum[i] = i+1;
    }
    printBase(players, name, playerNum, hp, element);

    int[] monster = new int[20]; // there are a set number of levels/monsters of this game
    

  }

  public static void printInstructions(){
    System.out.printf("Welcome to the Monster Element Game!!%n%n");

    System.out.printf("How to Play:%nIn this 1 - 6 player game, you will harness ");
    System.out.printf("the power of an Element of your choice:%nWater, Fire, Air,");
    System.out.printf("Earth, Dark, or Light.%nYou and your teammates will take ");
    System.out.printf("turns battling a monster who possesses the power of a random ");
    System.out.printf("Element.%nEach element does a different amount of damage to the");
    System.out.printf(" others.%nChoose your element wisely!%n In each level, beginning with Player 1,");
    System.out.printf(" each player must face the Element monster in a battle.%nPress A ");
    System.out.printf("to attack.%nOnce your team beats the monster, you are safe ");
    System.out.printf("to move on to the next round.%nIf the monster’s Element beats ");
    System.out.printf("yours, you will lose health points.%nSee how many Element monsters");
    System.out.printf(" you and your teammates can beat!%nPress Q to quit the game.%n%n");
  }

/**
getPlayers prompts the user for the number of players
@return the int that the user inputs
*/
  public static int getPlayers(){
    Scanner scanner = new Scanner(System.in);
    System.out.printf("How many players do you have?%n");
    int players = scanner.nextInt(); // records the input number of players
    return players;
  }

  /**
  getName() prompts the user for the name of the player
  @return the String that the user inputs
  */
  public static String getName(){
    Scanner scanner = new Scanner(System.in);
    System.out.printf("> What is your name?%n   ");
    String name = scanner.next(); // records player name
    return name;
  }

  /**
  getElement() prompts the user for the player's element
  also checks if the element is in the game
  @return the String that the user inputs
  NEEDS TO BE SORTED OUT
  */
  public static String getElement(){
    Scanner scanner = new Scanner(System.in);
    System.out.printf("> Which of the 6 elements are you?%n Earth, Fire, Water, Air, Dark, Light%n   ");
    String element;
    boolean check;
    do{
      element = scanner.next();
      check = checkElement(element);
    } while(check==false);
    return element;
  }

  /**
  checkElement(String) checks whether they user's element is one in the game
  @return whether the element is an elemnt in the game (true or false)
  */
  public static boolean checkElement(String a){
    if (a.equalsIgnoreCase("earth") || a.equalsIgnoreCase("fire") || a.equalsIgnoreCase("water") || a.equalsIgnoreCase("air") || a.equalsIgnoreCase("dark") || a.equalsIgnoreCase("light")){
      return true;
    } else {
      System.out.printf("Please choose one of the game's element...%n Earth, Fire, Water, Air, Dark, Light%n");
      return false;
    }
  }

  /**
  printStats() prints the player's name, number, health and element
  @param name an array that stores all the names of the players
  @param playerNum an array that stores the number assigned to each player (e.g. Player 1, Player 2, etc.)
  @param hp an array that stores the amount of health points each player has
  @param element an array that stores the element of each player
  @param n an integer that will call the position in each array to call an inputted value
  */
  public static void printStats(String[] name, int[] playerNum, int[] hp, String[] element, int n){
    System.out.printf("Player %d%n",playerNum[n]);
    System.out.printf("Name: %s%n",name[n]);
    System.out.printf("Element: %s%n",element[n]);
    System.out.printf("HP: %d%n",hp[n]);
  }
  /**
  printMonStats() prints the monster's HP and element
  @param monster
  @param monsterHP
  @param monsterEL
  @param n
  */
  public static void printMonStats(int[] monster, int[] monsterHP, String[] monsterEL, int n){
    System.out.printf("Monster #%d%n",monster[n]);
    System.out.printf("HP: %d%n",monsterHP[n]);
    System.out.printf("Element: %s%n",monsterEL[n]);
  }
  /**
  printResults() prints the results of the game (monsters killed)
  @param a an integer that stores the number of rounds played/monsters defeated
  */
  public static void printResults(int a){
    System.out.printf("Monsters defeated: %d%n",a); // need to add a++ every time a monster is defeated in the main
    //System.out.printf("Damage Given: %d%n");
    //System.out.printf("Damage Taken: %d%n");
  }

  /**
  printBase() uses printStats() to show the user how many players and all their stats before the game begins
  @param players an int that stored the number of users playing the game
  @param name an array that stores all the names of the players
  @param playerNum an array that stores the number assigned to each player (e.g. Player 1, Player 2, etc.)
  @param hp an array that stores the amount of health points each player has
  @param element an array that stores the element of each player
  */
  public static void printBase(int players, String[] name, int[] playerNum, int[] hp, String[] element){
    System.out.println();
    for (int j=0; j<players;j++){
      printStats(name, playerNum, hp, element, j);
    }
  }

  /**
  playOneRound() runs through one round of the game
  @param players an int that stored the number of users playing the game
  @param name an array that stores all the names of the players
  @param playerNum an array that stores the number assigned to each player (e.g. Player 1, Player 2, etc.)
  @param hp an array that stores the amount of health points each player has
  @param element an array that stores the element of each player
  NOTES: Should return void
  */

}
