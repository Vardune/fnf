package fnf;

import java.util.HashMap;

public class Units {

	private String corps;
	private String division;
	private String brigade;
	private String regiment;
	private String player;
	private int exp;
	private int fresh;
	private int warn;
	private int spent;
	private int curStands;
	private boolean braveColonel;
	private boolean union;
	private boolean fixedGuns;
	private int morale;
	private boolean silenced;
	private String movementResult;
	private int type;
	private String formation;
	private boolean moved;
	private int firedStands;
	private String leaderName;
	private String rank;
	private int ability;
	private String fallenLeaderResult;
	private String fallenReplacement;
	private boolean replacement;
	private String startingFormation;
	
	
	
	public Units(boolean union, String corps, String division, String brigade, String regiment, String player, int exp, int fresh, int warn, int spent, boolean braveColonel, int type, String startingFormation, String leaderName, String rank, int ability) {
		this.union = union;
		this.corps = corps;
		this.division = division;
		this.brigade = brigade;
		this.regiment = regiment;
		this.player = player;
		this.exp = exp;
		this.fresh = fresh;
		this.warn = warn;
		this.spent = spent;
		this.braveColonel = braveColonel;
		this.type = type;
		this.formation = startingFormation;
		this.startingFormation = startingFormation;
		this.leaderName = leaderName;
		this.rank = rank;
		this.ability = ability;
		
				
		this.morale = 3;
		this.silenced = false;
		this.firedStands = 0;
		this.fallenLeaderResult = "";
		this.fallenReplacement = "";
		this.replacement = false;
		this.curStands = fresh;
		
	}

	public Units(HashMap hm) {
		
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

	public String getSide() {
		if (isUnion()) {
			return "Union";
		} else {
			return "Confederate";
		}
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
	
	public String getExpDesc() {
		switch (this.exp) {
		case 2:
			return "Crack";
		case 1:
			return "Veteran";
		case 0:
			return "Trained";
		case -1:
			return "Green";
		default:
			return "Error bad exp " + exp;
		}
			
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getFresh() {
		return fresh;
	}

	public void setFresh(int fresh) {
		this.fresh = fresh;
	}

	public void setWarn(int warn) {
		this.warn = warn;
	}

	public void setSpent(int spent) {
		this.spent = spent;
	}

	public int getCurStands() {
		return curStands;
	}

	public void setCurStands(int curStands) {
		this.curStands = curStands;
	}
	
	public int getFWSMod() {
		if (this.curStands > this.warn) {
			return 2;
		} else {
			if (this.curStands > this.spent) {
				return 0;
			} else {
				return -2;
			}
		}
	}
	
	public boolean isBattery() {
		int type = this.getType();
		if (type == 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBraveColonel() {
		return braveColonel;
	}

	public void setBraveColonel(boolean braveColonel) {
		this.braveColonel = braveColonel;
	}

	public boolean isBroken() {
		if (this.morale == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isUnion() {
		return union;
	}

	public void setUnion(boolean union) {
		this.union = union;
	}

	public boolean isFixedGuns() {
		return fixedGuns;
	}

	public void setFixedGuns(boolean fixedGuns) {
		this.fixedGuns = fixedGuns;
	}

	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}
	
	public String getMoraleDesc() {
		switch (this.morale) {
		case 1:
			return "Broken";
		case 2:
			return "Disordered";
		case 3:
			return "Good";
		default:
			return "Invalid Morale";
		}
	}

	public boolean isSilenced() {
		return silenced;
	}

	public void setSilenced(boolean silenced) {
		this.silenced = silenced;
	}

	public int getType() {
		return type;
	}

	public void setMovementResult(String movementResult) {
		this.movementResult = movementResult;
	}

	public String getMovementResult() {
		return movementResult;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeDesc() {
		switch (this.type) {
		case 1:
			return "Leader";
		case 2:
			return "Infantry";
		case 3:
			return "Artillery";
		case 4:
			return "Cavalry";
		default:
			return "Invalid Type";
		}
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
		
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public String getRank() {
		return rank;
	}

	public int getAbility() {
		return ability;
	}
	
	public String getAbilityDesc() {
		switch (ability) {
		case 1:
			return "Gallant";
		case 0:
			return "Able";
		case -1:
			return "Poor";
		default:
			return "Invalid ability";
		}
	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public String getFallenLeaderResult() {
		return fallenLeaderResult;
	}

	public void setFallenLeaderResult(String fallenLeaderResult) {
		this.fallenLeaderResult = fallenLeaderResult;
	}

	public String getFallenReplacement() {
		return fallenReplacement;
	}

	public void setFallenReplacement(String fallenReplacement) {
		this.fallenReplacement = fallenReplacement;
	}

	public boolean isReplacement() {
		return replacement;
	}

	public void setReplacement(boolean replacement) {
		this.replacement = replacement;
	}

	public int getFiredStands() {
		return firedStands;
	}

	public void setFiredStands(int firedStands) {
		this.firedStands = firedStands;
	};
	
	public void accumFiredStands(int firedStands) {
		this.firedStands += firedStands;
		if (this.firedStands > curStands) {
			this.firedStands = curStands;
		}
	}

}
