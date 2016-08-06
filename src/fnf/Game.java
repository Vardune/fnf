package fnf;

public class Game {

    private String name;
    private String phase;
    private String side;
    private int turn;

    public Game() {}

    public Game(String name, String phase, String side, int turn) {
        this.name = name;
        this.phase = phase;
        this.side = side;
        this.turn = turn;
    }

    public String getName() {
        return name;
    }

    public String getPhase() {
        return phase;
    }

    public String getSide() {
        return side;
    }

    public int getTurn() {
        return turn;
    }

	public void putName(String name) {
		this.name = name;
	}

	public void putPhase(String phase) {
		this.phase = phase;
	}

	public void putSide(String side) {
		this.side = side;
	}

	public void putTurn(int turn) {
		this.turn = turn;
	}
}
