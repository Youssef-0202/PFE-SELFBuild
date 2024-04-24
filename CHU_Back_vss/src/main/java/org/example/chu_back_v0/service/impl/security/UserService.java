package org.example.chu_back_v0.service.impl.security;


import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.bean.security.Role;
import org.example.chu_back_v0.bean.security.User;
import org.example.chu_back_v0.dao.security.RoleDao;
import org.example.chu_back_v0.dao.security.UserDao;
import org.example.chu_back_v0.service.facade.commun.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    // aws
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MedecinService medecinService;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role medecinRole = new Role();
        medecinRole.setRoleName("medecin");
        medecinRole.setRoleDescription("medecin role");
        roleDao.save(medecinRole);

        Role infermierRole = new Role();
        infermierRole.setRoleName("infermier");
        infermierRole.setRoleDescription("infermier role");
        roleDao.save(infermierRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);


        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        Medecin medecin = new Medecin();
        /*medecin.setUserName("medecin");
        medecin.setUserPassword(getEncodedPassword("medecin"));
        medecin.setPrenom("medcin");
        medecin.setNom("medcin");
        Role role =  medecinRole;
        medecin.setRole(role);
        medecinService.registerNewUser(medecin);*/

        User medecinUser = new User();
        medecinUser.setUserName("medecin");
        medecinUser.setUserPassword(getEncodedPassword("medecin"));
        medecinUser.setUserFirstName("medecin");
        medecinUser.setUserLastName("medecin");
        Set<Role> medecinRoles = new HashSet<>();
        medecinRoles.add(medecinRole);
        medecinUser.setRole(medecinRoles);
        userDao.save(medecinUser);

        User infermierUser = new User();
        infermierUser.setUserName("infermier");
        infermierUser.setUserPassword(getEncodedPassword("infermier"));
        infermierUser.setUserFirstName("infermier");
        infermierUser.setUserLastName("infermier");
        Set<Role> infermierRoles = new HashSet<>();
        infermierRoles.add(infermierRole);
        infermierUser.setRole(infermierRoles);
        userDao.save(infermierUser);

        User user = new User();
        user.setUserName("ana");
        user.setUserPassword(getEncodedPassword("ana@pass"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);


    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
