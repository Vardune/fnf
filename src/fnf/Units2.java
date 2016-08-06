package fnf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Units2 {
    private String corps;
    private String division;

    public Units2() {};

    public Units2(HashMap hm) {
    	
        // Get a set of the entries
        Set set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
           Map.Entry me = (Map.Entry)i.next();
           int month = 8;
           String monthString;
           String key = (String) me.getKey();
           switch (key) {
               case "Corps" :
            	   		putCorps((String) me.getValue());
                        break;
               case "Division" :
       	   				putDivision((String) me.getValue());
       	   				break;

               default: 
            	   		// garbage data in the database - I will just ignore it
                        break;
           }
        }
        System.out.println();
        System.out.println("Da Corps: " + getCorps());
        System.out.println("Da Division: " + getDivision());
    };

    private void putDivision(String division) {
    	this.division = division;
		
	}

	private void putCorps(String corps) {
		this.corps = corps;
	}
    
    

	public String getCorps() {
        return corps;
    }

    public String getDivision() {
        return division;
    }

    @Override
    public String toString() { 
    	return "Units2{corps='"+corps+"', division="+division+"’}";
    };
}
