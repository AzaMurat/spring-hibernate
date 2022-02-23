package hiber.dao;

import hiber.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<?> getByModel(String model) {
      try {
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         List<User> users = session.createQuery("from User ").getResultList();
         users.stream().filter(user -> user.getCar().getModel().equals(model)).forEach(System.out::println);
         session.getTransaction().commit();
         session.close();
         return users;
      } catch (HibernateException e) {
         System.out.println(e.getMessage());
      }
      return null;
   }

   @Override
   public List<?> getBySeries(int series) {
      try {
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         List<User> users = session.createQuery("from User ").getResultList();
         users.stream().filter(user -> user.getCar().getSeries()==series).forEach(System.out::println);
         session.getTransaction().commit();
         session.close();

         return users;
      }catch (HibernateException e){
         System.out.println(e.getMessage());
      }
      return null;
   }

}
