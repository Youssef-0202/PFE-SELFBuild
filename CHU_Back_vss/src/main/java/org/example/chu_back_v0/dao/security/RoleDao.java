package org.example.chu_back_v0.dao.security;

import org.example.chu_back_v0.bean.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
