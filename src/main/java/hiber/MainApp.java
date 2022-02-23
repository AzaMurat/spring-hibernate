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


//      userService.add(new User("Rahim", "Kurbanov", "Rahim@mail.ru",
//              new Car("BMW",8630)));
//      userService.add(new User("Azamat", "Muratov", "Azamat@mail.ru",
//              new Car("AUDI",8631)));
//      userService.add(new User("Ermek", "Koboshov", "erma@mail.ru",
//              new Car("PEJO",8632)));
//      userService.add(new User("Aktan", "Mazhitov", "AktanAkylai@mail.ru",
//              new Car("RENAULT",8633)));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar());
//         System.out.println();
//      }
//      userService.getByModel("AUDI");
      userService.getBySeries(8631);
      context.close();
   }
}
