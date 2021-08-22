package com.zlody69.zlodyWebProj.services;

import com.zlody69.zlodyWebProj.DAO.RoleDao;
import com.zlody69.zlodyWebProj.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public List<Role> allRoles(){
        return roleDao.allRole();
    }

    @Transactional
    @Override
    public Role findRoleByName(String name){
        return roleDao.findRoleByName(name);
    }
}
