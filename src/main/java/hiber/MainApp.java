package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.SortedMap;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User us = new User("Igor", "Brizgunov", "Brizgunov342@mail.ru");
        User user1 = new User("Pavel", "Sidorov", "Pavel2@mail.ru");
        User user2 = new User("Egor", "Egorov", "Br@mail.ru");
        User user3 = new User("Andre", "Andreev", "Andreev34@mail.ru");
        Car car = new Car("BMW", 5);
        Car car3 = new Car("Lada", 99);
        us.setCar(car3);
        user1.setCar(car);
        user2.setCar(car3);
        user3.setCar(car);
        userService.add(us);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println(userService.getUser("BMW", 5));

        context.close();
    }
}
