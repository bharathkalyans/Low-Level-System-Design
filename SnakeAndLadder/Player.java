package snakeandladder;

public class Player {
    private int id;
    private String playerName;

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player(String _name, int _id) {
        this.playerName = _name;
        this.id = _id;
    }
}
