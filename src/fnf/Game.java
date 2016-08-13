package fnf;

public class Game {

    private String scenario;
    private int turn;
    private String phase;
    private String startingSide;
    private int confederateHeavyCasualties;
    private int confederateLosses;
    private int unionHeavyCasualties;
    private int unionLosses;
    private int gameLength;
    private int startingTime;
    private int currentTime;

    public Game() {}

    public Game(String scenario, int turn, String phase, String startingSide, int confederateHeavyCasualties, int confederateLosses, int unionHeavyCasualties, int unionLosses, int gameLength, int startingTime, int currentTime) {
        this.scenario = scenario;
        this.turn = turn;
        this.phase = phase;
        this.startingSide = startingSide;
        this.confederateHeavyCasualties = confederateHeavyCasualties;
        this.confederateLosses = confederateLosses;
        this.unionHeavyCasualties = unionHeavyCasualties;
        this.unionLosses = unionLosses;
        this.gameLength = gameLength;
        this.startingTime = startingTime;
        this.currentTime = currentTime;
    }

    public String getScenario() {
        return scenario;
    }

    public int getTurn() {
        return turn;
    }

    public String getPhase() {
        return phase;
    }

    public String getStartingSide() {
        return startingSide;
    }

    public int getConfederateHeavyCasualties() {
        return confederateHeavyCasualties;
    }

    public int getConfederateLosses() {
        return confederateLosses;
    }

    public int getUnionHeavyCasualties() {
        return unionHeavyCasualties;
    }

    public int getUnionLosses() {
        return unionLosses;
    }

    public int getGameLength() {
        return gameLength;
    }

    public int getStartingTime() {
        return startingTime;
    }

    public int getCurrentTime() {
        return currentTime;
    }

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void setPhase(String phase) {
		this.phase = phase;
	}

	public void setStartingSide(String startingSide) {
		this.startingSide = startingSide;
	}

	public void setConfederateHeavyCasualties(int confederateHeavyCasualties) {
		this.confederateHeavyCasualties = confederateHeavyCasualties;
	}
	
	public void setConfederateLosses(int confederateLosses) {
		this.confederateLosses = confederateLosses;
	}
	
	public void setUnionHeavyCasualties(int unionHeavyCasualties) {
		this.unionHeavyCasualties = unionHeavyCasualties;
	}
	
	public void setUnionLosses(int unionLosses) {
		this.unionLosses = unionLosses;
	}
	
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}
	
}

