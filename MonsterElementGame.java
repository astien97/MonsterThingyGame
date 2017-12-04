
//import lib.StringArray;
import java.util.Scanner;

public class MonsterElementGame {

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.printf("Welcome to the Monster Element Game!!%n%n");

    System.out.printf("How to Play:%nIn this 1 - 6 player game, you will harness ");
    System.out.printf("the power of an Element of your choice:%nWater, Fire, Air,");
    System.out.printf("Earth, Dark, or Light.%nYou and your teammates will take ");
    System.out.printf("turns battling a monster who possesses the power of a random ");
    System.out.printf("Element.%nDark beats Water, Water beats Air, Air beats Fire,");
    System.out.printf("Fire beats Earth, Earth beats Light, and Light beats Dark.");
    System.out.printf("%nChoose your element wisely!%nBeginning with Player 1, each ");
    System.out.printf("player will face the Element monster in a battle.%nPress A ");
    System.out.printf("to attack.%nIf your Element beats the monster, you are safe ");
    System.out.printf("to move on to the next round.%nIf the monster’s Element beats ");
    System.out.printf("yours, you will lose health points.%nYou will lose more or less ");
    System.out.printf("health points depending on the Elements at play.%nSee how many ");
    System.out.printf("Element monsters you and your teammates can beat!%nPress Q to quit the game.%n");

    System.out.printf("Character Customization Rules:%n");

    System.out.printf("Please input the number of players: %n");
    int players = scanner.nextInt(); // records the input number of players
    System.out.println("");

    String[] character = new String[players]; // the entire set of name, element, health, playerNum
    int[] playerNum = new int[players]; // calls the player by number
    String[] name = new String[players]; // stores names of players/characters
    String[] element = new String[players]; // stores the element of the player/character
    int[] hp = new int[players]; // stores the amount of health each player/character has

    int[] monsterNum = {1,2,3,4,5,6,7,8,9,10}; // number of monster/level of monster
    String[] monsterEL = {"dark","water","light","air","earth","dark","air","fire","light","dark"}; // stores corresponding element of monster
    int[] monsterHP = {5,5,5,5,5,5,5,5,5,5}; // monster's health in correspondence to it's level

    if (players > 6 || players < 1){
      System.out.println("This game is for 1 - 6 players. No more, no less, please!!");
    } else {
      int n = 1;
      for(int j=0; j<players; j++){
        playerNum[j] = n;
        n++;
      }
      /**
        Takes the user's inputs and puts them into their respective array slots
      */
      /**
      for(int l=0; l<players; l++){
      character[l] = makeCharacter(name,playerNum,hp,userElement,players); // uses method to create charcter
      }
      */
      for(int i = 0; i<players; i++){
        System.out.printf("Player %d%n", playerNum[i]);
        System.out.println("What is your name?");
        name[i] = scanner.next();
        System.out.println("What is your element?");
        element[i] = scanner.next();
        hp[i] = 50;
      }
      for(int k = 0; k<players; k++){
        System.out.printf("Player %d%n", playerNum[k]);
        System.out.printf("Name: %s%n",name[k]);
        System.out.printf("Element: %s%n",element[k]);
        System.out.printf("Health: %d%n",hp[k]);
      }
    }
    int hl=0; // health lost
    for (int m=0; m<monsterNum.length; m++){
      String monsterElement = monsterEL[m];
      int monsterHealth = monsterHP[m];
      System.out.printf("Monster #%d has popped up. It is of element %s%n",monsterNum[m],monsterEL[m]);
      do{
        for(int n=0;n<players;n++){
          String playerElement = element[n];
          int playerHp = hp[n];
          System.out.printf("Player %d's turn!",playerNum[n]);
          String move = scanner.next();
          if (move.equals("a")){
            if (monsterElement.equals("dark")){ //
              switch (playerElement) {
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

            } else if (monsterElement.equals("light")){
              switch (playerElement) {
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
            } else if (monsterElement.equals("earth")){
              switch (playerElement){
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
            } else if (monsterElement.equals("fire")){
              switch (playerElement) {
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
            } else if (monsterElement.equals("air")){
              switch (playerElement) {
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
            } else if (monsterElement.equals("water")){
              switch (playerElement) {
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
            }
            monsterHP[m]-=hl; // takes away health points from the affected element
            System.out.printf("monster's health = %d%n", monsterHP[m]);
            //System.out.println("Make your move:");
            //move = scanner.next();
          }
/**
          // from here down is monster affecting players
          if (playerElement.equals("dark")){
            switch (monsterElement) {
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

          } else if (playerElement.equals("light")){
            switch (monsterElement) {
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
          } else if (playerElement.equals("earth")){
              switch (monsterElement){
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
          } else if (playerElement.equals("fire")){
            switch (monsterElement) {
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
          } else if (playerElement.equals("air")){
            switch (monsterElement) {
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
          } else if (playerElement.equals("water")){
            switch (monsterElement) {
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
          }
          playerHp-=hl; // takes away health points from the affected element
          System.out.println(playerHp);*/
        }
      }  while (monsterHP[m] > 0);
        }
      }


    }
