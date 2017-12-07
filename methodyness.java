package monster;
import java.util.Scanner;

public class methodyness{
  public static void main(String[] args){
    int players;
    printInstructions();
    players = getPlayers();
    String[] name = new String[players]; String[] element = new String[players]; int[] hp = new int[players]; int[] playerNum = new int[players]; String user;
    for (int i=0; i<players; i++){
      name[i] = getName();
      element[i] = getElement();
      hp[i] = 50;
      playerNum[i] = i+1;
    }
    printBase(players, name, playerNum, hp, element);
    do{
      System.out.println("Monsters have infiltrated our world! We need your help to annihilate them!!!");
      System.out.println("Press A to begin!");
      int[] monster = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}; // there are a set number of levels/monsters of this game
      int[] monsterHP = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200}; // the amount of health for each respective monster
      String[] monsterEL = {"dark","light","water","fire","air","earth","water","fire","fire","air","light","earth","air","water","dark", "light","dark","fire","earth","air"}; // the element for each respective monster
      Scanner scanner = new Scanner(System.in);
      user = scanner.next();
      int defeated = 0; // counts number of monsters defeated
      if(user.equalsIgnoreCase("a")){
        for(int j=0; j<monster.length; j++){
          playOneRound(playerNum, monster, monsterHP, hp, monsterEL, element, j, user);
          defeated++;
        }
        printResults(defeated);
      } else if(user.equalsIgnoreCase("q")){
        System.out.printf("That is %d less monsters in our world! Thank you for your efforts! Please return and save us soon.", defeated);
      }
    } while(!user.equalsIgnoreCase("Q"));
  }

  public static void printInstructions(){
    System.out.printf("Welcome to the Monster-Hunter!!%n%n");

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
      System.out.printf("Please choose one of the game's elements...%n Earth, Fire, Water, Air, Dark, Light%n   ");
      return false;
    }
  }

  /**
  playOneRound() runs through one round of the game
  @param players an int that stored the number of users playing the game
  @param name an array that stores all the names of the players
  @param playerNum an array that stores the number assigned to each player (e.g. Player 1, Player 2, etc.)
  @param hp an array that stores the amount of health points each player has
  @param element an array that stores the element of each player
  @param monster an array that stores the number of monsters
  @param monsterHP an array that stores the health of the monsters
  @param monsterEL an array that stores the element of the monsters
  @param j monster array index
  */
  public static void playOneRound(int[] playerNum, int[] monster,int[] monsterHP,int[] hp, String[] monsterEL, String[] element, int j, String user){ // player number, monster number, monster's HP, player's HP, monster's element, player's element, a: monster's index, user's input
  printMonStats(monster, monsterHP, monsterEL,j);
  for(int k=0; k<playerNum.length;k++){
    playerTurn(playerNum,k,monsterHP[j],hp[k],element[k], monsterEL[j], user);
  }

}

/**
playerTurn() rotates the players for each attack and starts the round, dealing damage
to the monster and damage to the player(s)
@param playerNum an array that stores the number assigned to each player
@param a a string used to initialize the player attack
*/
public static void playerTurn(int[] playerNumI, int k, int monsterHPi, int hpI, String elementI, String monsterELi, String user) { // player number, k: player for loop, monster's HP, player's HP, player's element, monster's element, j: monster's loop, user's input
System.out.printf("Player %d's turn!%n",playerNumI);
System.out.println("Press a to attack.");
if (user.equals("a")){
  dmgToMonster(monsterHPi, elementI, monsterELi);
  printDamage(elementI, monsterELi);
}
dmgToPlayer(hp, monsterELi, elementI);
printDmgToPlayer(monsterELi, elementI);
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
  public static void printResults(int a){ // a = number of monsters defeated
    System.out.printf("Monsters defeated: %d%n",a);
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
  printDamage() prints out the message depending on the damage made
  */
  public static void printDamage(String elementA, String elementR){ // element attacking, element receiving damage
    int hl = checkDmg(elementA, elementR);
    if((hl >= 0) && (hl <= 5)){
      if(hl == 5){
        System.out.println("It's super effective!");
      } else if(hl < 5 && hl >= 3){
        System.out.println("It's pretty effective.");
      } else if(hl < 3 && hl >= 1){
        System.out.println("Not very effective.");
      } else{
        System.out.println("That sucks. Is that all you can do?");
      }
    }
  }

  public static void printDmgToPlayer(String elementA, String elementR){ // elementA = element attacking, elementR = element receiving damage
    int hl = checkDmg(elementA, elementR);
    if (hl > 0){
      if (hl =< 5 && hl >= 3){
        System.out.println("The monster hit you!");
      } else if (hl < 3 && hl >= 1){
        System.out.println("The monster hit you a little...?");
      }
    } else {
      System.out.println("The monster missed!");
    }
  }

  /**
  printBase() uses printStats() to show the user how many players and all their stats before the game begins
  @param players an int that stored the number of users playing the game
  @param name an array that stores all the names of the players
  @param playerNum an array that stores the number assigned to each player (e.g. Player 1, Player 2, etc.)
  @param hp an array that stores the amount of health points each player has
  @param element
  */
  public static int dmgToMonster(int monsterHPi, String elementI, String monsterELi) { // monster's HP, player's element, monster's element, j: monster's loop, i: player's loop
      int hl = checkDmg(element, monsterEL);
      monsterHP-=hl; // takes away health points from the affected element
      return monsterHP; //returns the health of the monster
  }

  /**
  dmgToPlayer() does the same thing that dmgToMonster() does but to the player
  @return gives the players health
  */
  public static int dmgToPlayer(int hp, String monsterEL, String element) { // hp of player, attacker's element, receiver's element, k: player's loop
      int hl = checkDmg(monsterEL, element);
      hp-=hl; // takes away health points from the affected element
      return hp; //returns the health of the player
  }

  /**
  checkDmg() with check the amount of damage an element does to another element in battle
  @param elementA a String that's pulled from either the monsterEL or element array to match the elementR
  @param elementR a String that's pulled from either the monsterEL or element array (opposite of elementA) to match the other element
  @return an int that will be used to take away damage from either a monster or a player
  */

  public static int checkDmg(String elementA, String elementR){ // attacker's element, damage receiver's element
    int hl = 0;
    if (elementR.equals("dark")){
      hl = checkDark(elementA);
    } else if (elementR.equals("light")){
      hl = checkLight(elementA);
    } else if (elementR.equals("earth")){
      hl = checkEarth(elementA);
    } else if (elementR.equals("fire")){
      hl = checkFire(elementA);
    } else if (elementR.equals("air")){
      hl = checkAir(elementA);
    } else if (elementR.equals("water")){
      hl = checkWater(elementA);
    }
    return hl;
  }

  /**
  checkDark() uses a switch to find how many points of damage the player receives or does
  @param elementA a String that's dealing damage
  @return the amount of points for that attack (hl)
  */
public static int checkDark(String elementA){
  int hl=0;
  switch (elementA) {
    case "light": hl = 5;
    break;
    case "earth": hl = 4;
    break;
    case "fire": hl = 3;
    break;
    case "air": hl = 2;
    break;
    case "water": hl = 1;
    break;
    case "dark": hl = 0;
    break;
  }
  return hl;
}

  /**
  checkLight() uses a switch to find how many points of damage the player receives or does
  @param elementA
    @return the amount of points for that attack (hl)
  */
public static int checkLight(String elementA){
  int hl=0;
  switch (elementA) {
    case "light": hl = 0;
    break;
    case "earth": hl = 5;
    break;
    case "fire": hl = 4;
    break;
    case "air": hl = 3;
    break;
    case "water": hl = 2;
    break;
    case "dark": hl = 1;
    break;
  }
  return hl;
}
  /**
  checkEarth() uses a switch to find how many points of damage the player receives or does
  @param elementA a String that's dealing damage
  @return the amount of points for that attack (hl)
  */
public static int checkEarth(String elementA){
  int hl=0;
  switch (elementA){
    case "light": hl = 1;
    break;
    case "earth": hl = 0;
    break;
    case "fire": hl = 5;
    break;
    case "air": hl = 4;
    break;
    case "water": hl = 3;
    break;
    case "dark": hl = 2;
    break;
  }
  return hl;
}
  /**
  checkFire() uses a switch to find how many points of damage the player receives or does
  @param elementA a String that's dealing damage
  @return the amount of points for that attack (hl)
  */
public static int checkFire(String elementA){
  int hl=0;
  switch (elementA) {
    case "light": hl = 2;
    break;
    case "earth": hl = 1;
    break;
    case "fire": hl = 0;
    break;
    case "air": hl = 5;
    break;
    case "water": hl = 4;
    break;
    case "dark": hl = 3;
    break;
  }
  return hl;
}
  /**
  checkAir() uses a switch to find how many points of damage the player receives or does
  @param elementA a String that's dealing damage
  @return the amount of points for that attack (hl)
  */
public static int checkAir(String elementA){
  int hl=0;
  switch (elementA) {
    case "light": hl = 3;
    break;
    case "earth": hl = 2;
    break;
    case "fire": hl = 1;
    break;
    case "air": hl = 0;
    break;
    case "water": hl = 5;
    break;
    case "dark": hl = 4;
    break;
  }
  return hl;
}
  /**
  checkWater() uses a switch to find how many points of damage the player receives or does
  @param elementA a String that's dealing damage
  @return the amount of points for that attack (hl)
  */
public static int checkWater(String elementA){
  int hl=0;
  switch (elementA) {
    case "light": hl = 4;
    break;
    case "earth": hl = 3;
    break;
    case "fire": hl = 2;
    break;
    case "air": hl = 1;
    break;
    case "water": hl = 0;
    break;
    case "dark": hl = 5;
    break;
  }
  return hl;
}

}
