package snakeandladder;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class GameBoard {

    private final Dice dice;
    private final Queue<Player> nextTurn;
    private final List<Jumper> snakes;
    private final List<Jumper> ladders;
    HashMap<String, Integer> playerCurrentPosition;
    int boardSize;

    public GameBoard(Dice dice, Queue<Player> nextTurn,
                     List<Jumper> snakes, List<Jumper> ladders,
                     HashMap<String, Integer> playersCurrentPosition, int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

    public void startGame() {
        while (nextTurn.size() > 1) {
            Player player = nextTurn.poll();
            int currentPosition = playerCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDies();
            System.out.println(player.getPlayerName() + " is at position : " +
                    playerCurrentPosition.get(player.getPlayerName())
                    + " and rolled a Die and got : " + diceValue);
            int nextCell = currentPosition + diceValue;

            if (nextCell > boardSize)
                nextTurn.offer(player);
            else if (nextCell == boardSize) {
                System.out.println(player.getPlayerName() + " has completed the Game. Congratulations");
            } else {
                int[] nextPosition = new int[1];
                boolean[] climbedALadder = new boolean[1];
                nextPosition[0] = nextCell;

                // Now check if there are Snakes at this Position.
                snakes.forEach(v -> {
                    if (v.getStartPoint() == nextCell) {
                        nextPosition[0] = v.getEndPoint();
                    }
                });
                if (nextPosition[0] != nextCell)
                    System.out.println(player.getPlayerName() + " was bit by a Snake 🥲😭 and dropped to position : " + nextPosition[0]);

                ladders.forEach(v -> {
                    if (v.getEndPoint() == nextCell) {
                        nextPosition[0] = v.getStartPoint();
                        climbedALadder[0] = true;
                    }
                });
                if (nextPosition[0] != nextCell && climbedALadder[0]) {
                    System.out.println("Hurrah," + player.getPlayerName() + " climbed a ladder!🤟🏽");
                }
                if (nextPosition[0] == boardSize)
                    System.out.println(player.getPlayerName() + " won the Game!");
                else {
                    playerCurrentPosition.put(player.getPlayerName(), nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is at position : " + nextPosition[0]);
                    nextTurn.offer(player);
                }

            }

        }
    }

}












