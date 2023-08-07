package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void add(Car car) {
        userDao.add(car);
    }

    @Override
    public List<User> getUser(String model, int series) {
        return userDao.getUser(model, series);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}
