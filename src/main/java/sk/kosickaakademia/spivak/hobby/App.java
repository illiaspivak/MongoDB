package sk.kosickaakademia.spivak.hobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.kosickaakademia.spivak.hobby.database.Database;
import sk.kosickaakademia.spivak.hobby.entity.User;

import java.util.List;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
        Database database = new Database();

        database.deleteByLogin("Vladimir");
        System.out.println(database.getAllUsers());
    }


}
