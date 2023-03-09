import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    
    
    
    private Set<Location> locations = new HashSet<Location>();
    public void addLocation(Location location) {
    	this.locations.add(location);
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<Location> getLocation() {
    	return locations;
    }
    public void setLocation(Set<Location> locations) {
    	this.locations= locations;
    }
    public String toString() {
    	return username;
    }
    
}