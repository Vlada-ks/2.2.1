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

      User user1 = new User("Sergey", "Ivanov", "sergey@mail.ru");
      Car car1 = new Car("BMW", 6);
      User user2 = new User("Yura", "Lastnameov", "Yura@mail.ru");
      Car car2 = new Car("AUDI", 7);
      User user3 = new User("Igor", "Igorev", "Igor@mail.ru");
      Car car3 = new Car("Toyota", 5);
      User user4 = new User("Anruy", "Petrov", "Andruy@mail.ru");
      Car car4 = new Car("Citroen", 4);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }


      System.out.println(userService.getUserByCar("BMW", 6));

      context.close();
   }
}
