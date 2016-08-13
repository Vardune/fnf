package fnf;

import java.util.HashMap;

public class Units {

	private String side;
	private String corps;
	private String division;
	private String brigade;
	private String regiment;
	private String player;
	
	public Units(String side, String corps, String division, String brigade, String regiment, String player) {
		this.side = side;
		this.corps = corps;
		this.division = division;
		this.brigade = brigade;
		this.regiment = regiment;
		this.player = player;
	}

	public Units(HashMap hm) {
		
	}
		
	public String getUnitType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCorps() {
		return corps;
	}

	public String getDivision() {
		return division;
	}

	public String getBrigade() {
		return brigade;
	}

	public boolean hasBraveColonel() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getWarn() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCurrentStands() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSpent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBattery() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setBrigade(String brigade) {
		this.brigade = brigade;
	}

	public String getRegiment() {
		return regiment;
	}

	public void setRegiment(String regiment) {
		this.regiment = regiment;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

}
