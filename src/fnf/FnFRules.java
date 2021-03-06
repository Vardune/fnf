package fnf;

import java.util.LinkedList;

import oldCode.Leaders;

public class FnFRules {

	public void movementRallyModifier(Units unit, Game game, LinkedList leaderList, boolean formationOrCover, boolean enfiladedOrBroken) {
		int totalLeaderMod = 0;
		
//		int attachedLeaderMod = attachLeaderValue(leader, unit);
//		totalLeaderMod += attachedLeaderMod;
	}
	
	public int attachLeaderValue(Units leader, Units unit) {
		String type = unit.getTypeDesc();
		if(type == "Leader") {
			System.out.println("Can not attach leader to a leader.");
			return -100;
		}
		int able = 0;
		switch (leader.getAbilityDesc()) {
		case "Gallant":
			able = 1;
			break;
		case "Able":
			able = 0;
			break;
		case "Poor":
			able = -1;
			break;
		default:
			able = -100;
			break;
		}
		
		int provisional = 0;
		if (leader.getCorps() == unit.getCorps()) {
			if (leader.getDivision() == unit.getDivision()) {
				if (leader.getBrigade() == unit.getBrigade()) {
					// good to go
					provisional = 0;
				} else {
					provisional = -1;
				}
			} else {
				provisional = -1;
			}
		} else {
			provisional = -1;
		}
		
		int braveColonel = 0;
		if (unit.isBraveColonel()) {
			braveColonel = 1;
		}
		
		int freshWarnSpent = freshWarnSpentModifier(unit);
		
		int battery = 0;
		if (unit.isBattery()) { 
			battery = 2;
		}
		
		
		return 1;
	}

	private int freshWarnSpentModifier(Units unit) {
		if (unit.getCurStands() > unit.getWarn()) {
			return 2;
		}
		if (unit.getCurStands() > unit.getSpent()) {
			return 0;
		} else {
			return -2;
		}
	}
	
	private String weaponRange(Units unit) {
		String weaponType = unit.getWeaponType();
		return "hi";
	}
}
