package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public Optional<User> findByEmailAndPassword(String email, String password);

    public Optional<User> findByEmail(String email);
}
