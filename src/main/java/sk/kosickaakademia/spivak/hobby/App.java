package sk.kosickaakademia.spivak.hobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.kosickaakademia.spivak.hobby.database.Database;
import sk.kosickaakademia.spivak.hobby.entity.User;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
        Database database = new Database();
        User user = new User("Vladimir", "politics");
        database.insertNewUser(user);
    }
}
