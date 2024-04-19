package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("BMV1");
      Car car2 = new Car("BMV2");
      Car car3 = new Car("BMV3");
      Car car4 = new Car("BMV4");
      userService.add(car1);
      userService.add(car2);
      userService.add(car3);
      userService.add(car4);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru").setCar(car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru").setCar(car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru").setCar(car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru").setCar(car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      context.close();
   }
}
