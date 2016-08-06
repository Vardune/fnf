package fnf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Units {
    private String key;
    private String side;
    private String corps;
    private String division;
    private String brigade;
    private String regiment;
    private String unitType;
    private String player;
    private String exp;
    private String formation;
    private boolean sharpshooter;
    private long maxStands;
    private long curStands;
    private long firedStands;
    private long lostedStands;
    private boolean moved;
    private long fresh;
    private long warn;
    private long spent;

    public Units() {};

    public Units(String side, String corps, String division, String brigade, String regiment, String unitType, String player, String exp, String formation, boolean sharpshooter, long maxStands, long curStands, long firedStands, long lostedStands, boolean moved, long fresh, long warn, long spent) {
        this.side = side;
        this.corps = corps;
        this.division = division;
        this.brigade = brigade;
        this.regiment = regiment;
        this.unitType = unitType;
        this.player = player;
        this.exp = exp;
        this.formation = formation;
        this.sharpshooter = sharpshooter;
        this.maxStands = maxStands;
        this.curStands = curStands;
        this.firedStands = firedStands;
        this.lostedStands = lostedStands;
        this.moved = moved;
        this.fresh = fresh;
        this.warn = warn;
        this.spent = spent;
    }

    public Units(HashMap hm) {
    	
        // Get a set of the entries
        Set<String> set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
           Map.Entry me = (Map.Entry)i.next();
           String key = (String) me.getKey();
           switch (key) {
	           case "Side" :
	        	   setSide((String) me.getValue());
	        	   break;
	           case "Corps" :
	        	   setCorps((String) me.getValue());
	        	   break;
               case "Division" :
            	   setDivision((String) me.getValue());
            	   break;
               case "Brigade" :
            	   setBrigade((String) me.getValue());
            	   break;
               case "Regiment" :
            	   setRegiment((String) me.getValue());
            	   break;
               case "UnitType" :
            	   setUnitType((String) me.getValue());
            	   break;
               case "Player" :
            	   setPlayer((String) me.getValue());
            	   break;
               case "Exp" :
            	   setExp((String) me.getValue());
            	   break;
               case "Formation" :
            	   setFormationt((String) me.getValue());
            	   break;
               case "Sharpshooter" :
            	   setSharpshooter((boolean) me.getValue());
            	   break;
               case "MaxStands" :
            	   setMaxStands((long) me.getValue());
            	   break;
               case "CurStands" :
            	   setCurStands((long) me.getValue());
            	   break;
               case "FiredStands" :
            	   setFiredStands((long) me.getValue());
            	   break;
               case "LostedStandes" :
            	   setLostedStands((long) me.getValue());
            	   break;
               case "Moved" :
            	   setMoved((boolean) me.getValue());
            	   break;
               case "Fresh" :
            	   setFresh((long) me.getValue());
            	   break;
               case "Warn" :
            	   setWarn((long) me.getValue());
            	   break;
               case "Spent" :
            	   setSpent((long) me.getValue());
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

	public void setRegiment(String regiment) {
    	this.regiment = regiment;		
	}

	public void setFormationt(String formation) {
		this.formation = formation;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public void setSharpshooter(boolean sharpshooter) {
		this.sharpshooter = sharpshooter;
	}

	public void setMaxStands(long maxStands) {
		this.maxStands = maxStands;
	}

	public void setCurStands(long curStands) {
		this.curStands = curStands;
	}

	public void setFiredStands(long firedStands) {
		this.firedStands = firedStands;
	}

	public void setLostedStands(long lostedStands) {
		this.lostedStands = lostedStands;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	public void setFresh(long fresh) {
		this.fresh = fresh;
	}

	public void setWarn(long warn) {
		this.warn = warn;
	}

	public void setSpent(long spent) {
		this.spent = spent;
	}

	public String getKey() {
        return key;
    }

	public String getSide() {
        return side;
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

    public String getRegiment() {
        return regiment;
    }
        
    public String getUnitType() {
        return unitType;
    }
        
    public String getPlayer() {
        return player;
    }
        
    public String getExp() {
        return exp;
    }
        
    public String getFormation() {
        return formation;
    }
        
    public boolean getSharpshooter() {
        return sharpshooter;
    }
        
    public long getMaxStands() {
        return maxStands;
    }
        
    public long getCurStands() {
        return curStands;
    }
    
    public long getFiredStands() {
        return firedStands;
    }
        
    public long getLostedStands() {
        return lostedStands;
    }
        
    public boolean getMoved() {
        return moved;
    }
        
    public long getFresh() {
        return fresh;
    }
        
    public long getWarn() {
        return warn;
    }

    public long getSpent() {
        return spent;
    }
        
 }
