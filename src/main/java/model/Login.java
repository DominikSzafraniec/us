package model;

public class Login {
    private String role;
    private String login;
    private Long pesel;

    public Login() {
    }

    public Login(String role, String login, Long pesel) {
        this.role = role;
        this.login = login;
        this.pesel = pesel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }
}
