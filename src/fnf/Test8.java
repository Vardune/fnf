package fnf;

public class Test8 {

// This class is to test Units, Leaders, Infantry, Artillery classes
	public static void main(String[] args) {
		System.out.println("starting test 8");
		boolean union = false;
		String corps = "1st";
		String division = "2nd";
		String brigade = "3rd";
		String regiment = "5th Texas";
		String player = "abc";
		int exp = 1;
		int fresh = 12;
		int warn = 9;
		int spent = 7;
		boolean braveColonel = false;
		int type = 2;
		String startingFormation = "Line";
		String leaderName = null;
		String rank = null;
		int ability = 0;
		
		String scenario = "Gettysburg Battle";
		String startingSide = "Confederate";
		int confederateHeavyCasualties = 33;
		int unionHeavyCasualties = 34;
		int gameLength = 18;
		int startingTime = 1600;
		
				
				
		Game game = new Game(scenario, startingSide, confederateHeavyCasualties, unionHeavyCasualties, gameLength, startingTime);
		
		Units unit = new Units(union, corps, division, brigade, regiment, player, exp, fresh, warn, spent, braveColonel, type, startingFormation, leaderName, rank, ability);
		System.out.println("Side " + unit.getSide());
		System.out.println("Exp " + unit.getExp());
		unit.setCurStands(3);
		Combat combat = new Combat();
		game.setConfederateLosses(34);
		combat.maneuver(unit, "Line", null, true, true, game);
		
		System.out.println(unit.getMovementResult());
		System.out.println("Morale # " + unit.getMorale());
		System.out.println("Morale Desc " + unit.getMoraleDesc());
		System.out.println("Formation " + unit.getFormation());
		
		
	}

}
