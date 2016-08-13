package fnf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Leaders extends Units {
	private String key;
	private boolean moved;
	private String name;
	private String rank;
	private String ability;
	private String fallenLeaderResult;
	private String fallenReplacement;
	private boolean replacement;

	public Leaders(String side, String corps, String division, String brigade, String regiment, String player,
			String name, String rank, String ability) {
		super(side, corps, division, brigade, regiment, player);
		this.setMoved(moved);
		this.name = name;
		this.rank = rank;
		this.ability = ability;
	}

	public Leaders(HashMap hm) {
		super(hm);

		// Get a set of the entries
		Set<String> set = hm.entrySet();
		// Get an iterator
		Iterator i = set.iterator();
		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			String key = (String) me.getKey();
			switch (key) {
			case "Side":
				setSide((String) me.getValue());
				break;
			case "Corps":
				setCorps((String) me.getValue());
				break;
			case "Division":
				setDivision((String) me.getValue());
				break;
			case "Brigade":
				setBrigade((String) me.getValue());
				break;
			case "Regiment":
				setRegiment((String) me.getValue());
				break;
			case "Player":
				setPlayer((String) me.getValue());
				break;
			case "Moved":
				setMoved((boolean) me.getValue());
				break;
			case "Name":
				setName((String) me.getValue());
				break;
			case "Rank":
				setRank((String) me.getValue());
				break;
			case "Ability":
				setAbility((String) me.getValue());
				break;

			default:
				// garbage data in the database - I will just ignore it
				break;
			}
		}
	};

	public void leadersCurrant(HashMap hm) {

		// Get a set of the entries
		Set<String> set = hm.entrySet();
		// Get an iterator
		Iterator i = set.iterator();
		// Display elements
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			String key = (String) me.getKey();
			switch (key) {
			case "Side":
				setSide((String) me.getValue());
				break;
			case "Corps":
				setCorps((String) me.getValue());
				break;
			case "Division":
				setDivision((String) me.getValue());
				break;
			case "Brigade":
				setBrigade((String) me.getValue());
				break;
			case "Regiment":
				setRegiment((String) me.getValue());
				break;
			case "Player":
				setPlayer((String) me.getValue());
				break;
			case "Moved":
				setMoved((boolean) me.getValue());
				break;
			case "Name":
				setName((String) me.getValue());
				break;
			case "Rank":
				setRank((String) me.getValue());
				break;
			case "Ability":
				setAbility((String) me.getValue());
				break;

			default:
				// garbage data in the database - I will just ignore it
				break;
			}
		}
	};

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getRank() {
		return rank;
	}

	public String getAbility() {
		return ability;
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
	};

}
