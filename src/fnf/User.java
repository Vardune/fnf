package fnf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class User {
	private String key;
    private String phone;
    private String firstName;
    private String lastName;
    private String email;
    private String side;
    private String userType;

    public User() {}

    public User(String firstName, String lastName, String phone, String email, String side) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.side = side;
        this.userType = "Player";
    }

    public User(HashMap hm) {
    	
        // Get a set of the entries
        Set set = hm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
           Map.Entry me = (Map.Entry)i.next();
           String key = (String) me.getKey();
           switch (key) {
               case "FirstName" :
            	   setFirstName((String) me.getValue());
                        break;
               case "LastName" :
            	   setLastName((String) me.getValue());
       	   				break;
               case "Email" :
            	   setEmail((String) me.getValue());
       	   				break;
               case "Phone" :
            	   setPhone((String) me.getValue());
       	   				break;
               case "Side" :
            	   setSide((String) me.getValue());
       	   				break;
               case "Type" :
            	   setType((String) me.getValue());
       	   				break;

               default: 
            	   		// garbage data in the database - I will just ignore it
                        break;
           }
        }
    };

    public String getKey() {
        return key;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSide() {
        return side;
    }

    public String getType() {
        return userType;
    }

	public void setKey(String key) {
		this.key = key;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public void setType(String userType) {
		this.userType = userType;
	}
    @Override
    public String toString() { 
    	return "Users{First Name='"+firstName+"', Last Name="+lastName+"’}";
    };
}

