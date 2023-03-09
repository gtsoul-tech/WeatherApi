
import java.util.HashSet;
import java.util.Set;

public interface BaseDao {
 public boolean login(String username, String password);
 public boolean exists(User user);
 public String register(User user);
 
 public User getUser(String username);
 public Location getLocation(String location);
 public Set<Location> getLocations(String username);
 public boolean existsLocation(Location location);
 public String registerLocation(Location location);
 public String removeLocation(Location location,User myuser);
 
}