
import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;


public class Location implements Serializable{
	private static final long serialVersionUID = 1L;
	private String location;
	
	private Set<User> users = new HashSet<User>();
	
	
	public String getCityname() {
        return location;
    }
    public void setCityname(String location) {
        this.location = location;
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public Set<User> getUser() {
    	return users;
    }
    public void setUser(Set<User> users) {
    	this.users= users;
    }
    public String toString() {
		return location;
    }
}
