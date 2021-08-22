package com.zlody69.zlodyWebProj.DAO;

import com.zlody69.zlodyWebProj.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> allRole();

    Role findRoleByName(String name);
}
