package form;

import java.util.UUID;

public class RegistrationForm {
    private String name;
    private String email;
    private String pass;

    public RegistrationForm(String name, String email, String pass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public static RegistrationForm randomFrom(){
        return new RegistrationForm(UUID.randomUUID().toString(), UUID.randomUUID() + "@test.ru", "123123");
    }

    public static RegistrationForm incorrectPassFrom(){
        return new RegistrationForm(UUID.randomUUID().toString(), UUID.randomUUID() + "@test.ru", "123");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
