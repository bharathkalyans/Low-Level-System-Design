package snakeandladder;/*
 * Credit goes to below channel
 * https://www.youtube.com/channel/UCQSU2g8XU-ZSs26_4HGuCWg
 * */

import java.util.*;

public class SnakeAndLadder {

    public static void main(String[] args) {

        int numberOfPLayers;
        Dice dice;
        Queue<Player> players = new LinkedList<>();
        HashMap<String, Integer> playerPositions = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of players : ");
        numberOfPLayers = sc.nextInt();

        System.out.println("Enter player names :: ");
        for (int i = 1; i <= numberOfPLayers; i++) {
            String name = sc.next();
            Player player = new Player(name, i);
            players.add(player);
            playerPositions.put(name, 0);
        }

        System.out.println("Enter number of dies to be used : ");
        int numberOfDies = sc.nextInt();
        dice = new Dice(numberOfDies);

        List<Jumper> snakes = new ArrayList<>();
        Jumper snake1 = new Jumper(10, 2);
        Jumper snake2 = new Jumper(56, 34);
        Jumper snake3 = new Jumper(88, 6);
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);

        List<Jumper> ladders = new ArrayList<>();
        Jumper ladder1 = new Jumper(7, 55);
        Jumper ladder2 = new Jumper(78, 89);
        Jumper ladder3 = new Jumper(37, 67);
        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);

        GameBoard game = new GameBoard(dice, players, snakes, ladders, playerPositions, 100);

        game.startGame();
    }
}
