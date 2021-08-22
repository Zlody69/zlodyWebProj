package com.zlody69.zlodyWebProj.services;

import com.zlody69.zlodyWebProj.DAO.UserDao;
import com.zlody69.zlodyWebProj.model.Role;
import com.zlody69.zlodyWebProj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user, Long userId){
        userDao.updateUser(user, userId);
    }

    @Transactional
    @Override
    public List<User> allUser(){
        return userDao.allUser();
    }

    @Transactional
    @Override
    public User findUser(Long userId){
        return userDao.findUser(userId);
    }

    @Transactional
    @Override
    public void deleteUser(Long userId){
        userDao.deleteUser(userId);
    }

    @Transactional
    @Override
    public User findUserByUsername(String name){
        return userDao.findUserByUsername(name);
    }


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User loadUser = userDao.findUserByUsername(s);
        if(loadUser==null){
            throw new UsernameNotFoundException(String.format("users '%s' not found",s));
        }
        return loadUser;
    }



}
