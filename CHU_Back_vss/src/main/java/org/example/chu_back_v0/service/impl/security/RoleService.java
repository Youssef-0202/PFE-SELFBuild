package org.example.chu_back_v0.service.impl.security;


import org.example.chu_back_v0.bean.security.Role;
import org.example.chu_back_v0.dao.security.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
