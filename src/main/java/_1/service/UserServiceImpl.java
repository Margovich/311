package _1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import _1.dao.UserDao;
import _1.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}