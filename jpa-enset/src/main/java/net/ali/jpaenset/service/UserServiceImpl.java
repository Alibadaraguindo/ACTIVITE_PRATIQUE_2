package net.ali.jpaenset.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.ali.jpaenset.entities.Role;
import net.ali.jpaenset.entities.User;
import net.ali.jpaenset.repositories.RoleRepository;
import net.ali.jpaenset.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role;
        role = findRoleByRoleName(roleName);
        if (user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);

        }
        //userRepository.save(user);


    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("BAD CREDENTIALS");
        if (user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("BAD CREDENTIALS");
    }
}