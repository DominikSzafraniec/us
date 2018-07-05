package model;

public class Login {
    private String role;
    private Long pesel;

    public Login(String role, Long pesel) {
        this.role = role;
        this.pesel = pesel;
    }

    public Login() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }
}
