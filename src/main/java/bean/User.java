package bean;

/**
 * @author : author
 * @date : 22:29 2021/6/28
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String telphone;
    private String email;

    public User() {
    }

    public User(int id, String username, String password, String telphone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telphone = telphone;
        this.email = email;
    }

    public User(String username, String email) {
        this.username=username;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
