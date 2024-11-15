package _1.dao;

import _1.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    List<User> getAllUsers();
}