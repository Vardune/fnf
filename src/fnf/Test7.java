package fnf;

public class Test7 {
// This class is to test Units, Leaders, Infantry, Artillery classes
	public static void main(String[] args) {
		System.out.println("starting");
//		Leaders leader = new Leaders("Confederate");
		Leaders leader = new Leaders("Confederate", "1st", "2nd", "", "", "1", "Landry OMack", "Brigadier General", "Able");
		System.out.println(leader.getSide());
		Combat combat = new Combat();
		combat.fallenLeaderTable(leader);
		System.out.println(leader.isReplacement());
		System.out.println(leader.getFallenReplacement());
		System.out.println(leader.getFallenLeaderResult());
		System.out.println();
		System.out.println(leader.getSide());
		System.out.println(leader.getCorps());
		System.out.println(leader.getDivision());
		System.out.println(leader.getBrigade());
		
		
	}

}
