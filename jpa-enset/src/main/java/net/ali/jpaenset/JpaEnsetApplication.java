package net.ali.jpaenset;

import net.ali.jpaenset.entities.Role;
import net.ali.jpaenset.entities.User;
import net.ali.jpaenset.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEnsetApplication.class, args);
    }
@Bean

    CommandLineRunner start(UserService userService){
        return args -> {
            User u = new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addUser(u);

             User u2 = new User();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addUser(u2);

            Role role1=new Role();
            role1.setRoleName("STUDENT");
            userService.addRole(role1);

            Role role2=new Role();
            role2.setRoleName("USER");
            userService.addRole(role2);

            Role role3=new Role();
            role3.setRoleName("ADMIN");
            userService.addRole(role3);

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");


            try {
                User user = userService.authenticate("user1", "123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("ROLES=>");
                user.getRoles().forEach(r -> System.out.println("Role=>"+r.toString()));
            }
            catch (Exception exception){
                exception.printStackTrace();

            }



        };
    }
}


