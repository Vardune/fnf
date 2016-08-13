package fnf;

import java.util.Random;

public class Combat {

	public Combat() {
	};

	public int ToHit(long firingDice, boolean melee, boolean enfilade, String defType) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void fallenLeaderTable(Leaders leader) {
		Random randomGenerator = new Random();
		int roll = randomGenerator.nextInt(10);
		String fallenResult;
		switch (roll) {
		case 1:
			fallenResult = "Coolly ignores the fire";
			break;
		case 2:
			fallenResult = "Coolly ignores the fire";
			break;
		case 3:
			fallenResult = "Coolly ignores the fire";
			break;
		case 4:
			fallenResult = "Staff officer struck";
			break;
		case 5:
			fallenResult = "Coat pierced but unscathed";
			break;
		case 6:
			fallenResult = "Horse shot out from under";
			leader.setFallenReplacement("May not move to new unit");
			break;
		case 7:
			fallenResult = "Mere flesh wound";
			leader.setFallenReplacement("Out of command for one turn");
			break;
		case 8:
			fallenResult = "Grievously wounded";
			leader.setFallenReplacement("Replacement Commander");
			leader.setReplacement(true);
			break;
		case 9:
			fallenResult = "Mortally wounded";
			leader.setFallenReplacement("Replacement Commander");
			leader.setReplacement(true);
			break;
		case 0:
			fallenResult = "Shot dead in the saddle";
			leader.setFallenReplacement("Replacement Commander");
			leader.setReplacement(true);
			break;
		default:
			fallenResult = "Invalid roll";
			break;
		}

		leader.setFallenLeaderResult(fallenResult);

	}
}
