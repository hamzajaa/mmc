package com.thefivebytes.mmc;

import com.thefivebytes.mmc.security.bean.Role;
import com.thefivebytes.mmc.security.bean.User;
import com.thefivebytes.mmc.security.dao.RoleDao;
import com.thefivebytes.mmc.security.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class MmcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MmcApplication.class, args);
    }

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("hamza");
        user.setLastName("jaa");
        user.setUserName("hamzajaa_10");
        user.setEmail("hamzajaa@gmail.com");
        user.setNumTel("0664230265");
        user.setPassword(passwordEncoder.encode("123"));

        if (userDao.findByEmail(user.getEmail()).isEmpty()) {

            Role role = new Role("ADMIN");
            user.setRoles(Collections.singleton(role));

            User save = userDao.save(user);

            System.out.println("**************");

        }
    }
}
