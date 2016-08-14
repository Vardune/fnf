package fnf;

import java.util.Random;

public class Combat {

	public Combat() {
	};

	public int ToHit(long firingDice, boolean melee, boolean enfilade, String defType) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void fallenLeaderTable(Units unit) {
		String fallenResult;
		if (unit.getTypeDesc() != "Leader")  fallenResult = "Error: Must be a leader type.";
		Random randomGenerator = new Random();
		int roll = randomGenerator.nextInt(10);
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
			unit.setFallenReplacement("May not move to new unit");
			break;
		case 7:
			fallenResult = "Mere flesh wound";
			unit.setFallenReplacement("Out of command for one turn");
			break;
		case 8:
			fallenResult = "Grievously wounded";
			unit.setFallenReplacement("Replacement Commander");
			unit.setReplacement(true);
			break;
		case 9:
			fallenResult = "Mortally wounded";
			unit.setFallenReplacement("Replacement Commander");
			unit.setReplacement(true);
			break;
		case 0:
			fallenResult = "Shot dead in the saddle";
			unit.setFallenReplacement("Replacement Commander");
			unit.setReplacement(true);
			break;
		default:
			fallenResult = "Invalid roll";
			break;
		}

		unit.setFallenLeaderResult(fallenResult);

	}

	public void rally(Units unit, boolean inCommand, boolean formationCover, boolean outflanked, Game game) {
		// data passed in
		// unit - The unit attempting to move
		// inCommand - Is the leader in command range
		// formationOrCover - Is the unit in a good rally formation or has cover
		// Outflanked

		int dieMod = 0;

		// In command leader

		// Attached leader
		if (unit.isBraveColonel()) {
			dieMod += 1;
		} else {

		}

		// Unit exp modifier
		dieMod += unit.getExp();

		// Unit fresh/warn/spent modifier
		dieMod += unit.getFWSMod();

		// Unit is battery
		if (unit.isBattery())
			dieMod += 2;

		// mod for formations and cover
		if (formationCover)
			dieMod += 1;

		// mod for outflanked or broken
		if (outflanked || unit.isBroken())
			dieMod += -2;

		// heavy casualties and greater losses
		if (unit.isUnion()) {
			game.unionLossesMod();
		} else {
			game.confederateLossesMod();
		}

		Random randomGenerator = new Random();
		int roll = randomGenerator.nextInt(10);
		roll += dieMod;
		String movementResult = "";
		if (inCommand) {
			if (roll <= -2) {
				unit.setMorale(1); // Broken
				if (unit.isBattery()) {
					unit.setSilenced(true);
					if (unit.isFixedGuns()) {
						movementResult = "Panic.  Lose all fixed guns.";
						unit.setMovementResult(movementResult);
					} else {
						movementResult = "Panic.  Guns limber and full retreat silenced.";
						unit.setMovementResult(movementResult);
					}
				} else {
					movementResult = "Panic.  Troops retreat broken facing away from enemy.";
					unit.setMovementResult(movementResult);
				}
			} else if (roll <= 0) {
				unit.setMorale(2); // Disordered
				if (unit.isBattery()) {
					unit.setSilenced(true);
					movementResult = "Fall Back.  Guns limber and retreat out of close range and silenced.";
					unit.setMovementResult(movementResult);
				} else {
					movementResult = "Fall Back.  Troops retreat out of close range and are disordered facing towards the enemy.";
					unit.setMovementResult(movementResult);
				}
			} else if (roll == 3) {
				movementResult = "Tardy.  May make a half move.";
				unit.setMovementResult(movementResult);

			} else if (roll <= 7) {
				movementResult = "Well Handled.  May make a full move.";
				unit.setMovementResult(movementResult);
				switch (unit.getMorale()) {
				case 1: // Broken
					unit.setMorale(3); // Good morale
					unit.setFormation("Line");
					movementResult = "Retreat out of close fire range moving more than full rate if nessary.";
					unit.setMovementResult(movementResult);
				case 2: // Disorganized
					unit.setMorale(3);
					movementResult = "Well Handled.  May make a full move.";
					unit.setMovementResult(movementResult);
				case 3:
					movementResult = "Double quick.  May full move and a half move.";
					unit.setMovementResult(movementResult);
				}
			} else if (roll >= 8) {
				switch (unit.getMorale()) {
				case 1: // Broken
					unit.setMorale(3); // Good morale
					movementResult = "Tardy.  May make a half move.";
					unit.setMovementResult(movementResult);
				case 2: // Disorganized
					unit.setMorale(3);
					movementResult = "Well Handled.  May make a full move.";
					unit.setMovementResult(movementResult);
				case 3:
					movementResult = "Double quick.  May full move and a half move.";
					unit.setMovementResult(movementResult);
				}
			}

		}
	}
}
