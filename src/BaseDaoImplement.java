

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class BaseDaoImplement implements BaseDao {

 @Override
 public boolean login(String username, String password) {
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    User user = (User) session.get(User.class, username);
    if (password.equals(user.getPassword())) {
     System.out.println("User: " + user.toString());
     return true;
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
    return false;
   }

  } else {
   System.out.println("DB server down.....");
  }
  session.close();
  return false;
 }
 
 @Override
 public boolean exists(User user) {
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
	  User myUser = (User) session.get(User.class, user.getUsername());
	  if(myUser == null) {
	  	return false;
	  }
	  else {

		session.close();
	   	return true;
	  }

	} catch (Exception exception) {
	    System.out.println("Exception occred while reading user data: "
	    	      + exception.getMessage());
	    	    return false;
	}
   } else {
     System.out.println("DB server down.....");
   }
  return false;
 }

 @Override
 public String register(User user) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
	  
	  
   
   try {
    if (user != null) {
     String username = (String) session.save(user);
     session.beginTransaction().commit();
     msg = "User " + username
       + " created successfully, please login...";
    }
   } catch (Exception exception) {
    System.out.println("Exception occured while reading user data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  session.close();
  return msg;
 }
 @Override
 public User getUser(String username) {
	  Session session = HibernateUtil.getSession();
	  if (session != null) {
	   try {
		  User myUser = (User) session.get(User.class, username);
		  session.close();
		  if(myUser == null) {
		  	return null;
		  }
		  else {
		   	return myUser;
		  }
		  
		} catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		    	      + exception.getMessage());
		    session.close();
		    	    return null;
		}
	    
	   } else {
	     System.out.println("DB server down.....");
	   }
	  
	  return null;
 }
 
 @Override
 public Location getLocation(String cityname) {
	  Session session = HibernateUtil.getSession();
	  if (session != null) {
	   try {
		  Location myLocation = (Location) session.get(Location.class, cityname);
		  session.close();
		  if(myLocation == null) {
		  	return null;
		  }
		  else {
		   	return myLocation;
		  }
		  
		} catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		    	      + exception.getMessage());
		    session.close();
		    	    return null;
		}
	    
	   } else {
	     System.out.println("DB server down.....");
	   }
	  
	  return null;
 }
 
 
 
 public String registerLocation(Location location) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
	  
   try {
    if (location != null) {
    	if(!existsLocation(location)) {
			 String myLocation = (String) session.save(location);
			 //session.merge(location);
			 session.beginTransaction().commit();
			 msg = "Location " //+ myLocation
			   + " created successfully, please login...";
    	}else {
    		msg = "Location (old and new)" //+ myLocation
    				   + " created successfully, please login...";
    		Location mylocation = (Location) session.get(Location.class, location.getCityname());
    		
    		Set<User> users = mylocation.getUser();
    		Set<User> temp =location.getUser();
    		temp.addAll(users);
    		location.setUser(temp);
    		session.merge(location);
    		session.beginTransaction().commit();
    	}
    }
      session.close();
   } catch (Exception exception) {
    System.out.println("Exception occured while reading location data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }


 public String removeLocation(Location location,User myuser) {
  String msg=null;
  Session session = HibernateUtil.getSession();
  if (session != null) {
	  
   try {
    if (location != null) {
    	if(existsLocation(location)) {
    		Location mylocation = (Location) session.get(Location.class, location.getCityname());
    		
    		Set<User> users = mylocation.getUser();
    		System.out.println(users);
    		System.out.println(myuser);
    		Set<User> temp = new HashSet<User>();
    		Iterator<User> it = users.iterator();
    		int flag=0;
    		while(it.hasNext()) {
    			User tempuser = it.next();
    			if(tempuser.getUsername().equals(myuser.getUsername()) ){
    				flag=1;
    			} else {
    				temp.add(tempuser);
    			}
    		}
    		if(flag==0) {
    			msg="Wrong Cityname to remove";
    		}
			location.setUser(temp);
			session.merge(location);
			session.beginTransaction().commit();
    		
    	}else {
    	}
    }
      session.close();
   } catch (Exception exception) {
    System.out.println("Exception occured while reading location data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  return msg;
 }
 
 @Override
 public boolean existsLocation(Location location) {
	  Session session = HibernateUtil.getSession();
	  if (session != null) {
	   try {
		  Location mylocation = (Location) session.get(Location.class, location.getCityname());
		  session.close();
		  if(mylocation == null) {
		  	return false;
		  }
		  else {
		   	return true;
		  }
		    
		} catch (Exception exception) {
		    System.out.println("Exception occred while reading user data: "
		    	      + exception.getMessage());
		    	    return false;
		}
	   } else {
	     System.out.println("DB server down.....");
	   }
	  return false;
	 }
	public Set<Location> getLocations(String username){
		Session session = HibernateUtil.getSession();
		User myUser = (User) session.get(User.class, username);
		Set<Location> temp = new HashSet<Location>();
	    temp.addAll(myUser.getLocation());
		System.out.println(temp);
		session.close();
		return temp;
	}
}