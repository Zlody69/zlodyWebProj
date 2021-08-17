package com.zlody69.zlodyWebProj.DAO;

import com.zlody69.zlodyWebProj.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    User findUser(Long userId);

    void deleteUser(Long userId);

    List<User> allUser();

    void updateUser(User user, Long userId);
}
