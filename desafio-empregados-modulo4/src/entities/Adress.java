package entities;

public class Adress {

    private String email;
    private String phone;

    public Adress() {
    }

    public Adress(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Para dúvidas, favor entrar em contato pelo email: "
            + email
            + " ou telefone: "
            + phone
            + ".";
    }
}
