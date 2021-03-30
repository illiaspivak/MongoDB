package sk.kosickaakademia.spivak.hobby.log;

public class Log {
    public void error(String message){
        System.out.println("[ERROR] : " + message);
    }
    public void print(String message){
        System.out.println("[OK] : " + message);
    }
    public void info(String message){
        System.out.println("[INFO] : " + message);
    }
}
