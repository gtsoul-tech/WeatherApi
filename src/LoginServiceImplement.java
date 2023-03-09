

public class LoginServiceImplement implements LoginService {

 private BaseDao loginDao = new BaseDaoImplement();

 @Override
 public boolean login(String username, String password) {
  return loginDao.login(username, password);
 }

 @Override
 public String registration(User user) {
  return loginDao.register(user);
 }

}