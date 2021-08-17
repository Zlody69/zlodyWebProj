package com.zlody69.zlodyWebProj.services;

import com.zlody69.zlodyWebProj.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user, Long userId);

    List<User> allUser();

    User findUser(Long userId);

    void deleteUser(Long userId);
}
