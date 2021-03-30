package sk.kosickaakademia.spivak.hobby.entity;

public class User {
    private String login;
    private String hobby;


    public User(String login, String hobby) {
        this.login = login;
        this.hobby = hobby;
    }


    public String getLogin() {
        return login;
    }

    public String getHobby() {
        return hobby;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
