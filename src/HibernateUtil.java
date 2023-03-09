
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private static Configuration configuration;
 private static SessionFactory sessionFactory;

 static {
  configuration = new Configuration()
    .configure("hibernate.config.xml");
  sessionFactory = configuration.buildSessionFactory();
	 //Configuration configuration = new Configuration().configure("hibernate.config.xml");
  
 }
 public static Session getSession() {

	 //Configuration configuration = new Configuration().configure("hibernate.config.xml");

 //StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
 //applySettings(configuration.getProperties());
 //SessionFactory factory = configuration.buildSessionFactory(builder.build());
  Session session = null;
  if (sessionFactory != null) {
   session = sessionFactory.openSession();
  }
  return session;
 }
}