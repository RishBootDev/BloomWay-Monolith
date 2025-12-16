package com.rishbootdev.bloomway.repository;

import com.rishbootdev.bloomway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByNameIs(String userName);
}
