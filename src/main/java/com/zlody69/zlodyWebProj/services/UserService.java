package com.zlody69.zlodyWebProj.services;

import com.zlody69.zlodyWebProj.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);

    void updateUser(User user, Long userId);

    List<User> allUser();

    User findUser(Long userId);

    void deleteUser(Long userId);

    User findUserByUsername(String name);
}
