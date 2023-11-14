package com.thefivebytes.mmc.security.dao;



import com.thefivebytes.mmc.security.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String username);
    Optional<User> findByUserNameOrEmail(String username, String email);
    Optional<User> findByNumTel(String numtel);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    Boolean existsByNumTel(String numTel);

}
