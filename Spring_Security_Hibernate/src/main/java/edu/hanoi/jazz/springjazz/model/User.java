package edu.hanoi.jazz.springjazz.model;


public class User {
    private String username;
    private String password;
    private String email;
    private Integer age;
    private Group group;

    public User() {
    }

    public User(String username, String password, String email, Integer age, Group group) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.group = group;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
