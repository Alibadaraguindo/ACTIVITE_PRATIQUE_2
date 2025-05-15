package net.ali.jpaenset.service;

import net.ali.jpaenset.entities.Role;
import net.ali.jpaenset.entities.User;

public interface UserService {
    User addUser(User user);
    Role addRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName , String roleName);
    User authenticate(String username, String password);

}
