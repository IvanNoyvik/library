package by.gomel.novik.library.model;

import by.gomel.novik.library.model.entity.Entity;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode
@ToString
public class User extends Entity {

    private String login;
    private String password;
    private String name;

    private UserStatus status;
    private Role role;


    public User() {
    }

    public User(String login, String password, String name, UserStatus status, Role role) {
        super();
        this.login = login;
        this.password = password;
        this.name = name;
        this.status = status;
        this.role = role;
    }

    public User(long id, String login, String password, String name, UserStatus status, Role role) {
        super(id);
        this.login = login;
        this.password = password;
        this.name = name;
        this.status = status;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
