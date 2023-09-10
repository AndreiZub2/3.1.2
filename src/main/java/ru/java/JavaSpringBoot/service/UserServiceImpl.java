package ru.java.JavaSpringBoot.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ru.java.JavaSpringBoot.dao.UserDao;
import ru.java.JavaSpringBoot.model.User;


import java.util.List;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getUserList() {
       return userDao.getUserList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
       return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser( User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }


}
