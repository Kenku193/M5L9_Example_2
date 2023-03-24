package com.example.m5l9_example_2.repository;

import com.example.m5l9_example_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface Repo extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User u set u.login = ?1, u.password = ?2 where u.id = ?3")
    int updateLoginAndPasswordById(String login, String password, Long id);
    Optional<User> findByLoginAndPassword(String login, String password);
}
