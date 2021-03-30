package sk.kosickaakademia.spivak.hobby.entity;

public class User {
    private int id;
    private String login;
    private String hobby;


    public User(int id, String login, String hobby) {
        this(login, hobby);
        this.id = id;
    }

    public User(String login, String hobby) {
        this.login = login;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getHobby() {
        return hobby;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
