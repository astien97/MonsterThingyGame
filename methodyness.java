import java.util.Scanner;

public class methodyness{
  public static void main(String[] args){
    int players;
    int[] playerNum;

    printInstructions();
    players = getPlayers();
    String[] name = new String[players];
    String[] element = new String[players];
    for (int i=0; i<players; i++){
      name[i] = getName();
      element[i] = getElement();
    }
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
    System.out.printf("yours, you will lose health points.%See how many Element monsters");
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
    System.out.printf("What is your name?%n");
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
    System.out.printf("Which of the 6 elements are you?%n Earth, Fire, Water, Air, Dark, Light%n");
    do{
      String element = scanner.next();
      boolean check = checkElement(element);
    } while(false)


    if (true){
      return element;
    } else {
      System.out.printf("Please choose one of the game's element...%n Earth, Fire, Water, Air, Dark, Light%n");
      element = scanner.next();
    }
  }

  /**
  checkElement(String) checks whether they user's element is one in the game
  @return whether the element is correct or not
  */
  public static boolean checkElement(String a){
    if (element.equalsIgnoreCase("earth") || element.equalsIgnoreCase("fire") || element.equalsIgnoreCase("water") || element.equalsIgnoreCase("air") || element.equalsIgnoreCase("dark") || element.equalsIgnoreCase("light")){
      return true;
    } else {
      return false;
    }
  }
  /**
  printStats() prints the player's name, number, health and element
  */
  public static void printStats(String[] name, int[] playerNum, int[] hp, String[] element, int n){
    System.out.printf("Player %d%n",playerNum[n]);
    System.out.printf("Name: %s%n",name[n]);
    System.out.printf("Element: %s%n",element[n]);
    System.out.printf("HP: %d%n",hp[n]);
  }
  /**
  printMonStats() prints the monster's HP and element
  */
  public static void printMonStats(int[] monster, int[] monsterHP, String[] monsterEL, int n){
    System.out.printf("Monster #%d%n",monster[n]);
    System.out.printf("HP: %d%n",monsterHP[n]);
    System.out.printf("Element: %s%n",monsterEL[n]);
  }
  /**
  printResults() prints the results of the game (monsters killed)
  */
  public static void printResults(int a){
    System.out.printf("Monsters defeated: %d%n",a); // need to add a++ every time a monster is defeated in the main
    //System.out.printf("Damage Given: %d%n");
    //System.out.printf("Damage Taken: %d%n");
  }
  /**
  playerTurn() rotates the players for each attack
  */
  public static void playerTurn() {
    for(int n=0;n<players;n++){
      System.out.printf("Player %d's turn!",playerNum[n]);
    }
  }
  /**
  dmgToMonster() returns the damaged health of the monster
  @return gives the monster's health
  */
  public static Int dmgToMonster(String a) {
    checkDmg();
    for (int m=0; m<monsterNum.length; m++){
      monsterHP[m]-=hl; // takes away health points from the affected element
      return monsterHP[m]; //returns the health of the monster
    }
  }
  /**
  dmgToPlayer() does the same thing that dmgToMonster() does but to the player
  @return gives the players health
  */
  public static Int dmgToPlayer(String a) {
    checkDmg();
    for (int m=0; m<monsterNum.length; m++){
    playerHp[m]-=hl; // takes away health points from the affected element
    return playerHp[m]; //returns the health of the monster
  }
}
  /**
  getRound() goes through the game and checks which monster we're fighting
  */
  public static void getRound(int[] monster,int[] monsterHP,int[] monsterEL){
    for(int i=0;i<monster.length;i++){
      printMonStats(monster[i], monsterHP[i], monsterEL[i]);
      dmgToMonster();
      checkDmg();
      dmgToPlayer();
    }
  }
}
