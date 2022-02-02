package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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
   public void add(Car userCar) {
      sessionFactory.getCurrentSession().save(userCar);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User listUserWithCars(Car userCar) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User where userCar.model =: model and userCar.series =: series", User.class);
              query.setParameter("model", userCar.getModel());
              query.setParameter("series", userCar.getSeries());

      return query.getSingleResult();
   }

}
