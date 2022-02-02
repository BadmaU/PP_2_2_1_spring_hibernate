package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void add(Car userCar);
   List<User> listUsers();
   User listUserWithCars(Car userCar);
}
