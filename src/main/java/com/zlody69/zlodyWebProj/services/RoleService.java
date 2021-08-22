package com.zlody69.zlodyWebProj.services;

import com.zlody69.zlodyWebProj.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> allRoles();

    Role findRoleByName(String name);
}
