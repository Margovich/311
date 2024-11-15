package _1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Table(name = "users") // название таблицы в базе данных
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Nickname cannot be empty")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё0-9_-]{3,20}$", message = "Nickname can only contain letters, numbers, underscores and dashes and from 3 to 20 characters")
    @Column(name = "nickname")
    private String nickname;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Min(value = 1, message = "Age must be greater than 0")
    @Column(name = "age")
    private int age;

    public User() {}

    public User(String nickname, String email, int age) {

        this.nickname = nickname;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email; //
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " " + age + " " + email + " " + nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, email, age);
    }
}