package fnf;

public class Test8 {

// This class is to test Units, Leaders, Infantry, Artillery classes
	public static void main(String[] args) {
		System.out.println("starting");
		boolean union = false;
		String corps = "1st";
		String division = "2nd";
		String brigade = "3rd";
		String regiment = "5th Texas";
		String player = "abc";
		int exp = 4;
		int fresh = 12;
		int warn = 9;
		int spent = 7;
		boolean braveColonel = false;
		int type = 2;
		String startingFormation = "Line";
		String leaderName = null;
		String rank = null;
		int ability = 0;
		
		Units unit = new Units(union, corps, division, brigade, regiment, player, exp, fresh, warn, spent, braveColonel, type, startingFormation, leaderName, rank, ability);
		System.out.println(unit.getSide());
		Combat combat = new Combat();
		combat.fallenLeaderTable(unit);
		System.out.println(unit.isReplacement());
		System.out.println(unit.getFallenReplacement());
		System.out.println(unit.getFallenLeaderResult());
		System.out.println();
		System.out.println(unit.getSide());
		System.out.println(unit.getCorps());
		System.out.println(unit.getDivision());
		System.out.println(unit.getBrigade());
		
		
	}

}
