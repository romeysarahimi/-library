package entity;

public class Member extends BaseEntity <Integer> {

    private String username;
    private String tel;
    private String address;
    private String email;

    public Member() {

    }

    public Member(int id, String username, String tel, String address, String email) {
        super(id);
        this.username = username;
        this.tel = tel;
        this.address = address;
        this.email = email;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + getId() +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
