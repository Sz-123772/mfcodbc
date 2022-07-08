package mfcodbc.cls;

/**
 * Demo User class
 *
 * @author Accer
 * @date 2022/06/23
 */

public class User {
    @Override
    public String toString() {
        return "User{" +
                "username='" + id + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    private String id;
    private String password;
    private String remark;

    public User(String username, String password, String remark)
    {
        super();
        this.id = username;
        this.password = password;
        this.remark = remark;
    }

    public void setUsername(String username) {
        this.id = username;
    }

    public String getUsername() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }
}
