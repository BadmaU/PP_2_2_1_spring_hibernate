package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void add(Car userCar);
    List<User> listUsers();
    List<User> listUsersWithCars(Car userCar);
}
